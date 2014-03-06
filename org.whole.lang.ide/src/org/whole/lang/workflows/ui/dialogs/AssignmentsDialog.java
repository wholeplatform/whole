/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
	protected String title;
	protected String message;
	protected Assignments assignments;

	public AssignmentsDialog(Shell shell, String title, String message,
			Assignments assignments) {
		super(shell);
		setShellStyle(SWT.DIALOG_TRIM);
		this.title = title;
		this.message = message;
		this.assignments = assignments;
	}

	@Override
	protected Control createContents(Composite parent) {
		getShell().setText(title);
		return super.createContents(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(message);
		label.setFocus();
		return super.createDialogArea(parent);
	}
	
	@Override
	public int open() {
		int result = super.open();
		viewer.setEntityContents(assignments);
		return result;
	}

	@Override
	protected Button createButton(Composite parent, int id,
			String label, boolean defaultButton) {
		return super.createButton(parent, id, label, false);
	}
}
