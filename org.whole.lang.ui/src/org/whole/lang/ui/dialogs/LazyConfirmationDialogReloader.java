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
package org.whole.lang.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Control;

/**
 * @author Enrico Persiani
 */
public class LazyConfirmationDialogReloader extends FocusAdapter {
	protected List<IResource> resources;
	protected Runnable updater;
	protected Control control;
	protected boolean scheduled;

	public LazyConfirmationDialogReloader(Control control, Runnable reloader) {
		this.resources = new ArrayList<IResource>();
		this.control = control;
		this.updater = reloader;
		this.scheduled = false;
	}
	
	protected String getConfirmTitle() {
		return resources.size() > 1 ? "Models Changed" : "Model Changed";
	}
	
	protected String getConfirmMessage() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < resources.size(); i++) {
			IResource resource = resources.get(i);
			if (i>0)
				sb.append(", ");
			sb.append('\'');
			sb.append(resource.getFullPath());
			sb.append('\'');
		}
		return String.format(resources.size() > 1 ? 
				"The models %s have been changed on the file system.":
					"The model %s has been changed on the file system.", sb.toString())
					+ " Reloading will discard changes, reload anyway?";
	}

	@Override
	public void focusGained(FocusEvent e) {
		showMessageDialog();
		control.removeFocusListener(this);
	}

	protected void showMessageDialog() {
		control.getDisplay().asyncExec(new Runnable() {
			public void run() {
				scheduled = false;
				if (MessageDialog.openConfirm(control.getDisplay().getActiveShell(),
						getConfirmTitle(), getConfirmMessage()))
					updater.run();
				resources.clear();
			}
		});
	}

	public void schedule(final IResource resource) {
		control.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				resources.add(resource);
				if (!scheduled) {
					if (!control.isVisible()) {
						control.addFocusListener(LazyConfirmationDialogReloader.this);
						scheduled = true;
					} else
						showMessageDialog();
				}
			}
		});
	}
}
