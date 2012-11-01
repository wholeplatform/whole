package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.visitors.ImpIdentityUnaryVisitor;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ImpTraverseAllVisitor extends ImpIdentityUnaryVisitor<IImpVisitor> {
	public ImpTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public ImpTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(FunctionDeclaration entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getParameters().accept(wGetVisitor1());
		entity.getBody().accept(wGetVisitor1());
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Parameter entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(VariableDeclaration entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getInitializer().accept(wGetVisitor1());
	}

	public void visit(Declaration entity) {
		entity.getType().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
	}

	public void visit(ReturnStatement entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(IfStatement entity) {
		entity.getCondition().accept(wGetVisitor1());
		entity.getTrueBody().accept(wGetVisitor1());
	}

	public void visit(IfElseStatement entity) {
		entity.getCondition().accept(wGetVisitor1());
		entity.getTrueBody().accept(wGetVisitor1());
		entity.getFalseBody().accept(wGetVisitor1());
	}

	public void visit(WhileStatement entity) {
		entity.getCondition().accept(wGetVisitor1());
		entity.getTrueBody().accept(wGetVisitor1());
	}

	public void visit(DoWhileStatement entity) {
		entity.getTrueBody().accept(wGetVisitor1());
		entity.getCondition().accept(wGetVisitor1());
	}

	public void visit(ForStatement entity) {
		entity.getInitializer().accept(wGetVisitor1());
		entity.getCondition().accept(wGetVisitor1());
		entity.getUpdater().accept(wGetVisitor1());
		entity.getTrueBody().accept(wGetVisitor1());
	}

	public void visit(ForeachStatement entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getArrayExp().accept(wGetVisitor1());
		entity.getTrueBody().accept(wGetVisitor1());
	}

	public void visit(BlockStatement entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(PrintStatement entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(PrintlnStatement entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(SaveStatement entity) {
		entity.getExp().accept(wGetVisitor1());
		entity.getFileName().accept(wGetVisitor1());
	}

	public void visit(ExpressionStatement entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(LoadExpression entity) {
		entity.getFileName().accept(wGetVisitor1());
		entity.getLanguage().accept(wGetVisitor1());
	}

	public void visit(FunctionInvocationExpression entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(AssignmentExpression entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(RunExpression entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(SizeExpression entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(RangeLiteral entity) {
		entity.getLowerBound().accept(wGetVisitor1());
		entity.getUpperBound().accept(wGetVisitor1());
	}

	public void visit(ArrayLiteral entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ArrayType entity) {
		entity.getContentType().accept(wGetVisitor1());
		entity.getIndexType().accept(wGetVisitor1());
	}

	public void visit(ArrayAccess entity) {
		entity.getArray().accept(wGetVisitor1());
		entity.getIndex().accept(wGetVisitor1());
	}

	public void visit(Addition entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(Subtraction entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(Multiplication entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(Division entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(Remainder entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(And entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(Or entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(Not entity) {
		entity.getExp().accept(wGetVisitor1());
	}

	public void visit(Equals entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(NotEquals entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(LessThan entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(LessOrEquals entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(GreaterThan entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}

	public void visit(GreaterOrEquals entity) {
		entity.getExp1().accept(wGetVisitor1());
		entity.getExp2().accept(wGetVisitor1());
	}
}
