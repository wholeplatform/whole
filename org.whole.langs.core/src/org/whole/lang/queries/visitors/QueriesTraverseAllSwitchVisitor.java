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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.queries.model.*;

/**
 *  @generator Whole
 */
public class QueriesTraverseAllSwitchVisitor extends QueriesIdentityUnaryVisitor<IVisitor> {

    public QueriesTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(QueryDeclaration entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getParameters());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(Path entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Delete entity) {
        wGetVisitor1().visit(entity.getFromClause());
    }

    public void visit(CartesianInsert entity) {
        wGetVisitor1().visit(entity.getPlacement());
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getValuesClause());
    }

    public void visit(PointwiseInsert entity) {
        wGetVisitor1().visit(entity.getPlacement());
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getValuesClause());
    }

    public void visit(CartesianUpdate entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getValuesClause());
    }

    public void visit(PointwiseUpdate entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getValuesClause());
    }

    public void visit(Select entity) {
        wGetVisitor1().visit(entity.getSelectClause());
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getWhereClause());
        wGetVisitor1().visit(entity.getClearClause());
    }

    public void visit(For entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(If entity) {
        wGetVisitor1().visit(entity.getPredicate());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Do entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(EntityTemplate entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getConstraints());
    }

    public void visit(EntityCall entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(Call entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(Expressions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Bindings entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Bind entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Choose entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Block entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Sequence entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Scope entity) {
        wGetVisitor1().visit(entity.getLocalNames());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(CartesianProduct entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PointwiseProduct entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Filter entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getPredicate());
    }

    public void visit(AdditionStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(SubtractionStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(MultiplicationStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(DivisionStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(RemainderStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(EqualsStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(NotEqualsStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(LessThanStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(LessOrEqualsStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(GreaterThanStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(GreaterOrEqualsStep entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Prune entity) {
        wGetVisitor1().visit(entity.getPredicate());
    }

    public void visit(IndexTest entity) {
        wGetVisitor1().visit(entity.getIndex());
    }

    public void visit(IndexRangeTest entity) {
        wGetVisitor1().visit(entity.getStartIndex());
        wGetVisitor1().visit(entity.getEndIndex());
    }

    public void visit(ExpressionTest entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(DistinctTest entity) {
        wGetVisitor1().visit(entity.getComparator());
    }

    public void visit(And entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Or entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Not entity) {
        wGetVisitor1().visit(entity.getPredicate());
    }

    public void visit(QuantifiedPredicate entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getWhereClause());
    }

    public void visit(One entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getWhereClause());
    }

    public void visit(Some entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getWhereClause());
    }

    public void visit(Every entity) {
        wGetVisitor1().visit(entity.getFromClause());
        wGetVisitor1().visit(entity.getWhereClause());
    }

    public void visit(ParenthesizedPredicate entity) {
        wGetVisitor1().visit(entity.getPredicate());
    }

    public void visit(AddNames entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getNames());
    }

    public void visit(RemoveNames entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getNames());
    }

    public void visit(Names entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CollectByExpression entity) {
        wGetVisitor1().visit(entity.getExpressions());
        wGetVisitor1().visit(entity.getComparator());
    }

    public void visit(IdentityComparator entity) {
        wGetVisitor1().visit(entity.getIdentity());
    }

    public void visit(UnionAll entity) {
        wGetVisitor1().visit(entity.getExpressions());
    }

    public void visit(Union entity) {
        wGetVisitor1().visit(entity.getExpressions());
        wGetVisitor1().visit(entity.getComparator());
    }

    public void visit(Intersect entity) {
        wGetVisitor1().visit(entity.getExpressions());
        wGetVisitor1().visit(entity.getComparator());
    }

    public void visit(Except entity) {
        wGetVisitor1().visit(entity.getExpressions());
        wGetVisitor1().visit(entity.getComparator());
    }

    public void visit(Singleton entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(PointwiseEquals entity) {
        wGetVisitor1().visit(entity.getPexp1());
        wGetVisitor1().visit(entity.getPexp2());
    }

    public void visit(Tuple entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Addition entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(Subtraction entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(Multiplication entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(Division entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(Remainder entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(Equals entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(NotEquals entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(LessThan entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(LessOrEquals entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(GreaterThan entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(GreaterOrEquals entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }
}
