package org.whole.lang.queries.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/** 
 * @generator Whole
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
