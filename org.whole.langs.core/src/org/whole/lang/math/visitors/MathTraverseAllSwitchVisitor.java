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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.math.model.*;

/**
 *  @generator Whole
 */
public class MathTraverseAllSwitchVisitor extends MathIdentityUnaryVisitor<IVisitor> {

    public MathTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Addition entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Subtraction entity) {
        wGetVisitor1().visit(entity.getMinuend());
        wGetVisitor1().visit(entity.getSubtrahend());
    }

    public void visit(Multiplication entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Division entity) {
        wGetVisitor1().visit(entity.getDividend());
        wGetVisitor1().visit(entity.getDivisor());
    }

    public void visit(Quotient entity) {
        wGetVisitor1().visit(entity.getDividend());
        wGetVisitor1().visit(entity.getDivisor());
    }

    public void visit(Remainder entity) {
        wGetVisitor1().visit(entity.getDividend());
        wGetVisitor1().visit(entity.getDivisor());
    }

    public void visit(Exponentiation entity) {
        wGetVisitor1().visit(entity.getBase());
        wGetVisitor1().visit(entity.getExponent());
    }

    public void visit(Root entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getDegree());
    }

    public void visit(Minus entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(AbsoluteValue entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Floor entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Ceiling entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Factorial entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(GreatestCommonDivisor entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(LowestCommonMultiple entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Maximum entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Minimum entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(And entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Or entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ExclusiveOr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Not entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Implies entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(BitwiseAnd entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BitwiseOr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BitwiseExclusiveOr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(BitwiseNot entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(ShiftExpression entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBits());
    }

    public void visit(ShiftLeft entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBits());
    }

    public void visit(ShiftRight entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBits());
    }

    public void visit(ArithmeticShiftRight entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBits());
    }

    public void visit(Equals entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(NotEquals entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(ApproximatelyEqual entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(GreaterThan entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(LessThan entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(GreaterOrEqual entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(LessOrEqual entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FactorOf entity) {
        wGetVisitor1().visit(entity.getExp1());
        wGetVisitor1().visit(entity.getExp2());
    }

    public void visit(Exponential entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(NaturalLogarithm entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Logarithm entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getBase());
    }

    public void visit(TrigonometricExpression entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Sine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Cosine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Tangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Cosecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Secant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Cotangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Arcsine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Arccosine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Arctangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Arccosecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Arcsecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Arccotangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicSine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicCosine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicTangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicCosecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicSecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicCotangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicArcsine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicArccosine entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicArctangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicArccosecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicArcsecant entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(HyperbolicArccotangent entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Set entity) {
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(OrderedPair entity) {
        wGetVisitor1().visit(entity.getFirst());
        wGetVisitor1().visit(entity.getSecond());
    }

    public void visit(Tuple entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(List entity) {
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(Stream entity) {
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(Enumeration entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Builder entity) {
        wGetVisitor1().visit(entity.getElement());
        wGetVisitor1().visit(entity.getRule());
    }

    public void visit(Union entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Intersection entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Difference entity) {
        wGetVisitor1().visit(entity.getCollection1());
        wGetVisitor1().visit(entity.getCollection2());
    }

    public void visit(In entity) {
        wGetVisitor1().visit(entity.getElement());
        wGetVisitor1().visit(entity.getCollection());
    }

    public void visit(NotIn entity) {
        wGetVisitor1().visit(entity.getElement());
        wGetVisitor1().visit(entity.getCollection());
    }

    public void visit(Subset entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ProperSubset entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(NotSubset entity) {
        wGetVisitor1().visit(entity.getCollection1());
        wGetVisitor1().visit(entity.getCollection2());
    }

    public void visit(NotProperSubset entity) {
        wGetVisitor1().visit(entity.getCollection1());
        wGetVisitor1().visit(entity.getCollection2());
    }

    public void visit(Cardinality entity) {
        wGetVisitor1().visit(entity.getCollection());
    }

    public void visit(Selector entity) {
        wGetVisitor1().visit(entity.getIndex());
        wGetVisitor1().visit(entity.getCollection());
    }

    public void visit(Rational entity) {
        wGetVisitor1().visit(entity.getNumerator());
        wGetVisitor1().visit(entity.getDenominator());
    }
}
