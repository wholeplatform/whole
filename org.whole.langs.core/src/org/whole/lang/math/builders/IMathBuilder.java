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
package org.whole.lang.math.builders;

import org.whole.lang.builders.IBuilder;
import java.math.BigInteger;
import java.math.BigDecimal;
import org.whole.lang.math.model.ConstantEnum;

/**
 *  @generator Whole
 */
public interface IMathBuilder extends IBuilder {


    public void visit();

    public void denominator();

    public void numerator();

    public void index();

    public void collection();

    public void collection2();

    public void collection1();

    public void rule();

    public void element();

    public void second();

    public void first();

    public void elements();

    public void bits();

    public void exp2();

    public void exp1();

    public void degree();

    public void expression();

    public void exponent();

    public void base();

    public void divisor();

    public void dividend();

    public void subtrahend();

    public void minuend();

    public void Addition();

    public void Addition_();

    public void Addition_(int initialCapacity);

    public void _Addition();

    public void Subtraction();

    public void Subtraction_();

    public void _Subtraction();

    public void Multiplication();

    public void Multiplication_();

    public void Multiplication_(int initialCapacity);

    public void _Multiplication();

    public void Division();

    public void Division_();

    public void _Division();

    public void Quotient();

    public void Quotient_();

    public void _Quotient();

    public void Remainder();

    public void Remainder_();

    public void _Remainder();

    public void Exponentiation();

    public void Exponentiation_();

    public void _Exponentiation();

    public void Root();

    public void Root_();

    public void _Root();

    public void Minus();

    public void Minus_();

    public void _Minus();

    public void AbsoluteValue();

    public void AbsoluteValue_();

    public void _AbsoluteValue();

    public void Floor();

    public void Floor_();

    public void _Floor();

    public void Ceiling();

    public void Ceiling_();

    public void _Ceiling();

    public void Factorial();

    public void Factorial_();

    public void _Factorial();

    public void GreatestCommonDivisor();

    public void GreatestCommonDivisor_();

    public void GreatestCommonDivisor_(int initialCapacity);

    public void _GreatestCommonDivisor();

    public void LowestCommonMultiple();

    public void LowestCommonMultiple_();

    public void LowestCommonMultiple_(int initialCapacity);

    public void _LowestCommonMultiple();

    public void Maximum();

    public void Maximum_();

    public void Maximum_(int initialCapacity);

    public void _Maximum();

    public void Minimum();

    public void Minimum_();

    public void Minimum_(int initialCapacity);

    public void _Minimum();

    public void And();

    public void And_();

    public void And_(int initialCapacity);

    public void _And();

    public void Or();

    public void Or_();

    public void Or_(int initialCapacity);

    public void _Or();

    public void ExclusiveOr();

    public void ExclusiveOr_();

    public void ExclusiveOr_(int initialCapacity);

    public void _ExclusiveOr();

    public void Not();

    public void Not_();

    public void _Not();

    public void Implies();

    public void Implies_();

    public void _Implies();

    public void BitwiseAnd();

    public void BitwiseAnd_();

    public void BitwiseAnd_(int initialCapacity);

    public void _BitwiseAnd();

    public void BitwiseOr();

    public void BitwiseOr_();

    public void BitwiseOr_(int initialCapacity);

    public void _BitwiseOr();

    public void BitwiseExclusiveOr();

    public void BitwiseExclusiveOr_();

    public void BitwiseExclusiveOr_(int initialCapacity);

    public void _BitwiseExclusiveOr();

    public void BitwiseNot();

    public void BitwiseNot_();

    public void _BitwiseNot();

    public void ShiftLeft();

    public void ShiftLeft_();

    public void _ShiftLeft();

    public void ShiftRight();

    public void ShiftRight_();

    public void _ShiftRight();

    public void ArithmeticShiftRight();

    public void ArithmeticShiftRight_();

    public void _ArithmeticShiftRight();

    public void Equals();

    public void Equals_();

    public void Equals_(int initialCapacity);

    public void _Equals();

    public void NotEquals();

    public void NotEquals_();

    public void _NotEquals();

    public void ApproximatelyEqual();

    public void ApproximatelyEqual_();

    public void _ApproximatelyEqual();

    public void GreaterThan();

    public void GreaterThan_();

    public void GreaterThan_(int initialCapacity);

    public void _GreaterThan();

    public void LessThan();

    public void LessThan_();

    public void LessThan_(int initialCapacity);

    public void _LessThan();

    public void GreaterOrEqual();

    public void GreaterOrEqual_();

    public void GreaterOrEqual_(int initialCapacity);

    public void _GreaterOrEqual();

    public void LessOrEqual();

    public void LessOrEqual_();

    public void LessOrEqual_(int initialCapacity);

    public void _LessOrEqual();

    public void FactorOf();

    public void FactorOf_();

    public void _FactorOf();

    public void Exponential();

    public void Exponential_();

    public void _Exponential();

    public void NaturalLogarithm();

    public void NaturalLogarithm_();

    public void _NaturalLogarithm();

    public void Logarithm();

    public void Logarithm_();

    public void _Logarithm();

    public void Sine();

    public void Sine_();

    public void _Sine();

    public void Cosine();

    public void Cosine_();

    public void _Cosine();

    public void Tangent();

    public void Tangent_();

    public void _Tangent();

    public void Cosecant();

    public void Cosecant_();

    public void _Cosecant();

    public void Secant();

    public void Secant_();

    public void _Secant();

    public void Cotangent();

    public void Cotangent_();

    public void _Cotangent();

    public void Arcsine();

    public void Arcsine_();

    public void _Arcsine();

    public void Arccosine();

    public void Arccosine_();

    public void _Arccosine();

    public void Arctangent();

    public void Arctangent_();

    public void _Arctangent();

    public void Arccosecant();

    public void Arccosecant_();

    public void _Arccosecant();

    public void Arcsecant();

    public void Arcsecant_();

    public void _Arcsecant();

    public void Arccotangent();

    public void Arccotangent_();

    public void _Arccotangent();

    public void HyperbolicSine();

    public void HyperbolicSine_();

    public void _HyperbolicSine();

    public void HyperbolicCosine();

    public void HyperbolicCosine_();

    public void _HyperbolicCosine();

    public void HyperbolicTangent();

    public void HyperbolicTangent_();

    public void _HyperbolicTangent();

    public void HyperbolicCosecant();

    public void HyperbolicCosecant_();

    public void _HyperbolicCosecant();

    public void HyperbolicSecant();

    public void HyperbolicSecant_();

    public void _HyperbolicSecant();

    public void HyperbolicCotangent();

    public void HyperbolicCotangent_();

    public void _HyperbolicCotangent();

    public void HyperbolicArcsine();

    public void HyperbolicArcsine_();

    public void _HyperbolicArcsine();

    public void HyperbolicArccosine();

    public void HyperbolicArccosine_();

    public void _HyperbolicArccosine();

    public void HyperbolicArctangent();

    public void HyperbolicArctangent_();

    public void _HyperbolicArctangent();

    public void HyperbolicArccosecant();

    public void HyperbolicArccosecant_();

    public void _HyperbolicArccosecant();

    public void HyperbolicArcsecant();

    public void HyperbolicArcsecant_();

    public void _HyperbolicArcsecant();

    public void HyperbolicArccotangent();

    public void HyperbolicArccotangent_();

    public void _HyperbolicArccotangent();

    public void Empty();

    public void Empty_();

    public void _Empty();

    public void Set();

    public void Set_();

    public void _Set();

    public void OrderedPair();

    public void OrderedPair_();

    public void _OrderedPair();

    public void Tuple();

    public void Tuple_();

    public void Tuple_(int initialCapacity);

    public void _Tuple();

    public void List();

    public void List_();

    public void _List();

    public void Stream();

    public void Stream_();

    public void _Stream();

    public void Enumeration();

    public void Enumeration_();

    public void Enumeration_(int initialCapacity);

    public void _Enumeration();

    public void Builder();

    public void Builder_();

    public void _Builder();

    public void Union();

    public void Union_();

    public void Union_(int initialCapacity);

    public void _Union();

    public void Intersection();

    public void Intersection_();

    public void Intersection_(int initialCapacity);

    public void _Intersection();

    public void Difference();

    public void Difference_();

    public void _Difference();

    public void In();

    public void In_();

    public void _In();

    public void NotIn();

    public void NotIn_();

    public void _NotIn();

    public void Subset();

    public void Subset_();

    public void Subset_(int initialCapacity);

    public void _Subset();

    public void ProperSubset();

    public void ProperSubset_();

    public void ProperSubset_(int initialCapacity);

    public void _ProperSubset();

    public void NotSubset();

    public void NotSubset_();

    public void _NotSubset();

    public void NotProperSubset();

    public void NotProperSubset_();

    public void _NotProperSubset();

    public void Cardinality();

    public void Cardinality_();

    public void _Cardinality();

    public void Selector();

    public void Selector_();

    public void _Selector();

    public void Identifier();

    public void Identifier(String value);

    public void Boolean();

    public void Boolean(boolean value);

    public void ByteInteger();

    public void ByteInteger(byte value);

    public void ShortInteger();

    public void ShortInteger(short value);

    public void Integer();

    public void Integer(int value);

    public void LongInteger();

    public void LongInteger(long value);

    public void BigInteger();

    public void BigInteger(BigInteger value);

    public void BigInteger(String value);

    public void Float();

    public void Float(float value);

    public void Double();

    public void Double(double value);

    public void BigDecimal();

    public void BigDecimal(BigDecimal value);

    public void BigDecimal(String value);

    public void Rational();

    public void Rational_();

    public void _Rational();

    public void Constant();

    public void Constant(ConstantEnum.Value value);

    public void Constant(String value);

    public void NotANumber();

    public void NotANumber_();

    public void _NotANumber();
}
