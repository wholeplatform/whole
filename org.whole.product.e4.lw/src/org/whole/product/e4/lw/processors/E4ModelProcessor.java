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
package org.whole.product.e4.lw.processors;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.SideValue;
import org.eclipse.e4.ui.model.application.ui.advanced.MAdvancedFactory;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MDialog;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimBar;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledToolItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBar;
import org.eclipse.e4.ui.model.application.ui.menu.MToolBarElement;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class E4ModelProcessor {
	private static final String PLACEHOLDER_WINDOW_ID = "org.whole.product.e4.lw.placeholderWindow";

	@Inject
	protected IEclipseContext context;
	@Inject
	protected IWorkspace workspace;
	@Inject
	protected MApplication application;
	@Inject
	protected EModelService modelService;

	@Execute
	protected void initialize() throws CoreException {
		try {
			ClasspathPersistenceProvider pp = new ClasspathPersistenceProvider("org/whole/product/e4/lw/WorkspaceConfiguration.xwl");
			InterpreterOperation.interpret(XmlBuilderPersistenceKit.instance().readModel(pp));

			MUIElement placeholderWindow = modelService.find(PLACEHOLDER_WINDOW_ID, application);
			if (placeholderWindow == null || !placeholderWindow.getParent().getChildren().remove(placeholderWindow))
				throw new IllegalStateException("Unable to remove placeholder window with id: '"+PLACEHOLDER_WINDOW_ID+"'");

			MTrimmedWindow window = MBasicFactory.INSTANCE.createTrimmedWindow();

			window.setLabel("Whole Language Workbench Window");
			window.setX(500);
			window.setY(20);
			window.setWidth(800);
			window.setHeight(1000);

			MMenu mainMenu = MMenuFactory.INSTANCE.createMenu();
			mainMenu.setElementId("menu:org.eclipse.ui.main.menu");
			mainMenu.getChildren().add(createFileMenu());
			mainMenu.getChildren().add(createEditMenu());
			mainMenu.getChildren().add(createHelpMenu());
			window.setMainMenu(mainMenu);

			MTrimBar trimBar = MBasicFactory.INSTANCE.createTrimBar();
			trimBar.setSide(SideValue.TOP);
			trimBar.getChildren().add(createToolBar());
			window.getTrimBars().add(trimBar);

			MPerspectiveStack perspectiveStack = MAdvancedFactory.INSTANCE.createPerspectiveStack();
			MPerspective perspective = MAdvancedFactory.INSTANCE.createPerspective();
			perspective.setLabel("P1");
			MPartSashContainer partSashContainer = MBasicFactory.INSTANCE.createPartSashContainer();
			partSashContainer.setHorizontal(false);
			MPartStack partStack = MBasicFactory.INSTANCE.createPartStack();
			MPart part = MBasicFactory.INSTANCE.createPart();
			part.setContributionURI("bundleclass://org.whole.lang.e4.ui/org.whole.lang.e4.ui.parts.E4GraphicalPart");
			part.setLabel("Part1a");
			part.setCloseable(true);
			Map<String, String> persistedState = part.getPersistedState();
			persistedState.put("basePersistenceKitId", "org.whole.lang.xml.codebase.XmlBuilderPersistenceKit");
			persistedState.put("filePath", "/BaseProject/src/org/whole/lang/ExampleModel.xwl");
			persistedState.put("overridePersistenceKitId", "org.whole.lang.xml.codebase.XmlBuilderPersistenceKit");
			partStack.getChildren().add(part);
			partSashContainer.getChildren().add(partStack);
			perspective.getChildren().add(partSashContainer);
			perspectiveStack.getChildren().add(perspective);
			window.getChildren().add(perspectiveStack);
			application.getChildren().add(window);

		} catch (Exception e) {
			System.out.println("Unable to configure the initial workspace");
			e.printStackTrace();
		}
	}

	private MToolBar createToolBar() {
		MToolBar toolBar = MMenuFactory.INSTANCE.createToolBar();
		toolBar.setElementId("toolbar:org.eclipse.ui.main.toolbar");
		List<MToolBarElement> toolItems = toolBar.getChildren();
		toolItems.add(createHandledToolItem("save", "Save", "org.eclipse.ui.file.save", "platform:/plugin/org.whole.product.e4.lw/icons/save_edit.png"));
		toolItems.add(createHandledToolItem("quit", "Quit", "org.eclipse.ui.file.exit"));
		toolItems.add(createHandledToolItem("revert", "Revert", "org.eclipse.ui.file.revert"));
		toolItems.add(createHandledToolItem("generateJava", "Generate Java", "org.whole.lang.e4.ui.command::generateJava"));
		return toolBar;
	}

	protected MMenu createFileMenu() {
		MMenu fileMenu = MMenuFactory.INSTANCE.createMenu();
		fileMenu.setLabel("File");

		List<MMenuElement> menuItems = fileMenu.getChildren();

		menuItems.add(createHandledMenuItem("save", "Save", "org.eclipse.ui.file.save", "platform:/plugin/org.whole.product.e4.lw/icons/save_edit.png"));
		menuItems.add(createHandledMenuItem("quit", "Quit", "org.eclipse.ui.file.exit"));
		menuItems.add(createHandledMenuItem("revert", "Revert", "org.eclipse.ui.file.revert"));

		return fileMenu;
	}

	protected MMenu createEditMenu() {
		MMenu editMenu = MMenuFactory.INSTANCE.createMenu();
		editMenu.setLabel("Edit");

		List<MMenuElement> menuItems = editMenu.getChildren();

		menuItems.add(createHandledMenuItem("undo", "Undo", "org.eclipse.ui.edit.undo"));
		menuItems.add(createHandledMenuItem("redo", "Redo", "org.eclipse.ui.edit.redo"));
		menuItems.add(MMenuFactory.INSTANCE.createMenuSeparator());

		menuItems.add(createHandledMenuItem("cut", "Cut", "org.eclipse.ui.edit.cut"));
		menuItems.add(createHandledMenuItem("copy", "Copy", "org.eclipse.ui.edit.copy"));
		menuItems.add(createHandledMenuItem("paste", "Paste", "org.eclipse.ui.edit.paste"));

		menuItems.add(createHandledMenuItem("delete", "Delete", "org.eclipse.ui.edit.delete"));
		menuItems.add(createHandledMenuItem("selectAll", "Select All", "org.eclipse.ui.edit.selectAll"));
		menuItems.add(createHandledMenuItem("findReplace", "Find/Replace...", "org.eclipse.ui.edit.findReplace"));
		return editMenu;
	}

	protected MMenu createHelpMenu() {
		MMenu helpMenu = MMenuFactory.INSTANCE.createMenu();
		helpMenu.setLabel("File");
		helpMenu.getChildren().add(createHandledMenuItem("about", "About", "org.eclipse.ui.help.aboutAction"));
		helpMenu.getChildren().add(createHandledMenuItem("preferences", "Preferences", "org.eclipse.ui.window.preferences"));
		return helpMenu;
	}

	protected MHandledMenuItem createHandledMenuItem(String elementId, String label, String commandId) {
		return createHandledMenuItem(elementId, label, commandId, null);
	}
	protected MHandledMenuItem createHandledMenuItem(String elementId, String label, String commandId, String iconURI) {
		MHandledMenuItem handledMenuItem = MMenuFactory.INSTANCE.createHandledMenuItem();
		handledMenuItem.setElementId(elementId);
		handledMenuItem.setLabel(label);
		handledMenuItem.setIconURI(iconURI);
		handledMenuItem.setCommand(E4Utils.findCommand(commandId, application));
		return handledMenuItem;
	}
	protected MHandledToolItem createHandledToolItem(String elementId, String label, String commandId) {
		return createHandledToolItem(elementId, label, commandId, null);
	}
	protected MHandledToolItem createHandledToolItem(String elementId, String label, String commandId, String iconURI) {
		MHandledToolItem handledToolItem = MMenuFactory.INSTANCE.createHandledToolItem();
		handledToolItem.setElementId(elementId);
		handledToolItem.setLabel(label);
		handledToolItem.setIconURI(iconURI);
		handledToolItem.setCommand(E4Utils.findCommand(commandId, application));
		return handledToolItem;
	}
}
