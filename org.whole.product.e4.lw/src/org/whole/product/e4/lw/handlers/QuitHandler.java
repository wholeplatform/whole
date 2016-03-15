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
package org.whole.product.e4.lw.handlers;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;

/**
 * @author Enrico Persiani
 */
public class QuitHandler {
	@Execute
	public void execute(EPartService partService, IWorkbench workbench, Shell shell) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.whole.product.e4.lw");
		boolean exitWithoutPrompt = preferences.getBoolean("exitWithoutPrompt", false);
		if (exitWithoutPrompt) {
			safeCloseWorkbench(partService, workbench);
			return;
		}

		MessageDialogWithToggle dialog = MessageDialogWithToggle.openOkCancelConfirm(shell, "Confirm exit", 
				"Exit Whole Platform?", "Always exit without prompt", exitWithoutPrompt, null, null);
		if (dialog.getReturnCode() == Window.OK) {
			preferences.putBoolean("exitWithoutPrompt", dialog.getToggleState());
			try {
				preferences.flush();
			} catch (BackingStoreException e) {
			}
			safeCloseWorkbench(partService, workbench);
		}
	}

	protected void safeCloseWorkbench(EPartService partService, IWorkbench workbench) {
		if (!partService.getDirtyParts().isEmpty())
			partService.saveAll(true);
		workbench.close();
	}
}
