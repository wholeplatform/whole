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
package org.whole.lang.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

/*
 * @see org.eclipse.jdt.ui.ProblemsLabelDecorator
 */
public class ProblemsImageDecorator {
	private static final int ERRORTICK_WARNING = WholeCompositeImageDescriptor.WARNING;
	private static final int ERRORTICK_ERROR = WholeCompositeImageDescriptor.ERROR;	

	private WholeImageDescriptorRegistry registry;

	public Image decorateImage(Image image, Object obj) {
		int adornmentFlags= computeAdornmentFlags(obj);
		if (adornmentFlags != 0) {
			ImageDescriptor baseImage= new WholeImageDescriptor(image);
			Rectangle bounds= image.getBounds();
			return getRegistry().get(new WholeCompositeImageDescriptor(baseImage, adornmentFlags, new Point(bounds.width, bounds.height)));
		}
		return image;
	}
	
	private WholeImageDescriptorRegistry getRegistry() {
		if (registry == null) {
			registry = new WholeImageDescriptorRegistry();
		}
		return registry;
	}
	
	private static int computeAdornmentFlags(Object obj) {
		if (obj instanceof IResource) {
			try {
				return getErrorTicksFromMarkers((IResource) obj, IResource.DEPTH_INFINITE);
			} catch (CoreException e) {
				throw new IllegalStateException(e);
			}
		}
		return 0;
	}
	
	private static int getErrorTicksFromMarkers(IResource res, int depth) throws CoreException {
		if (res == null || !res.isAccessible()) {
			return 0;
		}
		int info= 0;
		
		IMarker[] markers= res.findMarkers(IMarker.PROBLEM, true, depth);
		if (markers != null) {
			for (int i= 0; i < markers.length && (info != ERRORTICK_ERROR); i++) {
				IMarker curr= markers[i];
				int priority= curr.getAttribute(IMarker.SEVERITY, -1);
				if (priority == IMarker.SEVERITY_WARNING) {
					info= ERRORTICK_WARNING;
				} else if (priority == IMarker.SEVERITY_ERROR) {
					info= ERRORTICK_ERROR;
				}
			}			
		}
		return info;
	}
}
