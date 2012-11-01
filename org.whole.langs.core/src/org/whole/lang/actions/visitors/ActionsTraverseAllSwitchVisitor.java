package org.whole.lang.actions.visitors;

import org.whole.lang.actions.visitors.ActionsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.actions.model.*;

/** 
 * @generator Whole
 */
public class ActionsTraverseAllSwitchVisitor extends
		ActionsIdentityUnaryVisitor<IVisitor> {
	public ActionsTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(LanguageActionFactory entity) {
		wGetVisitor1().visit(entity.getUri());
		wGetVisitor1().visit(entity.getNamespace());
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getVersion());
		wGetVisitor1().visit(entity.getTargetLanguage());
		wGetVisitor1().visit(entity.getToolbarActions());
		wGetVisitor1().visit(entity.getContextMenuActions());
	}

	public void visit(ToolbarActions entity) {
		wGetVisitor1().visit(entity.getValidatorAction());
		wGetVisitor1().visit(entity.getNormalizerAction());
		wGetVisitor1().visit(entity.getPrettyPrinterAction());
		wGetVisitor1().visit(entity.getInterpreterAction());
		wGetVisitor1().visit(entity.getGeneratorAction());
	}

	public void visit(ContextMenuActions entity) {
		wGetVisitor1().visit(entity.getSourceMenuActions());
		wGetVisitor1().visit(entity.getRefactorMenuActions());
		wGetVisitor1().visit(entity.getTranslateMenuActions());
		wGetVisitor1().visit(entity.getAnalyzeMenuActions());
		wGetVisitor1().visit(entity.getMigrateMenuActions());
		wGetVisitor1().visit(entity.getValueAssistActions());
	}

	public void visit(MenuActions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(Actions entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(SeparatedAction entity) {
		wGetVisitor1().visit(entity.getAction());
	}

	public void visit(GroupAction entity) {
		wGetVisitor1().visit(entity.getIcon());
		wGetVisitor1().visit(entity.getText());
		wGetVisitor1().visit(entity.getFillStrategy());
		wGetVisitor1().visit(entity.getActions());
	}

	public void visit(SubgroupAction entity) {
		wGetVisitor1().visit(entity.getIcon());
		wGetVisitor1().visit(entity.getText());
		wGetVisitor1().visit(entity.getFillStrategy());
		wGetVisitor1().visit(entity.getActions());
	}

	public void visit(PerformAction entity) {
		wGetVisitor1().visit(entity.getIcon());
		wGetVisitor1().visit(entity.getText());
		wGetVisitor1().visit(entity.getKind());
		wGetVisitor1().visit(entity.getEnablerPredicate());
		wGetVisitor1().visit(entity.getConfiguration());
		wGetVisitor1().visit(entity.getTransformation());
	}

	public void visit(TemplateAction entity) {
		wGetVisitor1().visit(entity.getIcon());
		wGetVisitor1().visit(entity.getText());
		wGetVisitor1().visit(entity.getKind());
		wGetVisitor1().visit(entity.getEnablerPredicate());
		wGetVisitor1().visit(entity.getConfiguration());
		wGetVisitor1().visit(entity.getTransformation());
	}

	public void visit(FactoryAction entity) {
		wGetVisitor1().visit(entity.getTransformation());
	}

	public void visit(SimpleAction entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTransformation());
	}

	public void visit(GuardedAction entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getTransformation());
		wGetVisitor1().visit(entity.getEnablerPredicate());
	}

	public void visit(Configuration entity) {
		wGetVisitor1().visit(entity.getVariabilityModel());
		wGetVisitor1().visit(entity.getValidator());
		wGetVisitor1().visit(entity.getBindingsGenerator());
		wGetVisitor1().visit(entity.getDialog());
	}

	public void visit(ActionCall entity) {
		wGetVisitor1().visit(entity.getName());
		wGetVisitor1().visit(entity.getSelectedEntities());
	}

	public void visit(Hierarchical entity) {
		wGetVisitor1().visit(entity.getNamingStrategy());
		wGetVisitor1().visit(entity.getSplitSize());
	}
}
