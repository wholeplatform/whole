/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class DetailsViewer extends AbstractDerivedGraphicalViewer {
	public DetailsViewer(Composite parent, WholeEditDomain editDomain, AbstractDerivedGraphicalView view) {
		super(parent, editDomain, view);
	}

	protected IEntity deriveModel(IEntity model, IEntity firstSelectedEntity, WholeEditDomain editDomain, IStructuredSelection structuredSelection, IProgressMonitor monitor) {
		return firstSelectedEntity;
	}
}
