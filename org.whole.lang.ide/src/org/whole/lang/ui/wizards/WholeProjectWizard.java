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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.templates.codebase.ProjectsArtifactsTemplateManager;
import org.whole.lang.util.BehaviorUtils;

public class WholeProjectWizard extends Wizard implements INewWizard {
	protected IWorkbench workbench;
	protected IPath projectLocation;
	protected IProject project;
	protected String projectName;
	protected WizardNewProjectCreationPage newProjectCreationPage;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		//TODO setDefaultPageImageDescriptor(getImage("NewEmptyWholeProject"));
		setWindowTitle("New Whole Project");
	}

	protected boolean validateProject(IProject project, IPath location) {
		this.project = project;
		this.projectName = project.getName();
		this.projectLocation = Platform.getLocation().equals(location) ? null : location;
		return true;
	}

	public void addPages() {
		newProjectCreationPage = new WizardNewProjectCreationPage("NewProjectCreationPage") {
			protected boolean validatePage() {
				return super.validatePage() &&
					validateProject(getProjectHandle(), getLocationPath());
			}
		};

		newProjectCreationPage.setTitle("Whole Project");
		newProjectCreationPage.setDescription("Create an empty Java project, setting up the classpath to use Whole");
		addPage(newProjectCreationPage);
	}

	public boolean performFinish() {
		// outside WorkspaceModifyOperation.execute() due to a concurrency bug of OSGI
		final IBindingManager params = BindingManagerFactory.instance.createArguments();
		params.wDefValue("projectName", projectName);
		if (!newProjectCreationPage.useDefaults())
			params.wDefValue("locationURI", newProjectCreationPage.getLocationURI());
		
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor progressMonitor) {
				try {
					progressMonitor.beginTask("Generating...", IOperationProgressMonitor.TOTAL_WORK);
					params.wDefValue("progressMonitor", 
							new OperationProgressMonitorAdapter(progressMonitor));
					
					IEntity projectTemplate = ProjectsArtifactsTemplateManager.instance().create("WholeProject");
					projectTemplate = BehaviorUtils.evaluate(projectTemplate, 1, params);
					Matcher.removeVars(projectTemplate, false);
					ArtifactsGeneratorOperation.generate(projectTemplate, params);
				} catch (Exception exception) {
					E4CompatibilityPlugin.log(exception);
				} finally {
					progressMonitor.done();
				}
			}
		};

		try {
			getContainer().run(false, false, operation);
		} catch (Exception exception) {
			E4CompatibilityPlugin.log(exception);
			return false;
		}

		if (project != null) {
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(project);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget) activePart).selectReveal(targetSelection);
					}
				});
			}
		}

		return true;
	}
}
