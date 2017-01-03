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

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.e4.ui.actions.DerivedLinkableSelectionListener;
import org.whole.lang.e4.ui.actions.ILinkableSelectionListener;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.actions.LinkType;
import org.whole.lang.e4.ui.jobs.ShowingPolicy;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractE4DerivedGraphicalPart extends E4GraphicalPart {
	@Override
	protected IEntityPartViewer createEntityViewer(Composite parent) {
		IEntityPartViewer viewer = super.createEntityViewer(parent);
		setSelectionLinkable(createSelectionLinkable(viewer));
		return viewer;
	}

	protected ILinkableSelectionListener createSelectionLinkable(IEntityPartViewer viewer) {
		IEclipseContext params = EclipseContextFactory.create();
		// we need to pass the viewer because it has not been set in the active context
		params.set(IEntityPartViewer.class, viewer);
		return ContextInjectionFactory.make(DerivedLinkableSelectionListener.class, context,
				configureSelectionLinkable(params));
	}

	protected IEclipseContext configureSelectionLinkable(IEclipseContext params) {
		params.set(ILinkableSelectionListener.FUNCTION_URI, getDerivationFunction());
		params.set(ILinkableSelectionListener.FUNCTION_IS_TRANSACTIONAL, false);
		params.set(ILinkableSelectionListener.RESULTS_SHOWING_POLICY, ShowingPolicy.MANDATORY);
		params.set(ILinkableSelectionListener.LINK_TYPE, LinkType.ACTIVE_PART);
		params.set(ILinkableSelectionListener.SHARE_EDIT_DOMAIN, false);
		params.set(ILinkableSelectionListener.SYNCHRONIZE_SELECTION, false);
		params.set(ILinkableSelectionListener.IGNORABLE_PART_IDS, IE4UIConstants.DERIVED_PARTS_ID_SET);
		return params;
	}

	protected abstract String getDerivationFunction();
}
