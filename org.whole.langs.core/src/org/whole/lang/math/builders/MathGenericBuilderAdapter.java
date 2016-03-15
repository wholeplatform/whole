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

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import java.math.BigInteger;
import java.math.BigDecimal;
import org.whole.lang.model.EnumValue;
import org.whole.lang.math.model.ConstantEnum.Value;

/**
 *  @generator Whole
 */
public class MathGenericBuilderAdapter extends GenericIdentityBuilder {
    private IMathBuilder specificBuilder;

    public MathGenericBuilderAdapter(IMathBuilder specificBuilder) {
        this.specificBuilder = specificBuilder;
    }

    public MathGenericBuilderAdapter(IMathBuilder specificBuilder, IEntityContext entityContext) {
        this(specificBuilder);
        wSetEntityContext(entityContext);
    }

    public void visit() {
    }

    public void wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Addition_ord :
            specificBuilder.Addition();
            break;
            case MathEntityDescriptorEnum.Subtraction_ord :
            specificBuilder.Subtraction();
            break;
            case MathEntityDescriptorEnum.Multiplication_ord :
            specificBuilder.Multiplication();
            break;
            case MathEntityDescriptorEnum.Division_ord :
            specificBuilder.Division();
            break;
            case MathEntityDescriptorEnum.Quotient_ord :
            specificBuilder.Quotient();
            break;
            case MathEntityDescriptorEnum.Remainder_ord :
            specificBuilder.Remainder();
            break;
            case MathEntityDescriptorEnum.Exponentiation_ord :
            specificBuilder.Exponentiation();
            break;
            case MathEntityDescriptorEnum.Root_ord :
            specificBuilder.Root();
            break;
            case MathEntityDescriptorEnum.Minus_ord :
            specificBuilder.Minus();
            break;
            case MathEntityDescriptorEnum.AbsoluteValue_ord :
            specificBuilder.AbsoluteValue();
            break;
            case MathEntityDescriptorEnum.Floor_ord :
            specificBuilder.Floor();
            break;
            case MathEntityDescriptorEnum.Ceiling_ord :
            specificBuilder.Ceiling();
            break;
            case MathEntityDescriptorEnum.Factorial_ord :
            specificBuilder.Factorial();
            break;
            case MathEntityDescriptorEnum.GreatestCommonDivisor_ord :
            specificBuilder.GreatestCommonDivisor();
            break;
            case MathEntityDescriptorEnum.LowestCommonMultiple_ord :
            specificBuilder.LowestCommonMultiple();
            break;
            case MathEntityDescriptorEnum.Maximum_ord :
            specificBuilder.Maximum();
            break;
            case MathEntityDescriptorEnum.Minimum_ord :
            specificBuilder.Minimum();
            break;
            case MathEntityDescriptorEnum.And_ord :
            specificBuilder.And();
            break;
            case MathEntityDescriptorEnum.Or_ord :
            specificBuilder.Or();
            break;
            case MathEntityDescriptorEnum.ExclusiveOr_ord :
            specificBuilder.ExclusiveOr();
            break;
            case MathEntityDescriptorEnum.Not_ord :
            specificBuilder.Not();
            break;
            case MathEntityDescriptorEnum.Implies_ord :
            specificBuilder.Implies();
            break;
            case MathEntityDescriptorEnum.BitwiseAnd_ord :
            specificBuilder.BitwiseAnd();
            break;
            case MathEntityDescriptorEnum.BitwiseOr_ord :
            specificBuilder.BitwiseOr();
            break;
            case MathEntityDescriptorEnum.BitwiseExclusiveOr_ord :
            specificBuilder.BitwiseExclusiveOr();
            break;
            case MathEntityDescriptorEnum.BitwiseNot_ord :
            specificBuilder.BitwiseNot();
            break;
            case MathEntityDescriptorEnum.ShiftLeft_ord :
            specificBuilder.ShiftLeft();
            break;
            case MathEntityDescriptorEnum.ShiftRight_ord :
            specificBuilder.ShiftRight();
            break;
            case MathEntityDescriptorEnum.ArithmeticShiftRight_ord :
            specificBuilder.ArithmeticShiftRight();
            break;
            case MathEntityDescriptorEnum.Equals_ord :
            specificBuilder.Equals();
            break;
            case MathEntityDescriptorEnum.NotEquals_ord :
            specificBuilder.NotEquals();
            break;
            case MathEntityDescriptorEnum.ApproximatelyEqual_ord :
            specificBuilder.ApproximatelyEqual();
            break;
            case MathEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder.GreaterThan();
            break;
            case MathEntityDescriptorEnum.LessThan_ord :
            specificBuilder.LessThan();
            break;
            case MathEntityDescriptorEnum.GreaterOrEqual_ord :
            specificBuilder.GreaterOrEqual();
            break;
            case MathEntityDescriptorEnum.LessOrEqual_ord :
            specificBuilder.LessOrEqual();
            break;
            case MathEntityDescriptorEnum.FactorOf_ord :
            specificBuilder.FactorOf();
            break;
            case MathEntityDescriptorEnum.Exponential_ord :
            specificBuilder.Exponential();
            break;
            case MathEntityDescriptorEnum.NaturalLogarithm_ord :
            specificBuilder.NaturalLogarithm();
            break;
            case MathEntityDescriptorEnum.Logarithm_ord :
            specificBuilder.Logarithm();
            break;
            case MathEntityDescriptorEnum.Sine_ord :
            specificBuilder.Sine();
            break;
            case MathEntityDescriptorEnum.Cosine_ord :
            specificBuilder.Cosine();
            break;
            case MathEntityDescriptorEnum.Tangent_ord :
            specificBuilder.Tangent();
            break;
            case MathEntityDescriptorEnum.Cosecant_ord :
            specificBuilder.Cosecant();
            break;
            case MathEntityDescriptorEnum.Secant_ord :
            specificBuilder.Secant();
            break;
            case MathEntityDescriptorEnum.Cotangent_ord :
            specificBuilder.Cotangent();
            break;
            case MathEntityDescriptorEnum.Arcsine_ord :
            specificBuilder.Arcsine();
            break;
            case MathEntityDescriptorEnum.Arccosine_ord :
            specificBuilder.Arccosine();
            break;
            case MathEntityDescriptorEnum.Arctangent_ord :
            specificBuilder.Arctangent();
            break;
            case MathEntityDescriptorEnum.Arccosecant_ord :
            specificBuilder.Arccosecant();
            break;
            case MathEntityDescriptorEnum.Arcsecant_ord :
            specificBuilder.Arcsecant();
            break;
            case MathEntityDescriptorEnum.Arccotangent_ord :
            specificBuilder.Arccotangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicSine_ord :
            specificBuilder.HyperbolicSine();
            break;
            case MathEntityDescriptorEnum.HyperbolicCosine_ord :
            specificBuilder.HyperbolicCosine();
            break;
            case MathEntityDescriptorEnum.HyperbolicTangent_ord :
            specificBuilder.HyperbolicTangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicCosecant_ord :
            specificBuilder.HyperbolicCosecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicSecant_ord :
            specificBuilder.HyperbolicSecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicCotangent_ord :
            specificBuilder.HyperbolicCotangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsine_ord :
            specificBuilder.HyperbolicArcsine();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosine_ord :
            specificBuilder.HyperbolicArccosine();
            break;
            case MathEntityDescriptorEnum.HyperbolicArctangent_ord :
            specificBuilder.HyperbolicArctangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosecant_ord :
            specificBuilder.HyperbolicArccosecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsecant_ord :
            specificBuilder.HyperbolicArcsecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccotangent_ord :
            specificBuilder.HyperbolicArccotangent();
            break;
            case MathEntityDescriptorEnum.Empty_ord :
            specificBuilder.Empty();
            break;
            case MathEntityDescriptorEnum.Set_ord :
            specificBuilder.Set();
            break;
            case MathEntityDescriptorEnum.OrderedPair_ord :
            specificBuilder.OrderedPair();
            break;
            case MathEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple();
            break;
            case MathEntityDescriptorEnum.List_ord :
            specificBuilder.List();
            break;
            case MathEntityDescriptorEnum.Stream_ord :
            specificBuilder.Stream();
            break;
            case MathEntityDescriptorEnum.Enumeration_ord :
            specificBuilder.Enumeration();
            break;
            case MathEntityDescriptorEnum.Builder_ord :
            specificBuilder.Builder();
            break;
            case MathEntityDescriptorEnum.Union_ord :
            specificBuilder.Union();
            break;
            case MathEntityDescriptorEnum.Intersection_ord :
            specificBuilder.Intersection();
            break;
            case MathEntityDescriptorEnum.Difference_ord :
            specificBuilder.Difference();
            break;
            case MathEntityDescriptorEnum.In_ord :
            specificBuilder.In();
            break;
            case MathEntityDescriptorEnum.NotIn_ord :
            specificBuilder.NotIn();
            break;
            case MathEntityDescriptorEnum.Subset_ord :
            specificBuilder.Subset();
            break;
            case MathEntityDescriptorEnum.ProperSubset_ord :
            specificBuilder.ProperSubset();
            break;
            case MathEntityDescriptorEnum.NotSubset_ord :
            specificBuilder.NotSubset();
            break;
            case MathEntityDescriptorEnum.NotProperSubset_ord :
            specificBuilder.NotProperSubset();
            break;
            case MathEntityDescriptorEnum.Cardinality_ord :
            specificBuilder.Cardinality();
            break;
            case MathEntityDescriptorEnum.Selector_ord :
            specificBuilder.Selector();
            break;
            case MathEntityDescriptorEnum.Rational_ord :
            specificBuilder.Rational();
            break;
            case MathEntityDescriptorEnum.NotANumber_ord :
            specificBuilder.NotANumber();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Addition_ord :
            specificBuilder.Addition_();
            break;
            case MathEntityDescriptorEnum.Subtraction_ord :
            specificBuilder.Subtraction_();
            break;
            case MathEntityDescriptorEnum.Multiplication_ord :
            specificBuilder.Multiplication_();
            break;
            case MathEntityDescriptorEnum.Division_ord :
            specificBuilder.Division_();
            break;
            case MathEntityDescriptorEnum.Quotient_ord :
            specificBuilder.Quotient_();
            break;
            case MathEntityDescriptorEnum.Remainder_ord :
            specificBuilder.Remainder_();
            break;
            case MathEntityDescriptorEnum.Exponentiation_ord :
            specificBuilder.Exponentiation_();
            break;
            case MathEntityDescriptorEnum.Root_ord :
            specificBuilder.Root_();
            break;
            case MathEntityDescriptorEnum.Minus_ord :
            specificBuilder.Minus_();
            break;
            case MathEntityDescriptorEnum.AbsoluteValue_ord :
            specificBuilder.AbsoluteValue_();
            break;
            case MathEntityDescriptorEnum.Floor_ord :
            specificBuilder.Floor_();
            break;
            case MathEntityDescriptorEnum.Ceiling_ord :
            specificBuilder.Ceiling_();
            break;
            case MathEntityDescriptorEnum.Factorial_ord :
            specificBuilder.Factorial_();
            break;
            case MathEntityDescriptorEnum.GreatestCommonDivisor_ord :
            specificBuilder.GreatestCommonDivisor_();
            break;
            case MathEntityDescriptorEnum.LowestCommonMultiple_ord :
            specificBuilder.LowestCommonMultiple_();
            break;
            case MathEntityDescriptorEnum.Maximum_ord :
            specificBuilder.Maximum_();
            break;
            case MathEntityDescriptorEnum.Minimum_ord :
            specificBuilder.Minimum_();
            break;
            case MathEntityDescriptorEnum.And_ord :
            specificBuilder.And_();
            break;
            case MathEntityDescriptorEnum.Or_ord :
            specificBuilder.Or_();
            break;
            case MathEntityDescriptorEnum.ExclusiveOr_ord :
            specificBuilder.ExclusiveOr_();
            break;
            case MathEntityDescriptorEnum.Not_ord :
            specificBuilder.Not_();
            break;
            case MathEntityDescriptorEnum.Implies_ord :
            specificBuilder.Implies_();
            break;
            case MathEntityDescriptorEnum.BitwiseAnd_ord :
            specificBuilder.BitwiseAnd_();
            break;
            case MathEntityDescriptorEnum.BitwiseOr_ord :
            specificBuilder.BitwiseOr_();
            break;
            case MathEntityDescriptorEnum.BitwiseExclusiveOr_ord :
            specificBuilder.BitwiseExclusiveOr_();
            break;
            case MathEntityDescriptorEnum.BitwiseNot_ord :
            specificBuilder.BitwiseNot_();
            break;
            case MathEntityDescriptorEnum.ShiftLeft_ord :
            specificBuilder.ShiftLeft_();
            break;
            case MathEntityDescriptorEnum.ShiftRight_ord :
            specificBuilder.ShiftRight_();
            break;
            case MathEntityDescriptorEnum.ArithmeticShiftRight_ord :
            specificBuilder.ArithmeticShiftRight_();
            break;
            case MathEntityDescriptorEnum.Equals_ord :
            specificBuilder.Equals_();
            break;
            case MathEntityDescriptorEnum.NotEquals_ord :
            specificBuilder.NotEquals_();
            break;
            case MathEntityDescriptorEnum.ApproximatelyEqual_ord :
            specificBuilder.ApproximatelyEqual_();
            break;
            case MathEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder.GreaterThan_();
            break;
            case MathEntityDescriptorEnum.LessThan_ord :
            specificBuilder.LessThan_();
            break;
            case MathEntityDescriptorEnum.GreaterOrEqual_ord :
            specificBuilder.GreaterOrEqual_();
            break;
            case MathEntityDescriptorEnum.LessOrEqual_ord :
            specificBuilder.LessOrEqual_();
            break;
            case MathEntityDescriptorEnum.FactorOf_ord :
            specificBuilder.FactorOf_();
            break;
            case MathEntityDescriptorEnum.Exponential_ord :
            specificBuilder.Exponential_();
            break;
            case MathEntityDescriptorEnum.NaturalLogarithm_ord :
            specificBuilder.NaturalLogarithm_();
            break;
            case MathEntityDescriptorEnum.Logarithm_ord :
            specificBuilder.Logarithm_();
            break;
            case MathEntityDescriptorEnum.Sine_ord :
            specificBuilder.Sine_();
            break;
            case MathEntityDescriptorEnum.Cosine_ord :
            specificBuilder.Cosine_();
            break;
            case MathEntityDescriptorEnum.Tangent_ord :
            specificBuilder.Tangent_();
            break;
            case MathEntityDescriptorEnum.Cosecant_ord :
            specificBuilder.Cosecant_();
            break;
            case MathEntityDescriptorEnum.Secant_ord :
            specificBuilder.Secant_();
            break;
            case MathEntityDescriptorEnum.Cotangent_ord :
            specificBuilder.Cotangent_();
            break;
            case MathEntityDescriptorEnum.Arcsine_ord :
            specificBuilder.Arcsine_();
            break;
            case MathEntityDescriptorEnum.Arccosine_ord :
            specificBuilder.Arccosine_();
            break;
            case MathEntityDescriptorEnum.Arctangent_ord :
            specificBuilder.Arctangent_();
            break;
            case MathEntityDescriptorEnum.Arccosecant_ord :
            specificBuilder.Arccosecant_();
            break;
            case MathEntityDescriptorEnum.Arcsecant_ord :
            specificBuilder.Arcsecant_();
            break;
            case MathEntityDescriptorEnum.Arccotangent_ord :
            specificBuilder.Arccotangent_();
            break;
            case MathEntityDescriptorEnum.HyperbolicSine_ord :
            specificBuilder.HyperbolicSine_();
            break;
            case MathEntityDescriptorEnum.HyperbolicCosine_ord :
            specificBuilder.HyperbolicCosine_();
            break;
            case MathEntityDescriptorEnum.HyperbolicTangent_ord :
            specificBuilder.HyperbolicTangent_();
            break;
            case MathEntityDescriptorEnum.HyperbolicCosecant_ord :
            specificBuilder.HyperbolicCosecant_();
            break;
            case MathEntityDescriptorEnum.HyperbolicSecant_ord :
            specificBuilder.HyperbolicSecant_();
            break;
            case MathEntityDescriptorEnum.HyperbolicCotangent_ord :
            specificBuilder.HyperbolicCotangent_();
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsine_ord :
            specificBuilder.HyperbolicArcsine_();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosine_ord :
            specificBuilder.HyperbolicArccosine_();
            break;
            case MathEntityDescriptorEnum.HyperbolicArctangent_ord :
            specificBuilder.HyperbolicArctangent_();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosecant_ord :
            specificBuilder.HyperbolicArccosecant_();
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsecant_ord :
            specificBuilder.HyperbolicArcsecant_();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccotangent_ord :
            specificBuilder.HyperbolicArccotangent_();
            break;
            case MathEntityDescriptorEnum.Empty_ord :
            specificBuilder.Empty_();
            break;
            case MathEntityDescriptorEnum.Set_ord :
            specificBuilder.Set_();
            break;
            case MathEntityDescriptorEnum.OrderedPair_ord :
            specificBuilder.OrderedPair_();
            break;
            case MathEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple_();
            break;
            case MathEntityDescriptorEnum.List_ord :
            specificBuilder.List_();
            break;
            case MathEntityDescriptorEnum.Stream_ord :
            specificBuilder.Stream_();
            break;
            case MathEntityDescriptorEnum.Enumeration_ord :
            specificBuilder.Enumeration_();
            break;
            case MathEntityDescriptorEnum.Builder_ord :
            specificBuilder.Builder_();
            break;
            case MathEntityDescriptorEnum.Union_ord :
            specificBuilder.Union_();
            break;
            case MathEntityDescriptorEnum.Intersection_ord :
            specificBuilder.Intersection_();
            break;
            case MathEntityDescriptorEnum.Difference_ord :
            specificBuilder.Difference_();
            break;
            case MathEntityDescriptorEnum.In_ord :
            specificBuilder.In_();
            break;
            case MathEntityDescriptorEnum.NotIn_ord :
            specificBuilder.NotIn_();
            break;
            case MathEntityDescriptorEnum.Subset_ord :
            specificBuilder.Subset_();
            break;
            case MathEntityDescriptorEnum.ProperSubset_ord :
            specificBuilder.ProperSubset_();
            break;
            case MathEntityDescriptorEnum.NotSubset_ord :
            specificBuilder.NotSubset_();
            break;
            case MathEntityDescriptorEnum.NotProperSubset_ord :
            specificBuilder.NotProperSubset_();
            break;
            case MathEntityDescriptorEnum.Cardinality_ord :
            specificBuilder.Cardinality_();
            break;
            case MathEntityDescriptorEnum.Selector_ord :
            specificBuilder.Selector_();
            break;
            case MathEntityDescriptorEnum.Rational_ord :
            specificBuilder.Rational_();
            break;
            case MathEntityDescriptorEnum.NotANumber_ord :
            specificBuilder.NotANumber_();
            break;
        }
    }

    public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Addition_ord :
            specificBuilder.Addition_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Multiplication_ord :
            specificBuilder.Multiplication_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.GreatestCommonDivisor_ord :
            specificBuilder.GreatestCommonDivisor_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.LowestCommonMultiple_ord :
            specificBuilder.LowestCommonMultiple_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Maximum_ord :
            specificBuilder.Maximum_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Minimum_ord :
            specificBuilder.Minimum_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.And_ord :
            specificBuilder.And_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Or_ord :
            specificBuilder.Or_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.ExclusiveOr_ord :
            specificBuilder.ExclusiveOr_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.BitwiseAnd_ord :
            specificBuilder.BitwiseAnd_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.BitwiseOr_ord :
            specificBuilder.BitwiseOr_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.BitwiseExclusiveOr_ord :
            specificBuilder.BitwiseExclusiveOr_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Equals_ord :
            specificBuilder.Equals_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder.GreaterThan_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.LessThan_ord :
            specificBuilder.LessThan_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.GreaterOrEqual_ord :
            specificBuilder.GreaterOrEqual_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.LessOrEqual_ord :
            specificBuilder.LessOrEqual_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Tuple_ord :
            specificBuilder.Tuple_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Enumeration_ord :
            specificBuilder.Enumeration_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Union_ord :
            specificBuilder.Union_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Intersection_ord :
            specificBuilder.Intersection_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.Subset_ord :
            specificBuilder.Subset_(initialCapacity);
            break;
            case MathEntityDescriptorEnum.ProperSubset_ord :
            specificBuilder.ProperSubset_(initialCapacity);
            break;
        }
    }

    public void _wEntity(EntityDescriptor<?> entityDesc) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Addition_ord :
            specificBuilder._Addition();
            break;
            case MathEntityDescriptorEnum.Subtraction_ord :
            specificBuilder._Subtraction();
            break;
            case MathEntityDescriptorEnum.Multiplication_ord :
            specificBuilder._Multiplication();
            break;
            case MathEntityDescriptorEnum.Division_ord :
            specificBuilder._Division();
            break;
            case MathEntityDescriptorEnum.Quotient_ord :
            specificBuilder._Quotient();
            break;
            case MathEntityDescriptorEnum.Remainder_ord :
            specificBuilder._Remainder();
            break;
            case MathEntityDescriptorEnum.Exponentiation_ord :
            specificBuilder._Exponentiation();
            break;
            case MathEntityDescriptorEnum.Root_ord :
            specificBuilder._Root();
            break;
            case MathEntityDescriptorEnum.Minus_ord :
            specificBuilder._Minus();
            break;
            case MathEntityDescriptorEnum.AbsoluteValue_ord :
            specificBuilder._AbsoluteValue();
            break;
            case MathEntityDescriptorEnum.Floor_ord :
            specificBuilder._Floor();
            break;
            case MathEntityDescriptorEnum.Ceiling_ord :
            specificBuilder._Ceiling();
            break;
            case MathEntityDescriptorEnum.Factorial_ord :
            specificBuilder._Factorial();
            break;
            case MathEntityDescriptorEnum.GreatestCommonDivisor_ord :
            specificBuilder._GreatestCommonDivisor();
            break;
            case MathEntityDescriptorEnum.LowestCommonMultiple_ord :
            specificBuilder._LowestCommonMultiple();
            break;
            case MathEntityDescriptorEnum.Maximum_ord :
            specificBuilder._Maximum();
            break;
            case MathEntityDescriptorEnum.Minimum_ord :
            specificBuilder._Minimum();
            break;
            case MathEntityDescriptorEnum.And_ord :
            specificBuilder._And();
            break;
            case MathEntityDescriptorEnum.Or_ord :
            specificBuilder._Or();
            break;
            case MathEntityDescriptorEnum.ExclusiveOr_ord :
            specificBuilder._ExclusiveOr();
            break;
            case MathEntityDescriptorEnum.Not_ord :
            specificBuilder._Not();
            break;
            case MathEntityDescriptorEnum.Implies_ord :
            specificBuilder._Implies();
            break;
            case MathEntityDescriptorEnum.BitwiseAnd_ord :
            specificBuilder._BitwiseAnd();
            break;
            case MathEntityDescriptorEnum.BitwiseOr_ord :
            specificBuilder._BitwiseOr();
            break;
            case MathEntityDescriptorEnum.BitwiseExclusiveOr_ord :
            specificBuilder._BitwiseExclusiveOr();
            break;
            case MathEntityDescriptorEnum.BitwiseNot_ord :
            specificBuilder._BitwiseNot();
            break;
            case MathEntityDescriptorEnum.ShiftLeft_ord :
            specificBuilder._ShiftLeft();
            break;
            case MathEntityDescriptorEnum.ShiftRight_ord :
            specificBuilder._ShiftRight();
            break;
            case MathEntityDescriptorEnum.ArithmeticShiftRight_ord :
            specificBuilder._ArithmeticShiftRight();
            break;
            case MathEntityDescriptorEnum.Equals_ord :
            specificBuilder._Equals();
            break;
            case MathEntityDescriptorEnum.NotEquals_ord :
            specificBuilder._NotEquals();
            break;
            case MathEntityDescriptorEnum.ApproximatelyEqual_ord :
            specificBuilder._ApproximatelyEqual();
            break;
            case MathEntityDescriptorEnum.GreaterThan_ord :
            specificBuilder._GreaterThan();
            break;
            case MathEntityDescriptorEnum.LessThan_ord :
            specificBuilder._LessThan();
            break;
            case MathEntityDescriptorEnum.GreaterOrEqual_ord :
            specificBuilder._GreaterOrEqual();
            break;
            case MathEntityDescriptorEnum.LessOrEqual_ord :
            specificBuilder._LessOrEqual();
            break;
            case MathEntityDescriptorEnum.FactorOf_ord :
            specificBuilder._FactorOf();
            break;
            case MathEntityDescriptorEnum.Exponential_ord :
            specificBuilder._Exponential();
            break;
            case MathEntityDescriptorEnum.NaturalLogarithm_ord :
            specificBuilder._NaturalLogarithm();
            break;
            case MathEntityDescriptorEnum.Logarithm_ord :
            specificBuilder._Logarithm();
            break;
            case MathEntityDescriptorEnum.Sine_ord :
            specificBuilder._Sine();
            break;
            case MathEntityDescriptorEnum.Cosine_ord :
            specificBuilder._Cosine();
            break;
            case MathEntityDescriptorEnum.Tangent_ord :
            specificBuilder._Tangent();
            break;
            case MathEntityDescriptorEnum.Cosecant_ord :
            specificBuilder._Cosecant();
            break;
            case MathEntityDescriptorEnum.Secant_ord :
            specificBuilder._Secant();
            break;
            case MathEntityDescriptorEnum.Cotangent_ord :
            specificBuilder._Cotangent();
            break;
            case MathEntityDescriptorEnum.Arcsine_ord :
            specificBuilder._Arcsine();
            break;
            case MathEntityDescriptorEnum.Arccosine_ord :
            specificBuilder._Arccosine();
            break;
            case MathEntityDescriptorEnum.Arctangent_ord :
            specificBuilder._Arctangent();
            break;
            case MathEntityDescriptorEnum.Arccosecant_ord :
            specificBuilder._Arccosecant();
            break;
            case MathEntityDescriptorEnum.Arcsecant_ord :
            specificBuilder._Arcsecant();
            break;
            case MathEntityDescriptorEnum.Arccotangent_ord :
            specificBuilder._Arccotangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicSine_ord :
            specificBuilder._HyperbolicSine();
            break;
            case MathEntityDescriptorEnum.HyperbolicCosine_ord :
            specificBuilder._HyperbolicCosine();
            break;
            case MathEntityDescriptorEnum.HyperbolicTangent_ord :
            specificBuilder._HyperbolicTangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicCosecant_ord :
            specificBuilder._HyperbolicCosecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicSecant_ord :
            specificBuilder._HyperbolicSecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicCotangent_ord :
            specificBuilder._HyperbolicCotangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsine_ord :
            specificBuilder._HyperbolicArcsine();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosine_ord :
            specificBuilder._HyperbolicArccosine();
            break;
            case MathEntityDescriptorEnum.HyperbolicArctangent_ord :
            specificBuilder._HyperbolicArctangent();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosecant_ord :
            specificBuilder._HyperbolicArccosecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsecant_ord :
            specificBuilder._HyperbolicArcsecant();
            break;
            case MathEntityDescriptorEnum.HyperbolicArccotangent_ord :
            specificBuilder._HyperbolicArccotangent();
            break;
            case MathEntityDescriptorEnum.Empty_ord :
            specificBuilder._Empty();
            break;
            case MathEntityDescriptorEnum.Set_ord :
            specificBuilder._Set();
            break;
            case MathEntityDescriptorEnum.OrderedPair_ord :
            specificBuilder._OrderedPair();
            break;
            case MathEntityDescriptorEnum.Tuple_ord :
            specificBuilder._Tuple();
            break;
            case MathEntityDescriptorEnum.List_ord :
            specificBuilder._List();
            break;
            case MathEntityDescriptorEnum.Stream_ord :
            specificBuilder._Stream();
            break;
            case MathEntityDescriptorEnum.Enumeration_ord :
            specificBuilder._Enumeration();
            break;
            case MathEntityDescriptorEnum.Builder_ord :
            specificBuilder._Builder();
            break;
            case MathEntityDescriptorEnum.Union_ord :
            specificBuilder._Union();
            break;
            case MathEntityDescriptorEnum.Intersection_ord :
            specificBuilder._Intersection();
            break;
            case MathEntityDescriptorEnum.Difference_ord :
            specificBuilder._Difference();
            break;
            case MathEntityDescriptorEnum.In_ord :
            specificBuilder._In();
            break;
            case MathEntityDescriptorEnum.NotIn_ord :
            specificBuilder._NotIn();
            break;
            case MathEntityDescriptorEnum.Subset_ord :
            specificBuilder._Subset();
            break;
            case MathEntityDescriptorEnum.ProperSubset_ord :
            specificBuilder._ProperSubset();
            break;
            case MathEntityDescriptorEnum.NotSubset_ord :
            specificBuilder._NotSubset();
            break;
            case MathEntityDescriptorEnum.NotProperSubset_ord :
            specificBuilder._NotProperSubset();
            break;
            case MathEntityDescriptorEnum.Cardinality_ord :
            specificBuilder._Cardinality();
            break;
            case MathEntityDescriptorEnum.Selector_ord :
            specificBuilder._Selector();
            break;
            case MathEntityDescriptorEnum.Rational_ord :
            specificBuilder._Rational();
            break;
            case MathEntityDescriptorEnum.NotANumber_ord :
            specificBuilder._NotANumber();
            break;
        }
    }

    public void wFeature(FeatureDescriptor featureDesc) {
        switch (featureDesc.getOrdinal()) {
            case MathFeatureDescriptorEnum.minuend_ord :
            specificBuilder.minuend();
            break;
            case MathFeatureDescriptorEnum.subtrahend_ord :
            specificBuilder.subtrahend();
            break;
            case MathFeatureDescriptorEnum.dividend_ord :
            specificBuilder.dividend();
            break;
            case MathFeatureDescriptorEnum.divisor_ord :
            specificBuilder.divisor();
            break;
            case MathFeatureDescriptorEnum.base_ord :
            specificBuilder.base();
            break;
            case MathFeatureDescriptorEnum.exponent_ord :
            specificBuilder.exponent();
            break;
            case MathFeatureDescriptorEnum.expression_ord :
            specificBuilder.expression();
            break;
            case MathFeatureDescriptorEnum.degree_ord :
            specificBuilder.degree();
            break;
            case MathFeatureDescriptorEnum.exp1_ord :
            specificBuilder.exp1();
            break;
            case MathFeatureDescriptorEnum.exp2_ord :
            specificBuilder.exp2();
            break;
            case MathFeatureDescriptorEnum.bits_ord :
            specificBuilder.bits();
            break;
            case MathFeatureDescriptorEnum.elements_ord :
            specificBuilder.elements();
            break;
            case MathFeatureDescriptorEnum.first_ord :
            specificBuilder.first();
            break;
            case MathFeatureDescriptorEnum.second_ord :
            specificBuilder.second();
            break;
            case MathFeatureDescriptorEnum.element_ord :
            specificBuilder.element();
            break;
            case MathFeatureDescriptorEnum.rule_ord :
            specificBuilder.rule();
            break;
            case MathFeatureDescriptorEnum.collection1_ord :
            specificBuilder.collection1();
            break;
            case MathFeatureDescriptorEnum.collection2_ord :
            specificBuilder.collection2();
            break;
            case MathFeatureDescriptorEnum.collection_ord :
            specificBuilder.collection();
            break;
            case MathFeatureDescriptorEnum.index_ord :
            specificBuilder.index();
            break;
            case MathFeatureDescriptorEnum.numerator_ord :
            specificBuilder.numerator();
            break;
            case MathFeatureDescriptorEnum.denominator_ord :
            specificBuilder.denominator();
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, String value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Identifier_ord :
            specificBuilder.Identifier(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Boolean_ord :
            specificBuilder.Boolean(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, byte value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.ByteInteger_ord :
            specificBuilder.ByteInteger(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, short value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.ShortInteger_ord :
            specificBuilder.ShortInteger(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, int value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Integer_ord :
            specificBuilder.Integer(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, long value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.LongInteger_ord :
            specificBuilder.LongInteger(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, BigInteger value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.BigInteger_ord :
            specificBuilder.BigInteger(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, float value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Float_ord :
            specificBuilder.Float(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, double value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Double_ord :
            specificBuilder.Double(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, BigDecimal value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.BigDecimal_ord :
            specificBuilder.BigDecimal(value);
            break;
        }
    }

    public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
        switch (entityDesc.getOrdinal()) {
            case MathEntityDescriptorEnum.Constant_ord :
            specificBuilder.Constant((Value) value);
            break;
        }
    }
}
