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
package org.whole.lang.queries.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class QueriesImplEntityRegistry extends AbstractEntityRegistry {

    public QueriesImplEntityRegistry() {
        super(QueriesEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new QueryDeclarationImpl());
        put(new PathImpl());
        put(new DeleteImpl());
        put(new CartesianInsertImpl());
        put(new PointwiseInsertImpl());
        put(new CartesianUpdateImpl());
        put(new PointwiseUpdateImpl());
        put(new SelectImpl());
        put(new ForImpl());
        put(new IfImpl());
        put(new DoImpl());
        put(new EntityTemplateImpl());
        put(new EntityCallImpl());
        put(new CallImpl());
        put(new ExpressionsImpl());
        put(new BindingsImpl());
        put(new BindImpl());
        put(new ChooseImpl());
        put(new BlockImpl());
        put(new SequenceImpl());
        put(new ScopeImpl());
        put(new CartesianProductImpl());
        put(new PointwiseProductImpl());
        put(new FilterImpl());
        put(new AspectStepImpl());
        put(new AdjacentStepImpl());
        put(new ReachableStepImpl());
        put(new ReachableOrSelfStepImpl());
        put(new InverseAdjacentStepImpl());
        put(new InverseReachableStepImpl());
        put(new InverseReachableOrSelfStepImpl());
        put(new RootStepImpl());
        put(new FragmentRootStepImpl());
        put(new SelfStepImpl());
        put(new FeatureStepImpl());
        put(new ChildStepImpl());
        put(new DescendantStepImpl());
        put(new DescendantOrSelfStepImpl());
        put(new FollowingSiblingStepImpl());
        put(new FollowingStepImpl());
        put(new ParentStepImpl());
        put(new AncestorStepImpl());
        put(new AncestorOrSelfStepImpl());
        put(new PrecedingSiblingStepImpl());
        put(new PrecedingStepImpl());
        put(new AdditionStepImpl());
        put(new SubtractionStepImpl());
        put(new MultiplicationStepImpl());
        put(new DivisionStepImpl());
        put(new RemainderStepImpl());
        put(new EqualsStepImpl());
        put(new NotEqualsStepImpl());
        put(new LessThanStepImpl());
        put(new LessOrEqualsStepImpl());
        put(new GreaterThanStepImpl());
        put(new GreaterOrEqualsStepImpl());
        put(new PruneImpl());
        put(new VariableTestImpl());
        put(new IndexVariableTestImpl());
        put(new KindTestImpl());
        put(new StageTestImpl());
        put(new StageVariableTestImpl());
        put(new LanguageTestImpl());
        put(new TypeTestImpl());
        put(new SubtypeTestImpl());
        put(new SupertypeTestImpl());
        put(new ExtendedSubtypeTestImpl());
        put(new ExtendedSupertypeTestImpl());
        put(new AtTypeTestImpl());
        put(new AtFeatureTestImpl());
        put(new AtIndexTestImpl());
        put(new IndexTestImpl());
        put(new IndexRangeTestImpl());
        put(new VisitorTestImpl());
        put(new ExpressionTestImpl());
        put(new DistinctTestImpl());
        put(new AndImpl());
        put(new OrImpl());
        put(new NotImpl());
        put(new OneImpl());
        put(new SomeImpl());
        put(new EveryImpl());
        put(new ParenthesizedPredicateImpl());
        put(new EntityTypeImpl());
        put(new TemplateNamesImpl());
        put(new AllNamesImpl());
        put(new AddNamesImpl());
        put(new RemoveNamesImpl());
        put(new NamesImpl());
        put(new NameImpl());
        put(new IdentityComparatorImpl());
        put(new UnionAllImpl());
        put(new UnionImpl());
        put(new IntersectImpl());
        put(new ExceptImpl());
        put(new VariableRefStepImpl());
        put(new SingletonImpl());
        put(new PointwiseEqualsImpl());
        put(new TupleImpl());
        put(new AdditionImpl());
        put(new SubtractionImpl());
        put(new MultiplicationImpl());
        put(new DivisionImpl());
        put(new RemainderImpl());
        put(new EqualsImpl());
        put(new NotEqualsImpl());
        put(new LessThanImpl());
        put(new LessOrEqualsImpl());
        put(new GreaterThanImpl());
        put(new GreaterOrEqualsImpl());
        put(new VoidLiteralImpl());
        put(new BooleanLiteralImpl());
        put(new ByteLiteralImpl());
        put(new CharLiteralImpl());
        put(new DoubleLiteralImpl());
        put(new FloatLiteralImpl());
        put(new IntLiteralImpl());
        put(new LongLiteralImpl());
        put(new ShortLiteralImpl());
        put(new DateLiteralImpl());
        put(new StringLiteralImpl());
        put(new PlacementImpl());
    }
}
