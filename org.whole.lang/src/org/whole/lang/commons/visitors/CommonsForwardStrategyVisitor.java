package org.whole.lang.commons.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.commons.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CommonsForwardStrategyVisitor extends GenericForwardStrategyVisitor<ICommonsVisitor>
		implements ICommonsVisitor {
	public CommonsForwardStrategyVisitor() {
		this(new CommonsIdentityVisitor());
	}

	public CommonsForwardStrategyVisitor(ICommonsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((ICommonsEntity) entity).accept(this);
	}

	public void visit(Resolver entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(RootFragment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SameStageFragment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StageUpFragment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(StageDownFragment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TemplateFragment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(BaseFragment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Phase entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Multiplexer entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Variable entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(InlineVariable entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VarName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(VarType entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Quantifier entity) {
		wGetStrategy().visit(entity);
	}
}
