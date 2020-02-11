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
package org.whole.lang.queries.visitors;

import org.whole.lang.queries.model.*;

/**
 *  @generator Whole
 */
public class QueriesForwardStagedVisitor extends QueriesIdentityVisitor {

    public void visit(QueryDeclaration entity) {
        stagedVisit(entity);
    }

    public void visit(Path entity) {
        stagedVisit(entity);
    }

    public void visit(Clone entity) {
        stagedVisit(entity);
    }

    public void visit(Create entity) {
        stagedVisit(entity);
    }

    public void visit(Delete entity) {
        stagedVisit(entity);
    }

    public void visit(Insert entity) {
        stagedVisit(entity);
    }

    public void visit(CartesianInsert entity) {
        stagedVisit(entity);
    }

    public void visit(PointwiseInsert entity) {
        stagedVisit(entity);
    }

    public void visit(Update entity) {
        stagedVisit(entity);
    }

    public void visit(CartesianUpdate entity) {
        stagedVisit(entity);
    }

    public void visit(PointwiseUpdate entity) {
        stagedVisit(entity);
    }

    public void visit(Select entity) {
        stagedVisit(entity);
    }

    public void visit(For entity) {
        stagedVisit(entity);
    }

    public void visit(If entity) {
        stagedVisit(entity);
    }

    public void visit(Do entity) {
        stagedVisit(entity);
    }

    public void visit(Call entity) {
        stagedVisit(entity);
    }

    public void visit(Expressions entity) {
        stagedVisit(entity);
    }

    public void visit(Choose entity) {
        stagedVisit(entity);
    }

    public void visit(Block entity) {
        stagedVisit(entity);
    }

    public void visit(Sequence entity) {
        stagedVisit(entity);
    }

    public void visit(Scope entity) {
        stagedVisit(entity);
    }

    public void visit(CartesianProduct entity) {
        stagedVisit(entity);
    }

    public void visit(PointwiseProduct entity) {
        stagedVisit(entity);
    }

    public void visit(Filter entity) {
        stagedVisit(entity);
    }

    public void visit(Reverse entity) {
        stagedVisit(entity);
    }

    public void visit(AspectStep entity) {
        stagedVisit(entity);
    }

    public void visit(AdjacentStep entity) {
        stagedVisit(entity);
    }

    public void visit(ReachableStep entity) {
        stagedVisit(entity);
    }

    public void visit(ReachableOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(InverseAdjacentStep entity) {
        stagedVisit(entity);
    }

    public void visit(InverseReachableStep entity) {
        stagedVisit(entity);
    }

    public void visit(InverseReachableOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(RootStep entity) {
        stagedVisit(entity);
    }

    public void visit(FragmentRootStep entity) {
        stagedVisit(entity);
    }

    public void visit(SelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(FeatureStep entity) {
        stagedVisit(entity);
    }

    public void visit(ChildStep entity) {
        stagedVisit(entity);
    }

    public void visit(DescendantStep entity) {
        stagedVisit(entity);
    }

    public void visit(DescendantOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(FollowingSiblingStep entity) {
        stagedVisit(entity);
    }

    public void visit(FollowingSiblingOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(FollowingStep entity) {
        stagedVisit(entity);
    }

    public void visit(FollowingOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(ParentStep entity) {
        stagedVisit(entity);
    }

    public void visit(AncestorStep entity) {
        stagedVisit(entity);
    }

    public void visit(AncestorOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedingSiblingStep entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedingSiblingOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedingStep entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedingOrSelfStep entity) {
        stagedVisit(entity);
    }

    public void visit(Prune entity) {
        stagedVisit(entity);
    }

    public void visit(VariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(StageVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(LanguageVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(TypeVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(SubtypeVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(SupertypeVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(ExtendedSubtypeVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(ExtendedSupertypeVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(IndexVariableTest entity) {
        stagedVisit(entity);
    }

    public void visit(KindTest entity) {
        stagedVisit(entity);
    }

    public void visit(CompositeKindTest entity) {
        stagedVisit(entity);
    }

    public void visit(DataKindTest entity) {
        stagedVisit(entity);
    }

    public void visit(StageTest entity) {
        stagedVisit(entity);
    }

    public void visit(LanguageTest entity) {
        stagedVisit(entity);
    }

    public void visit(TypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(SubtypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(SupertypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(ExtendedSubtypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(ExtendedSupertypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(AtTypeTest entity) {
        stagedVisit(entity);
    }

    public void visit(AtFeatureTest entity) {
        stagedVisit(entity);
    }

    public void visit(AtIndexTest entity) {
        stagedVisit(entity);
    }

    public void visit(IndexTest entity) {
        stagedVisit(entity);
    }

    public void visit(IndexRangeTest entity) {
        stagedVisit(entity);
    }

    public void visit(VisitorTest entity) {
        stagedVisit(entity);
    }

    public void visit(MatchTest entity) {
        stagedVisit(entity);
    }

    public void visit(DistinctTest entity) {
        stagedVisit(entity);
    }

    public void visit(And entity) {
        stagedVisit(entity);
    }

    public void visit(Or entity) {
        stagedVisit(entity);
    }

    public void visit(Not entity) {
        stagedVisit(entity);
    }

    public void visit(One entity) {
        stagedVisit(entity);
    }

    public void visit(Some entity) {
        stagedVisit(entity);
    }

    public void visit(Every entity) {
        stagedVisit(entity);
    }

    public void visit(TemplateNames entity) {
        stagedVisit(entity);
    }

    public void visit(AllNames entity) {
        stagedVisit(entity);
    }

    public void visit(AddNames entity) {
        stagedVisit(entity);
    }

    public void visit(RemoveNames entity) {
        stagedVisit(entity);
    }

    public void visit(Names entity) {
        stagedVisit(entity);
    }

    public void visit(FreshNames entity) {
        stagedVisit(entity);
    }

    public void visit(ScopeNames entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(AdditionStep entity) {
        stagedVisit(entity);
    }

    public void visit(SubtractionStep entity) {
        stagedVisit(entity);
    }

    public void visit(MultiplicationStep entity) {
        stagedVisit(entity);
    }

    public void visit(DivisionStep entity) {
        stagedVisit(entity);
    }

    public void visit(RemainderStep entity) {
        stagedVisit(entity);
    }

    public void visit(EqualsStep entity) {
        stagedVisit(entity);
    }

    public void visit(NotEqualsStep entity) {
        stagedVisit(entity);
    }

    public void visit(LessThanStep entity) {
        stagedVisit(entity);
    }

    public void visit(LessOrEqualsStep entity) {
        stagedVisit(entity);
    }

    public void visit(GreaterThanStep entity) {
        stagedVisit(entity);
    }

    public void visit(GreaterOrEqualsStep entity) {
        stagedVisit(entity);
    }

    public void visit(IdentityComparator entity) {
        stagedVisit(entity);
    }

    public void visit(UnionAll entity) {
        stagedVisit(entity);
    }

    public void visit(Union entity) {
        stagedVisit(entity);
    }

    public void visit(Intersect entity) {
        stagedVisit(entity);
    }

    public void visit(Except entity) {
        stagedVisit(entity);
    }

    public void visit(VariableRefStep entity) {
        stagedVisit(entity);
    }

    public void visit(Singleton entity) {
        stagedVisit(entity);
    }

    public void visit(PointwiseEquals entity) {
        stagedVisit(entity);
    }

    public void visit(Tuple entity) {
        stagedVisit(entity);
    }

    public void visit(Addition entity) {
        stagedVisit(entity);
    }

    public void visit(Subtraction entity) {
        stagedVisit(entity);
    }

    public void visit(Multiplication entity) {
        stagedVisit(entity);
    }

    public void visit(Division entity) {
        stagedVisit(entity);
    }

    public void visit(Remainder entity) {
        stagedVisit(entity);
    }

    public void visit(Equals entity) {
        stagedVisit(entity);
    }

    public void visit(NotEquals entity) {
        stagedVisit(entity);
    }

    public void visit(LessThan entity) {
        stagedVisit(entity);
    }

    public void visit(LessOrEquals entity) {
        stagedVisit(entity);
    }

    public void visit(GreaterThan entity) {
        stagedVisit(entity);
    }

    public void visit(GreaterOrEquals entity) {
        stagedVisit(entity);
    }

    public void visit(EntityType entity) {
        stagedVisit(entity);
    }

    public void visit(Registry entity) {
        stagedVisit(entity);
    }

    public void visit(Children entity) {
        stagedVisit(entity);
    }

    public void visit(Features entity) {
        stagedVisit(entity);
    }

    public void visit(Feature entity) {
        stagedVisit(entity);
    }

    public void visit(VoidLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(BooleanLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(ByteLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(CharLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(DoubleLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(FloatLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(IntLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(LongLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(ShortLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(DateLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(Placement entity) {
        stagedVisit(entity);
    }
}
