package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaFailureVisitor extends
		UnifiedLambdaDeltaIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(Declaration entity) {
		throw new VisitException();
	}

	public void visit(Definition entity) {
		throw new VisitException();
	}

	public void visit(Top entity) {
		throw new VisitException();
	}

	public void visit(Application entity) {
		throw new VisitException();
	}

	public void visit(Cast entity) {
		throw new VisitException();
	}

	public void visit(Abstraction entity) {
		throw new VisitException();
	}

	public void visit(Abbreviation entity) {
		throw new VisitException();
	}

	public void visit(Local entity) {
		throw new VisitException();
	}

	public void visit(Sort entity) {
		throw new VisitException();
	}

	public void visit(Polarity entity) {
		throw new VisitException();
	}

	public void visit(Index entity) {
		throw new VisitException();
	}

	public void visit(Level entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(Access entity) {
		throw new VisitException();
	}

	public void visit(Prefix entity) {
		throw new VisitException();
	}

	public void visit(Postfix entity) {
		throw new VisitException();
	}
}
