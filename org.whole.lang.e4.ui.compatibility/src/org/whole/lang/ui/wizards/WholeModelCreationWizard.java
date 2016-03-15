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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author Riccardo Solmi
 */
public class WholeModelCreationWizard extends Wizard implements INewWizard {

	private WholeModelWizardPage1 wizardPage;
	private IStructuredSelection selection;
	private IWorkbench workbench;
	
	public void addPages(){
		super.addPages();
		wizardPage = new WholeModelWizardPage1(workbench, selection);
		addPage(wizardPage);
	}
	
	public void init(IWorkbench aWorkbench, IStructuredSelection currentSelection) {
		setWindowTitle("New Whole Model");
		workbench = aWorkbench;
		selection = currentSelection;
	}
	
	public boolean performFinish(){
		return wizardPage.finish();
	}
}
