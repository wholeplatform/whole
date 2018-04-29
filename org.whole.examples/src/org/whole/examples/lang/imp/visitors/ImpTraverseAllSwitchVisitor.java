package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.visitors.ImpIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.examples.lang.imp.model.*;

/** 
 * @generator Whole
 */
public class ImpTraverseAllSwitchVisitor extends ImpIdentityUnaryVisitor<IVisitor> {
	public ImpTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(FunctionDeclaration entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getParameters());
		wGetVisitor1().visit(entity.getBody());
	}

	public void visit(Parameters entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Parameter entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(VariableDeclaration entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getInitializer());
	}

	public void visit(Declaration entity) {
		wGetVisitor1().visit(entity.getType());
		wGetVisitor1().visit(entity.getName());
	}

	public void visit(ReturnStatement entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(IfStatement entity) {
		wGetVisitor1().visit(entity.getCondition());
		wGetVisitor1().visit(entity.getTrueBody());
	}

	public void visit(IfElseStatement entity) {
		wGetVisitor1().visit(entity.getCondition());
		wGetVisitor1().visit(entity.getTrueBody());
		wGetVisitor1().visit(entity.getFalseBody());
	}

	public void visit(WhileStatement entity) {
		wGetVisitor1().visit(entity.getCondition());
		wGetVisitor1().visit(entity.getTrueBody());
	}

	public void visit(DoWhileStatement entity) {
		wGetVisitor1().visit(entity.getTrueBody());
		wGetVisitor1().visit(entity.getCondition());
	}

	public void visit(ForStatement entity) {
		wGetVisitor1().visit(entity.getInitializer());
		wGetVisitor1().visit(entity.getCondition());
		wGetVisitor1().visit(entity.getUpdater());
		wGetVisitor1().visit(entity.getTrueBody());
	}

	public void visit(ForeachStatement entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getArrayExp());
		wGetVisitor1().visit(entity.getTrueBody());
	}

	public void visit(BlockStatement entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(PrintStatement entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(PrintlnStatement entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(SaveStatement entity) {
		wGetVisitor1().visit(entity.getExp());
		wGetVisitor1().visit(entity.getFileName());
	}

	public void visit(ExpressionStatement entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(LoadExpression entity) {
		wGetVisitor1().visit(entity.getFileName());
		wGetVisitor1().visit(entity.getLanguage());
	}

	public void visit(FunctionInvocationExpression entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getArguments());
	}

	public void visit(Arguments entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(AssignmentExpression entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(RunExpression entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(SizeExpression entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(RangeLiteral entity) {
		wGetVisitor1().visit(entity.getLowerBound());
		wGetVisitor1().visit(entity.getUpperBound());
	}

	public void visit(ArrayLiteral entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ArrayType entity) {
		wGetVisitor1().visit(entity.getContentType());
		wGetVisitor1().visit(entity.getIndexType());
	}

	public void visit(ArrayAccess entity) {
		wGetVisitor1().visit(entity.getArray());
		wGetVisitor1().visit(entity.getIndex());
	}

	public void visit(Addition entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(Subtraction entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(Multiplication entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(Division entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(Remainder entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(And entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(Or entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(Not entity) {
		wGetVisitor1().visit(entity.getExp());
	}

	public void visit(Equals entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(NotEquals entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(LessThan entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(LessOrEquals entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(GreaterThan entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}

	public void visit(GreaterOrEquals entity) {
		wGetVisitor1().visit(entity.getExp1());
		wGetVisitor1().visit(entity.getExp2());
	}
}
