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

import static org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum.SameStageFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.CRC32;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.StringPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.Clipboard;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ClipboardUtils {
	public static final int DEFAULT_OUTPUT_DPI = 300;

	public static String unparseEntity(IEntity entity) throws Exception {
		StringPersistenceProvider pp = new StringPersistenceProvider();
		ReflectionFactory.getDefaultPersistenceKit().writeModel(entity, pp);
		return pp.getStore();
	}

	public static IEntity parseEntity(String text) throws Exception {
		return ReflectionFactory.getDefaultPersistenceKit().readModel(new StringPersistenceProvider(text));
	}
	public static IEntity parseClipboardContents(IPersistenceKit persistenceKit, IBindingManager bm) throws Exception {
		IEntity entity = Clipboard.instance().getEntityContents();
		if (entity != null && ReflectionFactory.getDefaultPersistenceKit().equals(persistenceKit)) {
			if (EntityUtils.isTuple(entity))
				bm.wDef("syntheticRoot", entity);
			return entity;
		} else {
			String text;
			if (entity != null) {
				StringBuilder sb = new StringBuilder(1024);
				for (int i=0; i<entity.wSize(); i++)
					sb.append(PrettyPrinterOperation.toPrettyPrintString(entity.wGet(i)));
				text = sb.toString();
			} else
				text = Clipboard.instance().getTextContents();

			if (text == null)
				throw new IllegalStateException("no clipboard contents");

			bm.wDefValue("parseFragments", true);
			return persistenceKit.readModel(new StringPersistenceProvider(text, bm));
		}
	}

	public static File createTempImageFile(ImageData imageData, int dpi) throws IOException, FileNotFoundException {
		File file = File.createTempFile("whole-snapshot", ".png");
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] {imageData};
		OutputStream os = new FileOutputStream(file);
		loader.save(os, SWT.IMAGE_PNG);
		os.close();
		updatePngDpi(file, dpi);
		return file;
	}

	private static final String PNG_MAGIC = "\u0089PNG\r\n\u001a\n";
	private static final String IHDR_CHUNK = "IHDR";
	private static final String pHYs_CHUNK = "pHYs";

	private static final int CHUNK_BASE_LENGTH = 12; // 4bytes (length) + 4bytes (signature) + 4bytes (crc)
	private static final int pHYs_DATA_LENGTH = 9; // 4bytes (pointsperunit) + 4bytes (pointsperunit) + 1bytes (unit)
	private static final int pHYs_METERS_UNIT = 1;

	private static final float INCH_2_M = 0.0254f;

	private static void updatePngDpi(File file, int dpi) {

		int dpm = Math.round(Float.valueOf(dpi) / INCH_2_M);

		try (RandomAccessFile pngFile = new RandomAccessFile(file, "rws")) {
			IllegalArgumentException exception = new IllegalArgumentException("malformed png file");

			byte[] magic = new byte[8];
			pngFile.readFully(magic);
			if (!Arrays.equals(magic, PNG_MAGIC.getBytes("latin1")))
				throw exception;

			int ihdrLength = pngFile.readInt();

			byte[] ihdr = new byte[4];
			pngFile.readFully(ihdr);
			if (!Arrays.equals(ihdr, IHDR_CHUNK.getBytes("ascii")))
				throw exception;

			byte[] ihdrData = new byte[ihdrLength];
			pngFile.readFully(ihdrData);
			CRC32 crc32 = new CRC32();
			crc32.update(ihdr);
			crc32.update(ihdrData);

			ByteBuffer byteBuffer = ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN);
			byte[] ihdrCrc32 = new byte[4];
			pngFile.readFully(ihdrCrc32);
			if (!Arrays.equals(ihdrCrc32, byteBuffer.putInt((int) crc32.getValue()).array()))
				throw exception;

			long offset = pngFile.getFilePointer();
			long length = pngFile.length();
			byte[] buffer = new byte[1024];

			long fromOffset = length - buffer.length;
			long toOffset = fromOffset + CHUNK_BASE_LENGTH + pHYs_DATA_LENGTH;
			while(fromOffset >= offset) {
				pngFile.seek(fromOffset);
				pngFile.readFully(buffer);
				pngFile.seek(toOffset);
				pngFile.write(buffer);
				fromOffset -= buffer.length;
				toOffset -= buffer.length;
			}
			fromOffset += buffer.length;
			toOffset += buffer.length;
			if (fromOffset > offset) {
				pngFile.seek(offset);
				pngFile.readFully(buffer, 0, (int) (fromOffset - offset));
				pngFile.seek(offset + CHUNK_BASE_LENGTH + pHYs_DATA_LENGTH);
				pngFile.write(buffer, 0, (int) (fromOffset - offset));
			}

			// append pHYs after actual IHDR
			pngFile.seek(offset);

			pngFile.writeInt(pHYs_DATA_LENGTH);
			pngFile.write(buffer = pHYs_CHUNK.getBytes("ascii"));
			pngFile.writeInt(dpm);
			pngFile.writeInt(dpm);
			pngFile.write(pHYs_METERS_UNIT);

			byteBuffer.clear();
			crc32.reset();
			crc32.update(buffer); // pHYs
			crc32.update(buffer = byteBuffer.putInt(dpm).array());
			crc32.update(buffer);
			crc32.update(pHYs_METERS_UNIT);
			pngFile.writeInt((int) crc32.getValue());
		} catch (Exception e) {
			throw new IllegalArgumentException("cannot update png file");
		}
	}

	public static File createTempXmlBuilderFile(IEntity entity) throws Exception {
		return createTempXmlBuilderFile(unparseEntity(entity));
	}
	public static File createTempXmlBuilderFile(String contents) throws Exception {
		File file = File.createTempFile("whole-snippet", ".xwl");
		OutputStream os = new FileOutputStream(file);
		os.write(contents.getBytes("UTF-8"));
		os.close();
		return file;
	}

	public static boolean hasTextFocus(EditPartViewer viewer) {
		return hasTextFocus(viewer, viewer.getSelection());
	}
	public static boolean hasTextFocus(EditPartViewer viewer, ISelectionProvider selectionProvider) {
		return hasTextFocus(viewer, selectionProvider.getSelection());
	}
	public static boolean hasTextFocus(EditPartViewer viewer, ISelection selection) {
		List<EditPart> selectedParts = getSelectedEditParts(selection);
		if (selectedParts.size() > 1)
			return false;

		return Tools.TEXTUAL.isActive(viewer) &&
		viewer.getFocusEditPart() instanceof ITextualEntityPart ;
	}

	public static boolean hasTextSeletion(EditPartViewer viewer) {
		return hasTextSeletion(viewer, viewer.getSelection());
	}
	public static boolean hasTextSeletion(EditPartViewer viewer, ISelectionProvider selectionProvider) {
		return hasTextSeletion(viewer, selectionProvider.getSelection());
	}
	public static boolean hasTextSeletion(EditPartViewer viewer, ISelection selection) {
		List<EditPart> selectedParts = getSelectedEditParts(selection);
		if (selectedParts.size() != 1)
			return false;

		EditPart selectedPart = selectedParts.get(0);
		return Tools.TEXTUAL.isActive(viewer) &&
				selectedPart instanceof ITextualEntityPart &&
				((ITextualEntityPart) selectedPart).hasSelectionRange();
	}

	public static String getTextSelection(EditPartViewer viewer) {
		return getTextSelection(viewer, viewer.getSelection());
	}
	public static String getTextSelection(EditPartViewer viewer, ISelectionProvider selectionProvider) {
		return getTextSelection(viewer, selectionProvider.getSelection());
	}
	public static String getTextSelection(EditPartViewer viewer, ISelection selection) {
		ITextualEntityPart textualEntityPart = (ITextualEntityPart) getSelectedEditParts(selection).get(0);
		return DataTypeUtils.getAsPresentationString(textualEntityPart.getModelEntity()).substring(textualEntityPart.getSelectionStart(), textualEntityPart.getSelectionEnd());
	}

	public static List<EditPart> getSelectedEditParts(ISelectionProvider selectionProvider) {
		return getSelectedEditParts(selectionProvider.getSelection());
	}

	@SuppressWarnings("unchecked")
	public static List<EditPart> getSelectedEditParts(ISelection selection) {
		if (!(selection instanceof IStructuredSelection))
			return Collections.emptyList();
		List<EditPart> selectedParts = new ArrayList<EditPart>(((IStructuredSelection) selection).toList());
		// if there's a RootEditPart it must be the only element
		if (!selectedParts.isEmpty() && selectedParts.get(0).getParent() instanceof RootEditPart)
			selectedParts.remove(0);
		return selectedParts;
	}

	public static IEntityPart createEditPart(EditPartFactory factory, IEntity entity) {
		IGEFEditorKit commonsEditorKit = (IGEFEditorKit) ReflectionFactory.getEditorKit("org.whole.lang.commons.ui.CommonsEditorKit");
		RootFragment rootFragment = CommonsEntityFactory.instance.createRootFragment(
				entity.wGetAdapter(CommonsEntityDescriptorEnum.Any));
		EditPart rootFragmentPart = commonsEditorKit.getPartFactory().createEditPart(null, rootFragment);
		IEntityPart entityPart = (IEntityPart) factory.createEditPart(rootFragmentPart, entity);
		EntityUtils.remove(entity);
		return entityPart;
	}

	public static IEntity conditionalStageAdd(EditPart targetEditPart, EntityDescriptor<?> stage, IEntity entity, boolean needsCompositeTarget) {
		if (!(targetEditPart instanceof IEntityPart))
			return entity;
	
		IEntity targetEntity = ((IEntityPart) targetEditPart).getModelEntity();
		return conditionalStageAdd(targetEntity, stage, entity, needsCompositeTarget);
	}

	public static IEntity conditionalStageAdd(IEntity targetEntity, EntityDescriptor<?> stage, IEntity entity, boolean needsCompositeTarget) {
		assert !EntityUtils.hasParent(entity);

		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		if (SameStageFragment.equals(stage) &&
				((EntityUtils.isComposite(targetEntity) && EntityUtils.isAddable(targetEntity, ed)) ||
				(!needsCompositeTarget && EntityUtils.isReplaceable(targetEntity, ed))))
			return entity;

		return CommonsEntityFactory.instance.create(stage, entity);
	}
}

