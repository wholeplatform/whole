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
package org.whole.lang.actions.util;

import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi
 */
public class ActionsUtils {
	public static IEntityIterator<IEntity> actionsModulesIterator() {
		return IteratorFactory.javaCollectionIterator(
				ActionsRegistry.instance().getResources(false, ResourceUtils.SIMPLE_COMPARATOR));
	}
	public static IEntity getActionsModule(String contextURI, String resourceURI, boolean loadOnDemand) {
		return resourceURI != null ? ActionsRegistry.instance().getResourceModel(resourceURI, loadOnDemand, contextURI) : null;
	}
}
