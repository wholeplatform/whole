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

import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.CONSOLE_VIEW;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.OPERATION_ID;
import static org.whole.product.lw.launching.IWholeOperationLauncherConstants.PERSIST_CHANGES;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author Enrico Persiani
 */
public class OperationBlock extends AbstractBlock {
	protected Combo operationChooser;
	protected Button consoleCheckBox;
	protected Button persistCheckBox;
	protected String[][] operations; 

	public OperationBlock(WholeOperationMainTab tab) {
		super("Operation", tab);
	}

	@Override
	protected void createContents(Composite composite) {
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(composite, SWT.NONE);
		label.setText("Name:"); 

		operationChooser = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 300;
		operationChooser.setLayoutData(gd);
		operationChooser.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				updateLaunchConfiguration();
			}
		});

		gd = new GridData();
		gd.horizontalSpan = 2;
		consoleCheckBox = new Button(composite, SWT.CHECK);
		consoleCheckBox.setLayoutData(gd);
		consoleCheckBox.setText("I/O to Console View");
		persistCheckBox = new Button(composite, SWT.CHECK);
		persistCheckBox.setLayoutData(gd);
		persistCheckBox.setText("Persist target model changes");
		consoleCheckBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfiguration();
			}
		});
		persistCheckBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLaunchConfiguration();
			}
		});
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) throws CoreException {
		initializeOperationChooser(configuration);
		consoleCheckBox.setSelection(configuration.getAttribute(CONSOLE_VIEW, false));
		persistCheckBox.setSelection(configuration.getAttribute(PERSIST_CHANGES, false));
	}

	private void initializeOperationChooser(ILaunchConfiguration configuration) throws CoreException {
		String[] operationIds = OperationLauncherRegistry.instance.getOperationIds();
		operations = new String[operationIds.length][2];
		for (int i=0; i<operationIds.length; i++) {
			operations[i][0] = operationIds[i];
			operations[i][1] = OperationLauncherRegistry.instance.getOperationLauncherDescription(operationIds[i]);
		}
		OperationsComparator operationsComparator = new OperationsComparator();
		Arrays.sort(operations, operationsComparator);
		for (int i=0; i<operationIds.length; i++)
			operationIds[i] = operations[i][1];
		operationChooser.setItems(operationIds);
		
		// perform initial selection
		String operationId = configuration.getAttribute(OPERATION_ID, "");
		for (int i=0; i<operationIds.length; i++)
			if (operationId.equals(operations[i][0])) {
				operationChooser.select(i);
				break;
			}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		int selectionIndex = operationChooser.getSelectionIndex();
		if (selectionIndex != -1)
			configuration.setAttribute(OPERATION_ID, operations[selectionIndex][0]);
		configuration.setAttribute(CONSOLE_VIEW, consoleCheckBox.getSelection());
		configuration.setAttribute(PERSIST_CHANGES, persistCheckBox.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OPERATION_ID, "");
		configuration.setAttribute(CONSOLE_VIEW, false);
		configuration.setAttribute(PERSIST_CHANGES, false);
	}
	
	@Override
	public String validate() {
		if (operationChooser.getText().length() == 0)
			return "Choose an operation type";
		return null;
	}

	private static class OperationsComparator implements Comparator<String[]> {
		public int compare(String[] o1, String[] o2) {
			return o1[1].compareTo(o2[1]);
		}
	}
}
