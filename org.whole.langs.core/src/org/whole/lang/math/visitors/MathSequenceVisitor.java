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

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathSequenceVisitor extends AbstractBinaryVisitor<IMathVisitor> implements IMathVisitor {

    public MathSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
        super(visitor1, visitor2);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Addition entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Subtraction entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Multiplication entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Division entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Quotient entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Remainder entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Exponentiation entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Root entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Minus entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(AbsoluteValue entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Floor entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Ceiling entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Factorial entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(GreatestCommonDivisor entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(LowestCommonMultiple entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Maximum entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Minimum entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(And entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Or entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ExclusiveOr entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Not entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Implies entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(BitwiseAnd entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(BitwiseOr entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(BitwiseExclusiveOr entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(BitwiseNot entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ShiftLeft entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ShiftRight entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ArithmeticShiftRight entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Equals entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(NotEquals entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ApproximatelyEqual entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(GreaterThan entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(LessThan entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(GreaterOrEqual entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(LessOrEqual entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(FactorOf entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Exponential entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(NaturalLogarithm entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Logarithm entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Sine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Cosine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Tangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Cosecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Secant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Cotangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Arcsine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Arccosine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Arctangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Arccosecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Arcsecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Arccotangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicSine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicCosine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicTangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicCosecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicSecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicCotangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicArcsine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicArccosine entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicArctangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicArccosecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicArcsecant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(HyperbolicArccotangent entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Empty entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Set entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(OrderedPair entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Tuple entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(List entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Stream entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Enumeration entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Builder entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Union entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Intersection entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Difference entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(In entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(NotIn entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Subset entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ProperSubset entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(NotSubset entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(NotProperSubset entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Cardinality entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Selector entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Identifier entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Boolean entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ByteInteger entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(ShortInteger entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Integer entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(LongInteger entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(BigInteger entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Float entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Double entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(BigDecimal entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Rational entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(Constant entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }

    public void visit(NotANumber entity) {
        wGetVisitor1().visit(entity);
        wGetVisitor2().visit(entity);
    }
}
