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
package org.whole.lang.tests.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.ContentAssistOperation;
import org.whole.lang.tests.factories.TestsEntityFactory;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.util.TestsHelpers;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class TestsContentAssistVisitor extends TestsIdentityVisitor {
	public ContentAssistOperation getOperation() {
		return (ContentAssistOperation) super.getOperation();
	}
	protected void setResult(Name[] md) {
		getOperation().setResult(md);
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		findContentAssistValues(entity);
		return false;
	}

	@Override
	public void visit(Name entity) {
		findContentAssistValues(entity);
	}

	protected boolean findContentAssistValues(IEntity entity) {
		if (!Matcher.match(TestsEntityDescriptorEnum.Name, entity) ||
				!EntityUtils.hasParent(entity) || 
				!Matcher.match(TestsEntityDescriptorEnum.Filter, entity.wGetParent()))
			return false;

		TestSuite testSuite = Matcher.findAncestor(TestsEntityDescriptorEnum.TestSuite, entity);
		if (testSuite == null)
			return false;

		Map<String, FilterRule> rulesMap = TestsHelpers.createFilterRulesMap(testSuite);
		List<Name> names = new ArrayList<Name>();
		for (String key : rulesMap.keySet())
			names.add(TestsEntityFactory.instance.createName(key));
		setResult(names.toArray(new Name[names.size()]));
		return true;
	}
}
