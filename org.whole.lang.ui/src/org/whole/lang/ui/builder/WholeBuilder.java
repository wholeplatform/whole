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
package org.whole.lang.ui.builder;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.framework.Bundle;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.util.MarkerUtils;

public class WholeBuilder extends IncrementalProjectBuilder {
	public static final String BUILDER_ID = "org.whole.lang.ui.WholeBuilder";

	protected IProject[] build(int kind, @SuppressWarnings("rawtypes") Map args, IProgressMonitor monitor)
			throws CoreException {
		
		if (WholeUIPlugin.getDefault().getBundle().getState() != Bundle.ACTIVE || monitor.isCanceled())
			return null;

		if (kind == FULL_BUILD)
			fullBuild(monitor);
		else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null)
				fullBuild(monitor);
			else
				incrementalBuild(delta, monitor);
		}
		return null;
	}

	protected void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new WholeResourceVisitor());
		} catch (CoreException e) {
		}
	}
	protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		delta.accept(new WholeResourceDeltaVisitor());
	}

	class WholeResourceVisitor implements IResourceVisitor {
		public boolean visit(IResource resource) {
			//TODO handle resource
			return false; //return true to continue visiting children.
		}
	}

	class WholeResourceDeltaVisitor implements IResourceDeltaVisitor {
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				//TODO handle added resource
				break;
			case IResourceDelta.REMOVED:
				//TODO handle removed resource
				break;
			case IResourceDelta.CHANGED:
				//TODO handle changed resource
				break;
			}
			return false; //return true to continue visiting children.
		}
	}

	void checkResource(IResource resource) throws CoreException {
		if (resource instanceof IFile && resource.getName().endsWith(".whole")) {
			IFile file = (IFile) resource;
			MarkerUtils.deleteMarkers(file, true);
			//TODO
		}
	}
}
