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
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.WholeUIPlugin;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ImportAsModelDialog extends OpenAsModelDialog implements IImportAsModelDialog {
	protected EntityDescriptor<?> stage;
	protected boolean enableForceAdding;
	protected boolean forceAdding;

	public ImportAsModelDialog(Shell parent, String title, boolean enableForceAdding) {
		this(parent, title, "Choose resources to be imported", enableForceAdding);
	}
	public ImportAsModelDialog(Shell parent, String title, String message, boolean enableForceAdding) {
		super(parent, ReflectionFactory.getDefaultPersistenceKit(), title, message);
		this.enableForceAdding = enableForceAdding;
		this.stage = CommonsEntityDescriptorEnum.SameStageFragment;
		this.forceAdding = false;
		setValidator(new SelectionValidator());
	}

	@Override
	protected void addControls(Composite group) {
		ImportAsModelDialogFactory.addPersistenceCombo(this, group, "Import As:");
		ImportAsModelDialogFactory.addStageCombo(this, group, "Stage:");
		if (enableForceAdding)
			ImportAsModelDialogFactory.addForceAdditionButton(this, group, "Force addition");
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		getOkButton().setFocus();
		return buttonBar;
	}

	public void setPersistenceKit(IPersistenceKit persistenceKit) {
		this.persistenceKit = persistenceKit;
	}

	public EntityDescriptor<?> getStage() {
		return stage;
	}
	public void setStage(EntityDescriptor<?> stage) {
		this.stage = stage;
	}

	public boolean isForceAdding() {
		return forceAdding;
	}
	public void setForceAdding(boolean forceAdding) {
		this.forceAdding = forceAdding;
	}

	public Object[] getSelection() {
		return getResult();
	}
	public void setSelection(Object[] selection) {
		throw new IllegalStateException("cannot set selection");
	}

	public boolean show() {
		boolean value = super.open() == Window.OK;
		if (value)
			ImportAsModelDialogFactory.instance().setDefaults(persistenceKit, stage);				
		return value;
	}
	public void validate() {
		updateOKStatus();
	}

	private final class SelectionValidator implements ISelectionStatusValidator {
		public IStatus validate(Object[] selection) {
			if (selection.length == 0)
				return createErrorStatus("No files selected");

			for (Object selectedObject : selection) {
				if (!(selectedObject instanceof IFile))
					return createErrorStatus("Only files can be imported");

				IFile selectedFile = (IFile) selectedObject;
				try {
					persistenceKit.readModel(new IFilePersistenceProvider(selectedFile));
				} catch (Exception e) {
					return createErrorStatus("Cannot open "+selectedFile.getName()+" using "+persistenceKit.getDescription()+" persistence");
				}
			}
			return Status.OK_STATUS;
		}
		private Status createErrorStatus(String message) {
			return new Status(IStatus.ERROR, WholeUIPlugin.PLUGIN_ID, IStatus.ERROR, message, null);
		}
	}
}
