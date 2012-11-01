package org.whole.lang.actions.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ActionsImplEntityRegistry extends AbstractEntityRegistry {
	public ActionsImplEntityRegistry() {
		super(ActionsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new LanguageActionFactoryImpl());
		put(new ToolbarActionsImpl());
		put(new ContextMenuActionsImpl());
		put(new MenuActionsImpl());
		put(new ActionsImpl());
		put(new SeparatedActionImpl());
		put(new GroupActionImpl());
		put(new SubgroupActionImpl());
		put(new CustomActionImpl());
		put(new PerformActionImpl());
		put(new TemplateActionImpl());
		put(new FactoryActionImpl());
		put(new SimpleActionImpl());
		put(new GuardedActionImpl());
		put(new ConfigurationImpl());
		put(new ActionCallImpl());
		put(new FlatImpl());
		put(new HierarchicalImpl());
		put(new FullNameImpl());
		put(new DistinctPrefixImpl());
		put(new URIImpl());
		put(new NamespaceImpl());
		put(new NameImpl());
		put(new VersionImpl());
		put(new LabelImpl());
		put(new TextImpl());
		put(new IconImpl());
		put(new SizeImpl());
		put(new ActionKindImpl());
	}
}
