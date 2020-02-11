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
package org.whole.lang.queries.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.queries.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class QueriesEntityFactory extends GenericEntityFactory {
    public static final QueriesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static QueriesEntityFactory instance(IEntityRegistryProvider provider) {
        return new QueriesEntityFactory(provider);
    }

    protected QueriesEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public QueryDeclaration createQueryDeclaration() {
        return create(QueriesEntityDescriptorEnum.QueryDeclaration);
    }

    public QueryDeclaration createQueryDeclaration(Name name, Names parameters, Expression body) {
        return create(QueriesEntityDescriptorEnum.QueryDeclaration, name, parameters, body);
    }

    public IEntityBuilder<QueryDeclaration> buildQueryDeclaration() {
        return new EntityBuilder<QueryDeclaration>(create(QueriesEntityDescriptorEnum.QueryDeclaration));
    }

    public Path createPath() {
        return create(QueriesEntityDescriptorEnum.Path);
    }

    public Path createPath(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Path, (IEntity[]) entities);
    }

    public Path createPath(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Path, initialSize);
    }

    public Clone createClone() {
        return create(QueriesEntityDescriptorEnum.Clone);
    }

    public Clone createClone(Expression fromClause) {
        return create(QueriesEntityDescriptorEnum.Clone, fromClause);
    }

    public Create createCreate() {
        return create(QueriesEntityDescriptorEnum.Create);
    }

    public Create createCreate(Expression entityType, Expression registry, Expression whereClause) {
        return create(QueriesEntityDescriptorEnum.Create, entityType, registry, whereClause);
    }

    public IEntityBuilder<Create> buildCreate() {
        return new EntityBuilder<Create>(create(QueriesEntityDescriptorEnum.Create));
    }

    public Delete createDelete() {
        return create(QueriesEntityDescriptorEnum.Delete);
    }

    public Delete createDelete(Expression fromClause) {
        return create(QueriesEntityDescriptorEnum.Delete, fromClause);
    }

    public Insert createInsert() {
        return create(QueriesEntityDescriptorEnum.Insert);
    }

    public Insert createInsert(Placement placement, Expression fromClause) {
        return create(QueriesEntityDescriptorEnum.Insert, placement, fromClause);
    }

    public IEntityBuilder<Insert> buildInsert() {
        return new EntityBuilder<Insert>(create(QueriesEntityDescriptorEnum.Insert));
    }

    public CartesianInsert createCartesianInsert() {
        return create(QueriesEntityDescriptorEnum.CartesianInsert);
    }

    public CartesianInsert createCartesianInsert(Placement placement, Expression fromClause, Expression valuesClause) {
        return create(QueriesEntityDescriptorEnum.CartesianInsert, placement, fromClause, valuesClause);
    }

    public IEntityBuilder<CartesianInsert> buildCartesianInsert() {
        return new EntityBuilder<CartesianInsert>(create(QueriesEntityDescriptorEnum.CartesianInsert));
    }

    public PointwiseInsert createPointwiseInsert() {
        return create(QueriesEntityDescriptorEnum.PointwiseInsert);
    }

    public PointwiseInsert createPointwiseInsert(Placement placement, Expression fromClause, Expression valuesClause) {
        return create(QueriesEntityDescriptorEnum.PointwiseInsert, placement, fromClause, valuesClause);
    }

    public IEntityBuilder<PointwiseInsert> buildPointwiseInsert() {
        return new EntityBuilder<PointwiseInsert>(create(QueriesEntityDescriptorEnum.PointwiseInsert));
    }

    public Update createUpdate() {
        return create(QueriesEntityDescriptorEnum.Update);
    }

    public Update createUpdate(Expression fromClause) {
        return create(QueriesEntityDescriptorEnum.Update, fromClause);
    }

    public CartesianUpdate createCartesianUpdate() {
        return create(QueriesEntityDescriptorEnum.CartesianUpdate);
    }

    public CartesianUpdate createCartesianUpdate(Expression fromClause, Expression valuesClause) {
        return create(QueriesEntityDescriptorEnum.CartesianUpdate, fromClause, valuesClause);
    }

    public IEntityBuilder<CartesianUpdate> buildCartesianUpdate() {
        return new EntityBuilder<CartesianUpdate>(create(QueriesEntityDescriptorEnum.CartesianUpdate));
    }

    public PointwiseUpdate createPointwiseUpdate() {
        return create(QueriesEntityDescriptorEnum.PointwiseUpdate);
    }

    public PointwiseUpdate createPointwiseUpdate(Expression fromClause, Expression valuesClause) {
        return create(QueriesEntityDescriptorEnum.PointwiseUpdate, fromClause, valuesClause);
    }

    public IEntityBuilder<PointwiseUpdate> buildPointwiseUpdate() {
        return new EntityBuilder<PointwiseUpdate>(create(QueriesEntityDescriptorEnum.PointwiseUpdate));
    }

    public Select createSelect() {
        return create(QueriesEntityDescriptorEnum.Select);
    }

    public Select createSelect(Expression selectClause, Expression fromClause, Expression whereClause, NamesExpression clearClause) {
        return create(QueriesEntityDescriptorEnum.Select, selectClause, fromClause, whereClause, clearClause);
    }

    public IEntityBuilder<Select> buildSelect() {
        return new EntityBuilder<Select>(create(QueriesEntityDescriptorEnum.Select));
    }

    public For createFor() {
        return create(QueriesEntityDescriptorEnum.For);
    }

    public For createFor(Expression fromClause, Expression expression) {
        return create(QueriesEntityDescriptorEnum.For, fromClause, expression);
    }

    public IEntityBuilder<For> buildFor() {
        return new EntityBuilder<For>(create(QueriesEntityDescriptorEnum.For));
    }

    public If createIf() {
        return create(QueriesEntityDescriptorEnum.If);
    }

    public If createIf(Expression predicate, Expression expression) {
        return create(QueriesEntityDescriptorEnum.If, predicate, expression);
    }

    public IEntityBuilder<If> buildIf() {
        return new EntityBuilder<If>(create(QueriesEntityDescriptorEnum.If));
    }

    public Do createDo() {
        return create(QueriesEntityDescriptorEnum.Do);
    }

    public Do createDo(Expression expression) {
        return create(QueriesEntityDescriptorEnum.Do, expression);
    }

    public Call createCall() {
        return create(QueriesEntityDescriptorEnum.Call);
    }

    public Call createCall(Name name, Expressions arguments) {
        return create(QueriesEntityDescriptorEnum.Call, name, arguments);
    }

    public IEntityBuilder<Call> buildCall() {
        return new EntityBuilder<Call>(create(QueriesEntityDescriptorEnum.Call));
    }

    public Expressions createExpressions() {
        return create(QueriesEntityDescriptorEnum.Expressions);
    }

    public Expressions createExpressions(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Expressions, (IEntity[]) entities);
    }

    public Expressions createExpressions(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Expressions, initialSize);
    }

    public Choose createChoose() {
        return create(QueriesEntityDescriptorEnum.Choose);
    }

    public Choose createChoose(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Choose, (IEntity[]) entities);
    }

    public Choose createChoose(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Choose, initialSize);
    }

    public Block createBlock() {
        return create(QueriesEntityDescriptorEnum.Block);
    }

    public Block createBlock(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Block, (IEntity[]) entities);
    }

    public Block createBlock(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Block, initialSize);
    }

    public Sequence createSequence() {
        return create(QueriesEntityDescriptorEnum.Sequence);
    }

    public Sequence createSequence(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Sequence, (IEntity[]) entities);
    }

    public Sequence createSequence(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Sequence, initialSize);
    }

    public Scope createScope() {
        return create(QueriesEntityDescriptorEnum.Scope);
    }

    public Scope createScope(ScopeFilter localNames, Expression expression) {
        return create(QueriesEntityDescriptorEnum.Scope, localNames, expression);
    }

    public IEntityBuilder<Scope> buildScope() {
        return new EntityBuilder<Scope>(create(QueriesEntityDescriptorEnum.Scope));
    }

    public CartesianProduct createCartesianProduct() {
        return create(QueriesEntityDescriptorEnum.CartesianProduct);
    }

    public CartesianProduct createCartesianProduct(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.CartesianProduct, (IEntity[]) entities);
    }

    public CartesianProduct createCartesianProduct(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.CartesianProduct, initialSize);
    }

    public PointwiseProduct createPointwiseProduct() {
        return create(QueriesEntityDescriptorEnum.PointwiseProduct);
    }

    public PointwiseProduct createPointwiseProduct(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.PointwiseProduct, (IEntity[]) entities);
    }

    public PointwiseProduct createPointwiseProduct(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.PointwiseProduct, initialSize);
    }

    public Filter createFilter() {
        return create(QueriesEntityDescriptorEnum.Filter);
    }

    public Filter createFilter(Expression expression, PruneOrPredicate predicate) {
        return create(QueriesEntityDescriptorEnum.Filter, expression, predicate);
    }

    public IEntityBuilder<Filter> buildFilter() {
        return new EntityBuilder<Filter>(create(QueriesEntityDescriptorEnum.Filter));
    }

    public Reverse createReverse() {
        return create(QueriesEntityDescriptorEnum.Reverse);
    }

    public Reverse createReverse(ReversibleStep expression) {
        return create(QueriesEntityDescriptorEnum.Reverse, expression);
    }

    public AspectStep createAspectStep() {
        return create(QueriesEntityDescriptorEnum.AspectStep);
    }

    public AdjacentStep createAdjacentStep() {
        return create(QueriesEntityDescriptorEnum.AdjacentStep);
    }

    public ReachableStep createReachableStep() {
        return create(QueriesEntityDescriptorEnum.ReachableStep);
    }

    public ReachableOrSelfStep createReachableOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.ReachableOrSelfStep);
    }

    public InverseAdjacentStep createInverseAdjacentStep() {
        return create(QueriesEntityDescriptorEnum.InverseAdjacentStep);
    }

    public InverseReachableStep createInverseReachableStep() {
        return create(QueriesEntityDescriptorEnum.InverseReachableStep);
    }

    public InverseReachableOrSelfStep createInverseReachableOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.InverseReachableOrSelfStep);
    }

    public RootStep createRootStep() {
        return create(QueriesEntityDescriptorEnum.RootStep);
    }

    public FragmentRootStep createFragmentRootStep() {
        return create(QueriesEntityDescriptorEnum.FragmentRootStep);
    }

    public SelfStep createSelfStep() {
        return create(QueriesEntityDescriptorEnum.SelfStep);
    }

    public FeatureStep createFeatureStep() {
        return create(QueriesEntityDescriptorEnum.FeatureStep);
    }

    public FeatureStep createFeatureStep(String value) {
        return create(QueriesEntityDescriptorEnum.FeatureStep, value);
    }

    public ChildStep createChildStep() {
        return create(QueriesEntityDescriptorEnum.ChildStep);
    }

    public DescendantStep createDescendantStep() {
        return create(QueriesEntityDescriptorEnum.DescendantStep);
    }

    public DescendantOrSelfStep createDescendantOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.DescendantOrSelfStep);
    }

    public FollowingSiblingStep createFollowingSiblingStep() {
        return create(QueriesEntityDescriptorEnum.FollowingSiblingStep);
    }

    public FollowingSiblingOrSelfStep createFollowingSiblingOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.FollowingSiblingOrSelfStep);
    }

    public FollowingStep createFollowingStep() {
        return create(QueriesEntityDescriptorEnum.FollowingStep);
    }

    public FollowingOrSelfStep createFollowingOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.FollowingOrSelfStep);
    }

    public ParentStep createParentStep() {
        return create(QueriesEntityDescriptorEnum.ParentStep);
    }

    public AncestorStep createAncestorStep() {
        return create(QueriesEntityDescriptorEnum.AncestorStep);
    }

    public AncestorOrSelfStep createAncestorOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.AncestorOrSelfStep);
    }

    public PrecedingSiblingStep createPrecedingSiblingStep() {
        return create(QueriesEntityDescriptorEnum.PrecedingSiblingStep);
    }

    public PrecedingSiblingOrSelfStep createPrecedingSiblingOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.PrecedingSiblingOrSelfStep);
    }

    public PrecedingStep createPrecedingStep() {
        return create(QueriesEntityDescriptorEnum.PrecedingStep);
    }

    public PrecedingOrSelfStep createPrecedingOrSelfStep() {
        return create(QueriesEntityDescriptorEnum.PrecedingOrSelfStep);
    }

    public Prune createPrune() {
        return create(QueriesEntityDescriptorEnum.Prune);
    }

    public Prune createPrune(Expression predicate) {
        return create(QueriesEntityDescriptorEnum.Prune, predicate);
    }

    public VariableTest createVariableTest() {
        return create(QueriesEntityDescriptorEnum.VariableTest);
    }

    public VariableTest createVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.VariableTest, value);
    }

    public StageVariableTest createStageVariableTest() {
        return create(QueriesEntityDescriptorEnum.StageVariableTest);
    }

    public StageVariableTest createStageVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.StageVariableTest, value);
    }

    public LanguageVariableTest createLanguageVariableTest() {
        return create(QueriesEntityDescriptorEnum.LanguageVariableTest);
    }

    public LanguageVariableTest createLanguageVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.LanguageVariableTest, value);
    }

    public TypeVariableTest createTypeVariableTest() {
        return create(QueriesEntityDescriptorEnum.TypeVariableTest);
    }

    public TypeVariableTest createTypeVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.TypeVariableTest, value);
    }

    public SubtypeVariableTest createSubtypeVariableTest() {
        return create(QueriesEntityDescriptorEnum.SubtypeVariableTest);
    }

    public SubtypeVariableTest createSubtypeVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.SubtypeVariableTest, value);
    }

    public SupertypeVariableTest createSupertypeVariableTest() {
        return create(QueriesEntityDescriptorEnum.SupertypeVariableTest);
    }

    public SupertypeVariableTest createSupertypeVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.SupertypeVariableTest, value);
    }

    public ExtendedSubtypeVariableTest createExtendedSubtypeVariableTest() {
        return create(QueriesEntityDescriptorEnum.ExtendedSubtypeVariableTest);
    }

    public ExtendedSubtypeVariableTest createExtendedSubtypeVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.ExtendedSubtypeVariableTest, value);
    }

    public ExtendedSupertypeVariableTest createExtendedSupertypeVariableTest() {
        return create(QueriesEntityDescriptorEnum.ExtendedSupertypeVariableTest);
    }

    public ExtendedSupertypeVariableTest createExtendedSupertypeVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.ExtendedSupertypeVariableTest, value);
    }

    public IndexVariableTest createIndexVariableTest() {
        return create(QueriesEntityDescriptorEnum.IndexVariableTest);
    }

    public IndexVariableTest createIndexVariableTest(String value) {
        return create(QueriesEntityDescriptorEnum.IndexVariableTest, value);
    }

    public KindTest createKindTest() {
        return create(QueriesEntityDescriptorEnum.KindTest);
    }

    public KindTest createKindTest(KindTestEnum.Value value) {
        return create(QueriesEntityDescriptorEnum.KindTest, value);
    }

    public CompositeKindTest createCompositeKindTest() {
        return create(QueriesEntityDescriptorEnum.CompositeKindTest);
    }

    public CompositeKindTest createCompositeKindTest(CompositeKindTestEnum.Value value) {
        return create(QueriesEntityDescriptorEnum.CompositeKindTest, value);
    }

    public DataKindTest createDataKindTest() {
        return create(QueriesEntityDescriptorEnum.DataKindTest);
    }

    public DataKindTest createDataKindTest(DataKindTestEnum.Value value) {
        return create(QueriesEntityDescriptorEnum.DataKindTest, value);
    }

    public StageTest createStageTest() {
        return create(QueriesEntityDescriptorEnum.StageTest);
    }

    public StageTest createStageTest(StageTestEnum.Value value) {
        return create(QueriesEntityDescriptorEnum.StageTest, value);
    }

    public LanguageTest createLanguageTest() {
        return create(QueriesEntityDescriptorEnum.LanguageTest);
    }

    public LanguageTest createLanguageTest(String value) {
        return create(QueriesEntityDescriptorEnum.LanguageTest, value);
    }

    public TypeTest createTypeTest() {
        return create(QueriesEntityDescriptorEnum.TypeTest);
    }

    public TypeTest createTypeTest(String value) {
        return create(QueriesEntityDescriptorEnum.TypeTest, value);
    }

    public SubtypeTest createSubtypeTest() {
        return create(QueriesEntityDescriptorEnum.SubtypeTest);
    }

    public SubtypeTest createSubtypeTest(String value) {
        return create(QueriesEntityDescriptorEnum.SubtypeTest, value);
    }

    public SupertypeTest createSupertypeTest() {
        return create(QueriesEntityDescriptorEnum.SupertypeTest);
    }

    public SupertypeTest createSupertypeTest(String value) {
        return create(QueriesEntityDescriptorEnum.SupertypeTest, value);
    }

    public ExtendedSubtypeTest createExtendedSubtypeTest() {
        return create(QueriesEntityDescriptorEnum.ExtendedSubtypeTest);
    }

    public ExtendedSubtypeTest createExtendedSubtypeTest(String value) {
        return create(QueriesEntityDescriptorEnum.ExtendedSubtypeTest, value);
    }

    public ExtendedSupertypeTest createExtendedSupertypeTest() {
        return create(QueriesEntityDescriptorEnum.ExtendedSupertypeTest);
    }

    public ExtendedSupertypeTest createExtendedSupertypeTest(String value) {
        return create(QueriesEntityDescriptorEnum.ExtendedSupertypeTest, value);
    }

    public AtTypeTest createAtTypeTest() {
        return create(QueriesEntityDescriptorEnum.AtTypeTest);
    }

    public AtTypeTest createAtTypeTest(String value) {
        return create(QueriesEntityDescriptorEnum.AtTypeTest, value);
    }

    public AtFeatureTest createAtFeatureTest() {
        return create(QueriesEntityDescriptorEnum.AtFeatureTest);
    }

    public AtFeatureTest createAtFeatureTest(String value) {
        return create(QueriesEntityDescriptorEnum.AtFeatureTest, value);
    }

    public AtIndexTest createAtIndexTest() {
        return create(QueriesEntityDescriptorEnum.AtIndexTest);
    }

    public AtIndexTest createAtIndexTest(IntLiteral index) {
        return create(QueriesEntityDescriptorEnum.AtIndexTest, index);
    }

    public IndexTest createIndexTest() {
        return create(QueriesEntityDescriptorEnum.IndexTest);
    }

    public IndexTest createIndexTest(IntLiteral index) {
        return create(QueriesEntityDescriptorEnum.IndexTest, index);
    }

    public IndexRangeTest createIndexRangeTest() {
        return create(QueriesEntityDescriptorEnum.IndexRangeTest);
    }

    public IndexRangeTest createIndexRangeTest(IntLiteral startIndex, IntLiteral endIndex) {
        return create(QueriesEntityDescriptorEnum.IndexRangeTest, startIndex, endIndex);
    }

    public IEntityBuilder<IndexRangeTest> buildIndexRangeTest() {
        return new EntityBuilder<IndexRangeTest>(create(QueriesEntityDescriptorEnum.IndexRangeTest));
    }

    public VisitorTest createVisitorTest() {
        return create(QueriesEntityDescriptorEnum.VisitorTest);
    }

    public VisitorTest createVisitorTest(org.whole.lang.visitors.IVisitor value) {
        return create(QueriesEntityDescriptorEnum.VisitorTest, (java.lang.Object) value);
    }

    public MatchTest createMatchTest() {
        return create(QueriesEntityDescriptorEnum.MatchTest);
    }

    public MatchTest createMatchTest(Expression expression) {
        return create(QueriesEntityDescriptorEnum.MatchTest, expression);
    }

    public DistinctTest createDistinctTest() {
        return create(QueriesEntityDescriptorEnum.DistinctTest);
    }

    public DistinctTest createDistinctTest(Comparator comparator) {
        return create(QueriesEntityDescriptorEnum.DistinctTest, comparator);
    }

    public And createAnd() {
        return create(QueriesEntityDescriptorEnum.And);
    }

    public And createAnd(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.And, (IEntity[]) entities);
    }

    public And createAnd(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.And, initialSize);
    }

    public Or createOr() {
        return create(QueriesEntityDescriptorEnum.Or);
    }

    public Or createOr(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Or, (IEntity[]) entities);
    }

    public Or createOr(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Or, initialSize);
    }

    public Not createNot() {
        return create(QueriesEntityDescriptorEnum.Not);
    }

    public Not createNot(Expression predicate) {
        return create(QueriesEntityDescriptorEnum.Not, predicate);
    }

    public One createOne() {
        return create(QueriesEntityDescriptorEnum.One);
    }

    public One createOne(Expression fromClause, Expression whereClause) {
        return create(QueriesEntityDescriptorEnum.One, fromClause, whereClause);
    }

    public IEntityBuilder<One> buildOne() {
        return new EntityBuilder<One>(create(QueriesEntityDescriptorEnum.One));
    }

    public Some createSome() {
        return create(QueriesEntityDescriptorEnum.Some);
    }

    public Some createSome(Expression fromClause, Expression whereClause) {
        return create(QueriesEntityDescriptorEnum.Some, fromClause, whereClause);
    }

    public IEntityBuilder<Some> buildSome() {
        return new EntityBuilder<Some>(create(QueriesEntityDescriptorEnum.Some));
    }

    public Every createEvery() {
        return create(QueriesEntityDescriptorEnum.Every);
    }

    public Every createEvery(Expression fromClause, Expression whereClause) {
        return create(QueriesEntityDescriptorEnum.Every, fromClause, whereClause);
    }

    public IEntityBuilder<Every> buildEvery() {
        return new EntityBuilder<Every>(create(QueriesEntityDescriptorEnum.Every));
    }

    public TemplateNames createTemplateNames() {
        return create(QueriesEntityDescriptorEnum.TemplateNames);
    }

    public AllNames createAllNames() {
        return create(QueriesEntityDescriptorEnum.AllNames);
    }

    public AddNames createAddNames() {
        return create(QueriesEntityDescriptorEnum.AddNames);
    }

    public AddNames createAddNames(NamesExpression expression, Names names) {
        return create(QueriesEntityDescriptorEnum.AddNames, expression, names);
    }

    public IEntityBuilder<AddNames> buildAddNames() {
        return new EntityBuilder<AddNames>(create(QueriesEntityDescriptorEnum.AddNames));
    }

    public RemoveNames createRemoveNames() {
        return create(QueriesEntityDescriptorEnum.RemoveNames);
    }

    public RemoveNames createRemoveNames(NamesExpression expression, Names names) {
        return create(QueriesEntityDescriptorEnum.RemoveNames, expression, names);
    }

    public IEntityBuilder<RemoveNames> buildRemoveNames() {
        return new EntityBuilder<RemoveNames>(create(QueriesEntityDescriptorEnum.RemoveNames));
    }

    public Names createNames() {
        return create(QueriesEntityDescriptorEnum.Names);
    }

    public Names createNames(Name... entities) {
        return create(QueriesEntityDescriptorEnum.Names, (IEntity[]) entities);
    }

    public Names createNames(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Names, initialSize);
    }

    public FreshNames createFreshNames() {
        return create(QueriesEntityDescriptorEnum.FreshNames);
    }

    public FreshNames createFreshNames(Name... entities) {
        return create(QueriesEntityDescriptorEnum.FreshNames, (IEntity[]) entities);
    }

    public FreshNames createFreshNames(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.FreshNames, initialSize);
    }

    public ScopeNames createScopeNames() {
        return create(QueriesEntityDescriptorEnum.ScopeNames);
    }

    public ScopeNames createScopeNames(Name... entities) {
        return create(QueriesEntityDescriptorEnum.ScopeNames, (IEntity[]) entities);
    }

    public ScopeNames createScopeNames(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.ScopeNames, initialSize);
    }

    public Name createName() {
        return create(QueriesEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(QueriesEntityDescriptorEnum.Name, value);
    }

    public AdditionStep createAdditionStep() {
        return create(QueriesEntityDescriptorEnum.AdditionStep);
    }

    public AdditionStep createAdditionStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.AdditionStep, expression);
    }

    public SubtractionStep createSubtractionStep() {
        return create(QueriesEntityDescriptorEnum.SubtractionStep);
    }

    public SubtractionStep createSubtractionStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.SubtractionStep, expression);
    }

    public MultiplicationStep createMultiplicationStep() {
        return create(QueriesEntityDescriptorEnum.MultiplicationStep);
    }

    public MultiplicationStep createMultiplicationStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.MultiplicationStep, expression);
    }

    public DivisionStep createDivisionStep() {
        return create(QueriesEntityDescriptorEnum.DivisionStep);
    }

    public DivisionStep createDivisionStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.DivisionStep, expression);
    }

    public RemainderStep createRemainderStep() {
        return create(QueriesEntityDescriptorEnum.RemainderStep);
    }

    public RemainderStep createRemainderStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.RemainderStep, expression);
    }

    public EqualsStep createEqualsStep() {
        return create(QueriesEntityDescriptorEnum.EqualsStep);
    }

    public EqualsStep createEqualsStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.EqualsStep, expression);
    }

    public NotEqualsStep createNotEqualsStep() {
        return create(QueriesEntityDescriptorEnum.NotEqualsStep);
    }

    public NotEqualsStep createNotEqualsStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.NotEqualsStep, expression);
    }

    public LessThanStep createLessThanStep() {
        return create(QueriesEntityDescriptorEnum.LessThanStep);
    }

    public LessThanStep createLessThanStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.LessThanStep, expression);
    }

    public LessOrEqualsStep createLessOrEqualsStep() {
        return create(QueriesEntityDescriptorEnum.LessOrEqualsStep);
    }

    public LessOrEqualsStep createLessOrEqualsStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.LessOrEqualsStep, expression);
    }

    public GreaterThanStep createGreaterThanStep() {
        return create(QueriesEntityDescriptorEnum.GreaterThanStep);
    }

    public GreaterThanStep createGreaterThanStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.GreaterThanStep, expression);
    }

    public GreaterOrEqualsStep createGreaterOrEqualsStep() {
        return create(QueriesEntityDescriptorEnum.GreaterOrEqualsStep);
    }

    public GreaterOrEqualsStep createGreaterOrEqualsStep(Expression expression) {
        return create(QueriesEntityDescriptorEnum.GreaterOrEqualsStep, expression);
    }

    public IdentityComparator createIdentityComparator() {
        return create(QueriesEntityDescriptorEnum.IdentityComparator);
    }

    public IdentityComparator createIdentityComparator(Expression identity) {
        return create(QueriesEntityDescriptorEnum.IdentityComparator, identity);
    }

    public UnionAll createUnionAll() {
        return create(QueriesEntityDescriptorEnum.UnionAll);
    }

    public UnionAll createUnionAll(Expressions expressions) {
        return create(QueriesEntityDescriptorEnum.UnionAll, expressions);
    }

    public Union createUnion() {
        return create(QueriesEntityDescriptorEnum.Union);
    }

    public Union createUnion(Expressions expressions, Comparator comparator) {
        return create(QueriesEntityDescriptorEnum.Union, expressions, comparator);
    }

    public IEntityBuilder<Union> buildUnion() {
        return new EntityBuilder<Union>(create(QueriesEntityDescriptorEnum.Union));
    }

    public Intersect createIntersect() {
        return create(QueriesEntityDescriptorEnum.Intersect);
    }

    public Intersect createIntersect(Expressions expressions, Comparator comparator) {
        return create(QueriesEntityDescriptorEnum.Intersect, expressions, comparator);
    }

    public IEntityBuilder<Intersect> buildIntersect() {
        return new EntityBuilder<Intersect>(create(QueriesEntityDescriptorEnum.Intersect));
    }

    public Except createExcept() {
        return create(QueriesEntityDescriptorEnum.Except);
    }

    public Except createExcept(Expressions expressions, Comparator comparator) {
        return create(QueriesEntityDescriptorEnum.Except, expressions, comparator);
    }

    public IEntityBuilder<Except> buildExcept() {
        return new EntityBuilder<Except>(create(QueriesEntityDescriptorEnum.Except));
    }

    public VariableRefStep createVariableRefStep() {
        return create(QueriesEntityDescriptorEnum.VariableRefStep);
    }

    public VariableRefStep createVariableRefStep(String value) {
        return create(QueriesEntityDescriptorEnum.VariableRefStep, value);
    }

    public Singleton createSingleton() {
        return create(QueriesEntityDescriptorEnum.Singleton);
    }

    public Singleton createSingleton(Expression expression) {
        return create(QueriesEntityDescriptorEnum.Singleton, expression);
    }

    public PointwiseEquals createPointwiseEquals() {
        return create(QueriesEntityDescriptorEnum.PointwiseEquals);
    }

    public PointwiseEquals createPointwiseEquals(Expression pexp1, Expression pexp2) {
        return create(QueriesEntityDescriptorEnum.PointwiseEquals, pexp1, pexp2);
    }

    public IEntityBuilder<PointwiseEquals> buildPointwiseEquals() {
        return new EntityBuilder<PointwiseEquals>(create(QueriesEntityDescriptorEnum.PointwiseEquals));
    }

    public Tuple createTuple() {
        return create(QueriesEntityDescriptorEnum.Tuple);
    }

    public Tuple createTuple(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Tuple, (IEntity[]) entities);
    }

    public Tuple createTuple(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Tuple, initialSize);
    }

    public Addition createAddition() {
        return create(QueriesEntityDescriptorEnum.Addition);
    }

    public Addition createAddition(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.Addition, exp1, exp2);
    }

    public IEntityBuilder<Addition> buildAddition() {
        return new EntityBuilder<Addition>(create(QueriesEntityDescriptorEnum.Addition));
    }

    public Subtraction createSubtraction() {
        return create(QueriesEntityDescriptorEnum.Subtraction);
    }

    public Subtraction createSubtraction(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.Subtraction, exp1, exp2);
    }

    public IEntityBuilder<Subtraction> buildSubtraction() {
        return new EntityBuilder<Subtraction>(create(QueriesEntityDescriptorEnum.Subtraction));
    }

    public Multiplication createMultiplication() {
        return create(QueriesEntityDescriptorEnum.Multiplication);
    }

    public Multiplication createMultiplication(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.Multiplication, exp1, exp2);
    }

    public IEntityBuilder<Multiplication> buildMultiplication() {
        return new EntityBuilder<Multiplication>(create(QueriesEntityDescriptorEnum.Multiplication));
    }

    public Division createDivision() {
        return create(QueriesEntityDescriptorEnum.Division);
    }

    public Division createDivision(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.Division, exp1, exp2);
    }

    public IEntityBuilder<Division> buildDivision() {
        return new EntityBuilder<Division>(create(QueriesEntityDescriptorEnum.Division));
    }

    public Remainder createRemainder() {
        return create(QueriesEntityDescriptorEnum.Remainder);
    }

    public Remainder createRemainder(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.Remainder, exp1, exp2);
    }

    public IEntityBuilder<Remainder> buildRemainder() {
        return new EntityBuilder<Remainder>(create(QueriesEntityDescriptorEnum.Remainder));
    }

    public Equals createEquals() {
        return create(QueriesEntityDescriptorEnum.Equals);
    }

    public Equals createEquals(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.Equals, exp1, exp2);
    }

    public IEntityBuilder<Equals> buildEquals() {
        return new EntityBuilder<Equals>(create(QueriesEntityDescriptorEnum.Equals));
    }

    public NotEquals createNotEquals() {
        return create(QueriesEntityDescriptorEnum.NotEquals);
    }

    public NotEquals createNotEquals(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.NotEquals, exp1, exp2);
    }

    public IEntityBuilder<NotEquals> buildNotEquals() {
        return new EntityBuilder<NotEquals>(create(QueriesEntityDescriptorEnum.NotEquals));
    }

    public LessThan createLessThan() {
        return create(QueriesEntityDescriptorEnum.LessThan);
    }

    public LessThan createLessThan(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.LessThan, exp1, exp2);
    }

    public IEntityBuilder<LessThan> buildLessThan() {
        return new EntityBuilder<LessThan>(create(QueriesEntityDescriptorEnum.LessThan));
    }

    public LessOrEquals createLessOrEquals() {
        return create(QueriesEntityDescriptorEnum.LessOrEquals);
    }

    public LessOrEquals createLessOrEquals(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.LessOrEquals, exp1, exp2);
    }

    public IEntityBuilder<LessOrEquals> buildLessOrEquals() {
        return new EntityBuilder<LessOrEquals>(create(QueriesEntityDescriptorEnum.LessOrEquals));
    }

    public GreaterThan createGreaterThan() {
        return create(QueriesEntityDescriptorEnum.GreaterThan);
    }

    public GreaterThan createGreaterThan(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.GreaterThan, exp1, exp2);
    }

    public IEntityBuilder<GreaterThan> buildGreaterThan() {
        return new EntityBuilder<GreaterThan>(create(QueriesEntityDescriptorEnum.GreaterThan));
    }

    public GreaterOrEquals createGreaterOrEquals() {
        return create(QueriesEntityDescriptorEnum.GreaterOrEquals);
    }

    public GreaterOrEquals createGreaterOrEquals(Expression exp1, Expression exp2) {
        return create(QueriesEntityDescriptorEnum.GreaterOrEquals, exp1, exp2);
    }

    public IEntityBuilder<GreaterOrEquals> buildGreaterOrEquals() {
        return new EntityBuilder<GreaterOrEquals>(create(QueriesEntityDescriptorEnum.GreaterOrEquals));
    }

    public EntityType createEntityType() {
        return create(QueriesEntityDescriptorEnum.EntityType);
    }

    public EntityType createEntityType(String value) {
        return create(QueriesEntityDescriptorEnum.EntityType, value);
    }

    public Registry createRegistry() {
        return create(QueriesEntityDescriptorEnum.Registry);
    }

    public Registry createRegistry(RegistryEnum.Value value) {
        return create(QueriesEntityDescriptorEnum.Registry, value);
    }

    public Children createChildren() {
        return create(QueriesEntityDescriptorEnum.Children);
    }

    public Children createChildren(Expression... entities) {
        return create(QueriesEntityDescriptorEnum.Children, (IEntity[]) entities);
    }

    public Children createChildren(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Children, initialSize);
    }

    public Features createFeatures() {
        return create(QueriesEntityDescriptorEnum.Features);
    }

    public Features createFeatures(Feature... entities) {
        return create(QueriesEntityDescriptorEnum.Features, (IEntity[]) entities);
    }

    public Features createFeatures(int initialSize) {
        return clone(QueriesEntityDescriptorEnum.Features, initialSize);
    }

    public Feature createFeature() {
        return create(QueriesEntityDescriptorEnum.Feature);
    }

    public Feature createFeature(Name name, Expression value) {
        return create(QueriesEntityDescriptorEnum.Feature, name, value);
    }

    public IEntityBuilder<Feature> buildFeature() {
        return new EntityBuilder<Feature>(create(QueriesEntityDescriptorEnum.Feature));
    }

    public VoidLiteral createVoidLiteral() {
        return create(QueriesEntityDescriptorEnum.VoidLiteral);
    }

    public BooleanLiteral createBooleanLiteral() {
        return create(QueriesEntityDescriptorEnum.BooleanLiteral);
    }

    public BooleanLiteral createBooleanLiteral(boolean value) {
        return create(QueriesEntityDescriptorEnum.BooleanLiteral, value);
    }

    public ByteLiteral createByteLiteral() {
        return create(QueriesEntityDescriptorEnum.ByteLiteral);
    }

    public ByteLiteral createByteLiteral(byte value) {
        return create(QueriesEntityDescriptorEnum.ByteLiteral, value);
    }

    public CharLiteral createCharLiteral() {
        return create(QueriesEntityDescriptorEnum.CharLiteral);
    }

    public CharLiteral createCharLiteral(char value) {
        return create(QueriesEntityDescriptorEnum.CharLiteral, value);
    }

    public DoubleLiteral createDoubleLiteral() {
        return create(QueriesEntityDescriptorEnum.DoubleLiteral);
    }

    public DoubleLiteral createDoubleLiteral(double value) {
        return create(QueriesEntityDescriptorEnum.DoubleLiteral, value);
    }

    public FloatLiteral createFloatLiteral() {
        return create(QueriesEntityDescriptorEnum.FloatLiteral);
    }

    public FloatLiteral createFloatLiteral(float value) {
        return create(QueriesEntityDescriptorEnum.FloatLiteral, value);
    }

    public IntLiteral createIntLiteral() {
        return create(QueriesEntityDescriptorEnum.IntLiteral);
    }

    public IntLiteral createIntLiteral(int value) {
        return create(QueriesEntityDescriptorEnum.IntLiteral, value);
    }

    public LongLiteral createLongLiteral() {
        return create(QueriesEntityDescriptorEnum.LongLiteral);
    }

    public LongLiteral createLongLiteral(long value) {
        return create(QueriesEntityDescriptorEnum.LongLiteral, value);
    }

    public ShortLiteral createShortLiteral() {
        return create(QueriesEntityDescriptorEnum.ShortLiteral);
    }

    public ShortLiteral createShortLiteral(short value) {
        return create(QueriesEntityDescriptorEnum.ShortLiteral, value);
    }

    public DateLiteral createDateLiteral() {
        return create(QueriesEntityDescriptorEnum.DateLiteral);
    }

    public DateLiteral createDateLiteral(java.util.Date value) {
        return create(QueriesEntityDescriptorEnum.DateLiteral, value);
    }

    public StringLiteral createStringLiteral() {
        return create(QueriesEntityDescriptorEnum.StringLiteral);
    }

    public StringLiteral createStringLiteral(String value) {
        return create(QueriesEntityDescriptorEnum.StringLiteral, value);
    }

    public Placement createPlacement() {
        return create(QueriesEntityDescriptorEnum.Placement);
    }

    public Placement createPlacement(PlacementEnum.Value value) {
        return create(QueriesEntityDescriptorEnum.Placement, value);
    }
}
