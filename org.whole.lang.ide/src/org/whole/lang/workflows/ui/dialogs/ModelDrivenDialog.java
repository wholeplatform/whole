/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.dialogs.E4Dialog;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.workflows.model.Assignments;

/**
 * @author Riccardo Solmi
 */
public class ModelDrivenDialog extends E4Dialog {
	@Inject	@Named("dialogTitle") protected String title;
	@Inject	@Named("dialogMessage") protected String message;
	@Inject	@Named("dialogAssignments") protected Assignments assignments;
	@Inject	@Named("bindings") protected IBindingManager bindings;

	@Inject
	public ModelDrivenDialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell) {
		super(shell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MAX | SWT.RESIZE | getDefaultOrientation());
	}

	@Override
	protected Control createContents(Composite parent) {
		setShellStyle(SWT.DIALOG_TRIM);
		getShell().setText(title);
		return super.createContents(parent);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		if (message != null && !message.isEmpty()) {
			Label label = new Label(parent, SWT.NONE);
			label.setText(message);
			label.setFocus();
		}
		Control area = super.createDialogArea(parent);
		viewer.setEntityContents(assignments.get(0).getExpression());
		return area;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
//		super.createButtonsForButtonBar(parent);
		createButton(parent, IDialogConstants.STOP_ID, IDialogConstants.STOP_LABEL, false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, false);
//		getButton(IDialogConstants.OK_ID).setText("Apply");
//		getButton(IDialogConstants.CANCEL_ID).setText(IDialogConstants.SKIP_LABEL);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
		if (IDialogConstants.STOP_ID == buttonId) {
			setReturnCode(IDialogConstants.STOP_ID);
			close();
		}
	}

	@Override
	protected void okPressed() {
		super.okPressed();

		if (assignments.wSize() > 1 && assignments.get(1).getName().toString().equals("onOk")) {
			IEntity onOkAction = assignments.get(1).getExpression();
			BehaviorUtils.evaluate(onOkAction, 0, bindings);
		}

		assignments.clear();
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();

		if (assignments.wSize() > 2 && assignments.get(2).getName().toString().equals("onCancel")) {
			IEntity onCancelAction = assignments.get(2).getExpression();
			BehaviorUtils.evaluate(onCancelAction, 0, bindings);
		}
	}
}
