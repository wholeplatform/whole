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
package org.whole.lang.queries.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class QueriesIdentitySwitchVisitor extends AbstractVisitor implements IQueriesVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case QueriesEntityDescriptorEnum.QueryDeclaration_ord :
            visit((QueryDeclaration) entity);
            break;
            case QueriesEntityDescriptorEnum.Path_ord :
            visit((Path) entity);
            break;
            case QueriesEntityDescriptorEnum.Delete_ord :
            visit((Delete) entity);
            break;
            case QueriesEntityDescriptorEnum.CartesianInsert_ord :
            visit((CartesianInsert) entity);
            break;
            case QueriesEntityDescriptorEnum.PointwiseInsert_ord :
            visit((PointwiseInsert) entity);
            break;
            case QueriesEntityDescriptorEnum.CartesianUpdate_ord :
            visit((CartesianUpdate) entity);
            break;
            case QueriesEntityDescriptorEnum.PointwiseUpdate_ord :
            visit((PointwiseUpdate) entity);
            break;
            case QueriesEntityDescriptorEnum.Select_ord :
            visit((Select) entity);
            break;
            case QueriesEntityDescriptorEnum.For_ord :
            visit((For) entity);
            break;
            case QueriesEntityDescriptorEnum.If_ord :
            visit((If) entity);
            break;
            case QueriesEntityDescriptorEnum.Do_ord :
            visit((Do) entity);
            break;
            case QueriesEntityDescriptorEnum.EntityTemplate_ord :
            visit((EntityTemplate) entity);
            break;
            case QueriesEntityDescriptorEnum.EntityCall_ord :
            visit((EntityCall) entity);
            break;
            case QueriesEntityDescriptorEnum.Call_ord :
            visit((Call) entity);
            break;
            case QueriesEntityDescriptorEnum.Expressions_ord :
            visit((Expressions) entity);
            break;
            case QueriesEntityDescriptorEnum.Bindings_ord :
            visit((Bindings) entity);
            break;
            case QueriesEntityDescriptorEnum.Bind_ord :
            visit((Bind) entity);
            break;
            case QueriesEntityDescriptorEnum.Choose_ord :
            visit((Choose) entity);
            break;
            case QueriesEntityDescriptorEnum.Block_ord :
            visit((Block) entity);
            break;
            case QueriesEntityDescriptorEnum.Sequence_ord :
            visit((Sequence) entity);
            break;
            case QueriesEntityDescriptorEnum.Scope_ord :
            visit((Scope) entity);
            break;
            case QueriesEntityDescriptorEnum.CartesianProduct_ord :
            visit((CartesianProduct) entity);
            break;
            case QueriesEntityDescriptorEnum.PointwiseProduct_ord :
            visit((PointwiseProduct) entity);
            break;
            case QueriesEntityDescriptorEnum.Filter_ord :
            visit((Filter) entity);
            break;
            case QueriesEntityDescriptorEnum.AspectStep_ord :
            visit((AspectStep) entity);
            break;
            case QueriesEntityDescriptorEnum.AdjacentStep_ord :
            visit((AdjacentStep) entity);
            break;
            case QueriesEntityDescriptorEnum.ReachableStep_ord :
            visit((ReachableStep) entity);
            break;
            case QueriesEntityDescriptorEnum.ReachableOrSelfStep_ord :
            visit((ReachableOrSelfStep) entity);
            break;
            case QueriesEntityDescriptorEnum.InverseAdjacentStep_ord :
            visit((InverseAdjacentStep) entity);
            break;
            case QueriesEntityDescriptorEnum.InverseReachableStep_ord :
            visit((InverseReachableStep) entity);
            break;
            case QueriesEntityDescriptorEnum.InverseReachableOrSelfStep_ord :
            visit((InverseReachableOrSelfStep) entity);
            break;
            case QueriesEntityDescriptorEnum.RootStep_ord :
            visit((RootStep) entity);
            break;
            case QueriesEntityDescriptorEnum.FragmentRootStep_ord :
            visit((FragmentRootStep) entity);
            break;
            case QueriesEntityDescriptorEnum.SelfStep_ord :
            visit((SelfStep) entity);
            break;
            case QueriesEntityDescriptorEnum.FeatureStep_ord :
            visit((FeatureStep) entity);
            break;
            case QueriesEntityDescriptorEnum.ChildStep_ord :
            visit((ChildStep) entity);
            break;
            case QueriesEntityDescriptorEnum.DescendantStep_ord :
            visit((DescendantStep) entity);
            break;
            case QueriesEntityDescriptorEnum.DescendantOrSelfStep_ord :
            visit((DescendantOrSelfStep) entity);
            break;
            case QueriesEntityDescriptorEnum.FollowingSiblingStep_ord :
            visit((FollowingSiblingStep) entity);
            break;
            case QueriesEntityDescriptorEnum.FollowingStep_ord :
            visit((FollowingStep) entity);
            break;
            case QueriesEntityDescriptorEnum.ParentStep_ord :
            visit((ParentStep) entity);
            break;
            case QueriesEntityDescriptorEnum.AncestorStep_ord :
            visit((AncestorStep) entity);
            break;
            case QueriesEntityDescriptorEnum.AncestorOrSelfStep_ord :
            visit((AncestorOrSelfStep) entity);
            break;
            case QueriesEntityDescriptorEnum.PrecedingSiblingStep_ord :
            visit((PrecedingSiblingStep) entity);
            break;
            case QueriesEntityDescriptorEnum.PrecedingStep_ord :
            visit((PrecedingStep) entity);
            break;
            case QueriesEntityDescriptorEnum.AdditionStep_ord :
            visit((AdditionStep) entity);
            break;
            case QueriesEntityDescriptorEnum.SubtractionStep_ord :
            visit((SubtractionStep) entity);
            break;
            case QueriesEntityDescriptorEnum.MultiplicationStep_ord :
            visit((MultiplicationStep) entity);
            break;
            case QueriesEntityDescriptorEnum.DivisionStep_ord :
            visit((DivisionStep) entity);
            break;
            case QueriesEntityDescriptorEnum.RemainderStep_ord :
            visit((RemainderStep) entity);
            break;
            case QueriesEntityDescriptorEnum.EqualsStep_ord :
            visit((EqualsStep) entity);
            break;
            case QueriesEntityDescriptorEnum.NotEqualsStep_ord :
            visit((NotEqualsStep) entity);
            break;
            case QueriesEntityDescriptorEnum.LessThanStep_ord :
            visit((LessThanStep) entity);
            break;
            case QueriesEntityDescriptorEnum.LessOrEqualsStep_ord :
            visit((LessOrEqualsStep) entity);
            break;
            case QueriesEntityDescriptorEnum.GreaterThanStep_ord :
            visit((GreaterThanStep) entity);
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEqualsStep_ord :
            visit((GreaterOrEqualsStep) entity);
            break;
            case QueriesEntityDescriptorEnum.Prune_ord :
            visit((Prune) entity);
            break;
            case QueriesEntityDescriptorEnum.VariableTest_ord :
            visit((VariableTest) entity);
            break;
            case QueriesEntityDescriptorEnum.IndexVariableTest_ord :
            visit((IndexVariableTest) entity);
            break;
            case QueriesEntityDescriptorEnum.KindTest_ord :
            visit((KindTest) entity);
            break;
            case QueriesEntityDescriptorEnum.StageTest_ord :
            visit((StageTest) entity);
            break;
            case QueriesEntityDescriptorEnum.StageVariableTest_ord :
            visit((StageVariableTest) entity);
            break;
            case QueriesEntityDescriptorEnum.LanguageTest_ord :
            visit((LanguageTest) entity);
            break;
            case QueriesEntityDescriptorEnum.TypeTest_ord :
            visit((TypeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.SubtypeTest_ord :
            visit((SubtypeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.SupertypeTest_ord :
            visit((SupertypeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.ExtendedSubtypeTest_ord :
            visit((ExtendedSubtypeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.ExtendedSupertypeTest_ord :
            visit((ExtendedSupertypeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.AtTypeTest_ord :
            visit((AtTypeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.AtFeatureTest_ord :
            visit((AtFeatureTest) entity);
            break;
            case QueriesEntityDescriptorEnum.AtIndexTest_ord :
            visit((AtIndexTest) entity);
            break;
            case QueriesEntityDescriptorEnum.IndexTest_ord :
            visit((IndexTest) entity);
            break;
            case QueriesEntityDescriptorEnum.IndexRangeTest_ord :
            visit((IndexRangeTest) entity);
            break;
            case QueriesEntityDescriptorEnum.VisitorTest_ord :
            visit((VisitorTest) entity);
            break;
            case QueriesEntityDescriptorEnum.ExpressionTest_ord :
            visit((ExpressionTest) entity);
            break;
            case QueriesEntityDescriptorEnum.DistinctTest_ord :
            visit((DistinctTest) entity);
            break;
            case QueriesEntityDescriptorEnum.And_ord :
            visit((And) entity);
            break;
            case QueriesEntityDescriptorEnum.Or_ord :
            visit((Or) entity);
            break;
            case QueriesEntityDescriptorEnum.Not_ord :
            visit((Not) entity);
            break;
            case QueriesEntityDescriptorEnum.One_ord :
            visit((One) entity);
            break;
            case QueriesEntityDescriptorEnum.Some_ord :
            visit((Some) entity);
            break;
            case QueriesEntityDescriptorEnum.Every_ord :
            visit((Every) entity);
            break;
            case QueriesEntityDescriptorEnum.ParenthesizedPredicate_ord :
            visit((ParenthesizedPredicate) entity);
            break;
            case QueriesEntityDescriptorEnum.EntityType_ord :
            visit((EntityType) entity);
            break;
            case QueriesEntityDescriptorEnum.TemplateNames_ord :
            visit((TemplateNames) entity);
            break;
            case QueriesEntityDescriptorEnum.AllNames_ord :
            visit((AllNames) entity);
            break;
            case QueriesEntityDescriptorEnum.AddNames_ord :
            visit((AddNames) entity);
            break;
            case QueriesEntityDescriptorEnum.RemoveNames_ord :
            visit((RemoveNames) entity);
            break;
            case QueriesEntityDescriptorEnum.Names_ord :
            visit((Names) entity);
            break;
            case QueriesEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case QueriesEntityDescriptorEnum.IdentityComparator_ord :
            visit((IdentityComparator) entity);
            break;
            case QueriesEntityDescriptorEnum.UnionAll_ord :
            visit((UnionAll) entity);
            break;
            case QueriesEntityDescriptorEnum.Union_ord :
            visit((Union) entity);
            break;
            case QueriesEntityDescriptorEnum.Intersect_ord :
            visit((Intersect) entity);
            break;
            case QueriesEntityDescriptorEnum.Except_ord :
            visit((Except) entity);
            break;
            case QueriesEntityDescriptorEnum.VariableRefStep_ord :
            visit((VariableRefStep) entity);
            break;
            case QueriesEntityDescriptorEnum.Singleton_ord :
            visit((Singleton) entity);
            break;
            case QueriesEntityDescriptorEnum.PointwiseEquals_ord :
            visit((PointwiseEquals) entity);
            break;
            case QueriesEntityDescriptorEnum.Tuple_ord :
            visit((Tuple) entity);
            break;
            case QueriesEntityDescriptorEnum.Addition_ord :
            visit((Addition) entity);
            break;
            case QueriesEntityDescriptorEnum.Subtraction_ord :
            visit((Subtraction) entity);
            break;
            case QueriesEntityDescriptorEnum.Multiplication_ord :
            visit((Multiplication) entity);
            break;
            case QueriesEntityDescriptorEnum.Division_ord :
            visit((Division) entity);
            break;
            case QueriesEntityDescriptorEnum.Remainder_ord :
            visit((Remainder) entity);
            break;
            case QueriesEntityDescriptorEnum.Equals_ord :
            visit((Equals) entity);
            break;
            case QueriesEntityDescriptorEnum.NotEquals_ord :
            visit((NotEquals) entity);
            break;
            case QueriesEntityDescriptorEnum.LessThan_ord :
            visit((LessThan) entity);
            break;
            case QueriesEntityDescriptorEnum.LessOrEquals_ord :
            visit((LessOrEquals) entity);
            break;
            case QueriesEntityDescriptorEnum.GreaterThan_ord :
            visit((GreaterThan) entity);
            break;
            case QueriesEntityDescriptorEnum.GreaterOrEquals_ord :
            visit((GreaterOrEquals) entity);
            break;
            case QueriesEntityDescriptorEnum.VoidLiteral_ord :
            visit((VoidLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.BooleanLiteral_ord :
            visit((BooleanLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.ByteLiteral_ord :
            visit((ByteLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.CharLiteral_ord :
            visit((CharLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.DoubleLiteral_ord :
            visit((DoubleLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.FloatLiteral_ord :
            visit((FloatLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.IntLiteral_ord :
            visit((IntLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.LongLiteral_ord :
            visit((LongLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.ShortLiteral_ord :
            visit((ShortLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.DateLiteral_ord :
            visit((DateLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.StringLiteral_ord :
            visit((StringLiteral) entity);
            break;
            case QueriesEntityDescriptorEnum.Placement_ord :
            visit((Placement) entity);
            break;
        }
    }
}
