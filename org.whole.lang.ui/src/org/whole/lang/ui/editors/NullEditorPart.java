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
package org.whole.lang.ui.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.whole.lang.ui.views.WholeGraphicalViewer;

/**
 * @author Enrico Persiani
 */
public class NullEditorPart implements IEditorPart {
	private static final String null_editorPart = "missing editor part";

	private WholeGraphicalViewer viewer;
	private CommandStack commandStack;

	public void setViewer(WholeGraphicalViewer viewer) {
		this.viewer = viewer;
	}
	public void setCommandStack(CommandStack commandStack) {
		this.commandStack = commandStack;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class type) {
		if (type == CommandStack.class)
			return commandStack;
		if (type == GraphicalViewer.class)
			return viewer;
		if (type == ActionRegistry.class)
			return viewer.getActionFactory().getActionRegistry();
		if (type == EditPart.class && viewer != null)
			return viewer.getRootEditPart();
		if (type == IFigure.class && viewer != null)
			return ((GraphicalEditPart) viewer.getRootEditPart()).getFigure();
		return Platform.getAdapterManager().getAdapter(this, type);
	}

	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		throw new IllegalStateException(null_editorPart);
	}
	public void addPropertyListener(IPropertyListener listener) {
		throw new IllegalStateException(null_editorPart);
	}
	public void createPartControl(Composite parent) {
		throw new IllegalStateException(null_editorPart);
	}
	public void dispose() {
		throw new IllegalStateException(null_editorPart);
	}
	public IWorkbenchPartSite getSite() {
		throw new IllegalStateException(null_editorPart);
	}
	public String getTitle() {
		throw new IllegalStateException(null_editorPart);
	}
	public Image getTitleImage() {
		throw new IllegalStateException(null_editorPart);
	}
	public String getTitleToolTip() {
		throw new IllegalStateException(null_editorPart);
	}
	public void removePropertyListener(IPropertyListener listener) {
		throw new IllegalStateException(null_editorPart);
	}
	public void setFocus() {
		throw new IllegalStateException(null_editorPart);
	}
	public IEditorInput getEditorInput() {
		throw new IllegalStateException(null_editorPart);
	}
	public IEditorSite getEditorSite() {
		throw new IllegalStateException(null_editorPart);
	}
	public void doSave(IProgressMonitor monitor) {
		throw new IllegalStateException(null_editorPart);
	}
	public void doSaveAs() {
		throw new IllegalStateException(null_editorPart);
	}
	public boolean isDirty() {
		return false;
	}
	public boolean isSaveAsAllowed() {
		return false;
	}
	public boolean isSaveOnCloseNeeded() {
		return false;
	}
}
