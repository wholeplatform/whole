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
package org.whole.lang.tests.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TestsIdentityVisitor extends AbstractVisitor implements ITestsVisitor {

    public void visit(IEntity entity) {
        ((ITestsEntity) entity).accept(this);
    }

    public void visit(TestSuite entity) {
    }

    public void visit(FilterFamilies entity) {
    }

    public void visit(FilterFamily entity) {
    }

    public void visit(FilterRules entity) {
    }

    public void visit(FilterRule entity) {
    }

    public void visit(TestCases entity) {
    }

    public void visit(TestCase entity) {
    }

    public void visit(Aspects entity) {
    }

    public void visit(BeforeTestCase entity) {
    }

    public void visit(AfterTestCase entity) {
    }

    public void visit(BeforeTest entity) {
    }

    public void visit(AfterTest entity) {
    }

    public void visit(Tests entity) {
    }

    public void visit(Test entity) {
    }

    public void visit(TestStatements entity) {
    }

    public void visit(Comment entity) {
    }

    public void visit(CommentKind entity) {
    }

    public void visit(UsingFilter entity) {
    }

    public void visit(AssertThat entity) {
    }

    public void visit(AssumeThat entity) {
    }

    public void visit(Filter entity) {
    }

    public void visit(IsNull entity) {
    }

    public void visit(IsTrue entity) {
    }

    public void visit(IsFalse entity) {
    }

    public void visit(IsDef entity) {
    }

    public void visit(IsUndef entity) {
    }

    public void visit(HasKind entity) {
    }

    public void visit(Kind entity) {
    }

    public void visit(IsAssignableTo entity) {
    }

    public void visit(HasType entity) {
    }

    public void visit(Throws entity) {
    }

    public void visit(ThrowableType entity) {
    }

    public void visit(Same entity) {
    }

    public void visit(Equals entity) {
    }

    public void visit(Matches entity) {
    }

    public void visit(Not entity) {
    }

    public void visit(AllOf entity) {
    }

    public void visit(AnyOf entity) {
    }

    public void visit(Results entity) {
    }

    public void visit(Result entity) {
    }

    public void visit(Outcome entity) {
    }

    public void visit(BooleanLiteral entity) {
    }

    public void visit(IntLiteral entity) {
    }

    public void visit(StringLiteral entity) {
    }

    public void visit(DataName entity) {
    }

    public void visit(Sequence entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(PackageName entity) {
    }

    public void visit(Description entity) {
    }
}
