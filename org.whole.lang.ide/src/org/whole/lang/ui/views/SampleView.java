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
package org.whole.lang.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class SampleView extends AbstractDerivedGraphicalView {
	public static String ID = SampleView.class.getName();
	@Override
	public String getViewId() {
		return ID;
	}

	public void setInteractiveMode(WholeGraphicalViewer viewer, IEntity contents) {
		viewer.setInteractive(contents, true, true, false);
	}

	protected AbstractDerivedGraphicalViewer createGraphicalViewer(Composite parent, WholeEditDomain editDomain) {
		return new SampleViewer(parent, editDomain, this);
	}
}
