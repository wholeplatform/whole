package org.whole.lang.actions.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.actions.model.*;

/** 
 * @generator Whole
 */
public interface IActionsVisitor extends IVisitor {
	public void visit(LanguageActionFactory entity);

	public void visit(ToolbarActions entity);

	public void visit(ContextMenuActions entity);

	public void visit(MenuActions entity);

	public void visit(Actions entity);

	public void visit(SeparatedAction entity);

	public void visit(GroupAction entity);

	public void visit(SubgroupAction entity);

	public void visit(CustomAction entity);

	public void visit(PerformAction entity);

	public void visit(TemplateAction entity);

	public void visit(FactoryAction entity);

	public void visit(SimpleAction entity);

	public void visit(GuardedAction entity);

	public void visit(Configuration entity);

	public void visit(ActionCall entity);

	public void visit(Flat entity);

	public void visit(Hierarchical entity);

	public void visit(FullName entity);

	public void visit(DistinctPrefix entity);

	public void visit(URI entity);

	public void visit(Namespace entity);

	public void visit(Name entity);

	public void visit(Version entity);

	public void visit(Label entity);

	public void visit(Text entity);

	public void visit(Icon entity);

	public void visit(Size entity);

	public void visit(ActionKind entity);
}
