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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathFailureVisitor extends MathIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Addition entity) {
        throw new VisitException();
    }

    public void visit(Subtraction entity) {
        throw new VisitException();
    }

    public void visit(Multiplication entity) {
        throw new VisitException();
    }

    public void visit(Division entity) {
        throw new VisitException();
    }

    public void visit(Quotient entity) {
        throw new VisitException();
    }

    public void visit(Remainder entity) {
        throw new VisitException();
    }

    public void visit(Exponentiation entity) {
        throw new VisitException();
    }

    public void visit(Root entity) {
        throw new VisitException();
    }

    public void visit(Minus entity) {
        throw new VisitException();
    }

    public void visit(AbsoluteValue entity) {
        throw new VisitException();
    }

    public void visit(Floor entity) {
        throw new VisitException();
    }

    public void visit(Ceiling entity) {
        throw new VisitException();
    }

    public void visit(Factorial entity) {
        throw new VisitException();
    }

    public void visit(GreatestCommonDivisor entity) {
        throw new VisitException();
    }

    public void visit(LowestCommonMultiple entity) {
        throw new VisitException();
    }

    public void visit(Maximum entity) {
        throw new VisitException();
    }

    public void visit(Minimum entity) {
        throw new VisitException();
    }

    public void visit(And entity) {
        throw new VisitException();
    }

    public void visit(Or entity) {
        throw new VisitException();
    }

    public void visit(ExclusiveOr entity) {
        throw new VisitException();
    }

    public void visit(Not entity) {
        throw new VisitException();
    }

    public void visit(Implies entity) {
        throw new VisitException();
    }

    public void visit(BitwiseAnd entity) {
        throw new VisitException();
    }

    public void visit(BitwiseOr entity) {
        throw new VisitException();
    }

    public void visit(BitwiseExclusiveOr entity) {
        throw new VisitException();
    }

    public void visit(BitwiseNot entity) {
        throw new VisitException();
    }

    public void visit(ShiftLeft entity) {
        throw new VisitException();
    }

    public void visit(ShiftRight entity) {
        throw new VisitException();
    }

    public void visit(ArithmeticShiftRight entity) {
        throw new VisitException();
    }

    public void visit(Equals entity) {
        throw new VisitException();
    }

    public void visit(NotEquals entity) {
        throw new VisitException();
    }

    public void visit(ApproximatelyEqual entity) {
        throw new VisitException();
    }

    public void visit(GreaterThan entity) {
        throw new VisitException();
    }

    public void visit(LessThan entity) {
        throw new VisitException();
    }

    public void visit(GreaterOrEqual entity) {
        throw new VisitException();
    }

    public void visit(LessOrEqual entity) {
        throw new VisitException();
    }

    public void visit(FactorOf entity) {
        throw new VisitException();
    }

    public void visit(Exponential entity) {
        throw new VisitException();
    }

    public void visit(NaturalLogarithm entity) {
        throw new VisitException();
    }

    public void visit(Logarithm entity) {
        throw new VisitException();
    }

    public void visit(Sine entity) {
        throw new VisitException();
    }

    public void visit(Cosine entity) {
        throw new VisitException();
    }

    public void visit(Tangent entity) {
        throw new VisitException();
    }

    public void visit(Cosecant entity) {
        throw new VisitException();
    }

    public void visit(Secant entity) {
        throw new VisitException();
    }

    public void visit(Cotangent entity) {
        throw new VisitException();
    }

    public void visit(Arcsine entity) {
        throw new VisitException();
    }

    public void visit(Arccosine entity) {
        throw new VisitException();
    }

    public void visit(Arctangent entity) {
        throw new VisitException();
    }

    public void visit(Arccosecant entity) {
        throw new VisitException();
    }

    public void visit(Arcsecant entity) {
        throw new VisitException();
    }

    public void visit(Arccotangent entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicSine entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicCosine entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicTangent entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicCosecant entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicSecant entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicCotangent entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicArcsine entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicArccosine entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicArctangent entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicArccosecant entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicArcsecant entity) {
        throw new VisitException();
    }

    public void visit(HyperbolicArccotangent entity) {
        throw new VisitException();
    }

    public void visit(Empty entity) {
        throw new VisitException();
    }

    public void visit(Set entity) {
        throw new VisitException();
    }

    public void visit(OrderedPair entity) {
        throw new VisitException();
    }

    public void visit(Tuple entity) {
        throw new VisitException();
    }

    public void visit(List entity) {
        throw new VisitException();
    }

    public void visit(Stream entity) {
        throw new VisitException();
    }

    public void visit(Enumeration entity) {
        throw new VisitException();
    }

    public void visit(Builder entity) {
        throw new VisitException();
    }

    public void visit(Union entity) {
        throw new VisitException();
    }

    public void visit(Intersection entity) {
        throw new VisitException();
    }

    public void visit(Difference entity) {
        throw new VisitException();
    }

    public void visit(In entity) {
        throw new VisitException();
    }

    public void visit(NotIn entity) {
        throw new VisitException();
    }

    public void visit(Subset entity) {
        throw new VisitException();
    }

    public void visit(ProperSubset entity) {
        throw new VisitException();
    }

    public void visit(NotSubset entity) {
        throw new VisitException();
    }

    public void visit(NotProperSubset entity) {
        throw new VisitException();
    }

    public void visit(Cardinality entity) {
        throw new VisitException();
    }

    public void visit(Selector entity) {
        throw new VisitException();
    }

    public void visit(Identifier entity) {
        throw new VisitException();
    }

    public void visit(Boolean entity) {
        throw new VisitException();
    }

    public void visit(ByteInteger entity) {
        throw new VisitException();
    }

    public void visit(ShortInteger entity) {
        throw new VisitException();
    }

    public void visit(Integer entity) {
        throw new VisitException();
    }

    public void visit(LongInteger entity) {
        throw new VisitException();
    }

    public void visit(BigInteger entity) {
        throw new VisitException();
    }

    public void visit(Float entity) {
        throw new VisitException();
    }

    public void visit(Double entity) {
        throw new VisitException();
    }

    public void visit(BigDecimal entity) {
        throw new VisitException();
    }

    public void visit(Rational entity) {
        throw new VisitException();
    }

    public void visit(Constant entity) {
        throw new VisitException();
    }

    public void visit(NotANumber entity) {
        throw new VisitException();
    }
}
