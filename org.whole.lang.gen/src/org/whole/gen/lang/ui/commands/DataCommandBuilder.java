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
package org.whole.gen.lang.ui.commands;

import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.util.StringUtils;


/**
 * @author Riccardo Solmi
 */
public class DataCommandBuilder extends CompilationUnitBuilder {
	public DataCommandBuilder(LanguageGenerator generator, String packageSuffix, String fType, String primitiveType, String fName) {
		super(generator, packageSuffix);

		addClassDeclaration(fType+"Command", "org.eclipse.gef.commands.Command");

		addImportDeclaration(generator.modelPackage()+"."+fType);

		addBodyDeclaration(newFieldDeclaration(fType, "source"));
		addBodyDeclaration(newFieldDeclaration(primitiveType, "oldValue"));
		addBodyDeclaration(newFieldDeclaration(primitiveType, "newValue"));

		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "execute");
		MethodInvocation callExp = newMethodInvocation("source", StringUtils.setterName(fName));
		callExp.arguments().add(ast.newSimpleName("newValue"));
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "undo");
		callExp = newMethodInvocation("source", StringUtils.setterName(fName));
		callExp.arguments().add(ast.newSimpleName("oldValue"));
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));
		addBodyDeclaration(methodDec);

		addBodyDeclaration(newSetterMethod(fType, "source"));
		addBodyDeclaration(newSetterMethod(primitiveType, "oldValue"));
		addBodyDeclaration(newSetterMethod(primitiveType, "newValue"));
	}
}
