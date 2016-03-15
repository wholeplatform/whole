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
package org.whole.lang.tests.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.tests.model.AfterTest;
import org.whole.lang.tests.model.AfterTestCase;
import org.whole.lang.tests.model.AllOf;
import org.whole.lang.tests.model.AnyOf;
import org.whole.lang.tests.model.Aspects;
import org.whole.lang.tests.model.AssertThat;
import org.whole.lang.tests.model.AssumeThat;
import org.whole.lang.tests.model.BeforeTest;
import org.whole.lang.tests.model.BeforeTestCase;
import org.whole.lang.tests.model.Comment;
import org.whole.lang.tests.model.CommentKind;
import org.whole.lang.tests.model.Description;
import org.whole.lang.tests.model.Equals;
import org.whole.lang.tests.model.Filter;
import org.whole.lang.tests.model.FilterFamilies;
import org.whole.lang.tests.model.FilterFamily;
import org.whole.lang.tests.model.FilterRule;
import org.whole.lang.tests.model.FilterRules;
import org.whole.lang.tests.model.HasKind;
import org.whole.lang.tests.model.HasType;
import org.whole.lang.tests.model.ITestsEntity;
import org.whole.lang.tests.model.IsAssignableTo;
import org.whole.lang.tests.model.IsDef;
import org.whole.lang.tests.model.IsFalse;
import org.whole.lang.tests.model.IsNull;
import org.whole.lang.tests.model.IsTrue;
import org.whole.lang.tests.model.IsUndef;
import org.whole.lang.tests.model.Matches;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.model.Not;
import org.whole.lang.tests.model.PackageName;
import org.whole.lang.tests.model.Same;
import org.whole.lang.tests.model.Sequence;
import org.whole.lang.tests.model.StringLiteral;
import org.whole.lang.tests.model.Test;
import org.whole.lang.tests.model.TestCase;
import org.whole.lang.tests.model.TestCases;
import org.whole.lang.tests.model.TestStatements;
import org.whole.lang.tests.model.TestSuite;
import org.whole.lang.tests.model.Tests;
import org.whole.lang.tests.model.Throws;
import org.whole.lang.tests.model.UsingFilter;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.TestsIdentityDefaultVisitor;
import org.whole.lang.ui.editparts.AbstractPart;
import org.whole.lang.ui.editparts.AbstractTextualEntityPart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.CompositeRowWithPlaceholderPart;
import org.whole.lang.ui.editparts.DeclarationTextualEntityPart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.IGraphicalEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.figures.TextualFigure;
import org.whole.lang.ui.notations.editparts.QuotedStringTextualEntityPart;
import org.whole.lang.ui.notations.text.editparts.DefaultTextualPartFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class TestsPartFactoryVisitor extends TestsIdentityDefaultVisitor implements IEditPartFactory {
    protected EditPart part, context;

    public EditPart createEditPart(EditPart context, Object modelEntity) {
        this.context = context;
        ((ITestsEntity) modelEntity).accept(this);
        return part;
    }

    public boolean visitAdapter(IEntityAdapter entity) {
        part = new PlaceHolderPart();
        return super.visitAdapter(entity);
    }

    public void visit(ITestsEntity entity) {
        part = DefaultTextualPartFactory.instance().createEditPart(context, entity);
    }

    public void visit(StringLiteral entity) {
        part = new QuotedStringTextualEntityPart();
    }

    public void visit(Sequence entity) {
        part = new CompositeRowWithPlaceholderPart();
    }

    public void visit(AllOf entity) {
        part = new CompositeRowWithPlaceholderPart();
    }
    public void visit(AnyOf entity) {
        part = new CompositeColumnWithPlaceholderPart();
    }

    public void visit(TestSuite entity) {
        part = new TestSuitePart();
    }

    public void visit(FilterFamily entity) {
        part = new FilterFamilyPart();
    }

    public void visit(FilterRule entity) {
        part = new FilterRulePart();
    }

    public void visit(TestCase entity) {
        part = new TestCasePart();
    }

    public void visit(BeforeTestCase entity) {
        part = new BeforeTestCasePart();
    }

    public void visit(AfterTestCase entity) {
        part = new AfterTestCasePart();
    }

    public void visit(BeforeTest entity) {
        part = new BeforeTestPart();
    }

    public void visit(AfterTest entity) {
        part = new AfterTestPart();
    }

    public void visit(Test entity) {
        part = new TestPart();
    }

    @Override
    public void visit(PackageName entity) {
    	part = new ContentTextualEntityPart();
    }
    @Override
    public void visit(Name entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(TestsEntityDescriptorEnum.TestSuite, parent) ||
					Matcher.match(TestsEntityDescriptorEnum.TestCase, parent)) {
				part = new DeclarationTextualEntityPart();
				return;
			}
		}
    	part = new ContentTextualEntityPart();
    }

    public void visit(UsingFilter entity) {
        part = new UsingFilterPart();
    }

    public void visit(FilterFamilies entity) {
    	part = new CompositeColumnWithPlaceholderPart();
    }

    public void visit(FilterRules entity) {
    	part = new CompositeColumnWithPlaceholderPart();
    }

    public void visit(Filter entity) {
        part = new FilterPart();
    }

    public void visit(AssumeThat entity) {
        part = new AssumeThatPart();
    }

    public void visit(AssertThat entity) {
        part = new AssertThatPart();
    }

    public void visit(CommentKind entity) {
    	part = new CommentKindPart();
    }

    public void visit(Comment entity) {
    	part = new CommentPart();
    }

    public void visit(HasKind entity) {
        part = new HasKindPart();
    }

    public void visit(HasType entity) {
        part = new HasTypePart();
    }

    public void visit(IsAssignableTo entity) {
        part = new IsAssignableToPart();
    }

    public void visit(Throws entity) {
        part = new ThrowsPart();
    }

    public void visit(Same entity) {
        part = new SamePart();
    }

    public void visit(TestStatements entity) {
    	part = new CompositeColumnWithPlaceholderPart();
    }

    public void visit(TestCases entity) {
    	part = new CompositeColumnWithPlaceholderPart();//FIXME more spacing
    }

    public void visit(Tests entity) {
    	part = new CompositeColumnWithPlaceholderPart();
    }

    public void visit(Aspects entity) {
    	part = new CompositeColumnWithPlaceholderPart();
    }

    public void visit(Matches entity) {
        part = new MatchesPart();
    }

    public void visit(Equals entity) {
        part = new EqualsPart();
    }

    public void visit(Not entity) {
        part = new NotPart();
    }

    public void visit(IsDef entity) {
    	part = createKeywordPart("is def");
    }
    public void visit(IsUndef entity) {
    	part = createKeywordPart("is undef");
    }
    public void visit(IsFalse entity) {
    	part = createKeywordPart("is false");
    }
    public void visit(IsTrue entity) {
    	part = createKeywordPart("is true");
    }
    public void visit(IsNull entity) {
    	part = createKeywordPart("is null");
    }

    private IGraphicalEntityPart createKeywordPart(final String name) {
		return new AbstractPart() {
    		public IFigure createFigure() {
				return LabelFactory.createKeyword(name);
    		}
    	};
	}
 
    @Override
    public void visit(Description entity) {
    	part = new AbstractTextualEntityPart() {
    		protected IFigure createFigure() {
    			return new TextualFigure(LabelFactory.createContent());
    		}
    	};
    }
}
