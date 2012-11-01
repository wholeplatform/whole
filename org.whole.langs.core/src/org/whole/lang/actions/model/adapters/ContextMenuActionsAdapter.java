package org.whole.lang.actions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ContextMenuActionsAdapter extends AbstractEntityAdapter implements
		ContextMenuActions {
	private static final long serialVersionUID = 1;

	public ContextMenuActionsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ContextMenuActionsAdapter() {
	}

	public void accept(IActionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ContextMenuActions> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ContextMenuActions;
	}

	public MenuActions getSourceMenuActions() {
		return wGet(ActionsFeatureDescriptorEnum.sourceMenuActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void setSourceMenuActions(MenuActions sourceMenuActions) {
		wSet(ActionsFeatureDescriptorEnum.sourceMenuActions, sourceMenuActions);
	}

	public MenuActions getRefactorMenuActions() {
		return wGet(ActionsFeatureDescriptorEnum.refactorMenuActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void setRefactorMenuActions(MenuActions refactorMenuActions) {
		wSet(ActionsFeatureDescriptorEnum.refactorMenuActions,
				refactorMenuActions);
	}

	public MenuActions getTranslateMenuActions() {
		return wGet(ActionsFeatureDescriptorEnum.translateMenuActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void setTranslateMenuActions(MenuActions translateMenuActions) {
		wSet(ActionsFeatureDescriptorEnum.translateMenuActions,
				translateMenuActions);
	}

	public MenuActions getAnalyzeMenuActions() {
		return wGet(ActionsFeatureDescriptorEnum.analyzeMenuActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void setAnalyzeMenuActions(MenuActions analyzeMenuActions) {
		wSet(ActionsFeatureDescriptorEnum.analyzeMenuActions,
				analyzeMenuActions);
	}

	public MenuActions getMigrateMenuActions() {
		return wGet(ActionsFeatureDescriptorEnum.migrateMenuActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void setMigrateMenuActions(MenuActions migrateMenuActions) {
		wSet(ActionsFeatureDescriptorEnum.migrateMenuActions,
				migrateMenuActions);
	}

	public SimpleAction getValueAssistActions() {
		return wGet(ActionsFeatureDescriptorEnum.valueAssistActions)
				.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void setValueAssistActions(SimpleAction valueAssistActions) {
		wSet(ActionsFeatureDescriptorEnum.valueAssistActions,
				valueAssistActions);
	}
}
