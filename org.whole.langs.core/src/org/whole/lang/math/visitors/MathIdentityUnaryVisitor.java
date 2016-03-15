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

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IMathVisitor {

    public MathIdentityUnaryVisitor() {
        super(null);
    }

    public MathIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IMathEntity) entity).accept(this);
    }

    public void visit(Addition entity) {
    }

    public void visit(Subtraction entity) {
    }

    public void visit(Multiplication entity) {
    }

    public void visit(Division entity) {
    }

    public void visit(Quotient entity) {
    }

    public void visit(Remainder entity) {
    }

    public void visit(Exponentiation entity) {
    }

    public void visit(Root entity) {
    }

    public void visit(Minus entity) {
    }

    public void visit(AbsoluteValue entity) {
    }

    public void visit(Floor entity) {
    }

    public void visit(Ceiling entity) {
    }

    public void visit(Factorial entity) {
    }

    public void visit(GreatestCommonDivisor entity) {
    }

    public void visit(LowestCommonMultiple entity) {
    }

    public void visit(Maximum entity) {
    }

    public void visit(Minimum entity) {
    }

    public void visit(And entity) {
    }

    public void visit(Or entity) {
    }

    public void visit(ExclusiveOr entity) {
    }

    public void visit(Not entity) {
    }

    public void visit(Implies entity) {
    }

    public void visit(BitwiseAnd entity) {
    }

    public void visit(BitwiseOr entity) {
    }

    public void visit(BitwiseExclusiveOr entity) {
    }

    public void visit(BitwiseNot entity) {
    }

    public void visit(ShiftLeft entity) {
    }

    public void visit(ShiftRight entity) {
    }

    public void visit(ArithmeticShiftRight entity) {
    }

    public void visit(Equals entity) {
    }

    public void visit(NotEquals entity) {
    }

    public void visit(ApproximatelyEqual entity) {
    }

    public void visit(GreaterThan entity) {
    }

    public void visit(LessThan entity) {
    }

    public void visit(GreaterOrEqual entity) {
    }

    public void visit(LessOrEqual entity) {
    }

    public void visit(FactorOf entity) {
    }

    public void visit(Exponential entity) {
    }

    public void visit(NaturalLogarithm entity) {
    }

    public void visit(Logarithm entity) {
    }

    public void visit(Sine entity) {
    }

    public void visit(Cosine entity) {
    }

    public void visit(Tangent entity) {
    }

    public void visit(Cosecant entity) {
    }

    public void visit(Secant entity) {
    }

    public void visit(Cotangent entity) {
    }

    public void visit(Arcsine entity) {
    }

    public void visit(Arccosine entity) {
    }

    public void visit(Arctangent entity) {
    }

    public void visit(Arccosecant entity) {
    }

    public void visit(Arcsecant entity) {
    }

    public void visit(Arccotangent entity) {
    }

    public void visit(HyperbolicSine entity) {
    }

    public void visit(HyperbolicCosine entity) {
    }

    public void visit(HyperbolicTangent entity) {
    }

    public void visit(HyperbolicCosecant entity) {
    }

    public void visit(HyperbolicSecant entity) {
    }

    public void visit(HyperbolicCotangent entity) {
    }

    public void visit(HyperbolicArcsine entity) {
    }

    public void visit(HyperbolicArccosine entity) {
    }

    public void visit(HyperbolicArctangent entity) {
    }

    public void visit(HyperbolicArccosecant entity) {
    }

    public void visit(HyperbolicArcsecant entity) {
    }

    public void visit(HyperbolicArccotangent entity) {
    }

    public void visit(Empty entity) {
    }

    public void visit(Set entity) {
    }

    public void visit(OrderedPair entity) {
    }

    public void visit(Tuple entity) {
    }

    public void visit(List entity) {
    }

    public void visit(Stream entity) {
    }

    public void visit(Enumeration entity) {
    }

    public void visit(Builder entity) {
    }

    public void visit(Union entity) {
    }

    public void visit(Intersection entity) {
    }

    public void visit(Difference entity) {
    }

    public void visit(In entity) {
    }

    public void visit(NotIn entity) {
    }

    public void visit(Subset entity) {
    }

    public void visit(ProperSubset entity) {
    }

    public void visit(NotSubset entity) {
    }

    public void visit(NotProperSubset entity) {
    }

    public void visit(Cardinality entity) {
    }

    public void visit(Selector entity) {
    }

    public void visit(Identifier entity) {
    }

    public void visit(Boolean entity) {
    }

    public void visit(ByteInteger entity) {
    }

    public void visit(ShortInteger entity) {
    }

    public void visit(Integer entity) {
    }

    public void visit(LongInteger entity) {
    }

    public void visit(BigInteger entity) {
    }

    public void visit(Float entity) {
    }

    public void visit(Double entity) {
    }

    public void visit(BigDecimal entity) {
    }

    public void visit(Rational entity) {
    }

    public void visit(Constant entity) {
    }

    public void visit(NotANumber entity) {
    }
}
