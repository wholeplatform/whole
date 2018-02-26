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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class QueriesForwardStrategyVisitor extends GenericForwardStrategyVisitor<IQueriesVisitor> implements IQueriesVisitor {

    public QueriesForwardStrategyVisitor() {
        this(new QueriesIdentityVisitor());
    }

    public QueriesForwardStrategyVisitor(IQueriesVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IQueriesEntity) entity).accept(this);
    }

    public void visit(QueryDeclaration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Path entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Delete entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CartesianInsert entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointwiseInsert entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CartesianUpdate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointwiseUpdate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Select entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(For entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(If entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Do entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EntityTemplate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EntityCall entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Call entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Expressions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Bindings entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Bind entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Choose entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Block entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Sequence entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Scope entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CartesianProduct entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointwiseProduct entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Filter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Reverse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AspectStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AdjacentStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReachableStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReachableOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InverseAdjacentStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InverseReachableStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InverseReachableOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RootStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FragmentRootStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FeatureStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ChildStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DescendantStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DescendantOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FollowingSiblingStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FollowingSiblingOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FollowingStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FollowingOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ParentStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AncestorStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AncestorOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedingSiblingStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedingSiblingOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedingStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedingOrSelfStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Prune entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StageVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LanguageVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubtypeVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SupertypeVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtendedSubtypeVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtendedSupertypeVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IndexVariableTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(KindTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompositeKindTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DataKindTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StageTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LanguageTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubtypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SupertypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtendedSubtypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtendedSupertypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AtTypeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AtFeatureTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AtIndexTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IndexTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IndexRangeTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VisitorTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MatchTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DistinctTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(And entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Or entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Not entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(One entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Some entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Every entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ParenthesizedPredicate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EntityType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TemplateNames entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AllNames entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AddNames entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RemoveNames entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Names entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FreshNames entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ScopeNames entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AdditionStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubtractionStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MultiplicationStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DivisionStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RemainderStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EqualsStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotEqualsStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LessThanStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LessOrEqualsStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreaterThanStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreaterOrEqualsStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentityComparator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnionAll entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Union entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Intersect entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Except entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableRefStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Singleton entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PointwiseEquals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Tuple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Addition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Subtraction entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Multiplication entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Division entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Remainder entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Equals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotEquals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LessThan entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LessOrEquals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreaterThan entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreaterOrEquals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VoidLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ByteLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CharLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DoubleLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FloatLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LongLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ShortLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DateLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Placement entity) {
        wGetStrategy().visit(entity);
    }
}
