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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.tests.model.*;

/**
 *  @generator Whole
 */
public class TestsTraverseAllSwitchVisitor extends TestsIdentityUnaryVisitor<IVisitor> {

    public TestsTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(TestSuite entity) {
        wGetVisitor1().visit(entity.getPackageName());
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDeployer());
        wGetVisitor1().visit(entity.getFilterFamilies());
        wGetVisitor1().visit(entity.getTestCases());
        wGetVisitor1().visit(entity.getActualResults());
        wGetVisitor1().visit(entity.getExpectedResults());
    }

    public void visit(FilterFamilies entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FilterFamily entity) {
        wGetVisitor1().visit(entity.getPackageName());
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getFilterRules());
    }

    public void visit(FilterRules entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FilterRule entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(TestCases entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TestCase entity) {
        wGetVisitor1().visit(entity.getPackageName());
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDeployer());
        wGetVisitor1().visit(entity.getAspects());
        wGetVisitor1().visit(entity.getTests());
        wGetVisitor1().visit(entity.getActualResults());
        wGetVisitor1().visit(entity.getExpectedResults());
    }

    public void visit(AbstractBehavior entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(Aspects entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Aspect entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(BeforeTestCase entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(AfterTestCase entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(BeforeTest entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(AfterTest entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(Tests entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Test entity) {
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getActualResult());
        wGetVisitor1().visit(entity.getExpectedResult());
    }

    public void visit(TestStatements entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Comment entity) {
        wGetVisitor1().visit(entity.getKind());
        wGetVisitor1().visit(entity.getDescription());
    }

    public void visit(UsingFilter entity) {
        wGetVisitor1().visit(entity.getFilter());
        wGetVisitor1().visit(entity.getSubjectStatement());
    }

    public void visit(SubjectStatement entity) {
        wGetVisitor1().visit(entity.getSubject());
        wGetVisitor1().visit(entity.getConstraint());
    }

    public void visit(AssertThat entity) {
        wGetVisitor1().visit(entity.getSubject());
        wGetVisitor1().visit(entity.getConstraint());
    }

    public void visit(AssumeThat entity) {
        wGetVisitor1().visit(entity.getSubject());
        wGetVisitor1().visit(entity.getConstraint());
    }

    public void visit(Filter entity) {
        wGetVisitor1().visit(entity.getName());
    }

    public void visit(HasKind entity) {
        wGetVisitor1().visit(entity.getKind());
    }

    public void visit(IsAssignableTo entity) {
        wGetVisitor1().visit(entity.getDescriptorName());
    }

    public void visit(HasType entity) {
        wGetVisitor1().visit(entity.getDescriptorName());
    }

    public void visit(Throws entity) {
        wGetVisitor1().visit(entity.getThrowableType());
    }

    public void visit(ObjectConstraint entity) {
        wGetVisitor1().visit(entity.getObject());
    }

    public void visit(Same entity) {
        wGetVisitor1().visit(entity.getObject());
    }

    public void visit(Equals entity) {
        wGetVisitor1().visit(entity.getObject());
    }

    public void visit(Matches entity) {
        wGetVisitor1().visit(entity.getObject());
    }

    public void visit(DecoratorConstraint entity) {
        wGetVisitor1().visit(entity.getConstraint());
    }

    public void visit(Not entity) {
        wGetVisitor1().visit(entity.getConstraint());
    }

    public void visit(AllOf entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AnyOf entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Results entity) {
        wGetVisitor1().visit(entity.getSuccesses());
        wGetVisitor1().visit(entity.getFailures());
        wGetVisitor1().visit(entity.getErrors());
    }

    public void visit(Result entity) {
        wGetVisitor1().visit(entity.getOutcome());
        wGetVisitor1().visit(entity.getLocation());
        wGetVisitor1().visit(entity.getCause());
    }

    public void visit(Sequence entity) {
        for (Expression child : entity)
            wGetVisitor1().visit(child);
    }
}
