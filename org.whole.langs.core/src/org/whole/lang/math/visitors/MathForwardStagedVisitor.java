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

import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathForwardStagedVisitor extends MathIdentityVisitor {

    public void visit(Addition entity) {
        stagedVisit(entity);
    }

    public void visit(Subtraction entity) {
        stagedVisit(entity);
    }

    public void visit(Multiplication entity) {
        stagedVisit(entity);
    }

    public void visit(Division entity) {
        stagedVisit(entity);
    }

    public void visit(Quotient entity) {
        stagedVisit(entity);
    }

    public void visit(Remainder entity) {
        stagedVisit(entity);
    }

    public void visit(Exponentiation entity) {
        stagedVisit(entity);
    }

    public void visit(Root entity) {
        stagedVisit(entity);
    }

    public void visit(Minus entity) {
        stagedVisit(entity);
    }

    public void visit(AbsoluteValue entity) {
        stagedVisit(entity);
    }

    public void visit(Floor entity) {
        stagedVisit(entity);
    }

    public void visit(Ceiling entity) {
        stagedVisit(entity);
    }

    public void visit(Factorial entity) {
        stagedVisit(entity);
    }

    public void visit(GreatestCommonDivisor entity) {
        stagedVisit(entity);
    }

    public void visit(LowestCommonMultiple entity) {
        stagedVisit(entity);
    }

    public void visit(Maximum entity) {
        stagedVisit(entity);
    }

    public void visit(Minimum entity) {
        stagedVisit(entity);
    }

    public void visit(And entity) {
        stagedVisit(entity);
    }

    public void visit(Or entity) {
        stagedVisit(entity);
    }

    public void visit(ExclusiveOr entity) {
        stagedVisit(entity);
    }

    public void visit(Not entity) {
        stagedVisit(entity);
    }

    public void visit(Implies entity) {
        stagedVisit(entity);
    }

    public void visit(BitwiseAnd entity) {
        stagedVisit(entity);
    }

    public void visit(BitwiseOr entity) {
        stagedVisit(entity);
    }

    public void visit(BitwiseExclusiveOr entity) {
        stagedVisit(entity);
    }

    public void visit(BitwiseNot entity) {
        stagedVisit(entity);
    }

    public void visit(ShiftLeft entity) {
        stagedVisit(entity);
    }

    public void visit(ShiftRight entity) {
        stagedVisit(entity);
    }

    public void visit(ArithmeticShiftRight entity) {
        stagedVisit(entity);
    }

    public void visit(Equals entity) {
        stagedVisit(entity);
    }

    public void visit(NotEquals entity) {
        stagedVisit(entity);
    }

    public void visit(ApproximatelyEqual entity) {
        stagedVisit(entity);
    }

    public void visit(GreaterThan entity) {
        stagedVisit(entity);
    }

    public void visit(LessThan entity) {
        stagedVisit(entity);
    }

    public void visit(GreaterOrEqual entity) {
        stagedVisit(entity);
    }

    public void visit(LessOrEqual entity) {
        stagedVisit(entity);
    }

    public void visit(FactorOf entity) {
        stagedVisit(entity);
    }

    public void visit(Exponential entity) {
        stagedVisit(entity);
    }

    public void visit(NaturalLogarithm entity) {
        stagedVisit(entity);
    }

    public void visit(Logarithm entity) {
        stagedVisit(entity);
    }

    public void visit(Sine entity) {
        stagedVisit(entity);
    }

    public void visit(Cosine entity) {
        stagedVisit(entity);
    }

    public void visit(Tangent entity) {
        stagedVisit(entity);
    }

    public void visit(Cosecant entity) {
        stagedVisit(entity);
    }

    public void visit(Secant entity) {
        stagedVisit(entity);
    }

    public void visit(Cotangent entity) {
        stagedVisit(entity);
    }

    public void visit(Arcsine entity) {
        stagedVisit(entity);
    }

    public void visit(Arccosine entity) {
        stagedVisit(entity);
    }

    public void visit(Arctangent entity) {
        stagedVisit(entity);
    }

    public void visit(Arccosecant entity) {
        stagedVisit(entity);
    }

    public void visit(Arcsecant entity) {
        stagedVisit(entity);
    }

    public void visit(Arccotangent entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicSine entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicCosine entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicTangent entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicCosecant entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicSecant entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicCotangent entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicArcsine entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicArccosine entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicArctangent entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicArccosecant entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicArcsecant entity) {
        stagedVisit(entity);
    }

    public void visit(HyperbolicArccotangent entity) {
        stagedVisit(entity);
    }

    public void visit(Empty entity) {
        stagedVisit(entity);
    }

    public void visit(Set entity) {
        stagedVisit(entity);
    }

    public void visit(OrderedPair entity) {
        stagedVisit(entity);
    }

    public void visit(Tuple entity) {
        stagedVisit(entity);
    }

    public void visit(List entity) {
        stagedVisit(entity);
    }

    public void visit(Stream entity) {
        stagedVisit(entity);
    }

    public void visit(Enumeration entity) {
        stagedVisit(entity);
    }

    public void visit(Builder entity) {
        stagedVisit(entity);
    }

    public void visit(Union entity) {
        stagedVisit(entity);
    }

    public void visit(Intersection entity) {
        stagedVisit(entity);
    }

    public void visit(Difference entity) {
        stagedVisit(entity);
    }

    public void visit(In entity) {
        stagedVisit(entity);
    }

    public void visit(NotIn entity) {
        stagedVisit(entity);
    }

    public void visit(Subset entity) {
        stagedVisit(entity);
    }

    public void visit(ProperSubset entity) {
        stagedVisit(entity);
    }

    public void visit(NotSubset entity) {
        stagedVisit(entity);
    }

    public void visit(NotProperSubset entity) {
        stagedVisit(entity);
    }

    public void visit(Cardinality entity) {
        stagedVisit(entity);
    }

    public void visit(Selector entity) {
        stagedVisit(entity);
    }

    public void visit(Identifier entity) {
        stagedVisit(entity);
    }

    public void visit(Boolean entity) {
        stagedVisit(entity);
    }

    public void visit(ByteInteger entity) {
        stagedVisit(entity);
    }

    public void visit(ShortInteger entity) {
        stagedVisit(entity);
    }

    public void visit(Integer entity) {
        stagedVisit(entity);
    }

    public void visit(LongInteger entity) {
        stagedVisit(entity);
    }

    public void visit(BigInteger entity) {
        stagedVisit(entity);
    }

    public void visit(Float entity) {
        stagedVisit(entity);
    }

    public void visit(Double entity) {
        stagedVisit(entity);
    }

    public void visit(BigDecimal entity) {
        stagedVisit(entity);
    }

    public void visit(Rational entity) {
        stagedVisit(entity);
    }

    public void visit(Constant entity) {
        stagedVisit(entity);
    }

    public void visit(NotANumber entity) {
        stagedVisit(entity);
    }
}
