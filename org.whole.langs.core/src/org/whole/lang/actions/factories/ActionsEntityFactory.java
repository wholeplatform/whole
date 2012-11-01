package org.whole.lang.actions.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.actions.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ActionsEntityFactory extends GenericEntityFactory {
	public static final ActionsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static ActionsEntityFactory instance(IEntityRegistryProvider provider) {
		return new ActionsEntityFactory(provider);
	}

	protected ActionsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public LanguageActionFactory createLanguageActionFactory() {
		return create(ActionsEntityDescriptorEnum.LanguageActionFactory);
	}

	public LanguageActionFactory createLanguageActionFactory(URI uri,
			Namespace namespace, Name name, Version version,
			URI targetLanguage, ToolbarActions toolbarActions,
			ContextMenuActions contextMenuActions) {
		return create(ActionsEntityDescriptorEnum.LanguageActionFactory, uri,
				namespace, name, version, targetLanguage, toolbarActions,
				contextMenuActions);
	}

	public IEntityBuilder<LanguageActionFactory> buildLanguageActionFactory() {
		return new EntityBuilder<LanguageActionFactory>(
				create(ActionsEntityDescriptorEnum.LanguageActionFactory));
	}

	public ToolbarActions createToolbarActions() {
		return create(ActionsEntityDescriptorEnum.ToolbarActions);
	}

	public ToolbarActions createToolbarActions(SimpleAction validatorAction,
			SimpleAction normalizerAction, SimpleAction prettyPrinterAction,
			SimpleAction interpreterAction, SimpleAction generatorAction) {
		return create(ActionsEntityDescriptorEnum.ToolbarActions,
				validatorAction, normalizerAction, prettyPrinterAction,
				interpreterAction, generatorAction);
	}

	public IEntityBuilder<ToolbarActions> buildToolbarActions() {
		return new EntityBuilder<ToolbarActions>(
				create(ActionsEntityDescriptorEnum.ToolbarActions));
	}

	public ContextMenuActions createContextMenuActions() {
		return create(ActionsEntityDescriptorEnum.ContextMenuActions);
	}

	public ContextMenuActions createContextMenuActions(
			MenuActions sourceMenuActions, MenuActions refactorMenuActions,
			MenuActions translateMenuActions, MenuActions analyzeMenuActions,
			MenuActions migrateMenuActions, SimpleAction valueAssistActions) {
		return create(ActionsEntityDescriptorEnum.ContextMenuActions,
				sourceMenuActions, refactorMenuActions, translateMenuActions,
				analyzeMenuActions, migrateMenuActions, valueAssistActions);
	}

	public IEntityBuilder<ContextMenuActions> buildContextMenuActions() {
		return new EntityBuilder<ContextMenuActions>(
				create(ActionsEntityDescriptorEnum.ContextMenuActions));
	}

	public MenuActions createMenuActions() {
		return create(ActionsEntityDescriptorEnum.MenuActions);
	}

	public MenuActions createMenuActions(Action... entities) {
		return create(ActionsEntityDescriptorEnum.MenuActions,
				(IEntity[]) entities);
	}

	public MenuActions createMenuActions(int initialSize) {
		return clone(ActionsEntityDescriptorEnum.MenuActions, initialSize);
	}

	public Actions createActions() {
		return create(ActionsEntityDescriptorEnum.Actions);
	}

	public Actions createActions(Action... entities) {
		return create(ActionsEntityDescriptorEnum.Actions, (IEntity[]) entities);
	}

	public Actions createActions(int initialSize) {
		return clone(ActionsEntityDescriptorEnum.Actions, initialSize);
	}

	public SeparatedAction createSeparatedAction() {
		return create(ActionsEntityDescriptorEnum.SeparatedAction);
	}

	public SeparatedAction createSeparatedAction(Action action) {
		return create(ActionsEntityDescriptorEnum.SeparatedAction, action);
	}

	public GroupAction createGroupAction() {
		return create(ActionsEntityDescriptorEnum.GroupAction);
	}

	public GroupAction createGroupAction(Icon icon, Text text,
			FillStrategy fillStrategy, Actions actions) {
		return create(ActionsEntityDescriptorEnum.GroupAction, icon, text,
				fillStrategy, actions);
	}

	public IEntityBuilder<GroupAction> buildGroupAction() {
		return new EntityBuilder<GroupAction>(
				create(ActionsEntityDescriptorEnum.GroupAction));
	}

	public SubgroupAction createSubgroupAction() {
		return create(ActionsEntityDescriptorEnum.SubgroupAction);
	}

	public SubgroupAction createSubgroupAction(Icon icon, Text text,
			FillStrategy fillStrategy, Actions actions) {
		return create(ActionsEntityDescriptorEnum.SubgroupAction, icon, text,
				fillStrategy, actions);
	}

	public IEntityBuilder<SubgroupAction> buildSubgroupAction() {
		return new EntityBuilder<SubgroupAction>(
				create(ActionsEntityDescriptorEnum.SubgroupAction));
	}

	public CustomAction createCustomAction() {
		return create(ActionsEntityDescriptorEnum.CustomAction);
	}

	public CustomAction createCustomAction(Object value) {
		return create(ActionsEntityDescriptorEnum.CustomAction, value);
	}

	public PerformAction createPerformAction() {
		return create(ActionsEntityDescriptorEnum.PerformAction);
	}

	public PerformAction createPerformAction(Icon icon, Text text,
			ActionKind kind, Predicate enablerPredicate,
			Configuration configuration, Transformation transformation) {
		return create(ActionsEntityDescriptorEnum.PerformAction, icon, text,
				kind, enablerPredicate, configuration, transformation);
	}

	public IEntityBuilder<PerformAction> buildPerformAction() {
		return new EntityBuilder<PerformAction>(
				create(ActionsEntityDescriptorEnum.PerformAction));
	}

	public TemplateAction createTemplateAction() {
		return create(ActionsEntityDescriptorEnum.TemplateAction);
	}

	public TemplateAction createTemplateAction(Icon icon, Text text,
			ActionKind kind, Predicate enablerPredicate,
			Configuration configuration, Transformation transformation) {
		return create(ActionsEntityDescriptorEnum.TemplateAction, icon, text,
				kind, enablerPredicate, configuration, transformation);
	}

	public IEntityBuilder<TemplateAction> buildTemplateAction() {
		return new EntityBuilder<TemplateAction>(
				create(ActionsEntityDescriptorEnum.TemplateAction));
	}

	public FactoryAction createFactoryAction() {
		return create(ActionsEntityDescriptorEnum.FactoryAction);
	}

	public FactoryAction createFactoryAction(Transformation transformation) {
		return create(ActionsEntityDescriptorEnum.FactoryAction, transformation);
	}

	public SimpleAction createSimpleAction() {
		return create(ActionsEntityDescriptorEnum.SimpleAction);
	}

	public SimpleAction createSimpleAction(Label name,
			Transformation transformation) {
		return create(ActionsEntityDescriptorEnum.SimpleAction, name,
				transformation);
	}

	public IEntityBuilder<SimpleAction> buildSimpleAction() {
		return new EntityBuilder<SimpleAction>(
				create(ActionsEntityDescriptorEnum.SimpleAction));
	}

	public GuardedAction createGuardedAction() {
		return create(ActionsEntityDescriptorEnum.GuardedAction);
	}

	public GuardedAction createGuardedAction(Label name,
			Transformation transformation, Predicate enablerPredicate) {
		return create(ActionsEntityDescriptorEnum.GuardedAction, name,
				transformation, enablerPredicate);
	}

	public IEntityBuilder<GuardedAction> buildGuardedAction() {
		return new EntityBuilder<GuardedAction>(
				create(ActionsEntityDescriptorEnum.GuardedAction));
	}

	public Configuration createConfiguration() {
		return create(ActionsEntityDescriptorEnum.Configuration);
	}

	public Configuration createConfiguration(VariabilityModel variabilityModel,
			Predicate validator, Transformation bindingsGenerator, Dialog dialog) {
		return create(ActionsEntityDescriptorEnum.Configuration,
				variabilityModel, validator, bindingsGenerator, dialog);
	}

	public IEntityBuilder<Configuration> buildConfiguration() {
		return new EntityBuilder<Configuration>(
				create(ActionsEntityDescriptorEnum.Configuration));
	}

	public ActionCall createActionCall() {
		return create(ActionsEntityDescriptorEnum.ActionCall);
	}

	public ActionCall createActionCall(Label name,
			SelectedEntities selectedEntities) {
		return create(ActionsEntityDescriptorEnum.ActionCall, name,
				selectedEntities);
	}

	public IEntityBuilder<ActionCall> buildActionCall() {
		return new EntityBuilder<ActionCall>(
				create(ActionsEntityDescriptorEnum.ActionCall));
	}

	public Flat createFlat() {
		return create(ActionsEntityDescriptorEnum.Flat);
	}

	public Hierarchical createHierarchical() {
		return create(ActionsEntityDescriptorEnum.Hierarchical);
	}

	public Hierarchical createHierarchical(NamingStrategy namingStrategy,
			Size splitSize) {
		return create(ActionsEntityDescriptorEnum.Hierarchical, namingStrategy,
				splitSize);
	}

	public IEntityBuilder<Hierarchical> buildHierarchical() {
		return new EntityBuilder<Hierarchical>(
				create(ActionsEntityDescriptorEnum.Hierarchical));
	}

	public FullName createFullName() {
		return create(ActionsEntityDescriptorEnum.FullName);
	}

	public DistinctPrefix createDistinctPrefix() {
		return create(ActionsEntityDescriptorEnum.DistinctPrefix);
	}

	public URI createURI() {
		return create(ActionsEntityDescriptorEnum.URI);
	}

	public URI createURI(String value) {
		return create(ActionsEntityDescriptorEnum.URI, value);
	}

	public Namespace createNamespace() {
		return create(ActionsEntityDescriptorEnum.Namespace);
	}

	public Namespace createNamespace(String value) {
		return create(ActionsEntityDescriptorEnum.Namespace, value);
	}

	public Name createName() {
		return create(ActionsEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(ActionsEntityDescriptorEnum.Name, value);
	}

	public Version createVersion() {
		return create(ActionsEntityDescriptorEnum.Version);
	}

	public Version createVersion(String value) {
		return create(ActionsEntityDescriptorEnum.Version, value);
	}

	public Label createLabel() {
		return create(ActionsEntityDescriptorEnum.Label);
	}

	public Label createLabel(String value) {
		return create(ActionsEntityDescriptorEnum.Label, value);
	}

	public Text createText() {
		return create(ActionsEntityDescriptorEnum.Text);
	}

	public Text createText(String value) {
		return create(ActionsEntityDescriptorEnum.Text, value);
	}

	public Icon createIcon() {
		return create(ActionsEntityDescriptorEnum.Icon);
	}

	public Icon createIcon(Object value) {
		return create(ActionsEntityDescriptorEnum.Icon, value);
	}

	public Size createSize() {
		return create(ActionsEntityDescriptorEnum.Size);
	}

	public Size createSize(int value) {
		return create(ActionsEntityDescriptorEnum.Size, value);
	}

	public ActionKind createActionKind() {
		return create(ActionsEntityDescriptorEnum.ActionKind);
	}

	public ActionKind createActionKind(ActionKindEnum.Value value) {
		return create(ActionsEntityDescriptorEnum.ActionKind, value);
	}
}
