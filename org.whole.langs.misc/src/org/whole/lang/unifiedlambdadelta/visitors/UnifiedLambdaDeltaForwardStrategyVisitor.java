package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IUnifiedLambdaDeltaVisitor> implements
		IUnifiedLambdaDeltaVisitor {
	public UnifiedLambdaDeltaForwardStrategyVisitor() {
		this(new UnifiedLambdaDeltaIdentityVisitor());
	}

	public UnifiedLambdaDeltaForwardStrategyVisitor(
			IUnifiedLambdaDeltaVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IUnifiedLambdaDeltaEntity) entity).accept(this);
	}

	public void visit(Declaration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Definition entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Top entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Application entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Cast entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Abstraction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Abbreviation entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Local entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Sort entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Polarity entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Index entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Level entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Access entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Prefix entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Postfix entity) {
		wGetStrategy().visit(entity);
	}
}
