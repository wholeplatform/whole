/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.tests.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class TestsAdaptersEntityRegistry extends AbstractEntityRegistry {

    public TestsAdaptersEntityRegistry() {
        super(TestsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new TestSuiteAdapter());
        put(new FilterFamiliesAdapter());
        put(new FilterFamilyAdapter());
        put(new FilterRulesAdapter());
        put(new FilterRuleAdapter());
        put(new TestCasesAdapter());
        put(new TestCaseAdapter());
        put(new AbstractBehaviorAdapter());
        put(new AspectsAdapter());
        put(new AspectAdapter());
        put(new BeforeTestCaseAdapter());
        put(new AfterTestCaseAdapter());
        put(new BeforeTestAdapter());
        put(new AfterTestAdapter());
        put(new TestsAdapter());
        put(new TestAdapter());
        put(new TestStatementsAdapter());
        put(new TestStatementAdapter());
        put(new StatementAdapter());
        put(new CommentAdapter());
        put(new CommentKindAdapter());
        put(new UsingFilterAdapter());
        put(new SubjectStatementAdapter());
        put(new AssertThatAdapter());
        put(new AssumeThatAdapter());
        put(new FilterAdapter());
        put(new ConstraintAdapter());
        put(new IsNullAdapter());
        put(new IsTrueAdapter());
        put(new IsFalseAdapter());
        put(new IsDefAdapter());
        put(new IsUndefAdapter());
        put(new HasKindAdapter());
        put(new KindAdapter());
        put(new IsAssignableToAdapter());
        put(new HasTypeAdapter());
        put(new ThrowsAdapter());
        put(new ThrowableTypeAdapter());
        put(new ObjectConstraintAdapter());
        put(new SameAdapter());
        put(new EqualsAdapter());
        put(new MatchesAdapter());
        put(new DecoratorConstraintAdapter());
        put(new NotAdapter());
        put(new AllOfAdapter());
        put(new AnyOfAdapter());
        put(new ResultsAdapter());
        put(new ResultAdapter());
        put(new OutcomeAdapter());
        put(new ExpressionAdapter());
        put(new BooleanLiteralAdapter());
        put(new IntLiteralAdapter());
        put(new StringLiteralAdapter());
        put(new DataNameAdapter());
        put(new SequenceAdapter());
        put(new NameAdapter());
        put(new PackageNameAdapter());
        put(new DescriptionAdapter());
    }
}
