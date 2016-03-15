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

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.NewProjectAction;

public abstract class AbstractOpenWizardAction extends Action {
	
	private Shell fShell;
	private IStructuredSelection fSelection;
	private IJavaElement fCreatedElement;
	
	/**
	 * Creates the action.
	 */
	protected AbstractOpenWizardAction() {
		fShell= null;
		fSelection= null;
		fCreatedElement= null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	public void run() {
		Shell shell= getShell();
		if (!doCreateProjectFirstOnEmptyWorkspace(shell)) {
			return;
		}
		try {
			INewWizard wizard= createWizard();
			wizard.init(PlatformUI.getWorkbench(), getSelection());
			
			WizardDialog dialog= new WizardDialog(shell, wizard);
			dialog.create();
			int res= dialog.open();
//			if (res == Window.OK && wizard instanceof NewElementWizard) {
//				fCreatedElement= ((NewElementWizard)wizard).getCreatedElement();
//			}
			
			notifyResult(res == Window.OK);
		} catch (CoreException e) {
//			String title= NewWizardMessages.AbstractOpenWizardAction_createerror_title; 
//			String message= NewWizardMessages.AbstractOpenWizardAction_createerror_message; 
//			ExceptionHandler.handle(e, shell, title, message);
		}
	}
	
	/**
	 * Creates and configures the wizard. This method should only be called once.
	 * @return returns the created wizard.
	 * @throws CoreException exception is thrown when the creation was not successful.
	 */
	abstract protected INewWizard createWizard() throws CoreException;
	
	/**
	 * Returns the configured selection. If no selection has been configured using {@link #setSelection(IStructuredSelection)},
	 * the currently selected element of the active workbench is returned.
	 * @return the configured selection
	 */
	protected IStructuredSelection getSelection() {
		if (fSelection == null) {
			return evaluateCurrentSelection();
		}
		return fSelection;
	}
			
	private IStructuredSelection evaluateCurrentSelection() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			ISelection selection= window.getSelectionService().getSelection();
			if (selection instanceof IStructuredSelection) {
				return (IStructuredSelection) selection;
			}
		}
		return StructuredSelection.EMPTY;
	}
	
	/**
	 * Configures the selection to be used as initial selection of the wizard. 
	 * @param selection the selection to be set or <code>null</code> to use the selection of the active workbench window
	 */
	public void setSelection(IStructuredSelection selection) {
		fSelection= selection;
	}
	
	/**
	 * Returns the configured shell. If no shell has been configured using {@link #setShell(Shell)},
	 * 	the shell of the currently active workbench is returned.
	 * @return the configured shell
	 */
	protected Shell getShell() {
		if (fShell == null) {
			return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		}
		return fShell;
	}
	
	/**
	 * Configures the shell to be used as parent shell by the wizard.
	 * @param shell the shell to be set or <code>null</code> to use the shell of the active workbench window
	 */
	public void setShell(Shell shell) {
		fShell= shell;
	}
	
	/**
	 * Opens the new project dialog if the workspace is empty. This method is called on {@link #run()}.
	 * @param shell the shell to use
	 * @return returns <code>true</code> when a project has been created, or <code>false</code> when the
	 * new project has been canceled.
	 */
	protected boolean doCreateProjectFirstOnEmptyWorkspace(Shell shell) {
		IWorkspaceRoot workspaceRoot= ResourcesPlugin.getWorkspace().getRoot();
		if (workspaceRoot.getProjects().length == 0) {
//			String title= NewWizardMessages.AbstractOpenWizardAction_noproject_title; 
//			String message= NewWizardMessages.AbstractOpenWizardAction_noproject_message; 
			String title= "noproject_title"; 
			String message= "noproject_message"; 
			if (MessageDialog.openQuestion(shell, title, message)) {
				new NewProjectAction().run();
				return workspaceRoot.getProjects().length != 0;
			}
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the created element or <code>null</code> if the wizard has not run or was canceled.
	 * @return the created element or <code>null</code>
	 */
	public IJavaElement getCreatedElement() {
		return fCreatedElement;
	}
	
	
}

