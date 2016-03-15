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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class QueriesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IQueriesVisitor {

    public QueriesForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(QueryDeclaration entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Path entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Delete entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CartesianInsert entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointwiseInsert entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CartesianUpdate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointwiseUpdate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Select entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(For entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(If entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Do entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EntityTemplate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EntityCall entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Call entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Expressions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Bindings entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Bind entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Choose entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Block entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Sequence entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Scope entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CartesianProduct entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointwiseProduct entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Filter entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AspectStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AdjacentStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ReachableStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ReachableOrSelfStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InverseAdjacentStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InverseReachableStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InverseReachableOrSelfStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RootStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FragmentRootStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SelfStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FeatureStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ChildStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DescendantStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DescendantOrSelfStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FollowingSiblingStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FollowingStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ParentStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AncestorStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AncestorOrSelfStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedingSiblingStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedingStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AdditionStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SubtractionStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(MultiplicationStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DivisionStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RemainderStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EqualsStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(NotEqualsStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LessThanStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LessOrEqualsStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GreaterThanStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GreaterOrEqualsStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Prune entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IndexVariableTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(KindTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StageTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StageVariableTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LanguageTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SubtypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SupertypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExtendedSubtypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExtendedSupertypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AtTypeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AtFeatureTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AtIndexTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IndexTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IndexRangeTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VisitorTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExpressionTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DistinctTest entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(And entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Or entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Not entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(One entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Some entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Every entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ParenthesizedPredicate entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EntityType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TemplateNames entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AllNames entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AddNames entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RemoveNames entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Names entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IdentityComparator entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(UnionAll entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Union entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Intersect entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Except entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableRefStep entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Singleton entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PointwiseEquals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Tuple entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Addition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Subtraction entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Multiplication entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Division entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Remainder entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Equals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(NotEquals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LessThan entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LessOrEquals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GreaterThan entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GreaterOrEquals entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VoidLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BooleanLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ByteLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CharLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DoubleLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FloatLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IntLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LongLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ShortLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DateLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Placement entity) {
        wGetVisitor1().visit(entity);
    }
}
