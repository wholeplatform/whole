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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.queries.model.KindTestEnum.Value;
import org.whole.lang.visitors.IVisitor;
import java.util.Date;

/**
 *  @generator Whole
 */
public class QueriesGenericBuilderAdapter extends GenericIdentityBuilder {
    private IQueriesBuilder specificBuilder;

    public QueriesGenericBuilderAdapter(IQueriesBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public QueriesGenericBuilderAdapter(IQueriesBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case QueriesFeatureDescriptorEnum.name_ord :
            specificBuilder.name();
            break;
            case QueriesFeatureDescriptorEnum.parameters_ord :
            specificBuilder.parameters();
            break;
            case QueriesFeatureDescriptorEnum.body_ord :
            specificBuilder.body();
            break;
            case QueriesFeatureDescriptorEnum.fromClause_ord :
            specificBuilder.fromClause();
            break;
            case QueriesFeatureDescriptorEnum.placement_ord :
            specificBuilder.placement();
            break;
            case QueriesFeatureDescriptorEnum.valuesClause_ord :
            specificBuilder.valuesClause();
            break;
            case QueriesFeatureDescriptorEnum.selectClause_ord :
            specificBuilder.selectClause();
            break;
            case QueriesFeatureDescriptorEnum.whereClause_ord :
            specificBuilder.whereClause();
            break;
            case QueriesFeatureDescriptorEnum.clearClause_ord :
            specificBuilder.clearClause();
            break;
            case QueriesFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case QueriesFeatureDescriptorEnum.predicate_ord :
            specificBuilder.predicate();
            break;
            case QueriesFeatureDescriptorEnum.constraints_ord :
            specificBuilder.constraints();
            break;
            case QueriesFeatureDescriptorEnum.bindings_ord :
            specificBuilder.bindings();
            break;
            case QueriesFeatureDescriptorEnum.arguments_ord :
            specificBuilder.arguments();
            break;
            case QueriesFeatureDescriptorEnum.localNames_ord :
            specificBuilder.localNames();
            break;
            case QueriesFeatureDescriptorEnum.index_ord :
            specificBuilder.index();
            break;
            case QueriesFeatureDescriptorEnum.startIndex_ord :
            specificBuilder.startIndex();
            break;
            case QueriesFeatureDescriptorEnum.endIndex_ord :
            specificBuilder.endIndex();
            break;
            case QueriesFeatureDescriptorEnum.comparator_ord :
            specificBuilder.comparator();
            break;
            case QueriesFeatureDescriptorEnum.names_ord :
            specificBuilder.names();
            break;
            case QueriesFeatureDescriptorEnum.expressions_ord :
            specificBuilder.expressions();
            break;
            case QueriesFeatureDescriptorEnum.identity_ord :
            specificBuilder.identity();
            break;
            case QueriesFeatureDescriptorEnum.pexp1_ord :
            specificBuilder.pexp1();
            break;
            case QueriesFeatureDescriptorEnum.pexp2_ord :
            specificBuilder.pexp2();
            break;
            case QueriesFeatureDescriptorEnum.exp1_ord :
            specificBuilder.exp1();
            break;
            case QueriesFeatureDescriptorEnum.exp2_ord :
            specificBuilder.exp2();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.QueryDeclaration_ord :
            specificBuilder.QueryDeclaration();
            break;
            case QueriesEntityDescriptorEnum.Path_ord :
            specificBuilder.Path();
            break;
            case QueriesEntityDescriptorEnum.Delete_ord :
            specificBuilder.Delete();
            break;
            case QueriesEntityDescriptorEnum.CartesianInsert_ord :
            specificBuilder.CartesianInsert();
            break;
            case QueriesEntityDescriptorEnum.PointwiseInsert_ord :
            specificBuilder.PointwiseInsert();
            break;
            case QueriesEntityDescriptorEnum.CartesianUpdate_ord :
            specificBuilder.CartesianUpdate();
            break;
            case QueriesEntityDescriptorEnum.PointwiseUpdate_ord :
            specificBuilder.PointwiseUpdate();
            break;
            case QueriesEntityDescriptorEnum.Select_ord :
            specificBuilder.Select();
            break;
            case QueriesEntityDescriptorEnum.For_ord :
            specificBuilder.For();
            break;
            case QueriesEntityDescriptorEnum.If_ord :
            specificBuilder.If();
            break;
            case QueriesEntityDescriptorEnum.Do_ord :
            specificBuilder.Do();
            break;
            case QueriesEntityDescriptorEnum.EntityTemplate_ord :
            specificBuilder.EntityTemplate();
            break;
            case QueriesEntityDescriptorEnum.EntityCall_ord :
            specificBuilder.EntityCall();
            break;
            case QueriesEntityDescriptorEnum.Call_ord :
            specificBuilder.Call();
            break;
            case QueriesEntityDescriptorEnum.Expressions_ord :
            specificBuilder.Expressions();
            break;
            case QueriesEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings();
            break;
            case QueriesEntityDescriptorEnum.Bind_ord :
            specificBuilder.Bind();
            break;
            case QueriesEntityDescriptorEnum.Choose_ord :
            specificBuilder.Choose();
            break;
            case QueriesEntityDescriptorEnum.Block_ord :
            specificBuilder.Block();
            break;
            case QueriesEntityDescriptorEnum.Sequence_ord :
            specificBuilder.Sequence();
            break;
            case QueriesEntityDescriptorEnum.Scope_ord :
            specificBuilder.Scope();
            break;
            case QueriesEntityDescriptorEnum.CartesianProduct_ord :
            specificBuilder.CartesianProduct();
            break;
            case QueriesEntityDescriptorEnum.PointwiseProduct_ord :
            specificBuilder.PointwiseProduct();
            break;
            case QueriesEntityDescriptorEnum.Filter_ord :
            specificBuilder.Filter();
            break;
            case QueriesEntityDescriptorEnum.AspectStep_ord :
            specificBuilder.AspectStep();
            break;
            case QueriesEntityDescriptorEnum.AdjacentStep_ord :
            specificBuilder.AdjacentStep();
            break;
            case QueriesEntityDescriptorEnum.ReachableStep_ord :
            specificBuilder.ReachableStep();
            break;
            case QueriesEntityDescriptorEnum.ReachableOrSelfStep_ord :
            specificBuilder.ReachableOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.InverseAdjacentStep_ord :
            specificBuilder.InverseAdjacentStep();
            break;
            case QueriesEntityDescriptorEnum.InverseReachableStep_ord :
            specificBuilder.InverseReachableStep();
            break;
            case QueriesEntityDescriptorEnum.InverseReachableOrSelfStep_ord :
            specificBuilder.InverseReachableOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.RootStep_ord :
            specificBuilder.RootStep();
            break;
            case QueriesEntityDescriptorEnum.FragmentRootStep_ord :
            specificBuilder.FragmentRootStep();
            break;
            case QueriesEntityDescriptorEnum.SelfStep_ord :
            specificBuilder.SelfStep();
            break;
            case QueriesEntityDescriptorEnum.ChildStep_ord :
            specificBuilder.ChildStep();
            break;
            case QueriesEntityDescriptorEnum.DescendantStep_ord :
            specificBuilder.DescendantStep();
            break;
            case QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord :
            specificBuilder.DescendantOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.FollowingSiblingStep_ord :
            specificBuilder.FollowingSiblingStep();
            break;
            case QueriesEntityDescriptorEnum.FollowingStep_ord :
            specificBuilder.FollowingStep();
            break;
            case QueriesEntityDescriptorEnum.ParentStep_ord :
            specificBuilder.ParentStep();
            break;
            case QueriesEntityDescriptorEnum.AncestorStep_ord :
            specificBuilder.AncestorStep();
            break;
            case QueriesEntityDescriptorEnum.AncestorOrSelfStep_ord :
            specificBuilder.AncestorOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord :
            specificBuilder.PrecedingSiblingStep();
            break;
            case QueriesEntityDescriptorEnum.PrecedingStep_ord :
            specificBuilder.PrecedingStep();
            break;
            case QueriesEntityDescriptorEnum.AdditionStep_ord :
            specificBuilder.AdditionStep();
            break;
            case QueriesEntityDescriptorEnum.SubtractionStep_ord :
            specificBuilder.SubtractionStep();
            break;
            case QueriesEntityDescriptorEnum.MultiplicationStep_ord :
            specificBuilder.MultiplicationStep();
            break;
            case QueriesEntityDescriptorEnum.DivisionStep_ord :
            specificBuilder.DivisionStep();
            break;
            case QueriesEntityDescriptorEnum.RemainderStep_ord :
            specificBuilder.RemainderStep();
            break;
            case QueriesEntityDescriptorEnum.EqualsStep_ord :
            specificBuilder.EqualsStep();
            break;
            case QueriesEntityDescriptorEnum.NotEqualsStep_ord :
            specificBuilder.NotEqualsStep();
            break;
            case QueriesEntityDescriptorEnum.LessThanStep_ord :
            specificBuilder.LessThanStep();
            break;
            case QueriesEntityDescriptorEnum.LessOrEqualsStep_ord :
            specificBuilder.LessOrEqualsStep();
            break;
            case QueriesEntityDescriptorEnum.GreaterThanStep_ord :
            specificBuilder.GreaterThanStep();
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEqualsStep_ord :
            specificBuilder.GreaterOrEqualsStep();
            break;
            case QueriesEntityDescriptorEnum.Prune_ord :
            specificBuilder.Prune();
            break;
            case QueriesEntityDescriptorEnum.IndexTest_ord :
            specificBuilder.IndexTest();
            break;
            case QueriesEntityDescriptorEnum.IndexRangeTest_ord :
            specificBuilder.IndexRangeTest();
            break;
            case QueriesEntityDescriptorEnum.ExpressionTest_ord :
            specificBuilder.ExpressionTest();
            break;
            case QueriesEntityDescriptorEnum.DistinctTest_ord :
            specificBuilder.DistinctTest();
            break;
            case QueriesEntityDescriptorEnum.And_ord :
            specificBuilder.And();
            break;
            case QueriesEntityDescriptorEnum.Or_ord :
            specificBuilder.Or();
            break;
            case QueriesEntityDescriptorEnum.Not_ord :
            specificBuilder.Not();
            break;
            case QueriesEntityDescriptorEnum.One_ord :
            specificBuilder.One();
            break;
            case QueriesEntityDescriptorEnum.Some_ord :
            specificBuilder.Some();
            break;
            case QueriesEntityDescriptorEnum.Every_ord :
            specificBuilder.Every();
            break;
            case QueriesEntityDescriptorEnum.ParenthesizedPredicate_ord :
            specificBuilder.ParenthesizedPredicate();
            break;
            case QueriesEntityDescriptorEnum.TemplateNames_ord :
            specificBuilder.TemplateNames();
            break;
            case QueriesEntityDescriptorEnum.AllNames_ord :
            specificBuilder.AllNames();
            break;
            case QueriesEntityDescriptorEnum.AddNames_ord :
            specificBuilder.AddNames();
            break;
            case QueriesEntityDescriptorEnum.RemoveNames_ord :
            specificBuilder.RemoveNames();
            break;
            case QueriesEntityDescriptorEnum.Names_ord :
            specificBuilder.Names();
            break;
            case QueriesEntityDescriptorEnum.IdentityComparator_ord :
            specificBuilder.IdentityComparator();
            break;
            case QueriesEntityDescriptorEnum.UnionAll_ord :
            specificBuilder.UnionAll();
            break;
            case QueriesEntityDescriptorEnum.Union_ord :
            specificBuilder.Union();
            break;
            case QueriesEntityDescriptorEnum.Intersect_ord :
            specificBuilder.Intersect();
            break;
            case QueriesEntityDescriptorEnum.Except_ord :
            specificBuilder.Except();
            break;
            case QueriesEntityDescriptorEnum.Singleton_ord :
            specificBuilder.Singleton();
            break;
            case QueriesEntityDescriptorEnum.PointwiseEquals_ord :
            specificBuilder.PointwiseEquals();
            break;
            case QueriesEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple();
            break;
            case QueriesEntityDescriptorEnum.Addition_ord :
            specificBuilder.Addition();
            break;
            case QueriesEntityDescriptorEnum.Subtraction_ord :
            specificBuilder.Subtraction();
            break;
            case QueriesEntityDescriptorEnum.Multiplication_ord :
            specificBuilder.Multiplication();
            break;
            case QueriesEntityDescriptorEnum.Division_ord :
            specificBuilder.Division();
            break;
            case QueriesEntityDescriptorEnum.Remainder_ord :
            specificBuilder.Remainder();
            break;
            case QueriesEntityDescriptorEnum.Equals_ord :
            specificBuilder.Equals();
            break;
            case QueriesEntityDescriptorEnum.NotEquals_ord :
            specificBuilder.NotEquals();
            break;
            case QueriesEntityDescriptorEnum.LessThan_ord :
            specificBuilder.LessThan();
            break;
            case QueriesEntityDescriptorEnum.LessOrEquals_ord :
            specificBuilder.LessOrEquals();
            break;
            case QueriesEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder.GreaterThan();
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEquals_ord :
            specificBuilder.GreaterOrEquals();
            break;
            case QueriesEntityDescriptorEnum.VoidLiteral_ord :
            specificBuilder.VoidLiteral();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.QueryDeclaration_ord :
            specificBuilder.QueryDeclaration_();
            break;
            case QueriesEntityDescriptorEnum.Path_ord :
            specificBuilder.Path_();
            break;
            case QueriesEntityDescriptorEnum.Delete_ord :
            specificBuilder.Delete_();
            break;
            case QueriesEntityDescriptorEnum.CartesianInsert_ord :
            specificBuilder.CartesianInsert_();
            break;
            case QueriesEntityDescriptorEnum.PointwiseInsert_ord :
            specificBuilder.PointwiseInsert_();
            break;
            case QueriesEntityDescriptorEnum.CartesianUpdate_ord :
            specificBuilder.CartesianUpdate_();
            break;
            case QueriesEntityDescriptorEnum.PointwiseUpdate_ord :
            specificBuilder.PointwiseUpdate_();
            break;
            case QueriesEntityDescriptorEnum.Select_ord :
            specificBuilder.Select_();
            break;
            case QueriesEntityDescriptorEnum.For_ord :
            specificBuilder.For_();
            break;
            case QueriesEntityDescriptorEnum.If_ord :
            specificBuilder.If_();
            break;
            case QueriesEntityDescriptorEnum.Do_ord :
            specificBuilder.Do_();
            break;
            case QueriesEntityDescriptorEnum.EntityTemplate_ord :
            specificBuilder.EntityTemplate_();
            break;
            case QueriesEntityDescriptorEnum.EntityCall_ord :
            specificBuilder.EntityCall_();
            break;
            case QueriesEntityDescriptorEnum.Call_ord :
            specificBuilder.Call_();
            break;
            case QueriesEntityDescriptorEnum.Expressions_ord :
            specificBuilder.Expressions_();
            break;
            case QueriesEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings_();
            break;
            case QueriesEntityDescriptorEnum.Bind_ord :
            specificBuilder.Bind_();
            break;
            case QueriesEntityDescriptorEnum.Choose_ord :
            specificBuilder.Choose_();
            break;
            case QueriesEntityDescriptorEnum.Block_ord :
            specificBuilder.Block_();
            break;
            case QueriesEntityDescriptorEnum.Sequence_ord :
            specificBuilder.Sequence_();
            break;
            case QueriesEntityDescriptorEnum.Scope_ord :
            specificBuilder.Scope_();
            break;
            case QueriesEntityDescriptorEnum.CartesianProduct_ord :
            specificBuilder.CartesianProduct_();
            break;
            case QueriesEntityDescriptorEnum.PointwiseProduct_ord :
            specificBuilder.PointwiseProduct_();
            break;
            case QueriesEntityDescriptorEnum.Filter_ord :
            specificBuilder.Filter_();
            break;
            case QueriesEntityDescriptorEnum.AspectStep_ord :
            specificBuilder.AspectStep_();
            break;
            case QueriesEntityDescriptorEnum.AdjacentStep_ord :
            specificBuilder.AdjacentStep_();
            break;
            case QueriesEntityDescriptorEnum.ReachableStep_ord :
            specificBuilder.ReachableStep_();
            break;
            case QueriesEntityDescriptorEnum.ReachableOrSelfStep_ord :
            specificBuilder.ReachableOrSelfStep_();
            break;
            case QueriesEntityDescriptorEnum.InverseAdjacentStep_ord :
            specificBuilder.InverseAdjacentStep_();
            break;
            case QueriesEntityDescriptorEnum.InverseReachableStep_ord :
            specificBuilder.InverseReachableStep_();
            break;
            case QueriesEntityDescriptorEnum.InverseReachableOrSelfStep_ord :
            specificBuilder.InverseReachableOrSelfStep_();
            break;
            case QueriesEntityDescriptorEnum.RootStep_ord :
            specificBuilder.RootStep_();
            break;
            case QueriesEntityDescriptorEnum.FragmentRootStep_ord :
            specificBuilder.FragmentRootStep_();
            break;
            case QueriesEntityDescriptorEnum.SelfStep_ord :
            specificBuilder.SelfStep_();
            break;
            case QueriesEntityDescriptorEnum.ChildStep_ord :
            specificBuilder.ChildStep_();
            break;
            case QueriesEntityDescriptorEnum.DescendantStep_ord :
            specificBuilder.DescendantStep_();
            break;
            case QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord :
            specificBuilder.DescendantOrSelfStep_();
            break;
            case QueriesEntityDescriptorEnum.FollowingSiblingStep_ord :
            specificBuilder.FollowingSiblingStep_();
            break;
            case QueriesEntityDescriptorEnum.FollowingStep_ord :
            specificBuilder.FollowingStep_();
            break;
            case QueriesEntityDescriptorEnum.ParentStep_ord :
            specificBuilder.ParentStep_();
            break;
            case QueriesEntityDescriptorEnum.AncestorStep_ord :
            specificBuilder.AncestorStep_();
            break;
            case QueriesEntityDescriptorEnum.AncestorOrSelfStep_ord :
            specificBuilder.AncestorOrSelfStep_();
            break;
            case QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord :
            specificBuilder.PrecedingSiblingStep_();
            break;
            case QueriesEntityDescriptorEnum.PrecedingStep_ord :
            specificBuilder.PrecedingStep_();
            break;
            case QueriesEntityDescriptorEnum.AdditionStep_ord :
            specificBuilder.AdditionStep_();
            break;
            case QueriesEntityDescriptorEnum.SubtractionStep_ord :
            specificBuilder.SubtractionStep_();
            break;
            case QueriesEntityDescriptorEnum.MultiplicationStep_ord :
            specificBuilder.MultiplicationStep_();
            break;
            case QueriesEntityDescriptorEnum.DivisionStep_ord :
            specificBuilder.DivisionStep_();
            break;
            case QueriesEntityDescriptorEnum.RemainderStep_ord :
            specificBuilder.RemainderStep_();
            break;
            case QueriesEntityDescriptorEnum.EqualsStep_ord :
            specificBuilder.EqualsStep_();
            break;
            case QueriesEntityDescriptorEnum.NotEqualsStep_ord :
            specificBuilder.NotEqualsStep_();
            break;
            case QueriesEntityDescriptorEnum.LessThanStep_ord :
            specificBuilder.LessThanStep_();
            break;
            case QueriesEntityDescriptorEnum.LessOrEqualsStep_ord :
            specificBuilder.LessOrEqualsStep_();
            break;
            case QueriesEntityDescriptorEnum.GreaterThanStep_ord :
            specificBuilder.GreaterThanStep_();
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEqualsStep_ord :
            specificBuilder.GreaterOrEqualsStep_();
            break;
            case QueriesEntityDescriptorEnum.Prune_ord :
            specificBuilder.Prune_();
            break;
            case QueriesEntityDescriptorEnum.IndexTest_ord :
            specificBuilder.IndexTest_();
            break;
            case QueriesEntityDescriptorEnum.IndexRangeTest_ord :
            specificBuilder.IndexRangeTest_();
            break;
            case QueriesEntityDescriptorEnum.ExpressionTest_ord :
            specificBuilder.ExpressionTest_();
            break;
            case QueriesEntityDescriptorEnum.DistinctTest_ord :
            specificBuilder.DistinctTest_();
            break;
            case QueriesEntityDescriptorEnum.And_ord :
            specificBuilder.And_();
            break;
            case QueriesEntityDescriptorEnum.Or_ord :
            specificBuilder.Or_();
            break;
            case QueriesEntityDescriptorEnum.Not_ord :
            specificBuilder.Not_();
            break;
            case QueriesEntityDescriptorEnum.One_ord :
            specificBuilder.One_();
            break;
            case QueriesEntityDescriptorEnum.Some_ord :
            specificBuilder.Some_();
            break;
            case QueriesEntityDescriptorEnum.Every_ord :
            specificBuilder.Every_();
            break;
            case QueriesEntityDescriptorEnum.ParenthesizedPredicate_ord :
            specificBuilder.ParenthesizedPredicate_();
            break;
            case QueriesEntityDescriptorEnum.TemplateNames_ord :
            specificBuilder.TemplateNames_();
            break;
            case QueriesEntityDescriptorEnum.AllNames_ord :
            specificBuilder.AllNames_();
            break;
            case QueriesEntityDescriptorEnum.AddNames_ord :
            specificBuilder.AddNames_();
            break;
            case QueriesEntityDescriptorEnum.RemoveNames_ord :
            specificBuilder.RemoveNames_();
            break;
            case QueriesEntityDescriptorEnum.Names_ord :
            specificBuilder.Names_();
            break;
            case QueriesEntityDescriptorEnum.IdentityComparator_ord :
            specificBuilder.IdentityComparator_();
            break;
            case QueriesEntityDescriptorEnum.UnionAll_ord :
            specificBuilder.UnionAll_();
            break;
            case QueriesEntityDescriptorEnum.Union_ord :
            specificBuilder.Union_();
            break;
            case QueriesEntityDescriptorEnum.Intersect_ord :
            specificBuilder.Intersect_();
            break;
            case QueriesEntityDescriptorEnum.Except_ord :
            specificBuilder.Except_();
            break;
            case QueriesEntityDescriptorEnum.Singleton_ord :
            specificBuilder.Singleton_();
            break;
            case QueriesEntityDescriptorEnum.PointwiseEquals_ord :
            specificBuilder.PointwiseEquals_();
            break;
            case QueriesEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple_();
            break;
            case QueriesEntityDescriptorEnum.Addition_ord :
            specificBuilder.Addition_();
            break;
            case QueriesEntityDescriptorEnum.Subtraction_ord :
            specificBuilder.Subtraction_();
            break;
            case QueriesEntityDescriptorEnum.Multiplication_ord :
            specificBuilder.Multiplication_();
            break;
            case QueriesEntityDescriptorEnum.Division_ord :
            specificBuilder.Division_();
            break;
            case QueriesEntityDescriptorEnum.Remainder_ord :
            specificBuilder.Remainder_();
            break;
            case QueriesEntityDescriptorEnum.Equals_ord :
            specificBuilder.Equals_();
            break;
            case QueriesEntityDescriptorEnum.NotEquals_ord :
            specificBuilder.NotEquals_();
            break;
            case QueriesEntityDescriptorEnum.LessThan_ord :
            specificBuilder.LessThan_();
            break;
            case QueriesEntityDescriptorEnum.LessOrEquals_ord :
            specificBuilder.LessOrEquals_();
            break;
            case QueriesEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder.GreaterThan_();
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEquals_ord :
            specificBuilder.GreaterOrEquals_();
            break;
            case QueriesEntityDescriptorEnum.VoidLiteral_ord :
            specificBuilder.VoidLiteral_();
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.QueryDeclaration_ord :
            specificBuilder._QueryDeclaration();
            break;
            case QueriesEntityDescriptorEnum.Path_ord :
            specificBuilder._Path();
            break;
            case QueriesEntityDescriptorEnum.Delete_ord :
            specificBuilder._Delete();
            break;
            case QueriesEntityDescriptorEnum.CartesianInsert_ord :
            specificBuilder._CartesianInsert();
            break;
            case QueriesEntityDescriptorEnum.PointwiseInsert_ord :
            specificBuilder._PointwiseInsert();
            break;
            case QueriesEntityDescriptorEnum.CartesianUpdate_ord :
            specificBuilder._CartesianUpdate();
            break;
            case QueriesEntityDescriptorEnum.PointwiseUpdate_ord :
            specificBuilder._PointwiseUpdate();
            break;
            case QueriesEntityDescriptorEnum.Select_ord :
            specificBuilder._Select();
            break;
            case QueriesEntityDescriptorEnum.For_ord :
            specificBuilder._For();
            break;
            case QueriesEntityDescriptorEnum.If_ord :
            specificBuilder._If();
            break;
            case QueriesEntityDescriptorEnum.Do_ord :
            specificBuilder._Do();
            break;
            case QueriesEntityDescriptorEnum.EntityTemplate_ord :
            specificBuilder._EntityTemplate();
            break;
            case QueriesEntityDescriptorEnum.EntityCall_ord :
            specificBuilder._EntityCall();
            break;
            case QueriesEntityDescriptorEnum.Call_ord :
            specificBuilder._Call();
            break;
            case QueriesEntityDescriptorEnum.Expressions_ord :
            specificBuilder._Expressions();
            break;
            case QueriesEntityDescriptorEnum.Bindings_ord :
            specificBuilder._Bindings();
            break;
            case QueriesEntityDescriptorEnum.Bind_ord :
            specificBuilder._Bind();
            break;
            case QueriesEntityDescriptorEnum.Choose_ord :
            specificBuilder._Choose();
            break;
            case QueriesEntityDescriptorEnum.Block_ord :
            specificBuilder._Block();
            break;
            case QueriesEntityDescriptorEnum.Sequence_ord :
            specificBuilder._Sequence();
            break;
            case QueriesEntityDescriptorEnum.Scope_ord :
            specificBuilder._Scope();
            break;
            case QueriesEntityDescriptorEnum.CartesianProduct_ord :
            specificBuilder._CartesianProduct();
            break;
            case QueriesEntityDescriptorEnum.PointwiseProduct_ord :
            specificBuilder._PointwiseProduct();
            break;
            case QueriesEntityDescriptorEnum.Filter_ord :
            specificBuilder._Filter();
            break;
            case QueriesEntityDescriptorEnum.AspectStep_ord :
            specificBuilder._AspectStep();
            break;
            case QueriesEntityDescriptorEnum.AdjacentStep_ord :
            specificBuilder._AdjacentStep();
            break;
            case QueriesEntityDescriptorEnum.ReachableStep_ord :
            specificBuilder._ReachableStep();
            break;
            case QueriesEntityDescriptorEnum.ReachableOrSelfStep_ord :
            specificBuilder._ReachableOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.InverseAdjacentStep_ord :
            specificBuilder._InverseAdjacentStep();
            break;
            case QueriesEntityDescriptorEnum.InverseReachableStep_ord :
            specificBuilder._InverseReachableStep();
            break;
            case QueriesEntityDescriptorEnum.InverseReachableOrSelfStep_ord :
            specificBuilder._InverseReachableOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.RootStep_ord :
            specificBuilder._RootStep();
            break;
            case QueriesEntityDescriptorEnum.FragmentRootStep_ord :
            specificBuilder._FragmentRootStep();
            break;
            case QueriesEntityDescriptorEnum.SelfStep_ord :
            specificBuilder._SelfStep();
            break;
            case QueriesEntityDescriptorEnum.ChildStep_ord :
            specificBuilder._ChildStep();
            break;
            case QueriesEntityDescriptorEnum.DescendantStep_ord :
            specificBuilder._DescendantStep();
            break;
            case QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord :
            specificBuilder._DescendantOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.FollowingSiblingStep_ord :
            specificBuilder._FollowingSiblingStep();
            break;
            case QueriesEntityDescriptorEnum.FollowingStep_ord :
            specificBuilder._FollowingStep();
            break;
            case QueriesEntityDescriptorEnum.ParentStep_ord :
            specificBuilder._ParentStep();
            break;
            case QueriesEntityDescriptorEnum.AncestorStep_ord :
            specificBuilder._AncestorStep();
            break;
            case QueriesEntityDescriptorEnum.AncestorOrSelfStep_ord :
            specificBuilder._AncestorOrSelfStep();
            break;
            case QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord :
            specificBuilder._PrecedingSiblingStep();
            break;
            case QueriesEntityDescriptorEnum.PrecedingStep_ord :
            specificBuilder._PrecedingStep();
            break;
            case QueriesEntityDescriptorEnum.AdditionStep_ord :
            specificBuilder._AdditionStep();
            break;
            case QueriesEntityDescriptorEnum.SubtractionStep_ord :
            specificBuilder._SubtractionStep();
            break;
            case QueriesEntityDescriptorEnum.MultiplicationStep_ord :
            specificBuilder._MultiplicationStep();
            break;
            case QueriesEntityDescriptorEnum.DivisionStep_ord :
            specificBuilder._DivisionStep();
            break;
            case QueriesEntityDescriptorEnum.RemainderStep_ord :
            specificBuilder._RemainderStep();
            break;
            case QueriesEntityDescriptorEnum.EqualsStep_ord :
            specificBuilder._EqualsStep();
            break;
            case QueriesEntityDescriptorEnum.NotEqualsStep_ord :
            specificBuilder._NotEqualsStep();
            break;
            case QueriesEntityDescriptorEnum.LessThanStep_ord :
            specificBuilder._LessThanStep();
            break;
            case QueriesEntityDescriptorEnum.LessOrEqualsStep_ord :
            specificBuilder._LessOrEqualsStep();
            break;
            case QueriesEntityDescriptorEnum.GreaterThanStep_ord :
            specificBuilder._GreaterThanStep();
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEqualsStep_ord :
            specificBuilder._GreaterOrEqualsStep();
            break;
            case QueriesEntityDescriptorEnum.Prune_ord :
            specificBuilder._Prune();
            break;
            case QueriesEntityDescriptorEnum.IndexTest_ord :
            specificBuilder._IndexTest();
            break;
            case QueriesEntityDescriptorEnum.IndexRangeTest_ord :
            specificBuilder._IndexRangeTest();
            break;
            case QueriesEntityDescriptorEnum.ExpressionTest_ord :
            specificBuilder._ExpressionTest();
            break;
            case QueriesEntityDescriptorEnum.DistinctTest_ord :
            specificBuilder._DistinctTest();
            break;
            case QueriesEntityDescriptorEnum.And_ord :
            specificBuilder._And();
            break;
            case QueriesEntityDescriptorEnum.Or_ord :
            specificBuilder._Or();
            break;
            case QueriesEntityDescriptorEnum.Not_ord :
            specificBuilder._Not();
            break;
            case QueriesEntityDescriptorEnum.One_ord :
            specificBuilder._One();
            break;
            case QueriesEntityDescriptorEnum.Some_ord :
            specificBuilder._Some();
            break;
            case QueriesEntityDescriptorEnum.Every_ord :
            specificBuilder._Every();
            break;
            case QueriesEntityDescriptorEnum.ParenthesizedPredicate_ord :
            specificBuilder._ParenthesizedPredicate();
            break;
            case QueriesEntityDescriptorEnum.TemplateNames_ord :
            specificBuilder._TemplateNames();
            break;
            case QueriesEntityDescriptorEnum.AllNames_ord :
            specificBuilder._AllNames();
            break;
            case QueriesEntityDescriptorEnum.AddNames_ord :
            specificBuilder._AddNames();
            break;
            case QueriesEntityDescriptorEnum.RemoveNames_ord :
            specificBuilder._RemoveNames();
            break;
            case QueriesEntityDescriptorEnum.Names_ord :
            specificBuilder._Names();
            break;
            case QueriesEntityDescriptorEnum.IdentityComparator_ord :
            specificBuilder._IdentityComparator();
            break;
            case QueriesEntityDescriptorEnum.UnionAll_ord :
            specificBuilder._UnionAll();
            break;
            case QueriesEntityDescriptorEnum.Union_ord :
            specificBuilder._Union();
            break;
            case QueriesEntityDescriptorEnum.Intersect_ord :
            specificBuilder._Intersect();
            break;
            case QueriesEntityDescriptorEnum.Except_ord :
            specificBuilder._Except();
            break;
            case QueriesEntityDescriptorEnum.Singleton_ord :
            specificBuilder._Singleton();
            break;
            case QueriesEntityDescriptorEnum.PointwiseEquals_ord :
            specificBuilder._PointwiseEquals();
            break;
            case QueriesEntityDescriptorEnum.Tuple_ord :
            specificBuilder._Tuple();
            break;
            case QueriesEntityDescriptorEnum.Addition_ord :
            specificBuilder._Addition();
            break;
            case QueriesEntityDescriptorEnum.Subtraction_ord :
            specificBuilder._Subtraction();
            break;
            case QueriesEntityDescriptorEnum.Multiplication_ord :
            specificBuilder._Multiplication();
            break;
            case QueriesEntityDescriptorEnum.Division_ord :
            specificBuilder._Division();
            break;
            case QueriesEntityDescriptorEnum.Remainder_ord :
            specificBuilder._Remainder();
            break;
            case QueriesEntityDescriptorEnum.Equals_ord :
            specificBuilder._Equals();
            break;
            case QueriesEntityDescriptorEnum.NotEquals_ord :
            specificBuilder._NotEquals();
            break;
            case QueriesEntityDescriptorEnum.LessThan_ord :
            specificBuilder._LessThan();
            break;
            case QueriesEntityDescriptorEnum.LessOrEquals_ord :
            specificBuilder._LessOrEquals();
            break;
            case QueriesEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder._GreaterThan();
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEquals_ord :
            specificBuilder._GreaterOrEquals();
            break;
            case QueriesEntityDescriptorEnum.VoidLiteral_ord :
            specificBuilder._VoidLiteral();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.Path_ord :
            specificBuilder.Path_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Expressions_ord :
            specificBuilder.Expressions_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Bindings_ord :
            specificBuilder.Bindings_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Choose_ord :
            specificBuilder.Choose_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Block_ord :
            specificBuilder.Block_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Sequence_ord :
            specificBuilder.Sequence_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.CartesianProduct_ord :
            specificBuilder.CartesianProduct_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.PointwiseProduct_ord :
            specificBuilder.PointwiseProduct_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.And_ord :
            specificBuilder.And_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Or_ord :
            specificBuilder.Or_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Names_ord :
            specificBuilder.Names_(initialCapacity);
            break;
            case QueriesEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple_(initialCapacity);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.FeatureStep_ord :
            specificBuilder.FeatureStep(value);
            break;
            case QueriesEntityDescriptorEnum.VariableTest_ord :
            specificBuilder.VariableTest(value);
            break;
            case QueriesEntityDescriptorEnum.IndexVariableTest_ord :
            specificBuilder.IndexVariableTest(value);
            break;
            case QueriesEntityDescriptorEnum.StageVariableTest_ord :
            specificBuilder.StageVariableTest(value);
            break;
            case QueriesEntityDescriptorEnum.LanguageTest_ord :
            specificBuilder.LanguageTest(value);
            break;
            case QueriesEntityDescriptorEnum.TypeTest_ord :
            specificBuilder.TypeTest(value);
            break;
            case QueriesEntityDescriptorEnum.SubtypeTest_ord :
            specificBuilder.SubtypeTest(value);
            break;
            case QueriesEntityDescriptorEnum.SupertypeTest_ord :
            specificBuilder.SupertypeTest(value);
            break;
            case QueriesEntityDescriptorEnum.ExtendedSubtypeTest_ord :
            specificBuilder.ExtendedSubtypeTest(value);
            break;
            case QueriesEntityDescriptorEnum.ExtendedSupertypeTest_ord :
            specificBuilder.ExtendedSupertypeTest(value);
            break;
            case QueriesEntityDescriptorEnum.AtTypeTest_ord :
            specificBuilder.AtTypeTest(value);
            break;
            case QueriesEntityDescriptorEnum.AtFeatureTest_ord :
            specificBuilder.AtFeatureTest(value);
            break;
            case QueriesEntityDescriptorEnum.EntityType_ord :
            specificBuilder.EntityType(value);
            break;
            case QueriesEntityDescriptorEnum.Name_ord :
            specificBuilder.Name(value);
            break;
            case QueriesEntityDescriptorEnum.VariableRefStep_ord :
            specificBuilder.VariableRefStep(value);
            break;
            case QueriesEntityDescriptorEnum.StringLiteral_ord :
            specificBuilder.StringLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.KindTest_ord :
            specificBuilder.KindTest((Value) value);
            break;
            case QueriesEntityDescriptorEnum.StageTest_ord :
            specificBuilder.StageTest((org.whole.lang.queries.model.StageTestEnum.Value) value);
            break;
            case QueriesEntityDescriptorEnum.Placement_ord :
            specificBuilder.Placement((org.whole.lang.queries.model.PlacementEnum.Value) value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.AtIndexTest_ord :
            specificBuilder.AtIndexTest(value);
            break;
            case QueriesEntityDescriptorEnum.IntLiteral_ord :
            specificBuilder.IntLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, IVisitor value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.VisitorTest_ord :
            specificBuilder.VisitorTest(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.BooleanLiteral_ord :
            specificBuilder.BooleanLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.ByteLiteral_ord :
            specificBuilder.ByteLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, char value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.CharLiteral_ord :
            specificBuilder.CharLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.DoubleLiteral_ord :
            specificBuilder.DoubleLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.FloatLiteral_ord :
            specificBuilder.FloatLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.LongLiteral_ord :
            specificBuilder.LongLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.ShortLiteral_ord :
            specificBuilder.ShortLiteral(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, Date value) {
        switch (entityDesc.getOrdinal()) {
            case QueriesEntityDescriptorEnum.DateLiteral_ord :
            specificBuilder.DateLiteral(value);
            break;
        }
    }
}
