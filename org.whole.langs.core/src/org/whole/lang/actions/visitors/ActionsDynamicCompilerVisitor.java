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
package org.whole.lang.actions.visitors;

import org.whole.lang.actions.iterators.ActionCallIterator;
import org.whole.lang.actions.model.ActionCall;
import org.whole.lang.actions.model.GuardedAction;
import org.whole.lang.actions.model.IActionsEntity;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.model.SelectedEntities;
import org.whole.lang.actions.model.SimpleAction;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.resources.ActionsRegistry;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ActionsDynamicCompilerVisitor extends ActionsIdentityDefaultVisitor {
	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false), 0);
		return false;
	}

	@Override
	public void visit(IActionsEntity entity) {
		stagedDefaultVisit(entity, 0);
	}

    protected String actionsUri;
    protected String getActionsUri(IEntity entity) {
		if (actionsUri == null) {
			LanguageActionFactory laf = Matcher.findAncestor(ActionsEntityDescriptorEnum.LanguageActionFactory, entity);
			actionsUri = laf != null ? laf.getUri().getValue() : getBindings().wStringValue("actionsUri");
		}
		return actionsUri;
    }

    @Override
    public void visit(SimpleAction entity) {
    	stagedVisit(entity.getTransformation().wGetAdaptee(false));
    	IEntityIterator<?> functionBehavior = getResultIterator();

    	ActionsRegistry.instance().putFunctionCode(getActionsUri(entity)+"#"+entity.getName().getValue(), functionBehavior);
    }

    @Override
    public void visit(GuardedAction entity) {
    	//TODO add condition test
    	stagedVisit(entity.getTransformation().wGetAdaptee(false));
    	IEntityIterator<?> functionBehavior = getResultIterator();

    	ActionsRegistry.instance().putFunctionCode(getActionsUri(entity)+"#"+entity.getName().getValue(), functionBehavior);
    }

	@Override
	public void visit(ActionCall entity) {
    	SelectedEntities selectedEntitiesFeature = entity.getSelectedEntities();
    	IEntityIterator<?>[] argumentsIterators = null;
    	if (EntityUtils.isNotResolver(selectedEntitiesFeature)) {
			selectedEntitiesFeature.accept(this);
			IEntityIterator<?> resultIterator = getResultIterator();

        	argumentsIterators = new IEntityIterator<?>[1];
        	argumentsIterators[0] = resultIterator;
		}

    	setResultIterator(new ActionCallIterator(
    			entity.getName().getValue(), argumentsIterators).withSourceEntity(entity));
	}
}
