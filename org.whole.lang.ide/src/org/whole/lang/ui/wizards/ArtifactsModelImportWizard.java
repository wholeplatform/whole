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
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

/**
 * @author Enrico Persiani
 */
public class ArtifactsModelImportWizard extends AbstractWholeModelImportWizard implements IImportWizard {
	private WizardArtifactsModelImportPage1 mainPage;
	private String IMPORT_WIZARD_TITLE = "Import Artifacts model";

	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(IMPORT_WIZARD_TITLE);
	}

	public void addPages() {
        super.addPages();
        mainPage = new WizardArtifactsModelImportPage1(workbench, selection);
        addPage(mainPage);
	}

	public boolean performFinish() {
        return mainPage.importModel();
    }
}
