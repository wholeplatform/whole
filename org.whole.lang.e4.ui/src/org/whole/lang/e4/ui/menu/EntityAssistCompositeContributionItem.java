/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.e4.ui.menu;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractCompositeContributionItem;
import org.whole.lang.e4.ui.actions.ActionRegistry;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.menu.ActionContainer;
import org.whole.lang.ui.menu.ActionSet;
import org.whole.lang.ui.menu.FullMenuNameStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IItemContainer;
import org.whole.lang.ui.menu.MenuManagerSet;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class EntityAssistCompositeContributionItem extends AbstractCompositeContributionItem {
	protected ESelectionService selectionService;
	protected ActionRegistry actionRegistry;
	protected Comparator<IAction> comparator;

	public EntityAssistCompositeContributionItem(IEclipseContext context, ActionRegistry actionRegistry) {
		this.selectionService = context.get(ESelectionService.class);
		this.actionRegistry = actionRegistry;
		this.comparator = new Comparator<IAction>() {
			public int compare(IAction left, IAction right) {
				return left.getText().compareTo(right.getText());
			}
		};
	}

	protected IContributionItem[] getItems() {
		List<IContributionItem> items = new ArrayList<IContributionItem>();
		
		Object selection = selectionService.getSelection();
		if (!(selection instanceof IBindingManager))
			return new IContributionItem[0];

		IBindingManager bm = (IBindingManager) selection;
		IEntity selectedEntity = bm.wGet("primarySelectedEntity");
		ILanguageKit selectedLanguageKit = selectedEntity.wGetLanguageKit();

		
		List<MenuManager> menus = new ArrayList<MenuManager>();
		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			try {
				ImageDescriptor icon = ImageDescriptor.createFromURL(new URL(SELECT_LANGUAGE_ICON_URI));
				String label = ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit);
				MenuManager languageMenu = new MenuManager(label, icon, null);
				if (fillEntityAssistMenu(ActionContainer.create(languageMenu), selectedEntity, languageKit))
					menus.add(languageMenu);
			} catch (Exception e) {
			}
		}
		HierarchicalFillMenuStrategy.instance(FullMenuNameStrategy.instance())
				.fillMenu(MenuManagerListContainer.create(items),
						MenuManagerSet.create(menus.toArray(new MenuManager[menus.size()])), 0, menus.size());

		if (menus.size() > 0)
			items.add(new Separator());
		
		if (!fillEntityAssistMenu(ActionListContainer.create(items), selectedEntity, selectedLanguageKit))
			items.remove(items.size()-1);

		//TODO add text actions

		return items.toArray(new IContributionItem[items.size()]);
	}

	protected boolean fillEntityAssistMenu(IItemContainer<IAction, ImageDescriptor> container, IEntity selectedEntity, ILanguageKit lk) {
		boolean hasActions = false;

		int addElementNumber = 0;
		List<IAction> addActions = new ArrayList<IAction>();

		for (EntityDescriptor<?> ed : lk.getEntityDescriptorEnum())
			if (!ed.isAbstract() && EntityUtils.isAddable(selectedEntity, ed))
				addActions.add(actionRegistry.getAddEntityAction(ed));

		addElementNumber = addActions.size();
		Collections.sort(addActions, comparator);
		HierarchicalFillMenuStrategy.instance().fillMenu(
				container, ActionSet.create(addActions.toArray(new IAction[0])), 0, addElementNumber);

		hasActions |= addElementNumber > 0;

		int replaceElementNumber = 0;
		List<IAction> replaceElements = new ArrayList<IAction>();

		for (EntityDescriptor<?> ed : lk.getEntityDescriptorEnum())
			if (!ed.isAbstract() && !Matcher.match(ed, selectedEntity) && EntityUtils.isReplaceable(selectedEntity, ed))
				replaceElements.add(actionRegistry.getReplaceEntityAction(ed));

		replaceElementNumber = replaceElements.size();
		if (addElementNumber > 0 && replaceElementNumber > 0)
			container.addSeparator();
		Collections.sort(replaceElements, comparator);
		HierarchicalFillMenuStrategy.instance().fillMenu(
				container, ActionSet.create(replaceElements.toArray(new IAction[0])), 0, replaceElementNumber);
	
		hasActions |= replaceElementNumber > 0;

		//TODO add wrap actions

		return hasActions;
	}
}