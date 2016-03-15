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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.whole.gen.util.JDTUtils;

/**
 * @author Enrico Persiani
 */
public class BrowseListChooser extends Composite {

	private int buttonWidthHint;
	private CheckboxTreeViewer listChooser;
	private List<Class<?>> classList;

	public BrowseListChooser(Composite parent, int style, int buttonWidthHint) {
		super(parent, style);
		this.buttonWidthHint = buttonWidthHint;
		classList = new ArrayList<Class<?>>();
		addControls();
	}

	public void populateClassList(IPackageFragment packageFragment) {
		classList.clear();
		try {
			ClassLoader projectURLClassLoader = JDTUtils.createClassLoader(packageFragment.getJavaProject(), true);

			for(IJavaElement javaElement : packageFragment.getChildren()) {
				if(javaElement instanceof IClassFile) {
					IClassFile classFile = ((IClassFile)javaElement);
					Class<?> clazz = projectURLClassLoader.loadClass(classFile.getType().getFullyQualifiedName());
					if(clazz != null && !clazz.isAnonymousClass() && !clazz.isMemberClass())
						classList.add(clazz);
				}
				if(javaElement instanceof ICompilationUnit) {
					ICompilationUnit compilationUnit = ((ICompilationUnit)javaElement);
					IType[] types = compilationUnit.getTypes();
					for(IType type : types) {
						Class<?> clazz = projectURLClassLoader.loadClass(type.getFullyQualifiedName());
						if(clazz != null && !clazz.isAnonymousClass() && !clazz.isMemberClass())
							classList.add(clazz);
					}
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		listChooser.refresh();
		// TODO uncomment when checked state handling fixed
		//		listChooser.setAllChecked(true);
	}

	private void addControls() {
		Label title = new Label(this, SWT.NONE);
		title.setText("&Classes");

		Composite container = new Composite(this, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 0;

		layout.makeColumnsEqualWidth = false;
		container.setLayout(layout);

		container.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL
				| GridData.GRAB_VERTICAL | GridData.FILL_BOTH));

		listChooser = new CheckboxTreeViewer(container, SWT.BORDER);
		GridData listData = new GridData(GridData.GRAB_HORIZONTAL
				| GridData.GRAB_VERTICAL | GridData.FILL_BOTH);
		listChooser.getControl().setLayoutData(listData);

		listChooser.setContentProvider(new ITreeContentProvider() {
			public Object[] getChildren(Object parentElement) {
				return null;
			}
			public Object[] getElements(Object inputElement) {
				return classList.toArray();
			}
			public boolean hasChildren(Object element) {
				return false;
			}
			public Object getParent(Object element) {
				return null;
			}
			public void dispose() {

			}
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}
		});

		listChooser.setLabelProvider(new LabelProvider() {
			public String getText(Object element) {
				return (((Class<?>) element).getSimpleName());
			}
		});

		listChooser.setInput(this);
		listChooser.setSorter(new ViewerSorter());
		createSelectionButtons(container);
	}

	private void createSelectionButtons(Composite listComposite) {
		Composite buttonsComposite = new Composite(listComposite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		buttonsComposite.setLayout(layout);
		buttonsComposite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		GridData buttonGridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		buttonGridData.widthHint = buttonWidthHint;
		
		Button selectAll = new Button(buttonsComposite, SWT.PUSH);
		selectAll.setText("Select All");
		selectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				listChooser.setAllChecked(true);
			}
		});
		Dialog.applyDialogFont(selectAll);
		selectAll.setLayoutData(buttonGridData);

		Button deselectAll = new Button(buttonsComposite, SWT.PUSH);
		deselectAll.setText("Deselect All");
		deselectAll.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				//listChooser.setAllChecked(false);
				//listChooser.setCheckedElements(new Object[0]);
				//listChooser.setChecked(classList.get(0), false);
				listChooser.setAllChecked(false);
			}
		});
		Dialog.applyDialogFont(deselectAll);
		deselectAll.setLayoutData(buttonGridData);

		Button refresh = new Button(buttonsComposite, SWT.PUSH);
		refresh.setText("Refresh");
		refresh.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				listChooser.refresh();
			}
		});
		Dialog.applyDialogFont(refresh);
		refresh.setLayoutData(buttonGridData);
	}

	public Class<?>[] getCheckedClasses() {
		Object elements[] = listChooser.getCheckedElements();
		Class<?> classes[] = new Class<?>[elements.length];
		for(int i=0; i<elements.length; i++)
			classes[i] = (Class<?>) elements[i];
		return classes;
	}

	public void addCheckStateListener (ICheckStateListener listener) {
		listChooser.addCheckStateListener(listener);
	}

	public void removeCheckStateListener(ICheckStateListener listener) {
		listChooser.removeCheckStateListener(listener);
	}			
}
