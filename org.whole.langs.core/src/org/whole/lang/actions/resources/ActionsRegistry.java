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
package org.whole.lang.actions.resources;

import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.reflect.ActionsLanguageKit;
import org.whole.lang.resources.CompoundResourceRegistry;
import org.whole.lang.resources.Resource;
import org.whole.lang.resources.ResourceRegistry;

/**
 * @author Riccardo Solmi
 */
public class ActionsRegistry extends CompoundResourceRegistry<Resource> {
	private static class SingletonHolder {
		private static final ActionsRegistry instance = new ActionsRegistry();
	}
	public static final ActionsRegistry instance() {
		ActionsRegistry registry = SingletonHolder.instance;

		String registryId = ActionsLanguageKit.URI;
		if (!ResourceRegistry.hasRegistry(registryId))
			ResourceRegistry.putRegistry(registryId, registry);

		return registry;
	}

	protected ActionsRegistry() {
	}

	public boolean addActionFactory(LanguageActionFactory functionLibrary) {
		return addResource(functionLibrary, functionLibrary.getUri().getValue(), false);
	}
	public boolean removeActionFactory(LanguageActionFactory functionLibrary) {
		return removeResource(functionLibrary.getUri().getValue());
	}

	public <A extends Action> A getAction(String resourceUri, boolean loadOnDemand, String contextUri) {
		return getResourceModel(resourceUri, loadOnDemand, contextUri);
	}
}
