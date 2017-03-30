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
package org.whole.lang.tests.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TestsForwardStrategyVisitor extends GenericForwardStrategyVisitor<ITestsVisitor> implements ITestsVisitor {

    public TestsForwardStrategyVisitor() {
        this(new TestsIdentityVisitor());
    }

    public TestsForwardStrategyVisitor(ITestsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((ITestsEntity) entity).accept(this);
    }

    public void visit(TestSuite entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FilterFamilies entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FilterFamily entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FilterRules entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FilterRule entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TestCases entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TestCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Aspects entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BeforeTestCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AfterTestCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BeforeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AfterTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Tests entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Test entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TestStatements entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Comment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CommentKind entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UsingFilter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssertThat entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssumeThat entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Filter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsNull entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsTrue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsFalse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsDef entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsUndef entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HasKind entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Kind entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsAssignableTo entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HasType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Throws entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ThrowableType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Same entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Equals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Matches entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Not entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AllOf entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnyOf entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Results entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Result entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Outcome entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DataName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Sequence entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PackageName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Description entity) {
        wGetStrategy().visit(entity);
    }
}
