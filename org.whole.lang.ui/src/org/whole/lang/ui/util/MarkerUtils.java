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
package org.whole.lang.ui.util;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class MarkerUtils {
	public static final String MARKER_TYPE = "org.whole.lang.ui.wholemarker";
	public static final String PROBLEM_MARKER_TYPE = "org.whole.lang.ui.wholeproblem";

	public static IMarker addMarker(IResource resource, int severity, String message, IEntity entity, String location) throws CoreException {
		return addMarker(resource, PROBLEM_MARKER_TYPE, severity, message, entity, location);
	}
	public static IMarker addMarker(IResource resource, String markerType, int severity, String message, IEntity entity, String location) throws CoreException {
		IMarker marker = resource.createMarker(markerType);
		marker.setAttribute(IMarker.SEVERITY, severity);
		marker.setAttribute(IMarker.MESSAGE, message);
		marker.setAttribute(IMarker.LOCATION, location);
		String path = EntityUtils.getLocation(entity);
		marker.setAttribute("uri", path);
		return marker;
	}

	public static void deleteMarkers(IResource resource, boolean deep) throws CoreException {
		deleteMarkers(resource, PROBLEM_MARKER_TYPE, deep);
	}
	public static void deleteMarkers(IResource resource, String markerType, boolean deep) throws CoreException {
		resource.deleteMarkers(markerType, true, deep ? IResource.DEPTH_INFINITE : IResource.DEPTH_ZERO);
	}

	public static IMarker[] findMarkers(IResource resource, boolean deep) {
		return findMarkers(resource, PROBLEM_MARKER_TYPE, deep);
	}
	public static IMarker[] findMarkers(IResource resource, String markerType, boolean deep) {
		try {
			return resource.findMarkers(markerType, true, deep ? IResource.DEPTH_INFINITE : IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
			return new IMarker[0];
		}
	}
}
