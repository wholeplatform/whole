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

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/**
 * @author Enrico Persiani
 */
public class ChangeValueDialog extends InputDialog {
	private Expression expression;

	public ChangeValueDialog(Shell shell, String title, String message, Expression expression, IBindingManager bindings) {
		super(shell, title, message, DataTypeUtils.getAsPresentationString(
				Matcher.match(WorkflowsEntityDescriptorEnum.Variable, expression) ?	
						bindings.wGet(expression.wStringValue()) : expression),
						new EntityInputValidator());
		setShellStyle(SWT.DIALOG_TRIM);
		boolean isVariable = Matcher.match(WorkflowsEntityDescriptorEnum.Variable, expression);
		EntityDescriptor<?> ed = isVariable ? WorkflowsEntityDescriptorEnum.StringLiteral : expression.wGetEntityDescriptor();
		((EntityInputValidator) getValidator()).setEntityDescriptor(ed);
		
		Expression value = (Expression) GenericEntityFactory.instance.create(ed, getValue());
		expression.wGetParent().wSet(expression, value);
		this.expression = value;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
		String value = getValue();
		if (value != null) {
			DataTypeUtils.setFromPresentationString(expression, value);
		}
	}

	private static class EntityInputValidator implements IInputValidator {
		private EntityDescriptor<?> ed;
		public void setEntityDescriptor(EntityDescriptor<?> ed) {
			this.ed = ed;
		}
		public String isValid(String value) {
			try {
				DataTypeUtils.createFromPresentationString(ed, value);
				return null;
			} catch (Exception e) {
				return "invalid value";
			}
		}
	}
}
