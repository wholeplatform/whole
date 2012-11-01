/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
package org.whole.examples.lang.imp.ui.actions;

import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/** 
 * @author Riccardo Solmi
 */
public class ImpActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final ImpActionFactory instance = new ImpActionFactory();
	}
	public static ImpActionFactory instance() {
		return SingletonHolder.instance;
	}
	private ImpActionFactory() {
	}

	protected Object[][] addActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
//		return new Object[0][0];
		return new Object[][] {
//				{ pf.insertFeatureType(), "ImpVariable", "ImpVariable" },
//				{ pf.insertFeatureType(), "Parameter", "Parameter" },
//				{ pf.insertFeatureType(), "ImpAdapterFragment",
//						"ImpAdapterFragment" },
//				{ pf.insertFeatureType(), "ImpBaseFragment", "ImpBaseFragment" },
//				{ pf.insertFeatureType(), "ExpressionStatement",
//						"ExpressionStatement" },
//				{ pf.insertFeatureType(), "SaveStatement", "SaveStatement" },
//				{ pf.insertFeatureType(), "IfElseStatement", "IfElseStatement" },
//				{ pf.insertFeatureType(), "FunctionDeclaration",
//						"FunctionDeclaration" },
//				{ pf.insertFeatureType(), "DoWhileStatement",
//						"DoWhileStatement" },
//				{ pf.insertFeatureType(), "ForeachStatement",
//						"ForeachStatement" },
//				{ pf.insertFeatureType(), "ForStatement", "ForStatement" },
//				{ pf.insertFeatureType(), "VariableDeclaration",
//						"VariableDeclaration" },
//				{ pf.insertFeatureType(), "WhileStatement", "WhileStatement" },
//				{ pf.insertFeatureType(), "ReturnStatement", "ReturnStatement" },
				{ pf.insertFeatureType(), ImpEntityDescriptorEnum.EmptyStatement, "My Custom EmptyStatement" },
//				{ pf.insertFeatureType(), "PrintlnStatement",
//						"PrintlnStatement" },
//				{ pf.insertFeatureType(), "PrintStatement", "PrintStatement" },
//				{ pf.insertFeatureType(), "BlockStatement", "BlockStatement" },
//				{ pf.insertFeatureType(), "IfStatement", "IfStatement" },
//				{ pf.insertFeatureType(), "ImpMetaFragment", "ImpMetaFragment" },
//				{ pf.insertFeatureType(), "BooleanLiteral", "BooleanLiteral" },
//				{ pf.insertFeatureType(), "IntLiteral", "IntLiteral" },
//				{ pf.insertFeatureType(), "StringLiteral", "StringLiteral" },
//				{ pf.insertFeatureType(), "ArrayLiteral", "ArrayLiteral" },
//				{ pf.insertFeatureType(), "RangeLiteral", "RangeLiteral" },
//				{ pf.insertFeatureType(), "Or", "Or" },
//				{ pf.insertFeatureType(), "SizeExpression", "SizeExpression" },
//				{ pf.insertFeatureType(), "Subtraction", "Subtraction" },
//				{ pf.insertFeatureType(), "Multiplication", "Multiplication" },
//				{ pf.insertFeatureType(), "LessOrEquals", "LessOrEquals" },
//				{ pf.insertFeatureType(), "LessThan", "LessThan" },
//				{ pf.insertFeatureType(), "And", "And" },
//				{ pf.insertFeatureType(), "Remainder", "Remainder" },
//				{ pf.insertFeatureType(), "RunExpression", "RunExpression" },
//				{ pf.insertFeatureType(), "Addition", "Addition" },
//				{ pf.insertFeatureType(), "NotEquals", "NotEquals" },
//				{ pf.insertFeatureType(), "Equals", "Equals" },
//				{ pf.insertFeatureType(), "LoadExpression", "LoadExpression" },
//				{ pf.insertFeatureType(), "Not", "Not" },
//				{ pf.insertFeatureType(), "AssignmentExpression",
//						"AssignmentExpression" },
//				{ pf.insertFeatureType(), "Division", "Division" },
//				{ pf.insertFeatureType(), "NameExpression", "NameExpression" },
//				{ pf.insertFeatureType(), "GreaterOrEquals", "GreaterOrEquals" },
//				{ pf.insertFeatureType(), "FunctionInvocationExpression",
//						"FunctionInvocationExpression" },
//				{ pf.insertFeatureType(), "ArrayAccess", "ArrayAccess" },
//				{ pf.insertFeatureType(), "GreaterThan", "GreaterThan" }
				};
	}

	protected Object[][] replaceActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
//		return new Object[0][0];
		return new Object[][] {
				{ pf.replaceFeatureType(), ImpEntityDescriptorEnum.Addition, "Addition (customized)", copy },
//				{ pf.replaceFeatureType(), "And", "And", copy },
//				{ pf.replaceFeatureType(), "Arguments", "Arguments", copy },
//				{ pf.replaceFeatureType(), "ArrayAccess", "ArrayAccess", copy },
//				{ pf.replaceFeatureType(), "ArrayLiteral", "ArrayLiteral", copy },
//				{ pf.replaceFeatureType(), "ArrayType", "ArrayType", copy },
//				{ pf.replaceFeatureType(), "AssignmentExpression",
//						"AssignmentExpression", copy },
//				{ pf.replaceFeatureType(), "BlockStatement", "BlockStatement",
//						copy },
//				{ pf.replaceFeatureType(), "BooleanLiteral", "BooleanLiteral",
//						copy },
//				{ pf.replaceFeatureType(), "DeclarationResolver",
//						"DeclarationResolver", copy },
//				{ pf.replaceFeatureType(), "Division", "Division", copy },
//				{ pf.replaceFeatureType(), "DoWhileStatement",
//						"DoWhileStatement", copy },
//				{ pf.replaceFeatureType(), "EmptyStatement", "EmptyStatement",
//						copy },
//				{ pf.replaceFeatureType(), "Equals", "Equals", copy },
//				{ pf.replaceFeatureType(), "ExpressionResolver",
//						"ExpressionResolver", copy },
//				{ pf.replaceFeatureType(), "ExpressionStatement",
//						"ExpressionStatement", copy },
//				{ pf.replaceFeatureType(), "ForStatement", "ForStatement", copy },
//				{ pf.replaceFeatureType(), "ForeachStatement",
//						"ForeachStatement", copy },
//				{ pf.replaceFeatureType(), "FunctionDeclaration",
//						"FunctionDeclaration", copy },
//				{ pf.replaceFeatureType(), "FunctionInvocationExpression",
//						"FunctionInvocationExpression", copy },
//				{ pf.replaceFeatureType(), "GreaterOrEquals",
//						"GreaterOrEquals", copy },
//				{ pf.replaceFeatureType(), "GreaterThan", "GreaterThan", copy },
//				{ pf.replaceFeatureType(), "IArgumentsResolver",
//						"IArgumentsResolver", copy },
//				{ pf.replaceFeatureType(), "IImpStringDataResolver",
//						"IImpStringDataResolver", copy },
//				{ pf.replaceFeatureType(), "IIntLiteralResolver",
//						"IIntLiteralResolver", copy },
//				{ pf.replaceFeatureType(), "INameExpressionResolver",
//						"INameExpressionResolver", copy },
//				{ pf.replaceFeatureType(), "INameResolver", "INameResolver",
//						copy },
//				{ pf.replaceFeatureType(), "IParameterResolver",
//						"IParameterResolver", copy },
//				{ pf.replaceFeatureType(), "IParametersResolver",
//						"IParametersResolver", copy },
//				{ pf.replaceFeatureType(), "IPrimitiveTypeResolver",
//						"IPrimitiveTypeResolver", copy },
//				{ pf.replaceFeatureType(), "IVariableDeclarationResolver",
//						"IVariableDeclarationResolver", copy },
//				{ pf.replaceFeatureType(), "IfElseStatement",
//						"IfElseStatement", copy },
//				{ pf.replaceFeatureType(), "IfStatement", "IfStatement", copy },
//				{ pf.replaceFeatureType(), "ImpAdapterFragment",
//						"ImpAdapterFragment", copy },
//				{ pf.replaceFeatureType(), "ImpBaseFragment",
//						"ImpBaseFragment", fragment },
//				{ pf.replaceFeatureType(), "ImpEntityDescriptor",
//						"ImpEntityDescriptor", copy },
//				{ pf.replaceFeatureType(), "ImpMetaFragment",
//						"ImpMetaFragment", fragment },
//				{ pf.replaceFeatureType(), "ImpStringData", "ImpStringData",
//						copy },
//				{ pf.replaceFeatureType(), "ImpVariable", "ImpVariable", copy },
//				{ pf.replaceFeatureType(), "IntLiteral", "IntLiteral", copy },
//				{ pf.replaceFeatureType(), "LessOrEquals", "LessOrEquals", copy },
//				{ pf.replaceFeatureType(), "LessThan", "LessThan", copy },
//				{ pf.replaceFeatureType(), "LiteralResolver",
//						"LiteralResolver", copy },
//				{ pf.replaceFeatureType(), "LoadExpression", "LoadExpression",
//						copy },
//				{ pf.replaceFeatureType(), "Multiplication", "Multiplication",
//						copy },
//				{ pf.replaceFeatureType(), "Name", "Name", copy },
//				{ pf.replaceFeatureType(), "NameExpression", "NameExpression",
//						copy },
//				{ pf.replaceFeatureType(), "Not", "Not", copy },
//				{ pf.replaceFeatureType(), "NotEquals", "NotEquals", copy },
//				{ pf.replaceFeatureType(), "Or", "Or", copy },
//				{ pf.replaceFeatureType(), "Parameter", "Parameter", copy },
//				{ pf.replaceFeatureType(), "Parameters", "Parameters", copy },
//				{ pf.replaceFeatureType(), "PrimitiveType", "PrimitiveType",
//						copy },
//				{ pf.replaceFeatureType(), "PrintStatement", "PrintStatement",
//						copy },
//				{ pf.replaceFeatureType(), "PrintlnStatement",
//						"PrintlnStatement", copy },
//				{ pf.replaceFeatureType(), "RangeLiteral", "RangeLiteral", copy },
//				{ pf.replaceFeatureType(), "Remainder", "Remainder", copy },
//				{ pf.replaceFeatureType(), "ReturnStatement",
//						"ReturnStatement", copy },
//				{ pf.replaceFeatureType(), "RunExpression", "RunExpression",
//						copy },
//				{ pf.replaceFeatureType(), "SaveStatement", "SaveStatement",
//						copy },
//				{ pf.replaceFeatureType(), "SizeExpression", "SizeExpression",
//						copy },
//				{ pf.replaceFeatureType(), "StatementResolver",
//						"StatementResolver", copy },
//				{ pf.replaceFeatureType(), "StringLiteral", "StringLiteral",
//						copy },
//				{ pf.replaceFeatureType(), "Subtraction", "Subtraction", copy },
//				{ pf.replaceFeatureType(), "TypeResolver", "TypeResolver", copy },
//				{ pf.replaceFeatureType(), "VariableDeclaration",
//						"VariableDeclaration", copy },
//				{ pf.replaceFeatureType(), "WhileStatement", "WhileStatement",
//						copy }
				};
	}

	protected Object[][] wrapActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.assignableTo(ImpEntityDescriptorEnum.Expression), ImpEntityDescriptorEnum.Addition, "Addition 1", wrapIn0},
				{ pf.assignableTo(ImpEntityDescriptorEnum.Expression), ImpEntityDescriptorEnum.Addition, "Addition 2", wrapIn(ImpFeatureDescriptorEnum.exp2)}
		};
	};
}
