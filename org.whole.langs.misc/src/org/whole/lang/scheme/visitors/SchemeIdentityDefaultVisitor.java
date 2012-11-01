package org.whole.lang.scheme.visitors;

import org.whole.lang.scheme.model.*;

/** 
 * @generator Whole
 */
public class SchemeIdentityDefaultVisitor extends SchemeIdentityVisitor {
	public void visit(ISchemeEntity entity) {
	}

	public void visit(Definitions entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(Definition entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(Branches entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(Branch entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(SchemeExpressions entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(SchemeExpression entity) {
	}

	public void visit(ApplyExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(LambdaExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(AndExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(OrExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(CondExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(LocalExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(IdExpression entity) {
		visit((ISchemeEntity) entity);
		visit((SchemeExpression) entity);
	}

	public void visit(ConstExpression entity) {
		visit((SchemeExpression) entity);
	}

	public void visit(ClosureValue entity) {
		visit((ISchemeEntity) entity);
		visit((ConstExpression) entity);
	}

	public void visit(BuiltinValue entity) {
		visit((ISchemeEntity) entity);
		visit((ConstExpression) entity);
	}

	public void visit(BooleanValue entity) {
		visit((ISchemeEntity) entity);
		visit((ConstExpression) entity);
	}

	public void visit(IntValue entity) {
		visit((ISchemeEntity) entity);
		visit((ConstExpression) entity);
	}

	public void visit(StringValue entity) {
		visit((ISchemeEntity) entity);
		visit((ConstExpression) entity);
	}

	public void visit(PairValue entity) {
		visit((ISchemeEntity) entity);
		visit((ConstExpression) entity);
	}

	public void visit(Names entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(Name entity) {
		visit((ISchemeEntity) entity);
	}

	public void visit(SchemeEnvironment entity) {
		visit((ISchemeEntity) entity);
	}
}
