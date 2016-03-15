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

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * A registry that maps <code>ImageDescriptors</code> to <code>Image</code>.
 * @see org.eclipse.jdt.internal.ui.viewsupport.ImageDescriptorRegistry
 */
public class WholeImageDescriptorRegistry {
	private HashMap<ImageDescriptor, Image> registryMap = new HashMap<ImageDescriptor, Image>(10);
	private Display display;

	/**
	 * Creates a new image descriptor registry for the current or default display,
	 * respectively.
	 */
	public WholeImageDescriptorRegistry() {
		this(getStandardDisplay());
	}
	
	/**
	 * Creates a new image descriptor registry for the given display. All images
	 * managed by this registry will be disposed when the display gets disposed.
	 * 
	 * @param display the display the images managed by this registry are allocated for 
	 */
	public WholeImageDescriptorRegistry(Display display) {
		this.display = display;
		Assert.isNotNull(display);
		hookDisplay();
	}
	
	/**
	 * Returns the image associated with the given image descriptor.
	 * 
	 * @param descriptor the image descriptor for which the registry manages an image
	 * @return the image associated with the image descriptor or <code>null</code>
	 *  if the image descriptor can't create the requested image.
	 */
	public Image get(ImageDescriptor descriptor) {
		if (descriptor == null)
			descriptor= ImageDescriptor.getMissingImageDescriptor();
			
		Image result= registryMap.get(descriptor);
		if (result != null)
			return result;
	
		Assert.isTrue(display == getStandardDisplay(), "Allocating image for wrong display."); //$NON-NLS-1$
		result= descriptor.createImage();
		if (result != null)
			registryMap.put(descriptor, result);
		return result;
	}

	/**
	 * Disposes all images managed by this registry.
	 */	
	public void dispose() {
		for (Iterator<Image> iter = registryMap.values().iterator(); iter.hasNext(); ) {
			Image image = iter.next();
			image.dispose();
		}
		registryMap.clear();
	}
	
	private void hookDisplay() {
		display.disposeExec(new Runnable() {
			public void run() {
				dispose();
			}	
		});
	}

	private static Display getStandardDisplay() {
		Display display;
		display = Display.getCurrent();
		if (display == null)
			display = Display.getDefault();
		return display;		
	}
}
