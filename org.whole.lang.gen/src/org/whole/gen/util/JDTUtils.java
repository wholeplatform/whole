/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.gen.util;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.JavaSystemSoftware;
import org.whole.lang.java.util.JDTTransformerVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.util.IRunnable;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class JDTUtils {
	public static enum JAVA_FRAGMENT {
		COMPILATION_UNIT(ASTParser.K_COMPILATION_UNIT, CompilationUnit.class),
		CLASS_BODY_DECLARATIONS(ASTParser.K_CLASS_BODY_DECLARATIONS, TypeDeclaration.class),
		STATEMENTS(ASTParser.K_STATEMENTS, Block.class),
		EXPRESSION(ASTParser.K_EXPRESSION, Expression.class);
		
		public final int kind;
		public final Class<?> type;
		JAVA_FRAGMENT(int kind, Class<?> type) {
			this.kind = kind;
			this.type = type;
		}
	}

	public static ASTNode parse(String source) {
		for (JAVA_FRAGMENT f : JAVA_FRAGMENT.values()) {
			try {
				return parseAs(source, f);
			} catch (IllegalArgumentException e) {}
		}
		throw new IllegalArgumentException();
	}

	public static CompilationUnit parseAsCompilationUnit(String source) {
		return (CompilationUnit) parseAs(source, JAVA_FRAGMENT.COMPILATION_UNIT);
	}
	public static ASTNode parseAs(String source, JAVA_FRAGMENT f) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(f.kind);
		parser.setSource(source.toCharArray());
		ASTNode astNode = parser.createAST(null);
		if (f.type.isInstance(astNode) && isValid(astNode))
			return astNode;
		else
			throw new IllegalArgumentException();
	}

	private static boolean isValid(ASTNode astNode) {
		return !(astNode instanceof CompilationUnit && ((CompilationUnit) astNode).types().isEmpty()) &&
			!(astNode instanceof Block && ((Block) astNode).statements().isEmpty());
	}

	public static IEntityIterator<IEntity> generateJavaSystemSoftware() {
		return IteratorFactory.singleValuedRunnableIterator(new IRunnable() {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... arguments) {
				final List<CompilationUnit> cuList = JavaCompilerOperation.compile(selfEntity, bm);
				final JavaSystemSoftware javaSystemSoftware = JavaEntityFactory.instance.createJavaSystemSoftware(0);
				for (CompilationUnit cu : cuList)
					javaSystemSoftware.add((org.whole.lang.java.model.CompilationUnit) JDTTransformerVisitor.transform(cu));

				bm.setResult(javaSystemSoftware);
			}
		});
	}
	
	public static IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}
	public static IPackageFragmentRoot getPackageFragmentRoot(String locationPath) {
		return getPackageFragmentRoot(new Path(locationPath));
	}
	public static IPackageFragmentRoot getPackageFragmentRoot(IPath location) {
		IContainer container = getWorkspaceRoot().getContainerForLocation(location);
		if (container == null)
			throw new IllegalArgumentException();

		return getPackageFragmentRoot(container);
	}
	public static IPackageFragmentRoot getPackageFragmentRoot(IContainer container) {
		IProject proj = container.getProject();

		try {
			if (!proj.hasNature(JavaCore.NATURE_ID))
				throw new IllegalArgumentException();

			IJavaProject jProject = JavaCore.create(proj);
			if (jProject == null || !jProject.exists())
				throw new IllegalArgumentException();

			return jProject.getPackageFragmentRoot(container);
		} catch (CoreException e) {
			throw new IllegalArgumentException();
		}
	}
	public static String findSourceAttachment(ISourceReference sourceReference) {
		try {
			return sourceReference.getSource();
		} catch (JavaModelException e) {
			return null;
		}
	}
	public static ISourceReference findSourceReference(String className, IJavaProject javaProject) {
		try {
			ISourceReference sourceReference = (ISourceReference) javaProject.findType(className);
			return sourceReference;
		} catch (JavaModelException e) {
			return null;
		}
	}
}
