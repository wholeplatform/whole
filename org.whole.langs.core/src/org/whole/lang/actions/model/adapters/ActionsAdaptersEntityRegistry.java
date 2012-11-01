package org.whole.lang.actions.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ActionsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public ActionsAdaptersEntityRegistry() {
		super(ActionsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new LanguageActionFactoryAdapter());
		put(new ToolbarActionsAdapter());
		put(new ContextMenuActionsAdapter());
		put(new MenuActionsAdapter());
		put(new ActionsAdapter());
		put(new ActionAdapter());
		put(new SeparatedActionAdapter());
		put(new GroupActionAdapter());
		put(new SubgroupActionAdapter());
		put(new CustomActionAdapter());
		put(new PerformActionAdapter());
		put(new TemplateActionAdapter());
		put(new FactoryActionAdapter());
		put(new SimpleActionAdapter());
		put(new GuardedActionAdapter());
		put(new ConfigurationAdapter());
		put(new VariabilityModelAdapter());
		put(new DialogAdapter());
		put(new PredicateAdapter());
		put(new TransformationAdapter());
		put(new ActionCallAdapter());
		put(new SelectedEntitiesAdapter());
		put(new FillStrategyAdapter());
		put(new FlatAdapter());
		put(new HierarchicalAdapter());
		put(new NamingStrategyAdapter());
		put(new FullNameAdapter());
		put(new DistinctPrefixAdapter());
		put(new URIAdapter());
		put(new NamespaceAdapter());
		put(new NameAdapter());
		put(new VersionAdapter());
		put(new LabelAdapter());
		put(new TextAdapter());
		put(new IconAdapter());
		put(new SizeAdapter());
		put(new ActionKindAdapter());
	}
}
