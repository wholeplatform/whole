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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.debug.IDebugService;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.util.IResourceBindingsContributor;

/**
 * @author Enrico Persiani
 */
public class E4ResourceBindingsContributor implements IResourceBindingsContributor {
	public void addResourceBindings(final IBindingManager bm) {
		if (bm.wIsSet(IBindingManager.ECLIPSE_CONTEXT)) {
			try {
				IDebugService debugService = ((IEclipseContext) bm.wGetValue(IBindingManager.ECLIPSE_CONTEXT)).get(IDebugService.class);

				if (bm.wIsSet(IBindingManager.BREAKPOINTS_ENABLED)) {
					IEntity breakpointsEnabled = BindingManagerFactory.instance.createValue(true);
					breakpointsEnabled.wAddRequestEventHandler(new IdentityRequestEventHandler() {
						public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value) {
							return debugService.isBreakpointsEnabled();
						}
					});
					bm.wSet(IBindingManager.BREAKPOINTS_ENABLED, breakpointsEnabled);
				}

				if (bm.wIsSet(IBindingManager.INSTRUMENTATION_ENABLED)) {
					IEntity instrumentationEnabled = BindingManagerFactory.instance.createValue(true);
					instrumentationEnabled.wAddRequestEventHandler(new IdentityRequestEventHandler() {
						public boolean notifyRequested(IEntity source, FeatureDescriptor feature, boolean value) {
							return debugService.isInstrumentationEnabled();
						}
					});
					bm.wSet(IBindingManager.INSTRUMENTATION_ENABLED, instrumentationEnabled);
				}
	
			} catch (Exception e) {
			}
		}
	}
}
