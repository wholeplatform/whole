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
package org.whole.lang.queries.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class QueriesAdaptersEntityRegistry extends AbstractEntityRegistry {

    public QueriesAdaptersEntityRegistry() {
        super(QueriesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new PathExpressionOrPredicateAdapter());
        put(new PathExpressionAdapter());
        put(new QueryDeclarationAdapter());
        put(new PathAdapter());
        put(new DeleteAdapter());
        put(new CartesianInsertAdapter());
        put(new PointwiseInsertAdapter());
        put(new CartesianUpdateAdapter());
        put(new PointwiseUpdateAdapter());
        put(new SelectAdapter());
        put(new ForAdapter());
        put(new IfAdapter());
        put(new DoAdapter());
        put(new StepExpressionAdapter());
        put(new EntityTemplateAdapter());
        put(new EntityCallAdapter());
        put(new CallAdapter());
        put(new ConstraintsAdapter());
        put(new ExpressionsAdapter());
        put(new BindingsAdapter());
        put(new BindAdapter());
        put(new ChooseAdapter());
        put(new BlockAdapter());
        put(new SequenceAdapter());
        put(new ScopeAdapter());
        put(new CartesianProductAdapter());
        put(new PointwiseProductAdapter());
        put(new FilterAdapter());
        put(new TraversalStepAdapter());
        put(new AspectStepAdapter());
        put(new DirectStepAdapter());
        put(new AdjacentStepAdapter());
        put(new ReachableStepAdapter());
        put(new ReachableOrSelfStepAdapter());
        put(new InverseStepAdapter());
        put(new InverseAdjacentStepAdapter());
        put(new InverseReachableStepAdapter());
        put(new InverseReachableOrSelfStepAdapter());
        put(new RootStepAdapter());
        put(new FragmentRootStepAdapter());
        put(new SelfStepAdapter());
        put(new ForwardStepAdapter());
        put(new FeatureStepAdapter());
        put(new ChildStepAdapter());
        put(new DescendantStepAdapter());
        put(new DescendantOrSelfStepAdapter());
        put(new FollowingSiblingStepAdapter());
        put(new FollowingStepAdapter());
        put(new ReverseStepAdapter());
        put(new ParentStepAdapter());
        put(new AncestorStepAdapter());
        put(new AncestorOrSelfStepAdapter());
        put(new PrecedingSiblingStepAdapter());
        put(new PrecedingStepAdapter());
        put(new MathStepAdapter());
        put(new AdditionStepAdapter());
        put(new SubtractionStepAdapter());
        put(new MultiplicationStepAdapter());
        put(new DivisionStepAdapter());
        put(new RemainderStepAdapter());
        put(new EqualsStepAdapter());
        put(new NotEqualsStepAdapter());
        put(new LessThanStepAdapter());
        put(new LessOrEqualsStepAdapter());
        put(new GreaterThanStepAdapter());
        put(new GreaterOrEqualsStepAdapter());
        put(new PruneOrPredicateAdapter());
        put(new PruneAdapter());
        put(new PredicateAdapter());
        put(new VariableTestAdapter());
        put(new IndexVariableTestAdapter());
        put(new KindTestAdapter());
        put(new StageTestAdapter());
        put(new StageVariableTestAdapter());
        put(new LanguageTestAdapter());
        put(new TypeTestAdapter());
        put(new SubtypeTestAdapter());
        put(new SupertypeTestAdapter());
        put(new ExtendedSubtypeTestAdapter());
        put(new ExtendedSupertypeTestAdapter());
        put(new AtTypeTestAdapter());
        put(new AtFeatureTestAdapter());
        put(new AtIndexTestAdapter());
        put(new IndexTestAdapter());
        put(new IndexRangeTestAdapter());
        put(new VisitorTestAdapter());
        put(new ExpressionTestAdapter());
        put(new DistinctTestAdapter());
        put(new AndAdapter());
        put(new OrAdapter());
        put(new NotAdapter());
        put(new QuantifiedPredicateAdapter());
        put(new OneAdapter());
        put(new SomeAdapter());
        put(new EveryAdapter());
        put(new ParenthesizedPredicateAdapter());
        put(new EntityTypeAdapter());
        put(new NamesExpressionAdapter());
        put(new TemplateNamesAdapter());
        put(new AllNamesAdapter());
        put(new AddNamesAdapter());
        put(new RemoveNamesAdapter());
        put(new NamesAdapter());
        put(new NameAdapter());
        put(new ExpressionAdapter());
        put(new CollectByExpressionAdapter());
        put(new ComparatorAdapter());
        put(new IdentityComparatorAdapter());
        put(new UnionAllAdapter());
        put(new UnionAdapter());
        put(new IntersectAdapter());
        put(new ExceptAdapter());
        put(new VariableRefStepAdapter());
        put(new SingletonAdapter());
        put(new PointwiseEqualsAdapter());
        put(new TupleAdapter());
        put(new AdditionAdapter());
        put(new SubtractionAdapter());
        put(new MultiplicationAdapter());
        put(new DivisionAdapter());
        put(new RemainderAdapter());
        put(new EqualsAdapter());
        put(new NotEqualsAdapter());
        put(new LessThanAdapter());
        put(new LessOrEqualsAdapter());
        put(new GreaterThanAdapter());
        put(new GreaterOrEqualsAdapter());
        put(new LiteralAdapter());
        put(new VoidLiteralAdapter());
        put(new BooleanLiteralAdapter());
        put(new ByteLiteralAdapter());
        put(new CharLiteralAdapter());
        put(new DoubleLiteralAdapter());
        put(new FloatLiteralAdapter());
        put(new IntLiteralAdapter());
        put(new LongLiteralAdapter());
        put(new ShortLiteralAdapter());
        put(new DateLiteralAdapter());
        put(new StringLiteralAdapter());
        put(new PlacementAdapter());
    }
}
