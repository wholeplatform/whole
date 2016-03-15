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
package org.whole.lang.ui.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.dnd.SimpleObjectTransfer;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editpolicies.FailWithFeedbackStrategy;
import org.whole.lang.ui.editpolicies.WholeNonResizableEditPolicy;
import org.whole.lang.ui.util.ClipboardUtils;

/**
 * @author Enrico Persiani
 */
public class Clipboard {
	private static final class EntityTransfer extends SimpleObjectTransfer {
		private static final EntityTransfer instance = new EntityTransfer();
		public static EntityTransfer instance() {
			return instance;
		}

		private final String TRANSFER_TYPE_NAME = "org.whole.lang.ui.transfer";

		private int registeredTypeUID;
		private int[] registeredTypes;

		protected int[] getTypeIds() {
			if (registeredTypes == null) {
				registeredTypeUID = registerType(TRANSFER_TYPE_NAME);
				registeredTypes = new int[] { registeredTypeUID };
			}
			return registeredTypes;
		}

		protected String[] getTypeNames() {
			return new String[] { TRANSFER_TYPE_NAME };
		}
	}

	private Clipboard() {
	}

	private static class SingletonHolder {
		private static final Clipboard instance = new Clipboard();
	}
	public static Clipboard instance() {
		return SingletonHolder.instance;
	}

	public IEntity getInternalOrNativeEntityContents() {
		IEntity entity = getEntityContents();
		return entity != null ? entity : getEntityFromTextContents();
	}
	public IEntity getEntityContents() {
		return getContents(EntityTransfer.instance());
	}

	public IEntity getEntityFromTextContents() {
		String text = getTextContents();
		if (text == null)
			return null;
		try {
			return ClipboardUtils.parseEntity(text);
		} catch (Exception e) {
			return null;
		}
	}
	public String getTextContents() {
		return getContents(TextTransfer.getInstance());
	}

	@SuppressWarnings("unchecked")
	protected <T> T  getContents(Transfer transfer) {
		Object contents = null;
		org.eclipse.swt.dnd.Clipboard clipboard = new org.eclipse.swt.dnd.Clipboard(null);
		try {
			contents = clipboard.getContents(transfer);
		} catch (Exception e) {
		}
		clipboard.dispose();
		return (T) contents;
	}

	protected File[] xmlBuilderFiles;
	public void setEntityContents(IEntity tuple) {
		String contents = null;

		try {
			contents = ClipboardUtils.unparseEntity(tuple);

			// delete any previously created temporary file
			if (xmlBuilderFiles != null) {
				for (File file : xmlBuilderFiles)
					file.delete();
				xmlBuilderFiles = null;
			}

			// create temporary files
			List<File> files = new ArrayList<File>();
			IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
			iterator.set(tuple);
			for (IEntity entity : iterator) {
				File file = ClipboardUtils.createTempXmlBuilderFile(entity);
				file.deleteOnExit();
			}
			xmlBuilderFiles = files.toArray(new File[files.size()]);			

		} catch (Exception e) {
		}

		if (contents != null) {
			if (xmlBuilderFiles != null) {
				String[] paths = new String[xmlBuilderFiles.length];
				for (int i=0; i<xmlBuilderFiles.length; i++)
					paths[i] = xmlBuilderFiles[i].getAbsolutePath();

				setContents(tuple, contents, paths);
			} else
				setContents(tuple, contents);
		} else
			setContents(tuple);
	}

	protected File imageFile;
	public void setImageContents(IGraphicalEntityPart entityPart) {
		Image image = WholeNonResizableEditPolicy.createFeedbackImage(entityPart, 255, false, FailWithFeedbackStrategy.instance());
		if (image == null)
			return;
		ImageData imageData = image.getImageData();
		try {
			// delete any previously created temporary file
			if (imageFile != null) {
				imageFile.delete();
				imageFile = null;
			}
			imageFile = ClipboardUtils.createTempImageFile(imageData);

			// ensure file deletion on exit
			imageFile.deleteOnExit();
		} catch (Exception e) {
		}

		try {
			if (imageFile != null)
				setContents(imageData, imageFile);
			else
				setContents(image.getImageData());
		} finally {
			image.dispose();
		}
	}
	public void setTextContents(String text) {
		setContents(new Object[] {text}, new Transfer[] {TextTransfer.getInstance()});
	}

	protected void setContents(IEntity entity, String text) {
		setContents(new Object[] {entity, text}, new Transfer[] {EntityTransfer.instance(), TextTransfer.getInstance()});
	}
	protected void setContents(IEntity entity, String text, String[] paths) {
		setContents(new Object[] {entity, text, paths}, new Transfer[] {EntityTransfer.instance(), TextTransfer.getInstance(), FileTransfer.getInstance()});
	}
	protected void setContents(ImageData imageData, File imageFile) {
		setContents(new Object[] {imageData, new String[] {imageFile.getAbsolutePath()}}, new Transfer[] {ImageTransfer.getInstance(), FileTransfer.getInstance()});
	}
	protected void setContents(ImageData imageData) {
		setContents(new Object[] {imageData}, new Transfer[] {ImageTransfer.getInstance()});
	}
	protected void setContents(IEntity entity) {
		setContents(new Object[] {entity}, new Transfer[] {EntityTransfer.instance()});
	}
	protected void setContents(Object[] contents, Transfer[] transfers) {
		org.eclipse.swt.dnd.Clipboard clipboard = new org.eclipse.swt.dnd.Clipboard(null);
		try {
			clipboard.setContents(contents, transfers);
		} catch (Exception e) {
		}
		clipboard.dispose();
	}
}
