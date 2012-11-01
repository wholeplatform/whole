package org.whole.lang.actions.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.actions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class ActionsIdentitySwitchVisitor extends AbstractVisitor
		implements IActionsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case ActionsEntityDescriptorEnum.LanguageActionFactory_ord:
			visit((LanguageActionFactory) entity);
			break;
		case ActionsEntityDescriptorEnum.ToolbarActions_ord:
			visit((ToolbarActions) entity);
			break;
		case ActionsEntityDescriptorEnum.ContextMenuActions_ord:
			visit((ContextMenuActions) entity);
			break;
		case ActionsEntityDescriptorEnum.MenuActions_ord:
			visit((MenuActions) entity);
			break;
		case ActionsEntityDescriptorEnum.Actions_ord:
			visit((Actions) entity);
			break;
		case ActionsEntityDescriptorEnum.SeparatedAction_ord:
			visit((SeparatedAction) entity);
			break;
		case ActionsEntityDescriptorEnum.GroupAction_ord:
			visit((GroupAction) entity);
			break;
		case ActionsEntityDescriptorEnum.SubgroupAction_ord:
			visit((SubgroupAction) entity);
			break;
		case ActionsEntityDescriptorEnum.CustomAction_ord:
			visit((CustomAction) entity);
			break;
		case ActionsEntityDescriptorEnum.PerformAction_ord:
			visit((PerformAction) entity);
			break;
		case ActionsEntityDescriptorEnum.TemplateAction_ord:
			visit((TemplateAction) entity);
			break;
		case ActionsEntityDescriptorEnum.FactoryAction_ord:
			visit((FactoryAction) entity);
			break;
		case ActionsEntityDescriptorEnum.SimpleAction_ord:
			visit((SimpleAction) entity);
			break;
		case ActionsEntityDescriptorEnum.GuardedAction_ord:
			visit((GuardedAction) entity);
			break;
		case ActionsEntityDescriptorEnum.Configuration_ord:
			visit((Configuration) entity);
			break;
		case ActionsEntityDescriptorEnum.ActionCall_ord:
			visit((ActionCall) entity);
			break;
		case ActionsEntityDescriptorEnum.Flat_ord:
			visit((Flat) entity);
			break;
		case ActionsEntityDescriptorEnum.Hierarchical_ord:
			visit((Hierarchical) entity);
			break;
		case ActionsEntityDescriptorEnum.FullName_ord:
			visit((FullName) entity);
			break;
		case ActionsEntityDescriptorEnum.DistinctPrefix_ord:
			visit((DistinctPrefix) entity);
			break;
		case ActionsEntityDescriptorEnum.URI_ord:
			visit((URI) entity);
			break;
		case ActionsEntityDescriptorEnum.Namespace_ord:
			visit((Namespace) entity);
			break;
		case ActionsEntityDescriptorEnum.Name_ord:
			visit((Name) entity);
			break;
		case ActionsEntityDescriptorEnum.Version_ord:
			visit((Version) entity);
			break;
		case ActionsEntityDescriptorEnum.Label_ord:
			visit((Label) entity);
			break;
		case ActionsEntityDescriptorEnum.Text_ord:
			visit((Text) entity);
			break;
		case ActionsEntityDescriptorEnum.Icon_ord:
			visit((Icon) entity);
			break;
		case ActionsEntityDescriptorEnum.Size_ord:
			visit((Size) entity);
			break;
		case ActionsEntityDescriptorEnum.ActionKind_ord:
			visit((ActionKind) entity);
			break;
		}
	}
}
