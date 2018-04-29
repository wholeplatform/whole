package org.whole.examples.lang.imp.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class ImpIdentitySwitchVisitor extends AbstractVisitor implements IImpVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case ImpEntityDescriptorEnum.FunctionDeclaration_ord:
			visit((FunctionDeclaration) entity);
			break;
		case ImpEntityDescriptorEnum.Parameters_ord:
			visit((Parameters) entity);
			break;
		case ImpEntityDescriptorEnum.Parameter_ord:
			visit((Parameter) entity);
			break;
		case ImpEntityDescriptorEnum.VariableDeclaration_ord:
			visit((VariableDeclaration) entity);
			break;
		case ImpEntityDescriptorEnum.EmptyStatement_ord:
			visit((EmptyStatement) entity);
			break;
		case ImpEntityDescriptorEnum.ReturnStatement_ord:
			visit((ReturnStatement) entity);
			break;
		case ImpEntityDescriptorEnum.IfStatement_ord:
			visit((IfStatement) entity);
			break;
		case ImpEntityDescriptorEnum.IfElseStatement_ord:
			visit((IfElseStatement) entity);
			break;
		case ImpEntityDescriptorEnum.WhileStatement_ord:
			visit((WhileStatement) entity);
			break;
		case ImpEntityDescriptorEnum.DoWhileStatement_ord:
			visit((DoWhileStatement) entity);
			break;
		case ImpEntityDescriptorEnum.ForStatement_ord:
			visit((ForStatement) entity);
			break;
		case ImpEntityDescriptorEnum.ForeachStatement_ord:
			visit((ForeachStatement) entity);
			break;
		case ImpEntityDescriptorEnum.BlockStatement_ord:
			visit((BlockStatement) entity);
			break;
		case ImpEntityDescriptorEnum.PrintStatement_ord:
			visit((PrintStatement) entity);
			break;
		case ImpEntityDescriptorEnum.PrintlnStatement_ord:
			visit((PrintlnStatement) entity);
			break;
		case ImpEntityDescriptorEnum.SaveStatement_ord:
			visit((SaveStatement) entity);
			break;
		case ImpEntityDescriptorEnum.ExpressionStatement_ord:
			visit((ExpressionStatement) entity);
			break;
		case ImpEntityDescriptorEnum.LoadExpression_ord:
			visit((LoadExpression) entity);
			break;
		case ImpEntityDescriptorEnum.FunctionInvocationExpression_ord:
			visit((FunctionInvocationExpression) entity);
			break;
		case ImpEntityDescriptorEnum.Arguments_ord:
			visit((Arguments) entity);
			break;
		case ImpEntityDescriptorEnum.AssignmentExpression_ord:
			visit((AssignmentExpression) entity);
			break;
		case ImpEntityDescriptorEnum.RunExpression_ord:
			visit((RunExpression) entity);
			break;
		case ImpEntityDescriptorEnum.SizeExpression_ord:
			visit((SizeExpression) entity);
			break;
		case ImpEntityDescriptorEnum.BooleanLiteral_ord:
			visit((BooleanLiteral) entity);
			break;
		case ImpEntityDescriptorEnum.IntLiteral_ord:
			visit((IntLiteral) entity);
			break;
		case ImpEntityDescriptorEnum.StringLiteral_ord:
			visit((StringLiteral) entity);
			break;
		case ImpEntityDescriptorEnum.RangeLiteral_ord:
			visit((RangeLiteral) entity);
			break;
		case ImpEntityDescriptorEnum.ArrayLiteral_ord:
			visit((ArrayLiteral) entity);
			break;
		case ImpEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case ImpEntityDescriptorEnum.NameExpression_ord:
			visit((NameExpression) entity);
			break;
		case ImpEntityDescriptorEnum.PrimitiveType_ord:
			visit((PrimitiveType) entity);
			break;
		case ImpEntityDescriptorEnum.ArrayType_ord:
			visit((ArrayType) entity);
			break;
		case ImpEntityDescriptorEnum.ArrayAccess_ord:
			visit((ArrayAccess) entity);
			break;
		case ImpEntityDescriptorEnum.Addition_ord:
			visit((Addition) entity);
			break;
		case ImpEntityDescriptorEnum.Subtraction_ord:
			visit((Subtraction) entity);
			break;
		case ImpEntityDescriptorEnum.Multiplication_ord:
			visit((Multiplication) entity);
			break;
		case ImpEntityDescriptorEnum.Division_ord:
			visit((Division) entity);
			break;
		case ImpEntityDescriptorEnum.Remainder_ord:
			visit((Remainder) entity);
			break;
		case ImpEntityDescriptorEnum.And_ord:
			visit((And) entity);
			break;
		case ImpEntityDescriptorEnum.Or_ord:
			visit((Or) entity);
			break;
		case ImpEntityDescriptorEnum.Not_ord:
			visit((Not) entity);
			break;
		case ImpEntityDescriptorEnum.Equals_ord:
			visit((Equals) entity);
			break;
		case ImpEntityDescriptorEnum.NotEquals_ord:
			visit((NotEquals) entity);
			break;
		case ImpEntityDescriptorEnum.LessThan_ord:
			visit((LessThan) entity);
			break;
		case ImpEntityDescriptorEnum.LessOrEquals_ord:
			visit((LessOrEquals) entity);
			break;
		case ImpEntityDescriptorEnum.GreaterThan_ord:
			visit((GreaterThan) entity);
			break;
		case ImpEntityDescriptorEnum.GreaterOrEquals_ord:
			visit((GreaterOrEquals) entity);
			break;
		}
	}
}
