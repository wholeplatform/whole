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
package org.whole.lang.e4.ui.expressions;

import org.whole.lang.actions.model.GuardedAction;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.model.URI;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.Resource;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class ActionsVisibleWhen extends AbstractSelectionConstrainedVisibleWhen {
	protected FeatureDescriptor menu;
	public ActionsVisibleWhen(FeatureDescriptor menu) {
		this.menu = menu;
	}

	@Override
	public boolean isVisible(IBindingManager bm) {
		if (!HandlersBehavior.isValidEntityPartSelection(bm, false))
			return false;

		String languageURI = bm.wGet("self").wGetLanguageKit().getURI();
	
		IResourceRegistry<Resource> registry = ActionsRegistry.instance();
		for (IResource resource : registry.getResources(false)) {
			LanguageActionFactory actionsModule = resource.getEntity();
			URI targetLanguage = actionsModule.getTargetLanguage();
			if (DataTypeUtils.getDataKind(targetLanguage).isString() && !languageURI.equals(targetLanguage.getValue()))
				continue;

			IEntityIterator<GuardedAction> iterator = IteratorFactory.<GuardedAction>childMatcherIterator()
					.withPattern(ActionsEntityDescriptorEnum.GuardedAction);
			iterator.reset(getActions(actionsModule));
			if (iterator.hasNext())
				return true;
		}
		return false;
	}

	protected IEntity getActions(LanguageActionFactory actionsModule) {
		return actionsModule.getContextMenuActions().wGet(menu);
	}
}
