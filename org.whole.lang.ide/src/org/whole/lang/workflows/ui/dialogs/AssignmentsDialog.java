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
package org.whole.lang.workflows.ui.dialogs;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.e4.ui.dialogs.E4Dialog;
import org.whole.lang.workflows.model.Assignments;

/**
 * @author Enrico Persiani
 */
public class AssignmentsDialog extends E4Dialog {
	@Inject	@Named("dialogTitle") protected String title;
	@Inject	@Named("dialogMessage") protected String message;
	@Inject	@Named("dialogAssignments") protected Assignments assignments;

	@Inject
	public AssignmentsDialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		super(shell);
	}

	@Override
	protected Control createContents(Composite parent) {
		setShellStyle(SWT.DIALOG_TRIM);
		getShell().setText(title);
		return super.createContents(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(message);
		label.setFocus();
		Control area = super.createDialogArea(parent);
		viewer.setEntityContents(assignments);
		return area;
	}

	@Override
	protected Button createButton(Composite parent, int id,
			String label, boolean defaultButton) {
		return super.createButton(parent, id, label, false);
	}
}
