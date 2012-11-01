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
package org.whole.lang.ui.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.WholePlugin;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.actions.CompositeAddAction;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.actions.EnsurePanningToolActiveAction;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.actions.RemoveTextualSelectionAction;
import org.whole.lang.ui.actions.ReplaceChildAction;
import org.whole.lang.ui.actions.TextualAction;
import org.whole.lang.ui.actions.WrapChildAction;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.menu.FlatFillMenuStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.DefaultCopyTransformer;
import org.whole.lang.util.DefaultWrapInTransformer;
import org.whole.lang.util.DefaultWrapWithinTransformer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.IEntityTransformer;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class ActionFactory implements IActionFactory {
	private static class SingletonHolder {
		private static final IActionFactory instance = new ActionFactory();
	}
	public static IActionFactory instance() {
		return SingletonHolder.instance;
	}

	protected final IEntityTransformer fresh = new IEntityTransformer() {
		public void transform(IEntity oldEntity, IEntity newEntity) {
		}
	};
	protected final IEntityTransformer fragment = new IEntityTransformer() {
		public void transform(IEntity oldEntity, IEntity newEntity) {
			if (EntityUtils.isFragment(oldEntity))
				oldEntity = oldEntity.wGetRoot();
			newEntity.wSet(newEntity.wGetRoot(), EntityUtils.clone(oldEntity));
		}
	};
	protected final IEntityTransformer copy = DefaultCopyTransformer.instance;
	protected final IEntityTransformer wrapIn0 = DefaultWrapInTransformer.instance;
	protected final IEntityTransformer wrapWithin = DefaultWrapWithinTransformer.instance;
	protected final IEntityTransformer wrapIn(FeatureDescriptor featureDescriptor) {
		return new DefaultWrapInTransformer(featureDescriptor);
	}
	protected final IEntityTransformer wrapIn(int index) {
		return new DefaultWrapInTransformer(index);
	}
	protected final IEntityTransformer wrapWithin(FeatureDescriptor featureDescriptor) {
		return new DefaultWrapWithinTransformer(featureDescriptor);
	}
	protected final IEntityTransformer wrapWithin(FeatureDescriptor featureDescriptor, boolean append) {
		return new DefaultWrapWithinTransformer(featureDescriptor, append);
	}
	protected final IEntityTransformer wrapWithin(FeatureDescriptor featureDescriptor, boolean append, boolean replace) {
		return new DefaultWrapWithinTransformer(featureDescriptor, append, replace);
	}

	public void initActions(IWorkbenchPart workbenchPart) { }

	public void initAddActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, SelectionAction> addActionsMap) {
		for (Object[] addAction : addActions()) {
			EntityDescriptor<?> entityDescriptor = (EntityDescriptor<?>) addAction[1];
			if (!EnablerPredicateFactory.isHidden(entityDescriptor)) {
				IEnablerPredicate enablerPredicate = (IEnablerPredicate) addAction[0];
				String actionName = (String) addAction[2];
				CompositeAddAction action = new CompositeAddAction(workbenchPart,
						enablerPredicate, entityDescriptor,
						toPresentationName(actionName));
				addActionsMap.put(entityDescriptor, action);
				actionRegistry.registerAction(action);
			}
		}
	}

	public void initReplaceActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, SelectionAction> replaceActionsMap) {
		for (Object[] replaceAction : replaceActions()) {
			EntityDescriptor<?> entityDescriptor = (EntityDescriptor<?>) replaceAction[1];
			if (!EnablerPredicateFactory.isHidden(entityDescriptor)) {
				IEnablerPredicate enablerPredicate = (IEnablerPredicate) replaceAction[0];
				String actionName = (String) replaceAction[2];
				IEntityTransformer entityTransformer = (IEntityTransformer)  replaceAction[3];
				ReplaceChildAction action = new ReplaceChildAction(workbenchPart, 
						enablerPredicate, entityDescriptor, toPresentationName(actionName),
						entityTransformer);
				replaceActionsMap.put(entityDescriptor, action);
				actionRegistry.registerAction(action);
			}
		}
	}

	public void initWrapActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, List<SelectionAction>> wrapActionsMap) {
		for (Object[] wrapAction : wrapActions()) {
			EntityDescriptor<?> entityDescriptor = (EntityDescriptor<?>) wrapAction[1];
//			if (!EnablerPredicateFactory.isHidden(entityDescriptor)) {
				IEnablerPredicate enablerPredicate = (IEnablerPredicate) wrapAction[0];
				String actionName = (String) wrapAction[2];
				IEntityTransformer entityTransformer = (IEntityTransformer) wrapAction[3];
				WrapChildAction action = new WrapChildAction(workbenchPart, enablerPredicate, entityTransformer, entityDescriptor,
						toPresentationName(actionName));

				List<SelectionAction> list = wrapActionsMap.get(entityDescriptor);
				if (list == null)
					wrapActionsMap.put(entityDescriptor, list = new ArrayList<SelectionAction>());

				list.add(action);
				actionRegistry.registerAction(action);
//			}
		}
	}

	@SuppressWarnings("unchecked")
	public void initTextActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<EntityDescriptor<?>, List<SelectionAction>> textActionsMap) {
		Object[][] textActionList = textActions();
		for (Object[] textAction : textActionList) {
			EntityDescriptor<?> entityDescriptor = (EntityDescriptor<?>) textAction[1];
			if (!EnablerPredicateFactory.isHidden(entityDescriptor)) {
				IEnablerPredicate enablerPredicate = (IEnablerPredicate) textAction[0];
				String actionName = (String) textAction[2];
				Class<? extends TextualAction> actionClass = (Class<? extends TextualAction>) textAction[3];
				try {
					Object[] constructorParams = new Object[] {
							workbenchPart, enablerPredicate,
							entityDescriptor, actionName
					};
					TextualAction action = actionClass.getConstructor(CONSTRUCTOR_TYPES).newInstance(constructorParams);

					List<SelectionAction> list = textActionsMap.get(entityDescriptor);
					if (list == null)
						textActionsMap.put(entityDescriptor, list = new ArrayList<SelectionAction>());

					list.add(action);
					actionRegistry.registerAction(action);
				} catch (Exception e) {
					WholePlugin.log(e);
				}
			}
		}
	}

	public void initKeyActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<KeyStroke, SelectionAction> keyActionsMap) {
		SelectionAction action = getEnsurePanningToolActiveAction(workbenchPart, actionRegistry);
		keyActionsMap.put(KeyStroke.getPressed(SWT.CR, 13, SWT.NONE), action);
		keyActionsMap.put(KeyStroke.getPressed(SWT.LF, 10, SWT.NONE), action);
		keyActionsMap.put(KeyStroke.getPressed(SWT.ESC, 27, SWT.NONE), action);
		
		action = getRemoveTextualSelectionAction(workbenchPart, actionRegistry, SWT.LEFT);
		keyActionsMap.put(KeyStroke.getPressed(SWT.ARROW_LEFT, SWT.NONE), action);

		action = getRemoveTextualSelectionAction(workbenchPart, actionRegistry, SWT.RIGHT);
		keyActionsMap.put(KeyStroke.getPressed(SWT.ARROW_RIGHT, SWT.NONE), action);
	}
	protected SelectionAction getEnsurePanningToolActiveAction(IWorkbenchPart part, ActionRegistry actionRegistry) {
		SelectionAction action = (SelectionAction) actionRegistry.getAction(EnsurePanningToolActiveAction.ID);
		if (action == null)
			actionRegistry.registerAction(action = new EnsurePanningToolActiveAction(part));
		return action;
	}
	protected SelectionAction getRemoveTextualSelectionAction(IWorkbenchPart part, ActionRegistry actionRegistry, int direction) {
		SelectionAction action = (SelectionAction) actionRegistry.getAction(RemoveTextualSelectionAction.calculateId(direction));
		if (action == null)
			actionRegistry.registerAction(action = new RemoveTextualSelectionAction(part, direction));
		return action;
	}

	protected static final Class<?>[] CONSTRUCTOR_TYPES = new Class<?>[] {
		IWorkbenchPart.class, IEnablerPredicate.class,
		EntityDescriptor.class, String.class
	};

	protected Object[][] addActions() { return new Object[0][0]; }
	protected Object[][] replaceActions() { return new Object[0][0]; }
	protected Object[][] wrapActions() { return new Object[0][0]; }
	protected Object[][] textActions() { return new Object[0][0]; }

	public void fillValueMenu(IWorkbenchPart workbenchPart, IMenuManager contextMenu, ISelectionProvider provider) {
		final ISelection selection = provider != null ? provider.getSelection() : workbenchPart.getSite().getSelectionProvider().getSelection();
		final IEntityPart selectedPart = (IEntityPart) ((StructuredSelection) selection).getFirstElement();
		final IEntity selectedEntity = selectedPart.getModelEntity();

		IBindingManager args = BindingManagerFactory.instance.createArguments();
		if (workbenchPart instanceof IEditorPart) 
			ResourceUtils.defineResourceBindings(args, ((IEditorPart) workbenchPart).getEditorInput());
		//TODO ??? else [...]
		IEntity[] values = ContentAssistOperation.getContentAssist(selectedEntity, args);

		if (values.length == 1 && !EntityUtils.isData(values[0])) {
			IBindingManager bm = BindingManagerFactory.instance.createArguments();
			bm.wDefValue("workbenchPart", workbenchPart);
			bm.wDefValue("menuManager", contextMenu);
			bm.wDefValue("fillMenuStrategy", FlatFillMenuStrategy.instance());
			bm.wDefValue("selectionProvider", provider);
			InterpreterOperation.interpret(values[0], bm);
		} else if (values.length > 0)
			fillMenuWithValues(workbenchPart, contextMenu, provider, selectedEntity, values);
	}
	protected void fillMenuWithValues(IWorkbenchPart workbenchPart,
			IMenuManager contextMenu, ISelectionProvider provider,
			final IEntity selectedEntity, IEntity[] values) {
		IAction[] actions = new IAction[values.length];
		int actionsSize = 0;
		for (int i=0; i<values.length; i++) {
			IAction action = getAction(workbenchPart, selectedEntity, provider, values[i]);
			if (action != null && action.isEnabled())
				actions[actionsSize++] = action;
		}
		HierarchicalFillMenuStrategy.instance().fillMenu(contextMenu, actions, 0, actionsSize);
	}
	protected IAction getAction(IWorkbenchPart workbenchPart, IEntity selectedEntity,
			ISelectionProvider provider, IEntity value) {
		if (Matcher.match(value, selectedEntity))
			return null;

		ReplaceChildAction action = new ReplaceChildAction(
				workbenchPart, EnablerPredicateFactory.instance.replaceMode(),
				value, DataTypeUtils.getAsPresentationString(value),
				fresh);
		action.setSelectionProvider(provider);
		action.update();
		return action;
	}

	public SelectionAction createAddAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> addEntityDescriptor) {
		return new CompositeAddAction(workbenchPart, EnablerPredicateFactory.instance.alwaysTrue(),
				addEntityDescriptor, toPresentationName(addEntityDescriptor.getName()));
	}

	public SelectionAction createReplaceAction(IWorkbenchPart workbenchPart, EntityDescriptor<?> replaceEntityDescriptor) {
		return new ReplaceChildAction(workbenchPart, EnablerPredicateFactory.instance.alwaysTrue(), 
				replaceEntityDescriptor, toPresentationName(replaceEntityDescriptor.getName()),
				copy);
	}

	public List<? extends SelectionAction> createWrapActions(IWorkbenchPart workbenchPart, EntityDescriptor<?> wrapEntityDescriptor) {
		if (wrapEntityDescriptor.getEntityKind().isComposite())
			return Collections.singletonList(new WrapChildAction(workbenchPart,
					EnablerPredicateFactory.instance.assignableTo(wrapEntityDescriptor.getEntityDescriptor(0)),
					wrapIn0, wrapEntityDescriptor,
					toPresentationName(wrapEntityDescriptor.getName())));
		else
			return Collections.emptyList();
	}

	protected String toPresentationName(String name) {
		return StringUtils.camelCaseToSpacedWords(name);
	}
}
