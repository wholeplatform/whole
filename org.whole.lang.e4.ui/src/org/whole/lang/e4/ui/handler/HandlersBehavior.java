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
package org.whole.lang.e4.ui.handler;

import static org.whole.lang.e4.ui.api.IUIConstants.ACTION_CALL_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.ADD_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.ADD_FRAGMENT_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.COPY_AS_IMAGE_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.COPY_ENTITY_PATH_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_COPY;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_CUT;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_DELETE;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_FIND_AND_REPLACE;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_PASTE;
import static org.whole.lang.e4.ui.api.IUIConstants.EDIT_SELECT_ALL;
import static org.whole.lang.e4.ui.api.IUIConstants.FILE_REVERT;
import static org.whole.lang.e4.ui.api.IUIConstants.GENERATEARTIFACTS_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.GENERATEJAVA_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.IMPORT_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.INTERPRET_MODEL_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.NORMALIZE_MODEL_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.PASTE_AS_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.PERFORM_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.PRETTYPRINT_MODEL_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.REPLACE_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.REPLACE_FRAGMENT_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.REPLACE_WITH_DEFAULT_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.SELECT_NOTATION_COMMAND_ID;
import static org.whole.lang.e4.ui.api.IUIConstants.VALIDATE_MODEL_COMMAND_ID;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.actions.iterators.ActionCallIterator;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.e4.ui.viewers.IEntityPartViewer;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.misc.factories.MiscEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.actions.Clipboard;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DefaultCopyTransformer;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

/**
 * @author Enrico Persiani
 */
 
public class HandlersBehavior {

	public static void registerHandlers(EHandlerService handlerService) {
		handlerService.activateHandler(EDIT_CUT, new CutHandler());
		handlerService.activateHandler(EDIT_COPY, new CopyHandler());
		handlerService.activateHandler(EDIT_PASTE, new PasteHandler());
		handlerService.activateHandler(EDIT_DELETE, new DeleteHandler());
		handlerService.activateHandler(EDIT_SELECT_ALL, new SelectAllHandler());
		handlerService.activateHandler(EDIT_FIND_AND_REPLACE, new FindReplaceHandler());
		handlerService.activateHandler(FILE_REVERT, new RevertHandler());

		handlerService.activateHandler(COPY_ENTITY_PATH_COMMAND_ID, new CopyEntityPathHandler());
		handlerService.activateHandler(COPY_AS_IMAGE_COMMAND_ID, new CopyAsImageHandler());
		handlerService.activateHandler(PASTE_AS_COMMAND_ID, new PasteAsHandler());

		handlerService.activateHandler(REPLACE_COMMAND_ID, new ReplaceEntityHandler());
		handlerService.activateHandler(ADD_COMMAND_ID, new AddEntityHandler());

		handlerService.activateHandler(REPLACE_FRAGMENT_COMMAND_ID, new ReplaceFragmentHandler());
		handlerService.activateHandler(ADD_FRAGMENT_COMMAND_ID, new AddFragmentHandler());

		handlerService.activateHandler(REPLACE_WITH_DEFAULT_COMMAND_ID, new ReplaceWithDefaultHandler());
		handlerService.activateHandler(IMPORT_COMMAND_ID, new ImportHandler());
		handlerService.activateHandler(SELECT_NOTATION_COMMAND_ID, new SelectNotationHandler());
		handlerService.activateHandler(ACTION_CALL_COMMAND_ID, new ActionCallHandler());
		handlerService.activateHandler(PERFORM_COMMAND_ID, new PerformHandler());

		handlerService.activateHandler(VALIDATE_MODEL_COMMAND_ID, new ValidateModelHandler());
		handlerService.activateHandler(NORMALIZE_MODEL_COMMAND_ID, new NormalizeModelHandler());
		handlerService.activateHandler(PRETTYPRINT_MODEL_COMMAND_ID, new PrettyPrintModelHandler());
		handlerService.activateHandler(INTERPRET_MODEL_COMMAND_ID, new InterpretModelHandler());
		handlerService.activateHandler(GENERATEARTIFACTS_COMMAND_ID, new GenerateArtifactslHandler());
		handlerService.activateHandler(GENERATEJAVA_COMMAND_ID, new GenerateJavaHandler());
	}

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
		String selectedText;
		if (bm.wIsSet("selectedText") && !(selectedText = bm.wStringValue("selectedText")).isEmpty())
			Clipboard.instance().setTextContents(selectedText);
		else
			Clipboard.instance().setEntitiesContents(EntityUtils.clone(bm.wGet("selectedEntities")));
	}
	public static boolean canCopyEntityPath(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true);
	}
	public static void copyEntityPath(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		try {
			Class<?> queryUtilsClass = Class.forName("org.whole.lang.queries.util.QueriesUtils",
					true, ReflectionFactory.getClassLoader(bm));
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

		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		return viewer.getEditPartRegistry().get(primarySelectedEntity) instanceof IGraphicalEntityPart;
	}
	public static void copyAsImage(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntityPart part = viewer.getEditPartRegistry().get(primarySelectedEntity);
		Clipboard.instance().setImageContents((IGraphicalEntityPart) part);
	}

	public static boolean canPaste(IBindingManager bm) {

		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity clipboardTuple = Clipboard.instance().getInternalOrNativeEntityContents();
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(clipboardTuple);

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		if (primarySelectedEntity != null && iterator.hasNext()) {
			IEntity clipboardEntity = iterator.next();
			boolean addable = EntityUtils.isAddable(primarySelectedEntity, clipboardEntity);
			if (!addable && !iterator.hasNext())
				return EntityUtils.isReplaceable(primarySelectedEntity, clipboardEntity);
			else {
				while (addable && iterator.hasNext())
					addable = EntityUtils.isAddable(primarySelectedEntity, iterator.next());
				return addable;
			}
		}
		return false;
	}
	public static void paste(IBindingManager bm) {
		if (Clipboard.instance().getInternalOrNativeEntityContents() != null) {
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
	}

	public static boolean canPasteAs(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true) &&
				(Clipboard.instance().getEntityContents() != null ||
				Clipboard.instance().getTextContents() != null);
		
	}
	public static void pasteAs(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
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
			adding |= syntheticRoot.wSize() > 1;
			if (adding && !EntityUtils.isComposite(primarySelectedEntity)) {
				adding = false;
				iterator = IteratorFactory.selfIterator();
			} else
				iterator = IteratorFactory.childReverseIterator();
			iterator.reset(syntheticRoot);
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
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity entityContents = viewer.getEntityContents();
		IGraphicalEntityPart contents = (IGraphicalEntityPart) viewer.getEditPartRegistry().get(entityContents);
		return ((IEntityFigure) contents.getFigure()).isInteractiveEdit();
	}
	public static void selectAll(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity entityContents = viewer.getEntityContents();
		IEntityPart contents = viewer.getEditPartRegistry().get(entityContents);
		viewer.setSelection(new StructuredSelection(contents));
	}

	public static boolean canReplaceWithDefault(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true);
	}
	public static void replaceWithDefault(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity parent = primarySelectedEntity.wGetParent();
		IEntity defaultEntity = GenericEntityFactory.instance.create(primarySelectedEntity.wGetEntityDescriptor());
		parent.wSet(primarySelectedEntity, defaultEntity);
	}

	public static boolean canImportEntity(IBindingManager bm) {
		return isValidEntityPartSelection(bm, true);
	}
	public static void importEntity(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
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
		if (bm.wIsSet("featureDescriptor"))
			primarySelectedEntity = primarySelectedEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		return EntityUtils.isReplaceable(primarySelectedEntity, ed);
	}

	//FIXME make configurable
	private static final IEntityTransformer transformer = new DefaultCopyTransformer() {
		public void transform(IEntity oldEntity, IEntity newEntity) {
			if (CommonsEntityDescriptorEnum.Variable.isLanguageSupertypeOf(newEntity.wGetEntityDescriptor()) &&
					!CommonsEntityDescriptorEnum.Variable.isLanguageSupertypeOf(oldEntity.wGetEntityDescriptor())) {
				newEntity.wGet(CommonsFeatureDescriptorEnum.varName).wSetValue(oldEntity.wGetParent().wGetFeatureDescriptor(oldEntity).getName());
				newEntity.wGet(CommonsFeatureDescriptorEnum.varType).wSetValue(
						EntityUtils.isResolver(oldEntity) ? oldEntity.wGetParent().wGetEntityDescriptor(oldEntity) : //TODO workaround for resolver container descriptor
							oldEntity.wGetEntityDescriptor());
			} else
				super.transform(oldEntity, newEntity); 
		}
	};
	public static void replaceEntity(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("featureDescriptor"))
			primarySelectedEntity = primarySelectedEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		IEntity replacement = GenericEntityFactory.instance.create(ed);
		transformer.transform(primarySelectedEntity.wGetAdaptee(false), replacement);
		primarySelectedEntity.wGetParent().wSet(primarySelectedEntity, replacement);
	}

	public static boolean canAddEntity(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("featureDescriptor"))
			primarySelectedEntity = primarySelectedEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		return EntityUtils.isAddable(primarySelectedEntity, ed);
	}
	public static void addEntity(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("featureDescriptor"))
			primarySelectedEntity = primarySelectedEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		IEntity child = GenericEntityFactory.instance.create(ed);

		//FIXME make configurable
		if (CommonsEntityDescriptorEnum.Variable.isLanguageSupertypeOf(ed))
			child.wGet(CommonsFeatureDescriptorEnum.varType).wSetValue(primarySelectedEntity.wGetEntityDescriptor(0));

		if (bm.wIsSet("hilightPosition"))
			primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), child);
		else
			primarySelectedEntity.wAdd(child);
	}

	public static boolean canReplaceFragment(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity predicateEntity = bm.wGet("predicateEntity");


		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(ts);
		//FIXME workaround for domain content assist that assume self initialized with primarySelectedEntity
		bm.wDefValue("self", primarySelectedEntity);
		boolean predicateResult = BehaviorUtils.evaluatePredicate(predicateEntity, 0, bm);
		ts.rollback();
		bm.wExitScope();

		if (!predicateResult)
			return false;

		return EntityUtils.isReplaceable(primarySelectedEntity, bm.wGet("fragmentEntity"));
	}

	public static void replaceFragment(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		primarySelectedEntity.wGetParent().wSet(primarySelectedEntity, fragmentEntity);
	}

	public static boolean canAddFragment(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity predicateEntity = bm.wGet("predicateEntity");


		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(ts);
		//FIXME workaround for domain content assist that assume self initialized with primarySelectedEntity
		bm.wDefValue("self", primarySelectedEntity);
		boolean predicateResult = BehaviorUtils.evaluatePredicate(predicateEntity, 0, bm);
		ts.rollback();
		bm.wExitScope();

		if (!predicateResult)
			return false;

		return EntityUtils.isAddable(primarySelectedEntity, bm.wGet("fragmentEntity"));
	}

	public static void addFragment(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		if (bm.wIsSet("hilightPosition"))
			primarySelectedEntity.wAdd(bm.wIntValue("hilightPosition"), fragmentEntity);
		else
			primarySelectedEntity.wAdd(fragmentEntity);
	}

	public static boolean canWrapFragment(IBindingManager bm) {
		if (!isValidEntityPartSelection(bm, true))
			return false;

		if (!BehaviorUtils.evaluatePredicate(bm.wGet("predicateEntity"), 0, bm))
			return false;

		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		return EntityUtils.isReplaceable(primarySelectedEntity, fragmentEntity);
	}

	public static void wrapFragment(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("primarySelectedEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		DefaultWrapInTransformer.instance.transform(primarySelectedEntity, fragmentEntity);
		primarySelectedEntity.wGetParent().wSet(primarySelectedEntity, fragmentEntity);
	}

	public static boolean canCallAction(IBindingManager bm) {
		return BehaviorUtils.evaluatePredicate(bm.wGet("predicateEntity"), 0, bm);
	}
	public static void actionCall(IBindingManager bm) {
		IEntity model = bm.wGet("self");
		boolean analyzing = bm.wBooleanValue("analyzing");
		if (analyzing) {
			// clone model if is analyzing
			model = EntityUtils.clone(model);
			CommonsEntityFactory.instance.createRootFragment(
					model.wGetAdapter(CommonsEntityDescriptorEnum.Any));
			ReflectionFactory.getHistoryManager(model).setHistoryEnabled(true);

			// map selected entities if analyzing
			IEntity tuple = bm.wGet("selectedEntities");
			int size = tuple.wSize();
			for (int i = 0; i < size; i++)
				tuple.wSet(i, EntityUtils.mapEntity(tuple.wGet(i), model));
			bm.wSet("primarySelectedEntity", EntityUtils.mapEntity(bm.wGet("primarySelectedEntity"), model));
		}

		IEntityIterator<?> iterator = new ActionCallIterator(bm.wStringValue("functionUri"));

		if (analyzing) {
			iterator.setBindings(bm);
			iterator.reset(model);

			IEntity results = MiscEntityFactory.instance.createMisc();
			for (IEntity result : iterator) {
				results.wAdd(GenericEntityFactory.instance.create(
						CommonsEntityDescriptorEnum.StageUpFragment,
						//CommonsEntityFactory.instance.createStageUpFragment(
						EntityUtils.cloneIfParented(result)));//TODO substitute with a no containment fragment
	
				((IOperationProgressMonitor) bm.wGetValue("progressMonitor")).worked(1);
			}
			bm.setResult(results);
		} else
			BehaviorUtils.evaluate(iterator, model, bm);
	}

	public static boolean canPerform(IBindingManager bm) {
		return BehaviorUtils.evaluatePredicate(bm.wGet("predicateEntity"), 0, bm);
	}

	public static void perform(IBindingManager bm) {
		BehaviorUtils.evaluate(bm.wGet("behaviorEntity"), 0, bm);
	}

	public static boolean canValidateModel(IBindingManager bm) {
		return bm.wIsSet("file") && bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(ValidatorOperation.ID);
	}

	public static void validateModel(IBindingManager bm) {
		ValidatorOperation.validate(bm.wGet("self"), bm);
	}

	public static boolean canNormalizeModel(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(NormalizerOperation.ID);
	}

	public static void normalizeModel(IBindingManager bm) {
		NormalizerOperation.normalize(bm.wGet("self"), bm);
	}

	public static boolean canPrettyPrintModel(IBindingManager bm) {
		return bm.wIsSet("self");
	}

	public static void prettyPrintModel(IBindingManager bm) {
		E4Utils.invokePrettyPrinter(bm);
	}
	public static boolean canInterpretModel(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(InterpreterOperation.ID);
	}

	public static void interpretModel(IBindingManager bm) {
		E4Utils.invokeInterpreter(bm);
	}

	public static boolean canGenerateArtifacts(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(ArtifactsGeneratorOperation.ID);
	}

	public static void generateArtifacts(IBindingManager bm) {
		ArtifactsGeneratorOperation.generate(bm.wGet("self"), bm);
	}
	public static boolean canGenerateJava(IBindingManager bm) {
		return bm.wIsSet("self") &&
				//FIXME use JavaCompilerOperation.ID
				bm.wGet("self").wGetLanguageKit().hasVisitor("toJavaModel");
	}

	public static void generateJava(IBindingManager bm) {
		ClassLoader cl = ReflectionFactory.getClassLoader(bm);
		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		try {
			bm.wEnterScope(ts);
			Class<?> generatorClass = Class.forName("org.whole.lang.ui.actions.JavaModelGeneratorAction", true, cl);
			Method generateMethod = generatorClass.getMethod("generate", IProgressMonitor.class, IEntity.class, IBindingManager.class);
			final IOperationProgressMonitor operationProgressMonitor = (IOperationProgressMonitor) bm.wGetValue("progressMonitor");
			generateMethod.invoke(null, operationProgressMonitor.getAdapter(IProgressMonitor.class), bm.wGet("self"), bm);
		} catch (OperationCanceledException e) {
			throw e;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			ts.rollback();
			bm.wExitScope();
		}
	}
}
