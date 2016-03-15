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
package org.whole.lang.operations;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceRuleFactory;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.util.MarkerUtils;

/**
 * @author Riccardo Solmi
 */
public class WorkspaceDecorationManager extends AbstractDecorationManager {
	protected IResource resource;
	protected IProgressMonitor monitor;

	public WorkspaceDecorationManager() {
		this(null);
	}
	public WorkspaceDecorationManager(IProgressMonitor monitor) {
		this(null, monitor);
	}
	public WorkspaceDecorationManager(IResource resource, IProgressMonitor monitor) {
		this.resource = resource;
		this.monitor = monitor;
	}

	protected int getSeverity(DecorationKind kind) {
		switch (kind) {
		case ERROR:
		case ERROR_ASSIST:
			return IMarker.SEVERITY_ERROR;
		case WARNING:
		case WARNING_ASSIST:
			return IMarker.SEVERITY_WARNING;
		case INFO:
			return IMarker.SEVERITY_INFO;
		default:
			return -1;
		}
	}

	public void addDecoration(DecorationKind kind, final IEntity entity, final String message, final String location) {
		final int severity = getSeverity(kind);
		if (resource != null && severity != -1) {
			try {
				IResourceRuleFactory ruleFactory = ResourcesPlugin.getWorkspace().getRuleFactory();
				ResourcesPlugin.getWorkspace().run(
						new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor) throws CoreException {
								MarkerUtils.addMarker(resource, severity, message, entity, location);
							}
						}, ruleFactory.markerRule(resource), 0, monitor);
			} catch (CoreException e) {
			}
		}
	}

	public void deleteDecorations(IEntity entity, final boolean deep) {
		if (resource != null)
			try {
				IResourceRuleFactory ruleFactory = ResourcesPlugin.getWorkspace().getRuleFactory();
				ResourcesPlugin.getWorkspace().run(
						new IWorkspaceRunnable() {
							public void run(IProgressMonitor monitor) throws CoreException {
								MarkerUtils.deleteMarkers(resource, deep);
							}
						}, ruleFactory.markerRule(resource), 0, monitor);
			} catch (CoreException e) {
			}
	}
}
