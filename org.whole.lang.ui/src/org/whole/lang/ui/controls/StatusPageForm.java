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
package org.whole.lang.ui.controls;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

/**
 * TODO use Builder Pattern
 * @author Enrico Persiani
 */
public class StatusPageForm {
	protected Composite parent;
	protected ScrolledComposite composite;
	protected FormToolkit formToolkit;
	protected Form form;
	protected Section exceptionSection;
	protected Label messageLabel;
	protected Label exceptionLabel;
	protected Button reloadButton;
	protected Text exceptionTrace;
	protected Runnable retryHandler;

	public StatusPageForm(Composite parent, Runnable retryHandler) {
		this.parent = parent;
		this.retryHandler = retryHandler;

		formToolkit = new FormToolkit(parent.getDisplay());
		form = formToolkit.createForm(parent);
		formToolkit.decorateFormHeading(form);
		form.getHead().getBorderWidth();

		form.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				formToolkit.dispose();
			}
		});
		form.getBody().setLayout(new GridLayout());
		formToolkit.createSeparator(form.getBody(), SWT.NONE).setVisible(false);

		Composite separator = formToolkit.createCompositeSeparator(form.getBody());
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = 2;
		separator.setLayoutData(gridData);

		messageLabel = formToolkit.createLabel(form.getBody(), null);
		messageLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		exceptionLabel = formToolkit.createLabel(form.getBody(), null);
		exceptionLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		formToolkit.createSeparator(form.getBody(), SWT.HORIZONTAL).setVisible(false);
		reloadButton = formToolkit.createButton(form.getBody(), "Retry", SWT.PUSH);
		reloadButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				try {
					final IWorkbench workbench = PlatformUI.getWorkbench();
					workbench.getActiveWorkbenchWindow().run(true, false, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
							workbench.getDisplay().syncExec(StatusPageForm.this.retryHandler);
						}
					});
				} catch (Exception e) {
				}
			}
		});

		formToolkit.createSeparator(form.getBody(), SWT.HORIZONTAL).setVisible(false);

		exceptionSection = formToolkit.createSection(form.getBody(),
				Section.TITLE_BAR | Section.TWISTIE);
		exceptionSection.setText("Error details");
		exceptionSection.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite sectionClient = formToolkit.createComposite(exceptionSection);
		sectionClient.setLayout(new GridLayout());
		exceptionTrace = formToolkit.createText(sectionClient, null, SWT.MULTI |
				SWT.BORDER | SWT.V_SCROLL | SWT.READ_ONLY);
		exceptionTrace.setLayoutData(new GridData(GridData.FILL_BOTH));
		exceptionSection.setClient(sectionClient);
	}

	public Composite getControl() {
		return form;
	}

	public void setHeader(String header) {
		form.setText(header);
		form.update();
	}

	public void setMessage(String message) {
		messageLabel.setText(message);
		parent.layout();
	}

	public void setException(Throwable exception) {
		if (exception == null)
			return;
		String exceptionMessage = exception.getMessage();
		exceptionLabel.setText(exceptionMessage != null ?
				exceptionMessage : exception.toString());
		StringWriter sw = new StringWriter(2048);
		exception.printStackTrace(new PrintWriter(sw));
		exceptionTrace.setText(sw.toString());
		parent.layout();
	}
}
