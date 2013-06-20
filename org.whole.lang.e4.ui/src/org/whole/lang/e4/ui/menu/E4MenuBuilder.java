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
package org.whole.lang.e4.ui.menu;

import static org.whole.lang.e4.ui.api.IUIConstants.*;

import java.util.Iterator;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.MCoreExpression;
import org.eclipse.e4.ui.model.application.ui.MUiFactory;
import org.eclipse.e4.ui.model.application.ui.menu.ItemType;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuSeparator;
import org.eclipse.e4.ui.model.application.ui.menu.MOpaqueMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.impl.MenuFactoryImpl;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.jface.action.IContributionItem;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.e4.ui.api.AbstractUIBuilder;
import org.whole.lang.e4.ui.api.IContextProvider;
import org.whole.lang.e4.ui.expressions.AddEntityVisibleWhen;
import org.whole.lang.e4.ui.expressions.ReplaceEntityVisibleWhen;
import org.whole.lang.e4.ui.expressions.SelectNotationVisibleWhen;
import org.whole.lang.e4.ui.expressions.VisibilityExpression;
import org.whole.lang.e4.ui.handler.OpenDialogHandler;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.StringUtils;
import org.whole.lang.util.UniqueIdGenerator;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class E4MenuBuilder extends AbstractUIBuilder<MMenuElement, MMenu> {
	protected EModelService modelService;
	protected MApplication application;

	public E4MenuBuilder(IContextProvider contextProvider) {
		super(contextProvider);
		this.modelService = contextProvider.getContext().get(EModelService.class);
		this.application = contextProvider.getContext().get(MApplication.class);
	}

	protected UniqueIdGenerator idGen;
	public UniqueIdGenerator getIdGen() {
		if (idGen == null)
			idGen = UniqueIdGenerator.newUniqueIdGenerator(menu.getElementId()+".menuitem");
		return idGen;
	}

	protected MMenu menu;
	public MMenu getContainer() {
		return menu;
	}
	public MMenu setContainer(MMenu menu) {
		MMenu previous = this.menu;
		this.menu = menu;
		return previous;
	}

	public void before() {
		Iterator<MMenuElement> iterator = menu.getChildren().iterator();
		while (iterator.hasNext()) {
			MMenuElement menuElement = iterator.next();
			menuElement.setToBeRendered(true);
			menuElement.setVisible(false);
			iterator.remove();
		}
	}

	@Override
	public void after() {
	}

	@Override
	public void addOpenDialog() {
		String contriputionURI = E4Utils.createBundleclassURI(OpenDialogHandler.class);
		MDirectMenuItem menuItem = createDirectItem(REPLACE_ICON_URI, "open dialog", contriputionURI);
		addItem(menuItem);
	}

	@Override
	public void addDeleteItem() {
		MHandledMenuItem deleteMenu =  E4Utils.findMenu(DELETE_MENU_ID, modelService, application, MHandledMenuItem.class);
		deleteMenu = (MHandledMenuItem) modelService.cloneElement(deleteMenu, null);
		addItem(deleteMenu);
	}
	@Override
	public void addDefaultItem() {
		MCommand command = E4Utils.findCommand(REPLACE_WITH_DEFAULT_COMMAND_ID, application);
		MHandledMenuItem menuItem = createHandledItem(REPLACE_ICON_URI, DEFAULT_LABEL, command);
		addItem(menuItem);
	}

	@Override
	public void addContentAssistItem() {
		MMenu menu = createMenu(CONTENT_ASSIST_LABEL, getContentAssistVisibleWhen());
		addItem(menu);

		IContributionItem ici = new ContentAssistCompositeContributionItem(contextProvider);
		menu.getChildren().add(createOpaqueMenuItem(ici));
	}
	@Override
	public void addEntityAssistItem() {
		MMenu menu = createMenu(ENTITY_ASSIST_LABEL, getValidSingleSelectionVisibleWhen());
		addItem(menu);

		IContributionItem ici = new EntityAssistCompositeContributionItem(contextProvider);
		menu.getChildren().add(createOpaqueMenuItem(ici));
	}
	@Override
	public void addFeatureAssistItem() {
		MMenu menu = createMenu(FEATURE_ASSIST_LABEL, getFeatureAssistVisibleWhen());
		addItem(menu);

		IContributionItem ici = new FeatureAssistCompositeContributionItem(contextProvider);
		menu.getChildren().add(createOpaqueMenuItem(ici));
	}

	protected void addActionsItem(String menuLabel, VisibilityExpression expression, IContributionItem ici) {
		MMenu menu = createMenu(menuLabel, expression);
		addItem(menu);

		menu.getChildren().add(createOpaqueMenuItem(ici));
	}

	protected MHandledMenuItem createReplaceEntityItem(EntityDescriptor<?> ed, boolean sameLanguage) {
		String label = StringUtils.camelCaseToSpacedWords(ed.getName());
		MCommand command = E4Utils.findCommand(REPLACE_COMMAND_ID, application);
		MParameter parameter = createEDUriParameter(ed);
		MHandledMenuItem menuItem = createHandledItem(REPLACE_ICON_URI, label, command, parameter);
		MCoreExpression expression = MUiFactory.INSTANCE.createCoreExpression();
		expression.setCoreExpression(new ReplaceEntityVisibleWhen(ed, sameLanguage));
		menuItem.setVisibleWhen(expression);
		return menuItem;
	}
	protected MHandledMenuItem createAddEntityItem(EntityDescriptor<?> ed, boolean sameLanguage) {
		String label = StringUtils.camelCaseToSpacedWords(ed.getName());
		MCommand command = E4Utils.findCommand(ADD_COMMAND_ID, application);
		MParameter parameter = createEDUriParameter(ed);
		MHandledMenuItem menuItem = createHandledItem(ADD_ICON_URI, label, command, parameter);
		MCoreExpression expression = MUiFactory.INSTANCE.createCoreExpression();
		expression.setCoreExpression(new AddEntityVisibleWhen(ed, sameLanguage));
		menuItem.setVisibleWhen(expression);
		return menuItem;
	}

	@Override
	public void addReplaceEntityItem(EntityDescriptor<?> ed) {
		addItem(createReplaceEntityItem(ed, true));
	}
	@Override
	public void addAddEntityItem(EntityDescriptor<?> ed) {
		addItem(createAddEntityItem(ed, true));
	}

	@Override
	public void addSeparator() {
		addSeparator(null);
	}
	@Override
	public void addSeparator(String groupName) {
		MMenuSeparator separator = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		if (groupName != null)
			separator.setElementId(groupName);
		addItem(separator);
	}
	@Override
	public void addGroupMarker(String groupName) {
		MMenuSeparator separator = MenuFactoryImpl.eINSTANCE.createMenuSeparator();
		separator.setElementId(groupName);
		separator.getTags().add(TAG_GROUP_MARKER);
		addItem(separator);
	}
	@Override
	public void addUndoItem() {
		MOpaqueMenuItem undoMenu =  E4Utils.findMenu(UNDO_MENU_ID, modelService, application, MOpaqueMenuItem.class);
		MCommand command = E4Utils.findCommand(EDIT_UNDO, application);
		addItem(createHandledItem(UNDO_ICON_URI, undoMenu.getLocalizedLabel(), command));
	}

	@Override
	public void addRedoItem() {
		MOpaqueMenuItem redoMenu =  E4Utils.findMenu(REDO_MENU_ID, modelService, application, MOpaqueMenuItem.class);
		MCommand command = E4Utils.findCommand(EDIT_REDO, application);
		addItem(createHandledItem(REDO_ICON_URI, redoMenu.getLocalizedLabel(), command));
	}

	@Override
	public void addCutItem() {
		MHandledMenuItem cutMenu =  E4Utils.findMenu(CUT_MENU_ID, modelService, application, MHandledMenuItem.class);
		cutMenu = (MHandledMenuItem) modelService.cloneElement(cutMenu, null);
		addItem(cutMenu);
	}
	@Override
	public void addCopyItem() {
		MHandledMenuItem copyMenu =  E4Utils.findMenu(COPY_MENU_ID, modelService, application, MHandledMenuItem.class);
		copyMenu = (MHandledMenuItem) modelService.cloneElement(copyMenu, null);
		addItem(copyMenu);
	}
	@Override
	public void addCopyEntityPathItem() {
		MHandledMenuItem copyMenu =  E4Utils.findMenu(COPY_MENU_ID, modelService, application, MHandledMenuItem.class);
		MCommand command = E4Utils.findCommand(COPY_ENTITY_PATH_COMMAND_ID, application);
		addItem(createHandledItem(copyMenu.getIconURI(), COPY_ENTITY_PATH_LABEL, command));
	}
	@Override
	public void addCopyAsImageItem() {
		MHandledMenuItem copyMenu =  E4Utils.findMenu(COPY_MENU_ID, modelService, application, MHandledMenuItem.class);
		MCommand command = E4Utils.findCommand(COPY_AS_IMAGE_COMMAND_ID, application);
		addItem(createHandledItem(copyMenu.getIconURI(), COPY_AS_IMAGE_LABEL, command));
	}
	@Override
	public void addPasteItem() {
		MHandledMenuItem pasteMenu =  E4Utils.findMenu(PASTE_MENU_ID, modelService, application, MHandledMenuItem.class);
		pasteMenu = (MHandledMenuItem) modelService.cloneElement(pasteMenu, null);
		addItem(pasteMenu);
	}
	@Override
	public void addPasteAsItem() {
		MHandledMenuItem pasteMenu =  E4Utils.findMenu(PASTE_MENU_ID, modelService, application, MHandledMenuItem.class);
		MCommand command = E4Utils.findCommand(PASTE_AS_COMMAND_ID, application);
		addItem(createHandledItem(pasteMenu.getIconURI(), PASTE_AS_LABEL, command));
	}

	@Override
	public void addNotationsItem() {
		MMenu menu = createMenu(NOTATION_LABEL, getNotationsVisibleWhen());

		addItem(menu);
		
		MCommand command = E4Utils.findCommand(SELECT_NOTATION_COMMAND_ID, application);
		for (IEditorKit editorKit : ReflectionFactory.getEditorKits()) {
			// add selected menu
			MHandledMenuItem menuItem = createHandledItem(null, editorKit.getName(), command, createEditorKitIdParameter(editorKit.getId()));
			menuItem.setType(ItemType.RADIO);
			menuItem.setSelected(true);
			MCoreExpression expression = MUiFactory.INSTANCE.createCoreExpression();
			expression.setCoreExpression(new SelectNotationVisibleWhen(editorKit, true));
			menuItem.setVisibleWhen(expression);
			menu.getChildren().add(menuItem);

			// add unselected menu
			menuItem = createHandledItem(null, editorKit.getName(), command, createEditorKitIdParameter(editorKit.getId()));
			menuItem.setType(ItemType.PUSH);
			menuItem.setSelected(false);
			expression = MUiFactory.INSTANCE.createCoreExpression();
			expression.setCoreExpression(new SelectNotationVisibleWhen(editorKit, false));
			menuItem.setVisibleWhen(expression);
			menu.getChildren().add(menuItem);
		}
	}

	@Override
	public void addSelectAllItem() {
		MHandledMenuItem selectAllMenu =  E4Utils.findMenu(SELECT_ALL_MENU_ID, modelService, application, MHandledMenuItem.class);
		selectAllMenu = (MHandledMenuItem) modelService.cloneElement(selectAllMenu, null);
		addItem(selectAllMenu);
	}
	@Override
	public void addImportItem() {
		MCommand command = E4Utils.findCommand(IMPORT_COMMAND_ID, application);
		MHandledMenuItem menuItem = createHandledItem(IMPORT_ICON_URI, IMPORT_LABEL, command);
		addItem(menuItem);
	}

	protected void addItem(MMenuElement menuElement) {
		menu.getChildren().add(menuElement);
	}
	protected MMenu createMenu(String label, VisibilityExpression expression) {
		MMenu menu = createMenu(label);
		MCoreExpression coreExpression = MUiFactory.INSTANCE.createCoreExpression();
		coreExpression.setCoreExpression(expression);
		menu.setVisibleWhen(coreExpression);
		return menu;
	}
	protected MMenu createMenu(String label) {
		MMenu menu = MenuFactoryImpl.eINSTANCE.createMenu();
		menu.setLabel(label);
		menu.setVisible(true);
		menu.setElementId(getIdGen().next());
		return menu;
	}
	protected MOpaqueMenuItem createOpaqueMenuItem(IContributionItem ici) {
		MOpaqueMenuItem opaqueMenuItem = MenuFactoryImpl.eINSTANCE.createOpaqueMenuItem();
		opaqueMenuItem.setVisible(true);
		opaqueMenuItem.setOpaqueItem(ici);
		opaqueMenuItem.setElementId(getIdGen().next());
		return opaqueMenuItem;
	}
	protected MHandledMenuItem createHandledItem(String iconURI, String label, MCommand command, MParameter... parameters) {
		MHandledMenuItem menuItem = MenuFactoryImpl.eINSTANCE.createHandledMenuItem();
		menuItem.setIconURI(iconURI);
		menuItem.setLabel(label);
		menuItem.setVisible(true);
		menuItem.setElementId(getIdGen().next());
		menuItem.setCommand(command);
		for (MParameter parameter : parameters)
			menuItem.getParameters().add(parameter);
		return menuItem;
	}
	protected MDirectMenuItem createDirectItem(String iconURI, String label, String contributionURI) {
		MDirectMenuItem menuItem = MenuFactoryImpl.eINSTANCE.createDirectMenuItem();
		menuItem.setIconURI(iconURI);
		menuItem.setLabel(label);
		menuItem.setVisible(true);
		menuItem.setElementId(getIdGen().next());
		menuItem.setContributionURI(contributionURI);
		return menuItem;
	}

	protected MParameter createEDUriParameter(EntityDescriptor<?> ed) {
		MParameter parameter = MCommandsFactory.INSTANCE.createParameter();
		parameter.setName(ED_URI_PARAMETER_ID);
		parameter.setValue(CommonsDataTypePersistenceParser.unparseEntityDescriptor(ed));
		return parameter;
	}
	protected MParameter createEditorKitIdParameter(String editorKitId) {
		MParameter parameter = MCommandsFactory.INSTANCE.createParameter();
		parameter.setName(EDITORKIT_ID_PARAMETER_ID);
		parameter.setValue(editorKitId);
		return parameter;
	}
}
