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
package org.whole.lang.e4.ui.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.whole.lang.actions.model.GuardedAction;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.model.URI;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.reflect.ActionsFeatureDescriptorEnum;
import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractCompositeContributionItem;
import org.whole.lang.e4.ui.actions.IContextProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.resources.IResource;
import org.whole.lang.resources.IResourceRegistry;
import org.whole.lang.resources.Resource;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.menu.ActionSet;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public class ActionsCompositeContributionItem extends AbstractCompositeContributionItem {
	protected FeatureDescriptor menu;

	public ActionsCompositeContributionItem(IContextProvider contextProvider, FeatureDescriptor menu) {
		super(contextProvider);
		this.menu = menu;
	}

	@Override
	protected IContributionItem[] getItems() {

		Object selection = contextProvider.getContext().get(ESelectionService.class).getSelection();
		if (!(selection instanceof IBindingManager) || !((IBindingManager) selection).wIsSet("self"))
			return new IContributionItem[0];

		IBindingManager bm = (IBindingManager) selection;
		String languageURI = bm.wGet("self").wGetLanguageKit().getURI();

		Map<GuardedAction, String> actionsMap = new HashMap<GuardedAction, String>();
		IResourceRegistry<Resource> registry = ActionsRegistry.instance();
		for (IResource resource : registry.getResources(false)) {
			LanguageActionFactory actionsModule = resource.getEntity();
			URI targetLanguage = actionsModule.getTargetLanguage();
			if (DataTypeUtils.getDataKind(targetLanguage).isString() &&
					!languageURI.equals(targetLanguage.getValue()))
				continue;

			for (GuardedAction guardedAction : Matcher.findAll(
					ActionsEntityDescriptorEnum.GuardedAction, getActions(actionsModule), false)) {
				String actionName = guardedAction.getName().getValue();
				String functionUri = resource.getURI()+'#'+actionName;
				actionsMap.put(guardedAction, functionUri);
			}
		}

		List<IAction> actions = new ArrayList<IAction>();
		List<GuardedAction> guardedActions = new ArrayList<GuardedAction>(actionsMap.keySet());
		Collections.sort(guardedActions, new Comparator<GuardedAction>() {
			public int compare(GuardedAction a1, GuardedAction a2) {
				return a1.getName().getValue().compareTo(a2.getName().getValue());
			}
		});

		for (GuardedAction guardedAction : guardedActions) {
			String actionName = guardedAction.getName().getValue();
			String functionUri = actionsMap.get(guardedAction);
			IUpdatableAction action = contextProvider.getActionRegistry().getActionFactory().createActionCallAction(
					actionName, isAnalyze(), guardedAction.getEnablerPredicate(), functionUri);
			action.update();
			actions.add(action);
		}

		List<IContributionItem> items = new ArrayList<IContributionItem>();
		HierarchicalFillMenuStrategy.instance().fillMenu(
				ActionListContainer.create(items),
						ActionSet.create(actions.toArray(new IAction[actions.size()])), 0, actions.size());

		return items.toArray(new IContributionItem[items.size()]);
	}

	protected IEntity getActions(LanguageActionFactory actionsModule) {
		return actionsModule.getContextMenuActions().wGet(menu);
	}
	
	protected boolean isAnalyze() {
		return ActionsFeatureDescriptorEnum.analyzeMenuActions.equals(menu);
	}
}
