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
package org.whole.lang.ui.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;

/**
 * @author Enrico Persiani
 */
public class ImplicitElementImportAsModelDialog extends AbstractImportAsModelDialog {
	protected Dialog dialog;

	public ImplicitElementImportAsModelDialog(Shell shell, IImportAsModelDialogFactory factory,
			String title, boolean enableForceAdding) {
		super(shell, factory, title, "", enableForceAdding);
		this.dialog = new Dialog(shell, this, new LabelProvider(), getTitle(), getMessage());
	}

	@Override
	protected boolean openDialog() {
		return dialog.open() == Window.OK;
	}

	public static class Dialog extends SelectionStatusDialog {
		protected IImportAsModelDialog container;

		public Dialog(Shell parent, IImportAsModelDialog container, ILabelProvider renderer, String title, String message) {
			super(parent);
			setTitle(title);
			setMessage(message);
			this.container = container;
		}
		@Override
		protected void computeResult() {
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			Composite group = new Composite(composite, SWT.NONE);
			group.setLayout(new GridLayout());
			group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			GridLayout gridLayout = new GridLayout();
			gridLayout.numColumns = 2;
			gridLayout.marginWidth = 10;
			group.setLayout(gridLayout);

			addControls(group);

			return composite;
		}

		protected void addControls(Composite group) {
			container.getFactory().addPersistenceCombo(container, group, "Paste As:");
			container.getFactory().addStageCombo(container, group, "Stage:");
			if (container.isEnableForceAdding())
				container.getFactory().addForceAdditionButton(container, group, "Force addition");
		}

		@Override
		protected Control createButtonBar(Composite parent) {
			Control buttonBar = super.createButtonBar(parent);
			getOkButton().setFocus();
			return buttonBar;
		}
	}
}
