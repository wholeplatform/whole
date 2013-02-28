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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ContextViewer extends AbstractDerivedGraphicalViewer {
	public ContextViewer(Composite parent, WholeEditDomain editDomain, AbstractDerivedGraphicalView view) {
		super(parent, editDomain, view);
	}

	@Override
	public void dispose() {
		super.dispose();
		selfModel = null;
	}

	protected IEntity deriveModel(IEntity model, IEntity firstSelectedEntity, WholeEditDomain editDomain, IStructuredSelection structuredSelection, IProgressMonitor monitor) {
		GetContentsRunnable runnable = new GetContentsRunnable(view);
		PlatformUI.getWorkbench().getDisplay().syncExec(runnable);

		setSelfModel(EntityUtils.mapEntity(firstSelectedEntity, EntityUtils.clone(model)));

		IEntity contextModel = runnable.contextModel;
		if (contextModel == null) 
			contextModel = BehaviorUtils.apply(
					"whole:org.whole.lang.ui.views:SamplePerspectiveSemantics#ContextViewModel", getSelfModel());

		return contextModel;
	}

	private IEntity selfModel;
	public IEntity getSelfModel() {
		return selfModel;
	}
	public void setSelfModel(IEntity selfModel) {
		this.selfModel = selfModel;
	}
}
