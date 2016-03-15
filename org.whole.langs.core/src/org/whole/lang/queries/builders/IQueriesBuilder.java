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

import org.whole.lang.builders.IBuilder;
import org.whole.lang.queries.model.KindTestEnum;
import org.whole.lang.queries.model.StageTestEnum;
import org.whole.lang.visitors.IVisitor;
import java.util.Date;
import org.whole.lang.queries.model.PlacementEnum;

/**
 *  @generator Whole
 */
public interface IQueriesBuilder extends IBuilder {


    public void visit();

    public void exp2();

    public void exp1();

    public void pexp2();

    public void pexp1();

    public void identity();

    public void expressions();

    public void names();

    public void comparator();

    public void endIndex();

    public void startIndex();

    public void index();

    public void localNames();

    public void arguments();

    public void bindings();

    public void constraints();

    public void predicate();

    public void expression();

    public void clearClause();

    public void whereClause();

    public void selectClause();

    public void valuesClause();

    public void placement();

    public void fromClause();

    public void body();

    public void parameters();

    public void name();

    public void QueryDeclaration();

    public void QueryDeclaration_();

    public void _QueryDeclaration();

    public void Path();

    public void Path_();

    public void Path_(int initialCapacity);

    public void _Path();

    public void Delete();

    public void Delete_();

    public void _Delete();

    public void CartesianInsert();

    public void CartesianInsert_();

    public void _CartesianInsert();

    public void PointwiseInsert();

    public void PointwiseInsert_();

    public void _PointwiseInsert();

    public void CartesianUpdate();

    public void CartesianUpdate_();

    public void _CartesianUpdate();

    public void PointwiseUpdate();

    public void PointwiseUpdate_();

    public void _PointwiseUpdate();

    public void Select();

    public void Select_();

    public void _Select();

    public void For();

    public void For_();

    public void _For();

    public void If();

    public void If_();

    public void _If();

    public void Do();

    public void Do_();

    public void _Do();

    public void EntityTemplate();

    public void EntityTemplate_();

    public void _EntityTemplate();

    public void EntityCall();

    public void EntityCall_();

    public void _EntityCall();

    public void Call();

    public void Call_();

    public void _Call();

    public void Expressions();

    public void Expressions_();

    public void Expressions_(int initialCapacity);

    public void _Expressions();

    public void Bindings();

    public void Bindings_();

    public void Bindings_(int initialCapacity);

    public void _Bindings();

    public void Bind();

    public void Bind_();

    public void _Bind();

    public void Choose();

    public void Choose_();

    public void Choose_(int initialCapacity);

    public void _Choose();

    public void Block();

    public void Block_();

    public void Block_(int initialCapacity);

    public void _Block();

    public void Sequence();

    public void Sequence_();

    public void Sequence_(int initialCapacity);

    public void _Sequence();

    public void Scope();

    public void Scope_();

    public void _Scope();

    public void CartesianProduct();

    public void CartesianProduct_();

    public void CartesianProduct_(int initialCapacity);

    public void _CartesianProduct();

    public void PointwiseProduct();

    public void PointwiseProduct_();

    public void PointwiseProduct_(int initialCapacity);

    public void _PointwiseProduct();

    public void Filter();

    public void Filter_();

    public void _Filter();

    public void AspectStep();

    public void AspectStep_();

    public void _AspectStep();

    public void AdjacentStep();

    public void AdjacentStep_();

    public void _AdjacentStep();

    public void ReachableStep();

    public void ReachableStep_();

    public void _ReachableStep();

    public void ReachableOrSelfStep();

    public void ReachableOrSelfStep_();

    public void _ReachableOrSelfStep();

    public void InverseAdjacentStep();

    public void InverseAdjacentStep_();

    public void _InverseAdjacentStep();

    public void InverseReachableStep();

    public void InverseReachableStep_();

    public void _InverseReachableStep();

    public void InverseReachableOrSelfStep();

    public void InverseReachableOrSelfStep_();

    public void _InverseReachableOrSelfStep();

    public void RootStep();

    public void RootStep_();

    public void _RootStep();

    public void FragmentRootStep();

    public void FragmentRootStep_();

    public void _FragmentRootStep();

    public void SelfStep();

    public void SelfStep_();

    public void _SelfStep();

    public void FeatureStep();

    public void FeatureStep(String value);

    public void ChildStep();

    public void ChildStep_();

    public void _ChildStep();

    public void DescendantStep();

    public void DescendantStep_();

    public void _DescendantStep();

    public void DescendantOrSelfStep();

    public void DescendantOrSelfStep_();

    public void _DescendantOrSelfStep();

    public void FollowingSiblingStep();

    public void FollowingSiblingStep_();

    public void _FollowingSiblingStep();

    public void FollowingStep();

    public void FollowingStep_();

    public void _FollowingStep();

    public void ParentStep();

    public void ParentStep_();

    public void _ParentStep();

    public void AncestorStep();

    public void AncestorStep_();

    public void _AncestorStep();

    public void AncestorOrSelfStep();

    public void AncestorOrSelfStep_();

    public void _AncestorOrSelfStep();

    public void PrecedingSiblingStep();

    public void PrecedingSiblingStep_();

    public void _PrecedingSiblingStep();

    public void PrecedingStep();

    public void PrecedingStep_();

    public void _PrecedingStep();

    public void AdditionStep();

    public void AdditionStep_();

    public void _AdditionStep();

    public void SubtractionStep();

    public void SubtractionStep_();

    public void _SubtractionStep();

    public void MultiplicationStep();

    public void MultiplicationStep_();

    public void _MultiplicationStep();

    public void DivisionStep();

    public void DivisionStep_();

    public void _DivisionStep();

    public void RemainderStep();

    public void RemainderStep_();

    public void _RemainderStep();

    public void EqualsStep();

    public void EqualsStep_();

    public void _EqualsStep();

    public void NotEqualsStep();

    public void NotEqualsStep_();

    public void _NotEqualsStep();

    public void LessThanStep();

    public void LessThanStep_();

    public void _LessThanStep();

    public void LessOrEqualsStep();

    public void LessOrEqualsStep_();

    public void _LessOrEqualsStep();

    public void GreaterThanStep();

    public void GreaterThanStep_();

    public void _GreaterThanStep();

    public void GreaterOrEqualsStep();

    public void GreaterOrEqualsStep_();

    public void _GreaterOrEqualsStep();

    public void Prune();

    public void Prune_();

    public void _Prune();

    public void VariableTest();

    public void VariableTest(String value);

    public void IndexVariableTest();

    public void IndexVariableTest(String value);

    public void KindTest();

    public void KindTest(KindTestEnum.Value value);

    public void KindTest(String value);

    public void StageTest();

    public void StageTest(StageTestEnum.Value value);

    public void StageTest(String value);

    public void StageVariableTest();

    public void StageVariableTest(String value);

    public void LanguageTest();

    public void LanguageTest(String value);

    public void TypeTest();

    public void TypeTest(String value);

    public void SubtypeTest();

    public void SubtypeTest(String value);

    public void SupertypeTest();

    public void SupertypeTest(String value);

    public void ExtendedSubtypeTest();

    public void ExtendedSubtypeTest(String value);

    public void ExtendedSupertypeTest();

    public void ExtendedSupertypeTest(String value);

    public void AtTypeTest();

    public void AtTypeTest(String value);

    public void AtFeatureTest();

    public void AtFeatureTest(String value);

    public void AtIndexTest();

    public void AtIndexTest(int value);

    public void IndexTest();

    public void IndexTest_();

    public void _IndexTest();

    public void IndexRangeTest();

    public void IndexRangeTest_();

    public void _IndexRangeTest();

    public void VisitorTest();

    public void VisitorTest(IVisitor value);

    public void VisitorTest(String value);

    public void ExpressionTest();

    public void ExpressionTest_();

    public void _ExpressionTest();

    public void DistinctTest();

    public void DistinctTest_();

    public void _DistinctTest();

    public void And();

    public void And_();

    public void And_(int initialCapacity);

    public void _And();

    public void Or();

    public void Or_();

    public void Or_(int initialCapacity);

    public void _Or();

    public void Not();

    public void Not_();

    public void _Not();

    public void One();

    public void One_();

    public void _One();

    public void Some();

    public void Some_();

    public void _Some();

    public void Every();

    public void Every_();

    public void _Every();

    public void ParenthesizedPredicate();

    public void ParenthesizedPredicate_();

    public void _ParenthesizedPredicate();

    public void EntityType();

    public void EntityType(String value);

    public void TemplateNames();

    public void TemplateNames_();

    public void _TemplateNames();

    public void AllNames();

    public void AllNames_();

    public void _AllNames();

    public void AddNames();

    public void AddNames_();

    public void _AddNames();

    public void RemoveNames();

    public void RemoveNames_();

    public void _RemoveNames();

    public void Names();

    public void Names_();

    public void Names_(int initialCapacity);

    public void _Names();

    public void Name();

    public void Name(String value);

    public void IdentityComparator();

    public void IdentityComparator_();

    public void _IdentityComparator();

    public void UnionAll();

    public void UnionAll_();

    public void _UnionAll();

    public void Union();

    public void Union_();

    public void _Union();

    public void Intersect();

    public void Intersect_();

    public void _Intersect();

    public void Except();

    public void Except_();

    public void _Except();

    public void VariableRefStep();

    public void VariableRefStep(String value);

    public void Singleton();

    public void Singleton_();

    public void _Singleton();

    public void PointwiseEquals();

    public void PointwiseEquals_();

    public void _PointwiseEquals();

    public void Tuple();

    public void Tuple_();

    public void Tuple_(int initialCapacity);

    public void _Tuple();

    public void Addition();

    public void Addition_();

    public void _Addition();

    public void Subtraction();

    public void Subtraction_();

    public void _Subtraction();

    public void Multiplication();

    public void Multiplication_();

    public void _Multiplication();

    public void Division();

    public void Division_();

    public void _Division();

    public void Remainder();

    public void Remainder_();

    public void _Remainder();

    public void Equals();

    public void Equals_();

    public void _Equals();

    public void NotEquals();

    public void NotEquals_();

    public void _NotEquals();

    public void LessThan();

    public void LessThan_();

    public void _LessThan();

    public void LessOrEquals();

    public void LessOrEquals_();

    public void _LessOrEquals();

    public void GreaterThan();

    public void GreaterThan_();

    public void _GreaterThan();

    public void GreaterOrEquals();

    public void GreaterOrEquals_();

    public void _GreaterOrEquals();

    public void VoidLiteral();

    public void VoidLiteral_();

    public void _VoidLiteral();

    public void BooleanLiteral();

    public void BooleanLiteral(boolean value);

    public void ByteLiteral();

    public void ByteLiteral(byte value);

    public void CharLiteral();

    public void CharLiteral(char value);

    public void DoubleLiteral();

    public void DoubleLiteral(double value);

    public void FloatLiteral();

    public void FloatLiteral(float value);

    public void IntLiteral();

    public void IntLiteral(int value);

    public void LongLiteral();

    public void LongLiteral(long value);

    public void ShortLiteral();

    public void ShortLiteral(short value);

    public void DateLiteral();

    public void DateLiteral(Date value);

    public void DateLiteral(String value);

    public void StringLiteral();

    public void StringLiteral(String value);

    public void Placement();

    public void Placement(PlacementEnum.Value value);

    public void Placement(String value);
}
