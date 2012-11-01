package org.whole.lang.actions.visitors;

import org.whole.lang.actions.visitors.ActionsIdentityUnaryVisitor;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ActionsTraverseAllChildrenVisitor extends
		ActionsIdentityUnaryVisitor<IActionsVisitor> {
	public ActionsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public ActionsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(LanguageActionFactory entity) {
		entity.getUri().accept(wGetVisitor1());
		entity.getNamespace().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getVersion().accept(wGetVisitor1());
		entity.getTargetLanguage().accept(wGetVisitor1());
		entity.getToolbarActions().accept(wGetVisitor1());
		entity.getContextMenuActions().accept(wGetVisitor1());
	}

	public void visit(ToolbarActions entity) {
		entity.getValidatorAction().accept(wGetVisitor1());
		entity.getNormalizerAction().accept(wGetVisitor1());
		entity.getPrettyPrinterAction().accept(wGetVisitor1());
		entity.getInterpreterAction().accept(wGetVisitor1());
		entity.getGeneratorAction().accept(wGetVisitor1());
	}

	public void visit(ContextMenuActions entity) {
		entity.getSourceMenuActions().accept(wGetVisitor1());
		entity.getRefactorMenuActions().accept(wGetVisitor1());
		entity.getTranslateMenuActions().accept(wGetVisitor1());
		entity.getAnalyzeMenuActions().accept(wGetVisitor1());
		entity.getMigrateMenuActions().accept(wGetVisitor1());
		entity.getValueAssistActions().accept(wGetVisitor1());
	}

	public void visit(MenuActions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Actions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(SeparatedAction entity) {
		entity.getAction().accept(wGetVisitor1());
	}

	public void visit(GroupAction entity) {
		entity.getIcon().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getFillStrategy().accept(wGetVisitor1());
		entity.getActions().accept(wGetVisitor1());
	}

	public void visit(SubgroupAction entity) {
		entity.getIcon().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getFillStrategy().accept(wGetVisitor1());
		entity.getActions().accept(wGetVisitor1());
	}

	public void visit(PerformAction entity) {
		entity.getIcon().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getKind().accept(wGetVisitor1());
		entity.getEnablerPredicate().accept(wGetVisitor1());
		entity.getConfiguration().accept(wGetVisitor1());
		entity.getTransformation().accept(wGetVisitor1());
	}

	public void visit(TemplateAction entity) {
		entity.getIcon().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getKind().accept(wGetVisitor1());
		entity.getEnablerPredicate().accept(wGetVisitor1());
		entity.getConfiguration().accept(wGetVisitor1());
		entity.getTransformation().accept(wGetVisitor1());
	}

	public void visit(FactoryAction entity) {
		entity.getTransformation().accept(wGetVisitor1());
	}

	public void visit(SimpleAction entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getTransformation().accept(wGetVisitor1());
	}

	public void visit(GuardedAction entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getTransformation().accept(wGetVisitor1());
		entity.getEnablerPredicate().accept(wGetVisitor1());
	}

	public void visit(Configuration entity) {
		entity.getVariabilityModel().accept(wGetVisitor1());
		entity.getValidator().accept(wGetVisitor1());
		entity.getBindingsGenerator().accept(wGetVisitor1());
		entity.getDialog().accept(wGetVisitor1());
	}

	public void visit(ActionCall entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getSelectedEntities().accept(wGetVisitor1());
	}

	public void visit(Hierarchical entity) {
		entity.getNamingStrategy().accept(wGetVisitor1());
		entity.getSplitSize().accept(wGetVisitor1());
	}
}
