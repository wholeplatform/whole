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

import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.util.StringUtils;
import static org.whole.gen.lang.ClassNames.*;


/**
 * @author Riccardo Solmi
 */
public class DataDirectEditPolicyBuilder extends CompilationUnitBuilder {
	public DataDirectEditPolicyBuilder(LanguageGenerator generator, String packageSuffix, String fType, String primitiveType, String fName) {
		super(generator, packageSuffix);

		addClassDeclaration(fType+"DirectEditPolicy", "org.eclipse.gef.editpolicies.DirectEditPolicy");

		addImportDeclaration(generator.commandsPackage()+"."+fType+"Command");
		addImportDeclaration(generator.modelPackage()+"."+fType);

		methodDec = newMethodDeclaration("org.eclipse.gef.commands.Command", "getDirectEditCommand");
        methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration("org.eclipse.gef.requests.DirectEditRequest", "request"));

		TryStatement tryStm = newTryStatement();
		methodDec.getBody().statements().add(tryStm);
		tryStm.catchClauses().add(newCatchClause(
				newSingleVariableDeclaration("NumberFormatException", "e"),
				newReturnStatement(newFieldAccess(UnexecutableCommandName, "INSTANCE"))));
		List statements = tryStm.getBody().statements();
		
		statements.add(newVariableDeclarationStatement(fType+"Command", "cmd", newClassInstanceCreation(fType+"Command")));
		MethodInvocation callExp = newMethodInvocation("cmd", "setSource");
		callExp.arguments().add(newCastExpression(fType, newMethodInvocation(newMethodInvocation("getHost"), "getModel")));
		statements.add(ast.newExpressionStatement(callExp));

		callExp = newMethodInvocation("cmd", "setOldValue");
		callExp.arguments().add(newMethodInvocation(newParenthesizedExpression(newCastExpression(fType, newMethodInvocation(newMethodInvocation("getHost"), "getModel"))), StringUtils.getterName(primitiveType, fName)));
		statements.add(ast.newExpressionStatement(callExp));

		callExp = newMethodInvocation("cmd", "setNewValue");
		callExp.arguments().add(newValueOfMethodInvocation(newCastExpression("String", newMethodInvocation(newMethodInvocation("request","getCellEditor"), "getValue")), primitiveType));
		statements.add(ast.newExpressionStatement(callExp));

		statements.add(newReturnStatement(ast.newSimpleName("cmd")));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "showCurrentEditValue");
        methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration("org.eclipse.gef.requests.DirectEditRequest", "request"));

		statements = methodDec.getBody().statements();
		callExp = newMethodInvocation(newParenthesizedExpression(newCastExpression("org.eclipse.draw2d.Label", newMethodInvocation("getHostFigure"))), "setText");
		callExp.arguments().add(newCastExpression("String", newMethodInvocation(newMethodInvocation("request","getCellEditor"), "getValue")));
		statements.add(ast.newExpressionStatement(callExp));
		addBodyDeclaration(methodDec);
	}
}
