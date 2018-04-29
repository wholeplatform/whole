package org.whole.examples.lang.imp.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ImpForwardStrategyVisitor extends GenericForwardStrategyVisitor<IImpVisitor> implements IImpVisitor {
	public ImpForwardStrategyVisitor() {
		this(new ImpIdentityVisitor());
	}

	public ImpForwardStrategyVisitor(IImpVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IImpEntity) entity).accept(this);
	}

	public void visit(FunctionDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Parameters entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Parameter entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VariableDeclaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(EmptyStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ReturnStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IfStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IfElseStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(WhileStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DoWhileStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ForeachStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BlockStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrintStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrintlnStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SaveStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ExpressionStatement entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LoadExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FunctionInvocationExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Arguments entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(AssignmentExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RunExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SizeExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BooleanLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(IntLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StringLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RangeLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayLiteral entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NameExpression entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PrimitiveType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ArrayAccess entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Addition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Subtraction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Multiplication entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Division entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Remainder entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(And entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Or entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Not entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Equals entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(NotEquals entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LessThan entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(LessOrEquals entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(GreaterThan entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(GreaterOrEquals entity) {
		wGetStrategy().visit(entity);
	}
}
