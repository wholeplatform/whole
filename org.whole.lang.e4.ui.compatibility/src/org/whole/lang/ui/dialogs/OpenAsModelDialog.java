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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public class OpenAsModelDialog extends ElementTreeSelectionDialog {
	protected Combo persistenceCombo;
	protected IPersistenceKit persistenceKit;
	private List<IPersistenceKit> persistenceKits;

	public OpenAsModelDialog(Shell parent, IPersistenceKit defaultPersistenceKit) {
		this(parent, defaultPersistenceKit, "Open Model As", "Choose a resource");
		setValidator(createPersistenceValidator());
	}
	protected OpenAsModelDialog(Shell parent, IPersistenceKit defaultPersistenceKit, String title, String message) {
		super(parent, createLabelProvider(), createContentProvider());
		this.persistenceKit = defaultPersistenceKit;
		setInput(ResourcesPlugin.getWorkspace());
		setTitle(title); 
		setMessage(message); 
	}

	protected ISelectionStatusValidator createPersistenceValidator() {
		return new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				if (selection.length != 1 || !(selection[0] instanceof IFile))
					return createMultiSelectionStatus();
				try {
					getPersistenceKit().readModel(new IFilePersistenceProvider((IFile) selection[0]));
					return Status.OK_STATUS;
				} catch (Exception e) {
					return createWrongPersistenceStatus();
				}
			}
		};
	}
	protected IStatus createMultiSelectionStatus() {
		return new Status(IStatus.ERROR, E4CompatibilityPlugin.PLUGIN_ID, IStatus.ERROR,
				"Choose a single file", null);
	}
	protected IStatus createWrongPersistenceStatus() {
		return new Status(IStatus.ERROR, E4CompatibilityPlugin.PLUGIN_ID, IStatus.ERROR,
				"Can't open model with selected persistence", null);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Composite group = new Composite(composite, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginWidth = 10;
		group.setLayout(gridLayout);

		addControls(group);

		return composite;
	}

	protected void addControls(Composite group) {
		addPersistenceCombo(group, "Open As:");
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Control buttonBar = super.createButtonBar(parent);
		getOkButton().setFocus();
		return buttonBar;
	}

	protected void addPersistenceCombo(Composite group, String label) {
		new Label(group, SWT.NONE).setText(label);
		persistenceCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		persistenceCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		persistenceKits = new ArrayList<IPersistenceKit>(ReflectionFactory.getPersistenceKits());
		Iterator<IPersistenceKit> i = persistenceKits.iterator();
		persistenceCombo.setItems(new String[0]);
		while (i.hasNext()) {
			IPersistenceKit persistenceKit = i.next();
			persistenceCombo.add(persistenceKit.getDescription());
		}
		persistenceCombo.select(persistenceKits.indexOf(persistenceKit));
		persistenceCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				persistenceKit = persistenceKits.get(persistenceCombo.getSelectionIndex());
				updateOKStatus();
			}
		});
	}

	public IPersistenceKit getPersistenceKit() {
		return persistenceKit;
	}

	protected static ITreeContentProvider createContentProvider() {
		try {
			return (ITreeContentProvider) Class.forName(
					"org.eclipse.ui.model.WorkbenchContentProvider",
					true, ReflectionFactory.getPlatformClassLoader()).newInstance();
		} catch (Exception e) {
			return new ResourceTreeContentProvider();
		}
	}
	protected static ILabelProvider createLabelProvider() {
		try {
			return (ILabelProvider) Class.forName(
					"org.eclipse.ui.model.WorkbenchLabelProvider",
					true, ReflectionFactory.getPlatformClassLoader()).newInstance();
		} catch (Exception e) {
			return new ResourceTreeLabelProvider();
		}
	}

	public static class ResourceTreeContentProvider implements ITreeContentProvider {
		public void dispose() {
		}
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
		public Object[] getElements(Object inputElement) {
			return null;
		}
		public Object[] getChildren(Object parentElement) {
			try {
				if (parentElement instanceof IContainer)
					return ((IContainer) parentElement).members();
			} catch (CoreException e) {
			}
			return null;
		}
		public Object getParent(Object element) {
			return element instanceof IResource ?
					((IResource) element).getParent() : null;
		}
		public boolean hasChildren(Object element) {
			try {
				if (element instanceof IContainer)
					return ((IContainer) element).members().length > 0;
			} catch (CoreException e) {
			}
			return false;
		}
	}
	public static class ResourceTreeLabelProvider implements ILabelProvider {
	    public void addListener(ILabelProviderListener listener) {
	    }
	    public void dispose() {
	    }
	    public boolean isLabelProperty(Object element, String property) {
	        return false;
	    }
	    public void removeListener(ILabelProviderListener listener) {
	    }
	    public Image getImage(Object element) {
	        return null;
	    }
	    public String getText(Object element) {
			return element instanceof IResource ?
					((IResource) element).getName() : null;
	    }
	}
}
