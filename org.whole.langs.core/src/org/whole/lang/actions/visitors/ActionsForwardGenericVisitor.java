package org.whole.lang.actions.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ActionsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IActionsVisitor {
	public ActionsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LanguageActionFactory entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ToolbarActions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ContextMenuActions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(MenuActions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Actions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SeparatedAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(GroupAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SubgroupAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CustomAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PerformAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TemplateAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FactoryAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SimpleAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(GuardedAction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Configuration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ActionCall entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Flat entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Hierarchical entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FullName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DistinctPrefix entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(URI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Label entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Text entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Icon entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Size entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ActionKind entity) {
		wGetVisitor1().visit(entity);
	}
}
