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

import org.whole.lang.queries.visitors.QueriesIdentityUnaryVisitor;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class QueriesTraverseAllChildrenVisitor extends QueriesIdentityUnaryVisitor<IQueriesVisitor> {

    public QueriesTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public QueriesTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(QueryDeclaration entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getParameters().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(Path entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Delete entity) {
        entity.getFromClause().accept(wGetVisitor1());
    }

    public void visit(CartesianInsert entity) {
        entity.getPlacement().accept(wGetVisitor1());
        entity.getFromClause().accept(wGetVisitor1());
        entity.getValuesClause().accept(wGetVisitor1());
    }

    public void visit(PointwiseInsert entity) {
        entity.getPlacement().accept(wGetVisitor1());
        entity.getFromClause().accept(wGetVisitor1());
        entity.getValuesClause().accept(wGetVisitor1());
    }

    public void visit(CartesianUpdate entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getValuesClause().accept(wGetVisitor1());
    }

    public void visit(PointwiseUpdate entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getValuesClause().accept(wGetVisitor1());
    }

    public void visit(Select entity) {
        entity.getSelectClause().accept(wGetVisitor1());
        entity.getFromClause().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
        entity.getClearClause().accept(wGetVisitor1());
    }

    public void visit(For entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(If entity) {
        entity.getPredicate().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Do entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(EntityTemplate entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getConstraints().accept(wGetVisitor1());
    }

    public void visit(EntityCall entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getBindings().accept(wGetVisitor1());
    }

    public void visit(Call entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(Expressions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Bindings entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Bind entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Choose entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Block entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Sequence entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Scope entity) {
        entity.getLocalNames().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(CartesianProduct entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PointwiseProduct entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Filter entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getPredicate().accept(wGetVisitor1());
    }

    public void visit(AdditionStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(SubtractionStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(MultiplicationStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(DivisionStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(RemainderStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(EqualsStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(NotEqualsStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(LessThanStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(LessOrEqualsStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(GreaterThanStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(GreaterOrEqualsStep entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Prune entity) {
        entity.getPredicate().accept(wGetVisitor1());
    }

    public void visit(IndexTest entity) {
        entity.getIndex().accept(wGetVisitor1());
    }

    public void visit(IndexRangeTest entity) {
        entity.getStartIndex().accept(wGetVisitor1());
        entity.getEndIndex().accept(wGetVisitor1());
    }

    public void visit(ExpressionTest entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(DistinctTest entity) {
        entity.getComparator().accept(wGetVisitor1());
    }

    public void visit(And entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Or entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Not entity) {
        entity.getPredicate().accept(wGetVisitor1());
    }

    public void visit(QuantifiedPredicate entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
    }

    public void visit(One entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
    }

    public void visit(Some entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
    }

    public void visit(Every entity) {
        entity.getFromClause().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
    }

    public void visit(ParenthesizedPredicate entity) {
        entity.getPredicate().accept(wGetVisitor1());
    }

    public void visit(AddNames entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getNames().accept(wGetVisitor1());
    }

    public void visit(RemoveNames entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getNames().accept(wGetVisitor1());
    }

    public void visit(Names entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CollectByExpression entity) {
        entity.getExpressions().accept(wGetVisitor1());
        entity.getComparator().accept(wGetVisitor1());
    }

    public void visit(IdentityComparator entity) {
        entity.getIdentity().accept(wGetVisitor1());
    }

    public void visit(UnionAll entity) {
        entity.getExpressions().accept(wGetVisitor1());
    }

    public void visit(Union entity) {
        entity.getExpressions().accept(wGetVisitor1());
        entity.getComparator().accept(wGetVisitor1());
    }

    public void visit(Intersect entity) {
        entity.getExpressions().accept(wGetVisitor1());
        entity.getComparator().accept(wGetVisitor1());
    }

    public void visit(Except entity) {
        entity.getExpressions().accept(wGetVisitor1());
        entity.getComparator().accept(wGetVisitor1());
    }

    public void visit(Singleton entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(PointwiseEquals entity) {
        entity.getPexp1().accept(wGetVisitor1());
        entity.getPexp2().accept(wGetVisitor1());
    }

    public void visit(Tuple entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Addition entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(Subtraction entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(Multiplication entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(Division entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(Remainder entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(Equals entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(NotEquals entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(LessThan entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(LessOrEquals entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(GreaterThan entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(GreaterOrEquals entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }
}
