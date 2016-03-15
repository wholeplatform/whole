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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class QueriesIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IQueriesVisitor {

    public QueriesIdentityUnaryVisitor() {
        super(null);
    }

    public QueriesIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IQueriesEntity) entity).accept(this);
    }

    public void visit(QueryDeclaration entity) {
    }

    public void visit(Path entity) {
    }

    public void visit(Delete entity) {
    }

    public void visit(CartesianInsert entity) {
    }

    public void visit(PointwiseInsert entity) {
    }

    public void visit(CartesianUpdate entity) {
    }

    public void visit(PointwiseUpdate entity) {
    }

    public void visit(Select entity) {
    }

    public void visit(For entity) {
    }

    public void visit(If entity) {
    }

    public void visit(Do entity) {
    }

    public void visit(EntityTemplate entity) {
    }

    public void visit(EntityCall entity) {
    }

    public void visit(Call entity) {
    }

    public void visit(Expressions entity) {
    }

    public void visit(Bindings entity) {
    }

    public void visit(Bind entity) {
    }

    public void visit(Choose entity) {
    }

    public void visit(Block entity) {
    }

    public void visit(Sequence entity) {
    }

    public void visit(Scope entity) {
    }

    public void visit(CartesianProduct entity) {
    }

    public void visit(PointwiseProduct entity) {
    }

    public void visit(Filter entity) {
    }

    public void visit(AspectStep entity) {
    }

    public void visit(AdjacentStep entity) {
    }

    public void visit(ReachableStep entity) {
    }

    public void visit(ReachableOrSelfStep entity) {
    }

    public void visit(InverseAdjacentStep entity) {
    }

    public void visit(InverseReachableStep entity) {
    }

    public void visit(InverseReachableOrSelfStep entity) {
    }

    public void visit(RootStep entity) {
    }

    public void visit(FragmentRootStep entity) {
    }

    public void visit(SelfStep entity) {
    }

    public void visit(FeatureStep entity) {
    }

    public void visit(ChildStep entity) {
    }

    public void visit(DescendantStep entity) {
    }

    public void visit(DescendantOrSelfStep entity) {
    }

    public void visit(FollowingSiblingStep entity) {
    }

    public void visit(FollowingStep entity) {
    }

    public void visit(ParentStep entity) {
    }

    public void visit(AncestorStep entity) {
    }

    public void visit(AncestorOrSelfStep entity) {
    }

    public void visit(PrecedingSiblingStep entity) {
    }

    public void visit(PrecedingStep entity) {
    }

    public void visit(AdditionStep entity) {
    }

    public void visit(SubtractionStep entity) {
    }

    public void visit(MultiplicationStep entity) {
    }

    public void visit(DivisionStep entity) {
    }

    public void visit(RemainderStep entity) {
    }

    public void visit(EqualsStep entity) {
    }

    public void visit(NotEqualsStep entity) {
    }

    public void visit(LessThanStep entity) {
    }

    public void visit(LessOrEqualsStep entity) {
    }

    public void visit(GreaterThanStep entity) {
    }

    public void visit(GreaterOrEqualsStep entity) {
    }

    public void visit(Prune entity) {
    }

    public void visit(VariableTest entity) {
    }

    public void visit(IndexVariableTest entity) {
    }

    public void visit(KindTest entity) {
    }

    public void visit(StageTest entity) {
    }

    public void visit(StageVariableTest entity) {
    }

    public void visit(LanguageTest entity) {
    }

    public void visit(TypeTest entity) {
    }

    public void visit(SubtypeTest entity) {
    }

    public void visit(SupertypeTest entity) {
    }

    public void visit(ExtendedSubtypeTest entity) {
    }

    public void visit(ExtendedSupertypeTest entity) {
    }

    public void visit(AtTypeTest entity) {
    }

    public void visit(AtFeatureTest entity) {
    }

    public void visit(AtIndexTest entity) {
    }

    public void visit(IndexTest entity) {
    }

    public void visit(IndexRangeTest entity) {
    }

    public void visit(VisitorTest entity) {
    }

    public void visit(ExpressionTest entity) {
    }

    public void visit(DistinctTest entity) {
    }

    public void visit(And entity) {
    }

    public void visit(Or entity) {
    }

    public void visit(Not entity) {
    }

    public void visit(One entity) {
    }

    public void visit(Some entity) {
    }

    public void visit(Every entity) {
    }

    public void visit(ParenthesizedPredicate entity) {
    }

    public void visit(EntityType entity) {
    }

    public void visit(TemplateNames entity) {
    }

    public void visit(AllNames entity) {
    }

    public void visit(AddNames entity) {
    }

    public void visit(RemoveNames entity) {
    }

    public void visit(Names entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(IdentityComparator entity) {
    }

    public void visit(UnionAll entity) {
    }

    public void visit(Union entity) {
    }

    public void visit(Intersect entity) {
    }

    public void visit(Except entity) {
    }

    public void visit(VariableRefStep entity) {
    }

    public void visit(Singleton entity) {
    }

    public void visit(PointwiseEquals entity) {
    }

    public void visit(Tuple entity) {
    }

    public void visit(Addition entity) {
    }

    public void visit(Subtraction entity) {
    }

    public void visit(Multiplication entity) {
    }

    public void visit(Division entity) {
    }

    public void visit(Remainder entity) {
    }

    public void visit(Equals entity) {
    }

    public void visit(NotEquals entity) {
    }

    public void visit(LessThan entity) {
    }

    public void visit(LessOrEquals entity) {
    }

    public void visit(GreaterThan entity) {
    }

    public void visit(GreaterOrEquals entity) {
    }

    public void visit(VoidLiteral entity) {
    }

    public void visit(BooleanLiteral entity) {
    }

    public void visit(ByteLiteral entity) {
    }

    public void visit(CharLiteral entity) {
    }

    public void visit(DoubleLiteral entity) {
    }

    public void visit(FloatLiteral entity) {
    }

    public void visit(IntLiteral entity) {
    }

    public void visit(LongLiteral entity) {
    }

    public void visit(ShortLiteral entity) {
    }

    public void visit(DateLiteral entity) {
    }

    public void visit(StringLiteral entity) {
    }

    public void visit(Placement entity) {
    }
}
