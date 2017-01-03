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
package org.whole.lang.e4.ui.parts;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.ILinkableSelectionListener;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.actions.LinkViewerAdapter;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;


/**
 * @author Enrico Persiani
 */
@Singleton
public class E4ContextGraphicalPart extends AbstractE4DerivedGraphicalPart {
	@Inject IEventBroker eventBroker;

	protected String getDerivationFunction() {
		return "whole:org.whole.lang:ViewDerivationLibrary#deriveContextViewContents";
	}

	@Override
	protected ILinkableSelectionListener createSelectionLinkable(IEntityPartViewer viewer) {
		ILinkableSelectionListener listener = super.createSelectionLinkable(viewer);
		listener.addLinkViewerListener(new LinkViewerAdapter() {
			@Override
			public void contentsDerived(IEntityPartViewer viewer, IBindingManager selection, IEntity result) {
				if (selection.wIsSet("primarySelectedEntity")) {
					IEntity primarySelectedEntity = selection.wGet("primarySelectedEntity");
					IEntity model = EntityUtils.getCompoundRoot(primarySelectedEntity);
					IEntity selfModel = EntityUtils.mapEntity(primarySelectedEntity, EntityUtils.clone(model));
					IEntity selfBindings = BindingManagerFactory.instance.createValue(selection.clone());
					IEntity sampleContext = BindingManagerFactory.instance.createTuple(result, selfModel, selfBindings);
					//TODO test
//					if (Matcher.matchImpl(EnvironmentEntityDescriptorEnum.Bindings, result))
//						result.wAdd(BindingManagerFactory.instance.createBinding("self", selfModel));
					
					eventBroker.post(IE4UIConstants.TOPIC_UPDATE_SAMPLE_CONTEXT, sampleContext);
				} else
					getViewer().setContents(null, createDefaultContents());
			}
		});
		return listener;
	}
}
