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
package org.whole.lang.ui.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ActiveEditorHelper implements Runnable {
	private IEditorPart editorPart;
	public void run() {
		editorPart = getActiveEditor();
	}
	private static IEditorPart getActiveEditor() {
		try {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench != null) {
				IWorkbenchWindow activeWorkbenchWindow = workbench.getActiveWorkbenchWindow();
				if (activeWorkbenchWindow != null) {
					IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
					if (activePage != null)
						return activePage.getActiveEditor();
				}
			}
		} catch (Exception e) {
		}
		return null;
	}
	public static IEditorPart findActiveEditor() {
		if (Display.getCurrent() == null) {
			ActiveEditorHelper helper = new ActiveEditorHelper();
			Display.getDefault().syncExec(helper);
			return helper.editorPart;
		} else
			return getActiveEditor();
	}
}
