package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.model.*;

/** 
 * @generator Whole
 */
public class ImpIdentityDefaultVisitor extends ImpIdentityVisitor {
	public void visit(IImpEntity entity) {
	}

	public void visit(Declaration entity) {
		visit((Statement) entity);
	}

	public void visit(FunctionDeclaration entity) {
		visit((IImpEntity) entity);
		visit((Declaration) entity);
	}

	public void visit(Parameters entity) {
		visit((IImpEntity) entity);
	}

	public void visit(Parameter entity) {
		visit((IImpEntity) entity);
	}

	public void visit(VariableDeclaration entity) {
		visit((IImpEntity) entity);
		visit((Declaration) entity);
	}

	public void visit(Statement entity) {
	}

	public void visit(EmptyStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ReturnStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(IfStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(IfElseStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(WhileStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(DoWhileStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ForStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ForeachStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(BlockStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(PrintStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(PrintlnStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(SaveStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(ExpressionStatement entity) {
		visit((IImpEntity) entity);
		visit((Statement) entity);
	}

	public void visit(Expression entity) {
	}

	public void visit(LoadExpression entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(FunctionInvocationExpression entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Arguments entity) {
		visit((IImpEntity) entity);
	}

	public void visit(AssignmentExpression entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(RunExpression entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(SizeExpression entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Literal entity) {
		visit((Expression) entity);
	}

	public void visit(BooleanLiteral entity) {
		visit((IImpEntity) entity);
		visit((Literal) entity);
	}

	public void visit(IntLiteral entity) {
		visit((IImpEntity) entity);
		visit((Literal) entity);
	}

	public void visit(StringLiteral entity) {
		visit((IImpEntity) entity);
		visit((Literal) entity);
	}

	public void visit(RangeLiteral entity) {
		visit((IImpEntity) entity);
		visit((Literal) entity);
	}

	public void visit(ArrayLiteral entity) {
		visit((IImpEntity) entity);
		visit((Literal) entity);
	}

	public void visit(Name entity) {
		visit((IImpEntity) entity);
	}

	public void visit(NameExpression entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(PrimitiveType entity) {
		visit((IImpEntity) entity);
		visit((Type) entity);
	}

	public void visit(Type entity) {
	}

	public void visit(ArrayType entity) {
		visit((IImpEntity) entity);
		visit((Type) entity);
	}

	public void visit(ArrayAccess entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Addition entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Subtraction entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Multiplication entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Division entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Remainder entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(And entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Or entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Not entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(Equals entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(NotEquals entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(LessThan entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(LessOrEquals entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(GreaterThan entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}

	public void visit(GreaterOrEquals entity) {
		visit((IImpEntity) entity);
		visit((Expression) entity);
	}
}
