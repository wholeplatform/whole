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

import org.whole.lang.tests.visitors.TestsIdentityUnaryVisitor;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class TestsTraverseAllVisitor extends TestsIdentityUnaryVisitor<ITestsVisitor> {

    public TestsTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public TestsTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(TestSuite entity) {
        entity.getPackageName().accept(wGetVisitor1());
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getDeployer().accept(wGetVisitor1());
        entity.getFilterFamilies().accept(wGetVisitor1());
        entity.getTestCases().accept(wGetVisitor1());
        entity.getActualResults().accept(wGetVisitor1());
        entity.getExpectedResults().accept(wGetVisitor1());
    }

    public void visit(FilterFamilies entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FilterFamily entity) {
        entity.getPackageName().accept(wGetVisitor1());
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getFilterRules().accept(wGetVisitor1());
    }

    public void visit(FilterRules entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FilterRule entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(TestCases entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TestCase entity) {
        entity.getPackageName().accept(wGetVisitor1());
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getDeployer().accept(wGetVisitor1());
        entity.getAspects().accept(wGetVisitor1());
        entity.getTests().accept(wGetVisitor1());
        entity.getActualResults().accept(wGetVisitor1());
        entity.getExpectedResults().accept(wGetVisitor1());
    }

    public void visit(AbstractBehavior entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(Aspects entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Aspect entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(BeforeTestCase entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(AfterTestCase entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(BeforeTest entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(AfterTest entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(Tests entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Test entity) {
        entity.getDescription().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getActualResult().accept(wGetVisitor1());
        entity.getExpectedResult().accept(wGetVisitor1());
    }

    public void visit(TestStatements entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Comment entity) {
        entity.getKind().accept(wGetVisitor1());
        entity.getDescription().accept(wGetVisitor1());
    }

    public void visit(UsingFilter entity) {
        entity.getFilter().accept(wGetVisitor1());
        entity.getSubjectStatement().accept(wGetVisitor1());
    }

    public void visit(SubjectStatement entity) {
        entity.getSubject().accept(wGetVisitor1());
        entity.getConstraint().accept(wGetVisitor1());
    }

    public void visit(AssertThat entity) {
        entity.getSubject().accept(wGetVisitor1());
        entity.getConstraint().accept(wGetVisitor1());
    }

    public void visit(AssumeThat entity) {
        entity.getSubject().accept(wGetVisitor1());
        entity.getConstraint().accept(wGetVisitor1());
    }

    public void visit(Filter entity) {
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(HasKind entity) {
        entity.getKind().accept(wGetVisitor1());
    }

    public void visit(IsAssignableTo entity) {
        entity.getDescriptorName().accept(wGetVisitor1());
    }

    public void visit(HasType entity) {
        entity.getDescriptorName().accept(wGetVisitor1());
    }

    public void visit(Throws entity) {
        entity.getThrowableType().accept(wGetVisitor1());
    }

    public void visit(ObjectConstraint entity) {
        entity.getObject().accept(wGetVisitor1());
    }

    public void visit(Same entity) {
        entity.getObject().accept(wGetVisitor1());
    }

    public void visit(Equals entity) {
        entity.getObject().accept(wGetVisitor1());
    }

    public void visit(Matches entity) {
        entity.getObject().accept(wGetVisitor1());
    }

    public void visit(DecoratorConstraint entity) {
        entity.getConstraint().accept(wGetVisitor1());
    }

    public void visit(Not entity) {
        entity.getConstraint().accept(wGetVisitor1());
    }

    public void visit(AllOf entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AnyOf entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Results entity) {
        entity.getSuccesses().accept(wGetVisitor1());
        entity.getFailures().accept(wGetVisitor1());
        entity.getErrors().accept(wGetVisitor1());
    }

    public void visit(Result entity) {
        entity.getOutcome().accept(wGetVisitor1());
        entity.getLocation().accept(wGetVisitor1());
        entity.getCause().accept(wGetVisitor1());
    }

    public void visit(Sequence entity) {
        for (Expression child : entity)
            child.accept(wGetVisitor1());
    }
}
