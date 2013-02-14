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
package org.whole.lang.ui.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.DeleteAction;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.MatchHeightAction;
import org.eclipse.gef.ui.actions.MatchWidthAction;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.ActionFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.ui.editor.IActionFactory;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editparts.CompositeColumnPart;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.menu.E3FullMenuNameStrategy;
import org.whole.lang.ui.menu.E3HierarchicalFillMenuStrategy;
import org.whole.lang.ui.menu.IE3FillMenuStrategy;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.ResourceUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeActionFactory {
	private static final Comparator<SelectionAction> selectionActionComparator = new Comparator<SelectionAction>() {
		public int compare(SelectionAction first, SelectionAction second) {
			return first.getText().compareTo(second.getText());
		}
	};

	private IWorkbenchPart workbenchPart;
	protected Map<IEditorKit, EditorKitCustomActions> editorKitCustomActionsMap = new HashMap<IEditorKit, EditorKitCustomActions>();
	protected EditorKitCustomActions editorKitCustomActionsMap(IEditorKit editorKit) {
		EditorKitCustomActions editorKitActions = editorKitCustomActionsMap.get(editorKit);
		if (editorKitActions == null)
			editorKitCustomActionsMap.put(editorKit, editorKitActions = new EditorKitCustomActions());
		return editorKitActions;
	}
	public static class EditorKitCustomActions {
		public Map<EntityDescriptor<?>, SelectionAction> addActionsMap;
		public Map<EntityDescriptor<?>, SelectionAction> replaceActionsMap;
		public Map<EntityDescriptor<?>, List<SelectionAction>> wrapActionsMap;
		public Map<EntityDescriptor<?>, List<SelectionAction>> textActionsMap;		
	}
	protected Map<EntityDescriptor<?>, SelectionAction> customAddActionsMap(IEditorKit editorKit) {
		if (editorKitCustomActionsMap(editorKit).addActionsMap == null)
			editorKitCustomActionsMap(editorKit).addActionsMap = new HashMap<EntityDescriptor<?>, SelectionAction>();
		return editorKitCustomActionsMap(editorKit).addActionsMap;
	}
	protected Map<EntityDescriptor<?>, SelectionAction> customReplaceActionsMap(IEditorKit editorKit) {
		if (editorKitCustomActionsMap(editorKit).replaceActionsMap == null)
			editorKitCustomActionsMap(editorKit).replaceActionsMap = new HashMap<EntityDescriptor<?>, SelectionAction>();
		return editorKitCustomActionsMap(editorKit).replaceActionsMap;
	}
	protected Map<EntityDescriptor<?>, List<SelectionAction>> customWrapActionsMap(IEditorKit editorKit) {
		if (editorKitCustomActionsMap(editorKit).wrapActionsMap == null)
			editorKitCustomActionsMap(editorKit).wrapActionsMap = new HashMap<EntityDescriptor<?>, List<SelectionAction>>();
		return editorKitCustomActionsMap(editorKit).wrapActionsMap;
	}
	protected Map<EntityDescriptor<?>, List<SelectionAction>> customTextActionsMap(IEditorKit editorKit) {
		if (editorKitCustomActionsMap(editorKit).textActionsMap == null)
			editorKitCustomActionsMap(editorKit).textActionsMap = new HashMap<EntityDescriptor<?>, List<SelectionAction>>();
		return editorKitCustomActionsMap(editorKit).textActionsMap;
	}

	protected Map<EntityDescriptor<?>, SelectionAction> addActionsMap = new HashMap<EntityDescriptor<?>, SelectionAction>();
	protected Map<EntityDescriptor<?>, SelectionAction> replaceActionsMap = new HashMap<EntityDescriptor<?>, SelectionAction>();
	protected Map<EntityDescriptor<?>, List<? extends SelectionAction>> wrapActionsMap = new HashMap<EntityDescriptor<?>, List<? extends SelectionAction>>();

	private ActionRegistry actionRegistry;

	private List<String> originalActions;

	private List<SelectionAction> editActions = new ArrayList<SelectionAction>();
	private List<SelectionAction> removeActions = new ArrayList<SelectionAction>();

	private PerformAction importAction;

	private IE3FillMenuStrategy fillEntityAssistMenuStrategy = E3HierarchicalFillMenuStrategy.instance();

	private IE3FillMenuStrategy fillLanguageMenuStrategy = E3HierarchicalFillMenuStrategy.instance(E3FullMenuNameStrategy.instance());
	private EntityAssistMenuListener entityAssistMenuListener = new EntityAssistMenuListener();

	protected SelectionAction getAddAction(IEditorKit editorKit, EntityDescriptor<?> ed) {
		SelectionAction action = customAddActionsMap(editorKit).get(ed);
		if (action == null)
			action = addActionsMap.get(ed);
		if (action == null) {
			action = getEditorKitActionFactory(editorKit).createAddAction(workbenchPart, ed);
			addActionsMap.put(ed, action);
		}
		return action;
	}
	protected SelectionAction getReplaceAction(IEditorKit editorKit, EntityDescriptor<?> ed) {
		SelectionAction action = customReplaceActionsMap(editorKit).get(ed);
		if (action == null)
			action = replaceActionsMap.get(ed);
		if (action == null) {
			action = getEditorKitActionFactory(editorKit).createReplaceAction(workbenchPart, ed);
			replaceActionsMap.put(ed, action);
		}
		return action;
	}
	protected List<? extends SelectionAction> getWrapActions(IEditorKit editorKit, EntityDescriptor<?> ed) {
		List<? extends SelectionAction> actions = customWrapActionsMap(editorKit).get(ed);
		if (actions == null)
			actions = wrapActionsMap.get(ed);
		if (actions == null) {
			actions = getEditorKitActionFactory(editorKit).createWrapActions(workbenchPart, ed);
			wrapActionsMap.put(ed, actions);
		}
		return actions;
	}

	protected Set<EntityDescriptor<?>> getTextEntityDescriptors(IEditorKit editorKit) {
		return customTextActionsMap(editorKit).keySet();
	}
	protected List<SelectionAction> getTextActions(IEditorKit editorKit, EntityDescriptor<?> ed) {
		return customTextActionsMap(editorKit).get(ed);
	}

	public synchronized void createActions(IWorkbenchPart workbenchPart,
			List<String> selectionActions, ActionRegistry registry) {
		this.workbenchPart = workbenchPart;
		actionRegistry = registry;

		originalActions = new ArrayList<String>(16);
		Iterator<?> iterator = registry.getActions();
		while (iterator.hasNext()) {
			IAction action = (IAction) iterator.next();
			originalActions.add(action.getId());
		}

		SelectionAction editAction;
		editActions.add(editAction = new ModelCutAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());

		editActions.add(editAction = new ModelCopyAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());

		editActions.add(editAction = new ModelCopyEntityPathAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());

		editActions.add(editAction = new ModelCopyAsImageAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());
		
		editActions.add(editAction = new ModelPasteAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());

		editActions.add(editAction = new ModelPasteAsAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());

		editActions.add(editAction = new ModelFindAction(workbenchPart));
		registry.registerAction(editAction);
		selectionActions.add(editAction.getId());

		removeActions.add(new ReplaceDefaultAction(workbenchPart, "Default"));

		importAction = new ImportAction(workbenchPart);
		registry.registerAction(importAction);

		updateEditorActions(workbenchPart, registry);
	}

	private void updateEditorActions(IWorkbenchPart workbenchPart, ActionRegistry registry) {
		for (IEditorKit editorKit : ReflectionFactory.getEditorKits()) {
			IActionFactory actionFactory = getEditorKitActionFactory(editorKit);

			actionFactory.initActions(workbenchPart);
			actionFactory.initAddActions(workbenchPart, actionRegistry, customAddActionsMap(editorKit));
			actionFactory.initReplaceActions(workbenchPart, actionRegistry, customReplaceActionsMap(editorKit));
			actionFactory.initWrapActions(workbenchPart, actionRegistry, customWrapActionsMap(editorKit));
			actionFactory.initTextActions(workbenchPart, actionRegistry, customTextActionsMap(editorKit));

			registry.registerAction(new SelectEditorKitAction(workbenchPart, editorKit));
		}
	}

	private IActionFactory getEditorKitActionFactory(IEditorKit editorKit) {
		IGEFEditorKit gefEditorKit = (IGEFEditorKit) editorKit;
		IActionFactory actionFactory = gefEditorKit.getActionFactory();
		return actionFactory;
	}

	public void setActionRegistry(ActionRegistry actionRegistry) {
		this.actionRegistry = actionRegistry;
	}

	public ActionRegistry getActionRegistry() {
		return actionRegistry;
	}

	public synchronized void fillContextMenu(IMenuManager contextMenu, ISelectionProvider provider) {
		List<?> selectedObjects = getSelectedObjects(provider);
		if (selectedObjects.size() == 1) {
			Object selectedObject = selectedObjects.get(0);
			if (selectedObject instanceof IEntityPart) {
				IEntityPart selectedPart = (IEntityPart) selectedObject;
				IEntity selectedEntity = ((IEntity) selectedPart.getModel());
				
				if (!selectedEntity.wGetEntityDescriptor().equals(CommonsEntityDescriptorEnum.RootFragment)) {
					fillEditMenu(contextMenu, provider);
	
					fillRemoveMenu(contextMenu, provider);
					fillValueAssistMenu(contextMenu, provider);
	
					IMenuManager assistMenu = new MenuManager("Entity Assist") {
						//FIXME workaround
						@Override
						public boolean isVisible() {
							boolean removeAll = getRemoveAllWhenShown();
							setRemoveAllWhenShown(false);
							boolean isVisible = super.isVisible();
							setRemoveAllWhenShown(removeAll);
							return isVisible;
						}
					};
					contextMenu.appendToGroup(GEFActionConstants.GROUP_EDIT, assistMenu);
					assistMenu.setRemoveAllWhenShown(true);

					IEditorKit editorKit = UIUtils.getEditorKit(selectedPart);

					entityAssistMenuListener.setEditorKit(editorKit);
					entityAssistMenuListener.setProvider(provider);
					fillEntityAssistMenu(assistMenu, provider, editorKit);
					assistMenu.addMenuListener(entityAssistMenuListener);
	
					if (EntityUtils.isSimple(selectedEntity))
						fillFeatureAssistMenu(contextMenu, provider,
								selectedEntity.wGetEditorKit());

					importAction.setSelectionProvider(provider);
					importAction.update();
					if (importAction.isEnabled())
						contextMenu.appendToGroup(GEFActionConstants.GROUP_REST, importAction);
				}

				if (!(provider instanceof TreeViewer))
					fillNotationMenu(contextMenu, provider);
			}
		} else
			fillBoundsMenu(contextMenu);
	}

	private void fillBoundsMenu(IMenuManager contextMenu) {
		MenuManager submenu = new MenuManager("Arrange");

		ActionRegistry actionRegistry = getActionRegistry();
		IAction action = actionRegistry
				.getAction(GEFActionConstants.ALIGN_LEFT);
		if (action.isEnabled())
			submenu.add(action);

		action = actionRegistry.getAction(GEFActionConstants.ALIGN_CENTER);
		if (action.isEnabled())
			submenu.add(action);

		action = actionRegistry.getAction(GEFActionConstants.ALIGN_RIGHT);
		if (action.isEnabled())
			submenu.add(action);

		submenu.add(new Separator());

		action = actionRegistry.getAction(GEFActionConstants.ALIGN_TOP);
		if (action.isEnabled())
			submenu.add(action);

		action = actionRegistry.getAction(GEFActionConstants.ALIGN_MIDDLE);
		if (action.isEnabled())
			submenu.add(action);

		action = actionRegistry.getAction(GEFActionConstants.ALIGN_BOTTOM);
		if (action.isEnabled())
			submenu.add(action);

		submenu.add(new Separator());

		action = actionRegistry.getAction(GEFActionConstants.MATCH_WIDTH);
		if (action.isEnabled())
			submenu.add(action);

		action = actionRegistry.getAction(GEFActionConstants.MATCH_HEIGHT);
		if (action.isEnabled())
			submenu.add(action);

		if (!submenu.isEmpty())
			contextMenu.appendToGroup(GEFActionConstants.GROUP_REST, submenu);
	}

	private void fillEditMenu(IMenuManager contextMenu, ISelectionProvider provider) {
		Iterator<SelectionAction> i = editActions.iterator();
		while (i.hasNext()) {
			SelectionAction editAction = i.next();
			contextMenu.appendToGroup(GEFActionConstants.GROUP_COPY, editAction);
		}
	}

	private void fillRemoveMenu(IMenuManager contextMenu, ISelectionProvider provider) {
		MenuManager removeMenu = new MenuManager("Remove");

		IAction delAction = getActionRegistry().getAction(ActionFactory.DELETE.getId());
		if (delAction.isEnabled())
			removeMenu.add(delAction);

		for (SelectionAction action : removeActions) {
			action.setSelectionProvider(provider);
			action.update();
			if (action.isEnabled())
				removeMenu.add(action);
		}

		contextMenu.appendToGroup(GEFActionConstants.GROUP_EDIT, removeMenu);
	}

	private void fillValueAssistMenu(IMenuManager contextMenu, ISelectionProvider provider) {
		ISelection selection = provider.getSelection();
		IEntityPart selectedPart = (IEntityPart) ((StructuredSelection) selection).getFirstElement();
		MenuManager valueMenu = new MenuManager("Value Assist");

		fillValueAssistMenu(valueMenu, provider, UIUtils.getEditorKit(selectedPart));

		contextMenu.appendToGroup(GEFActionConstants.GROUP_EDIT, valueMenu);
	}

	public void fillValueAssistMenu(IMenuManager assistMenu, ISelectionProvider provider, IEditorKit editorKit) {
		IActionFactory actionFactory = getEditorKitActionFactory(editorKit);
		actionFactory.fillValueMenu(workbenchPart, assistMenu, provider);
	}

	public void fillEntityAssistMenu(IMenuManager assistMenu, ISelectionProvider provider, IEditorKit editorKit) {
		ISelection selection = provider.getSelection();
		IEntityPart selectedPart = (IEntityPart) ((StructuredSelection) selection).getFirstElement();
		IEntity selectedEntity = ((IEntity) selectedPart.getModel()).wGetAdaptee(false);

		EntityDescriptor<?> selectedEntityDescriptor = selectedEntity.wGetEntityDescriptor();
		EntityDescriptor<?> formalEntityDescriptor = EntityUtils.hasParent(selectedEntity) ?
				selectedEntity.wGetParent().wGetEntityDescriptor(selectedEntity) : null;
		EntityDescriptor<?> componentEntityDescriptor = EntityUtils.isComposite(selectedEntity) ?
				selectedEntityDescriptor.getEntityDescriptor(0) : null;
				
		ILanguageKit selectedLanguageKit = selectedEntityDescriptor.getLanguageKit();

		List<MenuManager> menus = new ArrayList<MenuManager>();

		IResourceRegistry<ILanguageKit> registry = ReflectionFactory.getLanguageKitRegistry();
		for (ILanguageKit languageKit : registry.getResources(false, ResourceUtils.SIMPLE_COMPARATOR)) {
			if (languageKit.equals(selectedLanguageKit))
				continue;

			MenuManager languageMenu = new MenuManager(
					ResourceUtils.SIMPLE_NAME_PROVIDER.toString(registry, languageKit),
					AbstractLazySelectionAction.SELECT_LANGUAGE_ICON, null);
			if (fillEntityAssistMenu(
					languageMenu, provider, editorKit,
					selectedPart, selectedEntity, selectedEntityDescriptor,
					formalEntityDescriptor, componentEntityDescriptor,
					languageKit))
				menus.add(languageMenu);
		}
		fillLanguageMenuStrategy
				.fillMenu(assistMenu, menus.toArray(new MenuManager[menus.size()]), 0, menus.size());

		assistMenu.add(new Separator());

		boolean hasAddReplaceWrapActions = fillEntityAssistMenu(
				assistMenu, provider, editorKit,
				selectedPart, selectedEntity, selectedEntityDescriptor,
				formalEntityDescriptor, componentEntityDescriptor,
				selectedLanguageKit);

		int textActionsNumber = 0;
		List<SelectionAction> textActions = new ArrayList<SelectionAction>();
		for (EntityDescriptor<?> textEntityDescriptor : getTextEntityDescriptors(editorKit)) {
			if (
					!textEntityDescriptor.isAbstract() &&
					selectedEntityDescriptor.equals(textEntityDescriptor)
					) {
				List<SelectionAction> actions = getTextActions(editorKit, textEntityDescriptor);
				for (SelectionAction action : actions) {
					action.setSelectionProvider(provider);
					action.update();
					if (action.isEnabled())
						textActions.add(action);
				}
			}
		}
		textActionsNumber = textActions.size();
		if (textActionsNumber > 0 && hasAddReplaceWrapActions)
			assistMenu.add(new Separator());
		Collections.sort(textActions, selectionActionComparator);
		fillEntityAssistMenuStrategy.fillMenu(assistMenu, textActions.toArray(new IAction[0]), 0, textActionsNumber);
	}

	public boolean fillEntityAssistMenu(IMenuManager assistMenu,
			ISelectionProvider provider, IEditorKit editorKit,
			IEntityPart selectedPart, IEntity selectedEntity, EntityDescriptor<?> selectedEntityDescriptor,
			EntityDescriptor<?> formalEntityDescriptor, EntityDescriptor<?> componentEntityDescriptor,
			ILanguageKit languageKit) {

		IEditorKit languageEditorKit = languageKit.getDefaultEditorKit();
		if (editorKit.isGeneric())
			editorKit = languageEditorKit;
		else if (editorKit.canApply(languageKit))
			languageEditorKit = editorKit;
		
		boolean hasAddReplaceWrapActions = false;
		
		int addActionsNumber = 0;
		if (componentEntityDescriptor != null) {
			List<SelectionAction> addActions = new ArrayList<SelectionAction>();
			for (EntityDescriptor<?> addEntityDescriptor : languageKit.getEntityDescriptorEnum()
					.getExtendedLanguageConcreteSubtypesOf(componentEntityDescriptor)) {
				SelectionAction action = getAddAction(languageEditorKit, addEntityDescriptor);
				action.setSelectionProvider(provider);
				action.update();
				if (action.isEnabled())
					addActions.add(action);
			}
			addActionsNumber = addActions.size();
			Collections.sort(addActions, selectionActionComparator);
			fillEntityAssistMenuStrategy.fillMenu(assistMenu, addActions.toArray(new IAction[0]), 0, addActionsNumber);

			hasAddReplaceWrapActions |= addActionsNumber > 0;
		}

		int replaceActionsNumber = 0;
		if (formalEntityDescriptor != null) {
			List<SelectionAction> replaceActions = new ArrayList<SelectionAction>();
			for (EntityDescriptor<?> replaceEntityDescriptor : languageKit.getEntityDescriptorEnum()
					.getExtendedLanguageConcreteSubtypesOf(formalEntityDescriptor))
				if (!replaceEntityDescriptor.equals(selectedEntityDescriptor)) {
					SelectionAction action = getReplaceAction(languageEditorKit, replaceEntityDescriptor);
					action.setSelectionProvider(provider);
					action.update();
					if (action.isEnabled())
						replaceActions.add(action);
				}
			replaceActionsNumber = replaceActions.size();
			if (addActionsNumber > 0 && replaceActionsNumber > 0)
				assistMenu.add(new Separator());
			Collections.sort(replaceActions, selectionActionComparator);
			fillEntityAssistMenuStrategy.fillMenu(assistMenu, replaceActions.toArray(new IAction[0]), 0, replaceActionsNumber);
		
			hasAddReplaceWrapActions |= replaceActionsNumber > 0;
		}

		int wrapActionsNumber = 0;
		if (formalEntityDescriptor != null) {
			List<SelectionAction> wrapActions = new ArrayList<SelectionAction>();
			for (EntityDescriptor<?> wrapEntityDescriptor : languageKit.getEntityDescriptorEnum()
					.getExtendedLanguageConcreteSubtypesOf(formalEntityDescriptor)) {
				{
					List<? extends SelectionAction> actions = getWrapActions(languageEditorKit, wrapEntityDescriptor);
					for (SelectionAction action : actions) {
						action.setSelectionProvider(provider);
						action.update();
						if (action.isEnabled())
							wrapActions.add(action);
					}
				}
			}
			wrapActionsNumber = wrapActions.size();
			if (wrapActionsNumber > 0 && hasAddReplaceWrapActions)
				assistMenu.add(new Separator());
			Collections.sort(wrapActions, selectionActionComparator);
			fillEntityAssistMenuStrategy.fillMenu(assistMenu, wrapActions.toArray(new IAction[0]), 0, wrapActionsNumber);
		
			hasAddReplaceWrapActions |= wrapActionsNumber > 0;
		}

		return hasAddReplaceWrapActions;//replaceActionsNumber > 0 || addActionsNumber > 0;
	}

	@SuppressWarnings("unchecked")
	private void fillFeatureAssistMenu(IMenuManager contextMenu,
			ISelectionProvider provider, IEditorKit editorKit) {
		MenuManager featureAssistMenu = new MenuManager("Feature Assist");

		IEntityPart selectedPart = (IEntityPart) getSelectedObjects(provider).get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		Map<IEntity, IEntityPart> registry = selectedPart.getViewer().getEditPartRegistry();
		MenuManager[] featureMenuItems = new MenuManager[selectedEntity.wSize()];

		for (int c = 0; c < selectedEntity.wSize(); c++) {
			IEntity child = selectedEntity.wGet(c);
			FeatureDescriptor descriptor = selectedEntity.wGetFeatureDescriptor(c);
			featureMenuItems[c] = new MenuManager(descriptor.getName()) {
				//TODO workaround
				@Override
				public boolean isVisible() {
					boolean removeAll = getRemoveAllWhenShown();
					setRemoveAllWhenShown(false);
					boolean isVisible = super.isVisible();
					setRemoveAllWhenShown(removeAll);
					return isVisible;
				}
			};
			IEntityPart featurePart = ModelObserver.getObserver(child, registry);
			assert featurePart != null;

			// the feature has no edit part
			if (featurePart == selectedPart) {
				featurePart = EntityUtils.isComposite(child) ? new CompositeColumnPart() : new PlaceHolderPart();
				featurePart.setModel(child);
			}

			ISelectionProvider immutableProvider = new ImmutableSelectionProvider(featurePart);
			EntityAssistMenuListener featureAssistMenuListener = new EntityAssistMenuListener();
			featureAssistMenuListener.setEditorKit(editorKit);
			featureAssistMenuListener.setProvider(immutableProvider);
			featureMenuItems[c].addMenuListener(featureAssistMenuListener);
			featureMenuItems[c].setRemoveAllWhenShown(true);
			fillEntityAssistMenu(featureMenuItems[c], immutableProvider, editorKit);
		}

		Arrays.sort(featureMenuItems, new Comparator<MenuManager>() {
			public int compare(MenuManager o1, MenuManager o2) {
				return o1.getMenuText().compareToIgnoreCase(o2.getMenuText());
			}
		});

		for (MenuManager featureMenuItem : featureMenuItems)
			featureAssistMenu.add(featureMenuItem);

		contextMenu.appendToGroup(GEFActionConstants.GROUP_EDIT,
				featureAssistMenu);
	}

	private void fillNotationMenu(IMenuManager contextMenu,
			ISelectionProvider provider) {
		MenuManager notationMenu = new MenuManager("Notation");

		IEntityPart selectedPart = (IEntityPart) getSelectedObjects(provider).get(0);
		IEntity selectedEntity = selectedPart.getModelEntity();
		IEditorKit selectedEditorKit = selectedEntity.wGetEditorKit();
		for (IEditorKit editorKit : selectedEntity.wGetLanguageKit().getEditorKits()) {
			SelectEditorKitAction action = (SelectEditorKitAction) getActionRegistry().getAction(editorKit.getId());
			if (action != null) {
				action.setChecked(editorKit == selectedEditorKit);
				action.setSelectionProvider(provider);
				action.update();
				notationMenu.add(action);
			}
		}
		contextMenu.appendToGroup(GEFActionConstants.GROUP_REST, notationMenu);
	}

	public static List<?> getSelectedObjects(ISelectionProvider provider) {
		if (!(provider.getSelection() instanceof IStructuredSelection))
			return Collections.EMPTY_LIST;
		return ((IStructuredSelection) provider.getSelection()).toList();
	}

	public static void addSelectionActions(IWorkbenchPart workbenchPart,
			WholeActionFactory actionFactory) {
		addSelectionActions(workbenchPart, actionFactory, actionFactory
				.getActionRegistry(), new ArrayList<String>());
	}

	public static void addSelectionActions(IWorkbenchPart workbenchPart,
			WholeActionFactory actionFactory, ActionRegistry registry,
			List<String> selectionActions) {
		IAction action;

		// TODO remove this action when fixed in GEF
		action = new DeleteAction(workbenchPart);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		// can be called through keyevents or popup menus
		DirectEditAction directEditAction = new DirectEditAction(workbenchPart);
		directEditAction.setDirectEditRequest(new DirectEditRequest());
		registry.registerAction(directEditAction);
		selectionActions.add(directEditAction.getId());

		action = new AlignmentAction(workbenchPart, PositionConstants.LEFT);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new AlignmentAction(workbenchPart, PositionConstants.RIGHT);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new AlignmentAction(workbenchPart, PositionConstants.TOP);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new AlignmentAction(workbenchPart, PositionConstants.BOTTOM);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new AlignmentAction(workbenchPart, PositionConstants.CENTER);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new AlignmentAction(workbenchPart, PositionConstants.MIDDLE);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new MatchWidthAction(workbenchPart);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new MatchHeightAction(workbenchPart);
		registry.registerAction(action);
		selectionActions.add(action.getId());

		action = new ContentAssistAction(workbenchPart);
		registry.registerAction(action);
		selectionActions.add(action.getId());
		
		actionFactory.createActions(workbenchPart, selectionActions, registry);
	}

	protected class EntityAssistMenuListener implements IMenuListener {
		private ISelectionProvider provider;
		private IEditorKit editorKit;

		public void menuAboutToShow(IMenuManager manager) {
			fillEntityAssistMenu(manager, provider, editorKit);
		}

		public IEditorKit getEditorKit() {
			return editorKit;
		}

		public void setEditorKit(IEditorKit editorKit) {
			this.editorKit = editorKit;
		}

		public ISelectionProvider getProvider() {
			return provider;
		}

		public void setProvider(ISelectionProvider provider) {
			this.provider = provider;
		}
	}
}
