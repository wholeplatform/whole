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
package org.whole.gen.lang.ui.editparts;

import java.util.List;

import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.whole.gen.CompilationUnitBuilder;
import org.whole.gen.lang.LanguageGenerator;
import org.whole.lang.util.StringUtils;
import static org.whole.gen.lang.ClassNames.*;


/**
 * @author Riccardo Solmi
 */
public class DataPartBuilder extends CompilationUnitBuilder {
	public DataPartBuilder(LanguageGenerator generator, String packageSuffix, String fType, String primitiveType, String fName) {
		super(generator, packageSuffix);

		addClassDeclaration(fType+"Part", AbstractPartName);

		addImportDeclaration(generator.modelPackage()+"."+fType);
		addImportDeclaration(generator.policiesPackage()+"."+fType+"DirectEditPolicy");

		addBodyDeclaration(newFieldDeclaration("org.eclipse.gef.tools.DirectEditManager", "manager"));
		
		methodDec = newMethodDeclaration("org.eclipse.draw2d.IFigure", "createFigure");
		methodDec.getBody().statements().add(newReturnStatement(
				newMethodInvocation(StyledLabelName, "createIdentifier")));
		addBodyDeclaration(methodDec);
		
		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "refreshVisuals");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		MethodInvocation callExp = newMethodInvocation(newParenthesizedExpression(newCastExpression(StyledLabelName, newMethodInvocation("getFigure"))), "setText");
		callExp.arguments().add(newToStringMethodInvocation(newMethodInvocation(newParenthesizedExpression(newCastExpression(fType, newMethodInvocation("getModel"))), StringUtils.getterName(primitiveType, fName))));
		methodDec.getBody().statements().add(ast.newExpressionStatement(callExp));
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "createEditPolicies");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		List statements = methodDec.getBody().statements();
		
		SuperMethodInvocation superCallExp = ast.newSuperMethodInvocation();
		superCallExp.setName(ast.newSimpleName("createEditPolicies"));
		statements.add(ast.newExpressionStatement(superCallExp));
		
		callExp = newMethodInvocation("installEditPolicy");
		FieldAccess fieldExp = ast.newFieldAccess();
		fieldExp.setExpression(newSimpleName("org.eclipse.gef.EditPolicy"));
		fieldExp.setName(ast.newSimpleName("DIRECT_EDIT_ROLE"));
		callExp.arguments().add(fieldExp);
		callExp.arguments().add(newClassInstanceCreation(fType+"DirectEditPolicy"));
		statements.add(ast.newExpressionStatement(callExp));
		
		addBodyDeclaration(methodDec);

		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "propertyChangeUI");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		methodDec.parameters().add(newSingleVariableDeclaration("java.beans.PropertyChangeEvent", "event"));

		methodDec.getBody().statements().add(ast.newExpressionStatement(newMethodInvocation("refreshVisuals")));
		addBodyDeclaration(methodDec);
		
		methodDec = newMethodDeclaration(ast.newPrimitiveType(PrimitiveType.VOID), "performDirectEdit");
		methodDec.modifiers().remove(0);//assume ModifierKeyword.PUBLIC_KEYWORD
		methodDec.modifiers().add(ast.newModifier(ModifierKeyword.PROTECTED_KEYWORD));
		
		IfStatement ifStm = ast.newIfStatement();
		InfixExpression infixExp = ast.newInfixExpression();
		infixExp.setLeftOperand(ast.newSimpleName("manager"));
		infixExp.setOperator(InfixExpression.Operator.EQUALS);
		infixExp.setRightOperand(ast.newNullLiteral());
		ifStm.setExpression(infixExp);
		Block body2 = ast.newBlock();
		
		body2.statements().add(newVariableDeclarationStatement("org.eclipse.draw2d.Label", "label", newCastExpression("org.eclipse.draw2d.Label", newMethodInvocation("getFigure"))));
		
		Assignment eqStm = ast.newAssignment();
		eqStm.setLeftHandSide(ast.newSimpleName("manager"));
		ClassInstanceCreation newExp = newClassInstanceCreation(LabelDirectEditManagerName);
		newExp.arguments().add(ast.newThisExpression());
		newExp.arguments().add(newTypeLiteral("org.eclipse.jface.viewers.TextCellEditor"));
		ClassInstanceCreation newExp2 = newClassInstanceCreation(LabelCellEditorLocatorName);
		newExp2.arguments().add(ast.newSimpleName("label"));
		newExp.arguments().add(newExp2);
		newExp.arguments().add(ast.newSimpleName("label"));
		eqStm.setRightHandSide(newExp);
		body2.statements().add(ast.newExpressionStatement(eqStm));

		ifStm.setThenStatement(body2);
		statements = methodDec.getBody().statements();
		statements.add(ifStm);
		statements.add(ast.newExpressionStatement(newMethodInvocation("manager", "show")));

		addBodyDeclaration(methodDec);
	}
}
