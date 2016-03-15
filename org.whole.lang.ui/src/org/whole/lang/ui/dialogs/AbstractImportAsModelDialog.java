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

import org.eclipse.swt.widgets.Shell;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractImportAsModelDialog implements IImportAsModelDialog {
	protected IImportAsModelDialogFactory factory;
	protected Shell shell;
	protected IPersistenceKit persistenceKit;
	protected EntityDescriptor<?> stage;
	protected boolean enableForceAdding;
	protected boolean forceAdding;
	protected String title;
	protected String message;
	protected boolean confirmed;

	public AbstractImportAsModelDialog(Shell shell, IImportAsModelDialogFactory factory, String title, String message, boolean enableForceAdding) {
		this.factory = factory;
		this.shell = shell;
		this.title = title;
		this.message = message;

		this.persistenceKit = ReflectionFactory.getDefaultPersistenceKit();
		this.stage = CommonsEntityDescriptorEnum.SameStageFragment;
		this.enableForceAdding = enableForceAdding;
		this.forceAdding = false;
		this.confirmed = false;
	}

	public IImportAsModelDialogFactory getFactory() {
		return factory;
	}

	public Object[] getSelection() {
		return new Object[0];
	}
	public void setSelection(Object[] selection) {
	}

	public IPersistenceKit getPersistenceKit() {
		return persistenceKit;
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
	public boolean isEnableForceAdding() {
		return enableForceAdding;
	}
	public void setEnableForceAdding(boolean enableForceAdding) {
		this.enableForceAdding = enableForceAdding;
	}
	public boolean isForceAdding() {
		return forceAdding;
	}
	public void setForceAdding(boolean forceAdding) {
		this.forceAdding = forceAdding;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean show() {
		if (this.confirmed = openDialog())
			factory.setDefaults(getPersistenceKit(), getStage());				
		return this.confirmed;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public boolean validate() {
		return false;
	}

	protected abstract boolean openDialog();
}
