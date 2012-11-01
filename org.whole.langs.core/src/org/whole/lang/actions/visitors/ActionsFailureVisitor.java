package org.whole.lang.actions.visitors;

import org.whole.lang.actions.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class ActionsFailureVisitor extends ActionsIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(LanguageActionFactory entity) {
		throw new VisitException();
	}

	public void visit(ToolbarActions entity) {
		throw new VisitException();
	}

	public void visit(ContextMenuActions entity) {
		throw new VisitException();
	}

	public void visit(MenuActions entity) {
		throw new VisitException();
	}

	public void visit(Actions entity) {
		throw new VisitException();
	}

	public void visit(SeparatedAction entity) {
		throw new VisitException();
	}

	public void visit(GroupAction entity) {
		throw new VisitException();
	}

	public void visit(SubgroupAction entity) {
		throw new VisitException();
	}

	public void visit(CustomAction entity) {
		throw new VisitException();
	}

	public void visit(PerformAction entity) {
		throw new VisitException();
	}

	public void visit(TemplateAction entity) {
		throw new VisitException();
	}

	public void visit(FactoryAction entity) {
		throw new VisitException();
	}

	public void visit(SimpleAction entity) {
		throw new VisitException();
	}

	public void visit(GuardedAction entity) {
		throw new VisitException();
	}

	public void visit(Configuration entity) {
		throw new VisitException();
	}

	public void visit(ActionCall entity) {
		throw new VisitException();
	}

	public void visit(Flat entity) {
		throw new VisitException();
	}

	public void visit(Hierarchical entity) {
		throw new VisitException();
	}

	public void visit(FullName entity) {
		throw new VisitException();
	}

	public void visit(DistinctPrefix entity) {
		throw new VisitException();
	}

	public void visit(URI entity) {
		throw new VisitException();
	}

	public void visit(Namespace entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(Version entity) {
		throw new VisitException();
	}

	public void visit(Label entity) {
		throw new VisitException();
	}

	public void visit(Text entity) {
		throw new VisitException();
	}

	public void visit(Icon entity) {
		throw new VisitException();
	}

	public void visit(Size entity) {
		throw new VisitException();
	}

	public void visit(ActionKind entity) {
		throw new VisitException();
	}
}
