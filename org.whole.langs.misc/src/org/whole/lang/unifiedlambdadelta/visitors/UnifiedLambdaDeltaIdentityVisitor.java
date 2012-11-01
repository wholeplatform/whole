package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaIdentityVisitor extends AbstractVisitor
		implements IUnifiedLambdaDeltaVisitor {
	public void visit(IEntity entity) {
		((IUnifiedLambdaDeltaEntity) entity).accept(this);
	}

	public void visit(Declaration entity) {
	}

	public void visit(Definition entity) {
	}

	public void visit(Top entity) {
	}

	public void visit(Application entity) {
	}

	public void visit(Cast entity) {
	}

	public void visit(Abstraction entity) {
	}

	public void visit(Abbreviation entity) {
	}

	public void visit(Local entity) {
	}

	public void visit(Sort entity) {
	}

	public void visit(Polarity entity) {
	}

	public void visit(Index entity) {
	}

	public void visit(Level entity) {
	}

	public void visit(Name entity) {
	}

	public void visit(Access entity) {
	}

	public void visit(Prefix entity) {
	}

	public void visit(Postfix entity) {
	}
}
