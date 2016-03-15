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
import java.util.List;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractCompositeContributionItem;
import org.whole.lang.e4.ui.actions.IContextProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.ui.actions.IUpdatableAction;
import org.whole.lang.ui.menu.ActionSet;
import org.whole.lang.ui.menu.FlatFillMenuStrategy;
import org.whole.lang.ui.menu.HierarchicalFillMenuStrategy;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ContentAssistCompositeContributionItem extends AbstractCompositeContributionItem {
	public ContentAssistCompositeContributionItem(IContextProvider contextProvider) {
		super(contextProvider);
	}

	protected IContributionItem[] getItems() {
		List<IContributionItem> items = new ArrayList<IContributionItem>();
		
		Object selection = contextProvider.getContext().get(ESelectionService.class).getSelection();
		if (!(selection instanceof IBindingManager))
			return new IContributionItem[0];

		IBindingManager bm = (IBindingManager) selection;

		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity[] values = ContentAssistOperation.getContentAssist(focusEntity, bm);

		ActionListContainer container = ActionListContainer.create(items);
		if (values.length == 1 && !EntityUtils.isData(values[0])) {
			try {
				bm.wEnterScope();
				bm.wDefValue("context", contextProvider.getContext());
				bm.wDefValue("itemContainer", container);
				bm.wDefValue("fillMenuStrategy", FlatFillMenuStrategy.instance());
				InterpreterOperation.interpret(values[0], bm);
			} finally {
				bm.wExitScope();
			}
		} else if (values.length > 0) {
			IAction[] actions = new IAction[values.length];
			int actionsSize = 0;
			for (int i=0; i<values.length; i++) {
				IEntity value = values[i];
				if (!Matcher.match(value, focusEntity)) {
					IUpdatableAction action = contextProvider.getActionRegistry().getActionFactory().createReplaceFragmentAction(DataTypeUtils.getAsPresentationString(value), BindingManagerFactory.instance.createSpecificValue(true), value);
					if (action.isEnabled())
						actions[actionsSize++] = action;
				}	
			}
			HierarchicalFillMenuStrategy.instance().fillMenu(container, ActionSet.create(actions), 0, actionsSize);
		}
		return items.toArray(new IContributionItem[items.size()]);
	}
}
