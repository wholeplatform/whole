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
package org.whole.lang.e4.ui.handler;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.actions.iterators.ActionCallIterator;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.reflect.CommonsFeatureDescriptorEnum;
import org.whole.lang.e4.ui.actions.IE4UIConstants;
import org.whole.lang.e4.ui.jobs.RunnableWithResult;
import org.whole.lang.e4.ui.util.E4Utils;
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
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;
import org.whole.lang.ui.actions.Clipboard;
import org.whole.lang.ui.dialogs.IImportAsModelDialog;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.util.ClipboardUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;
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
		handlerService.activateHandler(PASTE_AS_COMMAND_ID, new PasteAsHandler());//FIXME

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
	public static boolean isValidFocusEntityPart(IBindingManager bm) {
		return bm.wIsSet("focusEntity") &&
				!Matcher.match(CommonsEntityDescriptorEnum.RootFragment, bm.wGet("focusEntity"));
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
		E4Utils.syncExec(bm, () -> {
			String selectedText;
			if (bm.wIsSet("selectedText") && !(selectedText = bm.wStringValue("selectedText")).isEmpty())
				Clipboard.instance().setTextContents(selectedText);
			else {
				IEntity selectedEntities = bm.wGet("selectedEntities");
				IEntity tuple = BindingManagerFactory.instance.createTuple(true);
				for (int i=0, size=selectedEntities.wSize(); i<size; i++)
					tuple.wAdd(EntityUtils.clone(selectedEntities.wGet(i)));
				Clipboard.instance().setEntityContents(tuple);
			}
		});
	}
	public static boolean canCopyEntityPath(IBindingManager bm) {
		return isValidFocusEntityPart(bm);
	}
	public static void copyEntityPath(IBindingManager bm) {
		E4Utils.syncExec(bm, () -> {
			IEntity focusEntity = bm.wGet("focusEntity");
			try {
				Class<?> queryUtilsClass = Class.forName("org.whole.lang.queries.util.QueriesUtils",
						true, ReflectionFactory.getClassLoader(bm));
				Method createRootPathMethod = queryUtilsClass.getMethod("createRootPath", new Class[] {IEntity.class});
				IEntity entityPath = (IEntity) createRootPathMethod.invoke(null, focusEntity);
				Clipboard.instance().setEntityContents(BindingManagerFactory.instance.createTuple(true, entityPath));
			} catch (Exception e) {
				String location = EntityUtils.getLocation(focusEntity);
				Clipboard.instance().setTextContents(location);
			}
		});
	}
	public static boolean canCopyAsImage(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity focusEntity = bm.wGet("focusEntity");
		return viewer.getEditPartRegistry().get(focusEntity) instanceof IGraphicalEntityPart;
	}
	public static void copyAsImage(IBindingManager bm) {
		E4Utils.syncExec(bm, () -> {
			IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
			IEntity focusEntity = bm.wGet("focusEntity");
			IEntityPart part = viewer.getEditPartRegistry().get(focusEntity);
			Clipboard.instance().setImageContents((IGraphicalEntityPart) part);
		});
	}

	public static boolean canPaste(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		IEntity clipboardTuple = Clipboard.instance().getInternalOrNativeEntityContents();
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(clipboardTuple);

		IEntity focusEntity = bm.wGet("focusEntity");
		if (focusEntity != null && iterator.hasNext()) {
			IEntity clipboardEntity = iterator.next();
			boolean addable = EntityUtils.isAddable(focusEntity, clipboardEntity);
			if (!addable && !iterator.hasNext())
				return EntityUtils.isReplaceable(focusEntity, clipboardEntity);
			else {
				while (addable && iterator.hasNext())
					addable = EntityUtils.isAddable(focusEntity, iterator.next());
				return addable;
			}
		}
		return false;
	}
	public static void paste(IBindingManager bm) {
		RunnableWithResult<IEntity> runnable = E4Utils.syncExec(bm, RunnableWithResult.create(() -> {
			return Clipboard.instance().getInternalOrNativeEntityContents();
		}));

		if (runnable.get() != null) {
			IEntityIterator<IEntity> iterator = IteratorFactory.childReverseIterator();
			iterator.reset(runnable.get());
	
			IEntity focusEntity = bm.wGet("focusEntity");
			while (iterator.hasNext()) {
				IEntity clipboardEntity = EntityUtils.clone(iterator.next());
				boolean addable = EntityUtils.isAddable(focusEntity, clipboardEntity);
				if (!addable && !iterator.hasNext()) {
					IEntity parent = focusEntity.wGetParent();
					parent.wSet(focusEntity, clipboardEntity);
					break;
				} else
					if (bm.wIsSet("hilightPosition"))
						focusEntity.wAdd(bm.wIntValue("hilightPosition"), clipboardEntity);
					else
						focusEntity.wAdd(clipboardEntity);
			}
		}
	}

	public static boolean canPasteAs(IBindingManager bm) {
		return isValidFocusEntityPart(bm) &&
				(Clipboard.instance().getEntityContents() != null ||
				Clipboard.instance().getTextContents() != null);
		
	}
	public static void pasteAs(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity focusEntity = bm.wGet("focusEntity");

		RunnableWithResult<IImportAsModelDialog> dialogRunnable = RunnableWithResult.create(() -> {
			Shell shell = viewer.getControl().getShell();
			IEclipseContext eclipseContext = (IEclipseContext) bm.wGetValue("eclipseContext");
			IImportAsModelDialog dialog = eclipseContext.get(IImportAsModelDialogFactory.class)
					.createImplicitElementImportAsModelDialog(
							shell, "Paste As", EntityUtils.isComposite(focusEntity));
			dialog.show();
			return dialog;
		});

		IImportAsModelDialog dialog = E4Utils.syncExec(bm, dialogRunnable).get();
		if (!dialog.isConfirmed())
			return;

		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		RunnableWithResult<IEntity> entityRunnable = RunnableWithResult.create(() -> {
			try {
				return ClipboardUtils.parseClipboardContents(persistenceKit, bm);
			} catch (Exception e) {
				IEclipseContext context = (IEclipseContext) bm.wGetValue("eclipseContext");
				E4Utils.reportError(context, "Write Model errors", "Parse failed using the selected persistence.", e);
				return CommonsEntityFactory.instance.createResolver();
			}
		});
		IEntity entity = E4Utils.syncExec(bm, entityRunnable).get();

		boolean adding = dialog.isForceAdding();
		IEntityIterator<IEntity> iterator;
		if (bm.wIsSet("syntheticRoot")) {
			IEntity syntheticRoot = bm.wGet("syntheticRoot");
			adding |= syntheticRoot.wSize() > 1;
			if (adding && !EntityUtils.isComposite(focusEntity)) {
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
						!EntityUtils.isReplaceable(focusEntity, clipboardEntity))
					clipboardEntity = CommonsEntityFactory.instance.create(stage, clipboardEntity);
				IEntity parent = focusEntity.wGetParent();
				parent.wSet(focusEntity, clipboardEntity);
				break;
			} else {
				if (!CommonsEntityDescriptorEnum.SameStageFragment.equals(stage) ||
						!EntityUtils.isAddable(focusEntity, clipboardEntity))
					clipboardEntity = CommonsEntityFactory.instance.create(stage, clipboardEntity);
				if (bm.wIsSet("hilightPosition"))
					focusEntity.wAdd(bm.wIntValue("hilightPosition"), clipboardEntity);
				else
					focusEntity.wAdd(clipboardEntity);
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
		E4Utils.syncExec(bm, () -> {
			IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
			IEntity entityContents = viewer.getEntityContents();
			IEntityPart contents = viewer.getEditPartRegistry().get(entityContents);
			viewer.setSelection(new StructuredSelection(contents));
		});
	}

	public static boolean canReplaceWithDefault(IBindingManager bm) {
		return isValidFocusEntityPart(bm);
	}
	public static void replaceWithDefault(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("focusEntity");
		IEntity parent = primarySelectedEntity.wGetParent();
		IEntity defaultEntity = GenericEntityFactory.instance.create(primarySelectedEntity.wGetEntityDescriptor());
		parent.wSet(primarySelectedEntity, defaultEntity);
	}

	public static boolean canImportEntity(IBindingManager bm) {
		return isValidFocusEntityPart(bm);
	}
	public static void importEntity(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity focusEntity = bm.wGet("focusEntity");
		
		RunnableWithResult<IImportAsModelDialog> runnable = RunnableWithResult.create(() -> {
			Shell shell = viewer.getControl().getShell();
			IEclipseContext eclipseContext = (IEclipseContext) bm.wGetValue("eclipseContext");
			IImportAsModelDialog dialog = eclipseContext.get(IImportAsModelDialogFactory.class)
					.createImportAsModelDialog(shell, "Import model", EntityUtils.isComposite(focusEntity));
			dialog.show();
			return dialog;
		});

		E4Utils.syncExec(bm, runnable);
		IImportAsModelDialog dialog = runnable.get();
		if (!dialog.isConfirmed())
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
							!EntityUtils.isReplaceable(focusEntity, importedEntity))
						importedEntity = CommonsEntityFactory.instance.create(stage, importedEntity);
					IEntity parent = focusEntity.wGetParent();
					parent.wSet(focusEntity, importedEntity);
					break;
				} else {
					if (!CommonsEntityDescriptorEnum.SameStageFragment.equals(stage) ||
							!EntityUtils.isAddable(focusEntity, importedEntity))
						importedEntity = CommonsEntityFactory.instance.create(stage, importedEntity);
					if (bm.wIsSet("hilightPosition"))
						focusEntity.wAdd(bm.wIntValue("hilightPosition"), importedEntity);
					else
						focusEntity.wAdd(importedEntity);
				}
			} catch (Exception e) {
				// fail silently
			}
		}
	}

	public static boolean canReplaceEntity(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		IEntity primarySelectedEntity = bm.wGet("focusEntity");
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
		IEntity focusEntity = bm.wGet("focusEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("featureDescriptor"))
			focusEntity = focusEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		IEntity replacement = GenericEntityFactory.instance.create(ed);
		transformer.transform(focusEntity.wGetAdaptee(false), replacement);
		focusEntity.wGetParent().wSet(focusEntity, replacement);
	}

	public static boolean canAddEntity(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		IEntity focusEntity = bm.wGet("focusEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("featureDescriptor"))
			focusEntity = focusEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		return EntityUtils.isAddable(focusEntity, ed);
	}
	public static void addEntity(IBindingManager bm) {
		IEntity focusEntity = bm.wGet("focusEntity");
		EntityDescriptor<?> ed = (EntityDescriptor<?>) bm.wGetValue("entityDescriptor");
		if (bm.wIsSet("featureDescriptor"))
			focusEntity = focusEntity.wGet((FeatureDescriptor) bm.wGetValue("featureDescriptor"));
		IEntity child = GenericEntityFactory.instance.create(ed);

		//FIXME make configurable
		if (CommonsEntityDescriptorEnum.Variable.isLanguageSupertypeOf(ed))
			child.wGet(CommonsFeatureDescriptorEnum.varType).wSetValue(focusEntity.wGetEntityDescriptor(0));

		if (bm.wIsSet("hilightPosition"))
			focusEntity.wAdd(bm.wIntValue("hilightPosition"), child);
		else
			focusEntity.wAdd(child);
	}

	public static boolean canReplaceFragment(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity predicateEntity = bm.wGet("predicateEntity");


		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(ts);
		//FIXME workaround for domain content assist that assume self initialized with primarySelectedEntity
		bm.wDefValue("self", focusEntity);
		boolean predicateResult = BehaviorUtils.evaluatePredicate(predicateEntity, 0, bm);
		ts.rollback();
		bm.wExitScope();

		if (!predicateResult)
			return false;

		return EntityUtils.isReplaceable(focusEntity, bm.wGet("fragmentEntity"));
	}

	public static void replaceFragment(IBindingManager bm) {
		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		focusEntity.wGetParent().wSet(focusEntity, fragmentEntity);
	}

	public static boolean canAddFragment(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity predicateEntity = bm.wGet("predicateEntity");

		ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
		bm.wEnterScope(ts);
		//FIXME workaround for domain content assist that assume self initialized with primarySelectedEntity
		bm.wDefValue("self", focusEntity);
		boolean predicateResult = BehaviorUtils.evaluatePredicate(predicateEntity, 0, bm);
		ts.rollback();
		bm.wExitScope();

		if (!predicateResult)
			return false;

		return EntityUtils.isAddable(focusEntity, bm.wGet("fragmentEntity"));
	}

	public static void addFragment(IBindingManager bm) {
		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		if (bm.wIsSet("hilightPosition"))
			focusEntity.wAdd(bm.wIntValue("hilightPosition"), fragmentEntity);
		else
			focusEntity.wAdd(fragmentEntity);
	}

	public static boolean canWrapFragment(IBindingManager bm) {
		if (!isValidFocusEntityPart(bm))
			return false;

		if (!BehaviorUtils.evaluatePredicate(bm.wGet("predicateEntity"), 0, bm))
			return false;

		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		return EntityUtils.isReplaceable(focusEntity, fragmentEntity);
	}

	public static void wrapFragment(IBindingManager bm) {
		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity fragmentEntity = bm.wGet("fragmentEntity");
		DefaultWrapInTransformer.instance.transform(focusEntity, fragmentEntity);
		focusEntity.wGetParent().wSet(focusEntity, fragmentEntity);
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
			bm.wSet("focusEntity", EntityUtils.mapEntity(bm.wGet("focusEntity"), model));
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
				bm.wGet("self").wGetLanguageKit().hasVisitor(ValidatorOperation.ID) &&
				bm.wIsSet("viewer") && ((IEntityPartViewer) bm.wGetValue("viewer")).isOperationExecutable();
	}

	public static void validateModel(IBindingManager bm) {
		ValidatorOperation.validate(bm.wGet("self"), bm);
	}

	public static boolean canNormalizeModel(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(NormalizerOperation.ID) &&
				bm.wIsSet("viewer") && ((IEntityPartViewer) bm.wGetValue("viewer")).isOperationExecutable();
	}

	public static void normalizeModel(IBindingManager bm) {
		NormalizerOperation.normalize(bm.wGet("self"), bm);
	}

	public static boolean canPrettyPrintModel(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wIsSet("viewer") && ((IEntityPartViewer) bm.wGetValue("viewer")).isOperationExecutable();
	}

	public static void prettyPrintModel(IBindingManager bm) {
		E4Utils.invokePrettyPrinter(bm);
	}
	public static boolean canInterpretModel(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(InterpreterOperation.ID) &&
				bm.wIsSet("viewer") && ((IEntityPartViewer) bm.wGetValue("viewer")).isOperationExecutable();
	}

	public static void interpretModel(IBindingManager bm) {
		E4Utils.invokeInterpreter(bm);
	}

	public static boolean canGenerateArtifacts(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(ArtifactsGeneratorOperation.ID) &&
				bm.wIsSet("viewer") && ((IEntityPartViewer) bm.wGetValue("viewer")).isOperationExecutable();
	}

	public static void generateArtifacts(IBindingManager bm) {
		ArtifactsGeneratorOperation.generate(bm.wGet("self"), bm);
	}
	public static boolean canGenerateJava(IBindingManager bm) {
		return bm.wIsSet("self") &&
				bm.wGet("self").wGetLanguageKit().hasVisitor(IE4UIConstants.JAVA_COMPILER_OPERATION_ID) &&
				bm.wIsSet("viewer") && ((IEntityPartViewer) bm.wGetValue("viewer")).isOperationExecutable();
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
