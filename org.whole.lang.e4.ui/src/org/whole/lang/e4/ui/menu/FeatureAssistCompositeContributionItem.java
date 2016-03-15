/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.IContextProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.menu.ActionContainer;
import org.whole.lang.ui.menu.FullMenuNameStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IItemContainer;
import org.whole.lang.ui.menu.MenuManagerContainer;
import org.whole.lang.ui.menu.MenuManagerSet;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Enrico Persiani
 */
public class FeatureAssistCompositeContributionItem extends EntityAssistCompositeContributionItem {
	protected FeatureDescriptor fd;

	public FeatureAssistCompositeContributionItem(IContextProvider contextProvider) {
		super(contextProvider);
	}

	@Override
	protected boolean fillItems(IItemContainer<MenuManager, ImageDescriptor> menuContainer, IItemContainer<IAction, ImageDescriptor> actionContainer, IBindingManager bm) {
		List<MenuManager> menus = new ArrayList<MenuManager>();
		IEntity focusEntity = bm.wGet("focusEntity");

		for (int i = 0; i < focusEntity.wSize(); i++) {
			fd = focusEntity.wGetFeatureDescriptor(i);
			MenuManager featureMenu = new MenuManager(fd.getName(), null, null);
			if (super.fillItems(MenuManagerContainer.create(featureMenu), ActionContainer.create(featureMenu), bm))
				menus.add(featureMenu);
		}
		HierarchicalFillMenuStrategy.instance(FullMenuNameStrategy.instance())
				.fillMenu(menuContainer,
						MenuManagerSet.create(menus.toArray(new MenuManager[menus.size()])), 0, menus.size());
		
		return menus.size() > 0;
	}

	@Override
	protected IEntity getTargetEntity(IEntity selectedEntity) {
		return selectedEntity.wGet(fd);
	}

	@Override
	protected IUpdatableAction getAddEntityAction(EntityDescriptor<?> ed) {
		return contextProvider.getActionRegistry().getAddEntityAction(ed, fd);
	}
	@Override
	protected IUpdatableAction getReplaceEntityAction(EntityDescriptor<?> ed) {
		return contextProvider.getActionRegistry().getReplaceEntityAction(ed, fd);
	}
	@Override
	protected IEntity getBehavior(EntityDescriptor<?> ed, IEntityTransformer transformer) {
		return E4Utils.wrapToBehavior(ed, fd, transformer);
	}
}
