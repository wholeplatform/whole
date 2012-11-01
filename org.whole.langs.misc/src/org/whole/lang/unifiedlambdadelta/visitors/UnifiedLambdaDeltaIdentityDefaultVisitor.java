package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.unifiedlambdadelta.model.*;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaIdentityDefaultVisitor extends
		UnifiedLambdaDeltaIdentityVisitor {
	public void visit(IUnifiedLambdaDeltaEntity entity) {
	}

	public void visit(BinaryItem entity) {
	}

	public void visit(BinaryContextBinder entity) {
		visit((BinaryItem) entity);
		visit((Context) entity);
		visit((Binder) entity);
	}

	public void visit(Context entity) {
	}

	public void visit(Binder entity) {
	}

	public void visit(Declaration entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((BinaryContextBinder) entity);
	}

	public void visit(Definition entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((BinaryContextBinder) entity);
	}

	public void visit(Top entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((Context) entity);
	}

	public void visit(BinaryTerm entity) {
		visit((BinaryItem) entity);
		visit((Term) entity);
	}

	public void visit(Term entity) {
	}

	public void visit(Application entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((BinaryTerm) entity);
	}

	public void visit(Cast entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((BinaryTerm) entity);
	}

	public void visit(BinaryTermBinder entity) {
		visit((BinaryTerm) entity);
		visit((Binder) entity);
	}

	public void visit(Abstraction entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((BinaryTermBinder) entity);
	}

	public void visit(Abbreviation entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((BinaryTermBinder) entity);
	}

	public void visit(Local entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((Term) entity);
	}

	public void visit(Sort entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
		visit((Term) entity);
	}

	public void visit(Polarity entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}

	public void visit(Index entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}

	public void visit(Level entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}

	public void visit(Name entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}

	public void visit(Access entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}

	public void visit(Prefix entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}

	public void visit(Postfix entity) {
		visit((IUnifiedLambdaDeltaEntity) entity);
	}
}
