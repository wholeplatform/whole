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
import org.whole.lang.math.model.Number;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathIdentityDefaultVisitor extends MathIdentityVisitor {

    public void visit(IMathEntity entity) {
    }

    public void visit(Expression entity) {
    }

    public void visit(ArithmeticExpression entity) {
        visit((Expression) entity);
    }

    public void visit(Addition entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Subtraction entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Multiplication entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Division entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Quotient entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Remainder entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Exponentiation entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Root entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Minus entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(AbsoluteValue entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Floor entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Ceiling entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Factorial entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(GreatestCommonDivisor entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(LowestCommonMultiple entity) {
        visit((IMathEntity) entity);
        visit((ArithmeticExpression) entity);
    }

    public void visit(Maximum entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Minimum entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(LogicExpression entity) {
        visit((Expression) entity);
    }

    public void visit(And entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(Or entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(ExclusiveOr entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(Not entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(Implies entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(BitwiseExpression entity) {
        visit((Expression) entity);
    }

    public void visit(BitwiseAnd entity) {
        visit((IMathEntity) entity);
        visit((BitwiseExpression) entity);
    }

    public void visit(BitwiseOr entity) {
        visit((IMathEntity) entity);
        visit((BitwiseExpression) entity);
    }

    public void visit(BitwiseExclusiveOr entity) {
        visit((IMathEntity) entity);
        visit((BitwiseExpression) entity);
    }

    public void visit(BitwiseNot entity) {
        visit((IMathEntity) entity);
        visit((BitwiseExpression) entity);
    }

    public void visit(ShiftExpression entity) {
        visit((BitwiseExpression) entity);
    }

    public void visit(ShiftLeft entity) {
        visit((IMathEntity) entity);
        visit((ShiftExpression) entity);
    }

    public void visit(ShiftRight entity) {
        visit((IMathEntity) entity);
        visit((ShiftExpression) entity);
    }

    public void visit(ArithmeticShiftRight entity) {
        visit((IMathEntity) entity);
        visit((ShiftExpression) entity);
    }

    public void visit(RelationalExpression entity) {
        visit((Expression) entity);
    }

    public void visit(Equals entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(NotEquals entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(ApproximatelyEqual entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(GreaterThan entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(LessThan entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(GreaterOrEqual entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(LessOrEqual entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(FactorOf entity) {
        visit((IMathEntity) entity);
        visit((RelationalExpression) entity);
    }

    public void visit(Exponential entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(NaturalLogarithm entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Logarithm entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(TrigonometricExpression entity) {
        visit((Expression) entity);
    }

    public void visit(Sine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Cosine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Tangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Cosecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Secant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Cotangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Arcsine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Arccosine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Arctangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Arccosecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Arcsecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(Arccotangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicSine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicCosine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicTangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicCosecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicSecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicCotangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicArcsine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicArccosine entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicArctangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicArccosecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicArcsecant entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(HyperbolicArccotangent entity) {
        visit((IMathEntity) entity);
        visit((TrigonometricExpression) entity);
    }

    public void visit(CollectionExpression entity) {
        visit((Expression) entity);
    }

    public void visit(Collection entity) {
        visit((CollectionExpression) entity);
    }

    public void visit(Empty entity) {
        visit((IMathEntity) entity);
        visit((Collection) entity);
    }

    public void visit(Set entity) {
        visit((IMathEntity) entity);
        visit((Collection) entity);
    }

    public void visit(Sequence entity) {
        visit((Collection) entity);
    }

    public void visit(OrderedPair entity) {
        visit((IMathEntity) entity);
        visit((Sequence) entity);
    }

    public void visit(Tuple entity) {
        visit((IMathEntity) entity);
        visit((Sequence) entity);
    }

    public void visit(List entity) {
        visit((IMathEntity) entity);
        visit((Sequence) entity);
    }

    public void visit(Stream entity) {
        visit((IMathEntity) entity);
        visit((Sequence) entity);
    }

    public void visit(Constructor entity) {
    }

    public void visit(Enumeration entity) {
        visit((IMathEntity) entity);
        visit((Constructor) entity);
    }

    public void visit(Builder entity) {
        visit((IMathEntity) entity);
        visit((Constructor) entity);
    }

    public void visit(Union entity) {
        visit((IMathEntity) entity);
        visit((CollectionExpression) entity);
    }

    public void visit(Intersection entity) {
        visit((IMathEntity) entity);
        visit((CollectionExpression) entity);
    }

    public void visit(Difference entity) {
        visit((IMathEntity) entity);
        visit((CollectionExpression) entity);
    }

    public void visit(In entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(NotIn entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(Subset entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(ProperSubset entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(NotSubset entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(NotProperSubset entity) {
        visit((IMathEntity) entity);
        visit((LogicExpression) entity);
    }

    public void visit(Cardinality entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Selector entity) {
        visit((IMathEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Variable entity) {
        visit((Expression) entity);
    }

    public void visit(Identifier entity) {
        visit((IMathEntity) entity);
        visit((Variable) entity);
    }

    public void visit(Number entity) {
        visit((Expression) entity);
    }

    public void visit(Boolean entity) {
        visit((IMathEntity) entity);
        visit((Number) entity);
    }

    public void visit(IntegerNumber entity) {
        visit((Number) entity);
    }

    public void visit(ByteInteger entity) {
        visit((IMathEntity) entity);
        visit((IntegerNumber) entity);
    }

    public void visit(ShortInteger entity) {
        visit((IMathEntity) entity);
        visit((IntegerNumber) entity);
    }

    public void visit(Integer entity) {
        visit((IMathEntity) entity);
        visit((IntegerNumber) entity);
    }

    public void visit(LongInteger entity) {
        visit((IMathEntity) entity);
        visit((IntegerNumber) entity);
    }

    public void visit(BigInteger entity) {
        visit((IMathEntity) entity);
        visit((IntegerNumber) entity);
    }

    public void visit(DecimalNumber entity) {
        visit((Number) entity);
    }

    public void visit(Float entity) {
        visit((IMathEntity) entity);
        visit((DecimalNumber) entity);
    }

    public void visit(Double entity) {
        visit((IMathEntity) entity);
        visit((DecimalNumber) entity);
    }

    public void visit(BigDecimal entity) {
        visit((IMathEntity) entity);
        visit((DecimalNumber) entity);
    }

    public void visit(Rational entity) {
        visit((IMathEntity) entity);
        visit((Number) entity);
    }

    public void visit(Constant entity) {
        visit((IMathEntity) entity);
        visit((Number) entity);
    }

    public void visit(NotANumber entity) {
        visit((IMathEntity) entity);
        visit((Number) entity);
    }
}
