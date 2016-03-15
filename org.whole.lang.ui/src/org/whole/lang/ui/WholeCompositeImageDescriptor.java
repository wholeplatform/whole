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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;

public class WholeCompositeImageDescriptor extends CompositeImageDescriptor {
	/** Flag to render the warning adornment. */
	public final static int WARNING=			0x020;
	
	/** Flag to render the error adornment. */
	public final static int ERROR=			0x040;
	
	private ImageDescriptor fBaseImage;
	private int fFlags;
	private Point fSize;

	/**
	 * Creates a new WholeCompositeImageDescriptor.
	 * 
	 * @param baseImage an image descriptor used as the base image
	 * @param flags flags indicating which adornments are to be rendered. See <code>setAdornments</code>
	 * 	for valid values.
	 * @param size the size of the resulting image
	 * @see #setAdornments(int)
	 */
	public WholeCompositeImageDescriptor(ImageDescriptor baseImage, int flags, Point size) {
		fBaseImage= baseImage;
		Assert.isNotNull(fBaseImage);
		fFlags= flags;
		Assert.isTrue(fFlags >= 0);
		fSize= size;
		Assert.isNotNull(fSize);
	}
	
	/**
	 * Sets the descriptors adornments. Valid values are: </code>WARNING<code>, 
	 * </code>ERROR<code>,  or any combination of those.
	 * @param adornments the image descriptors adornments
	 */
	public void setAdornments(int adornments) {
		Assert.isTrue(adornments >= 0);
		fFlags= adornments;
	}

	/**
	 * Returns the current adornments.
	 * @return the current adornments
	 */
	public int getAdronments() {
		return fFlags;
	}

	/**
	 * Sets the size of the image created by calling <code>createImage()</code>.
	 * @param size the size of the image returned from calling <code>createImage()</code>
	 * @see ImageDescriptor#createImage()
	 */
	public void setImageSize(Point size) {
		Assert.isNotNull(size);
		Assert.isTrue(size.x >= 0 && size.y >= 0);
		fSize= size;
	}
	
	/**
	 * Returns the size of the image created by calling <code>createImage()</code>.
	 * @return the size of the image created by calling <code>createImage()</code>
	 * @see ImageDescriptor#createImage()
	 */
	public Point getImageSize() {
		return new Point(fSize.x, fSize.y);
	}
	
	/* (non-Javadoc)
	 * Method declared in CompositeImageDescriptor
	 */
	protected Point getSize() {
		return fSize;
	}
	
	/* (non-Javadoc)
	 * Method declared on Object.
	 */
	public boolean equals(Object object) {
		if (object == null || !WholeCompositeImageDescriptor.class.equals(object.getClass()))
			return false;
			
		WholeCompositeImageDescriptor other= (WholeCompositeImageDescriptor)object;
		return (fBaseImage.equals(other.fBaseImage) && fFlags == other.fFlags && fSize.equals(other.fSize));
	}
	
	/* (non-Javadoc)
	 * Method declared on Object.
	 */
	public int hashCode() {
		return fBaseImage.hashCode() | fFlags | fSize.hashCode();
	}
	
	/* (non-Javadoc)
	 * Method declared in CompositeImageDescriptor
	 */
	protected void drawCompositeImage(int width, int height) {
		ImageData bg= getImageData(fBaseImage);
		drawImage(bg, 0, 0);
		drawBottomLeft();
	}
	
	private ImageData getImageData(ImageDescriptor descriptor) {
		ImageData data= descriptor.getImageData(); // see bug 51965: getImageData can return null
		if (data == null) {
			data= DEFAULT_IMAGE_DATA;
			throw new IllegalArgumentException("Image data not available: " + descriptor.toString());
		}
		return data;
	}
	
	private void drawBottomLeft() {
		Point size= getSize();
		int x= 0;
		if ((fFlags & ERROR) != 0) {
			ImageData data= getImageData(WholeImages.DESC_ERROR_OVR);
			drawImage(data, x, size.y - data.height);
			x+= data.width;
		}
		if ((fFlags & WARNING) != 0) {
			ImageData data= getImageData(WholeImages.DESC_WARNING_OVR);
			drawImage(data, x, size.y - data.height);
			x+= data.width;
		}

	}
}
