package org.whole.lang.actions.visitors;

import org.whole.lang.actions.model.*;

/** 
 * @generator Whole
 */
public class ActionsIdentityDefaultVisitor extends ActionsIdentityVisitor {
	public void visit(IActionsEntity entity) {
	}

	public void visit(LanguageActionFactory entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(ToolbarActions entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(ContextMenuActions entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(MenuActions entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Actions entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Action entity) {
	}

	public void visit(SeparatedAction entity) {
		visit((IActionsEntity) entity);
		visit((Action) entity);
	}

	public void visit(GroupAction entity) {
		visit((IActionsEntity) entity);
		visit((Action) entity);
	}

	public void visit(SubgroupAction entity) {
		visit((IActionsEntity) entity);
		visit((GroupAction) entity);
	}

	public void visit(CustomAction entity) {
		visit((IActionsEntity) entity);
		visit((Action) entity);
	}

	public void visit(PerformAction entity) {
		visit((IActionsEntity) entity);
		visit((Action) entity);
	}

	public void visit(TemplateAction entity) {
		visit((IActionsEntity) entity);
		visit((PerformAction) entity);
	}

	public void visit(FactoryAction entity) {
		visit((IActionsEntity) entity);
		visit((Action) entity);
	}

	public void visit(SimpleAction entity) {
		visit((IActionsEntity) entity);
		visit((Action) entity);
	}

	public void visit(GuardedAction entity) {
		visit((IActionsEntity) entity);
		visit((SimpleAction) entity);
	}

	public void visit(Configuration entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Transformation entity) {
	}

	public void visit(ActionCall entity) {
		visit((IActionsEntity) entity);
		visit((Transformation) entity);
	}

	public void visit(FillStrategy entity) {
	}

	public void visit(Flat entity) {
		visit((IActionsEntity) entity);
		visit((FillStrategy) entity);
	}

	public void visit(Hierarchical entity) {
		visit((IActionsEntity) entity);
		visit((FillStrategy) entity);
	}

	public void visit(NamingStrategy entity) {
	}

	public void visit(FullName entity) {
		visit((IActionsEntity) entity);
		visit((NamingStrategy) entity);
	}

	public void visit(DistinctPrefix entity) {
		visit((IActionsEntity) entity);
		visit((NamingStrategy) entity);
	}

	public void visit(URI entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Namespace entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Name entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Version entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Label entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Text entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Icon entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(Size entity) {
		visit((IActionsEntity) entity);
	}

	public void visit(ActionKind entity) {
		visit((IActionsEntity) entity);
	}
}
