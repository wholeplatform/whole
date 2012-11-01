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
package org.whole.lang.workflows.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.workflows.model.Assignments;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class TaskDialogHelper {
	private static class UIRunnable implements Runnable {
		private final ITaskDialogFactory factory;
		private final String message;
		private final Assignments assignments;
		private final IBindingManager bindings;
		private final String title;
		private boolean confirmation;

		private UIRunnable(ITaskDialogFactory factory, String title,
				String message, Assignments assignments, IBindingManager bindings) {
			this.factory = factory;
			this.title = title;
			this.message = message;
			this.assignments = assignments;
			this.bindings = bindings;
		}

		public void run() {
			Shell activeShell = Display.getCurrent().getActiveShell();
			Dialog dialog = factory.createDialog(activeShell, title,
					message, assignments, bindings);

			confirmation = dialog.open() == Dialog.OK;
		}

		public boolean getConfirmation() {
			return confirmation;
		}
	}

	public static boolean showTaskDialog(ITaskDialogFactory factory, String title, String message, 
			Assignments assignments, IBindingManager bindings) {
		UIRunnable runnable = new UIRunnable(factory, title, message, assignments, bindings);
		Display.getDefault().syncExec(runnable);
		return runnable.getConfirmation();
	}
}
