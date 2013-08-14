/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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

import org.eclipse.swt.widgets.Composite;
import org.whole.lang.e4.ui.actions.DerivedLinkableSelectionListener;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.model.IEntity;

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

	protected DerivedLinkableSelectionListener createSelectionLinkable(IEntityPartViewer viewer) {
		return new DerivedLinkableSelectionListener(viewer, getDerivationFunction()) {
			@Override
			protected void linkViewer(IEntityPartViewer toViewer) {
				super.linkViewer(toViewer);
				fireViewerLinked(toViewer);
			}
		
			@Override
			protected void unlinkViewer() {
				super.unlinkViewer();
				fireViewerUnlinked();
			}
			
			@Override
			protected void setDerivedContents(IEntity result) {
				super.setDerivedContents(result);
				fireContentsDerived(result);
			}
		};
	}

	protected abstract String getDerivationFunction();
}
