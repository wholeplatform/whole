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
package org.whole.gen.lang.model.impl;

import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TryStatement;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.model.AbstractDataEntity;
import org.whole.lang.model.EnumValue;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class DataEntityImplBuilder extends CompilationUnitBuilder {
	public DataEntityImplBuilder(LanguageGenerator generator, String packageSuffix, String entityName, String primitiveType, String fName) {
		super(generator, packageSuffix);

		addClassDeclaration(generator.entityImplName(entityName), AbstractDataEntity.class.getName());
		generator.putEntity(entityName);
		addSuperInterface(generator.entityInterfaceQName(entityName));
		addSerialVersionUID(1L);

		//FIXME fix field and accessors methods and move up into the caller
		if (StringUtils.isAmbiguous(primitiveType))
			primitiveType = "java.lang."+primitiveType;
		boolean useQualifiedType = !"java.lang".equals(StringUtils.toPackageName(primitiveType));

		addBodyDeclaration(newFieldDeclaration(primitiveType, fName, useQualifiedType));

//		addBodyDeclaration(newConstructorDeclaration(typeDec));
		
//		methodDec = newConstructorDeclaration(typeDec);
//		addConstructorCase(methodDec, primitiveType, fName);
//		addBodyDeclaration(methodDec);
		
		addBodyDeclaration(newGetterMethodWithNotification(
null,//				((LanguageGenerator)generator).specificFeatureDescriptorEnumName(),
				primitiveType, fName, fName, useQualifiedType));
		addBodyDeclaration(newSetterMethodWithNotification(
null,//				((LanguageGenerator)generator).specificFeatureDescriptorEnumName(),
				primitiveType, fName, fName, false, useQualifiedType));

		addBodyDeclaration(newAcceptMethod(generator.specificVisitorInterfaceName()));

		// add wGetEntityOrd method
		MethodDeclaration methodDecl = newMethodDeclaration("int", "wGetEntityOrd");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName+"_ord")));
		addBodyDeclaration(methodDecl);
		
		// add wGetEntityDescriptor method
		methodDecl = newMethodDeclaration(
				newParameterizedType(EntityDescriptor.class.getName(), generator.entityInterfaceQName(entityName)),
				"wGetEntityDescriptor");
		methodDecl.getBody().statements().add(newReturnStatement(newFieldAccess(generator.specificEntityDescriptorEnumName(), entityName)));
		addBodyDeclaration(methodDecl);

		// add generic Object getter
		MethodDeclaration method = newMethodDeclaration("java.lang.Object", "wGetValue");
		method.getBody().statements().add(newReturnStatement(newWrapperInstanceCreation(primitiveType, newMethodInvocation(StringUtils.getterName(primitiveType, fName)))));
		addBodyDeclaration(method);

		// add generic Object setter
		method = newMethodDeclaration("void", "wSetValue");
		method.parameters().add(newSingleVariableDeclaration("java.lang.Object", "value"));
		MethodInvocation callExp = newMethodInvocation(StringUtils.setterName(fName));
		callExp.arguments().add(newUnwrapperExpression(primitiveType, "value", useQualifiedType));
		method.getBody().statements().add(newExpressionStatement(callExp));
		addBodyDeclaration(method);

		if (StringUtils.isPrimitiveOrString(primitiveType)) {
			if (!StringUtils.isString(primitiveType))
				addStringAccessors(primitiveType, fName);
			else
				primitiveType = "String";

			// add specific getter
			method = newMethodDeclaration(primitiveType, "w"+StringUtils.toUpperCap(primitiveType)+"Value");
			method.getBody().statements().add(newReturnStatement(newMethodInvocation(StringUtils.getterName(primitiveType, fName))));
			addBodyDeclaration(method);
			
			// add specific setter
			method = newMethodDeclaration("void", "wSetValue");
			method.parameters().add(newSingleVariableDeclaration(primitiveType, fName));
			callExp = newMethodInvocation(StringUtils.setterName(fName));
			callExp.arguments().add(newSimpleName(fName));
			method.getBody().statements().add(newExpressionStatement(callExp));
			addBodyDeclaration(method);
		} else if (primitiveType.endsWith("Enum.Value") || primitiveType.equals(EntityDescriptor.class.getName())) {
			addStringAccessors(primitiveType, fName);

			String primitiveType1 = EnumValue.class.getName();
			// add specific getter
			method = newMethodDeclaration(primitiveType1, "wEnumValue");
			method.getBody().statements().add(newReturnStatement(newSimpleName(fName)));
			addBodyDeclaration(method);
			
			// add specific setter
			method = newMethodDeclaration("void", "wSetValue");
			method.parameters().add(newSingleVariableDeclaration(primitiveType1, fName));
			callExp = newMethodInvocation(StringUtils.setterName(fName));
			callExp.arguments().add(newCastExpression(primitiveType, newSimpleName(fName), true));
			method.getBody().statements().add(newExpressionStatement(callExp));
			addBodyDeclaration(method);			
		} else if (primitiveType.equals("Date") || primitiveType.equals("java.util.Date")) {
			// add generic String getter
			method = newMethodDeclaration("String", "wStringValue");
			method.getBody().statements().add(newReturnStatement(
					newMethodInvocation(StringUtils.class.getName(), "toExtendedISO8601DateTime", ast.newSimpleName("value"))));
			addBodyDeclaration(method);

			// add generic String setter
			method = newMethodDeclaration("void", "wSetValue");
			method.parameters().add(newSingleVariableDeclaration("String", "value"));
			TryStatement tryStm = newTryStatement();
			callExp = newMethodInvocation(StringUtils.setterName(fName));
			callExp.arguments().add(
					newMethodInvocation(StringUtils.class.getName(), "fromExtendedISO8601DateTime", ast.newSimpleName("value")));
			tryStm.getBody().statements().add(newExpressionStatement(callExp));
			tryStm.catchClauses().add(newCatchClause(newSingleVariableDeclaration("IllegalArgumentException", "e")));
			method.getBody().statements().add(tryStm);
			addBodyDeclaration(method);

			// add specific getter
			method = newMethodDeclaration(primitiveType, "wDateValue");
			method.getBody().statements().add(newReturnStatement(newSimpleName(fName)));
			addBodyDeclaration(method);
			
			// add specific setter
			method = newMethodDeclaration("void", "wSetValue");
			method.parameters().add(newSingleVariableDeclaration(primitiveType, fName));
			callExp = newMethodInvocation(StringUtils.setterName(fName));
			callExp.arguments().add(newCastExpression(primitiveType, newSimpleName(fName)));
			method.getBody().statements().add(newExpressionStatement(callExp));
			addBodyDeclaration(method);
		} else if (primitiveType.equals("java.sql.Date")) {
			// add specific setter
			method = newMethodDeclaration("void", "wSetValue");
			method.parameters().add(newSingleVariableDeclaration("java.util.Date", fName));
			callExp = newMethodInvocation(StringUtils.setterName(fName));
			callExp.arguments().add(newCastExpression(primitiveType, newSimpleName(fName)));
			method.getBody().statements().add(newExpressionStatement(callExp));
			addBodyDeclaration(method);			
		}
			
	}

	private void addStringAccessors(String primitiveType, String fName) {
		// add generic String getter
		MethodDeclaration method = newMethodDeclaration("String", "wStringValue");
		method.getBody().statements().add(newReturnStatement(newMethodInvocation("toString")));
		addBodyDeclaration(method);

		// add generic String setter
		method = newMethodDeclaration("void", "wSetValue");
		method.parameters().add(newSingleVariableDeclaration("String", "value"));
		TryStatement tryStm = newTryStatement();
		MethodInvocation callExp = newMethodInvocation(StringUtils.setterName(fName));
		callExp.arguments().add(newValueOfMethodInvocation(ast.newSimpleName("value"), primitiveType));
		tryStm.getBody().statements().add(newExpressionStatement(callExp));
		tryStm.catchClauses().add(newCatchClause(newSingleVariableDeclaration("NumberFormatException", "e")));
		method.getBody().statements().add(tryStm);
		addBodyDeclaration(method);
	}
}
