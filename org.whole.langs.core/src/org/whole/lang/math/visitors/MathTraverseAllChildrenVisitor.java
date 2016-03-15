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
package org.whole.lang.math.visitors;

import org.whole.lang.math.visitors.MathIdentityUnaryVisitor;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class MathTraverseAllChildrenVisitor extends MathIdentityUnaryVisitor<IMathVisitor> {

    public MathTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public MathTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Addition entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Subtraction entity) {
        entity.getMinuend().accept(wGetVisitor1());
        entity.getSubtrahend().accept(wGetVisitor1());
    }

    public void visit(Multiplication entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Division entity) {
        entity.getDividend().accept(wGetVisitor1());
        entity.getDivisor().accept(wGetVisitor1());
    }

    public void visit(Quotient entity) {
        entity.getDividend().accept(wGetVisitor1());
        entity.getDivisor().accept(wGetVisitor1());
    }

    public void visit(Remainder entity) {
        entity.getDividend().accept(wGetVisitor1());
        entity.getDivisor().accept(wGetVisitor1());
    }

    public void visit(Exponentiation entity) {
        entity.getBase().accept(wGetVisitor1());
        entity.getExponent().accept(wGetVisitor1());
    }

    public void visit(Root entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getDegree().accept(wGetVisitor1());
    }

    public void visit(Minus entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(AbsoluteValue entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Floor entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Ceiling entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Factorial entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(GreatestCommonDivisor entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(LowestCommonMultiple entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Maximum entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Minimum entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(And entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Or entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ExclusiveOr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Not entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Implies entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(BitwiseAnd entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BitwiseOr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BitwiseExclusiveOr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BitwiseNot entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ShiftExpression entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBits().accept(wGetVisitor1());
    }

    public void visit(ShiftLeft entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBits().accept(wGetVisitor1());
    }

    public void visit(ShiftRight entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBits().accept(wGetVisitor1());
    }

    public void visit(ArithmeticShiftRight entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBits().accept(wGetVisitor1());
    }

    public void visit(Equals entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(NotEquals entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(ApproximatelyEqual entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(GreaterThan entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(LessThan entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(GreaterOrEqual entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(LessOrEqual entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FactorOf entity) {
        entity.getExp1().accept(wGetVisitor1());
        entity.getExp2().accept(wGetVisitor1());
    }

    public void visit(Exponential entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(NaturalLogarithm entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Logarithm entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getBase().accept(wGetVisitor1());
    }

    public void visit(TrigonometricExpression entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Sine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Cosine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Tangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Cosecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Secant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Cotangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Arcsine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Arccosine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Arctangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Arccosecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Arcsecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Arccotangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicSine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicCosine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicTangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicCosecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicSecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicCotangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicArcsine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicArccosine entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicArctangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicArccosecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicArcsecant entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(HyperbolicArccotangent entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(Set entity) {
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(OrderedPair entity) {
        entity.getFirst().accept(wGetVisitor1());
        entity.getSecond().accept(wGetVisitor1());
    }

    public void visit(Tuple entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(List entity) {
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(Stream entity) {
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(Enumeration entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Builder entity) {
        entity.getElement().accept(wGetVisitor1());
        entity.getRule().accept(wGetVisitor1());
    }

    public void visit(Union entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Intersection entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Difference entity) {
        entity.getCollection1().accept(wGetVisitor1());
        entity.getCollection2().accept(wGetVisitor1());
    }

    public void visit(In entity) {
        entity.getElement().accept(wGetVisitor1());
        entity.getCollection().accept(wGetVisitor1());
    }

    public void visit(NotIn entity) {
        entity.getElement().accept(wGetVisitor1());
        entity.getCollection().accept(wGetVisitor1());
    }

    public void visit(Subset entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ProperSubset entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(NotSubset entity) {
        entity.getCollection1().accept(wGetVisitor1());
        entity.getCollection2().accept(wGetVisitor1());
    }

    public void visit(NotProperSubset entity) {
        entity.getCollection1().accept(wGetVisitor1());
        entity.getCollection2().accept(wGetVisitor1());
    }

    public void visit(Cardinality entity) {
        entity.getCollection().accept(wGetVisitor1());
    }

    public void visit(Selector entity) {
        entity.getIndex().accept(wGetVisitor1());
        entity.getCollection().accept(wGetVisitor1());
    }

    public void visit(Rational entity) {
        entity.getNumerator().accept(wGetVisitor1());
        entity.getDenominator().accept(wGetVisitor1());
    }
}
