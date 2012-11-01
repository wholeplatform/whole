package org.whole.lang.actions.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.actions.model.ActionKindEnum.Value;

/** 
 * @generator Whole
 */
public class ActionsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IActionsBuilder specificBuilder;

	public ActionsGenericBuilderAdapter(IActionsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public ActionsGenericBuilderAdapter(IActionsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case ActionsFeatureDescriptorEnum.uri_ord:
			specificBuilder.uri();
			break;
		case ActionsFeatureDescriptorEnum.namespace_ord:
			specificBuilder.namespace();
			break;
		case ActionsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case ActionsFeatureDescriptorEnum.version_ord:
			specificBuilder.version();
			break;
		case ActionsFeatureDescriptorEnum.targetLanguage_ord:
			specificBuilder.targetLanguage();
			break;
		case ActionsFeatureDescriptorEnum.toolbarActions_ord:
			specificBuilder.toolbarActions();
			break;
		case ActionsFeatureDescriptorEnum.contextMenuActions_ord:
			specificBuilder.contextMenuActions();
			break;
		case ActionsFeatureDescriptorEnum.validatorAction_ord:
			specificBuilder.validatorAction();
			break;
		case ActionsFeatureDescriptorEnum.normalizerAction_ord:
			specificBuilder.normalizerAction();
			break;
		case ActionsFeatureDescriptorEnum.prettyPrinterAction_ord:
			specificBuilder.prettyPrinterAction();
			break;
		case ActionsFeatureDescriptorEnum.interpreterAction_ord:
			specificBuilder.interpreterAction();
			break;
		case ActionsFeatureDescriptorEnum.generatorAction_ord:
			specificBuilder.generatorAction();
			break;
		case ActionsFeatureDescriptorEnum.sourceMenuActions_ord:
			specificBuilder.sourceMenuActions();
			break;
		case ActionsFeatureDescriptorEnum.refactorMenuActions_ord:
			specificBuilder.refactorMenuActions();
			break;
		case ActionsFeatureDescriptorEnum.translateMenuActions_ord:
			specificBuilder.translateMenuActions();
			break;
		case ActionsFeatureDescriptorEnum.analyzeMenuActions_ord:
			specificBuilder.analyzeMenuActions();
			break;
		case ActionsFeatureDescriptorEnum.migrateMenuActions_ord:
			specificBuilder.migrateMenuActions();
			break;
		case ActionsFeatureDescriptorEnum.valueAssistActions_ord:
			specificBuilder.valueAssistActions();
			break;
		case ActionsFeatureDescriptorEnum.action_ord:
			specificBuilder.action();
			break;
		case ActionsFeatureDescriptorEnum.icon_ord:
			specificBuilder.icon();
			break;
		case ActionsFeatureDescriptorEnum.text_ord:
			specificBuilder.text();
			break;
		case ActionsFeatureDescriptorEnum.fillStrategy_ord:
			specificBuilder.fillStrategy();
			break;
		case ActionsFeatureDescriptorEnum.actions_ord:
			specificBuilder.actions();
			break;
		case ActionsFeatureDescriptorEnum.kind_ord:
			specificBuilder.kind();
			break;
		case ActionsFeatureDescriptorEnum.enablerPredicate_ord:
			specificBuilder.enablerPredicate();
			break;
		case ActionsFeatureDescriptorEnum.configuration_ord:
			specificBuilder.configuration();
			break;
		case ActionsFeatureDescriptorEnum.transformation_ord:
			specificBuilder.transformation();
			break;
		case ActionsFeatureDescriptorEnum.variabilityModel_ord:
			specificBuilder.variabilityModel();
			break;
		case ActionsFeatureDescriptorEnum.validator_ord:
			specificBuilder.validator();
			break;
		case ActionsFeatureDescriptorEnum.bindingsGenerator_ord:
			specificBuilder.bindingsGenerator();
			break;
		case ActionsFeatureDescriptorEnum.dialog_ord:
			specificBuilder.dialog();
			break;
		case ActionsFeatureDescriptorEnum.selectedEntities_ord:
			specificBuilder.selectedEntities();
			break;
		case ActionsFeatureDescriptorEnum.namingStrategy_ord:
			specificBuilder.namingStrategy();
			break;
		case ActionsFeatureDescriptorEnum.splitSize_ord:
			specificBuilder.splitSize();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.LanguageActionFactory_ord:
			specificBuilder.LanguageActionFactory();
			break;
		case ActionsEntityDescriptorEnum.ToolbarActions_ord:
			specificBuilder.ToolbarActions();
			break;
		case ActionsEntityDescriptorEnum.ContextMenuActions_ord:
			specificBuilder.ContextMenuActions();
			break;
		case ActionsEntityDescriptorEnum.MenuActions_ord:
			specificBuilder.MenuActions();
			break;
		case ActionsEntityDescriptorEnum.Actions_ord:
			specificBuilder.Actions();
			break;
		case ActionsEntityDescriptorEnum.SeparatedAction_ord:
			specificBuilder.SeparatedAction();
			break;
		case ActionsEntityDescriptorEnum.GroupAction_ord:
			specificBuilder.GroupAction();
			break;
		case ActionsEntityDescriptorEnum.SubgroupAction_ord:
			specificBuilder.SubgroupAction();
			break;
		case ActionsEntityDescriptorEnum.PerformAction_ord:
			specificBuilder.PerformAction();
			break;
		case ActionsEntityDescriptorEnum.TemplateAction_ord:
			specificBuilder.TemplateAction();
			break;
		case ActionsEntityDescriptorEnum.FactoryAction_ord:
			specificBuilder.FactoryAction();
			break;
		case ActionsEntityDescriptorEnum.SimpleAction_ord:
			specificBuilder.SimpleAction();
			break;
		case ActionsEntityDescriptorEnum.GuardedAction_ord:
			specificBuilder.GuardedAction();
			break;
		case ActionsEntityDescriptorEnum.Configuration_ord:
			specificBuilder.Configuration();
			break;
		case ActionsEntityDescriptorEnum.ActionCall_ord:
			specificBuilder.ActionCall();
			break;
		case ActionsEntityDescriptorEnum.Flat_ord:
			specificBuilder.Flat();
			break;
		case ActionsEntityDescriptorEnum.Hierarchical_ord:
			specificBuilder.Hierarchical();
			break;
		case ActionsEntityDescriptorEnum.FullName_ord:
			specificBuilder.FullName();
			break;
		case ActionsEntityDescriptorEnum.DistinctPrefix_ord:
			specificBuilder.DistinctPrefix();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.LanguageActionFactory_ord:
			specificBuilder.LanguageActionFactory_();
			break;
		case ActionsEntityDescriptorEnum.ToolbarActions_ord:
			specificBuilder.ToolbarActions_();
			break;
		case ActionsEntityDescriptorEnum.ContextMenuActions_ord:
			specificBuilder.ContextMenuActions_();
			break;
		case ActionsEntityDescriptorEnum.MenuActions_ord:
			specificBuilder.MenuActions_();
			break;
		case ActionsEntityDescriptorEnum.Actions_ord:
			specificBuilder.Actions_();
			break;
		case ActionsEntityDescriptorEnum.SeparatedAction_ord:
			specificBuilder.SeparatedAction_();
			break;
		case ActionsEntityDescriptorEnum.GroupAction_ord:
			specificBuilder.GroupAction_();
			break;
		case ActionsEntityDescriptorEnum.SubgroupAction_ord:
			specificBuilder.SubgroupAction_();
			break;
		case ActionsEntityDescriptorEnum.PerformAction_ord:
			specificBuilder.PerformAction_();
			break;
		case ActionsEntityDescriptorEnum.TemplateAction_ord:
			specificBuilder.TemplateAction_();
			break;
		case ActionsEntityDescriptorEnum.FactoryAction_ord:
			specificBuilder.FactoryAction_();
			break;
		case ActionsEntityDescriptorEnum.SimpleAction_ord:
			specificBuilder.SimpleAction_();
			break;
		case ActionsEntityDescriptorEnum.GuardedAction_ord:
			specificBuilder.GuardedAction_();
			break;
		case ActionsEntityDescriptorEnum.Configuration_ord:
			specificBuilder.Configuration_();
			break;
		case ActionsEntityDescriptorEnum.ActionCall_ord:
			specificBuilder.ActionCall_();
			break;
		case ActionsEntityDescriptorEnum.Flat_ord:
			specificBuilder.Flat_();
			break;
		case ActionsEntityDescriptorEnum.Hierarchical_ord:
			specificBuilder.Hierarchical_();
			break;
		case ActionsEntityDescriptorEnum.FullName_ord:
			specificBuilder.FullName_();
			break;
		case ActionsEntityDescriptorEnum.DistinctPrefix_ord:
			specificBuilder.DistinctPrefix_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.LanguageActionFactory_ord:
			specificBuilder._LanguageActionFactory();
			break;
		case ActionsEntityDescriptorEnum.ToolbarActions_ord:
			specificBuilder._ToolbarActions();
			break;
		case ActionsEntityDescriptorEnum.ContextMenuActions_ord:
			specificBuilder._ContextMenuActions();
			break;
		case ActionsEntityDescriptorEnum.MenuActions_ord:
			specificBuilder._MenuActions();
			break;
		case ActionsEntityDescriptorEnum.Actions_ord:
			specificBuilder._Actions();
			break;
		case ActionsEntityDescriptorEnum.SeparatedAction_ord:
			specificBuilder._SeparatedAction();
			break;
		case ActionsEntityDescriptorEnum.GroupAction_ord:
			specificBuilder._GroupAction();
			break;
		case ActionsEntityDescriptorEnum.SubgroupAction_ord:
			specificBuilder._SubgroupAction();
			break;
		case ActionsEntityDescriptorEnum.PerformAction_ord:
			specificBuilder._PerformAction();
			break;
		case ActionsEntityDescriptorEnum.TemplateAction_ord:
			specificBuilder._TemplateAction();
			break;
		case ActionsEntityDescriptorEnum.FactoryAction_ord:
			specificBuilder._FactoryAction();
			break;
		case ActionsEntityDescriptorEnum.SimpleAction_ord:
			specificBuilder._SimpleAction();
			break;
		case ActionsEntityDescriptorEnum.GuardedAction_ord:
			specificBuilder._GuardedAction();
			break;
		case ActionsEntityDescriptorEnum.Configuration_ord:
			specificBuilder._Configuration();
			break;
		case ActionsEntityDescriptorEnum.ActionCall_ord:
			specificBuilder._ActionCall();
			break;
		case ActionsEntityDescriptorEnum.Flat_ord:
			specificBuilder._Flat();
			break;
		case ActionsEntityDescriptorEnum.Hierarchical_ord:
			specificBuilder._Hierarchical();
			break;
		case ActionsEntityDescriptorEnum.FullName_ord:
			specificBuilder._FullName();
			break;
		case ActionsEntityDescriptorEnum.DistinctPrefix_ord:
			specificBuilder._DistinctPrefix();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.MenuActions_ord:
			specificBuilder.MenuActions_(initialCapacity);
			break;
		case ActionsEntityDescriptorEnum.Actions_ord:
			specificBuilder.Actions_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.CustomAction_ord:
			specificBuilder.CustomAction(value);
			break;
		case ActionsEntityDescriptorEnum.Icon_ord:
			specificBuilder.Icon(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.URI_ord:
			specificBuilder.URI(value);
			break;
		case ActionsEntityDescriptorEnum.Namespace_ord:
			specificBuilder.Namespace(value);
			break;
		case ActionsEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case ActionsEntityDescriptorEnum.Version_ord:
			specificBuilder.Version(value);
			break;
		case ActionsEntityDescriptorEnum.Label_ord:
			specificBuilder.Label(value);
			break;
		case ActionsEntityDescriptorEnum.Text_ord:
			specificBuilder.Text(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.Size_ord:
			specificBuilder.Size(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case ActionsEntityDescriptorEnum.ActionKind_ord:
			specificBuilder.ActionKind((Value) value);
			break;
		}
	}
}
