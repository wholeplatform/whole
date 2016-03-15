/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.tests.visitors;

import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.operations.IPrettyPrintWriter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.tests.model.AfterTest;
import org.whole.lang.tests.model.AfterTestCase;
import org.whole.lang.tests.model.AllOf;
import org.whole.lang.tests.model.AnyOf;
import org.whole.lang.tests.model.Aspect;
import org.whole.lang.tests.model.AssertThat;
import org.whole.lang.tests.model.AssumeThat;
import org.whole.lang.tests.model.BeforeTest;
import org.whole.lang.tests.model.BeforeTestCase;
import org.whole.lang.tests.model.BooleanLiteral;
import org.whole.lang.tests.model.Comment;
import org.whole.lang.tests.model.CommentKind;
import org.whole.lang.tests.model.CommentKindEnum;
import org.whole.lang.tests.model.Constraint;
import org.whole.lang.tests.model.DataName;
import org.whole.lang.tests.model.Description;
import org.whole.lang.tests.model.Equals;
import org.whole.lang.tests.model.FilterFamily;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.HasKind;
import org.whole.lang.tests.model.HasType;
import org.whole.lang.tests.model.IntLiteral;
import org.whole.lang.tests.model.IsAssignableTo;
import org.whole.lang.tests.model.IsDef;
import org.whole.lang.tests.model.IsFalse;
import org.whole.lang.tests.model.IsNull;
import org.whole.lang.tests.model.IsTrue;
import org.whole.lang.tests.model.IsUndef;
import org.whole.lang.tests.model.Kind;
import org.whole.lang.tests.model.Matches;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.model.Not;
import org.whole.lang.tests.model.PackageName;
import org.whole.lang.tests.model.Same;
import org.whole.lang.tests.model.StringLiteral;
import org.whole.lang.tests.model.Test;
import org.whole.lang.tests.model.TestCase;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.tests.model.ThrowableType;
import org.whole.lang.tests.model.Throws;
import org.whole.lang.tests.model.UsingFilter;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class TestsPrettyPrinterVisitor extends TestsTraverseAllVisitor {
	private static final String COMMENT_LINE_PREFIX = " *  ";

	protected final IPrettyPrintWriter out;

	public TestsPrettyPrinterVisitor(PrettyPrinterOperation operation) {
		out = operation.getPrettyPrintWriter();
	}

	protected boolean useDataNameValues() {
		return getBindings().wIsSet("useDataNameValues") ?
				getBindings().wBooleanValue("useDataNameValues") : false;
	}

	public boolean visitAdapter(IEntityAdapter entity) {
		stagedVisit(entity.wGetAdaptee(false));
		if (Matcher.match(TestsEntityDescriptorEnum.TestStatements, entity.wGetParent()))
			out.ensureNewLine();
		return false;
	}

	@Override
	public void visit(Description entity) {
		IEntity parent = entity.wGetParent();
		if (!EntityUtils.isNull(parent) && Matcher.match(TestsEntityDescriptorEnum.Comment, parent)) {
			for (String line : StringUtils.EOL_PATTERN.split(entity.wStringValue()))
				out.printlnRaw(line);
		} else {
			out.printlnRaw("/**");
			out.addLinePrefix(COMMENT_LINE_PREFIX);
			for (String line : StringUtils.EOL_PATTERN.split(entity.wStringValue()))
				out.printlnRaw(line);
			out.ensureNewLine();
			out.removeLinePrefix(COMMENT_LINE_PREFIX);
			out.printlnRaw(" */");
		}
	}

	@Override
	public void visit(CommentKind entity) {
		if (!CommentKindEnum.NOTE.equals(entity.getValue()))
			out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}

	@Override
	public void visit(Comment entity) {
		out.printRaw("/* ");
		out.addLinePrefix(COMMENT_LINE_PREFIX);
		entity.getKind().accept(this);
		out.ensureNewLine();
		entity.getDescription().accept(this);
		out.ensureNewLine();
		out.removeLinePrefix(COMMENT_LINE_PREFIX);
		out.printlnRaw(" */");
	}

	@Override
	public void visit(TestSuite entity) {
		entity.getDescription().accept(this);

		out.printRaw("Test suite ");
		PackageName packageName = entity.getPackageName();
		if (!EntityUtils.isResolver(packageName)) {
			packageName.accept(this);
			out.print('.');
		}
		entity.getName().accept(this);
		out.printlnRaw(" {");

		out.setRelativeIndentation(+1);

		out.printlnRaw("Deployer {");
		out.setRelativeIndentation(+1);
		entity.getDeployer().accept(this);
		out.setRelativeIndentation(-1);
		out.printlnRaw("}");

		entity.getFilterFamilies().accept(this);
		entity.getTestCases().accept(this);

		out.setRelativeIndentation(-1);

		out.printlnRaw("}");
	}

	@Override
	public void visit(FilterFamily entity) {
		entity.getDescription().accept(this);

		out.printRaw("Filter family ");
		PackageName packageName = entity.getPackageName();
		if (!EntityUtils.isResolver(packageName)) {
			packageName.accept(this);
			out.print('.');
		}
		entity.getName().accept(this);
		out.printlnRaw(" {");

		out.setRelativeIndentation(+1);
		entity.getFilterRules().accept(this);
		out.setRelativeIndentation(-1);

		out.printlnRaw("}");
	}

	@Override
	public void visit(FilterRule entity) {
		entity.getDescription().accept(this);

		entity.getName().accept(this);
		out.printlnRaw("() {");

		out.setRelativeIndentation(+1);
		entity.getBody().accept(this);
		out.setRelativeIndentation(-1);

		out.ensureNewLine();
		out.printlnRaw("}");
	}

	@Override
	public void visit(TestCase entity) {
		out.printRaw("Test case ");
		PackageName packageName = entity.getPackageName();
		if (!EntityUtils.isResolver(packageName)) {
			packageName.accept(this);
			out.print('.');
		}
		entity.getName().accept(this);
		out.printlnRaw(" {");

		out.setRelativeIndentation(+1);

		out.printlnRaw("Deployer {");
		out.setRelativeIndentation(+1);
		entity.getDeployer().accept(this);
		out.setRelativeIndentation(-1);
		out.printlnRaw("}");

		entity.getAspects().accept(this);
		entity.getTests().accept(this);

		out.setRelativeIndentation(-1);

		out.printlnRaw("}");
	}

	protected void visitAspect(Aspect entity) {
		out.printRaw("@");
		out.printlnRaw(entity.wGetEntityDescriptor().getName());
		entity.getName().accept(this);
		out.printlnRaw("() {");

		out.setRelativeIndentation(+1);
		entity.getBody().accept(this);
		out.setRelativeIndentation(-1);

		out.printlnRaw("}");
	}
	@Override
	public void visit(AfterTest entity) {
		visitAspect(entity);
	}
	@Override
	public void visit(AfterTestCase entity) {
		visitAspect(entity);
	}
	@Override
	public void visit(BeforeTest entity) {
		visitAspect(entity);
	}
	@Override
	public void visit(BeforeTestCase entity) {
		visitAspect(entity);
	}

	@Override
	public void visit(Test entity) {
		out.printlnRaw("@Test");
		entity.getName().accept(this);
		out.printlnRaw("() {");

		out.setRelativeIndentation(+1);
		entity.getBody().accept(this);
		out.setRelativeIndentation(-1);

		out.printlnRaw("}");
	}

	@Override
	public void visit(AssumeThat entity) {
		out.printRaw("assume that ");
		entity.getSubject().accept(this);
		out.printRaw(" ");
		entity.getConstraint().accept(this);
		out.println();
	}

	@Override
	public void visit(AssertThat entity) {
		out.printRaw("assert that ");
		entity.getSubject().accept(this);
		out.printRaw(" ");
		entity.getConstraint().accept(this);
		out.println();
	}
	@Override
	public void visit(UsingFilter entity) {
		out.printRaw("using filter ");
		entity.getFilter().accept(this);
		out.printRaw(" ");
		entity.getSubjectStatement().accept(this);
	}

	@Override
	public void visit(BooleanLiteral entity) {
		out.printRaw("boolean(");
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
		out.printRaw(")");
	}

	@Override
	public void visit(IntLiteral entity) {
		out.printRaw("int(");
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
		out.printRaw(")");
	}

	@Override
	public void visit(StringLiteral entity) {
		out.printRaw("\"");
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
		out.printRaw("\"");
	}

	@Override
	public void visit(DataName entity) {
		String name = entity.wStringValue();
		if (useDataNameValues())
			out.printRaw("value of ");
		out.printRaw("DataName(");
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
		out.printRaw(")");
		if (useDataNameValues())
			if (getBindings().wIsSet(name)) {
				out.printRaw(" [\"");
				stagedVisit(getBindings().wGet(name));
				out.printRaw("\"]");
			} else
				out.printRaw(" [Undefined]");
	}

	@Override
	public void visit(AllOf entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(" and ");
			((Constraint) entity.wGet(i)).accept(this);
		}
	}

	@Override
	public void visit(AnyOf entity) {
		for (int i = 0; i < entity.wSize(); i++) {
			if (i>0)
				out.printRaw(" or ");
			((Constraint) entity.wGet(i)).accept(this);
		}
	}

	@Override
	public void visit(Not entity) {
		out.printRaw("not ");
		entity.getConstraint().accept(this);
	}
	@Override
	public void visit(Throws entity) {
		out.printRaw("throws  ");
		entity.getThrowableType().accept(this);
	}
	@Override
	public void visit(Equals entity) {
		out.printRaw("equals ");
		entity.getObject().accept(this);
	}
	@Override
	public void visit(Same entity) {
		out.printRaw("same as ");
		entity.getObject().accept(this);
	}
	@Override
	public void visit(Matches entity) {
		out.printRaw("matches ");
		entity.getObject().accept(this);
	}

	@Override
	public void visit(HasKind entity) {
		out.printRaw("has kind ");
		entity.getKind().accept(this);
	}
	@Override
	public void visit(HasType entity) {
		out.printRaw("has type ");
		entity.getDescriptorName().accept(this);
	}
	@Override
	public void visit(IsAssignableTo entity) {
		out.printRaw("is assignable ");
		entity.getDescriptorName().accept(this);
	}

	@Override
	public void visit(IsDef entity) {
		out.printRaw("is defined");
	}
	@Override
	public void visit(IsUndef entity) {
		out.printRaw("is undefined");
	}
	@Override
	public void visit(IsNull entity) {
		out.printRaw("is null");
	}
	@Override
	public void visit(IsFalse entity) {
		out.printRaw("is false");
	}
	@Override
	public void visit(IsTrue entity) {
		out.printRaw("is true");
	}
	@Override
	public void visit(Kind entity) {
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}
	@Override
	public void visit(ThrowableType entity) {
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}
	@Override
	public void visit(Name entity) {
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}
	@Override
	public void visit(PackageName entity) {
		out.printRaw(DataTypeUtils.getAsPresentationString(entity));
	}
}
