package org.whole.lang.scheme.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.scheme.model.*;

/** 
 * @generator Whole
 */
public interface ISchemeVisitor extends IVisitor {
	public void visit(Definitions entity);

	public void visit(Definition entity);

	public void visit(Branches entity);

	public void visit(Branch entity);

	public void visit(SchemeExpressions entity);

	public void visit(ApplyExpression entity);

	public void visit(LambdaExpression entity);

	public void visit(AndExpression entity);

	public void visit(OrExpression entity);

	public void visit(CondExpression entity);

	public void visit(LocalExpression entity);

	public void visit(IdExpression entity);

	public void visit(ClosureValue entity);

	public void visit(BuiltinValue entity);

	public void visit(BooleanValue entity);

	public void visit(IntValue entity);

	public void visit(StringValue entity);

	public void visit(PairValue entity);

	public void visit(Names entity);

	public void visit(Name entity);

	public void visit(SchemeEnvironment entity);
}
