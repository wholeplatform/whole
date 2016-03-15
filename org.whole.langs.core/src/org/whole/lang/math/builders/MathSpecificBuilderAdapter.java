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

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import java.math.BigInteger;
import java.math.BigDecimal;
import org.whole.lang.math.model.ConstantEnum;

/**
 *  @generator Whole
 */
public class MathSpecificBuilderAdapter extends GenericBuilderContext implements IMathBuilder {

    public MathSpecificBuilderAdapter(IBuilder strategy) {
        super(strategy);
    }

    public MathSpecificBuilderAdapter(IBuilder strategy, IEntityContext entityContext) {
        super(strategy, entityContext);
    }

    public void denominator() {
        wFeature(MathFeatureDescriptorEnum.denominator);
    }

    public void numerator() {
        wFeature(MathFeatureDescriptorEnum.numerator);
    }

    public void index() {
        wFeature(MathFeatureDescriptorEnum.index);
    }

    public void collection() {
        wFeature(MathFeatureDescriptorEnum.collection);
    }

    public void collection2() {
        wFeature(MathFeatureDescriptorEnum.collection2);
    }

    public void collection1() {
        wFeature(MathFeatureDescriptorEnum.collection1);
    }

    public void rule() {
        wFeature(MathFeatureDescriptorEnum.rule);
    }

    public void element() {
        wFeature(MathFeatureDescriptorEnum.element);
    }

    public void second() {
        wFeature(MathFeatureDescriptorEnum.second);
    }

    public void first() {
        wFeature(MathFeatureDescriptorEnum.first);
    }

    public void elements() {
        wFeature(MathFeatureDescriptorEnum.elements);
    }

    public void bits() {
        wFeature(MathFeatureDescriptorEnum.bits);
    }

    public void exp2() {
        wFeature(MathFeatureDescriptorEnum.exp2);
    }

    public void exp1() {
        wFeature(MathFeatureDescriptorEnum.exp1);
    }

    public void degree() {
        wFeature(MathFeatureDescriptorEnum.degree);
    }

    public void expression() {
        wFeature(MathFeatureDescriptorEnum.expression);
    }

    public void exponent() {
        wFeature(MathFeatureDescriptorEnum.exponent);
    }

    public void base() {
        wFeature(MathFeatureDescriptorEnum.base);
    }

    public void divisor() {
        wFeature(MathFeatureDescriptorEnum.divisor);
    }

    public void dividend() {
        wFeature(MathFeatureDescriptorEnum.dividend);
    }

    public void subtrahend() {
        wFeature(MathFeatureDescriptorEnum.subtrahend);
    }

    public void minuend() {
        wFeature(MathFeatureDescriptorEnum.minuend);
    }

    public void visit() {
    }

    public void Addition() {
        wEntity(MathEntityDescriptorEnum.Addition);
    }

    public void Addition_() {
        wEntity_(MathEntityDescriptorEnum.Addition);
    }

    public void Addition_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Addition, initialCapacity);
    }

    public void _Addition() {
        _wEntity(MathEntityDescriptorEnum.Addition);
    }

    public void Subtraction() {
        wEntity(MathEntityDescriptorEnum.Subtraction);
    }

    public void Subtraction_() {
        wEntity_(MathEntityDescriptorEnum.Subtraction);
    }

    public void _Subtraction() {
        _wEntity(MathEntityDescriptorEnum.Subtraction);
    }

    public void Multiplication() {
        wEntity(MathEntityDescriptorEnum.Multiplication);
    }

    public void Multiplication_() {
        wEntity_(MathEntityDescriptorEnum.Multiplication);
    }

    public void Multiplication_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Multiplication, initialCapacity);
    }

    public void _Multiplication() {
        _wEntity(MathEntityDescriptorEnum.Multiplication);
    }

    public void Division() {
        wEntity(MathEntityDescriptorEnum.Division);
    }

    public void Division_() {
        wEntity_(MathEntityDescriptorEnum.Division);
    }

    public void _Division() {
        _wEntity(MathEntityDescriptorEnum.Division);
    }

    public void Quotient() {
        wEntity(MathEntityDescriptorEnum.Quotient);
    }

    public void Quotient_() {
        wEntity_(MathEntityDescriptorEnum.Quotient);
    }

    public void _Quotient() {
        _wEntity(MathEntityDescriptorEnum.Quotient);
    }

    public void Remainder() {
        wEntity(MathEntityDescriptorEnum.Remainder);
    }

    public void Remainder_() {
        wEntity_(MathEntityDescriptorEnum.Remainder);
    }

    public void _Remainder() {
        _wEntity(MathEntityDescriptorEnum.Remainder);
    }

    public void Exponentiation() {
        wEntity(MathEntityDescriptorEnum.Exponentiation);
    }

    public void Exponentiation_() {
        wEntity_(MathEntityDescriptorEnum.Exponentiation);
    }

    public void _Exponentiation() {
        _wEntity(MathEntityDescriptorEnum.Exponentiation);
    }

    public void Root() {
        wEntity(MathEntityDescriptorEnum.Root);
    }

    public void Root_() {
        wEntity_(MathEntityDescriptorEnum.Root);
    }

    public void _Root() {
        _wEntity(MathEntityDescriptorEnum.Root);
    }

    public void Minus() {
        wEntity(MathEntityDescriptorEnum.Minus);
    }

    public void Minus_() {
        wEntity_(MathEntityDescriptorEnum.Minus);
    }

    public void _Minus() {
        _wEntity(MathEntityDescriptorEnum.Minus);
    }

    public void AbsoluteValue() {
        wEntity(MathEntityDescriptorEnum.AbsoluteValue);
    }

    public void AbsoluteValue_() {
        wEntity_(MathEntityDescriptorEnum.AbsoluteValue);
    }

    public void _AbsoluteValue() {
        _wEntity(MathEntityDescriptorEnum.AbsoluteValue);
    }

    public void Floor() {
        wEntity(MathEntityDescriptorEnum.Floor);
    }

    public void Floor_() {
        wEntity_(MathEntityDescriptorEnum.Floor);
    }

    public void _Floor() {
        _wEntity(MathEntityDescriptorEnum.Floor);
    }

    public void Ceiling() {
        wEntity(MathEntityDescriptorEnum.Ceiling);
    }

    public void Ceiling_() {
        wEntity_(MathEntityDescriptorEnum.Ceiling);
    }

    public void _Ceiling() {
        _wEntity(MathEntityDescriptorEnum.Ceiling);
    }

    public void Factorial() {
        wEntity(MathEntityDescriptorEnum.Factorial);
    }

    public void Factorial_() {
        wEntity_(MathEntityDescriptorEnum.Factorial);
    }

    public void _Factorial() {
        _wEntity(MathEntityDescriptorEnum.Factorial);
    }

    public void GreatestCommonDivisor() {
        wEntity(MathEntityDescriptorEnum.GreatestCommonDivisor);
    }

    public void GreatestCommonDivisor_() {
        wEntity_(MathEntityDescriptorEnum.GreatestCommonDivisor);
    }

    public void GreatestCommonDivisor_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.GreatestCommonDivisor, initialCapacity);
    }

    public void _GreatestCommonDivisor() {
        _wEntity(MathEntityDescriptorEnum.GreatestCommonDivisor);
    }

    public void LowestCommonMultiple() {
        wEntity(MathEntityDescriptorEnum.LowestCommonMultiple);
    }

    public void LowestCommonMultiple_() {
        wEntity_(MathEntityDescriptorEnum.LowestCommonMultiple);
    }

    public void LowestCommonMultiple_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.LowestCommonMultiple, initialCapacity);
    }

    public void _LowestCommonMultiple() {
        _wEntity(MathEntityDescriptorEnum.LowestCommonMultiple);
    }

    public void Maximum() {
        wEntity(MathEntityDescriptorEnum.Maximum);
    }

    public void Maximum_() {
        wEntity_(MathEntityDescriptorEnum.Maximum);
    }

    public void Maximum_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Maximum, initialCapacity);
    }

    public void _Maximum() {
        _wEntity(MathEntityDescriptorEnum.Maximum);
    }

    public void Minimum() {
        wEntity(MathEntityDescriptorEnum.Minimum);
    }

    public void Minimum_() {
        wEntity_(MathEntityDescriptorEnum.Minimum);
    }

    public void Minimum_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Minimum, initialCapacity);
    }

    public void _Minimum() {
        _wEntity(MathEntityDescriptorEnum.Minimum);
    }

    public void And() {
        wEntity(MathEntityDescriptorEnum.And);
    }

    public void And_() {
        wEntity_(MathEntityDescriptorEnum.And);
    }

    public void And_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.And, initialCapacity);
    }

    public void _And() {
        _wEntity(MathEntityDescriptorEnum.And);
    }

    public void Or() {
        wEntity(MathEntityDescriptorEnum.Or);
    }

    public void Or_() {
        wEntity_(MathEntityDescriptorEnum.Or);
    }

    public void Or_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Or, initialCapacity);
    }

    public void _Or() {
        _wEntity(MathEntityDescriptorEnum.Or);
    }

    public void ExclusiveOr() {
        wEntity(MathEntityDescriptorEnum.ExclusiveOr);
    }

    public void ExclusiveOr_() {
        wEntity_(MathEntityDescriptorEnum.ExclusiveOr);
    }

    public void ExclusiveOr_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.ExclusiveOr, initialCapacity);
    }

    public void _ExclusiveOr() {
        _wEntity(MathEntityDescriptorEnum.ExclusiveOr);
    }

    public void Not() {
        wEntity(MathEntityDescriptorEnum.Not);
    }

    public void Not_() {
        wEntity_(MathEntityDescriptorEnum.Not);
    }

    public void _Not() {
        _wEntity(MathEntityDescriptorEnum.Not);
    }

    public void Implies() {
        wEntity(MathEntityDescriptorEnum.Implies);
    }

    public void Implies_() {
        wEntity_(MathEntityDescriptorEnum.Implies);
    }

    public void _Implies() {
        _wEntity(MathEntityDescriptorEnum.Implies);
    }

    public void BitwiseAnd() {
        wEntity(MathEntityDescriptorEnum.BitwiseAnd);
    }

    public void BitwiseAnd_() {
        wEntity_(MathEntityDescriptorEnum.BitwiseAnd);
    }

    public void BitwiseAnd_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.BitwiseAnd, initialCapacity);
    }

    public void _BitwiseAnd() {
        _wEntity(MathEntityDescriptorEnum.BitwiseAnd);
    }

    public void BitwiseOr() {
        wEntity(MathEntityDescriptorEnum.BitwiseOr);
    }

    public void BitwiseOr_() {
        wEntity_(MathEntityDescriptorEnum.BitwiseOr);
    }

    public void BitwiseOr_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.BitwiseOr, initialCapacity);
    }

    public void _BitwiseOr() {
        _wEntity(MathEntityDescriptorEnum.BitwiseOr);
    }

    public void BitwiseExclusiveOr() {
        wEntity(MathEntityDescriptorEnum.BitwiseExclusiveOr);
    }

    public void BitwiseExclusiveOr_() {
        wEntity_(MathEntityDescriptorEnum.BitwiseExclusiveOr);
    }

    public void BitwiseExclusiveOr_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.BitwiseExclusiveOr, initialCapacity);
    }

    public void _BitwiseExclusiveOr() {
        _wEntity(MathEntityDescriptorEnum.BitwiseExclusiveOr);
    }

    public void BitwiseNot() {
        wEntity(MathEntityDescriptorEnum.BitwiseNot);
    }

    public void BitwiseNot_() {
        wEntity_(MathEntityDescriptorEnum.BitwiseNot);
    }

    public void _BitwiseNot() {
        _wEntity(MathEntityDescriptorEnum.BitwiseNot);
    }

    public void ShiftLeft() {
        wEntity(MathEntityDescriptorEnum.ShiftLeft);
    }

    public void ShiftLeft_() {
        wEntity_(MathEntityDescriptorEnum.ShiftLeft);
    }

    public void _ShiftLeft() {
        _wEntity(MathEntityDescriptorEnum.ShiftLeft);
    }

    public void ShiftRight() {
        wEntity(MathEntityDescriptorEnum.ShiftRight);
    }

    public void ShiftRight_() {
        wEntity_(MathEntityDescriptorEnum.ShiftRight);
    }

    public void _ShiftRight() {
        _wEntity(MathEntityDescriptorEnum.ShiftRight);
    }

    public void ArithmeticShiftRight() {
        wEntity(MathEntityDescriptorEnum.ArithmeticShiftRight);
    }

    public void ArithmeticShiftRight_() {
        wEntity_(MathEntityDescriptorEnum.ArithmeticShiftRight);
    }

    public void _ArithmeticShiftRight() {
        _wEntity(MathEntityDescriptorEnum.ArithmeticShiftRight);
    }

    public void Equals() {
        wEntity(MathEntityDescriptorEnum.Equals);
    }

    public void Equals_() {
        wEntity_(MathEntityDescriptorEnum.Equals);
    }

    public void Equals_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Equals, initialCapacity);
    }

    public void _Equals() {
        _wEntity(MathEntityDescriptorEnum.Equals);
    }

    public void NotEquals() {
        wEntity(MathEntityDescriptorEnum.NotEquals);
    }

    public void NotEquals_() {
        wEntity_(MathEntityDescriptorEnum.NotEquals);
    }

    public void _NotEquals() {
        _wEntity(MathEntityDescriptorEnum.NotEquals);
    }

    public void ApproximatelyEqual() {
        wEntity(MathEntityDescriptorEnum.ApproximatelyEqual);
    }

    public void ApproximatelyEqual_() {
        wEntity_(MathEntityDescriptorEnum.ApproximatelyEqual);
    }

    public void _ApproximatelyEqual() {
        _wEntity(MathEntityDescriptorEnum.ApproximatelyEqual);
    }

    public void GreaterThan() {
        wEntity(MathEntityDescriptorEnum.GreaterThan);
    }

    public void GreaterThan_() {
        wEntity_(MathEntityDescriptorEnum.GreaterThan);
    }

    public void GreaterThan_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.GreaterThan, initialCapacity);
    }

    public void _GreaterThan() {
        _wEntity(MathEntityDescriptorEnum.GreaterThan);
    }

    public void LessThan() {
        wEntity(MathEntityDescriptorEnum.LessThan);
    }

    public void LessThan_() {
        wEntity_(MathEntityDescriptorEnum.LessThan);
    }

    public void LessThan_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.LessThan, initialCapacity);
    }

    public void _LessThan() {
        _wEntity(MathEntityDescriptorEnum.LessThan);
    }

    public void GreaterOrEqual() {
        wEntity(MathEntityDescriptorEnum.GreaterOrEqual);
    }

    public void GreaterOrEqual_() {
        wEntity_(MathEntityDescriptorEnum.GreaterOrEqual);
    }

    public void GreaterOrEqual_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.GreaterOrEqual, initialCapacity);
    }

    public void _GreaterOrEqual() {
        _wEntity(MathEntityDescriptorEnum.GreaterOrEqual);
    }

    public void LessOrEqual() {
        wEntity(MathEntityDescriptorEnum.LessOrEqual);
    }

    public void LessOrEqual_() {
        wEntity_(MathEntityDescriptorEnum.LessOrEqual);
    }

    public void LessOrEqual_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.LessOrEqual, initialCapacity);
    }

    public void _LessOrEqual() {
        _wEntity(MathEntityDescriptorEnum.LessOrEqual);
    }

    public void FactorOf() {
        wEntity(MathEntityDescriptorEnum.FactorOf);
    }

    public void FactorOf_() {
        wEntity_(MathEntityDescriptorEnum.FactorOf);
    }

    public void _FactorOf() {
        _wEntity(MathEntityDescriptorEnum.FactorOf);
    }

    public void Exponential() {
        wEntity(MathEntityDescriptorEnum.Exponential);
    }

    public void Exponential_() {
        wEntity_(MathEntityDescriptorEnum.Exponential);
    }

    public void _Exponential() {
        _wEntity(MathEntityDescriptorEnum.Exponential);
    }

    public void NaturalLogarithm() {
        wEntity(MathEntityDescriptorEnum.NaturalLogarithm);
    }

    public void NaturalLogarithm_() {
        wEntity_(MathEntityDescriptorEnum.NaturalLogarithm);
    }

    public void _NaturalLogarithm() {
        _wEntity(MathEntityDescriptorEnum.NaturalLogarithm);
    }

    public void Logarithm() {
        wEntity(MathEntityDescriptorEnum.Logarithm);
    }

    public void Logarithm_() {
        wEntity_(MathEntityDescriptorEnum.Logarithm);
    }

    public void _Logarithm() {
        _wEntity(MathEntityDescriptorEnum.Logarithm);
    }

    public void Sine() {
        wEntity(MathEntityDescriptorEnum.Sine);
    }

    public void Sine_() {
        wEntity_(MathEntityDescriptorEnum.Sine);
    }

    public void _Sine() {
        _wEntity(MathEntityDescriptorEnum.Sine);
    }

    public void Cosine() {
        wEntity(MathEntityDescriptorEnum.Cosine);
    }

    public void Cosine_() {
        wEntity_(MathEntityDescriptorEnum.Cosine);
    }

    public void _Cosine() {
        _wEntity(MathEntityDescriptorEnum.Cosine);
    }

    public void Tangent() {
        wEntity(MathEntityDescriptorEnum.Tangent);
    }

    public void Tangent_() {
        wEntity_(MathEntityDescriptorEnum.Tangent);
    }

    public void _Tangent() {
        _wEntity(MathEntityDescriptorEnum.Tangent);
    }

    public void Cosecant() {
        wEntity(MathEntityDescriptorEnum.Cosecant);
    }

    public void Cosecant_() {
        wEntity_(MathEntityDescriptorEnum.Cosecant);
    }

    public void _Cosecant() {
        _wEntity(MathEntityDescriptorEnum.Cosecant);
    }

    public void Secant() {
        wEntity(MathEntityDescriptorEnum.Secant);
    }

    public void Secant_() {
        wEntity_(MathEntityDescriptorEnum.Secant);
    }

    public void _Secant() {
        _wEntity(MathEntityDescriptorEnum.Secant);
    }

    public void Cotangent() {
        wEntity(MathEntityDescriptorEnum.Cotangent);
    }

    public void Cotangent_() {
        wEntity_(MathEntityDescriptorEnum.Cotangent);
    }

    public void _Cotangent() {
        _wEntity(MathEntityDescriptorEnum.Cotangent);
    }

    public void Arcsine() {
        wEntity(MathEntityDescriptorEnum.Arcsine);
    }

    public void Arcsine_() {
        wEntity_(MathEntityDescriptorEnum.Arcsine);
    }

    public void _Arcsine() {
        _wEntity(MathEntityDescriptorEnum.Arcsine);
    }

    public void Arccosine() {
        wEntity(MathEntityDescriptorEnum.Arccosine);
    }

    public void Arccosine_() {
        wEntity_(MathEntityDescriptorEnum.Arccosine);
    }

    public void _Arccosine() {
        _wEntity(MathEntityDescriptorEnum.Arccosine);
    }

    public void Arctangent() {
        wEntity(MathEntityDescriptorEnum.Arctangent);
    }

    public void Arctangent_() {
        wEntity_(MathEntityDescriptorEnum.Arctangent);
    }

    public void _Arctangent() {
        _wEntity(MathEntityDescriptorEnum.Arctangent);
    }

    public void Arccosecant() {
        wEntity(MathEntityDescriptorEnum.Arccosecant);
    }

    public void Arccosecant_() {
        wEntity_(MathEntityDescriptorEnum.Arccosecant);
    }

    public void _Arccosecant() {
        _wEntity(MathEntityDescriptorEnum.Arccosecant);
    }

    public void Arcsecant() {
        wEntity(MathEntityDescriptorEnum.Arcsecant);
    }

    public void Arcsecant_() {
        wEntity_(MathEntityDescriptorEnum.Arcsecant);
    }

    public void _Arcsecant() {
        _wEntity(MathEntityDescriptorEnum.Arcsecant);
    }

    public void Arccotangent() {
        wEntity(MathEntityDescriptorEnum.Arccotangent);
    }

    public void Arccotangent_() {
        wEntity_(MathEntityDescriptorEnum.Arccotangent);
    }

    public void _Arccotangent() {
        _wEntity(MathEntityDescriptorEnum.Arccotangent);
    }

    public void HyperbolicSine() {
        wEntity(MathEntityDescriptorEnum.HyperbolicSine);
    }

    public void HyperbolicSine_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicSine);
    }

    public void _HyperbolicSine() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicSine);
    }

    public void HyperbolicCosine() {
        wEntity(MathEntityDescriptorEnum.HyperbolicCosine);
    }

    public void HyperbolicCosine_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicCosine);
    }

    public void _HyperbolicCosine() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicCosine);
    }

    public void HyperbolicTangent() {
        wEntity(MathEntityDescriptorEnum.HyperbolicTangent);
    }

    public void HyperbolicTangent_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicTangent);
    }

    public void _HyperbolicTangent() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicTangent);
    }

    public void HyperbolicCosecant() {
        wEntity(MathEntityDescriptorEnum.HyperbolicCosecant);
    }

    public void HyperbolicCosecant_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicCosecant);
    }

    public void _HyperbolicCosecant() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicCosecant);
    }

    public void HyperbolicSecant() {
        wEntity(MathEntityDescriptorEnum.HyperbolicSecant);
    }

    public void HyperbolicSecant_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicSecant);
    }

    public void _HyperbolicSecant() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicSecant);
    }

    public void HyperbolicCotangent() {
        wEntity(MathEntityDescriptorEnum.HyperbolicCotangent);
    }

    public void HyperbolicCotangent_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicCotangent);
    }

    public void _HyperbolicCotangent() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicCotangent);
    }

    public void HyperbolicArcsine() {
        wEntity(MathEntityDescriptorEnum.HyperbolicArcsine);
    }

    public void HyperbolicArcsine_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicArcsine);
    }

    public void _HyperbolicArcsine() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicArcsine);
    }

    public void HyperbolicArccosine() {
        wEntity(MathEntityDescriptorEnum.HyperbolicArccosine);
    }

    public void HyperbolicArccosine_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicArccosine);
    }

    public void _HyperbolicArccosine() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicArccosine);
    }

    public void HyperbolicArctangent() {
        wEntity(MathEntityDescriptorEnum.HyperbolicArctangent);
    }

    public void HyperbolicArctangent_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicArctangent);
    }

    public void _HyperbolicArctangent() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicArctangent);
    }

    public void HyperbolicArccosecant() {
        wEntity(MathEntityDescriptorEnum.HyperbolicArccosecant);
    }

    public void HyperbolicArccosecant_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicArccosecant);
    }

    public void _HyperbolicArccosecant() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicArccosecant);
    }

    public void HyperbolicArcsecant() {
        wEntity(MathEntityDescriptorEnum.HyperbolicArcsecant);
    }

    public void HyperbolicArcsecant_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicArcsecant);
    }

    public void _HyperbolicArcsecant() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicArcsecant);
    }

    public void HyperbolicArccotangent() {
        wEntity(MathEntityDescriptorEnum.HyperbolicArccotangent);
    }

    public void HyperbolicArccotangent_() {
        wEntity_(MathEntityDescriptorEnum.HyperbolicArccotangent);
    }

    public void _HyperbolicArccotangent() {
        _wEntity(MathEntityDescriptorEnum.HyperbolicArccotangent);
    }

    public void Empty() {
        wEntity(MathEntityDescriptorEnum.Empty);
    }

    public void Empty_() {
        wEntity_(MathEntityDescriptorEnum.Empty);
    }

    public void _Empty() {
        _wEntity(MathEntityDescriptorEnum.Empty);
    }

    public void Set() {
        wEntity(MathEntityDescriptorEnum.Set);
    }

    public void Set_() {
        wEntity_(MathEntityDescriptorEnum.Set);
    }

    public void _Set() {
        _wEntity(MathEntityDescriptorEnum.Set);
    }

    public void OrderedPair() {
        wEntity(MathEntityDescriptorEnum.OrderedPair);
    }

    public void OrderedPair_() {
        wEntity_(MathEntityDescriptorEnum.OrderedPair);
    }

    public void _OrderedPair() {
        _wEntity(MathEntityDescriptorEnum.OrderedPair);
    }

    public void Tuple() {
        wEntity(MathEntityDescriptorEnum.Tuple);
    }

    public void Tuple_() {
        wEntity_(MathEntityDescriptorEnum.Tuple);
    }

    public void Tuple_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Tuple, initialCapacity);
    }

    public void _Tuple() {
        _wEntity(MathEntityDescriptorEnum.Tuple);
    }

    public void List() {
        wEntity(MathEntityDescriptorEnum.List);
    }

    public void List_() {
        wEntity_(MathEntityDescriptorEnum.List);
    }

    public void _List() {
        _wEntity(MathEntityDescriptorEnum.List);
    }

    public void Stream() {
        wEntity(MathEntityDescriptorEnum.Stream);
    }

    public void Stream_() {
        wEntity_(MathEntityDescriptorEnum.Stream);
    }

    public void _Stream() {
        _wEntity(MathEntityDescriptorEnum.Stream);
    }

    public void Enumeration() {
        wEntity(MathEntityDescriptorEnum.Enumeration);
    }

    public void Enumeration_() {
        wEntity_(MathEntityDescriptorEnum.Enumeration);
    }

    public void Enumeration_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Enumeration, initialCapacity);
    }

    public void _Enumeration() {
        _wEntity(MathEntityDescriptorEnum.Enumeration);
    }

    public void Builder() {
        wEntity(MathEntityDescriptorEnum.Builder);
    }

    public void Builder_() {
        wEntity_(MathEntityDescriptorEnum.Builder);
    }

    public void _Builder() {
        _wEntity(MathEntityDescriptorEnum.Builder);
    }

    public void Union() {
        wEntity(MathEntityDescriptorEnum.Union);
    }

    public void Union_() {
        wEntity_(MathEntityDescriptorEnum.Union);
    }

    public void Union_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Union, initialCapacity);
    }

    public void _Union() {
        _wEntity(MathEntityDescriptorEnum.Union);
    }

    public void Intersection() {
        wEntity(MathEntityDescriptorEnum.Intersection);
    }

    public void Intersection_() {
        wEntity_(MathEntityDescriptorEnum.Intersection);
    }

    public void Intersection_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Intersection, initialCapacity);
    }

    public void _Intersection() {
        _wEntity(MathEntityDescriptorEnum.Intersection);
    }

    public void Difference() {
        wEntity(MathEntityDescriptorEnum.Difference);
    }

    public void Difference_() {
        wEntity_(MathEntityDescriptorEnum.Difference);
    }

    public void _Difference() {
        _wEntity(MathEntityDescriptorEnum.Difference);
    }

    public void In() {
        wEntity(MathEntityDescriptorEnum.In);
    }

    public void In_() {
        wEntity_(MathEntityDescriptorEnum.In);
    }

    public void _In() {
        _wEntity(MathEntityDescriptorEnum.In);
    }

    public void NotIn() {
        wEntity(MathEntityDescriptorEnum.NotIn);
    }

    public void NotIn_() {
        wEntity_(MathEntityDescriptorEnum.NotIn);
    }

    public void _NotIn() {
        _wEntity(MathEntityDescriptorEnum.NotIn);
    }

    public void Subset() {
        wEntity(MathEntityDescriptorEnum.Subset);
    }

    public void Subset_() {
        wEntity_(MathEntityDescriptorEnum.Subset);
    }

    public void Subset_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.Subset, initialCapacity);
    }

    public void _Subset() {
        _wEntity(MathEntityDescriptorEnum.Subset);
    }

    public void ProperSubset() {
        wEntity(MathEntityDescriptorEnum.ProperSubset);
    }

    public void ProperSubset_() {
        wEntity_(MathEntityDescriptorEnum.ProperSubset);
    }

    public void ProperSubset_(int initialCapacity) {
        wEntity_(MathEntityDescriptorEnum.ProperSubset, initialCapacity);
    }

    public void _ProperSubset() {
        _wEntity(MathEntityDescriptorEnum.ProperSubset);
    }

    public void NotSubset() {
        wEntity(MathEntityDescriptorEnum.NotSubset);
    }

    public void NotSubset_() {
        wEntity_(MathEntityDescriptorEnum.NotSubset);
    }

    public void _NotSubset() {
        _wEntity(MathEntityDescriptorEnum.NotSubset);
    }

    public void NotProperSubset() {
        wEntity(MathEntityDescriptorEnum.NotProperSubset);
    }

    public void NotProperSubset_() {
        wEntity_(MathEntityDescriptorEnum.NotProperSubset);
    }

    public void _NotProperSubset() {
        _wEntity(MathEntityDescriptorEnum.NotProperSubset);
    }

    public void Cardinality() {
        wEntity(MathEntityDescriptorEnum.Cardinality);
    }

    public void Cardinality_() {
        wEntity_(MathEntityDescriptorEnum.Cardinality);
    }

    public void _Cardinality() {
        _wEntity(MathEntityDescriptorEnum.Cardinality);
    }

    public void Selector() {
        wEntity(MathEntityDescriptorEnum.Selector);
    }

    public void Selector_() {
        wEntity_(MathEntityDescriptorEnum.Selector);
    }

    public void _Selector() {
        _wEntity(MathEntityDescriptorEnum.Selector);
    }

    public void Identifier() {
        wEntity(MathEntityDescriptorEnum.Identifier);
    }

    public void Identifier(String value) {
        wEntity(MathEntityDescriptorEnum.Identifier, value);
    }

    public void Boolean() {
        wEntity(MathEntityDescriptorEnum.Boolean);
    }

    public void Boolean(boolean value) {
        wEntity(MathEntityDescriptorEnum.Boolean, value);
    }

    public void ByteInteger() {
        wEntity(MathEntityDescriptorEnum.ByteInteger);
    }

    public void ByteInteger(byte value) {
        wEntity(MathEntityDescriptorEnum.ByteInteger, value);
    }

    public void ShortInteger() {
        wEntity(MathEntityDescriptorEnum.ShortInteger);
    }

    public void ShortInteger(short value) {
        wEntity(MathEntityDescriptorEnum.ShortInteger, value);
    }

    public void Integer() {
        wEntity(MathEntityDescriptorEnum.Integer);
    }

    public void Integer(int value) {
        wEntity(MathEntityDescriptorEnum.Integer, value);
    }

    public void LongInteger() {
        wEntity(MathEntityDescriptorEnum.LongInteger);
    }

    public void LongInteger(long value) {
        wEntity(MathEntityDescriptorEnum.LongInteger, value);
    }

    public void BigInteger() {
        wEntity(MathEntityDescriptorEnum.BigInteger);
    }

    public void BigInteger(BigInteger value) {
        wEntity(MathEntityDescriptorEnum.BigInteger, value);
    }

    public void BigInteger(String value) {
        wEntity(MathEntityDescriptorEnum.BigInteger, value);
    }

    public void Float() {
        wEntity(MathEntityDescriptorEnum.Float);
    }

    public void Float(float value) {
        wEntity(MathEntityDescriptorEnum.Float, value);
    }

    public void Double() {
        wEntity(MathEntityDescriptorEnum.Double);
    }

    public void Double(double value) {
        wEntity(MathEntityDescriptorEnum.Double, value);
    }

    public void BigDecimal() {
        wEntity(MathEntityDescriptorEnum.BigDecimal);
    }

    public void BigDecimal(BigDecimal value) {
        wEntity(MathEntityDescriptorEnum.BigDecimal, value);
    }

    public void BigDecimal(String value) {
        wEntity(MathEntityDescriptorEnum.BigDecimal, value);
    }

    public void Rational() {
        wEntity(MathEntityDescriptorEnum.Rational);
    }

    public void Rational_() {
        wEntity_(MathEntityDescriptorEnum.Rational);
    }

    public void _Rational() {
        _wEntity(MathEntityDescriptorEnum.Rational);
    }

    public void Constant() {
        wEntity(MathEntityDescriptorEnum.Constant);
    }

    public void Constant(ConstantEnum.Value value) {
        wEntity(MathEntityDescriptorEnum.Constant, value);
    }

    public void Constant(String value) {
        wEntity(MathEntityDescriptorEnum.Constant, value);
    }

    public void NotANumber() {
        wEntity(MathEntityDescriptorEnum.NotANumber);
    }

    public void NotANumber_() {
        wEntity_(MathEntityDescriptorEnum.NotANumber);
    }

    public void _NotANumber() {
        _wEntity(MathEntityDescriptorEnum.NotANumber);
    }
}
