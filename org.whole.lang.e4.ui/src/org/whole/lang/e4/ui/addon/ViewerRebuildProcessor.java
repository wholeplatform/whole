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
package org.whole.lang.e4.ui.addon;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistryListener;

/**
 * @author Enrico Persiani
 */
public class ViewerRebuildProcessor {
	@Inject
	protected IEventBroker eventBroker;

	@Execute
	public void execute() {
		ReflectionFactory.getLanguageKitRegistry().addResourceRegistryListener(createResourceRegistryListener());
	}

	protected IResourceRegistryListener<ILanguageKit> createResourceRegistryListener() {
		return new IResourceRegistryListener<ILanguageKit>() {
			public void notifyAdded(ILanguageKit resource) {
				rebuildNotationIfNeeded(resource);
			}
			public void notifyRemoved(ILanguageKit resource) {
				rebuildNotationIfNeeded(resource);
			}
			public void notifyChanged(ILanguageKit oldResource, ILanguageKit newResource) {
				rebuildNotationIfNeeded(newResource);
			}
			protected void rebuildNotationIfNeeded(final ILanguageKit resource) {
				eventBroker.post(IE4UIConstants.TOPIC_REBUILD_VIEWER_CONDITIONAL, resource.getURI());
			}
		};
	}
}
