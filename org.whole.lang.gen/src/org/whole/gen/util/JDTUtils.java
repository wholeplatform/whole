/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceReference;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.factories.JavaEntityFactory;
import org.whole.lang.java.model.JavaSystemSoftware;
import org.whole.lang.java.util.JDTTransformerVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.reflect.ReflectionFactory;
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
		ASTParser parser = ASTParser.newParser(AST.JLS8);
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

	public static String asString(ASTNode astNode) {
		return astNode.toString();
	}
	public static Document asDocument(ASTNode astNode) {
		return new Document(asString(astNode));
	}
	public static String asFormattedString(ASTNode astNode) {
		return asFormattedDocument(astNode, CodeFormatter.K_UNKNOWN).get();
	}
	public static String asFormattedString(CompilationUnit cu) {
		return asFormattedDocument(cu).get();
	}
	public static Document asFormattedDocument(CompilationUnit cu) {
		return asFormattedDocument(cu, CodeFormatter.K_COMPILATION_UNIT);
	}
	public static Document asFormattedDocument(Statement stm) {
		return asFormattedDocument(stm, CodeFormatter.K_STATEMENTS);
	}
	public static Document asFormattedDocument(Expression exp) {
		return asFormattedDocument(exp, CodeFormatter.K_EXPRESSION);
	}
	@SuppressWarnings("unchecked")
	public static Document asFormattedDocument(ASTNode astNode, int kind) {
		String source = asString(astNode);
		Document document = new Document(source);

		Map<String, String> options = JavaCore.getOptions();
		options.put(JavaCore.COMPILER_SOURCE, "1.5");
		options.put(JavaCore.COMPILER_COMPLIANCE, "1.5");
		options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, "1.5");

		CodeFormatter formatter = ToolFactory.createCodeFormatter(options);
		TextEdit textEdit = formatter.format(kind, source, 0, source.length(), 0, null);
		try {
			textEdit.apply(document);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		return document;
	}

	public static String getTypeName(CompilationUnit cu) {
		if (cu.types().isEmpty())
			return "";
		String packageName = cu.getPackage().getName().toString();
		String typeName = ((TypeDeclaration)cu.types().get(0)).getName().getIdentifier();
		return packageName+"."+typeName;
	}

	public static void save(CompilationUnit cu, IPackageFragmentRoot packageFragmentRoot, IProgressMonitor monitor) throws JavaModelException {
		if (cu.types().isEmpty())
			return;
		String packageName = cu.getPackage().getName().toString();
		String typeName = ((TypeDeclaration)cu.types().get(0)).getName().getIdentifier();

		IPackageFragment packageFragment = packageFragmentRoot.createPackageFragment(packageName, true, monitor);
		packageFragment.createCompilationUnit(typeName+".java", asFormattedString(cu), true, monitor);
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
			return javaProject.findType(className).getCompilationUnit();
		} catch (JavaModelException e) {
			return null;
		}
	}


	public static String getCompilationUnitName(IFile compilationUnitFile) {
		IProject prj = compilationUnitFile.getProject();

		try {
			if (!prj.hasNature(JavaCore.NATURE_ID))
				return null;

			IJavaProject jProject = JavaCore.create(prj);

			IClasspathEntry cpes[] = jProject.getResolvedClasspath(true);
			for (IClasspathEntry cpe : cpes) {
				IPath filePath = compilationUnitFile.getFullPath();
				IPath cpePath = cpe.getPath();
				if (cpe.getEntryKind() == IClasspathEntry.CPE_SOURCE && cpePath.isPrefixOf(filePath)) {
					IPath path = filePath.removeFirstSegments(cpePath.segmentCount()).removeFileExtension();
					StringBuilder sb = new StringBuilder();
					String[] segments = path.segments();
					for (int i=0; i<segments.length; i++) {
						if (i>0)
							sb.append('.');
						sb.append(segments[i]);
					}
					return sb.toString();
				}
			}
		} catch (CoreException e) {
			throw new IllegalArgumentException("Cannot retrieve "+compilationUnitFile+" fully qualified class name", e);
		}
		throw new IllegalArgumentException("Missing top-level type declaration in "+compilationUnitFile);
	}

	public static Class<?> loadCompilationUnit(IBindingManager bm) {
		IFile compilationUnitFile = (IFile) bm.wGetValue("file");
		ClassLoader ideClassLoader = ReflectionFactory.getClassLoader(bm);
		return loadCompilationUnit(compilationUnitFile, ideClassLoader);
	}
	public static Class<?> loadCompilationUnit(IFile compilationUnitFile, ClassLoader classLoader) {
		IProject project = compilationUnitFile.getProject();

		try {
			if (!project.hasNature(JavaCore.NATURE_ID))
				return null;


			IJavaElement javaElement = JavaCore.create(compilationUnitFile);
			if(javaElement instanceof ICompilationUnit) {
				ICompilationUnit compilationUnit = ((ICompilationUnit)javaElement);
				IType[] types = compilationUnit.getTypes();
				for(IType type : types) {
					Class<?> clazz = classLoader.loadClass(type.getFullyQualifiedName());
					if(clazz != null && !clazz.isAnonymousClass() && !clazz.isMemberClass())
						return clazz;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static ClassLoader createClassLoader(IJavaProject javaProject, boolean override) {
		ClassLoader platformClassLoader = ReflectionFactory.getPlatformClassLoader();
		String outputLocation = null;
		String[] projectClassPath;
		try {
			IPath outputPath = javaProject.getOutputLocation();
			if (override && outputPath != null)
				outputLocation = ResourcesPlugin.getWorkspace().getRoot().getFolder(outputPath).getLocation().toPortableString();
			projectClassPath = computeDefaultRuntimeClassPath(javaProject);
		} catch (CoreException e) {
			return platformClassLoader;
		}

		List<URL> projectCPEntries = new ArrayList<URL>(projectClassPath.length);
		for(int i=0; i<projectClassPath.length; i++) {
			try {
				projectCPEntries.add(new File(projectClassPath[i]).toURI().toURL());
			} catch (MalformedURLException e) {
			}
		}
		return new URLClassLoader(projectCPEntries.toArray(new URL[0]), 
				outputLocation != null ?
						new FilteringClassLoader(new FolderClassFilter(outputLocation), platformClassLoader) :
						platformClassLoader);
	}

	public static IJavaProject getJavaProject(IProject project) {
		try {
			return JavaCore.create(project);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	public static IJavaProject getJavaProject(String projectName) {
		return getJavaProject(ResourcesPlugin.getWorkspace().getRoot().getProject(projectName));
	}
	
	public static String[] computeDefaultRuntimeClassPath(IJavaProject javaProject) throws JavaModelException {
//		try {
//			IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
//			for (IClasspathEntry entry : rawClasspath) {
//				JavaCore.getClasspathContainer(entry.getPath(), javaProject);
//			}
//			String[] locations = new String[resolvedClasspath.length];
//			for (int i = 0; i < resolvedClasspath.length; i++) {
//				IClasspathEntry entry = resolvedClasspath[i];
//				IPath path = entry.getPath();
//				locations[i] = path.toString();
//			}
//			return locations;
//		} catch (Exception e) {
			try {
				Class<?> javaRuntimeClass = Class.forName("org.eclipse.jdt.launching.JavaRuntime", true, ReflectionFactory.getPlatformClassLoader());
				Method method = javaRuntimeClass.getMethod("computeDefaultRuntimeClassPath", IJavaProject.class);
				String[] originals = (String[]) method.invoke(null, javaProject);
				return originals;
			} catch (Exception e2) {
			}
//		}
		return new String[] { javaProject.getCorrespondingResource().getLocation().toString()+"/bin"};
	}
	
}