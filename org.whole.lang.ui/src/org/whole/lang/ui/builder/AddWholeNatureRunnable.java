/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

public class AddWholeNatureRunnable implements IWorkspaceRunnable {
	protected List projects = new ArrayList();

	public AddWholeNatureRunnable(Collection objects) {
		Iterator i = objects.iterator();
		while (i.hasNext()) {
			Object object = i.next();
			if (object instanceof IProject)
				projects.add(object);
		}
	}

	public void run(IProgressMonitor monitor) throws CoreException {
		if (!projects.isEmpty()) {
			monitor.beginTask("", projects.size());
			monitor.subTask("Add Whole Nature");

			Iterator i = projects.iterator();
			while (i.hasNext()) {
				IProject project = (IProject) i.next();

				monitor.subTask("Add Whole project nature to "+ project.getName());
				
				IProjectDescription description = project.getDescription();
				String[] natures = description.getNatureIds();
				String[] newNatures = new String[natures.length + 1];
				System.arraycopy(natures, 0, newNatures, 1, natures.length);
				newNatures[0] = WholeNature.NATURE_ID;
				description.setNatureIds(newNatures);
				project.setDescription(description, new SubProgressMonitor(monitor, 1));
			}

			monitor.done();
		}
	}
}
