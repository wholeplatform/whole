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
package org.whole.product.lw.launching;

import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.ENVIRONMENT;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class EnvironmentBlock  extends AbstractBlock {
	protected IBindingScope scope;
	protected TableViewer environmentViewer;
	protected Button addButton;
	protected Button editButton;
	protected Button removeButton;

	public EnvironmentBlock(WholeOperationMainTab tab) {
		super("Arguments", tab);
	}

	protected void createContents(Composite composite) {
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		createEnvironmentViewer(composite);
		createEnvironmentViewerButtons(composite);
	}

	protected void createEnvironmentViewer(Composite composite) {
		environmentViewer = new TableViewer(composite, SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 300;
		environmentViewer.getControl().setLayoutData(gd);
		environmentViewer.setContentProvider(new EnvironmentContentProvider());
		environmentViewer.setLabelProvider(new EnvironmentLabelProvider());
		environmentViewer.setComparator(new ViewerComparator() {
			@Override
			public boolean isSorterProperty(Object element, String property) {
				return true;
			}
		});

		Table table = environmentViewer.getTable();
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		table.setHeaderVisible(true);

		ColumnWeightData columnWeightData = new ColumnWeightData(20);
		tableLayout.addColumnData(columnWeightData);
		TableColumn tc = new TableColumn(table, SWT.NONE, 0);
		tc.setResizable(columnWeightData.resizable);
		tc.setText("Name");

		columnWeightData = new ColumnWeightData(10);
		tableLayout.addColumnData(columnWeightData);
		tc = new TableColumn(table, SWT.NONE, 1);
		tc.setResizable(columnWeightData.resizable);
		tc.setText("Type");

		columnWeightData = new ColumnWeightData(70);
		tableLayout.addColumnData(columnWeightData);
		tc = new TableColumn(table, SWT.NONE, 2);
		tc.setResizable(columnWeightData.resizable);
		tc.setText("Value");
	}

	protected void createEnvironmentViewerButtons(Composite composite) {
		Composite buttonComposite = new Composite(composite, SWT.NONE);
		GridLayout glayout = new GridLayout();
		glayout.marginHeight = 0;
		glayout.marginWidth = 0;
		glayout.numColumns = 1;
		GridData gdata = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.HORIZONTAL_ALIGN_END);
		buttonComposite.setLayout(glayout);
		buttonComposite.setLayoutData(gdata);
		buttonComposite.setFont(composite.getFont());

		addButton = createButton(buttonComposite, "Add ...");
		editButton = createButton(buttonComposite, "Edit ...");
		removeButton = createButton(buttonComposite, "Remove ...");

		addButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				VariableDialog dialog = new VariableDialog(getTab().getControl().getShell(), "Add variable",
						"Add a new variable to the operation environment");
				if (dialog.open() == Window.OK) {
					scope.wDef(dialog.getName(), dialog.getValue());
					environmentViewer.refresh();
					updateLaunchConfiguration();
				}
			}
		});

		editButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection structuredSelection = (IStructuredSelection) environmentViewer.getSelection();
				String selectedVariableName = (String) ((Object[]) structuredSelection.getFirstElement())[0];
				
				VariableDialog dialog = new VariableDialog(getTab().getControl().getShell(), "Edit variable",
						"Edit a variable in the operation environment", selectedVariableName, scope.wGet(selectedVariableName));
				if (dialog.open() == Window.OK) {
					scope.wUnset(selectedVariableName);
					scope.wDef(dialog.getName(), dialog.getValue());
					environmentViewer.refresh();
					updateLaunchConfiguration();
				}
			}
		});

		removeButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				IStructuredSelection structuredSelection = (IStructuredSelection) environmentViewer.getSelection();
				String selectedVariableName = (String) ((Object[]) structuredSelection.getFirstElement())[0];
				if (MessageDialog.openQuestion(getTab().getControl().getShell(), "Remove variable",
						"Are you sure you want to remove the variable '"+selectedVariableName+"'?")) {
					scope.wUnset(selectedVariableName);
					environmentViewer.refresh();
					updateLaunchConfiguration();
				}
			}
		});
		
		// setup buttons enablement on selection uptade
		editButton.setEnabled(false);
		removeButton.setEnabled(false);
		environmentViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				boolean hasSelection = !event.getSelection().isEmpty();
				editButton.setEnabled(hasSelection);
				removeButton.setEnabled(hasSelection);
			}
		});
	}

	private Button createButton(Composite composite, String text) {
		Button button = new Button(composite, SWT.PUSH);
		button.setText(text);
		button.setFont(JFaceResources.getDialogFont());
		int widthHint = UIUtils.getButtonWidthHint(composite);
		GridData gd = new GridData();
		gd.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);	
		gd.horizontalAlignment = GridData.FILL;
		button.setLayoutData(gd);
		return button;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		scope = LaunchConfigurationUtils.loadBindingScope(configuration);
		environmentViewer.setInput(scope);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		LaunchConfigurationUtils.saveBindingScope(configuration, scope);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ENVIRONMENT, new HashMap<String, String>());
	}

	protected class EnvironmentContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			IBindingScope scope = (IBindingScope) inputElement;
			Set<String> localNames = scope.wLocalNames();
			int size = localNames.size();
			Object[][] elements = new Object[size][2];

			int index = 0;
			Iterator<String> iterator = localNames.iterator();;
			while (iterator.hasNext()) {
				String name = iterator.next();
				elements[index][0] = name;
				elements[index++][1] = scope.wGet(name);
			}
			return elements;
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	protected class EnvironmentLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object element, int columnIndex) 	{
			String result = null;
			if (element != null) {
				Object[] pair = (Object[]) element;
				switch (columnIndex) {
				case 0:
					result = (String) pair[0];
					break;
				case 1:
					result = DataTypeUtils.getDataKind((IEntity) pair[1]).toString();
					break;
				case 2:
					result = ((IEntity) pair[1]).wStringValue();
					break;
				}
			}
			return result;
		}
		@Override
		public String getText(Object element) {
			return getColumnText(element, 0);
		}
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
	}

	private static class VariableDialog extends Dialog {
		protected String name;
		protected IEntity value;

		protected Text nameText;
		protected Combo typeCombo;
		protected Text valueText;

		protected String title;
		protected String message;
		protected Label errorMessageLabel;
		
		public VariableDialog(Shell parentShell, String title, String message) {
			this(parentShell, title, message, null, null);
		}
		public VariableDialog(Shell parentShell, String title, String message, String initName, IEntity initValue) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.SHELL_TRIM);
			initDefaults(initName, initValue);
			this.title = title;
			this.message = message;
		}

		public String getName() {
			return name;
		}

		public IEntity getValue() {
			return value;
		}

		protected void initDefaults(String initName, IEntity initValue) {
			name = initName != null ? initName : "";
			value = initValue != null ? initValue : BindingManagerFactory.instance.createValue("");
		}

		@Override
		protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
	        if (title != null)
	        	newShell.setText(title);
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite outerComposite = (Composite) super.createDialogArea(parent);

			GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
			Label messageLabel = new Label(outerComposite, SWT.NONE);
			messageLabel.setText(message);
			messageLabel.setLayoutData(gridData);

			Composite innerComposite = new Composite(outerComposite, SWT.NONE);
			GridLayout layout = new GridLayout(2, false);
			innerComposite.setLayout(layout);
			gridData = new GridData(GridData.FILL_BOTH);
			innerComposite.setLayoutData(gridData);

			gridData = new GridData(GridData.FILL_HORIZONTAL);
			gridData.widthHint = 300;

			Label labelControl = new Label(innerComposite, SWT.NONE);
			labelControl.setText("Name:");
			nameText = new Text(innerComposite, SWT.SINGLE | SWT.BORDER);
			nameText.setLayoutData(gridData);

			labelControl = new Label(innerComposite, SWT.NONE);
			labelControl.setText("Type:");
			typeCombo = new Combo(innerComposite, SWT.NONE);
			typeCombo.setLayoutData(gridData);

			labelControl = new Label(innerComposite, SWT.NONE);
			labelControl.setText("Value:");
			valueText = new Text(innerComposite, SWT.SINGLE | SWT.BORDER);
			valueText.setLayoutData(gridData);

			gridData = new GridData(GridData.FILL_HORIZONTAL);
			errorMessageLabel = new Label(outerComposite, SWT.NONE);
			errorMessageLabel.setLayoutData(gridData);

			configureControls();

			applyDialogFont(outerComposite);
			return outerComposite;
		}

		@Override
		protected Control createContents(Composite parent) {
			Control control = super.createContents(parent);
			
			registerValidation();

			return control;
		}

		private void configureControls() {
			nameText.setText(name);

			DataKinds[] values = DataKinds.values();
			String[] items = new String[values.length - 3];
			for (int i=0, j=0; i<values.length; i++)
				if (!values[i].isEnumValue() && !values[i].isObject() && !values[i].isNotAData())
					items[j++] = values[i].toString();
			typeCombo.setItems(items);
			typeCombo.setText(DataTypeUtils.getDataKind(value).toString());
			
			valueText.setText(value.wStringValue());
		}
		
		private void registerValidation() {
			nameText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					validate();
				}
			});
			typeCombo.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					validate();
				}
			});
			valueText.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					validate();
				}
			});
			validate();
		}

		private void validate() {
			name = nameText.getText();
			if (name.length() == 0)
				setErrorMessage("Invalid variable name");
			else
				try {
					parseVariable();
					setErrorMessage(null);
				} catch (Exception e) {
					setErrorMessage("Invalid value for type "+typeCombo.getText());
				}
		}

		private void parseVariable() {
			IEntity newEntity = null;
			switch (DataKinds.valueOf(typeCombo.getText())) {
			case BOOLEAN:
				newEntity = BindingManagerFactory.instance.createValue(true);
				break;
			case BYTE:
				newEntity = BindingManagerFactory.instance.createValue((byte) 0);
				break;
			case SHORT:
				newEntity = BindingManagerFactory.instance.createValue((short) 0);
				break;
			case INT:
				newEntity = BindingManagerFactory.instance.createValue((int) 0);
				break;
			case LONG:
				newEntity = BindingManagerFactory.instance.createValue((long) 0);
				break;
			case DOUBLE:
				newEntity = BindingManagerFactory.instance.createValue(0.0);
				break;
			case FLOAT:
				newEntity = BindingManagerFactory.instance.createValue(0.0f);
				break;
			case DATE:
				newEntity = BindingManagerFactory.instance.createValue(new Date());
				break;
			case CHAR:
				newEntity = BindingManagerFactory.instance.createValue(' ');
				break;
			case STRING:
				newEntity = BindingManagerFactory.instance.createValue("");
				break;
//			case OBJECT:
//			case ENUM_VALUE:
			}
			newEntity.wSetValue(valueText.getText());
			value = newEntity;
		}

		private void setErrorMessage(String errorMessage) {
			if (errorMessage == null) {
				errorMessageLabel.setText("");
				getButton(IDialogConstants.OK_ID).setEnabled(true);
			} else {
				errorMessageLabel.setText(errorMessage);
				getButton(IDialogConstants.OK_ID).setEnabled(false);
			}
		}
	};
}
