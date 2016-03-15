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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.model.WorkbenchViewerComparator;
import org.whole.lang.artifacts.templates.WorkspaceTemplate;
import org.whole.lang.builders.ModelBuilderOperation;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class WizardArtifactsModelImportPage1 extends AbstractWizardWholeModelImportPage {
	private TreeViewer resourceChooser;

	public WizardArtifactsModelImportPage1(IWorkbench workbench, IStructuredSelection selection) {
		super("artifactsModelImportPage1", workbench, selection);
		setTitle("Import Artifacts Model");
		setDescription("Import resources from the Workspace into an Artifacts model");
	}

//	private IArtifactsEntity getContextEntity(String name, IEntity model) {
//		//TODO only for testing purpose
//		IArtifactsEntity pattern = ArtifactsEntityFactory.instance.createFolderArtifact(
//				GenericEntityFactory.instance.create(ArtifactsEntityDescriptorEnum.Name, name), 
//				CommonsEntityAdapterFactory.createVariable(ArtifactsEntityDescriptorEnum.Metadata, "metadata"), 
//				CommonsEntityAdapterFactory.createVariable(ArtifactsEntityDescriptorEnum.Artifacts, "artifacts"));
//		IArtifactsEntity entity = Matcher.find(pattern, model, false);
//		if (entity == null)
//			entity = (IArtifactsEntity) model;
//		Metadata metadata = ArtifactsEntityFactory.instance.createMetadata();
//		metadata.wSet(ArtifactsFeatureDescriptorEnum.persistenceKitId,
//				GenericEntityFactory.instance.create(ArtifactsEntityDescriptorEnum.PersistenceKitId,
//				"org.whole.lang.text.codebase.TextSourcePersistenceKit"));
//		entity.wSet(ArtifactsFeatureDescriptorEnum.metadata, metadata);
//		return entity;
//	}

	@Override
	protected IEntity buildModel() {
		ModelBuilderOperation op = new ModelBuilderOperation();
		IResource resource = (IResource) ((IStructuredSelection)resourceChooser.getSelection()).getFirstElement();
		WorkspaceTemplate template = new WorkspaceTemplate(resource);
		template.apply(op);
		IEntity model = op.wGetResult();
//		IArtifactsEntity context = getContextEntity(resource.getName(), model);
//		if (context != null) {
//			IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
//			LoadContentsVisitor.loadContents(context, bindings);
//		}
		return model;
	}

	@Override
	protected void createSourceGroup(Composite parent) {
		resourceChooser = new TreeViewer(parent);
		GridLayout listAreaLayout = new GridLayout();
		listAreaLayout.marginWidth = 0;
		parent.setLayout(listAreaLayout);
		resourceChooser.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		resourceChooser.setContentProvider(new WorkbenchContentProvider());
		resourceChooser.setLabelProvider(new WorkbenchLabelProvider());
		resourceChooser.setComparator(new WorkbenchViewerComparator());
		resourceChooser.setInput(ResourcesPlugin.getWorkspace());
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
		if(resourceChooser != null && resourceChooser.getSelection().isEmpty()) {
			setErrorMessage("A resource must be choosen.");
			return false;		
		} else
			return true;
	}
}
