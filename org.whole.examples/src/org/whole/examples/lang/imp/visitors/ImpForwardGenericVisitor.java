package org.whole.examples.lang.imp.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ImpForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IImpVisitor {
	public ImpForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FunctionDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Parameters entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Parameter entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableDeclaration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EmptyStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ReturnStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IfStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IfElseStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WhileStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DoWhileStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForeachStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BlockStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrintStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrintlnStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SaveStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ExpressionStatement entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LoadExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FunctionInvocationExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Arguments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AssignmentExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RunExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SizeExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RangeLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NameExpression entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PrimitiveType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArrayAccess entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Addition entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Subtraction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Multiplication entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Division entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Remainder entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(And entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Or entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Not entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Equals entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(NotEquals entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LessThan entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LessOrEquals entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(GreaterThan entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(GreaterOrEquals entity) {
		wGetVisitor1().visit(entity);
	}
}
