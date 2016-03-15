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
package org.whole.lang.ui.controls;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractBrowseChooser extends Composite {
	protected int buttonWidthHint;
	protected Button browseButton;
	protected Text chooserText;
	protected Object[] selectedElements;
	protected String label;

	public AbstractBrowseChooser(Composite parent, int style, String label, int buttonWidthHint) {
		super(parent, style);
		this.buttonWidthHint = buttonWidthHint;
		this.label = label;

		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		setLayout(layout);

		addControls();
	}

	protected void addControls() {
        // container label
        Label resourcesLabel = new Label(this, SWT.NONE);
        resourcesLabel.setText(label);
        resourcesLabel.setFont(this.getFont());

        chooserText = new Text(this, SWT.SINGLE | SWT.BORDER);
        GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
                | GridData.GRAB_HORIZONTAL);
        chooserText.setLayoutData(data);
        chooserText.setFont(this.getFont());
        chooserText.setEditable(false);

        browseButton = new Button(this, SWT.PUSH);
		browseButton.setText("Browse ...");
        browseButton.setFont(this.getFont());
		GridData buttonData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		buttonData.widthHint = buttonWidthHint;
		browseButton.setLayoutData(buttonData);
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				showChooser();
			}
		});
	}

	protected abstract Dialog createDialog();

	protected void showChooser() {
		Dialog dialog = createDialog();
		if (dialog.open() == Window.OK) {
			selectedElements = getResult(dialog);
			if (selectedElements != null) {
				chooserText.setText(resultToString(selectedElements));
			} else
				chooserText.setText("");
		}
	}

	protected abstract Object[] getResult(Dialog dialog);
	protected abstract String resultToString(Object[] selectedElements);

	public void addModifyListener(ModifyListener listener) {
		chooserText.addModifyListener(listener);
	}

	public void removeModifyListener(ModifyListener listener) {
		chooserText.removeModifyListener(listener);
	}

	public void setText(String text) {
		chooserText.setText(text);
	}
}
