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
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ChangeValueDialog extends InputDialog {
	private IEntity entity;

	@Inject
	public ChangeValueDialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named("dialogTitle") String title,
			@Named("dialogMessage") String message,
			@Named("dialogEntity") IEntity entity) {
		super(shell, title, message, 
				DataTypeUtils.getAsPresentationString(entity),
				new EntityInputValidator(EntityUtils.clone(entity)));
		setShellStyle(SWT.DIALOG_TRIM);
		this.entity = entity;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
		String value = getValue();
		if (value != null) {
			DataTypeUtils.setFromPresentationString(entity, value);
		}
	}

	private static class EntityInputValidator implements IInputValidator {
		private IEntity entity;
		public EntityInputValidator(IEntity entity) {
			this.entity = entity;
		}
		public String isValid(String value) {
			try {
				DataTypeUtils.setFromPresentationString(entity, value);
				return null;
			} catch (Exception e) {
				return "invalid value";
			}
		}
	}
}
