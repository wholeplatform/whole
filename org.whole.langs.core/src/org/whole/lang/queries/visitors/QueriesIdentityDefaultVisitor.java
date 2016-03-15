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

import org.whole.lang.queries.model.*;

/**
 *  @generator Whole
 */
public class QueriesIdentityDefaultVisitor extends QueriesIdentityVisitor {

    public void visit(IQueriesEntity entity) {
    }

    public void visit(PathExpressionOrPredicate entity) {
    }

    public void visit(PathExpression entity) {
        visit((PathExpressionOrPredicate) entity);
    }

    public void visit(QueryDeclaration entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(Path entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(Delete entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(CartesianInsert entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(PointwiseInsert entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(CartesianUpdate entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(PointwiseUpdate entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(Select entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(For entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(If entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(Do entity) {
        visit((IQueriesEntity) entity);
        visit((PathExpression) entity);
    }

    public void visit(StepExpression entity) {
        visit((PathExpression) entity);
    }

    public void visit(EntityTemplate entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(EntityCall entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Call entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Constraints entity) {
    }

    public void visit(Expressions entity) {
        visit((IQueriesEntity) entity);
        visit((Constraints) entity);
    }

    public void visit(Bindings entity) {
        visit((IQueriesEntity) entity);
        visit((Constraints) entity);
    }

    public void visit(Bind entity) {
        visit((IQueriesEntity) entity);
    }

    public void visit(Choose entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Block entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Sequence entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Scope entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(CartesianProduct entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(PointwiseProduct entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Filter entity) {
        visit((IQueriesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(TraversalStep entity) {
        visit((StepExpression) entity);
    }

    public void visit(AspectStep entity) {
        visit((IQueriesEntity) entity);
        visit((TraversalStep) entity);
    }

    public void visit(DirectStep entity) {
        visit((TraversalStep) entity);
    }

    public void visit(AdjacentStep entity) {
        visit((IQueriesEntity) entity);
        visit((DirectStep) entity);
    }

    public void visit(ReachableStep entity) {
        visit((IQueriesEntity) entity);
        visit((DirectStep) entity);
    }

    public void visit(ReachableOrSelfStep entity) {
        visit((IQueriesEntity) entity);
        visit((DirectStep) entity);
    }

    public void visit(InverseStep entity) {
        visit((TraversalStep) entity);
    }

    public void visit(InverseAdjacentStep entity) {
        visit((IQueriesEntity) entity);
        visit((InverseStep) entity);
    }

    public void visit(InverseReachableStep entity) {
        visit((IQueriesEntity) entity);
        visit((InverseStep) entity);
    }

    public void visit(InverseReachableOrSelfStep entity) {
        visit((IQueriesEntity) entity);
        visit((InverseStep) entity);
    }

    public void visit(RootStep entity) {
        visit((IQueriesEntity) entity);
        visit((TraversalStep) entity);
    }

    public void visit(FragmentRootStep entity) {
        visit((IQueriesEntity) entity);
        visit((TraversalStep) entity);
    }

    public void visit(SelfStep entity) {
        visit((IQueriesEntity) entity);
        visit((TraversalStep) entity);
    }

    public void visit(ForwardStep entity) {
        visit((TraversalStep) entity);
    }

    public void visit(FeatureStep entity) {
        visit((IQueriesEntity) entity);
        visit((ForwardStep) entity);
    }

    public void visit(ChildStep entity) {
        visit((IQueriesEntity) entity);
        visit((ForwardStep) entity);
    }

    public void visit(DescendantStep entity) {
        visit((IQueriesEntity) entity);
        visit((ForwardStep) entity);
    }

    public void visit(DescendantOrSelfStep entity) {
        visit((IQueriesEntity) entity);
        visit((ForwardStep) entity);
    }

    public void visit(FollowingSiblingStep entity) {
        visit((IQueriesEntity) entity);
        visit((ForwardStep) entity);
    }

    public void visit(FollowingStep entity) {
        visit((IQueriesEntity) entity);
        visit((ForwardStep) entity);
    }

    public void visit(ReverseStep entity) {
        visit((TraversalStep) entity);
    }

    public void visit(ParentStep entity) {
        visit((IQueriesEntity) entity);
        visit((ReverseStep) entity);
    }

    public void visit(AncestorStep entity) {
        visit((IQueriesEntity) entity);
        visit((ReverseStep) entity);
    }

    public void visit(AncestorOrSelfStep entity) {
        visit((IQueriesEntity) entity);
        visit((ReverseStep) entity);
    }

    public void visit(PrecedingSiblingStep entity) {
        visit((IQueriesEntity) entity);
        visit((ReverseStep) entity);
    }

    public void visit(PrecedingStep entity) {
        visit((IQueriesEntity) entity);
        visit((ReverseStep) entity);
    }

    public void visit(MathStep entity) {
        visit((StepExpression) entity);
    }

    public void visit(AdditionStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(SubtractionStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(MultiplicationStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(DivisionStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(RemainderStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(EqualsStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(NotEqualsStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(LessThanStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(LessOrEqualsStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(GreaterThanStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(GreaterOrEqualsStep entity) {
        visit((IQueriesEntity) entity);
        visit((MathStep) entity);
    }

    public void visit(PruneOrPredicate entity) {
    }

    public void visit(Prune entity) {
        visit((IQueriesEntity) entity);
        visit((PruneOrPredicate) entity);
    }

    public void visit(Predicate entity) {
        visit((PathExpressionOrPredicate) entity);
        visit((PruneOrPredicate) entity);
    }

    public void visit(VariableTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(IndexVariableTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(KindTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(StageTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(StageVariableTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(LanguageTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(TypeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(SubtypeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(SupertypeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(ExtendedSubtypeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(ExtendedSupertypeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(AtTypeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(AtFeatureTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(AtIndexTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(IndexTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(IndexRangeTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(VisitorTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(ExpressionTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(DistinctTest entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(And entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(Or entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(Not entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(QuantifiedPredicate entity) {
        visit((Predicate) entity);
    }

    public void visit(One entity) {
        visit((IQueriesEntity) entity);
        visit((QuantifiedPredicate) entity);
    }

    public void visit(Some entity) {
        visit((IQueriesEntity) entity);
        visit((QuantifiedPredicate) entity);
    }

    public void visit(Every entity) {
        visit((IQueriesEntity) entity);
        visit((QuantifiedPredicate) entity);
    }

    public void visit(ParenthesizedPredicate entity) {
        visit((IQueriesEntity) entity);
        visit((Predicate) entity);
    }

    public void visit(EntityType entity) {
        visit((IQueriesEntity) entity);
    }

    public void visit(NamesExpression entity) {
    }

    public void visit(TemplateNames entity) {
        visit((IQueriesEntity) entity);
        visit((NamesExpression) entity);
    }

    public void visit(AllNames entity) {
        visit((IQueriesEntity) entity);
        visit((NamesExpression) entity);
    }

    public void visit(AddNames entity) {
        visit((IQueriesEntity) entity);
        visit((NamesExpression) entity);
    }

    public void visit(RemoveNames entity) {
        visit((IQueriesEntity) entity);
        visit((NamesExpression) entity);
    }

    public void visit(Names entity) {
        visit((IQueriesEntity) entity);
        visit((NamesExpression) entity);
    }

    public void visit(Name entity) {
        visit((IQueriesEntity) entity);
    }

    public void visit(Expression entity) {
        visit((StepExpression) entity);
    }

    public void visit(CollectByExpression entity) {
        visit((Expression) entity);
    }

    public void visit(Comparator entity) {
    }

    public void visit(IdentityComparator entity) {
        visit((IQueriesEntity) entity);
        visit((Comparator) entity);
    }

    public void visit(UnionAll entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Union entity) {
        visit((IQueriesEntity) entity);
        visit((CollectByExpression) entity);
    }

    public void visit(Intersect entity) {
        visit((IQueriesEntity) entity);
        visit((CollectByExpression) entity);
    }

    public void visit(Except entity) {
        visit((IQueriesEntity) entity);
        visit((CollectByExpression) entity);
    }

    public void visit(VariableRefStep entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Singleton entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(PointwiseEquals entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Tuple entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Addition entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Subtraction entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Multiplication entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Division entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Remainder entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Equals entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(NotEquals entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(LessThan entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(LessOrEquals entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(GreaterThan entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(GreaterOrEquals entity) {
        visit((IQueriesEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Literal entity) {
        visit((Expression) entity);
    }

    public void visit(VoidLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(BooleanLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(ByteLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(CharLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(DoubleLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(FloatLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(IntLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(LongLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(ShortLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(DateLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(StringLiteral entity) {
        visit((IQueriesEntity) entity);
        visit((Literal) entity);
    }

    public void visit(Placement entity) {
        visit((IQueriesEntity) entity);
    }
}
