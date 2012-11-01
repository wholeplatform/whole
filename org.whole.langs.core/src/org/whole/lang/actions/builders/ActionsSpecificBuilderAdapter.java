package org.whole.lang.actions.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.model.ActionKindEnum;

/** 
 * @generator Whole
 */
public class ActionsSpecificBuilderAdapter extends GenericBuilderContext
		implements IActionsBuilder {
	public ActionsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public ActionsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void splitSize() {
		wFeature(ActionsFeatureDescriptorEnum.splitSize);
	}

	public void namingStrategy() {
		wFeature(ActionsFeatureDescriptorEnum.namingStrategy);
	}

	public void selectedEntities() {
		wFeature(ActionsFeatureDescriptorEnum.selectedEntities);
	}

	public void dialog() {
		wFeature(ActionsFeatureDescriptorEnum.dialog);
	}

	public void bindingsGenerator() {
		wFeature(ActionsFeatureDescriptorEnum.bindingsGenerator);
	}

	public void validator() {
		wFeature(ActionsFeatureDescriptorEnum.validator);
	}

	public void variabilityModel() {
		wFeature(ActionsFeatureDescriptorEnum.variabilityModel);
	}

	public void transformation() {
		wFeature(ActionsFeatureDescriptorEnum.transformation);
	}

	public void configuration() {
		wFeature(ActionsFeatureDescriptorEnum.configuration);
	}

	public void enablerPredicate() {
		wFeature(ActionsFeatureDescriptorEnum.enablerPredicate);
	}

	public void kind() {
		wFeature(ActionsFeatureDescriptorEnum.kind);
	}

	public void actions() {
		wFeature(ActionsFeatureDescriptorEnum.actions);
	}

	public void fillStrategy() {
		wFeature(ActionsFeatureDescriptorEnum.fillStrategy);
	}

	public void text() {
		wFeature(ActionsFeatureDescriptorEnum.text);
	}

	public void icon() {
		wFeature(ActionsFeatureDescriptorEnum.icon);
	}

	public void action() {
		wFeature(ActionsFeatureDescriptorEnum.action);
	}

	public void valueAssistActions() {
		wFeature(ActionsFeatureDescriptorEnum.valueAssistActions);
	}

	public void migrateMenuActions() {
		wFeature(ActionsFeatureDescriptorEnum.migrateMenuActions);
	}

	public void analyzeMenuActions() {
		wFeature(ActionsFeatureDescriptorEnum.analyzeMenuActions);
	}

	public void translateMenuActions() {
		wFeature(ActionsFeatureDescriptorEnum.translateMenuActions);
	}

	public void refactorMenuActions() {
		wFeature(ActionsFeatureDescriptorEnum.refactorMenuActions);
	}

	public void sourceMenuActions() {
		wFeature(ActionsFeatureDescriptorEnum.sourceMenuActions);
	}

	public void generatorAction() {
		wFeature(ActionsFeatureDescriptorEnum.generatorAction);
	}

	public void interpreterAction() {
		wFeature(ActionsFeatureDescriptorEnum.interpreterAction);
	}

	public void prettyPrinterAction() {
		wFeature(ActionsFeatureDescriptorEnum.prettyPrinterAction);
	}

	public void normalizerAction() {
		wFeature(ActionsFeatureDescriptorEnum.normalizerAction);
	}

	public void validatorAction() {
		wFeature(ActionsFeatureDescriptorEnum.validatorAction);
	}

	public void contextMenuActions() {
		wFeature(ActionsFeatureDescriptorEnum.contextMenuActions);
	}

	public void toolbarActions() {
		wFeature(ActionsFeatureDescriptorEnum.toolbarActions);
	}

	public void targetLanguage() {
		wFeature(ActionsFeatureDescriptorEnum.targetLanguage);
	}

	public void version() {
		wFeature(ActionsFeatureDescriptorEnum.version);
	}

	public void name() {
		wFeature(ActionsFeatureDescriptorEnum.name);
	}

	public void namespace() {
		wFeature(ActionsFeatureDescriptorEnum.namespace);
	}

	public void uri() {
		wFeature(ActionsFeatureDescriptorEnum.uri);
	}

	public void visit() {
	}

	public void LanguageActionFactory() {
		wEntity(ActionsEntityDescriptorEnum.LanguageActionFactory);
	}

	public void LanguageActionFactory_() {
		wEntity_(ActionsEntityDescriptorEnum.LanguageActionFactory);
	}

	public void _LanguageActionFactory() {
		_wEntity(ActionsEntityDescriptorEnum.LanguageActionFactory);
	}

	public void ToolbarActions() {
		wEntity(ActionsEntityDescriptorEnum.ToolbarActions);
	}

	public void ToolbarActions_() {
		wEntity_(ActionsEntityDescriptorEnum.ToolbarActions);
	}

	public void _ToolbarActions() {
		_wEntity(ActionsEntityDescriptorEnum.ToolbarActions);
	}

	public void ContextMenuActions() {
		wEntity(ActionsEntityDescriptorEnum.ContextMenuActions);
	}

	public void ContextMenuActions_() {
		wEntity_(ActionsEntityDescriptorEnum.ContextMenuActions);
	}

	public void _ContextMenuActions() {
		_wEntity(ActionsEntityDescriptorEnum.ContextMenuActions);
	}

	public void MenuActions() {
		wEntity(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void MenuActions_() {
		wEntity_(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void MenuActions_(int initialCapacity) {
		wEntity_(ActionsEntityDescriptorEnum.MenuActions, initialCapacity);
	}

	public void _MenuActions() {
		_wEntity(ActionsEntityDescriptorEnum.MenuActions);
	}

	public void Actions() {
		wEntity(ActionsEntityDescriptorEnum.Actions);
	}

	public void Actions_() {
		wEntity_(ActionsEntityDescriptorEnum.Actions);
	}

	public void Actions_(int initialCapacity) {
		wEntity_(ActionsEntityDescriptorEnum.Actions, initialCapacity);
	}

	public void _Actions() {
		_wEntity(ActionsEntityDescriptorEnum.Actions);
	}

	public void SeparatedAction() {
		wEntity(ActionsEntityDescriptorEnum.SeparatedAction);
	}

	public void SeparatedAction_() {
		wEntity_(ActionsEntityDescriptorEnum.SeparatedAction);
	}

	public void _SeparatedAction() {
		_wEntity(ActionsEntityDescriptorEnum.SeparatedAction);
	}

	public void GroupAction() {
		wEntity(ActionsEntityDescriptorEnum.GroupAction);
	}

	public void GroupAction_() {
		wEntity_(ActionsEntityDescriptorEnum.GroupAction);
	}

	public void _GroupAction() {
		_wEntity(ActionsEntityDescriptorEnum.GroupAction);
	}

	public void SubgroupAction() {
		wEntity(ActionsEntityDescriptorEnum.SubgroupAction);
	}

	public void SubgroupAction_() {
		wEntity_(ActionsEntityDescriptorEnum.SubgroupAction);
	}

	public void _SubgroupAction() {
		_wEntity(ActionsEntityDescriptorEnum.SubgroupAction);
	}

	public void CustomAction() {
		wEntity(ActionsEntityDescriptorEnum.CustomAction);
	}

	public void CustomAction(Object value) {
		wEntity(ActionsEntityDescriptorEnum.CustomAction, value);
	}

	public void CustomAction(String value) {
		wEntity(ActionsEntityDescriptorEnum.CustomAction, value);
	}

	public void PerformAction() {
		wEntity(ActionsEntityDescriptorEnum.PerformAction);
	}

	public void PerformAction_() {
		wEntity_(ActionsEntityDescriptorEnum.PerformAction);
	}

	public void _PerformAction() {
		_wEntity(ActionsEntityDescriptorEnum.PerformAction);
	}

	public void TemplateAction() {
		wEntity(ActionsEntityDescriptorEnum.TemplateAction);
	}

	public void TemplateAction_() {
		wEntity_(ActionsEntityDescriptorEnum.TemplateAction);
	}

	public void _TemplateAction() {
		_wEntity(ActionsEntityDescriptorEnum.TemplateAction);
	}

	public void FactoryAction() {
		wEntity(ActionsEntityDescriptorEnum.FactoryAction);
	}

	public void FactoryAction_() {
		wEntity_(ActionsEntityDescriptorEnum.FactoryAction);
	}

	public void _FactoryAction() {
		_wEntity(ActionsEntityDescriptorEnum.FactoryAction);
	}

	public void SimpleAction() {
		wEntity(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void SimpleAction_() {
		wEntity_(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void _SimpleAction() {
		_wEntity(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public void GuardedAction() {
		wEntity(ActionsEntityDescriptorEnum.GuardedAction);
	}

	public void GuardedAction_() {
		wEntity_(ActionsEntityDescriptorEnum.GuardedAction);
	}

	public void _GuardedAction() {
		_wEntity(ActionsEntityDescriptorEnum.GuardedAction);
	}

	public void Configuration() {
		wEntity(ActionsEntityDescriptorEnum.Configuration);
	}

	public void Configuration_() {
		wEntity_(ActionsEntityDescriptorEnum.Configuration);
	}

	public void _Configuration() {
		_wEntity(ActionsEntityDescriptorEnum.Configuration);
	}

	public void ActionCall() {
		wEntity(ActionsEntityDescriptorEnum.ActionCall);
	}

	public void ActionCall_() {
		wEntity_(ActionsEntityDescriptorEnum.ActionCall);
	}

	public void _ActionCall() {
		_wEntity(ActionsEntityDescriptorEnum.ActionCall);
	}

	public void Flat() {
		wEntity(ActionsEntityDescriptorEnum.Flat);
	}

	public void Flat_() {
		wEntity_(ActionsEntityDescriptorEnum.Flat);
	}

	public void _Flat() {
		_wEntity(ActionsEntityDescriptorEnum.Flat);
	}

	public void Hierarchical() {
		wEntity(ActionsEntityDescriptorEnum.Hierarchical);
	}

	public void Hierarchical_() {
		wEntity_(ActionsEntityDescriptorEnum.Hierarchical);
	}

	public void _Hierarchical() {
		_wEntity(ActionsEntityDescriptorEnum.Hierarchical);
	}

	public void FullName() {
		wEntity(ActionsEntityDescriptorEnum.FullName);
	}

	public void FullName_() {
		wEntity_(ActionsEntityDescriptorEnum.FullName);
	}

	public void _FullName() {
		_wEntity(ActionsEntityDescriptorEnum.FullName);
	}

	public void DistinctPrefix() {
		wEntity(ActionsEntityDescriptorEnum.DistinctPrefix);
	}

	public void DistinctPrefix_() {
		wEntity_(ActionsEntityDescriptorEnum.DistinctPrefix);
	}

	public void _DistinctPrefix() {
		_wEntity(ActionsEntityDescriptorEnum.DistinctPrefix);
	}

	public void URI() {
		wEntity(ActionsEntityDescriptorEnum.URI);
	}

	public void URI(String value) {
		wEntity(ActionsEntityDescriptorEnum.URI, value);
	}

	public void Namespace() {
		wEntity(ActionsEntityDescriptorEnum.Namespace);
	}

	public void Namespace(String value) {
		wEntity(ActionsEntityDescriptorEnum.Namespace, value);
	}

	public void Name() {
		wEntity(ActionsEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(ActionsEntityDescriptorEnum.Name, value);
	}

	public void Version() {
		wEntity(ActionsEntityDescriptorEnum.Version);
	}

	public void Version(String value) {
		wEntity(ActionsEntityDescriptorEnum.Version, value);
	}

	public void Label() {
		wEntity(ActionsEntityDescriptorEnum.Label);
	}

	public void Label(String value) {
		wEntity(ActionsEntityDescriptorEnum.Label, value);
	}

	public void Text() {
		wEntity(ActionsEntityDescriptorEnum.Text);
	}

	public void Text(String value) {
		wEntity(ActionsEntityDescriptorEnum.Text, value);
	}

	public void Icon() {
		wEntity(ActionsEntityDescriptorEnum.Icon);
	}

	public void Icon(Object value) {
		wEntity(ActionsEntityDescriptorEnum.Icon, value);
	}

	public void Icon(String value) {
		wEntity(ActionsEntityDescriptorEnum.Icon, value);
	}

	public void Size() {
		wEntity(ActionsEntityDescriptorEnum.Size);
	}

	public void Size(int value) {
		wEntity(ActionsEntityDescriptorEnum.Size, value);
	}

	public void ActionKind() {
		wEntity(ActionsEntityDescriptorEnum.ActionKind);
	}

	public void ActionKind(ActionKindEnum.Value value) {
		wEntity(ActionsEntityDescriptorEnum.ActionKind, value);
	}

	public void ActionKind(String value) {
		wEntity(ActionsEntityDescriptorEnum.ActionKind, value);
	}
}
