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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.whole.lang.ui.controls.StatusPageForm;

/**
 * @author Enrico Persiani
 */
public class StatusPageHandler {

	private Runnable retryHandler;
	private Composite rootComposite;
	private StackLayout stackLayout;
	private Composite editorContainer;
	private Control statusControl;

	public StatusPageHandler(Composite parent, Runnable retryHandler) {
		this.retryHandler = retryHandler;

		rootComposite = new Composite(parent, SWT.NONE);
		rootComposite.setLayout(stackLayout = new StackLayout());

		editorContainer = new Composite(rootComposite, SWT.NONE);
		editorContainer.setLayout(new FillLayout());

		rootComposite.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
	}

	protected void dispose() {
		if (statusControl != null)
			statusControl.dispose();
		if (editorContainer != null)
			editorContainer.dispose();
	}

	protected boolean isErrorStatus(IStatus status) {
		return status != null && status.getSeverity() == IStatus.ERROR;
	}

	protected String getHeader(IStatus status) {
		return "Whole Editor Error";
	}
	protected String getMessage(IStatus status) {
		return status.getMessage();
	}
	protected Throwable getException(IStatus status) {
		return status.getException();
	}

	public Composite getEditorContainer() {
		return editorContainer;
	}

	public void hookEditorPart(IEditorPart editorPart) {
		updatePartControl();
	}

	public void setStatus(IStatus status) {
		if (statusControl != null)
			statusControl.dispose();
		statusControl = isErrorStatus(status) ? createStatusControl(status) : null;
		updatePartControl();
	}
	protected Control createStatusControl(IStatus status) {
		StatusPageForm statusForm = new StatusPageForm(rootComposite, retryHandler);
		statusForm.setHeader(getHeader(status));
		statusForm.setMessage(getMessage(status));
		statusForm.setException(getException(status));
		return statusForm.getControl();
	}
	protected void updatePartControl() {
		showPartControl(rootComposite != null && statusControl != null ?
				statusControl : editorContainer);
	}
	protected boolean showPartControl(Control childControl) {
		boolean notShowing = stackLayout.topControl != childControl;
		if (notShowing) {
			stackLayout.topControl = childControl;
			rootComposite.layout();
		}
		return notShowing;
	}
}
