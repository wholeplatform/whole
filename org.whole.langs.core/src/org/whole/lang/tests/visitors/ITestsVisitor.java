package org.whole.lang.tests.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.tests.model.*;

/** 
 * @generator Whole
 */
public interface ITestsVisitor extends IVisitor {
	public void visit(TestSuite entity);

	public void visit(FilterFamilies entity);

	public void visit(FilterFamily entity);

	public void visit(FilterRules entity);

	public void visit(FilterRule entity);

	public void visit(TestCases entity);

	public void visit(TestCase entity);

	public void visit(Aspects entity);

	public void visit(BeforeTestCase entity);

	public void visit(AfterTestCase entity);

	public void visit(BeforeTest entity);

	public void visit(AfterTest entity);

	public void visit(Tests entity);

	public void visit(Test entity);

	public void visit(TestStatements entity);

	public void visit(Comment entity);

	public void visit(CommentKind entity);

	public void visit(UsingFilter entity);

	public void visit(AssertThat entity);

	public void visit(AssumeThat entity);

	public void visit(Filter entity);

	public void visit(IsNull entity);

	public void visit(IsTrue entity);

	public void visit(IsFalse entity);

	public void visit(IsDef entity);

	public void visit(IsUndef entity);

	public void visit(HasKind entity);

	public void visit(Kind entity);

	public void visit(IsAssignableTo entity);

	public void visit(HasType entity);

	public void visit(Throws entity);

	public void visit(ThrowableType entity);

	public void visit(Same entity);

	public void visit(Equals entity);

	public void visit(Matches entity);

	public void visit(Not entity);

	public void visit(AllOf entity);

	public void visit(AnyOf entity);

	public void visit(BooleanLiteral entity);

	public void visit(IntLiteral entity);

	public void visit(StringLiteral entity);

	public void visit(DataName entity);

	public void visit(Sequence entity);

	public void visit(Name entity);

	public void visit(PackageName entity);

	public void visit(Description entity);
}
