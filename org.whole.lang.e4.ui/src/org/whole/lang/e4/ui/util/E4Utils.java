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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
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
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.e4.ui.viewers.E4GraphicalViewer;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.views.ResultsView;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.DefaultWrapWithinTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;

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
			if (primarySelectedEntityPart instanceof IHilightable) {
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
			bm.wDefValue("modelInput", modelInput);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

		
	public static IEntity wrapToBehavior(EntityDescriptor<?> ed, IEntityTransformer entityTransformer) {
		return wrapToBehavior(ed, null, entityTransformer);
	}
	public static IEntity wrapToBehavior(EntityDescriptor<?> ed, FeatureDescriptor intoFD, IEntityTransformer entityTransformer) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		if (intoFD != null)
			bm.wDefValue("intoFDUri", CommonsDataTypePersistenceParser.unparseFeatureDescriptor(intoFD));

		if (entityTransformer instanceof DefaultWrapInTransformer) {
			FeatureDescriptor fd = ((DefaultWrapInTransformer) entityTransformer).getFeatureDescriptor();

			bm.wDefValue("edUri", CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed));
			if (fd != null)
				bm.wDefValue("fdUri", CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd));
			else
				bm.wDefValue("fdIndex", ((DefaultWrapInTransformer) entityTransformer).getIndex());

			IEntity wrapInBehavior = WrapActionsTemplateManager.instance().create(fd != null ? "WrapIn" : "WrapInIndex");
			wrapInBehavior = BehaviorUtils.evaluate(wrapInBehavior, 1, bm);
			Matcher.removeVars(wrapInBehavior, false);
			return wrapInBehavior;
	
		} else if (entityTransformer instanceof DefaultWrapWithinTransformer) {
			FeatureDescriptor fd = ((DefaultWrapWithinTransformer) entityTransformer).getFeatureDescriptor();

			bm.wDefValue("edUri", CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed));
			bm.wDefValue("fdUri", CommonsDataTypePersistenceParser.unparseFeatureDescriptor(fd));

			IEntity wrapWithinBehavior = WrapActionsTemplateManager.instance().create("WrapWithin");
			wrapWithinBehavior = BehaviorUtils.evaluate(wrapWithinBehavior, 1, bm);
			Matcher.removeVars(wrapWithinBehavior, false);
			return wrapWithinBehavior;
		} else
			throw new IllegalArgumentException("unsupported entity transformer");
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
	public static <T> T revealLegacyView(UISynchronize uiSynchronize, IBindingManager bm, String viewId, String secondaryId) {
		RevealViewRunnable<T> runnable = new RevealViewRunnable<T>(bm, viewId, secondaryId);
		uiSynchronize.syncExec(runnable);
		return runnable.getResult();
	}
	public static <T> T  revealLegacyView(UISynchronize uiSynchronize, IBindingManager bm, Class<T> clazz) {
		return revealLegacyView(uiSynchronize, bm, clazz.getName(), null);
	}
	public static void revealResultsView(UISynchronize uiSynchronize, IBindingManager bm, final IEntity results) {
		RevealViewRunnable<ResultsView> runnable = new RevealViewRunnable<ResultsView>(bm, ResultsView.class.getName(), null) {
			public void run() {
				super.run();
				getResult().setContents(results);
			}
		};
		uiSynchronize.syncExec(runnable);
	}
	public static void invokeInterpreter(IBindingManager bm) {
		try {
			ClassLoader cl = ReflectionFactory.getClassLoader(bm);
			Class<?> consoleFactoryClass = Class.forName("org.whole.lang.ui.console.WholeConsoleFactory", true, cl);
			Object ioConsole = consoleFactoryClass.getMethod("getIOConsole").invoke(null);
			Class<?> consoleClass = Class.forName("org.eclipse.ui.console.IOConsole", true, cl);
			InputStream is = (InputStream) consoleClass.getMethod("getInputStream").invoke(ioConsole);
			OutputStream os = (OutputStream) consoleClass.getMethod("newOutputStream").invoke(ioConsole);
			InterpreterOperation.interpret(bm.wGet("self"), bm, is, os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void invokePrettyPrinter(IBindingManager bm) {
		try {
			ClassLoader cl = ReflectionFactory.getClassLoader(bm);
			Class<?> consoleFactoryClass = Class.forName("org.whole.lang.ui.console.WholeConsoleFactory", true, cl);
			Object ioConsole = consoleFactoryClass.getMethod("getIOConsole").invoke(null);
			Class<?> consoleClass = Class.forName("org.eclipse.ui.console.IOConsole", true, cl);
			OutputStream os = (OutputStream) consoleClass.getMethod("newOutputStream").invoke(ioConsole);
			bm.wEnterScope();
			bm.wDefValue("printWriter", new PrintWriter(os));
			PrettyPrinterOperation.prettyPrint(bm.wGet("self"), bm);
			bm.wExitScope();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
