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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.whole.lang.codebase.BeansPersistenceKit;
import org.whole.lang.codebase.DataTypePersistenceKit;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class SaveAsModelDialog extends SaveAsDialog {
	private List<IPersistenceKit> persistenceKits;
	private ComboViewer saveAsCombo;
	private IPersistenceKit defaultPersistenceKit;

	public SaveAsModelDialog(Shell parentShell, IPersistenceKit defaultPersistenceKit) {
		this(parentShell, ReflectionFactory.getPersistenceKits(), defaultPersistenceKit);
	}
	public SaveAsModelDialog(Shell parentShell, ILanguageKit languageKit, IPersistenceKit defaultPersistenceKit) {
		this(parentShell, languageKit.getPersistenceKits(), defaultPersistenceKit);
	}
	public SaveAsModelDialog(Shell parentShell, Collection<IPersistenceKit> persistenceKits, IPersistenceKit defaultPersistenceKit) {
		super(parentShell);
		this.persistenceKits = new ArrayList<IPersistenceKit>(persistenceKits);
		this.defaultPersistenceKit = defaultPersistenceKit;
	}

    protected Control createDialogArea(Composite parent) {
        Composite parentComposite = (Composite) super.createDialogArea(parent);
		
        //workaround to get the file name Text
        Control[] children = parentComposite.getChildren();
        Control c1 = children[1];
        Text cText = null;
        if (c1 instanceof Composite) {
        	children = ((Composite) c1).getChildren();
        	Control c2 = children[0];
        	if (c2 instanceof Composite) {
        		children = ((Composite) c2).getChildren();
            	Control c3 = children[1];
            	if (c3 instanceof Composite) {
            		children = ((Composite) c3).getChildren();
                	Control c4 = children[1];
                	if (c4 instanceof Text)
                		cText = (Text) c4;
            	}
        	}
        }
        final Text textControl = cText;
        	
        Composite group = new Composite(parentComposite, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginWidth = 10;
		group.setLayout(gridLayout);

		new Label(group, SWT.NONE).setText("Save As:");
		saveAsCombo = new ComboViewer(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		saveAsCombo.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		saveAsCombo.setContentProvider(new ArrayContentProvider());
		saveAsCombo.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IPersistenceKit) element).getDescription();
			}
		});
		saveAsCombo.setSorter(new ViewerSorter());
		saveAsCombo.setFilters(new ViewerFilter[] { new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return !BeansPersistenceKit.instance().equals(element) &&
					!DataTypePersistenceKit.instance().equals(element);
			}
		}});
		saveAsCombo.setInput(persistenceKits);
		saveAsCombo.setSelection(new StructuredSelection(defaultPersistenceKit), true);
		saveAsCombo.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (textControl != null) {
					String name = textControl.getText();
					name = StringUtils.replaceExtension(name, getPersistenceKit().getFileExtension());
					//TODO mediated by languageKit
					textControl.setText(name);
				}
			}
		});	
        return parentComposite;
    }

    protected void okPressed() {
    	defaultPersistenceKit = getPersistenceKit();
    	super.okPressed();
    }

    public IPersistenceKit getPersistenceKit() {
    	if (saveAsCombo == null)
    		return defaultPersistenceKit;
    	else {
	    	ISelection selection = saveAsCombo.getSelection();
	   		return selection.isEmpty() ? defaultPersistenceKit : (IPersistenceKit) ((IStructuredSelection) selection).getFirstElement();
    	}
    }

    @Override
    public void setOriginalName(String originalName) {
    	String fileExtension = getPersistenceKit().getFileExtension();
    	if (!StringUtils.toSimpleName(originalName).equals(fileExtension))
			originalName += "." + fileExtension;
    	super.setOriginalName(originalName);
    }
}
