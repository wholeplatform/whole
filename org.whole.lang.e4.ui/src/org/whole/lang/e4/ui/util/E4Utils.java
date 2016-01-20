/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MBindingTable;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MKeyBinding;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Shell;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.actions.IUIConstants;
import org.whole.lang.e4.ui.jobs.ExecutionState;
import org.whole.lang.events.IdentityRequestEventHandler;
import org.whole.lang.exceptions.IWholeRuntimeException;
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
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.DefaultWrapWithinTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;
import org.whole.lang.util.NullInputStream;
import org.whole.lang.util.NullOutputStream;

/**
 * @author Enrico Persiani
 */
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
	public static <T> T findMenu(String elementId, EModelService modelService, MApplication application, Class<T> type) {
		for (MWindow window : modelService.findElements(application, null, MWindow.class, null)) {
			MMenu mainMenu = window.getMainMenu();
			if (mainMenu == null)
				continue;
			MMenuElement menuElement = findMenu(elementId, mainMenu);
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

	public static IBindingManager createSelectionBindings(SelectionChangedEvent event, IEclipseContext context) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		bm.wDefValue("eclipseContext", context);
		defineSelectionBindings(bm, event);
		return bm;
	}
	public static IBindingManager createSelectionBindings(List<IEntityPart> selectedEntityParts, IEntityPartViewer viewer, IEclipseContext context) {
		IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
		bm.wDefValue("eclipseContext", context);
		defineSelectionBindings(bm, selectedEntityParts, viewer);
		return bm;
	}
	@SuppressWarnings("unchecked")
	public static void defineSelectionBindings(IBindingManager bm, SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		List<IEntityPart> selectedEntityParts = selection instanceof IStructuredSelection ?
				((IStructuredSelection) selection).toList() : Collections.emptyList();
		defineSelectionBindings(bm, selectedEntityParts, (IEntityPartViewer) event.getSelectionProvider());		
	}
	public static void defineSelectionBindings(IBindingManager bm, List<IEntityPart> selectedEntityParts, IEntityPartViewer viewer) {
		IEntity selectedEntities = BindingManagerFactory.instance.createTuple();
		for (IEntityPart selectedEntityPart : selectedEntityParts)
			selectedEntities.wAdd(selectedEntityPart.getModelEntity());

		if (viewer != null) {
			bm.wDef("self", EntityUtils.getCompoundRoot(viewer.getEntityContents()));
			bm.wDefValue("viewer", viewer);
			bm.wDef("focusEntity", viewer.getFocusEntityPart().getModelEntity());
		}
		bm.wDef("selectedEntities", selectedEntities);
		IEntityIterator<IEntity> iterator = IteratorFactory.childIterator();
		iterator.reset(selectedEntities);
		if (iterator.hasNext()) {
			IEntity focusEntity = iterator.next();
			bm.wDef("primarySelectedEntity", focusEntity);
			if (!bm.wIsSet("focusEntity"))
				bm.wDef("focusEntity", focusEntity);

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
		modelInput.getPersistenceProvider().defineBindings(bm);
		bm.wDefValue("modelInput", modelInput);
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

	public static void refreshNotation(final IEntityPartViewer viewer) {
		viewer.getContext().get(UISynchronize.class).syncExec(new Runnable() {
			@Override
			public void run() {
				viewer.refreshNotation();
			}
		});
	}
	public static void revealPart(final IEclipseContext context, final String partId) {
		context.get(UISynchronize.class).syncExec(new Runnable() {
			@Override
			public void run() {
				EPartService partService = context.get(EPartService.class);
				MPart part = partService.findPart(partId);
				if (part == null)
					part = partService.createPart(partId);
				partService.showPart(part, PartState.VISIBLE);
			}
		});
	}
	public static void reveal(final IEntityPartViewer viewer, final IEntity entity) {
		viewer.getContext().get(UISynchronize.class).syncExec(new Runnable() {
			@Override
			public void run() {
				viewer.reveal(entity);
			}
		});
	}
	public static void select(final IEntityPartViewer viewer, final IEntity entity) {
		viewer.getContext().get(UISynchronize.class).syncExec(new Runnable() {
			@Override
			public void run() {
				viewer.select(entity);
			}
		});
	}
	public static void selectAndReveal(final IEntityPartViewer viewer, final IEntity entity) {
		viewer.getContext().get(UISynchronize.class).syncExec(new Runnable() {
			@Override
			public void run() {
				viewer.selectAndReveal(entity);
			}
		});
	}

	public static IBindingScope invokeInterpreter(IBindingManager bm) {
		InputStream is;
		OutputStream os;
		try {
			ClassLoader cl = ReflectionFactory.getClassLoader(bm);
			Class<?> consoleFactoryClass = Class.forName("org.whole.lang.ui.console.WholeConsoleFactory", true, cl);
			Object ioConsole = consoleFactoryClass.getMethod("getIOConsole").invoke(null);
			Class<?> consoleClass = Class.forName("org.eclipse.ui.console.IOConsole", true, cl);
			is = (InputStream) consoleClass.getMethod("getInputStream").invoke(ioConsole);
			os = (OutputStream) consoleClass.getMethod("newOutputStream").invoke(ioConsole);
		} catch (Exception e) {
			is = NullInputStream.instance();
			os = NullOutputStream.instance();
		}
		return InterpreterOperation.interpret(bm.wGet("self"), bm, is, os);
	}
	public static void invokePrettyPrinter(IBindingManager bm) {
		OutputStream os;
		try {
			ClassLoader cl = ReflectionFactory.getClassLoader(bm);
			Class<?> consoleFactoryClass = Class.forName("org.whole.lang.ui.console.WholeConsoleFactory", true, cl);
			Object ioConsole = consoleFactoryClass.getMethod("getIOConsole").invoke(null);
			Class<?> consoleClass = Class.forName("org.eclipse.ui.console.IOConsole", true, cl);
			os = (OutputStream) consoleClass.getMethod("newOutputStream").invoke(ioConsole);
		} catch (Exception e) {
			os = NullOutputStream.instance();
		}

		try {
			bm.wEnterScope();
			bm.wDefValue("printWriter", new PrintWriter(os));
			PrettyPrinterOperation.prettyPrint(bm.wGet("self"), bm);
		} finally {
			bm.wExitScope();
		}
	}
	public static void reportError(final IEclipseContext context, final String title, final String message, Throwable t) {
		try {
			ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
			Class<?> uiPluginClass = Class.forName("org.whole.lang.e4.ui.E4CompatibilityPlugin", true, cl);
			uiPluginClass.getMethod("reportError", Shell.class, String.class, String.class, Throwable.class)
					.invoke(null, context.get(IServiceConstants.ACTIVE_SHELL), title, message, t);
		} catch (Exception e) {
		}
	}

	public static void suspendOperation(SuspensionKind kind, IWholeRuntimeException e) {
		suspendOperation(kind, e.asException(), e.getSourceEntity(), e.getBindings());		
	}
	public static void suspendOperation(SuspensionKind kind, Throwable throwable, IEntity sourceEntity, final IBindingManager bindings) {
		suspendOperation(kind, throwable, sourceEntity, bindings, Collections.emptySet());
	}
	public static void suspendOperation(SuspensionKind kind, Throwable throwable, IEntity sourceEntity, final IBindingManager bindings, Set<String> includeNames) {
		if (bindings.wIsSet("debug#reportModeEnabled") && !bindings.wBooleanValue("debug#reportModeEnabled"))
			return;
		if (bindings.wIsSet("debug#debugModeEnabled") && !bindings.wBooleanValue("debug#debugModeEnabled")) {
			if (kind.isError())
				E4Utils.reportError((IEclipseContext) bindings.wGetValue("eclipseContext"),
						"Domain behavior error", "Error while executing domain behavior", throwable);
			
			return;
		}
		if (kind.isBreak() && bindings.wIsSet("debug#breakpointsEnabled") && !bindings.wBooleanValue("debug#breakpointsEnabled"))
			return;

		if (((IEntityPartViewer) bindings.wGetValue("viewer")).getControl().getDisplay().getThread() == Thread.currentThread()) {
			E4Utils.reportError((IEclipseContext) bindings.wGetValue("eclipseContext"),
						"Domain behavior error", "Attempted suspension in UI thread", throwable);

			return;
		}

		final IEclipseContext context = (IEclipseContext) bindings.wGetValue("eclipseContext");
		context.get(UISynchronize.class).syncExec(new Runnable() {
			public void run() {
				try {
					ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
					Class<?> uiPluginClass = Class.forName("org.whole.lang.e4.ui.E4CompatibilityPlugin", true, cl);
					Method method = uiPluginClass.getMethod("revealPerspective", String.class);
					method.invoke(null, "org.whole.lang.ui.perspectives.LanguageWorkbenchDebugPerspectiveFactory");
				} catch (Exception e) {
					throw new IllegalStateException(e);
				}

				E4Utils.revealPart(context, IUIConstants.DEBUG_PART_ID);
				E4Utils.revealPart(context, IUIConstants.VARIABLES_PART_ID);
				if (bindings.wIsSet("self") && bindings.wIsSet("viewer")) {
					IEntity selfEntity = bindings.wGet("self");
					((IEntityPartViewer) bindings.wGetValue("viewer")).selectAndReveal(selfEntity);
				}
			}
		});
		
		IEventBroker eventBroker = context.get(IEventBroker.class);
		ExecutionState execution = new ExecutionState(kind, throwable, sourceEntity, bindings, includeNames);
		eventBroker.post(IUIConstants.TOPIC_UPDATE_DEBUG, execution);
		execution.pause();
	}

	public static void openEditor(IEclipseContext context, IFile file, IPersistenceKit persistenceKit) {
		try {
			ClassLoader cl = ReflectionFactory.getPlatformClassLoader();
			Class<?> editorPartClass = Class.forName("org.whole.lang.e4.ui.E4CompatibilityPlugin", true, cl);
			editorPartClass.getMethod("openEditor", IEclipseContext.class, IFile.class, IPersistenceKit.class)
					.invoke(null, context, file, persistenceKit);
		} catch (Exception e) {
		}
	}
	
	public static IPersistenceProvider createWorkspaceProvider(IBindingManager bm, String resourceString, boolean isInput) {
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(resourceString);
		if (resource == null) {
			if (isInput)
				throw new IllegalArgumentException("The workspace doesn't contain the resource: "+resourceString);
			else {
				try {
					IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(resourceString));
					file.create(new ByteArrayInputStream(new byte[0]), true, null);
					resource = file;
				} catch (CoreException e) {
					throw new IllegalArgumentException("Failed to create a file at the following path: "+resourceString);
				}
			}
		}

		if (resource instanceof IFile)
			return new IFilePersistenceProvider((IFile) resource, bm);

		throw new UnsupportedOperationException("Unable to find sthe specified resource in the Workspace");
	}
	public static boolean isLegacyApplication() {
		try {
			Class.forName("org.eclipse.ui.internal.Workbench", true, ReflectionFactory.getPlatformClassLoader());
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
