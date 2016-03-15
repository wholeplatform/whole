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
package org.whole.lang.queries.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.model.KindTestEnum;
import org.whole.lang.queries.model.StageTestEnum;
import org.whole.lang.visitors.IVisitor;
import java.util.Date;
import org.whole.lang.queries.model.PlacementEnum;

/**
 *  @generator Whole
 */
public class QueriesSpecificBuilderAdapter extends GenericBuilderContext implements IQueriesBuilder {

    public QueriesSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public QueriesSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void exp2() {
        wFeature(QueriesFeatureDescriptorEnum.exp2);
    }

    public void exp1() {
        wFeature(QueriesFeatureDescriptorEnum.exp1);
    }

    public void pexp2() {
        wFeature(QueriesFeatureDescriptorEnum.pexp2);
    }

    public void pexp1() {
        wFeature(QueriesFeatureDescriptorEnum.pexp1);
    }

    public void identity() {
        wFeature(QueriesFeatureDescriptorEnum.identity);
    }

    public void expressions() {
        wFeature(QueriesFeatureDescriptorEnum.expressions);
    }

    public void names() {
        wFeature(QueriesFeatureDescriptorEnum.names);
    }

    public void comparator() {
        wFeature(QueriesFeatureDescriptorEnum.comparator);
    }

    public void endIndex() {
        wFeature(QueriesFeatureDescriptorEnum.endIndex);
    }

    public void startIndex() {
        wFeature(QueriesFeatureDescriptorEnum.startIndex);
    }

    public void index() {
        wFeature(QueriesFeatureDescriptorEnum.index);
    }

    public void localNames() {
        wFeature(QueriesFeatureDescriptorEnum.localNames);
    }

    public void arguments() {
        wFeature(QueriesFeatureDescriptorEnum.arguments);
    }

    public void bindings() {
        wFeature(QueriesFeatureDescriptorEnum.bindings);
    }

    public void constraints() {
        wFeature(QueriesFeatureDescriptorEnum.constraints);
    }

    public void predicate() {
        wFeature(QueriesFeatureDescriptorEnum.predicate);
    }

    public void expression() {
        wFeature(QueriesFeatureDescriptorEnum.expression);
    }

    public void clearClause() {
        wFeature(QueriesFeatureDescriptorEnum.clearClause);
    }

    public void whereClause() {
        wFeature(QueriesFeatureDescriptorEnum.whereClause);
    }

    public void selectClause() {
        wFeature(QueriesFeatureDescriptorEnum.selectClause);
    }

    public void valuesClause() {
        wFeature(QueriesFeatureDescriptorEnum.valuesClause);
    }

    public void placement() {
        wFeature(QueriesFeatureDescriptorEnum.placement);
    }

    public void fromClause() {
        wFeature(QueriesFeatureDescriptorEnum.fromClause);
    }

    public void body() {
        wFeature(QueriesFeatureDescriptorEnum.body);
    }

    public void parameters() {
        wFeature(QueriesFeatureDescriptorEnum.parameters);
    }

    public void name() {
        wFeature(QueriesFeatureDescriptorEnum.name);
    }

    public void visit() {
    }

    public void QueryDeclaration() {
        wEntity(QueriesEntityDescriptorEnum.QueryDeclaration);
    }

    public void QueryDeclaration_() {
        wEntity_(QueriesEntityDescriptorEnum.QueryDeclaration);
    }

    public void _QueryDeclaration() {
        _wEntity(QueriesEntityDescriptorEnum.QueryDeclaration);
    }

    public void Path() {
        wEntity(QueriesEntityDescriptorEnum.Path);
    }

    public void Path_() {
        wEntity_(QueriesEntityDescriptorEnum.Path);
    }

    public void Path_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Path, initialCapacity);
    }

    public void _Path() {
        _wEntity(QueriesEntityDescriptorEnum.Path);
    }

    public void Delete() {
        wEntity(QueriesEntityDescriptorEnum.Delete);
    }

    public void Delete_() {
        wEntity_(QueriesEntityDescriptorEnum.Delete);
    }

    public void _Delete() {
        _wEntity(QueriesEntityDescriptorEnum.Delete);
    }

    public void CartesianInsert() {
        wEntity(QueriesEntityDescriptorEnum.CartesianInsert);
    }

    public void CartesianInsert_() {
        wEntity_(QueriesEntityDescriptorEnum.CartesianInsert);
    }

    public void _CartesianInsert() {
        _wEntity(QueriesEntityDescriptorEnum.CartesianInsert);
    }

    public void PointwiseInsert() {
        wEntity(QueriesEntityDescriptorEnum.PointwiseInsert);
    }

    public void PointwiseInsert_() {
        wEntity_(QueriesEntityDescriptorEnum.PointwiseInsert);
    }

    public void _PointwiseInsert() {
        _wEntity(QueriesEntityDescriptorEnum.PointwiseInsert);
    }

    public void CartesianUpdate() {
        wEntity(QueriesEntityDescriptorEnum.CartesianUpdate);
    }

    public void CartesianUpdate_() {
        wEntity_(QueriesEntityDescriptorEnum.CartesianUpdate);
    }

    public void _CartesianUpdate() {
        _wEntity(QueriesEntityDescriptorEnum.CartesianUpdate);
    }

    public void PointwiseUpdate() {
        wEntity(QueriesEntityDescriptorEnum.PointwiseUpdate);
    }

    public void PointwiseUpdate_() {
        wEntity_(QueriesEntityDescriptorEnum.PointwiseUpdate);
    }

    public void _PointwiseUpdate() {
        _wEntity(QueriesEntityDescriptorEnum.PointwiseUpdate);
    }

    public void Select() {
        wEntity(QueriesEntityDescriptorEnum.Select);
    }

    public void Select_() {
        wEntity_(QueriesEntityDescriptorEnum.Select);
    }

    public void _Select() {
        _wEntity(QueriesEntityDescriptorEnum.Select);
    }

    public void For() {
        wEntity(QueriesEntityDescriptorEnum.For);
    }

    public void For_() {
        wEntity_(QueriesEntityDescriptorEnum.For);
    }

    public void _For() {
        _wEntity(QueriesEntityDescriptorEnum.For);
    }

    public void If() {
        wEntity(QueriesEntityDescriptorEnum.If);
    }

    public void If_() {
        wEntity_(QueriesEntityDescriptorEnum.If);
    }

    public void _If() {
        _wEntity(QueriesEntityDescriptorEnum.If);
    }

    public void Do() {
        wEntity(QueriesEntityDescriptorEnum.Do);
    }

    public void Do_() {
        wEntity_(QueriesEntityDescriptorEnum.Do);
    }

    public void _Do() {
        _wEntity(QueriesEntityDescriptorEnum.Do);
    }

    public void EntityTemplate() {
        wEntity(QueriesEntityDescriptorEnum.EntityTemplate);
    }

    public void EntityTemplate_() {
        wEntity_(QueriesEntityDescriptorEnum.EntityTemplate);
    }

    public void _EntityTemplate() {
        _wEntity(QueriesEntityDescriptorEnum.EntityTemplate);
    }

    public void EntityCall() {
        wEntity(QueriesEntityDescriptorEnum.EntityCall);
    }

    public void EntityCall_() {
        wEntity_(QueriesEntityDescriptorEnum.EntityCall);
    }

    public void _EntityCall() {
        _wEntity(QueriesEntityDescriptorEnum.EntityCall);
    }

    public void Call() {
        wEntity(QueriesEntityDescriptorEnum.Call);
    }

    public void Call_() {
        wEntity_(QueriesEntityDescriptorEnum.Call);
    }

    public void _Call() {
        _wEntity(QueriesEntityDescriptorEnum.Call);
    }

    public void Expressions() {
        wEntity(QueriesEntityDescriptorEnum.Expressions);
    }

    public void Expressions_() {
        wEntity_(QueriesEntityDescriptorEnum.Expressions);
    }

    public void Expressions_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Expressions, initialCapacity);
    }

    public void _Expressions() {
        _wEntity(QueriesEntityDescriptorEnum.Expressions);
    }

    public void Bindings() {
        wEntity(QueriesEntityDescriptorEnum.Bindings);
    }

    public void Bindings_() {
        wEntity_(QueriesEntityDescriptorEnum.Bindings);
    }

    public void Bindings_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Bindings, initialCapacity);
    }

    public void _Bindings() {
        _wEntity(QueriesEntityDescriptorEnum.Bindings);
    }

    public void Bind() {
        wEntity(QueriesEntityDescriptorEnum.Bind);
    }

    public void Bind_() {
        wEntity_(QueriesEntityDescriptorEnum.Bind);
    }

    public void _Bind() {
        _wEntity(QueriesEntityDescriptorEnum.Bind);
    }

    public void Choose() {
        wEntity(QueriesEntityDescriptorEnum.Choose);
    }

    public void Choose_() {
        wEntity_(QueriesEntityDescriptorEnum.Choose);
    }

    public void Choose_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Choose, initialCapacity);
    }

    public void _Choose() {
        _wEntity(QueriesEntityDescriptorEnum.Choose);
    }

    public void Block() {
        wEntity(QueriesEntityDescriptorEnum.Block);
    }

    public void Block_() {
        wEntity_(QueriesEntityDescriptorEnum.Block);
    }

    public void Block_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Block, initialCapacity);
    }

    public void _Block() {
        _wEntity(QueriesEntityDescriptorEnum.Block);
    }

    public void Sequence() {
        wEntity(QueriesEntityDescriptorEnum.Sequence);
    }

    public void Sequence_() {
        wEntity_(QueriesEntityDescriptorEnum.Sequence);
    }

    public void Sequence_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Sequence, initialCapacity);
    }

    public void _Sequence() {
        _wEntity(QueriesEntityDescriptorEnum.Sequence);
    }

    public void Scope() {
        wEntity(QueriesEntityDescriptorEnum.Scope);
    }

    public void Scope_() {
        wEntity_(QueriesEntityDescriptorEnum.Scope);
    }

    public void _Scope() {
        _wEntity(QueriesEntityDescriptorEnum.Scope);
    }

    public void CartesianProduct() {
        wEntity(QueriesEntityDescriptorEnum.CartesianProduct);
    }

    public void CartesianProduct_() {
        wEntity_(QueriesEntityDescriptorEnum.CartesianProduct);
    }

    public void CartesianProduct_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.CartesianProduct, initialCapacity);
    }

    public void _CartesianProduct() {
        _wEntity(QueriesEntityDescriptorEnum.CartesianProduct);
    }

    public void PointwiseProduct() {
        wEntity(QueriesEntityDescriptorEnum.PointwiseProduct);
    }

    public void PointwiseProduct_() {
        wEntity_(QueriesEntityDescriptorEnum.PointwiseProduct);
    }

    public void PointwiseProduct_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.PointwiseProduct, initialCapacity);
    }

    public void _PointwiseProduct() {
        _wEntity(QueriesEntityDescriptorEnum.PointwiseProduct);
    }

    public void Filter() {
        wEntity(QueriesEntityDescriptorEnum.Filter);
    }

    public void Filter_() {
        wEntity_(QueriesEntityDescriptorEnum.Filter);
    }

    public void _Filter() {
        _wEntity(QueriesEntityDescriptorEnum.Filter);
    }

    public void AspectStep() {
        wEntity(QueriesEntityDescriptorEnum.AspectStep);
    }

    public void AspectStep_() {
        wEntity_(QueriesEntityDescriptorEnum.AspectStep);
    }

    public void _AspectStep() {
        _wEntity(QueriesEntityDescriptorEnum.AspectStep);
    }

    public void AdjacentStep() {
        wEntity(QueriesEntityDescriptorEnum.AdjacentStep);
    }

    public void AdjacentStep_() {
        wEntity_(QueriesEntityDescriptorEnum.AdjacentStep);
    }

    public void _AdjacentStep() {
        _wEntity(QueriesEntityDescriptorEnum.AdjacentStep);
    }

    public void ReachableStep() {
        wEntity(QueriesEntityDescriptorEnum.ReachableStep);
    }

    public void ReachableStep_() {
        wEntity_(QueriesEntityDescriptorEnum.ReachableStep);
    }

    public void _ReachableStep() {
        _wEntity(QueriesEntityDescriptorEnum.ReachableStep);
    }

    public void ReachableOrSelfStep() {
        wEntity(QueriesEntityDescriptorEnum.ReachableOrSelfStep);
    }

    public void ReachableOrSelfStep_() {
        wEntity_(QueriesEntityDescriptorEnum.ReachableOrSelfStep);
    }

    public void _ReachableOrSelfStep() {
        _wEntity(QueriesEntityDescriptorEnum.ReachableOrSelfStep);
    }

    public void InverseAdjacentStep() {
        wEntity(QueriesEntityDescriptorEnum.InverseAdjacentStep);
    }

    public void InverseAdjacentStep_() {
        wEntity_(QueriesEntityDescriptorEnum.InverseAdjacentStep);
    }

    public void _InverseAdjacentStep() {
        _wEntity(QueriesEntityDescriptorEnum.InverseAdjacentStep);
    }

    public void InverseReachableStep() {
        wEntity(QueriesEntityDescriptorEnum.InverseReachableStep);
    }

    public void InverseReachableStep_() {
        wEntity_(QueriesEntityDescriptorEnum.InverseReachableStep);
    }

    public void _InverseReachableStep() {
        _wEntity(QueriesEntityDescriptorEnum.InverseReachableStep);
    }

    public void InverseReachableOrSelfStep() {
        wEntity(QueriesEntityDescriptorEnum.InverseReachableOrSelfStep);
    }

    public void InverseReachableOrSelfStep_() {
        wEntity_(QueriesEntityDescriptorEnum.InverseReachableOrSelfStep);
    }

    public void _InverseReachableOrSelfStep() {
        _wEntity(QueriesEntityDescriptorEnum.InverseReachableOrSelfStep);
    }

    public void RootStep() {
        wEntity(QueriesEntityDescriptorEnum.RootStep);
    }

    public void RootStep_() {
        wEntity_(QueriesEntityDescriptorEnum.RootStep);
    }

    public void _RootStep() {
        _wEntity(QueriesEntityDescriptorEnum.RootStep);
    }

    public void FragmentRootStep() {
        wEntity(QueriesEntityDescriptorEnum.FragmentRootStep);
    }

    public void FragmentRootStep_() {
        wEntity_(QueriesEntityDescriptorEnum.FragmentRootStep);
    }

    public void _FragmentRootStep() {
        _wEntity(QueriesEntityDescriptorEnum.FragmentRootStep);
    }

    public void SelfStep() {
        wEntity(QueriesEntityDescriptorEnum.SelfStep);
    }

    public void SelfStep_() {
        wEntity_(QueriesEntityDescriptorEnum.SelfStep);
    }

    public void _SelfStep() {
        _wEntity(QueriesEntityDescriptorEnum.SelfStep);
    }

    public void FeatureStep() {
        wEntity(QueriesEntityDescriptorEnum.FeatureStep);
    }

    public void FeatureStep(String value) {
        wEntity(QueriesEntityDescriptorEnum.FeatureStep, value);
    }

    public void ChildStep() {
        wEntity(QueriesEntityDescriptorEnum.ChildStep);
    }

    public void ChildStep_() {
        wEntity_(QueriesEntityDescriptorEnum.ChildStep);
    }

    public void _ChildStep() {
        _wEntity(QueriesEntityDescriptorEnum.ChildStep);
    }

    public void DescendantStep() {
        wEntity(QueriesEntityDescriptorEnum.DescendantStep);
    }

    public void DescendantStep_() {
        wEntity_(QueriesEntityDescriptorEnum.DescendantStep);
    }

    public void _DescendantStep() {
        _wEntity(QueriesEntityDescriptorEnum.DescendantStep);
    }

    public void DescendantOrSelfStep() {
        wEntity(QueriesEntityDescriptorEnum.DescendantOrSelfStep);
    }

    public void DescendantOrSelfStep_() {
        wEntity_(QueriesEntityDescriptorEnum.DescendantOrSelfStep);
    }

    public void _DescendantOrSelfStep() {
        _wEntity(QueriesEntityDescriptorEnum.DescendantOrSelfStep);
    }

    public void FollowingSiblingStep() {
        wEntity(QueriesEntityDescriptorEnum.FollowingSiblingStep);
    }

    public void FollowingSiblingStep_() {
        wEntity_(QueriesEntityDescriptorEnum.FollowingSiblingStep);
    }

    public void _FollowingSiblingStep() {
        _wEntity(QueriesEntityDescriptorEnum.FollowingSiblingStep);
    }

    public void FollowingStep() {
        wEntity(QueriesEntityDescriptorEnum.FollowingStep);
    }

    public void FollowingStep_() {
        wEntity_(QueriesEntityDescriptorEnum.FollowingStep);
    }

    public void _FollowingStep() {
        _wEntity(QueriesEntityDescriptorEnum.FollowingStep);
    }

    public void ParentStep() {
        wEntity(QueriesEntityDescriptorEnum.ParentStep);
    }

    public void ParentStep_() {
        wEntity_(QueriesEntityDescriptorEnum.ParentStep);
    }

    public void _ParentStep() {
        _wEntity(QueriesEntityDescriptorEnum.ParentStep);
    }

    public void AncestorStep() {
        wEntity(QueriesEntityDescriptorEnum.AncestorStep);
    }

    public void AncestorStep_() {
        wEntity_(QueriesEntityDescriptorEnum.AncestorStep);
    }

    public void _AncestorStep() {
        _wEntity(QueriesEntityDescriptorEnum.AncestorStep);
    }

    public void AncestorOrSelfStep() {
        wEntity(QueriesEntityDescriptorEnum.AncestorOrSelfStep);
    }

    public void AncestorOrSelfStep_() {
        wEntity_(QueriesEntityDescriptorEnum.AncestorOrSelfStep);
    }

    public void _AncestorOrSelfStep() {
        _wEntity(QueriesEntityDescriptorEnum.AncestorOrSelfStep);
    }

    public void PrecedingSiblingStep() {
        wEntity(QueriesEntityDescriptorEnum.PrecedingSiblingStep);
    }

    public void PrecedingSiblingStep_() {
        wEntity_(QueriesEntityDescriptorEnum.PrecedingSiblingStep);
    }

    public void _PrecedingSiblingStep() {
        _wEntity(QueriesEntityDescriptorEnum.PrecedingSiblingStep);
    }

    public void PrecedingStep() {
        wEntity(QueriesEntityDescriptorEnum.PrecedingStep);
    }

    public void PrecedingStep_() {
        wEntity_(QueriesEntityDescriptorEnum.PrecedingStep);
    }

    public void _PrecedingStep() {
        _wEntity(QueriesEntityDescriptorEnum.PrecedingStep);
    }

    public void AdditionStep() {
        wEntity(QueriesEntityDescriptorEnum.AdditionStep);
    }

    public void AdditionStep_() {
        wEntity_(QueriesEntityDescriptorEnum.AdditionStep);
    }

    public void _AdditionStep() {
        _wEntity(QueriesEntityDescriptorEnum.AdditionStep);
    }

    public void SubtractionStep() {
        wEntity(QueriesEntityDescriptorEnum.SubtractionStep);
    }

    public void SubtractionStep_() {
        wEntity_(QueriesEntityDescriptorEnum.SubtractionStep);
    }

    public void _SubtractionStep() {
        _wEntity(QueriesEntityDescriptorEnum.SubtractionStep);
    }

    public void MultiplicationStep() {
        wEntity(QueriesEntityDescriptorEnum.MultiplicationStep);
    }

    public void MultiplicationStep_() {
        wEntity_(QueriesEntityDescriptorEnum.MultiplicationStep);
    }

    public void _MultiplicationStep() {
        _wEntity(QueriesEntityDescriptorEnum.MultiplicationStep);
    }

    public void DivisionStep() {
        wEntity(QueriesEntityDescriptorEnum.DivisionStep);
    }

    public void DivisionStep_() {
        wEntity_(QueriesEntityDescriptorEnum.DivisionStep);
    }

    public void _DivisionStep() {
        _wEntity(QueriesEntityDescriptorEnum.DivisionStep);
    }

    public void RemainderStep() {
        wEntity(QueriesEntityDescriptorEnum.RemainderStep);
    }

    public void RemainderStep_() {
        wEntity_(QueriesEntityDescriptorEnum.RemainderStep);
    }

    public void _RemainderStep() {
        _wEntity(QueriesEntityDescriptorEnum.RemainderStep);
    }

    public void EqualsStep() {
        wEntity(QueriesEntityDescriptorEnum.EqualsStep);
    }

    public void EqualsStep_() {
        wEntity_(QueriesEntityDescriptorEnum.EqualsStep);
    }

    public void _EqualsStep() {
        _wEntity(QueriesEntityDescriptorEnum.EqualsStep);
    }

    public void NotEqualsStep() {
        wEntity(QueriesEntityDescriptorEnum.NotEqualsStep);
    }

    public void NotEqualsStep_() {
        wEntity_(QueriesEntityDescriptorEnum.NotEqualsStep);
    }

    public void _NotEqualsStep() {
        _wEntity(QueriesEntityDescriptorEnum.NotEqualsStep);
    }

    public void LessThanStep() {
        wEntity(QueriesEntityDescriptorEnum.LessThanStep);
    }

    public void LessThanStep_() {
        wEntity_(QueriesEntityDescriptorEnum.LessThanStep);
    }

    public void _LessThanStep() {
        _wEntity(QueriesEntityDescriptorEnum.LessThanStep);
    }

    public void LessOrEqualsStep() {
        wEntity(QueriesEntityDescriptorEnum.LessOrEqualsStep);
    }

    public void LessOrEqualsStep_() {
        wEntity_(QueriesEntityDescriptorEnum.LessOrEqualsStep);
    }

    public void _LessOrEqualsStep() {
        _wEntity(QueriesEntityDescriptorEnum.LessOrEqualsStep);
    }

    public void GreaterThanStep() {
        wEntity(QueriesEntityDescriptorEnum.GreaterThanStep);
    }

    public void GreaterThanStep_() {
        wEntity_(QueriesEntityDescriptorEnum.GreaterThanStep);
    }

    public void _GreaterThanStep() {
        _wEntity(QueriesEntityDescriptorEnum.GreaterThanStep);
    }

    public void GreaterOrEqualsStep() {
        wEntity(QueriesEntityDescriptorEnum.GreaterOrEqualsStep);
    }

    public void GreaterOrEqualsStep_() {
        wEntity_(QueriesEntityDescriptorEnum.GreaterOrEqualsStep);
    }

    public void _GreaterOrEqualsStep() {
        _wEntity(QueriesEntityDescriptorEnum.GreaterOrEqualsStep);
    }

    public void Prune() {
        wEntity(QueriesEntityDescriptorEnum.Prune);
    }

    public void Prune_() {
        wEntity_(QueriesEntityDescriptorEnum.Prune);
    }

    public void _Prune() {
        _wEntity(QueriesEntityDescriptorEnum.Prune);
    }

    public void VariableTest() {
        wEntity(QueriesEntityDescriptorEnum.VariableTest);
    }

    public void VariableTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.VariableTest, value);
    }

    public void IndexVariableTest() {
        wEntity(QueriesEntityDescriptorEnum.IndexVariableTest);
    }

    public void IndexVariableTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.IndexVariableTest, value);
    }

    public void KindTest() {
        wEntity(QueriesEntityDescriptorEnum.KindTest);
    }

    public void KindTest(KindTestEnum.Value value) {
        wEntity(QueriesEntityDescriptorEnum.KindTest, value);
    }

    public void KindTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.KindTest, value);
    }

    public void StageTest() {
        wEntity(QueriesEntityDescriptorEnum.StageTest);
    }

    public void StageTest(StageTestEnum.Value value) {
        wEntity(QueriesEntityDescriptorEnum.StageTest, value);
    }

    public void StageTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.StageTest, value);
    }

    public void StageVariableTest() {
        wEntity(QueriesEntityDescriptorEnum.StageVariableTest);
    }

    public void StageVariableTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.StageVariableTest, value);
    }

    public void LanguageTest() {
        wEntity(QueriesEntityDescriptorEnum.LanguageTest);
    }

    public void LanguageTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.LanguageTest, value);
    }

    public void TypeTest() {
        wEntity(QueriesEntityDescriptorEnum.TypeTest);
    }

    public void TypeTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.TypeTest, value);
    }

    public void SubtypeTest() {
        wEntity(QueriesEntityDescriptorEnum.SubtypeTest);
    }

    public void SubtypeTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.SubtypeTest, value);
    }

    public void SupertypeTest() {
        wEntity(QueriesEntityDescriptorEnum.SupertypeTest);
    }

    public void SupertypeTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.SupertypeTest, value);
    }

    public void ExtendedSubtypeTest() {
        wEntity(QueriesEntityDescriptorEnum.ExtendedSubtypeTest);
    }

    public void ExtendedSubtypeTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.ExtendedSubtypeTest, value);
    }

    public void ExtendedSupertypeTest() {
        wEntity(QueriesEntityDescriptorEnum.ExtendedSupertypeTest);
    }

    public void ExtendedSupertypeTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.ExtendedSupertypeTest, value);
    }

    public void AtTypeTest() {
        wEntity(QueriesEntityDescriptorEnum.AtTypeTest);
    }

    public void AtTypeTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.AtTypeTest, value);
    }

    public void AtFeatureTest() {
        wEntity(QueriesEntityDescriptorEnum.AtFeatureTest);
    }

    public void AtFeatureTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.AtFeatureTest, value);
    }

    public void AtIndexTest() {
        wEntity(QueriesEntityDescriptorEnum.AtIndexTest);
    }

    public void AtIndexTest(int value) {
        wEntity(QueriesEntityDescriptorEnum.AtIndexTest, value);
    }

    public void IndexTest() {
        wEntity(QueriesEntityDescriptorEnum.IndexTest);
    }

    public void IndexTest_() {
        wEntity_(QueriesEntityDescriptorEnum.IndexTest);
    }

    public void _IndexTest() {
        _wEntity(QueriesEntityDescriptorEnum.IndexTest);
    }

    public void IndexRangeTest() {
        wEntity(QueriesEntityDescriptorEnum.IndexRangeTest);
    }

    public void IndexRangeTest_() {
        wEntity_(QueriesEntityDescriptorEnum.IndexRangeTest);
    }

    public void _IndexRangeTest() {
        _wEntity(QueriesEntityDescriptorEnum.IndexRangeTest);
    }

    public void VisitorTest() {
        wEntity(QueriesEntityDescriptorEnum.VisitorTest);
    }

    public void VisitorTest(IVisitor value) {
        wEntity(QueriesEntityDescriptorEnum.VisitorTest, value);
    }

    public void VisitorTest(String value) {
        wEntity(QueriesEntityDescriptorEnum.VisitorTest, value);
    }

    public void ExpressionTest() {
        wEntity(QueriesEntityDescriptorEnum.ExpressionTest);
    }

    public void ExpressionTest_() {
        wEntity_(QueriesEntityDescriptorEnum.ExpressionTest);
    }

    public void _ExpressionTest() {
        _wEntity(QueriesEntityDescriptorEnum.ExpressionTest);
    }

    public void DistinctTest() {
        wEntity(QueriesEntityDescriptorEnum.DistinctTest);
    }

    public void DistinctTest_() {
        wEntity_(QueriesEntityDescriptorEnum.DistinctTest);
    }

    public void _DistinctTest() {
        _wEntity(QueriesEntityDescriptorEnum.DistinctTest);
    }

    public void And() {
        wEntity(QueriesEntityDescriptorEnum.And);
    }

    public void And_() {
        wEntity_(QueriesEntityDescriptorEnum.And);
    }

    public void And_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.And, initialCapacity);
    }

    public void _And() {
        _wEntity(QueriesEntityDescriptorEnum.And);
    }

    public void Or() {
        wEntity(QueriesEntityDescriptorEnum.Or);
    }

    public void Or_() {
        wEntity_(QueriesEntityDescriptorEnum.Or);
    }

    public void Or_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Or, initialCapacity);
    }

    public void _Or() {
        _wEntity(QueriesEntityDescriptorEnum.Or);
    }

    public void Not() {
        wEntity(QueriesEntityDescriptorEnum.Not);
    }

    public void Not_() {
        wEntity_(QueriesEntityDescriptorEnum.Not);
    }

    public void _Not() {
        _wEntity(QueriesEntityDescriptorEnum.Not);
    }

    public void One() {
        wEntity(QueriesEntityDescriptorEnum.One);
    }

    public void One_() {
        wEntity_(QueriesEntityDescriptorEnum.One);
    }

    public void _One() {
        _wEntity(QueriesEntityDescriptorEnum.One);
    }

    public void Some() {
        wEntity(QueriesEntityDescriptorEnum.Some);
    }

    public void Some_() {
        wEntity_(QueriesEntityDescriptorEnum.Some);
    }

    public void _Some() {
        _wEntity(QueriesEntityDescriptorEnum.Some);
    }

    public void Every() {
        wEntity(QueriesEntityDescriptorEnum.Every);
    }

    public void Every_() {
        wEntity_(QueriesEntityDescriptorEnum.Every);
    }

    public void _Every() {
        _wEntity(QueriesEntityDescriptorEnum.Every);
    }

    public void ParenthesizedPredicate() {
        wEntity(QueriesEntityDescriptorEnum.ParenthesizedPredicate);
    }

    public void ParenthesizedPredicate_() {
        wEntity_(QueriesEntityDescriptorEnum.ParenthesizedPredicate);
    }

    public void _ParenthesizedPredicate() {
        _wEntity(QueriesEntityDescriptorEnum.ParenthesizedPredicate);
    }

    public void EntityType() {
        wEntity(QueriesEntityDescriptorEnum.EntityType);
    }

    public void EntityType(String value) {
        wEntity(QueriesEntityDescriptorEnum.EntityType, value);
    }

    public void TemplateNames() {
        wEntity(QueriesEntityDescriptorEnum.TemplateNames);
    }

    public void TemplateNames_() {
        wEntity_(QueriesEntityDescriptorEnum.TemplateNames);
    }

    public void _TemplateNames() {
        _wEntity(QueriesEntityDescriptorEnum.TemplateNames);
    }

    public void AllNames() {
        wEntity(QueriesEntityDescriptorEnum.AllNames);
    }

    public void AllNames_() {
        wEntity_(QueriesEntityDescriptorEnum.AllNames);
    }

    public void _AllNames() {
        _wEntity(QueriesEntityDescriptorEnum.AllNames);
    }

    public void AddNames() {
        wEntity(QueriesEntityDescriptorEnum.AddNames);
    }

    public void AddNames_() {
        wEntity_(QueriesEntityDescriptorEnum.AddNames);
    }

    public void _AddNames() {
        _wEntity(QueriesEntityDescriptorEnum.AddNames);
    }

    public void RemoveNames() {
        wEntity(QueriesEntityDescriptorEnum.RemoveNames);
    }

    public void RemoveNames_() {
        wEntity_(QueriesEntityDescriptorEnum.RemoveNames);
    }

    public void _RemoveNames() {
        _wEntity(QueriesEntityDescriptorEnum.RemoveNames);
    }

    public void Names() {
        wEntity(QueriesEntityDescriptorEnum.Names);
    }

    public void Names_() {
        wEntity_(QueriesEntityDescriptorEnum.Names);
    }

    public void Names_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Names, initialCapacity);
    }

    public void _Names() {
        _wEntity(QueriesEntityDescriptorEnum.Names);
    }

    public void Name() {
        wEntity(QueriesEntityDescriptorEnum.Name);
    }

    public void Name(String value) {
        wEntity(QueriesEntityDescriptorEnum.Name, value);
    }

    public void IdentityComparator() {
        wEntity(QueriesEntityDescriptorEnum.IdentityComparator);
    }

    public void IdentityComparator_() {
        wEntity_(QueriesEntityDescriptorEnum.IdentityComparator);
    }

    public void _IdentityComparator() {
        _wEntity(QueriesEntityDescriptorEnum.IdentityComparator);
    }

    public void UnionAll() {
        wEntity(QueriesEntityDescriptorEnum.UnionAll);
    }

    public void UnionAll_() {
        wEntity_(QueriesEntityDescriptorEnum.UnionAll);
    }

    public void _UnionAll() {
        _wEntity(QueriesEntityDescriptorEnum.UnionAll);
    }

    public void Union() {
        wEntity(QueriesEntityDescriptorEnum.Union);
    }

    public void Union_() {
        wEntity_(QueriesEntityDescriptorEnum.Union);
    }

    public void _Union() {
        _wEntity(QueriesEntityDescriptorEnum.Union);
    }

    public void Intersect() {
        wEntity(QueriesEntityDescriptorEnum.Intersect);
    }

    public void Intersect_() {
        wEntity_(QueriesEntityDescriptorEnum.Intersect);
    }

    public void _Intersect() {
        _wEntity(QueriesEntityDescriptorEnum.Intersect);
    }

    public void Except() {
        wEntity(QueriesEntityDescriptorEnum.Except);
    }

    public void Except_() {
        wEntity_(QueriesEntityDescriptorEnum.Except);
    }

    public void _Except() {
        _wEntity(QueriesEntityDescriptorEnum.Except);
    }

    public void VariableRefStep() {
        wEntity(QueriesEntityDescriptorEnum.VariableRefStep);
    }

    public void VariableRefStep(String value) {
        wEntity(QueriesEntityDescriptorEnum.VariableRefStep, value);
    }

    public void Singleton() {
        wEntity(QueriesEntityDescriptorEnum.Singleton);
    }

    public void Singleton_() {
        wEntity_(QueriesEntityDescriptorEnum.Singleton);
    }

    public void _Singleton() {
        _wEntity(QueriesEntityDescriptorEnum.Singleton);
    }

    public void PointwiseEquals() {
        wEntity(QueriesEntityDescriptorEnum.PointwiseEquals);
    }

    public void PointwiseEquals_() {
        wEntity_(QueriesEntityDescriptorEnum.PointwiseEquals);
    }

    public void _PointwiseEquals() {
        _wEntity(QueriesEntityDescriptorEnum.PointwiseEquals);
    }

    public void Tuple() {
        wEntity(QueriesEntityDescriptorEnum.Tuple);
    }

    public void Tuple_() {
        wEntity_(QueriesEntityDescriptorEnum.Tuple);
    }

    public void Tuple_(int initialCapacity) {
        wEntity_(QueriesEntityDescriptorEnum.Tuple, initialCapacity);
    }

    public void _Tuple() {
        _wEntity(QueriesEntityDescriptorEnum.Tuple);
    }

    public void Addition() {
        wEntity(QueriesEntityDescriptorEnum.Addition);
    }

    public void Addition_() {
        wEntity_(QueriesEntityDescriptorEnum.Addition);
    }

    public void _Addition() {
        _wEntity(QueriesEntityDescriptorEnum.Addition);
    }

    public void Subtraction() {
        wEntity(QueriesEntityDescriptorEnum.Subtraction);
    }

    public void Subtraction_() {
        wEntity_(QueriesEntityDescriptorEnum.Subtraction);
    }

    public void _Subtraction() {
        _wEntity(QueriesEntityDescriptorEnum.Subtraction);
    }

    public void Multiplication() {
        wEntity(QueriesEntityDescriptorEnum.Multiplication);
    }

    public void Multiplication_() {
        wEntity_(QueriesEntityDescriptorEnum.Multiplication);
    }

    public void _Multiplication() {
        _wEntity(QueriesEntityDescriptorEnum.Multiplication);
    }

    public void Division() {
        wEntity(QueriesEntityDescriptorEnum.Division);
    }

    public void Division_() {
        wEntity_(QueriesEntityDescriptorEnum.Division);
    }

    public void _Division() {
        _wEntity(QueriesEntityDescriptorEnum.Division);
    }

    public void Remainder() {
        wEntity(QueriesEntityDescriptorEnum.Remainder);
    }

    public void Remainder_() {
        wEntity_(QueriesEntityDescriptorEnum.Remainder);
    }

    public void _Remainder() {
        _wEntity(QueriesEntityDescriptorEnum.Remainder);
    }

    public void Equals() {
        wEntity(QueriesEntityDescriptorEnum.Equals);
    }

    public void Equals_() {
        wEntity_(QueriesEntityDescriptorEnum.Equals);
    }

    public void _Equals() {
        _wEntity(QueriesEntityDescriptorEnum.Equals);
    }

    public void NotEquals() {
        wEntity(QueriesEntityDescriptorEnum.NotEquals);
    }

    public void NotEquals_() {
        wEntity_(QueriesEntityDescriptorEnum.NotEquals);
    }

    public void _NotEquals() {
        _wEntity(QueriesEntityDescriptorEnum.NotEquals);
    }

    public void LessThan() {
        wEntity(QueriesEntityDescriptorEnum.LessThan);
    }

    public void LessThan_() {
        wEntity_(QueriesEntityDescriptorEnum.LessThan);
    }

    public void _LessThan() {
        _wEntity(QueriesEntityDescriptorEnum.LessThan);
    }

    public void LessOrEquals() {
        wEntity(QueriesEntityDescriptorEnum.LessOrEquals);
    }

    public void LessOrEquals_() {
        wEntity_(QueriesEntityDescriptorEnum.LessOrEquals);
    }

    public void _LessOrEquals() {
        _wEntity(QueriesEntityDescriptorEnum.LessOrEquals);
    }

    public void GreaterThan() {
        wEntity(QueriesEntityDescriptorEnum.GreaterThan);
    }

    public void GreaterThan_() {
        wEntity_(QueriesEntityDescriptorEnum.GreaterThan);
    }

    public void _GreaterThan() {
        _wEntity(QueriesEntityDescriptorEnum.GreaterThan);
    }

    public void GreaterOrEquals() {
        wEntity(QueriesEntityDescriptorEnum.GreaterOrEquals);
    }

    public void GreaterOrEquals_() {
        wEntity_(QueriesEntityDescriptorEnum.GreaterOrEquals);
    }

    public void _GreaterOrEquals() {
        _wEntity(QueriesEntityDescriptorEnum.GreaterOrEquals);
    }

    public void VoidLiteral() {
        wEntity(QueriesEntityDescriptorEnum.VoidLiteral);
    }

    public void VoidLiteral_() {
        wEntity_(QueriesEntityDescriptorEnum.VoidLiteral);
    }

    public void _VoidLiteral() {
        _wEntity(QueriesEntityDescriptorEnum.VoidLiteral);
    }

    public void BooleanLiteral() {
        wEntity(QueriesEntityDescriptorEnum.BooleanLiteral);
    }

    public void BooleanLiteral(boolean value) {
        wEntity(QueriesEntityDescriptorEnum.BooleanLiteral, value);
    }

    public void ByteLiteral() {
        wEntity(QueriesEntityDescriptorEnum.ByteLiteral);
    }

    public void ByteLiteral(byte value) {
        wEntity(QueriesEntityDescriptorEnum.ByteLiteral, value);
    }

    public void CharLiteral() {
        wEntity(QueriesEntityDescriptorEnum.CharLiteral);
    }

    public void CharLiteral(char value) {
        wEntity(QueriesEntityDescriptorEnum.CharLiteral, value);
    }

    public void DoubleLiteral() {
        wEntity(QueriesEntityDescriptorEnum.DoubleLiteral);
    }

    public void DoubleLiteral(double value) {
        wEntity(QueriesEntityDescriptorEnum.DoubleLiteral, value);
    }

    public void FloatLiteral() {
        wEntity(QueriesEntityDescriptorEnum.FloatLiteral);
    }

    public void FloatLiteral(float value) {
        wEntity(QueriesEntityDescriptorEnum.FloatLiteral, value);
    }

    public void IntLiteral() {
        wEntity(QueriesEntityDescriptorEnum.IntLiteral);
    }

    public void IntLiteral(int value) {
        wEntity(QueriesEntityDescriptorEnum.IntLiteral, value);
    }

    public void LongLiteral() {
        wEntity(QueriesEntityDescriptorEnum.LongLiteral);
    }

    public void LongLiteral(long value) {
        wEntity(QueriesEntityDescriptorEnum.LongLiteral, value);
    }

    public void ShortLiteral() {
        wEntity(QueriesEntityDescriptorEnum.ShortLiteral);
    }

    public void ShortLiteral(short value) {
        wEntity(QueriesEntityDescriptorEnum.ShortLiteral, value);
    }

    public void DateLiteral() {
        wEntity(QueriesEntityDescriptorEnum.DateLiteral);
    }

    public void DateLiteral(Date value) {
        wEntity(QueriesEntityDescriptorEnum.DateLiteral, value);
    }

    public void DateLiteral(String value) {
        wEntity(QueriesEntityDescriptorEnum.DateLiteral, value);
    }

    public void StringLiteral() {
        wEntity(QueriesEntityDescriptorEnum.StringLiteral);
    }

    public void StringLiteral(String value) {
        wEntity(QueriesEntityDescriptorEnum.StringLiteral, value);
    }

    public void Placement() {
        wEntity(QueriesEntityDescriptorEnum.Placement);
    }

    public void Placement(PlacementEnum.Value value) {
        wEntity(QueriesEntityDescriptorEnum.Placement, value);
    }

    public void Placement(String value) {
        wEntity(QueriesEntityDescriptorEnum.Placement, value);
    }
}
