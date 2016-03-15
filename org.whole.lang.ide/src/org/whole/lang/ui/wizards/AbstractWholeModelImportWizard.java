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

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.ide.IDE;
import org.whole.lang.ui.util.UIUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractWholeModelImportWizard extends Wizard implements IImportWizard {
	protected IWorkbench workbench;
	protected IStructuredSelection selection;

	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		this.workbench = workbench;
		this.selection = currentSelection;

        List<?> selectedResources = IDE.computeSelectedResources(currentSelection);
        if (!selectedResources.isEmpty())
            this.selection = new StructuredSelection(selectedResources);

        setDefaultPageImageDescriptor(UIUtils.getImageDescriptor("icons/wizards/importproj_wiz.png"));
		setNeedsProgressMonitor(true);
	}

    public boolean performCancel() {
        return true;
    }
}
