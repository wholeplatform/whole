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
package org.whole.examples;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.HandlerEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Riccardo Solmi
 */
public class ExamplesContributionsDeployerHandler extends AbstractHandler implements IRunnableWithProgress {
	private boolean enabled = true;
	public boolean isEnabled() {
		return enabled;
	}

	protected void setEnabled(boolean isEnabled) {
		if (enabled != isEnabled) {
			enabled = isEnabled;
			fireHandlerChanged(new HandlerEvent(this, true, false));
		}
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		setEnabled(false);
		try {
			Shell activeShell = Display.getCurrent().getActiveShell();
			new ProgressMonitorDialog(activeShell).run(true, true, this);
		} catch (Exception e) {
			throw new ExecutionException("Whole Examples actions deploy failed", e);
		}
		return null;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		monitor.beginTask("Activating examples...", 100);
		ReflectionFactory.deploy(ExamplesContributionsDeployer.class);
		monitor.done();
	}
}
