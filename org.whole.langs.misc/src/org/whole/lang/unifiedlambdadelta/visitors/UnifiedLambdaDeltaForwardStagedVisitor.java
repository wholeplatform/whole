package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.unifiedlambdadelta.model.*;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaForwardStagedVisitor extends
		UnifiedLambdaDeltaIdentityVisitor {
	public void visit(Declaration entity) {
		stagedVisit(entity);
	}

	public void visit(Definition entity) {
		stagedVisit(entity);
	}

	public void visit(Top entity) {
		stagedVisit(entity);
	}

	public void visit(Application entity) {
		stagedVisit(entity);
	}

	public void visit(Cast entity) {
		stagedVisit(entity);
	}

	public void visit(Abstraction entity) {
		stagedVisit(entity);
	}

	public void visit(Abbreviation entity) {
		stagedVisit(entity);
	}

	public void visit(Local entity) {
		stagedVisit(entity);
	}

	public void visit(Sort entity) {
		stagedVisit(entity);
	}

	public void visit(Polarity entity) {
		stagedVisit(entity);
	}

	public void visit(Index entity) {
		stagedVisit(entity);
	}

	public void visit(Level entity) {
		stagedVisit(entity);
	}

	public void visit(Name entity) {
		stagedVisit(entity);
	}

	public void visit(Access entity) {
		stagedVisit(entity);
	}

	public void visit(Prefix entity) {
		stagedVisit(entity);
	}

	public void visit(Postfix entity) {
		stagedVisit(entity);
	}
}
