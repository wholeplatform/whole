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
package org.whole.lang.e4.ui.actions;

import java.net.URL;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.jobs.FunctionRunnable;
import org.whole.lang.e4.ui.jobs.ISynchronizableRunnable;
import org.whole.lang.e4.ui.jobs.TextualFunctionRunnable;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractModelTextAction extends AbstractE4Action {
	public AbstractModelTextAction(IEclipseContext context, String label) {
		super(context, label);
		try {
			setImageDescriptor(ImageDescriptor.createFromURL(new URL(IE4UIConstants.TEXT_ICON_URI)));
		} catch (Exception e) {
		}
	}

	protected abstract String getEnablementUri();
	protected abstract String getBehaviorUri();

	@Override
	public void update() {
		setEnabled(false);

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			setEnabled(calculateEnabled(bm));
		}
	}

	protected boolean calculateEnabled(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		if (!Tools.TEXTUAL.isActive(viewer) ||
				!(ModelObserver.getObserver(bm.wGet("focusEntity"), viewer.getEditPartRegistry()) instanceof ITextualEntityPart))
			return false;

		IEclipseContext context = (IEclipseContext) bm.wGetValue("eclipseContext");
		ISynchronizableRunnable runnable = new FunctionRunnable(context, bm, getText(), getEnablementUri());
		IEntity result = runnable.syncExec(3000).getResult();
		return result != null && result.wBooleanValue();
	}

	@Override
	public void run() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		ISynchronizableRunnable runnable = new TextualFunctionRunnable(getContext(), bm, getText(), getBehaviorUri());
		runnable.syncExec(3000);
	}
}
