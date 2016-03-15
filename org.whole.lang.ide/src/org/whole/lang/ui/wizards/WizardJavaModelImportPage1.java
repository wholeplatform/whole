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
package org.whole.lang.ui.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaElementComparator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.whole.lang.java.codebase.JavaSourceTemplateFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.controls.JavaClassFileFilter;

/**
 * @author Enrico Persiani
 */
public class WizardJavaModelImportPage1 extends AbstractWizardWholeModelImportPage {
	protected TreeViewer resourceChooser;

	public WizardJavaModelImportPage1(String pageName, IWorkbench workbench, IStructuredSelection selection) {
		super(pageName, workbench, selection);
	}

	public WizardJavaModelImportPage1(IWorkbench workbench, IStructuredSelection selection) {
		super("javaModelImportPage1", workbench, selection);
		setTitle("Import Java Model");
		setDescription("Import a Java class into a Java model");
	}

	@Override
	protected IEntity buildModel() {
		IStructuredSelection selection = (IStructuredSelection)resourceChooser.getSelection();
		ITypeRoot typeRoot = (ITypeRoot) selection.getFirstElement();
		return new JavaSourceTemplateFactory(typeRoot).useCanonicalNames(false).create();
	}

	@Override
	protected void createSourceGroup(Composite parent) {
		resourceChooser = new TreeViewer(parent, SWT.SINGLE);
		GridLayout listAreaLayout = new GridLayout();
		listAreaLayout.marginWidth = 0;
		parent.setLayout(listAreaLayout);
		resourceChooser.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		resourceChooser.setContentProvider(new StandardJavaElementContentProvider());
		resourceChooser.setLabelProvider(new JavaElementLabelProvider());
		resourceChooser.setComparator(new JavaElementComparator());
		resourceChooser.addFilter(new JavaClassFileFilter());
		resourceChooser.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		resourceChooser.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updatePageCompletion();
			}
		});
	}

	@Override
	protected boolean determinePageCompletion() {
		if (!super.determinePageCompletion())
			return false;

		if(resourceChooser == null)
			return false;

		IStructuredSelection selection = (IStructuredSelection) resourceChooser.getSelection();
		if (selection.isEmpty() || !(selection.getFirstElement() instanceof IClassFile)) {
			setErrorMessage("A Java class must be choosen");
			return  false;
		}
		return true;
	}
}
