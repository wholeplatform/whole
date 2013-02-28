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
package org.whole.lang.ui.handlers;

import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.Clipboard;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class GoToEntityPath extends AbstractHandler {
	private static Pattern XML_PATTERN = Pattern.compile("<\\?\\s*xml");

	private IWorkbenchWindow workbenchWindow;
	private WholeGraphicalEditor editorPart;
	private IEntity selectedEntity;
	private boolean isRelative;

	public boolean isRelative() {
		return isRelative;
	}
	public void setRelative(boolean isRelative) {
		this.isRelative = isRelative;
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Object appContextObj = event.getApplicationContext();
		if (appContextObj instanceof IEvaluationContext) {
			IEvaluationContext appContext = (IEvaluationContext) appContextObj;
			workbenchWindow = (IWorkbenchWindow) appContext.getVariable(ISources.ACTIVE_WORKBENCH_WINDOW_NAME);
			editorPart = (WholeGraphicalEditor) appContext.getVariable(ISources.ACTIVE_EDITOR_NAME);
			
			List<IEntityPart>  selectedParts = UIUtils.getSelectedEntityParts(editorPart);
			if (selectedParts.size() == 1) {
				IEntity entity = selectedParts.get(0).getModelEntity();
				selectedEntity = Matcher.match(CommonsEntityDescriptorEnum.RootFragment, entity) ? null : entity;
			}

			EntityPathValidator validator = new EntityPathValidator();
			String initialValue = "";
			String textContents = Clipboard.instance().getTextContents();
			if (textContents != null && (validator.isValid(textContents) == null ||
					(textContents = parsePath(textContents)) != null))
				initialValue = textContents;

			EntityPathInputDialog dialog = new EntityPathInputDialog(workbenchWindow.getShell(), initialValue, validator);
			if (dialog.open() == Dialog.OK) {
				IEntity rootEntity = isRelative() ? selectedEntity : editorPart.getRootEntity();
				editorPart.selectAndReveal(getEntity(rootEntity, dialog.getValue()));
			}
		}
		return null;
	}

	public IEntity getEntity(IEntity rootEntity, String location) {
		return EntityUtils.getEntity(rootEntity, location);
	}

	public static String parsePath(String input) {
		if (XML_PATTERN.matcher(input).find()) {
			try {
				IEntity entity = ClipboardUtils.parseEntity(input);
				if (EntityUtils.isTuple(entity) && entity.wSize() == 1) {
					entity = entity.wGet(0);
					EntityDescriptor<?> ed = entity.wGetEntityDescriptor();				
					if (ed.getLanguageKit().equals(ReflectionFactory.getLanguageKit("http://lang.whole.org/Queries")) &&
							ed.getName().equals("Path")) {

						String path = PrettyPrinterOperation.toPrettyPrintString(entity);
						return '/'+path.replaceAll("(child\\(\\))|\\[|\\]", "");
					}
				}
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	private final class EntityPathValidator implements IInputValidator {
		public String isValid(String newValue) {
			if ("".equals(newValue))
				return "";
			IEntity rootEntity = isRelative() ? selectedEntity : editorPart.getRootEntity();
			boolean isMalformed = !UIUtils.LOCATION_PATTERN.matcher(newValue).matches();
			boolean isInvalid = getEntity(rootEntity, newValue) == null;
			return isMalformed ? "Malformed path" : isInvalid ? "Invalid path" : null;
		}
	}

	private final class EntityPathInputDialog extends InputDialog {
		public EntityPathInputDialog(Shell parentShell, String initialValue, IInputValidator validator) {
			super(parentShell, "Go to entity path", "Enter entity path:",
					initialValue, validator);
		}
		@Override
		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);
			final Button isRelative = new Button(composite, SWT.CHECK);
			isRelative.setText("relative to selection");
			isRelative.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
			isRelative.moveBelow(getText());
			isRelative.setEnabled(selectedEntity != null);
			isRelative.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					setRelative(isRelative.getSelection());
					validateInput();
				}
			});
			setRelative(isRelative.getSelection());
			applyDialogFont(composite);
			return composite;
		}
		@Override
		protected Control createContents(Composite parent) {
			Control contents = super.createContents(parent);
			validateInput();
			return contents;
		}

		protected int getInputTextStyle() {
			return SWT.MULTI | SWT.BORDER;
		}
		@Override
		protected void validateInput() {
			Text text = getText();
			String input = text.getText();

			// try to convert a queries path to an entity location
			if ((input = parsePath(input)) != null)
				text.setText(input);

			super.validateInput();
		}
	}
}
