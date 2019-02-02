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

import org.whole.lang.tests.model.*;

/**
 *  @generator Whole
 */
public class TestsForwardStagedVisitor extends TestsIdentityVisitor {

    public void visit(TestSuite entity) {
        stagedVisit(entity);
    }

    public void visit(FilterFamilies entity) {
        stagedVisit(entity);
    }

    public void visit(FilterFamily entity) {
        stagedVisit(entity);
    }

    public void visit(FilterRules entity) {
        stagedVisit(entity);
    }

    public void visit(FilterRule entity) {
        stagedVisit(entity);
    }

    public void visit(TestCases entity) {
        stagedVisit(entity);
    }

    public void visit(TestCase entity) {
        stagedVisit(entity);
    }

    public void visit(Aspects entity) {
        stagedVisit(entity);
    }

    public void visit(BeforeTestCase entity) {
        stagedVisit(entity);
    }

    public void visit(AfterTestCase entity) {
        stagedVisit(entity);
    }

    public void visit(BeforeTest entity) {
        stagedVisit(entity);
    }

    public void visit(AfterTest entity) {
        stagedVisit(entity);
    }

    public void visit(Tests entity) {
        stagedVisit(entity);
    }

    public void visit(Test entity) {
        stagedVisit(entity);
    }

    public void visit(TestStatements entity) {
        stagedVisit(entity);
    }

    public void visit(Comment entity) {
        stagedVisit(entity);
    }

    public void visit(CommentKind entity) {
        stagedVisit(entity);
    }

    public void visit(UsingFilter entity) {
        stagedVisit(entity);
    }

    public void visit(AssertThat entity) {
        stagedVisit(entity);
    }

    public void visit(AssumeThat entity) {
        stagedVisit(entity);
    }

    public void visit(Filter entity) {
        stagedVisit(entity);
    }

    public void visit(IsNull entity) {
        stagedVisit(entity);
    }

    public void visit(IsTrue entity) {
        stagedVisit(entity);
    }

    public void visit(IsFalse entity) {
        stagedVisit(entity);
    }

    public void visit(IsDef entity) {
        stagedVisit(entity);
    }

    public void visit(IsUndef entity) {
        stagedVisit(entity);
    }

    public void visit(HasKind entity) {
        stagedVisit(entity);
    }

    public void visit(Kind entity) {
        stagedVisit(entity);
    }

    public void visit(IsAssignableTo entity) {
        stagedVisit(entity);
    }

    public void visit(HasType entity) {
        stagedVisit(entity);
    }

    public void visit(Throws entity) {
        stagedVisit(entity);
    }

    public void visit(ThrowableType entity) {
        stagedVisit(entity);
    }

    public void visit(Same entity) {
        stagedVisit(entity);
    }

    public void visit(Equals entity) {
        stagedVisit(entity);
    }

    public void visit(Matches entity) {
        stagedVisit(entity);
    }

    public void visit(Not entity) {
        stagedVisit(entity);
    }

    public void visit(AllOf entity) {
        stagedVisit(entity);
    }

    public void visit(AnyOf entity) {
        stagedVisit(entity);
    }

    public void visit(Results entity) {
        stagedVisit(entity);
    }

    public void visit(Result entity) {
        stagedVisit(entity);
    }

    public void visit(Outcome entity) {
        stagedVisit(entity);
    }

    public void visit(BooleanLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(IntLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(DataName entity) {
        stagedVisit(entity);
    }

    public void visit(Sequence entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(PackageName entity) {
        stagedVisit(entity);
    }

    public void visit(Description entity) {
        stagedVisit(entity);
    }
}
