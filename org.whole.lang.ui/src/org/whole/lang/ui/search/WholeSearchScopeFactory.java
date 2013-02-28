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
package org.whole.lang.ui.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkingSet;

/**
 * @author Enrico Persiani
 */
public class WholeSearchScopeFactory {
	private static final WholeSearchScopeFactory instance = new WholeSearchScopeFactory();
	public static WholeSearchScopeFactory getInstance() {
		return instance;
	}
	private WholeSearchScopeFactory() {
	}

	public String getWorkspaceScopeDescription() {
		return "workspace";
	}

	public String getSelectionScopeDescription() {
		return "selected resources";
	}

	public String getProjectsScopeDescription() {
		return "enclosing projects";
	}

	public String getWorkingSetScopeDescription() {
		return "working set";
	}

	public IWholeSearchScope createWorkspaceScope() {
		Set<IResource> roots = Collections.singleton((IResource)ResourcesPlugin.getWorkspace().getRoot());
		return new WholeSearchScope(roots);
	}

	public IWholeSearchScope createSelectionScope(ISelection sel) {
		List<IResource> roots;

		if (sel instanceof IStructuredSelection && !sel.isEmpty()) {
			roots = new ArrayList<IResource>();
			for (Object element : ((IStructuredSelection) sel).toArray())
				if (element instanceof IAdaptable) {
					IAdaptable adaptable = (IAdaptable) element;
					IResource adaptedResource = (IResource) adaptable.getAdapter(IResource.class);
					if (adaptedResource != null)
						roots.add((IResource)adaptedResource);
				}
		} else
			roots = Collections.emptyList();

		return new WholeSearchScope(roots);
	}

	public IWholeSearchScope createProjectsScope(final String[] projectNames) {
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		List<IResource> roots = new ArrayList<IResource>();
		
		for (String projectName : projectNames) {
			roots.add(workspaceRoot.getProject(projectName));
		}
		return new WholeSearchScope(roots);
	}

	public IWholeSearchScope createWorkingSetScope(IWorkingSet[] workingSets) {
		List<IResource> roots = new ArrayList<IResource>();

		for (IWorkingSet workingSet : workingSets) {
			for (IAdaptable adaptable : workingSet.getElements()) {
				IResource res = (IResource) adaptable.getAdapter(IResource.class);
				if (res != null)
					roots.add(res);
			}
		}
		return new WholeSearchScope(roots);
	}
}
