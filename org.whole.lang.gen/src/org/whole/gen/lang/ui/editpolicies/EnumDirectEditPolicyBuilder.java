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
package org.whole.gen.lang.ui.editpolicies;

import java.util.List;

import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.StringUtils;
import static org.whole.gen.lang.ClassNames.*;


/**
 * @author Riccardo Solmi
 */
public class EnumDirectEditPolicyBuilder extends CompilationUnitBuilder {
	public EnumDirectEditPolicyBuilder(LanguageGenerator generator, String packageSuffix, String entityName, String valueType, String valueName) {
		super(generator, packageSuffix);

		addClassDeclaration(entityName+"DirectEditPolicy", "org.eclipse.gef.editpolicies.DirectEditPolicy");

		addImportDeclaration(generator.commandsPackage()+"."+entityName+"Command");
		addImportDeclaration(generator.modelPackage()+"."+entityName);

		methodDec = newMethodDeclaration("org.eclipse.gef.commands.Command", "getDirectEditCommand");
        methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration("org.eclipse.gef.requests.DirectEditRequest", "request"));

		List statements = methodDec.getBody().statements();
		
		String enumName = generator.modelPackage()+"."+entityName+"Enum";
		if (valueType.equals(EntityDescriptor.class.getName()))
			enumName = generator.specificEntityDescriptorEnumName();
			
		statements.add(newVariableDeclarationStatement(valueType, "newValue", 
				newMethodInvocation(newFieldAccess(enumName, "instance"), "valueOf",
						newCastExpression("String", newMethodInvocation(newMethodInvocation("request", "getCellEditor"), "getValue")))));
		
		statements.add(newIfStatement(
				newInfixExpression(ast.newSimpleName("newValue"), "==", newNullLiteral()),
				newReturnStatement(newFieldAccess(UnexecutableCommandName, "INSTANCE"))));
		
		statements.add(newVariableDeclarationStatement(entityName+"Command", "cmd", newClassInstanceCreation(entityName+"Command")));
		
		statements.add(newExpressionStatement(
				newMethodInvocation("cmd", "setSource", 
				newCastExpression(entityName, newMethodInvocation(newMethodInvocation("getHost"), "getModel")))));

		statements.add(newExpressionStatement(
				newMethodInvocation("cmd", "setOldValue",
						newMethodInvocation(newParenthesizedExpression(newCastExpression(entityName, newMethodInvocation(newMethodInvocation("getHost"), "getModel"))), StringUtils.getterName(valueType, valueName)))));

		statements.add(newExpressionStatement(
				newMethodInvocation("cmd", "setNewValue", ast.newSimpleName("newValue"))));

		statements.add(newReturnStatement(ast.newSimpleName("cmd")));

		addBodyDeclaration(methodDec);


		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "showCurrentEditValue");
        methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration("org.eclipse.gef.requests.DirectEditRequest", "request"));

		statements = methodDec.getBody().statements();
		statements.add(newExpressionStatement(
				newMethodInvocation(newParenthesizedExpression(newCastExpression("org.eclipse.draw2d.Label", newMethodInvocation("getHostFigure"))), "setText",
						newCastExpression("String", newMethodInvocation(newMethodInvocation("request","getCellEditor"), "getValue")))));
		
		addBodyDeclaration(methodDec);
	}
}
