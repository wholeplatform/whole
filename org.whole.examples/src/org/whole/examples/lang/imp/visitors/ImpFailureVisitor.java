package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class ImpFailureVisitor extends ImpIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(FunctionDeclaration entity) {
		throw new VisitException();
	}

	public void visit(Parameters entity) {
		throw new VisitException();
	}

	public void visit(Parameter entity) {
		throw new VisitException();
	}

	public void visit(VariableDeclaration entity) {
		throw new VisitException();
	}

	public void visit(EmptyStatement entity) {
		throw new VisitException();
	}

	public void visit(ReturnStatement entity) {
		throw new VisitException();
	}

	public void visit(IfStatement entity) {
		throw new VisitException();
	}

	public void visit(IfElseStatement entity) {
		throw new VisitException();
	}

	public void visit(WhileStatement entity) {
		throw new VisitException();
	}

	public void visit(DoWhileStatement entity) {
		throw new VisitException();
	}

	public void visit(ForStatement entity) {
		throw new VisitException();
	}

	public void visit(ForeachStatement entity) {
		throw new VisitException();
	}

	public void visit(BlockStatement entity) {
		throw new VisitException();
	}

	public void visit(PrintStatement entity) {
		throw new VisitException();
	}

	public void visit(PrintlnStatement entity) {
		throw new VisitException();
	}

	public void visit(SaveStatement entity) {
		throw new VisitException();
	}

	public void visit(ExpressionStatement entity) {
		throw new VisitException();
	}

	public void visit(LoadExpression entity) {
		throw new VisitException();
	}

	public void visit(FunctionInvocationExpression entity) {
		throw new VisitException();
	}

	public void visit(Arguments entity) {
		throw new VisitException();
	}

	public void visit(AssignmentExpression entity) {
		throw new VisitException();
	}

	public void visit(RunExpression entity) {
		throw new VisitException();
	}

	public void visit(SizeExpression entity) {
		throw new VisitException();
	}

	public void visit(BooleanLiteral entity) {
		throw new VisitException();
	}

	public void visit(IntLiteral entity) {
		throw new VisitException();
	}

	public void visit(StringLiteral entity) {
		throw new VisitException();
	}

	public void visit(RangeLiteral entity) {
		throw new VisitException();
	}

	public void visit(ArrayLiteral entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(NameExpression entity) {
		throw new VisitException();
	}

	public void visit(PrimitiveType entity) {
		throw new VisitException();
	}

	public void visit(ArrayType entity) {
		throw new VisitException();
	}

	public void visit(ArrayAccess entity) {
		throw new VisitException();
	}

	public void visit(Addition entity) {
		throw new VisitException();
	}

	public void visit(Subtraction entity) {
		throw new VisitException();
	}

	public void visit(Multiplication entity) {
		throw new VisitException();
	}

	public void visit(Division entity) {
		throw new VisitException();
	}

	public void visit(Remainder entity) {
		throw new VisitException();
	}

	public void visit(And entity) {
		throw new VisitException();
	}

	public void visit(Or entity) {
		throw new VisitException();
	}

	public void visit(Not entity) {
		throw new VisitException();
	}

	public void visit(Equals entity) {
		throw new VisitException();
	}

	public void visit(NotEquals entity) {
		throw new VisitException();
	}

	public void visit(LessThan entity) {
		throw new VisitException();
	}

	public void visit(LessOrEquals entity) {
		throw new VisitException();
	}

	public void visit(GreaterThan entity) {
		throw new VisitException();
	}

	public void visit(GreaterOrEquals entity) {
		throw new VisitException();
	}
}
