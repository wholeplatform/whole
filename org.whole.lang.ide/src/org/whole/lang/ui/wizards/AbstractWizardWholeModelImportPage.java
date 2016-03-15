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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardResourceImportPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.reflect.PojoLanguageKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractWizardWholeModelImportPage extends WizardResourceImportPage {

	private IWorkbench workbench;
	private Text filenameField;
	private Combo presistenceTypes;
	private List<IPersistenceKit> persistenceKits;
	private static int filenameCount = 1;

	@Override
	protected boolean allowNewContainerName() {
		return super.allowNewContainerName();
	}

	@Override
	public void handleEvent(Event event) {
		super.handleEvent(event);
	}

	public AbstractWizardWholeModelImportPage(String pageName, IWorkbench workbench, IStructuredSelection selection) {
		super(pageName, selection);
		this.workbench = workbench;
	}

	@Override
	protected abstract void createSourceGroup(Composite parent);

	protected final void createOptionsGroup(Composite parent) {
		Composite containerGroup = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		containerGroup.setLayout(layout);
		containerGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		containerGroup.setFont(parent.getFont());

		// resource label
		Label filenameLabel = new Label(containerGroup, SWT.NONE);
		filenameLabel.setText("File name: ");
		filenameLabel.setFont(parent.getFont());

		filenameField = new Text(containerGroup, SWT.SINGLE | SWT.BORDER);
		filenameField.addListener(SWT.Modify, this);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, true);
		filenameField.setLayoutData(data);
		filenameField.setFont(parent.getFont());

		// presistence label
		Label presistenceLabel = new Label(containerGroup, SWT.NONE);
		presistenceLabel.setText("Save as: ");
		presistenceLabel.setFont(parent.getFont());

		presistenceTypes = new Combo(containerGroup, SWT.DROP_DOWN | SWT.READ_ONLY);
		presistenceTypes.addListener(SWT.Modify, this);
		presistenceTypes.setLayoutData(data);
		presistenceTypes.setFont(parent.getFont());

		initOptionsGroup();
	}

	private void initOptionsGroup() {
		ILanguageKit languageKit = ReflectionFactory.getLanguageKit(PojoLanguageKit.URI, false, null);
		setFilename("ModelExample" + filenameCount + "." + languageKit.getDefaultFileExtension());
		persistenceKits = new ArrayList<IPersistenceKit>(languageKit.getPersistenceKits());
		Iterator<IPersistenceKit> iterator = persistenceKits.iterator();
		presistenceTypes.setItems(new String[0]);
		while (iterator.hasNext())
			presistenceTypes.add(iterator.next().getDescription());

		int selectionIndex = persistenceKits.indexOf(languageKit.getDefaultPersistenceKit());
		presistenceTypes.select(selectionIndex);
		presistenceTypes.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				String name = getFilename();
				name = StringUtils.replaceExtension(name,
						getPersistenceKit(presistenceTypes).getFileExtension());
				setFilename(name);
			}
		});
	}

	protected String getFilename() {
		if (filenameField != null)
			return filenameField.getText();
		else
			return null;
	}

	protected void setFilename(String filename) {
		filenameField.setText(filename);
	}

	@Override
	protected ITreeContentProvider getFileProvider() {
		return new WorkbenchContentProvider() {
			public Object[] getChildren(Object o) {
				return new Object[0];
			}
		};
	}

	@Override
	protected ITreeContentProvider getFolderProvider() {
		return new WorkbenchContentProvider() {
			public Object[] getChildren(Object o) {
				return new Object[0];
			}
		};
	}

	protected abstract IEntity buildModel();

	protected IPersistenceKit persistenceKit;
	protected boolean createNewFile(IFile fileHandle) {
		IEntity model = buildModel();
		persistenceKit = getPersistenceKit(presistenceTypes);

		try {
			persistenceKit.writeModel(model, new IFilePersistenceProvider(fileHandle));
			return true;
		}
		catch (Exception e) {
			IEclipseContext context = (IEclipseContext) PlatformUI.getWorkbench().getService(IEclipseContext.class);
			E4Utils.reportError(context, "Write Model errors", StringUtils.errorMessage(e), e);
			return false;
		}
	}

	public boolean importModel() {
		IFile file = null;
		IContainer container = getSpecifiedContainer();
		switch (container.getType()) {
		case IContainer.FOLDER:
			IFolder folder = (IFolder) container;
			file = folder.getFile(getFilename());
			break;
		case IContainer.PROJECT:
			IProject project = (IProject) container;
			file = project.getFile(getFilename());
			break;
		}

		// create and open in editor
		if (!createNewFile(file) || !revealAndOpen(file))
			return false;

		filenameCount++;
		return true;
	}

	private boolean revealAndOpen(IFile file) {
		BasicNewResourceWizard.selectAndReveal(file, getWorkbench().getActiveWorkbenchWindow());

		IWorkbenchWindow dw = getWorkbench().getActiveWorkbenchWindow();
		try {
			if (dw != null) {
				IWorkbenchPage page = dw.getActivePage();
				if (page != null) {
					String editorID = ReflectionFactory.getEditorIdFromPersistenceKit(persistenceKit);
					IDE.setDefaultEditor(file, editorID);
					IDE.openEditor(page, file, true);
				}
			}
		} catch (PartInitException e) {
			E4CompatibilityPlugin.log(e);
			return false;
		}
		return true;
	}

	private IPersistenceKit getPersistenceKit(Combo saveAsCombo) {
		return persistenceKits.get(saveAsCombo.getSelectionIndex());
	}

	private boolean existsFilename() {
		IContainer container = getSpecifiedContainer();
		switch (container.getType()) {
		case IContainer.FOLDER:
			IFolder folder = (IFolder) container;
			return folder.getFile(getFilename()).exists();
		case IContainer.PROJECT:
			IProject project = (IProject) container;
			return project.getFile(getFilename()).exists();
		default:
			return false;
		}
	}


	protected boolean determinePageCompletion() {
		if(!super.determinePageCompletion())
			return false;
		else if(getFilename() == null || getFilename().length() == 0) {
			setErrorMessage("Empty file name specified.");
			return false;
		} else if(existsFilename()) {
			setErrorMessage("The same name exists.");
			return false;
		}
		return true;
	}

	public IWorkbench getWorkbench() {
		return workbench;
	}
}
