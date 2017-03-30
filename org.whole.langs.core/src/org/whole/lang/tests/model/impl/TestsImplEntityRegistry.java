/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.tests.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class TestsImplEntityRegistry extends AbstractEntityRegistry {

    public TestsImplEntityRegistry() {
        super(TestsEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new TestSuiteImpl());
        put(new FilterFamiliesImpl());
        put(new FilterFamilyImpl());
        put(new FilterRulesImpl());
        put(new FilterRuleImpl());
        put(new TestCasesImpl());
        put(new TestCaseImpl());
        put(new AspectsImpl());
        put(new BeforeTestCaseImpl());
        put(new AfterTestCaseImpl());
        put(new BeforeTestImpl());
        put(new AfterTestImpl());
        put(new TestsImpl());
        put(new TestImpl());
        put(new TestStatementsImpl());
        put(new CommentImpl());
        put(new CommentKindImpl());
        put(new UsingFilterImpl());
        put(new AssertThatImpl());
        put(new AssumeThatImpl());
        put(new FilterImpl());
        put(new IsNullImpl());
        put(new IsTrueImpl());
        put(new IsFalseImpl());
        put(new IsDefImpl());
        put(new IsUndefImpl());
        put(new HasKindImpl());
        put(new KindImpl());
        put(new IsAssignableToImpl());
        put(new HasTypeImpl());
        put(new ThrowsImpl());
        put(new ThrowableTypeImpl());
        put(new SameImpl());
        put(new EqualsImpl());
        put(new MatchesImpl());
        put(new NotImpl());
        put(new AllOfImpl());
        put(new AnyOfImpl());
        put(new ResultsImpl());
        put(new ResultImpl());
        put(new OutcomeImpl());
        put(new BooleanLiteralImpl());
        put(new IntLiteralImpl());
        put(new StringLiteralImpl());
        put(new DataNameImpl());
        put(new SequenceImpl());
        put(new NameImpl());
        put(new PackageNameImpl());
        put(new DescriptionImpl());
    }
}
