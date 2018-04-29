package org.whole.examples.lang.imp.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ImpIdentityUnaryVisitor<V extends IVisitor> extends AbstractUnaryVisitor<V> implements IImpVisitor {
	public ImpIdentityUnaryVisitor() {
		super(null);
	}

	public ImpIdentityUnaryVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		((IImpEntity) entity).accept(this);
	}

	public void visit(FunctionDeclaration entity) {
	}

	public void visit(Parameters entity) {
	}

	public void visit(Parameter entity) {
	}

	public void visit(VariableDeclaration entity) {
	}

	public void visit(EmptyStatement entity) {
	}

	public void visit(ReturnStatement entity) {
	}

	public void visit(IfStatement entity) {
	}

	public void visit(IfElseStatement entity) {
	}

	public void visit(WhileStatement entity) {
	}

	public void visit(DoWhileStatement entity) {
	}

	public void visit(ForStatement entity) {
	}

	public void visit(ForeachStatement entity) {
	}

	public void visit(BlockStatement entity) {
	}

	public void visit(PrintStatement entity) {
	}

	public void visit(PrintlnStatement entity) {
	}

	public void visit(SaveStatement entity) {
	}

	public void visit(ExpressionStatement entity) {
	}

	public void visit(LoadExpression entity) {
	}

	public void visit(FunctionInvocationExpression entity) {
	}

	public void visit(Arguments entity) {
	}

	public void visit(AssignmentExpression entity) {
	}

	public void visit(RunExpression entity) {
	}

	public void visit(SizeExpression entity) {
	}

	public void visit(BooleanLiteral entity) {
	}

	public void visit(IntLiteral entity) {
	}

	public void visit(StringLiteral entity) {
	}

	public void visit(RangeLiteral entity) {
	}

	public void visit(ArrayLiteral entity) {
	}

	public void visit(Name entity) {
	}

	public void visit(NameExpression entity) {
	}

	public void visit(PrimitiveType entity) {
	}

	public void visit(ArrayType entity) {
	}

	public void visit(ArrayAccess entity) {
	}

	public void visit(Addition entity) {
	}

	public void visit(Subtraction entity) {
	}

	public void visit(Multiplication entity) {
	}

	public void visit(Division entity) {
	}

	public void visit(Remainder entity) {
	}

	public void visit(And entity) {
	}

	public void visit(Or entity) {
	}

	public void visit(Not entity) {
	}

	public void visit(Equals entity) {
	}

	public void visit(NotEquals entity) {
	}

	public void visit(LessThan entity) {
	}

	public void visit(LessOrEquals entity) {
	}

	public void visit(GreaterThan entity) {
	}

	public void visit(GreaterOrEquals entity) {
	}
}
