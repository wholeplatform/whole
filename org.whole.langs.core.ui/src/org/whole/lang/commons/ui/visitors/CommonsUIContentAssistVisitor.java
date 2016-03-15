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
package org.whole.lang.commons.ui.visitors;

import java.util.Collections;

import org.whole.lang.actions.factories.ActionsEntityFactory;
import org.whole.lang.actions.model.Action;
import org.whole.lang.actions.model.ActionKindEnum;
import org.whole.lang.actions.reflect.ActionsEntityDescriptorEnum;
import org.whole.lang.actions.ui.factories.ActionsUIEntityFactory;
import org.whole.lang.commons.model.VarName;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.CommonsContentAssistVisitor;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;

/**
 * @author Riccardo Solmi
 */
public class CommonsUIContentAssistVisitor extends CommonsContentAssistVisitor {
	protected boolean mergeResult(Action action) {
		IEntity[] result = getOperation().getResult();
		if (result == null || result.length == 0)
			result = new IEntity[] { ActionsEntityFactory.instance.createActions(0)};
		
		result[0].wAdd(Matcher.match(ActionsEntityDescriptorEnum.SubgroupAction, action) ? action :
			ActionsEntityFactory.instance.createSeparatedAction(action));

		getOperation().setResult(result);
		return true;
	}

	@Override
	public void visit(VarName entity) {
		mergeResult(ActionsUIEntityFactory.instance.createAllVariablesGroupAction(
				ActionKindEnum.REPLACE, Collections.<String>emptySet(),
				CommonsEntityDescriptorEnum.VarName, entity));
	}
}
