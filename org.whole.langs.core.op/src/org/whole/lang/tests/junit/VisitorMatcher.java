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
package org.whole.lang.tests.junit;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.IVisitor;

/**
 * @author Enrico Persiani
 */
public class VisitorMatcher extends TypeSafeMatcher<IEntity> {
	private final IVisitor visitor;

	public VisitorMatcher(IVisitor visitor) {
		this.visitor = visitor;
	}

	@Override
	public boolean matchesSafely(IEntity entity) {
		return org.whole.lang.matchers.Matcher.match(visitor, entity);
	}

	public void describeTo(Description description) {
		description.appendText(visitor.toString());
	}
}