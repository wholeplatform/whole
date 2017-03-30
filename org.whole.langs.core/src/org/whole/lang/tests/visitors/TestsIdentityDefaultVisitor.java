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

import org.whole.lang.tests.model.*;

/**
 *  @generator Whole
 */
public class TestsIdentityDefaultVisitor extends TestsIdentityVisitor {

    public void visit(ITestsEntity entity) {
    }

    public void visit(TestSuite entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(FilterFamilies entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(FilterFamily entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(FilterRules entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(FilterRule entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(TestCases entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(TestCase entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Aspects entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(AbstractBehavior entity) {
    }

    public void visit(Aspect entity) {
        visit((AbstractBehavior) entity);
    }

    public void visit(BeforeTestCase entity) {
        visit((ITestsEntity) entity);
        visit((Aspect) entity);
    }

    public void visit(AfterTestCase entity) {
        visit((ITestsEntity) entity);
        visit((Aspect) entity);
    }

    public void visit(BeforeTest entity) {
        visit((ITestsEntity) entity);
        visit((Aspect) entity);
    }

    public void visit(AfterTest entity) {
        visit((ITestsEntity) entity);
        visit((Aspect) entity);
    }

    public void visit(Tests entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Test entity) {
        visit((ITestsEntity) entity);
        visit((AbstractBehavior) entity);
    }

    public void visit(TestStatements entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(TestStatement entity) {
    }

    public void visit(Statement entity) {
        visit((TestStatement) entity);
    }

    public void visit(Comment entity) {
        visit((ITestsEntity) entity);
        visit((TestStatement) entity);
    }

    public void visit(CommentKind entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(UsingFilter entity) {
        visit((ITestsEntity) entity);
        visit((TestStatement) entity);
    }

    public void visit(SubjectStatement entity) {
        visit((TestStatement) entity);
    }

    public void visit(AssertThat entity) {
        visit((ITestsEntity) entity);
        visit((SubjectStatement) entity);
    }

    public void visit(AssumeThat entity) {
        visit((ITestsEntity) entity);
        visit((SubjectStatement) entity);
    }

    public void visit(Filter entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Constraint entity) {
    }

    public void visit(IsNull entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(IsTrue entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(IsFalse entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(IsDef entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(IsUndef entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(HasKind entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(Kind entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(IsAssignableTo entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(HasType entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(Throws entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(ThrowableType entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(ObjectConstraint entity) {
        visit((Constraint) entity);
    }

    public void visit(Same entity) {
        visit((ITestsEntity) entity);
        visit((ObjectConstraint) entity);
    }

    public void visit(Equals entity) {
        visit((ITestsEntity) entity);
        visit((ObjectConstraint) entity);
    }

    public void visit(Matches entity) {
        visit((ITestsEntity) entity);
        visit((ObjectConstraint) entity);
    }

    public void visit(DecoratorConstraint entity) {
        visit((Constraint) entity);
    }

    public void visit(Not entity) {
        visit((ITestsEntity) entity);
        visit((DecoratorConstraint) entity);
    }

    public void visit(AllOf entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(AnyOf entity) {
        visit((ITestsEntity) entity);
        visit((Constraint) entity);
    }

    public void visit(Results entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Result entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Outcome entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Expression entity) {
    }

    public void visit(BooleanLiteral entity) {
        visit((ITestsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(IntLiteral entity) {
        visit((ITestsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(StringLiteral entity) {
        visit((ITestsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(DataName entity) {
        visit((ITestsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Sequence entity) {
        visit((ITestsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Name entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(PackageName entity) {
        visit((ITestsEntity) entity);
    }

    public void visit(Description entity) {
        visit((ITestsEntity) entity);
    }
}
