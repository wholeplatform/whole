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
package org.whole.lang.queries.ui.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.queries.ui.figures.CollectByExpressionFigure;
import org.whole.lang.queries.visitors.QueriesIdentityDefaultVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeColumnPart;
import org.whole.lang.ui.editparts.CommaSeparatedCompositeFlowPart;
import org.whole.lang.ui.editparts.CompositeColumnWithPlaceholderPart;
import org.whole.lang.ui.editparts.ContentLightDataEntityPart;
import org.whole.lang.ui.editparts.ContentTextualEntityPart;
import org.whole.lang.ui.editparts.EntityTypePart;
import org.whole.lang.ui.editparts.FeatureTypePart;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.editparts.KeywordDataEntityPart;
import org.whole.lang.ui.editparts.PlaceHolderPart;
import org.whole.lang.ui.editparts.VariableDataEntityPart;
import org.whole.lang.ui.notations.editparts.QuotedStringTextualEntityPart;
import org.whole.lang.ui.notations.text.editparts.TextPartFactory;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class QueriesPartFactoryVisitor extends QueriesIdentityDefaultVisitor implements
		IEditPartFactory {
	protected EditPart part, context;

	public EditPart createEditPart(EditPart context, Object modelEntity) {
		this.context = context;
		((IQueriesEntity) modelEntity).accept(this);
		return part;
	}

	@Override
	public boolean visitAdapter(IEntityAdapter entity) {
		part = new PlaceHolderPart();
		return super.visitAdapter(entity);
	}

	@Override
	public void visit(IQueriesEntity entity) {
		part = TextPartFactory.instance().createEditPart(context, entity);
	}

	@Override
	public void visit(QueryDeclaration entity) {
		part = new QueryDeclarationPart();
	}

	@Override
	public void visit(Names entity) {
		part = new CommaSeparatedCompositeFlowPart();
	}

	@Override
	public void visit(Name entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.hasParent(entity) && Matcher.match(QueriesEntityDescriptorEnum.Bind, parent) && parent.wGet(QueriesFeatureDescriptorEnum.name) == entity)
			part = new ContentTextualEntityPart();
		else
			part = new VariableDataEntityPart();//IdentifierTextualEntityPart();
	}

	@Override
	public void visit(Expressions entity) {
		IEntity parent = entity.wGetParent();
		if (EntityUtils.hasParent(entity)) {
			if (Matcher.match(QueriesEntityDescriptorEnum.EntityTemplate, parent)) {
				part = new CompositeColumnWithPlaceholderPart();
				return;
			} else if (Matcher.match(QueriesEntityDescriptorEnum.UnionAll, parent) ||
					Matcher.isAssignableAsIsFrom(QueriesEntityDescriptorEnum.CollectByExpression, parent)) {
				part = new CommaSeparatedCompositeColumnPart();
				return;				
			}
		}
		part = new CommaSeparatedCompositeFlowPart();
	}

	@Override
	public void visit(Tuple entity) {
		part = new TuplePart();
	}

	@Override
	public void visit(Path entity) {
		part = new PathPart();
	}

	@Override
	public void visit(Delete entity) {
		part = new DeletePart();
	}

	@Override
	public void visit(CartesianInsert entity) {
		part = new CartesianInsertPart();
	}

	@Override
	public void visit(PointwiseInsert entity) {
		part = new PointwiseInsertPart();
	}

	@Override
	public void visit(Placement entity) {
		part = new KeywordDataEntityPart();
	}

	@Override
	public void visit(CartesianUpdate entity) {
		part = new CartesianUpdatePart();
	}

	@Override
	public void visit(PointwiseUpdate entity) {
		part = new PointwiseUpdatePart();
	}

	@Override
	public void visit(Select entity) {
		IEntity parent = entity.wGetParent();
		if (Matcher.match(QueriesEntityDescriptorEnum.Choose, parent))
			part = new SelectRowPart();
		else
			part = new SelectPart();
	}

	@Override
	public void visit(If entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(QueriesEntityDescriptorEnum.Choose, parent)) {
					part = new IfRowPart();
					return;
			}
		}
		part = new IfPart();
	}

	@Override
	public void visit(For entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(QueriesEntityDescriptorEnum.Choose, parent)) {
					part = new ForRowPart();
					return;
			}
		}
		part = new ForPart();
	}

	@Override
	public void visit(CartesianProduct entity) {
		part = new CartesianProductPart();
	}

	@Override
	public void visit(PointwiseProduct entity) {
		part = new PointwiseProductPart();
	}

	@Override
	public void visit(Choose entity) {
		part = new ChooseTablePart();
	}

	@Override
	public void visit(Block entity) {
		part = new BlockPart();
	}

	@Override
	public void visit(Sequence entity) {
		part = new SequencePart();
	}

	@Override
	public void visit(Call entity) {
		part = new CallPart();
	}

	@Override
	public void visit(EntityCall entity) {
		part = new EntityCallPart();
	}

	@Override
	public void visit(EntityTemplate entity) {
		EntityType name = entity.getName();
		if (DataTypeUtils.getDataKind(name).isString()) {
			EntityDescriptor<?> ed = CommonsDataTypePersistenceParser.getEntityDescriptor(name.getValue(), false, null);
			if (ed != null && ed.getEntityKind().isData()) {
				part = new EntityTemplateInlinePart();
				return;
			}
		}

		part = new EntityTemplatePart();
	}

	@Override
	public void visit(EntityType entity) {
		part = new EntityTypePart();
	}
	
	@Override
	public void visit(Bindings entity) {
		part = new BindingsTablePart();
	}
	@Override
	public void visit(Bind entity) {
		part = new BindPart();
	}

	@Override
	public void visit(Do entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(QueriesEntityDescriptorEnum.Choose, parent)) {
					part = new DoRowPart();
					return;
			}
		}
		part = new DoPart();
	}

	@Override
	public void visit(Filter entity) {
		if (EntityUtils.hasParent(entity)) {
			IEntity parent = entity.wGetParent();
			if (Matcher.match(QueriesEntityDescriptorEnum.Tuple, parent)) {
					part = new FilterRowPart();
					return;
			}
		}
		part = new FilterPart();
	}

	@Override
	public void visit(AspectStep entity) {
		part = new AspectStepPart();
	}
	@Override
	public void visit(AdjacentStep entity) {
		part = new AdjacentStepPart();
	}
	@Override
	public void visit(ReachableStep entity) {
		part = new ReachableStepPart();
	}
	@Override
	public void visit(ReachableOrSelfStep entity) {
		part = new ReachableOrSelfStepPart();
	}
	@Override
	public void visit(InverseAdjacentStep entity) {
		part = new InverseAdjacentStepPart();
	}
	@Override
	public void visit(InverseReachableStep entity) {
		part = new InverseReachableStepPart();
	}
	@Override
	public void visit(InverseReachableOrSelfStep entity) {
		part = new InverseReachableOrSelfStepPart();
	}

	@Override
	public void visit(RootStep entity) {
		part = new RootStepPart();
	}

	@Override
	public void visit(FragmentRootStep entity) {
		part = new FragmentRootStepPart();
	}

	@Override
	public void visit(SelfStep entity) {
		part = new SelfStepPart();
	}

	@Override
	public void visit(FeatureStep entity) {
		part = new FeatureTypePart();
	}

	@Override
	public void visit(ChildStep entity) {
		part = new ChildStepPart();
	}

	@Override
	public void visit(DescendantStep entity) {
		part = new DescendantStepPart();
	}

	@Override
	public void visit(DescendantOrSelfStep entity) {
		part = new DescendantOrSelfStepPart();
	}

	@Override
	public void visit(FollowingSiblingStep entity) {
		part = new FollowingSiblingStepPart();
	}

	@Override
	public void visit(FollowingStep entity) {
		part = new FollowingStepPart();
	}

	@Override
	public void visit(ParentStep entity) {
		part = new ParentStepPart();
	}

	@Override
	public void visit(AncestorStep entity) {
		part = new AncestorStepPart();
	}

	@Override
	public void visit(AncestorOrSelfStep entity) {
		part = new AncestorOrSelfStepPart();
	}

	@Override
	public void visit(PrecedingSiblingStep entity) {
		part = new PrecedingSiblingStepPart();
	}

	@Override
	public void visit(PrecedingStep entity) {
		part = new PrecedingStepPart();
	}

	@Override
	public void visit(KindTest entity) {
		part = new ContentLightDataEntityPart();
	}

	@Override
	public void visit(StageTest entity) {
		part = new ContentLightDataEntityPart();
	}
	@Override
	public void visit(StageVariableTest entity) {
		part = new StageVariableTestPart();
	}

	@Override
	public void visit(LanguageTest entity) {
		part = new LanguageTestPart();
	}

	@Override
	public void visit(TypeTest entity) {
		part = new TypeTestPart();
	}

	@Override
	public void visit(SubtypeTest entity) {
		part = new SubtypeTestPart();
	}

	@Override
	public void visit(SupertypeTest entity) {
		part = new SupertypeTestPart();
	}

	@Override
	public void visit(ExtendedSubtypeTest entity) {
		part = new ExtendedSubtypeTestPart();
	}

	@Override
	public void visit(ExtendedSupertypeTest entity) {
		part = new ExtendedSupertypeTestPart();
	}

	@Override
	public void visit(AtTypeTest entity) {
		part = new AtTypeTestPart();
	}

	@Override
	public void visit(AtFeatureTest entity) {
		part = new AtFeatureTestPart();
	}

	@Override
	public void visit(AtIndexTest entity) {
		part = new AtIndexTestPart();
	}

	@Override
	public void visit(IndexVariableTest entity) {
		part = new IndexVariableTestPart();
	}

	@Override
	public void visit(IndexTest entity) {
		part = new IndexTestPart();
	}

	@Override
	public void visit(IndexRangeTest entity) {
		part = new IndexRangeTestPart();
	}

	@Override
	public void visit(StringLiteral entity) {
		part = new QuotedStringTextualEntityPart();
	}

	@Override
	public void visit(VoidLiteral entity) {
		part = new VoidLiteralPart();
	}
	
	@Override
	public void visit(ExpressionTest entity) {
		part = new ExpressionTestPart();
	}

	@Override
	public void visit(VariableRefStep entity) {
		part = new VariableDataEntityPart();
	}

	@Override
	public void visit(VariableTest entity) {
//		IEntity parent = entity.wGetParent();
//		boolean hasParent = EntityUtils.hasParent(entity);
//		boolean isBindContext = hasParent && Matcher.match(QueriesEntityDescriptorEnum.Bind, parent);
//		boolean isAndContext = hasParent & Matcher.match(QueriesEntityDescriptorEnum.And, parent);
//		boolean isAnd2Context = false;
//		if (isAndContext) {
//			int indexOf = parent.wIndexOf(entity);
//			isAnd2Context = indexOf > 0 && indexOf == parent.wSize()-1;
//		}
//
//		//TODO !isAnd2StarContext
//		if (isAnd2Context)
//			context = context.getParent();
		EditPart contextParent = context.getParent();
		boolean isFilterContext = (context instanceof FilterPart) || (context instanceof FilterRowPart);
		boolean isFilterInPath = isFilterContext && contextParent instanceof PathPart;
		boolean isFilterLastChild = false;
		if (isFilterInPath) {
			IEntity path = ((PathPart) contextParent).getModelEntity();
			isFilterLastChild = path.wGet(path.wSize()-1) == context.getModel();
		}
//		final boolean showBrackets = !isBindContext && (!isFilterContext || (isFilterInPath && !isFilterLastChild));
	
		part = new VariableTestPart(isFilterInPath && !isFilterLastChild);//showBrackets);
	}

	@Override
	public void visit(DistinctTest entity) {
		part = new DistinctTestPart();
	}

	@Override
	public void visit(Prune entity) {
		part = new PrunePart();
	}

	@Override
	public void visit(And entity) {
		part = new AndPart();
	}

	@Override
	public void visit(Or entity) {
		part = new OrPart();
	}

	@Override
	public void visit(Not entity) {
		part = new NotPart();
	}

	@Override
	public void visit(One entity) {
		part = new OnePart();
	}
	@Override
	public void visit(Some entity) {
		part = new SomePart();
	}
	@Override
	public void visit(Every entity) {
		part = new EveryPart();
	}

	@Override
	public void visit(ParenthesizedPredicate entity) {
		part = new ParenthesizedPredicatePart();
	}

	@Override
	public void visit(UnionAll entity) {
		part = new UnionAllPart();
	}

	@Override
	public void visit(Union entity) {
		part = new CollectByExpressionPart() {
			protected IFigure createFigure() {
				return new CollectByExpressionFigure("\u222a");
			}
		};
	}

	@Override
	public void visit(Intersect entity) {
		part = new CollectByExpressionPart() {
			protected IFigure createFigure() {
				return new CollectByExpressionFigure("\u2229");
			}
		};
	}

	@Override
	public void visit(Except entity) {
		part = new CollectByExpressionPart() {
			protected IFigure createFigure() {
				return new CollectByExpressionFigure("\u2216");
			}
		};
	}


	@Override
	public void visit(IdentityComparator entity) {
		part = new IdentityComparatorPart();
	}

	@Override
	public void visit(PointwiseEquals entity) {
		part = new PointwiseEqualsPart();
	}
	
	@Override
	public void visit(AdditionStep entity) {
		part = new PrefixExpressionPart("+");
	}

	@Override
	public void visit(SubtractionStep entity) {
		part = new PrefixExpressionPart("-");
	}

	@Override
	public void visit(MultiplicationStep entity) {
		part = new PrefixExpressionPart("*");
	}

	@Override
	public void visit(DivisionStep entity) {
		part = new PrefixExpressionPart("/");
	}
	
	@Override
	public void visit(RemainderStep entity) {
		part = new PrefixExpressionPart("%");
	}

	@Override
	public void visit(EqualsStep entity) {
		part = new PrefixExpressionPart("==");
	}
	
	@Override
	public void visit(NotEqualsStep entity) {
		part = new PrefixExpressionPart("!=");
	}
	
	@Override
	public void visit(LessThanStep entity) {
		part = new PrefixExpressionPart("<");
	}
	
	@Override
	public void visit(LessOrEqualsStep entity) {
		part = new PrefixExpressionPart("<=");
	}
	
	@Override
	public void visit(GreaterThanStep entity) {
		part = new PrefixExpressionPart(">");
	}
	
	@Override
	public void visit(GreaterOrEqualsStep entity) {
		part = new PrefixExpressionPart(">=");
	}

	@Override
	public void visit(Addition entity) {
		part = new InfixExpressionPart("+");
	}

	@Override
	public void visit(Subtraction entity) {
		part = new InfixExpressionPart("-");
	}

	@Override
	public void visit(Multiplication entity) {
		part = new InfixExpressionPart("*");
	}

	@Override
	public void visit(Division entity) {
		part = new InfixExpressionPart("/");
	}
	
	@Override
	public void visit(Remainder entity) {
		part = new InfixExpressionPart("%");
	}

	@Override
	public void visit(Equals entity) {
		part = new InfixExpressionPart("==");
	}
	
	@Override
	public void visit(NotEquals entity) {
		part = new InfixExpressionPart("!=");
	}
	
	@Override
	public void visit(LessThan entity) {
		part = new InfixExpressionPart("<");
	}
	
	@Override
	public void visit(LessOrEquals entity) {
		part = new InfixExpressionPart("<=");
	}
	
	@Override
	public void visit(GreaterThan entity) {
		part = new InfixExpressionPart(">");
	}
	
	@Override
	public void visit(GreaterOrEquals entity) {
		part = new InfixExpressionPart(">=");
	}

	@Override
	public void visit(Singleton entity) {
		part = new SingletonPart();
	}

	@Override
	public void visit(Scope entity) {
		part = new ScopePart();
	}

	@Override
	public void visit(AllNames entity) {
		part = new AllNamesPart();
	}
	@Override
	public void visit(TemplateNames entity) {
		part = new TemplateNamesPart();
	}

	@Override
	public void visit(AddNames entity) {
		part = new AddNamesPart();
	}
	@Override
	public void visit(RemoveNames entity) {
		part = new RemoveNamesPart();
	}
}
