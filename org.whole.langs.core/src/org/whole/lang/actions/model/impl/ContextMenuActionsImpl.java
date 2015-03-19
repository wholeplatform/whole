package org.whole.lang.actions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.actions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ContextMenuActionsImpl extends AbstractSimpleEntity implements
		ContextMenuActions {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ContextMenuActions> wGetEntityDescriptor() {
		return ActionsEntityDescriptorEnum.ContextMenuActions;
	}

	public int wGetEntityOrd() {
		return ActionsEntityDescriptorEnum.ContextMenuActions_ord;
	}

	public void accept(IActionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private MenuActions sourceMenuActions;

	public MenuActions getSourceMenuActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.sourceMenuActions,
				sourceMenuActions);
	}

	public void setSourceMenuActions(MenuActions sourceMenuActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.sourceMenuActions,
				this.sourceMenuActions,
				this.sourceMenuActions = sourceMenuActions);
	}

	private MenuActions refactorMenuActions;

	public MenuActions getRefactorMenuActions() {
		return notifyRequested(
				ActionsFeatureDescriptorEnum.refactorMenuActions,
				refactorMenuActions);
	}

	public void setRefactorMenuActions(MenuActions refactorMenuActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.refactorMenuActions,
				this.refactorMenuActions,
				this.refactorMenuActions = refactorMenuActions);
	}

	private MenuActions translateMenuActions;

	public MenuActions getTranslateMenuActions() {
		return notifyRequested(
				ActionsFeatureDescriptorEnum.translateMenuActions,
				translateMenuActions);
	}

	public void setTranslateMenuActions(MenuActions translateMenuActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.translateMenuActions,
				this.translateMenuActions,
				this.translateMenuActions = translateMenuActions);
	}

	private MenuActions analyzeMenuActions;

	public MenuActions getAnalyzeMenuActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.analyzeMenuActions,
				analyzeMenuActions);
	}

	public void setAnalyzeMenuActions(MenuActions analyzeMenuActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.analyzeMenuActions,
				this.analyzeMenuActions,
				this.analyzeMenuActions = analyzeMenuActions);
	}

	private MenuActions migrateMenuActions;

	public MenuActions getMigrateMenuActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.migrateMenuActions,
				migrateMenuActions);
	}

	public void setMigrateMenuActions(MenuActions migrateMenuActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.migrateMenuActions,
				this.migrateMenuActions,
				this.migrateMenuActions = migrateMenuActions);
	}

	private SimpleAction valueAssistActions;

	public SimpleAction getValueAssistActions() {
		return notifyRequested(ActionsFeatureDescriptorEnum.valueAssistActions,
				valueAssistActions);
	}

	public void setValueAssistActions(SimpleAction valueAssistActions) {
		notifyChanged(ActionsFeatureDescriptorEnum.valueAssistActions,
				this.valueAssistActions,
				this.valueAssistActions = valueAssistActions);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSourceMenuActions().wGetAdaptee(false);
		case 1:
			return getRefactorMenuActions().wGetAdaptee(false);
		case 2:
			return getTranslateMenuActions().wGetAdaptee(false);
		case 3:
			return getAnalyzeMenuActions().wGetAdaptee(false);
		case 4:
			return getMigrateMenuActions().wGetAdaptee(false);
		case 5:
			return getValueAssistActions().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSourceMenuActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions));
			break;
		case 1:
			setRefactorMenuActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions));
			break;
		case 2:
			setTranslateMenuActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions));
			break;
		case 3:
			setAnalyzeMenuActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions));
			break;
		case 4:
			setMigrateMenuActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.MenuActions));
			break;
		case 5:
			setValueAssistActions(value
					.wGetAdapter(ActionsEntityDescriptorEnum.SimpleAction));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
