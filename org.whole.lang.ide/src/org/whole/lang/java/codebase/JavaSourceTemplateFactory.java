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
package org.whole.lang.java.codebase;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ITypeRoot;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.builders.GenericForwardSpecificBuilder;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.java.util.JDTTransformerVisitor;
import org.whole.lang.templates.ModelTemplate;

/**
 * @author Enrico Persiani
 */
public class JavaSourceTemplateFactory extends JavaClassTemplateFactory {
	protected CompilationUnit compilationUnit;

	public JavaSourceTemplateFactory(String className, IJavaProject javaProject) {
		init(JDTUtils.findSourceAttachment(JDTUtils.findSourceReference(className, javaProject)), className, javaProject);
	}
	public JavaSourceTemplateFactory(ITypeRoot typeRoot) {
		String className = typeRoot.findPrimaryType().getFullyQualifiedName();
		IJavaProject javaProject = typeRoot.getJavaProject();
		init(JDTUtils.findSourceAttachment(typeRoot), className, javaProject);
	}

	protected void init(String sourceAttachment, String className, IJavaProject javaProject) {
		try {
			if (sourceAttachment != null) {
				compilationUnit = JDTTransformerVisitor.transform(sourceAttachment, JDTUtils.parseAsCompilationUnit(sourceAttachment));
			} else
				this.clazz = Class.forName(className, false, JDTUtils.createClassLoader(javaProject, true));
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException("Cannot load "+className+" class fomr "+javaProject.getElementName()+" Java Project");
		}
	}

	@Override
	public void apply(IBuilderOperation op) {
		if (compilationUnit != null) {
			new ModelTemplate(compilationUnit).apply(new GenericForwardSpecificBuilder(op));
		} else
			super.apply(op);
	}

	@Override
	public CompilationUnit create() {
		if (compilationUnit != null)
			return compilationUnit;
		else
			return super.create();
	}
}
