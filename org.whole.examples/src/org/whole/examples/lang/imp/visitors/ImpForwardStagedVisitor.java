package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.model.*;

/** 
 * @generator Whole
 */
public class ImpForwardStagedVisitor extends ImpIdentityVisitor {
	public void visit(FunctionDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(Parameters entity) {
		stagedVisit(entity);
	}

	public void visit(Parameter entity) {
		stagedVisit(entity);
	}

	public void visit(VariableDeclaration entity) {
		stagedVisit(entity);
	}

	public void visit(EmptyStatement entity) {
		stagedVisit(entity);
	}

	public void visit(ReturnStatement entity) {
		stagedVisit(entity);
	}

	public void visit(IfStatement entity) {
		stagedVisit(entity);
	}

	public void visit(IfElseStatement entity) {
		stagedVisit(entity);
	}

	public void visit(WhileStatement entity) {
		stagedVisit(entity);
	}

	public void visit(DoWhileStatement entity) {
		stagedVisit(entity);
	}

	public void visit(ForStatement entity) {
		stagedVisit(entity);
	}

	public void visit(ForeachStatement entity) {
		stagedVisit(entity);
	}

	public void visit(BlockStatement entity) {
		stagedVisit(entity);
	}

	public void visit(PrintStatement entity) {
		stagedVisit(entity);
	}

	public void visit(PrintlnStatement entity) {
		stagedVisit(entity);
	}

	public void visit(SaveStatement entity) {
		stagedVisit(entity);
	}

	public void visit(ExpressionStatement entity) {
		stagedVisit(entity);
	}

	public void visit(LoadExpression entity) {
		stagedVisit(entity);
	}

	public void visit(FunctionInvocationExpression entity) {
		stagedVisit(entity);
	}

	public void visit(Arguments entity) {
		stagedVisit(entity);
	}

	public void visit(AssignmentExpression entity) {
		stagedVisit(entity);
	}

	public void visit(RunExpression entity) {
		stagedVisit(entity);
	}

	public void visit(SizeExpression entity) {
		stagedVisit(entity);
	}

	public void visit(BooleanLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(IntLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(StringLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(RangeLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(ArrayLiteral entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(NameExpression entity) {
		stagedVisit(entity);
	}

	public void visit(PrimitiveType entity) {
		stagedVisit(entity);
	}

	public void visit(ArrayType entity) {
		stagedVisit(entity);
	}

	public void visit(ArrayAccess entity) {
		stagedVisit(entity);
	}

	public void visit(Addition entity) {
		stagedVisit(entity);
	}

	public void visit(Subtraction entity) {
		stagedVisit(entity);
	}

	public void visit(Multiplication entity) {
		stagedVisit(entity);
	}

	public void visit(Division entity) {
		stagedVisit(entity);
	}

	public void visit(Remainder entity) {
		stagedVisit(entity);
	}

	public void visit(And entity) {
		stagedVisit(entity);
	}

	public void visit(Or entity) {
		stagedVisit(entity);
	}

	public void visit(Not entity) {
		stagedVisit(entity);
	}

	public void visit(Equals entity) {
		stagedVisit(entity);
	}

	public void visit(NotEquals entity) {
		stagedVisit(entity);
	}

	public void visit(LessThan entity) {
		stagedVisit(entity);
	}

	public void visit(LessOrEquals entity) {
		stagedVisit(entity);
	}

	public void visit(GreaterThan entity) {
		stagedVisit(entity);
	}

	public void visit(GreaterOrEquals entity) {
		stagedVisit(entity);
	}
}
