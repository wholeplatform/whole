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
package org.whole.lang.ui.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkingSet;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.views.WholeGraphicalViewer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Enrico Persiani
 */
public class WholeSearchPage extends DialogPage implements ISearchPage {
	private ISearchPageContainer container;
	private WholeGraphicalViewer viewer;
	private Combo languageCombo;
	private IEntity pattern;
	private ILanguageKit languageKit;
	private List<ILanguageKit> languageKits;

	public WholeSearchPage() {
		container = null;
		viewer = null;
		languageCombo = null;
		pattern = null;
		languageKit = null;
		languageKits = null;
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		
		// workaround for forced layout in SearchDialog#createPageControl()
		Composite result = new Composite(parent, SWT.NONE) {
			@Override
			public void setLayoutData(Object layoutData) {
				super.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			}
		};

		GridLayout layout = new GridLayout(2, false);
		layout.horizontalSpacing= 10;
		result.setLayout(layout);

		// add a language selection
		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		languageKits = new ArrayList<ILanguageKit>(registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR));
		new Label(result, SWT.LEFT).setText("Language:");
        languageCombo = new Combo(result, SWT.DROP_DOWN | SWT.READ_ONLY);
        languageCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		for (ILanguageKit languageKit : languageKits)
			languageCombo.add(ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit));

		languageCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				ILanguageKit languageKit = (ILanguageKit) languageKits.get(languageCombo.getSelectionIndex());
				handleLanguageKitChange(languageKit);
			}
		});
		languageCombo.select(0);

		// initialize search dialog contents before
		// EmbeddableGraphicalViewer creation 
		setInitialControlsState();

		Composite viewerContainer = new Composite(result, SWT.NONE);
		viewerContainer.setLayout(new FillLayout());
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.horizontalSpan = 2;
		viewerContainer.setLayoutData(gridData);
		viewer = new WholeGraphicalViewer(viewerContainer, pattern);
		
		setControl(result);
		Dialog.applyDialogFont(result);
	}

	private void setInitialControlsState() {
		IEntity initialSelection = getInitialSelection();
		
		if (initialSelection != null) {
			languageKit = initialSelection.wGetLanguageKit();
			pattern = EntityUtils.clone(initialSelection);
			languageCombo.select(languageKits.indexOf(languageKit));
		} else {
			languageKit = (ILanguageKit) languageKits.get(languageCombo.getSelectionIndex());
			pattern = languageKit.getTemplateManager().createEmpty();
		}
	}

	protected void handleLanguageKitChange(ILanguageKit newLanguageKit) {
		if (newLanguageKit != languageKit) {
			this.languageKit = newLanguageKit;
			pattern = languageKit.getTemplateManager().createEmpty();
			viewer.setContents(pattern);
		}
	}

	private IEntity getInitialSelection() {
		Object firstSelected = null;
		ISelection selection = null;
		IEntity model = null;
		
		if (getContainer() != null) {
			selection = getContainer().getSelection();
		}

		if (selection instanceof IStructuredSelection) {
			firstSelected = ((IStructuredSelection)selection).getFirstElement();
		}

		model =  firstSelected instanceof IEntityPart ?
				EntityUtils.clone(((IEntityPart)firstSelected).getModelEntity()) : null;

		// when selection is a RootBaseFragment extract the root child entity
		if (CommonsEntityDescriptorEnum.RootFragment.equals(model.wGetEntityDescriptor()))
			model = model.wGetRoot();

		return model;
	}

	public boolean performAction() {
		return performNewSearch();
	}

	private boolean performNewSearch() {
		IWholeSearchScope scope= null;
		String scopeDescription= "";
		WholeSearchScopeFactory factory = WholeSearchScopeFactory.getInstance();

		switch (getContainer().getSelectedScope()) {
		case ISearchPageContainer.SELECTION_SCOPE:
			ISelection selection = getContainer().getSelection();
			scopeDescription = factory.getSelectionScopeDescription();
			scope = factory.createSelectionScope(selection);
			break;
		case ISearchPageContainer.SELECTED_PROJECTS_SCOPE:
			String[] projectNames = getContainer().getSelectedProjectNames();
			scopeDescription = factory.getProjectsScopeDescription();
			scope = factory.createProjectsScope(projectNames);
			break;
		case ISearchPageContainer.WORKING_SET_SCOPE:
			IWorkingSet[] workingSets = getContainer().getSelectedWorkingSets();
			if (workingSets == null || workingSets.length < 1)
				return false;
			scopeDescription = factory.getWorkingSetScopeDescription();
			scope = factory.createWorkingSetScope(workingSets);
			break;
		case ISearchPageContainer.WORKSPACE_SCOPE:
			scopeDescription = factory.getWorkspaceScopeDescription();
			scope = factory.createWorkspaceScope();
			break;
		}

		WholeQuerySpecification querySpec = new WholeQuerySpecification(scope, scopeDescription, pattern);
		WholeSearchQuery textSearchJob= new WholeSearchQuery(querySpec);
		NewSearchUI.runQueryInBackground(textSearchJob);
		return true;
	}

	public void setContainer(ISearchPageContainer container) {
		this.container = container;
	}
	
	public ISearchPageContainer getContainer() {
		return container;
	}
}
