package org.whole.lang.tests.visitors;

import org.whole.lang.tests.visitors.TestsIdentityUnaryVisitor;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TestsTraverseAllChildrenVisitor extends
		TestsIdentityUnaryVisitor<ITestsVisitor> {
	public TestsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public TestsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(TestSuite entity) {
		entity.getPackageName().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
		entity.getName().accept(wGetVisitor1());
		entity.getDeployer().accept(wGetVisitor1());
		entity.getFilterFamilies().accept(wGetVisitor1());
		entity.getTestCases().accept(wGetVisitor1());
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

	public void visit(Sequence entity) {
		for (Expression child : entity)
			child.accept(wGetVisitor1());
	}
}
