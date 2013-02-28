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
package org.whole.lang.e4.ui.util;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MBindingTable;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MKeyBinding;
import org.eclipse.e4.ui.model.application.ui.MElementContainer;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.renderers.swt.MenuManagerRenderer;
import org.eclipse.e4.ui.workbench.swt.factories.IRendererFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.e4.ui.command.ICommandFactory;
import org.whole.lang.e4.ui.handler.AddEntityHandler;
import org.whole.lang.e4.ui.handler.AddFragmentHandler;
import org.whole.lang.e4.ui.handler.CopyAsImageHandler;
import org.whole.lang.e4.ui.handler.CopyEntityPathHandler;
import org.whole.lang.e4.ui.handler.CopyHandler;
import org.whole.lang.e4.ui.handler.CutHandler;
import org.whole.lang.e4.ui.handler.DeleteHandler;
import org.whole.lang.e4.ui.handler.ImportHandler;
import org.whole.lang.e4.ui.handler.PasteAsHandler;
import org.whole.lang.e4.ui.handler.PasteHandler;
import org.whole.lang.e4.ui.handler.ReplaceEntityHandler;
import org.whole.lang.e4.ui.handler.ReplaceFragmentHandler;
import org.whole.lang.e4.ui.handler.ReplaceWithDefaultHandler;
import org.whole.lang.e4.ui.handler.SelectAllHandler;
import org.whole.lang.e4.ui.handler.SelectNotationHandler;
import org.whole.lang.e4.ui.handler.ActionCallHandler;
import org.whole.lang.e4.ui.handler.WrapFragmentHandler;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.views.ResultsView;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E4Utils {

	public static MCommand findCommand(String commandId, MApplication application) {
		for (MCommand command : application.getCommands())
			if (commandId.equals(command.getElementId()))
				return command;
		return null;
	}

	public static MMenuElement findMenu(String elementId, MMenuElement rootMenu) {
		if (elementId.equals(rootMenu.getElementId()))
			return rootMenu;
		else if (rootMenu instanceof MMenu) {
			for (MMenuElement menuElement : ((MMenu) rootMenu).getChildren()) {
				if ((menuElement = findMenu(elementId, menuElement)) != null)
					return menuElement;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static void forceRender(IEclipseContext context, MMenu menu) {
		MenuManagerRenderer renderer = getMenuManagerRenderer(context, menu);
		renderer.processContents((MElementContainer<MUIElement>) ((Object) menu));
	}

	public static MenuManagerRenderer getMenuManagerRenderer(IEclipseContext context, MMenu menu) {
		IRendererFactory rendererFactory = context.get(IRendererFactory.class);
		MenuManagerRenderer renderer = (MenuManagerRenderer) rendererFactory.getRenderer(menu, null);
		return renderer;
	}

	@SuppressWarnings("unchecked")
	public static <T> T findMenu(String elementId, EModelService modelService, MApplication application, Class<T> type) {
		for (MWindow window : modelService.findElements(application, null, MWindow.class, null)) {
			MMenuElement menuElement = findMenu(elementId, window.getMainMenu());
			if (menuElement != null)
				return (T) menuElement;
		}
		return null;
	}
	public static MKeyBinding findKeyBinding(String commandId, MApplication application) {
		for (MBindingTable bindingTable : application.getBindingTables()) {
			for (MKeyBinding keyBinding : bindingTable.getBindings())
				if (commandId.equals(keyBinding.getCommand().getElementId()))
					return keyBinding;
		}
		return null;
	}

	public static  String createBundleclassURI(Class<?> clazz) {
		return "bundleclass://org.whole.lang.e4.ui/" + clazz.getName();
	}

	public static  String createPlatformPuginURI(String pluginRelativePath) {
		return "platform:/plugin/org.whole.lang.e4.ui/" + pluginRelativePath;
	}

	public static IBindingManager createSelectionBindings(SelectionChangedEvent event) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		defineSelectionBindings(bm, event);
		return bm;
	}
	public static IBindingManager createSelectionBindings(List<IEntityPart> selectedEntityParts, E4GraphicalViewer viewer) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		defineSelectionBindings(bm, selectedEntityParts, viewer);
		return bm;
	}
	@SuppressWarnings("unchecked")
	public static void defineSelectionBindings(IBindingManager bm, SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		List<IEntityPart> selectedEntityParts = selection instanceof IStructuredSelection ?
				((IStructuredSelection) selection).toList() : Collections.emptyList();
		defineSelectionBindings(bm, selectedEntityParts, (E4GraphicalViewer) event.getSelectionProvider());		
	}
	public static void defineSelectionBindings(IBindingManager bm, List<IEntityPart> selectedEntityParts, E4GraphicalViewer viewer) {
		IEntity selectedEntities = BindingManagerFactory.instance.createTuple();
		for (IEntityPart selectedEntityPart : selectedEntityParts)
			selectedEntities.wAdd(selectedEntityPart.getModelEntity());

		if (viewer != null) {
			bm.wDef("self", EntityUtils.getCompoundRoot(viewer.getEntityContents()));
			bm.wDefValue("viewer", viewer);
		}
		bm.wDef("selectedEntities", selectedEntities);
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(selectedEntities);
		if (iterator.hasNext()) {
			bm.wDef("primarySelectedEntity", iterator.next());
			IEntityPart primarySelectedEntityPart = selectedEntityParts.get(0);
			if (/* !selectedEntityParts.isEmpty() && */ primarySelectedEntityPart instanceof IHilightable) {
				final IHilightable hilightable = (IHilightable) primarySelectedEntityPart;
				bm.wDefValue("hilightPosition", -1);
				bm.wGet("hilightPosition").wAddRequestEventHandler(new IdentityRequestEventHandler() {
					public int notifyRequested(IEntity source, FeatureDescriptor feature, int value) {
						return hilightable.getHilightPosition();
					}
				});
			}
			if (primarySelectedEntityPart instanceof ITextualEntityPart) {
				final ITextualEntityPart textualEntityPart = (ITextualEntityPart) primarySelectedEntityPart;
				bm.wDefValue("selectedText", "");
				bm.wGet("selectedText").wAddRequestEventHandler(new IdentityRequestEventHandler() {
					public String notifyRequested(IEntity source, FeatureDescriptor feature, String value) {
						return textualEntityPart.hasSelectionRange() ?
								DataTypeUtils.getAsPresentationString(textualEntityPart.getModelEntity())
										.substring(textualEntityPart.getSelectionStart(), textualEntityPart.getSelectionEnd()) : "";
					}
				});
			}
		}
	}

	public static void defineResourceBindings(IBindingManager bm, IModelInput modelInput) {
		try {
			// NOTE: we must use the platform class loader
			// because bm doesn't includes the classLoader variable, yet
			ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
			Class<?> resourceUtilsClass = Class.forName("org.whole.lang.ui.util.ResourceUtils", true, cl);
			Method defineResourceBindingsMethod = resourceUtilsClass.getMethod("defineResourceBindings", new Class[] {IBindingManager.class, IFile.class});
			defineResourceBindingsMethod.invoke(null, bm, modelInput.getFile());
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}


	@SuppressWarnings("unchecked")
	protected static class RevealViewRunnable<T> implements Runnable {
		protected IBindingManager bm;
		protected String viewId;
		protected String secondaryId;
		protected T result;

		public RevealViewRunnable(IBindingManager bm, String viewId, String secondaryId) {
			this.bm = bm;
			this.viewId = viewId;
			this.secondaryId = secondaryId;
		}
		public T getResult() {
			return result;
		}
		public void run() {
			try {
				// we must use the platform class loader
				// because bm doesn't includes the variable "classLoader"
				ClassLoader cl = ReflectionFactory.getClassLoader(bm);
				Class<?> pluginClass = Class.forName("org.whole.lang.ui.WholeUIPlugin", true, cl);
				Method revealViewMethod = pluginClass.getMethod("revealView", new Class[] {String.class, String.class});
				result = (T) revealViewMethod.invoke(null, viewId, secondaryId);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
	};
	public static <T> T revealLegacyView(IEclipseContext context, IBindingManager bm, String viewId, String secondaryId) {
		RevealViewRunnable<T> runnable = new RevealViewRunnable<T>(bm, viewId, secondaryId);
		context.get(UISynchronize.class).syncExec(runnable);
		return runnable.getResult();
	}
	public static <T> T  revealLegacyView(IEclipseContext context, IBindingManager bm, Class<T> clazz) {
		return revealLegacyView(context, bm, clazz.getName(), null);
	}
	public static void revealResultsView(IEclipseContext context, IBindingManager bm, final IEntity results) {
		RevealViewRunnable<ResultsView> runnable = new RevealViewRunnable<ResultsView>(bm, ResultsView.class.getName(), null) {
			public void run() {
				super.run();
				getResult().setContents(results);
			}
		};
		context.get(UISynchronize.class).syncExec(runnable);
	}
	
	public static void registerCommands(EHandlerService handlerService,
			MApplication application, ICommandFactory commandFactory) {
		// register platform services
		handlerService.activateHandler(EDIT_CUT, new CutHandler());
		handlerService.activateHandler(EDIT_COPY, new CopyHandler());
		handlerService.activateHandler(EDIT_PASTE, new PasteHandler());
		handlerService.activateHandler(EDIT_DELETE, new DeleteHandler());
		handlerService.activateHandler(EDIT_SELECT_ALL, new SelectAllHandler());

		application.getCommands().add(commandFactory.createCopyEntityPathCommand());
		handlerService.activateHandler(COPY_ENTITY_PATH_COMMAND_ID, new CopyEntityPathHandler());
		application.getCommands().add(commandFactory.createCopyAsImageCommand());
		handlerService.activateHandler(COPY_AS_IMAGE_COMMAND_ID, new CopyAsImageHandler());
		application.getCommands().add(commandFactory.createPasteAsCommand());
		handlerService.activateHandler(PASTE_AS_COMMAND_ID, new PasteAsHandler());

		application.getCommands().add(commandFactory.createReplaceEntityCommand());
		handlerService.activateHandler(REPLACE_COMMAND_ID, new ReplaceEntityHandler());
		application.getCommands().add(commandFactory.createAddEntityCommand());
		handlerService.activateHandler(ADD_COMMAND_ID, new AddEntityHandler());

		application.getCommands().add(commandFactory.createReplaceFragmentCommand());
		handlerService.activateHandler(REPLACE_FRAGMENT_COMMAND_ID, new ReplaceFragmentHandler());
		application.getCommands().add(commandFactory.createAddFragmentCommand());
		handlerService.activateHandler(ADD_FRAGMENT_COMMAND_ID, new AddFragmentHandler());
		application.getCommands().add(commandFactory.createWrapFragmentCommand());
		handlerService.activateHandler(WRAP_FRAGMENT_COMMAND_ID, new WrapFragmentHandler());

		application.getCommands().add(commandFactory.createReplaceWithDefaultCommand());
		handlerService.activateHandler(REPLACE_WITH_DEFAULT_COMMAND_ID, new ReplaceWithDefaultHandler());
		application.getCommands().add(commandFactory.createImportCommand());
		handlerService.activateHandler(IMPORT_COMMAND_ID, new ImportHandler());
		application.getCommands().add(commandFactory.createSelectNotationCommand());
		handlerService.activateHandler(SELECT_NOTATION_COMMAND_ID, new SelectNotationHandler());
		application.getCommands().add(commandFactory.createActionCallCommand());
		handlerService.activateHandler(ACTION_CALL_COMMAND_ID, new ActionCallHandler());
	}
}
