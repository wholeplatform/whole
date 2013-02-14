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
package org.whole.lang.e4.ui.handler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.Clipboard;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.util.DefaultCopyTransformer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class HandlersBehavior {
	public static boolean isValidEntityPartSelection(IBindingManager bm, boolean single) {
		IEntity selectionTuple = bm.wGet("selectedEntities");
		if (selectionTuple.wSize() == 0 || (single && selectionTuple.wSize() > 1))
			return false;
		
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(selectionTuple);
		while (iterator.hasNext()) {
			IEntity entity = iterator.next();
			if (Matcher.match(CommonsEntityDescriptorEnum.RootFragment, entity))
				return false;
		}
		return true;
	}

	public static boolean canCut(IBindingManager bm) {
		return isValidEntityPartSelection(bm, false);
	}
	public static void cut(IBindingManager bm) {
		copy(bm);
		delete(bm);
	}

	public static boolean canCopy(IBindingManager bm) {
		return isValidEntityPartSelection(bm, false);
	}
	public static void copy(IBindingManager bm) {
		Clipboard.instance().setEntitiesContents(bm.wGet("selectedEntities"));
	}
	public static boolean canCopyEntityPath(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true);
	}
	public static void copyEntityPath(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		try {
			Class<?> queryUtilsClass = Class.forName("org.whole.lang.queries.util.QueriesUtils",
					true, ReflectionFactory.getPlatformClassLoader());
			Method createRootPathMethod = queryUtilsClass.getMethod("createRootPath", new Class[] {IEntity.class});
			IEntity entityPath = (IEntity) createRootPathMethod.invoke(null, primarySelectedEntity);
			Clipboard.instance().setEntityContents(entityPath);
		} catch (Exception e) {
			String location = EntityUtils.getLocation(primarySelectedEntity);
			Clipboard.instance().setTextContents(location);
		}
	}
	public static boolean canCopyAsImage(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		return viewer.getEditPartRegistry().get(primarySelectedEntity) instanceof IGraphicalEntityPart;
	}
	public static void copyAsImage(IBindingManager bm) {
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntityPart part = viewer.getEditPartRegistry().get(primarySelectedEntity);
		Clipboard.instance().setImageContents((IGraphicalEntityPart) part);
	}

	public static boolean canPaste(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;
		
		IEntity clipboardTuple = Clipboard.instance().getInternalOrNativeEntityContents();
		if (clipboardTuple == null)
			return false;
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(clipboardTuple);

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		if (primarySelectedEntity == null)
			return false;
		if (iterator.hasNext()) {
			IEntity clipboardEntity = iterator.next();
			boolean addable = EntityUtils.isAddable(primarySelectedEntity, clipboardEntity);
			if (!addable && !iterator.hasNext())
				return EntityUtils.isReplaceable(primarySelectedEntity, clipboardEntity);
			else {
				while (addable && iterator.hasNext())
					addable = EntityUtils.isAddable(primarySelectedEntity, iterator.next());
				return addable;
			}
		} else
			return false;
	}
	public static void paste(IBindingManager bm) {
		IEntityIterator<IEntity> iterator = IteratorFactory.childReverseIterator();
		iterator.reset(Clipboard.instance().getInternalOrNativeEntityContents());

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		while (iterator.hasNext()) {
			IEntity clipboardEntity = EntityUtils.clone(iterator.next());
			boolean addable = EntityUtils.isAddable(primarySelectedEntity, clipboardEntity);
			if (!addable && !iterator.hasNext()) {
				IEntity parent = primarySelectedEntity.wGetParent();
				parent.wSet(primarySelectedEntity, clipboardEntity);
				break;
			} else
				if (bm.wIsSet("hilightPosition"))
					primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), clipboardEntity);
				else
					primarySelectedEntity.wAdd(clipboardEntity);
		}
	}
	public static boolean canPasteAs(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true) &&
				(Clipboard.instance().getEntityContents() != null ||
				Clipboard.instance().getTextContents() != null);
		
	}
	public static void pasteAs(IBindingManager bm) {
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		Shell shell = viewer.getControl().getShell();
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IImportAsModelDialog dialog = ImportAsModelDialogFactory.instance().createImplicitElementImportAsModelDialog(
				shell, "Paste As", EntityUtils.isComposite(primarySelectedEntity));
		if (!dialog.show())
			return;
		
		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		IEntity entity = ClipboardUtils.parseClipboardContents(persistenceKit, bm);
		if (entity == null) {
			MessageDialog.openError(shell, "Paste As Error", "Parse failed using the selected persistence.");
			return;
		}
		
		boolean adding = dialog.isForceAdding();
		IEntityIterator<IEntity> iterator;
		if (bm.wIsSet("syntheticRoot")) {
			IEntity syntheticRoot = bm.wGet("syntheticRoot");
			iterator = IteratorFactory.childReverseIterator();
			iterator.reset(syntheticRoot);
			adding |= syntheticRoot.wSize() > 1;
		} else {
			iterator = IteratorFactory.selfIterator();
			iterator.reset(entity);
		}
		
		EntityDescriptor<?> stage = dialog.getStage();
		while (iterator.hasNext()) {
			IEntity clipboardEntity = EntityUtils.clone(iterator.next());
			if (!adding) {
				if (!CommonsEntityDescriptorEnum.SameStageFragment.equals(stage) ||
						!EntityUtils.isReplaceable(primarySelectedEntity, clipboardEntity))
					clipboardEntity = CommonsEntityFactory.instance.create(stage, clipboardEntity);
				IEntity parent = primarySelectedEntity.wGetParent();
				parent.wSet(primarySelectedEntity, clipboardEntity);
				break;
			} else {
				if (!CommonsEntityDescriptorEnum.SameStageFragment.equals(stage) ||
						!EntityUtils.isAddable(primarySelectedEntity, clipboardEntity))
					clipboardEntity = CommonsEntityFactory.instance.create(stage, clipboardEntity);
				if (bm.wIsSet("hilightPosition"))
					primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), clipboardEntity);
				else
					primarySelectedEntity.wAdd(clipboardEntity);
			}
		}
	}

	public static boolean canDelete(IBindingManager bm) {
		return isValidEntityPartSelection(bm, false);
	}
	public static void delete(IBindingManager bm) {
		IEntity selectedEntities = bm.wGet("selectedEntities");
		List<IEntity> rootEntities = new ArrayList<IEntity>();

		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(selectedEntities);
		while (iterator.hasNext()) {
			IEntity entity = iterator.next();

			boolean rootCandidate = true;
			IEntity parent = entity.wGetParent();
			while (rootCandidate && !EntityUtils.isNull(parent)) {
				if (selectedEntities.wContains(parent))
					rootCandidate = false;
				else
					parent = parent.wGetParent();
			}

			if (rootCandidate)
				rootEntities.add(entity);
		}

//FIXME workaround for ConcurrentModificationException when inserted
//		into a no containment Tuple (gathered through selection) 
//		EntityUtils.removeAll(roots);
		for (IEntity entity : rootEntities)
			entity.wGetParent().wRemove(entity);
	}

	public static boolean canSelectAll(IBindingManager bm) {
		return true;
	}
	public static void selectAll(IBindingManager bm) {
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		List<EditPart> allSelectableParts = new LinkedList<EditPart>();
		collectAllSelectableParts(viewer.getContents(), allSelectableParts);
		viewer.setSelection(new StructuredSelection(allSelectableParts));
	}
	@SuppressWarnings("unchecked")
	private static void collectAllSelectableParts(EditPart rootPart, List<EditPart> allSelectableParts) {
		for (EditPart child : (List<EditPart>) rootPart.getChildren()) {
			if (child.isSelectable())
				allSelectableParts.add(child);
			collectAllSelectableParts(child, allSelectableParts);
		}
	}

	public static boolean canImportEntity(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true);
	}
	public static void importEntity(IBindingManager bm) {
		E4GraphicalViewer viewer = (E4GraphicalViewer) bm.wGetValue("viewer");
		Shell shell = viewer.getControl().getShell();

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IImportAsModelDialog dialog = ImportAsModelDialogFactory.instance().createImportAsModelDialog(
				shell, "Import model", EntityUtils.isComposite(primarySelectedEntity));
		if (!dialog.show())
			return;

		Object[] files = dialog.getSelection();
		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		EntityDescriptor<?> stage = dialog.getStage();
		boolean adding = dialog.isForceAdding() || files.length > 1;
		for (int i=files.length-1; i>=0; i--) {
			IPersistenceProvider pp =  new IFilePersistenceProvider((IFile) files[i]);
			try {
				IEntity importedEntity = persistenceKit.readModel(pp);
				if (!adding) {
					if (!CommonsEntityDescriptorEnum.SameStageFragment.equals(stage) ||
							!EntityUtils.isReplaceable(primarySelectedEntity, importedEntity))
						importedEntity = CommonsEntityFactory.instance.create(stage, importedEntity);
					IEntity parent = primarySelectedEntity.wGetParent();
					parent.wSet(primarySelectedEntity, importedEntity);
					break;
				} else {
					if (!CommonsEntityDescriptorEnum.SameStageFragment.equals(stage) ||
							!EntityUtils.isAddable(primarySelectedEntity, importedEntity))
						importedEntity = CommonsEntityFactory.instance.create(stage, importedEntity);
					if (bm.wIsSet("hilightPosition"))
						primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), importedEntity);
					else
						primarySelectedEntity.wAdd(importedEntity);
				}
			} catch (Exception e) {
				// fail silently
			}
		}
	}

	public static boolean canReplaceEntity(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		return EntityUtils.isReplaceable(primarySelectedEntity, ed);
	}
	public static void replaceEntity(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		IEntity replacement = GenericEntityFactory.instance.create(ed);
		DefaultCopyTransformer.instance.transform(primarySelectedEntity, replacement);
		primarySelectedEntity.wGetParent().wSet(primarySelectedEntity, replacement);
	}

	public static boolean canAddEntity(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		return EntityUtils.isAddable(primarySelectedEntity, ed);
	}
	public static void addEntity(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("hilightPosition"))
			primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), GenericEntityFactory.instance.create(ed));
		else
			primarySelectedEntity.wAdd(GenericEntityFactory.instance.create(ed));
	}

	public static boolean canReplaceFragment(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		return EntityUtils.isReplaceable(primarySelectedEntity, fragmentEntity);
	}

	public static void replaceFragment(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
//TODO enable entity transformer?
//		DefaultCopyTransformer.instance.transform(primarySelectedEntity, fragmentEntity);
		primarySelectedEntity.wGetParent().wSet(primarySelectedEntity, fragmentEntity);
	}

	public static boolean canAddFragment(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		return EntityUtils.isAddable(primarySelectedEntity, fragmentEntity);
	}

	public static void addFragment(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		if (bm.wIsSet("hilightPosition"))
			primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), fragmentEntity);
		else
			primarySelectedEntity.wAdd(fragmentEntity);
	}
}
