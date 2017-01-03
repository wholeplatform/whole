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
package org.whole.lang.e4.ui.util;

import java.util.Map;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.util.IResourceBindingsContributor;

/**
 * @author Enrico Persiani
 */
public class E4ResourceBindingsContributor implements IResourceBindingsContributor {
	public void addResourceBindings(final IBindingManager bm) {
		try {
			EPartService partService = ((IEclipseContext) bm.wGetValue("eclipseContext")).get(EPartService.class);
			final MPart debugPart = partService.findPart(IE4UIConstants.DEBUG_PART_ID);
			if (debugPart == null)
				return;

			IEntity breakpointsEnabled = BindingManagerFactory.instance.createValue(true);
			breakpointsEnabled.wAddRequestEventHandler(new IdentityRequestEventHandler() {
				public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value) {
					Map<String, String> persistedState = debugPart.getPersistedState();
					return Boolean.valueOf(persistedState.get("debug#breakpointsEnabled"));
				}
			});
			bm.wSet("debug#breakpointsEnabled", breakpointsEnabled);

		} catch (Exception e) {
		}
	}
}
