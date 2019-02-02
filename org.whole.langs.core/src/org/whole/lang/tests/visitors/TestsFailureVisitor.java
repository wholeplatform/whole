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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class TestsFailureVisitor extends TestsIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(TestSuite entity) {
        throw new VisitException();
    }

    public void visit(FilterFamilies entity) {
        throw new VisitException();
    }

    public void visit(FilterFamily entity) {
        throw new VisitException();
    }

    public void visit(FilterRules entity) {
        throw new VisitException();
    }

    public void visit(FilterRule entity) {
        throw new VisitException();
    }

    public void visit(TestCases entity) {
        throw new VisitException();
    }

    public void visit(TestCase entity) {
        throw new VisitException();
    }

    public void visit(Aspects entity) {
        throw new VisitException();
    }

    public void visit(BeforeTestCase entity) {
        throw new VisitException();
    }

    public void visit(AfterTestCase entity) {
        throw new VisitException();
    }

    public void visit(BeforeTest entity) {
        throw new VisitException();
    }

    public void visit(AfterTest entity) {
        throw new VisitException();
    }

    public void visit(Tests entity) {
        throw new VisitException();
    }

    public void visit(Test entity) {
        throw new VisitException();
    }

    public void visit(TestStatements entity) {
        throw new VisitException();
    }

    public void visit(Comment entity) {
        throw new VisitException();
    }

    public void visit(CommentKind entity) {
        throw new VisitException();
    }

    public void visit(UsingFilter entity) {
        throw new VisitException();
    }

    public void visit(AssertThat entity) {
        throw new VisitException();
    }

    public void visit(AssumeThat entity) {
        throw new VisitException();
    }

    public void visit(Filter entity) {
        throw new VisitException();
    }

    public void visit(IsNull entity) {
        throw new VisitException();
    }

    public void visit(IsTrue entity) {
        throw new VisitException();
    }

    public void visit(IsFalse entity) {
        throw new VisitException();
    }

    public void visit(IsDef entity) {
        throw new VisitException();
    }

    public void visit(IsUndef entity) {
        throw new VisitException();
    }

    public void visit(HasKind entity) {
        throw new VisitException();
    }

    public void visit(Kind entity) {
        throw new VisitException();
    }

    public void visit(IsAssignableTo entity) {
        throw new VisitException();
    }

    public void visit(HasType entity) {
        throw new VisitException();
    }

    public void visit(Throws entity) {
        throw new VisitException();
    }

    public void visit(ThrowableType entity) {
        throw new VisitException();
    }

    public void visit(Same entity) {
        throw new VisitException();
    }

    public void visit(Equals entity) {
        throw new VisitException();
    }

    public void visit(Matches entity) {
        throw new VisitException();
    }

    public void visit(Not entity) {
        throw new VisitException();
    }

    public void visit(AllOf entity) {
        throw new VisitException();
    }

    public void visit(AnyOf entity) {
        throw new VisitException();
    }

    public void visit(Results entity) {
        throw new VisitException();
    }

    public void visit(Result entity) {
        throw new VisitException();
    }

    public void visit(Outcome entity) {
        throw new VisitException();
    }

    public void visit(BooleanLiteral entity) {
        throw new VisitException();
    }

    public void visit(IntLiteral entity) {
        throw new VisitException();
    }

    public void visit(StringLiteral entity) {
        throw new VisitException();
    }

    public void visit(DataName entity) {
        throw new VisitException();
    }

    public void visit(Sequence entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(PackageName entity) {
        throw new VisitException();
    }

    public void visit(Description entity) {
        throw new VisitException();
    }
}
