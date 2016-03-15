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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ImportAsModelDialog extends AbstractImportAsModelDialog {
	protected Dialog dialog;

	public ImportAsModelDialog(Shell shell, IImportAsModelDialogFactory factory,
			String title, boolean enableForceAdding) {
		this(shell, factory, title, "Choose resources to be imported", enableForceAdding);
	}
	public ImportAsModelDialog(Shell shell, IImportAsModelDialogFactory factory,
			String title, String message, boolean enableForceAdding) {
		super(shell, factory, title, message, enableForceAdding);

		this.dialog = new Dialog(shell, this, getPersistenceKit(), getTitle(), getMessage());
	}

	public Object[] getSelection() {
		return dialog.getResult();
	}
	public void setSelection(Object[] selection) {
		dialog.setInitialSelections(selection);
	}

	public boolean validate() {
		dialog.setPersistenceKit(getPersistenceKit());
		return dialog.validate();
	}
	
	@Override
	protected boolean openDialog() {
		return dialog.open() == Window.OK;
	}

	public static class Dialog extends OpenAsModelDialog {
		protected IImportAsModelDialog container;
		private IStatus status;

		public Dialog(Shell parent, IImportAsModelDialog container, IPersistenceKit defaultPersistenceKit, String title, String message) {
			super(parent, defaultPersistenceKit, title, message);
			setValidator(new SelectionValidator());
			this.container = container;
			this.status = createErrorStatus("undefined");
		}

		public void setPersistenceKit(IPersistenceKit persistenceKit) {
			this.persistenceKit = persistenceKit;
		}

		@Override
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

		protected Status createErrorStatus(String message) {
			return new Status(IStatus.ERROR, E4CompatibilityPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
		}

		public boolean validate() {
			updateOKStatus();
			return status.isOK();
		}

		private final class SelectionValidator implements ISelectionStatusValidator {
			public IStatus validate(Object[] selection) {
				if (selection.length == 0)
					return status = createErrorStatus("No files selected");

				for (Object selectedObject : selection) {
					if (!(selectedObject instanceof IFile))
						return status = createErrorStatus("Only files can be imported");

					IFile selectedFile = (IFile) selectedObject;
					try {
						persistenceKit.readModel(new IFilePersistenceProvider(selectedFile));
					} catch (Exception e) {
						return status = createErrorStatus("Cannot open "+selectedFile.getName()+" using "+persistenceKit.getDescription()+" persistence");
					}
				}
				return status = Status.OK_STATUS;
			}
		}
	}
}
