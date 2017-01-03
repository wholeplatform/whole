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
package org.whole.lang.operations;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.whole.gen.JavaModelGenerator;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.model.IEntity;


/**
 * @author Riccardo Solmi
 */
public class JavaCompilerOperation extends AbstractOperation {
	public static final String ID = IE4UIConstants.JAVA_COMPILER_OPERATION_ID;

	private JavaModelGenerator generator;

	public static List<CompilationUnit> compile(IEntity model, IBindingManager args) {
		JavaCompilerOperation op = new JavaCompilerOperation(args);
    	op.stagedVisit(model);
    	return op.getCompilationUnits();
	}

	protected JavaCompilerOperation(IBindingManager args) {
		super(ID, args, false);
	}

	public JavaModelGenerator getGenerator() {
		if (generator == null) {
			setGenerator(createGenerator());

			IBindingScope pe = getOperationEnvironment();
			if (pe.wIsSet("author"))
				generator.setAuthor(pe.wStringValue("author"));
			if (pe.wIsSet("copyright"))
				generator.setCopyright(pe.wStringValue("copyright"));
			if (pe.wIsSet("license"))
				generator.setLicense(pe.wStringValue("license"));
			if (pe.wIsSet("packageName"))
				generator.setBasePackagePrefix(pe.wStringValue("packageName"));
			if (pe.wIsSet("URI"))
				generator.setURI(pe.wStringValue("URI"));
		}
		return generator;
	}
	public void setGenerator(JavaModelGenerator generator) {
		this.generator = generator;
	}
	protected JavaModelGenerator createGenerator() {
		try {
			Class<?> genClass = Thread.currentThread().getContextClassLoader().loadClass("org.whole.gen.lang.LanguageGenerator");
			return (JavaModelGenerator) genClass.newInstance();
		} catch (Exception e) {
			return new JavaModelGenerator("test");
		}
	}

	public List<CompilationUnit> getCompilationUnits() {
		if (generator == null)
			return Collections.emptyList();
		else
			return generator.cuList;
	}
}
