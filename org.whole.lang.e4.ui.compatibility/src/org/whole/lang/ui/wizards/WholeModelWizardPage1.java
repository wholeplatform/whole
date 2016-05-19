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

import static org.whole.lang.ui.util.ResourceUtils.defineResourceBindings;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.util.ResourceUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class WholeModelWizardPage1 extends WizardNewFileCreationPage {
	private List<ILanguageKit> languageKits;
	private ITemplateManager templateFactory;
	private String[] templates;
	private List<IPersistenceKit> persistenceKits;
	
	private IWorkbench workbench;
	private static int exampleCount = 1;
	private Combo languageCombo;
	private Combo templateCombo;
	private Combo saveAsCombo;
	
	public WholeModelWizardPage1(IWorkbench aWorkbench, IStructuredSelection selection) {
		super("sampleModelPage1", selection);
		this.setTitle("Whole Model");
		this.setDescription("Create a new Whole Model");
		this.setImageDescriptor(ImageDescriptor.createFromFile(E4CompatibilityPlugin.class,"images/banner.png"));
		this.workbench = aWorkbench;
	}

	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite composite = (Composite)getControl();
		
		Group group = new Group(composite, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setText("Choose options");
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group.setLayout(gridLayout);
		
		new Label(group, SWT.LEFT).setText("Language:");
        languageCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
        languageCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		new Label(group, SWT.LEFT).setText("Template:");
		templateCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		templateCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		new Label(group, SWT.LEFT).setText("Save As:");
		saveAsCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		saveAsCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		languageKits = new ArrayList<ILanguageKit>(
				registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR));
		for (ILanguageKit languageKit : languageKits)
			languageCombo.add(ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit));

		languageCombo.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				ILanguageKit languageKit = languageKits.get(languageCombo.getSelectionIndex());
				fireLanguageSelected(languageKit);
			}
		});
		languageCombo.select(0);
		ILanguageKit languageKit = languageKits.get(0);		
		fireLanguageSelected(languageKit);

		saveAsCombo.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				String name = getFileName();
				name = StringUtils.replaceExtension(name,
						getPersistenceKit(saveAsCombo).getFileExtension());
				//TODO mediated by languageKit
				setFileName(name);
			}
		});

		setPageComplete(validatePage());
	}

	protected void fireLanguageSelected(ILanguageKit languageKit) {
		String name = getFileName();
		if (name == null || name.isEmpty())
			name = "ModelExample" + exampleCount;
		setFileName(StringUtils.replaceExtension(name, languageKit.getDefaultFileExtension()));

		templateFactory = languageKit.getTemplateManager();
		templates = templateFactory.names().toArray(new String[0]);
		templateCombo.setItems(templates);
		templateCombo.select(templates.length-1);

		persistenceKits = new ArrayList<IPersistenceKit>(languageKit.getPersistenceKits());
		saveAsCombo.setItems(new String[0]);
		for (IPersistenceKit persistenceKit : persistenceKits)
			saveAsCombo.add(persistenceKit.getDescription());
		int selectionIndex = persistenceKits.indexOf(languageKit.getDefaultPersistenceKit());
		saveAsCombo.select(selectionIndex);
	}

	protected IFile fileHandle;
    protected IFile createFileHandle(IPath filePath) {
		return fileHandle = super.createFileHandle(filePath);
	}
    protected IPersistenceKit persistenceKit;
	protected InputStream getInitialContents() {
		IEntity model = templateFactory.create(templates[templateCombo.getSelectionIndex()]);		
		persistenceKit = getPersistenceKit(saveAsCombo);

		try {
			IPersistenceProvider pp = new StringPersistenceProvider();
			defineResourceBindings(pp.getBindings(), fileHandle);
			persistenceKit.writeModel(model, pp);
			return pp.openInputStream();
		} catch (Exception e) {
			throw new IllegalStateException("error writing file contents", e);
		}
	}

	private IPersistenceKit getPersistenceKit(Combo saveAsCombo) {
		return persistenceKits.get(saveAsCombo.getSelectionIndex());
	}
	
	public boolean finish() {
		try {
			IFile newFile = createNewFile();

			String editorID = ReflectionFactory.getEditorIdFromPersistenceKit(persistenceKit);
			IDE.setDefaultEditor(newFile, editorID);

			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
            IDE.openEditor(page, newFile, true);

            exampleCount++;
            return true;
		} catch (Exception e) {
			E4CompatibilityPlugin.reportError(getShell(), "Create model error", "Unable to create a new model.", e);
			return false;
		}
	}
}
