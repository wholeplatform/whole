package org.whole.lang.actions.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ActionsForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IActionsVisitor> implements
		IActionsVisitor {
	public ActionsForwardStrategyVisitor() {
		this(new ActionsIdentityVisitor());
	}

	public ActionsForwardStrategyVisitor(IActionsVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IActionsEntity) entity).accept(this);
	}

	public void visit(LanguageActionFactory entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ToolbarActions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ContextMenuActions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(MenuActions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Actions entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SeparatedAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(GroupAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SubgroupAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(CustomAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PerformAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(TemplateAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FactoryAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(SimpleAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(GuardedAction entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Configuration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ActionCall entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Flat entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Hierarchical entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FullName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DistinctPrefix entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(URI entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Name entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Version entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Label entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Text entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Icon entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Size entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ActionKind entity) {
		wGetStrategy().visit(entity);
	}
}
