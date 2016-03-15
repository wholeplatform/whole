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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathForwardStrategyVisitor extends GenericForwardStrategyVisitor<IMathVisitor> implements IMathVisitor {

    public MathForwardStrategyVisitor() {
        this(new MathIdentityVisitor());
    }

    public MathForwardStrategyVisitor(IMathVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IMathEntity) entity).accept(this);
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

    public void visit(Quotient entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Remainder entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Exponentiation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Root entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Minus entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AbsoluteValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Floor entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Ceiling entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Factorial entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreatestCommonDivisor entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LowestCommonMultiple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Maximum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Minimum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(And entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Or entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExclusiveOr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Not entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Implies entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BitwiseAnd entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BitwiseOr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BitwiseExclusiveOr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BitwiseNot entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ShiftLeft entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ShiftRight entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArithmeticShiftRight entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Equals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotEquals entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ApproximatelyEqual entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreaterThan entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LessThan entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GreaterOrEqual entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LessOrEqual entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FactorOf entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Exponential entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NaturalLogarithm entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Logarithm entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Sine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cosine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Tangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cosecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Secant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cotangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arcsine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arccosine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arctangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arccosecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arcsecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arccotangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicSine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicCosine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicTangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicCosecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicSecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicCotangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicArcsine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicArccosine entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicArctangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicArccosecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicArcsecant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HyperbolicArccotangent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Empty entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Set entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OrderedPair entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Tuple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(List entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Stream entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Enumeration entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Builder entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Union entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Intersection entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Difference entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(In entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotIn entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Subset entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ProperSubset entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotSubset entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotProperSubset entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cardinality entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Selector entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Identifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Boolean entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ByteInteger entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ShortInteger entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Integer entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LongInteger entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BigInteger entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Float entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Double entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BigDecimal entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Rational entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Constant entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NotANumber entity) {
        wGetStrategy().visit(entity);
    }
}
