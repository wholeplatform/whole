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
package org.whole.lang.math.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.model.*;
import org.whole.lang.math.model.Number;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
@SuppressWarnings("unchecked")
public class MathEntityDescriptorEnum extends EntityDescriptorEnum {
    public static final int Expression_ord = 0;
    public static final int ArithmeticExpression_ord = 1;
    public static final int Addition_ord = 2;
    public static final int Subtraction_ord = 3;
    public static final int Multiplication_ord = 4;
    public static final int Division_ord = 5;
    public static final int Quotient_ord = 6;
    public static final int Remainder_ord = 7;
    public static final int Exponentiation_ord = 8;
    public static final int Root_ord = 9;
    public static final int Minus_ord = 10;
    public static final int AbsoluteValue_ord = 11;
    public static final int Floor_ord = 12;
    public static final int Ceiling_ord = 13;
    public static final int Factorial_ord = 14;
    public static final int GreatestCommonDivisor_ord = 15;
    public static final int LowestCommonMultiple_ord = 16;
    public static final int Maximum_ord = 17;
    public static final int Minimum_ord = 18;
    public static final int LogicExpression_ord = 19;
    public static final int And_ord = 20;
    public static final int Or_ord = 21;
    public static final int ExclusiveOr_ord = 22;
    public static final int Not_ord = 23;
    public static final int Implies_ord = 24;
    public static final int BitwiseExpression_ord = 25;
    public static final int BitwiseAnd_ord = 26;
    public static final int BitwiseOr_ord = 27;
    public static final int BitwiseExclusiveOr_ord = 28;
    public static final int BitwiseNot_ord = 29;
    public static final int ShiftExpression_ord = 30;
    public static final int ShiftLeft_ord = 31;
    public static final int ShiftRight_ord = 32;
    public static final int ArithmeticShiftRight_ord = 33;
    public static final int RelationalExpression_ord = 34;
    public static final int Equals_ord = 35;
    public static final int NotEquals_ord = 36;
    public static final int ApproximatelyEqual_ord = 37;
    public static final int GreaterThan_ord = 38;
    public static final int LessThan_ord = 39;
    public static final int GreaterOrEqual_ord = 40;
    public static final int LessOrEqual_ord = 41;
    public static final int FactorOf_ord = 42;
    public static final int Exponential_ord = 43;
    public static final int NaturalLogarithm_ord = 44;
    public static final int Logarithm_ord = 45;
    public static final int TrigonometricExpression_ord = 46;
    public static final int Sine_ord = 47;
    public static final int Cosine_ord = 48;
    public static final int Tangent_ord = 49;
    public static final int Cosecant_ord = 50;
    public static final int Secant_ord = 51;
    public static final int Cotangent_ord = 52;
    public static final int Arcsine_ord = 53;
    public static final int Arccosine_ord = 54;
    public static final int Arctangent_ord = 55;
    public static final int Arccosecant_ord = 56;
    public static final int Arcsecant_ord = 57;
    public static final int Arccotangent_ord = 58;
    public static final int HyperbolicSine_ord = 59;
    public static final int HyperbolicCosine_ord = 60;
    public static final int HyperbolicTangent_ord = 61;
    public static final int HyperbolicCosecant_ord = 62;
    public static final int HyperbolicSecant_ord = 63;
    public static final int HyperbolicCotangent_ord = 64;
    public static final int HyperbolicArcsine_ord = 65;
    public static final int HyperbolicArccosine_ord = 66;
    public static final int HyperbolicArctangent_ord = 67;
    public static final int HyperbolicArccosecant_ord = 68;
    public static final int HyperbolicArcsecant_ord = 69;
    public static final int HyperbolicArccotangent_ord = 70;
    public static final int CollectionExpression_ord = 71;
    public static final int Collection_ord = 72;
    public static final int Empty_ord = 73;
    public static final int Set_ord = 74;
    public static final int Sequence_ord = 75;
    public static final int OrderedPair_ord = 76;
    public static final int Tuple_ord = 77;
    public static final int List_ord = 78;
    public static final int Stream_ord = 79;
    public static final int Constructor_ord = 80;
    public static final int Enumeration_ord = 81;
    public static final int Builder_ord = 82;
    public static final int Union_ord = 83;
    public static final int Intersection_ord = 84;
    public static final int Difference_ord = 85;
    public static final int In_ord = 86;
    public static final int NotIn_ord = 87;
    public static final int Subset_ord = 88;
    public static final int ProperSubset_ord = 89;
    public static final int NotSubset_ord = 90;
    public static final int NotProperSubset_ord = 91;
    public static final int Cardinality_ord = 92;
    public static final int Selector_ord = 93;
    public static final int Variable_ord = 94;
    public static final int Identifier_ord = 95;
    public static final int Number_ord = 96;
    public static final int Boolean_ord = 97;
    public static final int IntegerNumber_ord = 98;
    public static final int ByteInteger_ord = 99;
    public static final int ShortInteger_ord = 100;
    public static final int Integer_ord = 101;
    public static final int LongInteger_ord = 102;
    public static final int BigInteger_ord = 103;
    public static final int DecimalNumber_ord = 104;
    public static final int Float_ord = 105;
    public static final int Double_ord = 106;
    public static final int BigDecimal_ord = 107;
    public static final int Rational_ord = 108;
    public static final int Constant_ord = 109;
    public static final int NotANumber_ord = 110;
    public static final MathEntityDescriptorEnum instance = new MathEntityDescriptorEnum();
    public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance.valueOf(Expression_ord);
    public static final EntityDescriptor<ArithmeticExpression> ArithmeticExpression = (EntityDescriptor<ArithmeticExpression>) instance.valueOf(ArithmeticExpression_ord);
    public static final EntityDescriptor<Addition> Addition = (EntityDescriptor<Addition>) instance.valueOf(Addition_ord);
    public static final EntityDescriptor<Subtraction> Subtraction = (EntityDescriptor<Subtraction>) instance.valueOf(Subtraction_ord);
    public static final EntityDescriptor<Multiplication> Multiplication = (EntityDescriptor<Multiplication>) instance.valueOf(Multiplication_ord);
    public static final EntityDescriptor<Division> Division = (EntityDescriptor<Division>) instance.valueOf(Division_ord);
    public static final EntityDescriptor<Quotient> Quotient = (EntityDescriptor<Quotient>) instance.valueOf(Quotient_ord);
    public static final EntityDescriptor<Remainder> Remainder = (EntityDescriptor<Remainder>) instance.valueOf(Remainder_ord);
    public static final EntityDescriptor<Exponentiation> Exponentiation = (EntityDescriptor<Exponentiation>) instance.valueOf(Exponentiation_ord);
    public static final EntityDescriptor<Root> Root = (EntityDescriptor<Root>) instance.valueOf(Root_ord);
    public static final EntityDescriptor<Minus> Minus = (EntityDescriptor<Minus>) instance.valueOf(Minus_ord);
    public static final EntityDescriptor<AbsoluteValue> AbsoluteValue = (EntityDescriptor<AbsoluteValue>) instance.valueOf(AbsoluteValue_ord);
    public static final EntityDescriptor<Floor> Floor = (EntityDescriptor<Floor>) instance.valueOf(Floor_ord);
    public static final EntityDescriptor<Ceiling> Ceiling = (EntityDescriptor<Ceiling>) instance.valueOf(Ceiling_ord);
    public static final EntityDescriptor<Factorial> Factorial = (EntityDescriptor<Factorial>) instance.valueOf(Factorial_ord);
    public static final EntityDescriptor<GreatestCommonDivisor> GreatestCommonDivisor = (EntityDescriptor<GreatestCommonDivisor>) instance.valueOf(GreatestCommonDivisor_ord);
    public static final EntityDescriptor<LowestCommonMultiple> LowestCommonMultiple = (EntityDescriptor<LowestCommonMultiple>) instance.valueOf(LowestCommonMultiple_ord);
    public static final EntityDescriptor<Maximum> Maximum = (EntityDescriptor<Maximum>) instance.valueOf(Maximum_ord);
    public static final EntityDescriptor<Minimum> Minimum = (EntityDescriptor<Minimum>) instance.valueOf(Minimum_ord);
    public static final EntityDescriptor<LogicExpression> LogicExpression = (EntityDescriptor<LogicExpression>) instance.valueOf(LogicExpression_ord);
    public static final EntityDescriptor<And> And = (EntityDescriptor<And>) instance.valueOf(And_ord);
    public static final EntityDescriptor<Or> Or = (EntityDescriptor<Or>) instance.valueOf(Or_ord);
    public static final EntityDescriptor<ExclusiveOr> ExclusiveOr = (EntityDescriptor<ExclusiveOr>) instance.valueOf(ExclusiveOr_ord);
    public static final EntityDescriptor<Not> Not = (EntityDescriptor<Not>) instance.valueOf(Not_ord);
    public static final EntityDescriptor<Implies> Implies = (EntityDescriptor<Implies>) instance.valueOf(Implies_ord);
    public static final EntityDescriptor<BitwiseExpression> BitwiseExpression = (EntityDescriptor<BitwiseExpression>) instance.valueOf(BitwiseExpression_ord);
    public static final EntityDescriptor<BitwiseAnd> BitwiseAnd = (EntityDescriptor<BitwiseAnd>) instance.valueOf(BitwiseAnd_ord);
    public static final EntityDescriptor<BitwiseOr> BitwiseOr = (EntityDescriptor<BitwiseOr>) instance.valueOf(BitwiseOr_ord);
    public static final EntityDescriptor<BitwiseExclusiveOr> BitwiseExclusiveOr = (EntityDescriptor<BitwiseExclusiveOr>) instance.valueOf(BitwiseExclusiveOr_ord);
    public static final EntityDescriptor<BitwiseNot> BitwiseNot = (EntityDescriptor<BitwiseNot>) instance.valueOf(BitwiseNot_ord);
    public static final EntityDescriptor<ShiftExpression> ShiftExpression = (EntityDescriptor<ShiftExpression>) instance.valueOf(ShiftExpression_ord);
    public static final EntityDescriptor<ShiftLeft> ShiftLeft = (EntityDescriptor<ShiftLeft>) instance.valueOf(ShiftLeft_ord);
    public static final EntityDescriptor<ShiftRight> ShiftRight = (EntityDescriptor<ShiftRight>) instance.valueOf(ShiftRight_ord);
    public static final EntityDescriptor<ArithmeticShiftRight> ArithmeticShiftRight = (EntityDescriptor<ArithmeticShiftRight>) instance.valueOf(ArithmeticShiftRight_ord);
    public static final EntityDescriptor<RelationalExpression> RelationalExpression = (EntityDescriptor<RelationalExpression>) instance.valueOf(RelationalExpression_ord);
    public static final EntityDescriptor<Equals> Equals = (EntityDescriptor<Equals>) instance.valueOf(Equals_ord);
    public static final EntityDescriptor<NotEquals> NotEquals = (EntityDescriptor<NotEquals>) instance.valueOf(NotEquals_ord);
    public static final EntityDescriptor<ApproximatelyEqual> ApproximatelyEqual = (EntityDescriptor<ApproximatelyEqual>) instance.valueOf(ApproximatelyEqual_ord);
    public static final EntityDescriptor<GreaterThan> GreaterThan = (EntityDescriptor<GreaterThan>) instance.valueOf(GreaterThan_ord);
    public static final EntityDescriptor<LessThan> LessThan = (EntityDescriptor<LessThan>) instance.valueOf(LessThan_ord);
    public static final EntityDescriptor<GreaterOrEqual> GreaterOrEqual = (EntityDescriptor<GreaterOrEqual>) instance.valueOf(GreaterOrEqual_ord);
    public static final EntityDescriptor<LessOrEqual> LessOrEqual = (EntityDescriptor<LessOrEqual>) instance.valueOf(LessOrEqual_ord);
    public static final EntityDescriptor<FactorOf> FactorOf = (EntityDescriptor<FactorOf>) instance.valueOf(FactorOf_ord);
    public static final EntityDescriptor<Exponential> Exponential = (EntityDescriptor<Exponential>) instance.valueOf(Exponential_ord);
    public static final EntityDescriptor<NaturalLogarithm> NaturalLogarithm = (EntityDescriptor<NaturalLogarithm>) instance.valueOf(NaturalLogarithm_ord);
    public static final EntityDescriptor<Logarithm> Logarithm = (EntityDescriptor<Logarithm>) instance.valueOf(Logarithm_ord);
    public static final EntityDescriptor<TrigonometricExpression> TrigonometricExpression = (EntityDescriptor<TrigonometricExpression>) instance.valueOf(TrigonometricExpression_ord);
    public static final EntityDescriptor<Sine> Sine = (EntityDescriptor<Sine>) instance.valueOf(Sine_ord);
    public static final EntityDescriptor<Cosine> Cosine = (EntityDescriptor<Cosine>) instance.valueOf(Cosine_ord);
    public static final EntityDescriptor<Tangent> Tangent = (EntityDescriptor<Tangent>) instance.valueOf(Tangent_ord);
    public static final EntityDescriptor<Cosecant> Cosecant = (EntityDescriptor<Cosecant>) instance.valueOf(Cosecant_ord);
    public static final EntityDescriptor<Secant> Secant = (EntityDescriptor<Secant>) instance.valueOf(Secant_ord);
    public static final EntityDescriptor<Cotangent> Cotangent = (EntityDescriptor<Cotangent>) instance.valueOf(Cotangent_ord);
    public static final EntityDescriptor<Arcsine> Arcsine = (EntityDescriptor<Arcsine>) instance.valueOf(Arcsine_ord);
    public static final EntityDescriptor<Arccosine> Arccosine = (EntityDescriptor<Arccosine>) instance.valueOf(Arccosine_ord);
    public static final EntityDescriptor<Arctangent> Arctangent = (EntityDescriptor<Arctangent>) instance.valueOf(Arctangent_ord);
    public static final EntityDescriptor<Arccosecant> Arccosecant = (EntityDescriptor<Arccosecant>) instance.valueOf(Arccosecant_ord);
    public static final EntityDescriptor<Arcsecant> Arcsecant = (EntityDescriptor<Arcsecant>) instance.valueOf(Arcsecant_ord);
    public static final EntityDescriptor<Arccotangent> Arccotangent = (EntityDescriptor<Arccotangent>) instance.valueOf(Arccotangent_ord);
    public static final EntityDescriptor<HyperbolicSine> HyperbolicSine = (EntityDescriptor<HyperbolicSine>) instance.valueOf(HyperbolicSine_ord);
    public static final EntityDescriptor<HyperbolicCosine> HyperbolicCosine = (EntityDescriptor<HyperbolicCosine>) instance.valueOf(HyperbolicCosine_ord);
    public static final EntityDescriptor<HyperbolicTangent> HyperbolicTangent = (EntityDescriptor<HyperbolicTangent>) instance.valueOf(HyperbolicTangent_ord);
    public static final EntityDescriptor<HyperbolicCosecant> HyperbolicCosecant = (EntityDescriptor<HyperbolicCosecant>) instance.valueOf(HyperbolicCosecant_ord);
    public static final EntityDescriptor<HyperbolicSecant> HyperbolicSecant = (EntityDescriptor<HyperbolicSecant>) instance.valueOf(HyperbolicSecant_ord);
    public static final EntityDescriptor<HyperbolicCotangent> HyperbolicCotangent = (EntityDescriptor<HyperbolicCotangent>) instance.valueOf(HyperbolicCotangent_ord);
    public static final EntityDescriptor<HyperbolicArcsine> HyperbolicArcsine = (EntityDescriptor<HyperbolicArcsine>) instance.valueOf(HyperbolicArcsine_ord);
    public static final EntityDescriptor<HyperbolicArccosine> HyperbolicArccosine = (EntityDescriptor<HyperbolicArccosine>) instance.valueOf(HyperbolicArccosine_ord);
    public static final EntityDescriptor<HyperbolicArctangent> HyperbolicArctangent = (EntityDescriptor<HyperbolicArctangent>) instance.valueOf(HyperbolicArctangent_ord);
    public static final EntityDescriptor<HyperbolicArccosecant> HyperbolicArccosecant = (EntityDescriptor<HyperbolicArccosecant>) instance.valueOf(HyperbolicArccosecant_ord);
    public static final EntityDescriptor<HyperbolicArcsecant> HyperbolicArcsecant = (EntityDescriptor<HyperbolicArcsecant>) instance.valueOf(HyperbolicArcsecant_ord);
    public static final EntityDescriptor<HyperbolicArccotangent> HyperbolicArccotangent = (EntityDescriptor<HyperbolicArccotangent>) instance.valueOf(HyperbolicArccotangent_ord);
    public static final EntityDescriptor<CollectionExpression> CollectionExpression = (EntityDescriptor<CollectionExpression>) instance.valueOf(CollectionExpression_ord);
    public static final EntityDescriptor<Collection> Collection = (EntityDescriptor<Collection>) instance.valueOf(Collection_ord);
    public static final EntityDescriptor<Empty> Empty = (EntityDescriptor<Empty>) instance.valueOf(Empty_ord);
    public static final EntityDescriptor<Set> Set = (EntityDescriptor<Set>) instance.valueOf(Set_ord);
    public static final EntityDescriptor<Sequence> Sequence = (EntityDescriptor<Sequence>) instance.valueOf(Sequence_ord);
    public static final EntityDescriptor<OrderedPair> OrderedPair = (EntityDescriptor<OrderedPair>) instance.valueOf(OrderedPair_ord);
    public static final EntityDescriptor<Tuple> Tuple = (EntityDescriptor<Tuple>) instance.valueOf(Tuple_ord);
    public static final EntityDescriptor<List> List = (EntityDescriptor<List>) instance.valueOf(List_ord);
    public static final EntityDescriptor<Stream> Stream = (EntityDescriptor<Stream>) instance.valueOf(Stream_ord);
    public static final EntityDescriptor<Constructor> Constructor = (EntityDescriptor<Constructor>) instance.valueOf(Constructor_ord);
    public static final EntityDescriptor<Enumeration> Enumeration = (EntityDescriptor<Enumeration>) instance.valueOf(Enumeration_ord);
    public static final EntityDescriptor<Builder> Builder = (EntityDescriptor<Builder>) instance.valueOf(Builder_ord);
    public static final EntityDescriptor<Union> Union = (EntityDescriptor<Union>) instance.valueOf(Union_ord);
    public static final EntityDescriptor<Intersection> Intersection = (EntityDescriptor<Intersection>) instance.valueOf(Intersection_ord);
    public static final EntityDescriptor<Difference> Difference = (EntityDescriptor<Difference>) instance.valueOf(Difference_ord);
    public static final EntityDescriptor<In> In = (EntityDescriptor<In>) instance.valueOf(In_ord);
    public static final EntityDescriptor<NotIn> NotIn = (EntityDescriptor<NotIn>) instance.valueOf(NotIn_ord);
    public static final EntityDescriptor<Subset> Subset = (EntityDescriptor<Subset>) instance.valueOf(Subset_ord);
    public static final EntityDescriptor<ProperSubset> ProperSubset = (EntityDescriptor<ProperSubset>) instance.valueOf(ProperSubset_ord);
    public static final EntityDescriptor<NotSubset> NotSubset = (EntityDescriptor<NotSubset>) instance.valueOf(NotSubset_ord);
    public static final EntityDescriptor<NotProperSubset> NotProperSubset = (EntityDescriptor<NotProperSubset>) instance.valueOf(NotProperSubset_ord);
    public static final EntityDescriptor<Cardinality> Cardinality = (EntityDescriptor<Cardinality>) instance.valueOf(Cardinality_ord);
    public static final EntityDescriptor<Selector> Selector = (EntityDescriptor<Selector>) instance.valueOf(Selector_ord);
    public static final EntityDescriptor<Variable> Variable = (EntityDescriptor<Variable>) instance.valueOf(Variable_ord);
    public static final EntityDescriptor<Identifier> Identifier = (EntityDescriptor<Identifier>) instance.valueOf(Identifier_ord);
    public static final EntityDescriptor<Number> Number = (EntityDescriptor<Number>) instance.valueOf(Number_ord);
    public static final EntityDescriptor<Boolean> Boolean = (EntityDescriptor<Boolean>) instance.valueOf(Boolean_ord);
    public static final EntityDescriptor<IntegerNumber> IntegerNumber = (EntityDescriptor<IntegerNumber>) instance.valueOf(IntegerNumber_ord);
    public static final EntityDescriptor<ByteInteger> ByteInteger = (EntityDescriptor<ByteInteger>) instance.valueOf(ByteInteger_ord);
    public static final EntityDescriptor<ShortInteger> ShortInteger = (EntityDescriptor<ShortInteger>) instance.valueOf(ShortInteger_ord);
    public static final EntityDescriptor<Integer> Integer = (EntityDescriptor<Integer>) instance.valueOf(Integer_ord);
    public static final EntityDescriptor<LongInteger> LongInteger = (EntityDescriptor<LongInteger>) instance.valueOf(LongInteger_ord);
    public static final EntityDescriptor<BigInteger> BigInteger = (EntityDescriptor<BigInteger>) instance.valueOf(BigInteger_ord);
    public static final EntityDescriptor<DecimalNumber> DecimalNumber = (EntityDescriptor<DecimalNumber>) instance.valueOf(DecimalNumber_ord);
    public static final EntityDescriptor<Float> Float = (EntityDescriptor<Float>) instance.valueOf(Float_ord);
    public static final EntityDescriptor<Double> Double = (EntityDescriptor<Double>) instance.valueOf(Double_ord);
    public static final EntityDescriptor<BigDecimal> BigDecimal = (EntityDescriptor<BigDecimal>) instance.valueOf(BigDecimal_ord);
    public static final EntityDescriptor<Rational> Rational = (EntityDescriptor<Rational>) instance.valueOf(Rational_ord);
    public static final EntityDescriptor<Constant> Constant = (EntityDescriptor<Constant>) instance.valueOf(Constant_ord);
    public static final EntityDescriptor<NotANumber> NotANumber = (EntityDescriptor<NotANumber>) instance.valueOf(NotANumber_ord);

    private MathEntityDescriptorEnum() {
    }
    private static final long serialVersionUID = 1;

    protected void initEntityDescriptors() {
        putSimpleEntity(Expression_ord, "Expression", Expression.class, true, HyperbolicArctangent_ord, Arcsecant_ord, HyperbolicArcsecant_ord, Or_ord, Subset_ord, Rational_ord, Ceiling_ord, Exponential_ord, DecimalNumber_ord, NaturalLogarithm_ord, HyperbolicTangent_ord, GreaterThan_ord, BitwiseExclusiveOr_ord, Arcsine_ord, Boolean_ord, Selector_ord, RelationalExpression_ord, AbsoluteValue_ord, Root_ord, ShiftLeft_ord, LowestCommonMultiple_ord, Float_ord, HyperbolicSecant_ord, BitwiseExpression_ord, Minus_ord, Cosecant_ord, Intersection_ord, LessOrEqual_ord, GreatestCommonDivisor_ord, Minimum_ord, Set_ord, In_ord, NotIn_ord, Secant_ord, Union_ord, Remainder_ord, HyperbolicArcsine_ord, LogicExpression_ord, Division_ord, Arccosine_ord, GreaterOrEqual_ord, Tangent_ord, ArithmeticExpression_ord, ProperSubset_ord, HyperbolicCosine_ord, HyperbolicArccosecant_ord, HyperbolicCotangent_ord, Tuple_ord, ShiftRight_ord, Multiplication_ord, ByteInteger_ord, Sine_ord, Arccosecant_ord, Difference_ord, ShortInteger_ord, NotANumber_ord, Maximum_ord, LessThan_ord, Identifier_ord, Implies_ord, TrigonometricExpression_ord, Arctangent_ord, List_ord, Stream_ord, Cotangent_ord, Addition_ord, Cardinality_ord, NotSubset_ord, OrderedPair_ord, LongInteger_ord, ShiftExpression_ord, Sequence_ord, Double_ord, NotEquals_ord, Not_ord, BitwiseOr_ord, And_ord, BitwiseAnd_ord, Collection_ord, BigInteger_ord, HyperbolicCosecant_ord, BitwiseNot_ord, HyperbolicArccosine_ord, Cosine_ord, NotProperSubset_ord, Variable_ord, Constant_ord, HyperbolicSine_ord, Exponentiation_ord, ApproximatelyEqual_ord, Factorial_ord, Empty_ord, Number_ord, Logarithm_ord, CollectionExpression_ord, HyperbolicArccotangent_ord, ArithmeticShiftRight_ord, Floor_ord, Arccotangent_ord, BigDecimal_ord, Integer_ord, Equals_ord, FactorOf_ord, Subtraction_ord, IntegerNumber_ord, Quotient_ord, ExclusiveOr_ord);
        putSimpleEntity(ArithmeticExpression_ord, "ArithmeticExpression", ArithmeticExpression.class, true, Floor_ord, GreatestCommonDivisor_ord, Addition_ord, Multiplication_ord, AbsoluteValue_ord, Root_ord, Ceiling_ord, LowestCommonMultiple_ord, Exponentiation_ord, Remainder_ord, Factorial_ord, Subtraction_ord, Division_ord, Quotient_ord, Minus_ord);
        putCompositeEntity(
		Addition_ord, "Addition", Addition.class, false, Expression_ord, true, false);
        putSimpleEntity(Subtraction_ord, "Subtraction", Subtraction.class, false).withFeature(MathFeatureDescriptorEnum.minuend, Expression_ord).withFeature(MathFeatureDescriptorEnum.subtrahend, Expression_ord);
        putCompositeEntity(
		Multiplication_ord, "Multiplication", Multiplication.class, false, Expression_ord, true, false);
        putSimpleEntity(Division_ord, "Division", Division.class, false).withFeature(MathFeatureDescriptorEnum.dividend, Expression_ord).withFeature(MathFeatureDescriptorEnum.divisor, Expression_ord);
        putSimpleEntity(Quotient_ord, "Quotient", Quotient.class, false).withFeature(MathFeatureDescriptorEnum.dividend, Expression_ord).withFeature(MathFeatureDescriptorEnum.divisor, Expression_ord);
        putSimpleEntity(Remainder_ord, "Remainder", Remainder.class, false).withFeature(MathFeatureDescriptorEnum.dividend, Expression_ord).withFeature(MathFeatureDescriptorEnum.divisor, Expression_ord);
        putSimpleEntity(Exponentiation_ord, "Exponentiation", Exponentiation.class, false).withFeature(MathFeatureDescriptorEnum.base, Expression_ord).withFeature(MathFeatureDescriptorEnum.exponent, Expression_ord);
        putSimpleEntity(Root_ord, "Root", Root.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord).withFeature(MathFeatureDescriptorEnum.degree, Expression_ord, true, false, false, false, false);
        putSimpleEntity(Minus_ord, "Minus", Minus.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(AbsoluteValue_ord, "AbsoluteValue", AbsoluteValue.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Floor_ord, "Floor", Floor.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Ceiling_ord, "Ceiling", Ceiling.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Factorial_ord, "Factorial", Factorial.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putCompositeEntity(
		GreatestCommonDivisor_ord, "GreatestCommonDivisor", GreatestCommonDivisor.class, false, Expression_ord, true, false);
        putCompositeEntity(
		LowestCommonMultiple_ord, "LowestCommonMultiple", LowestCommonMultiple.class, false, Expression_ord, true, false);
        putCompositeEntity(
		Maximum_ord, "Maximum", Maximum.class, false, Expression_ord, true, false);
        putCompositeEntity(
		Minimum_ord, "Minimum", Minimum.class, false, Expression_ord, true, false);
        putSimpleEntity(LogicExpression_ord, "LogicExpression", LogicExpression.class, true, ProperSubset_ord, NotProperSubset_ord, Not_ord, Or_ord, Implies_ord, Subset_ord, In_ord, NotSubset_ord, And_ord, NotIn_ord, ExclusiveOr_ord);
        putCompositeEntity(
		And_ord, "And", And.class, false, Expression_ord, true, false);
        putCompositeEntity(
		Or_ord, "Or", Or.class, false, Expression_ord, true, false);
        putCompositeEntity(
		ExclusiveOr_ord, "ExclusiveOr", ExclusiveOr.class, false, Expression_ord, true, false);
        putSimpleEntity(Not_ord, "Not", Not.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Implies_ord, "Implies", Implies.class, false).withFeature(MathFeatureDescriptorEnum.exp1, Expression_ord).withFeature(MathFeatureDescriptorEnum.exp2, Expression_ord);
        putSimpleEntity(BitwiseExpression_ord, "BitwiseExpression", BitwiseExpression.class, true, ShiftRight_ord, ShiftLeft_ord, BitwiseOr_ord, BitwiseExclusiveOr_ord, BitwiseAnd_ord, ShiftExpression_ord, BitwiseNot_ord, ArithmeticShiftRight_ord);
        putCompositeEntity(
		BitwiseAnd_ord, "BitwiseAnd", BitwiseAnd.class, false, Expression_ord, true, false);
        putCompositeEntity(
		BitwiseOr_ord, "BitwiseOr", BitwiseOr.class, false, Expression_ord, true, false);
        putCompositeEntity(
		BitwiseExclusiveOr_ord, "BitwiseExclusiveOr", BitwiseExclusiveOr.class, false, Expression_ord, true, false);
        putSimpleEntity(BitwiseNot_ord, "BitwiseNot", BitwiseNot.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(ShiftExpression_ord, "ShiftExpression", ShiftExpression.class, true, ShiftRight_ord, ShiftLeft_ord, ArithmeticShiftRight_ord).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord).withFeature(MathFeatureDescriptorEnum.bits, Expression_ord);
        putSimpleEntity(ShiftLeft_ord, "ShiftLeft", ShiftLeft.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord).withFeature(MathFeatureDescriptorEnum.bits, Expression_ord);
        putSimpleEntity(ShiftRight_ord, "ShiftRight", ShiftRight.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord).withFeature(MathFeatureDescriptorEnum.bits, Expression_ord);
        putSimpleEntity(ArithmeticShiftRight_ord, "ArithmeticShiftRight", ArithmeticShiftRight.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord).withFeature(MathFeatureDescriptorEnum.bits, Expression_ord);
        putSimpleEntity(RelationalExpression_ord, "RelationalExpression", RelationalExpression.class, true, LessOrEqual_ord, Equals_ord, LessThan_ord, FactorOf_ord, GreaterThan_ord, GreaterOrEqual_ord, ApproximatelyEqual_ord, NotEquals_ord);
        putCompositeEntity(
		Equals_ord, "Equals", Equals.class, false, Expression_ord, true, false);
        putSimpleEntity(NotEquals_ord, "NotEquals", NotEquals.class, false).withFeature(MathFeatureDescriptorEnum.exp1, Expression_ord).withFeature(MathFeatureDescriptorEnum.exp2, Expression_ord);
        putSimpleEntity(ApproximatelyEqual_ord, "ApproximatelyEqual", ApproximatelyEqual.class, false).withFeature(MathFeatureDescriptorEnum.exp1, Expression_ord).withFeature(MathFeatureDescriptorEnum.exp2, Expression_ord);
        putCompositeEntity(
		GreaterThan_ord, "GreaterThan", GreaterThan.class, false, Expression_ord, true, false);
        putCompositeEntity(
		LessThan_ord, "LessThan", LessThan.class, false, Expression_ord, true, false);
        putCompositeEntity(
		GreaterOrEqual_ord, "GreaterOrEqual", GreaterOrEqual.class, false, Expression_ord, true, false);
        putCompositeEntity(
		LessOrEqual_ord, "LessOrEqual", LessOrEqual.class, false, Expression_ord, true, false);
        putSimpleEntity(FactorOf_ord, "FactorOf", FactorOf.class, false).withFeature(MathFeatureDescriptorEnum.exp1, Expression_ord).withFeature(MathFeatureDescriptorEnum.exp2, Expression_ord);
        putSimpleEntity(Exponential_ord, "Exponential", Exponential.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(NaturalLogarithm_ord, "NaturalLogarithm", NaturalLogarithm.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Logarithm_ord, "Logarithm", Logarithm.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord).withFeature(MathFeatureDescriptorEnum.base, Expression_ord);
        putSimpleEntity(TrigonometricExpression_ord, "TrigonometricExpression", TrigonometricExpression.class, true, HyperbolicArctangent_ord, Arcsecant_ord, HyperbolicArcsecant_ord, Secant_ord, HyperbolicSine_ord, Sine_ord, Tangent_ord, Arccosecant_ord, Arccotangent_ord, HyperbolicArcsine_ord, HyperbolicTangent_ord, Arcsine_ord, Arctangent_ord, HyperbolicCosine_ord, HyperbolicCosecant_ord, Cotangent_ord, Arccosine_ord, HyperbolicSecant_ord, HyperbolicArccosecant_ord, HyperbolicArccotangent_ord, HyperbolicCotangent_ord, HyperbolicArccosine_ord, Cosine_ord, Cosecant_ord).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Sine_ord, "Sine", Sine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Cosine_ord, "Cosine", Cosine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Tangent_ord, "Tangent", Tangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Cosecant_ord, "Cosecant", Cosecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Secant_ord, "Secant", Secant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Cotangent_ord, "Cotangent", Cotangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Arcsine_ord, "Arcsine", Arcsine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Arccosine_ord, "Arccosine", Arccosine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Arctangent_ord, "Arctangent", Arctangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Arccosecant_ord, "Arccosecant", Arccosecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Arcsecant_ord, "Arcsecant", Arcsecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(Arccotangent_ord, "Arccotangent", Arccotangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicSine_ord, "HyperbolicSine", HyperbolicSine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicCosine_ord, "HyperbolicCosine", HyperbolicCosine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicTangent_ord, "HyperbolicTangent", HyperbolicTangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicCosecant_ord, "HyperbolicCosecant", HyperbolicCosecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicSecant_ord, "HyperbolicSecant", HyperbolicSecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicCotangent_ord, "HyperbolicCotangent", HyperbolicCotangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicArcsine_ord, "HyperbolicArcsine", HyperbolicArcsine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicArccosine_ord, "HyperbolicArccosine", HyperbolicArccosine.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicArctangent_ord, "HyperbolicArctangent", HyperbolicArctangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicArccosecant_ord, "HyperbolicArccosecant", HyperbolicArccosecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicArcsecant_ord, "HyperbolicArcsecant", HyperbolicArcsecant.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(HyperbolicArccotangent_ord, "HyperbolicArccotangent", HyperbolicArccotangent.class, false).withFeature(MathFeatureDescriptorEnum.expression, Expression_ord);
        putSimpleEntity(CollectionExpression_ord, "CollectionExpression", CollectionExpression.class, true, Intersection_ord, Empty_ord, Set_ord, OrderedPair_ord, Collection_ord, List_ord, Stream_ord, Difference_ord, Sequence_ord, Union_ord, Tuple_ord);
        putSimpleEntity(Collection_ord, "Collection", Collection.class, true, Empty_ord, Set_ord, OrderedPair_ord, List_ord, Stream_ord, Sequence_ord, Tuple_ord);
        putSimpleEntity(Empty_ord, "Empty", Empty.class, false);
        putSimpleEntity(Set_ord, "Set", Set.class, false).withFeature(MathFeatureDescriptorEnum.elements, Constructor_ord);
        putSimpleEntity(Sequence_ord, "Sequence", Sequence.class, true, List_ord, Stream_ord, Tuple_ord, OrderedPair_ord);
        putSimpleEntity(OrderedPair_ord, "OrderedPair", OrderedPair.class, false).withFeature(MathFeatureDescriptorEnum.first, Expression_ord).withFeature(MathFeatureDescriptorEnum.second, Expression_ord);
        putCompositeEntity(
		Tuple_ord, "Tuple", Tuple.class, false, Expression_ord, true, false);
        putSimpleEntity(List_ord, "List", List.class, false).withFeature(MathFeatureDescriptorEnum.elements, Constructor_ord);
        putSimpleEntity(Stream_ord, "Stream", Stream.class, false).withFeature(MathFeatureDescriptorEnum.elements, Constructor_ord);
        putSimpleEntity(Constructor_ord, "Constructor", Constructor.class, true, Enumeration_ord, Builder_ord);
        putCompositeEntity(
		Enumeration_ord, "Enumeration", Enumeration.class, false, Expression_ord, true, false);
        putSimpleEntity(Builder_ord, "Builder", Builder.class, false).withFeature(MathFeatureDescriptorEnum.element, Expression_ord).withFeature(MathFeatureDescriptorEnum.rule, Expression_ord);
        putCompositeEntity(
		Union_ord, "Union", Union.class, false, CollectionExpression_ord, true, false);
        putCompositeEntity(
		Intersection_ord, "Intersection", Intersection.class, false, CollectionExpression_ord, true, false);
        putSimpleEntity(Difference_ord, "Difference", Difference.class, false).withFeature(MathFeatureDescriptorEnum.collection1, CollectionExpression_ord).withFeature(MathFeatureDescriptorEnum.collection2, CollectionExpression_ord);
        putSimpleEntity(In_ord, "In", In.class, false).withFeature(MathFeatureDescriptorEnum.element, Expression_ord).withFeature(MathFeatureDescriptorEnum.collection, CollectionExpression_ord);
        putSimpleEntity(NotIn_ord, "NotIn", NotIn.class, false).withFeature(MathFeatureDescriptorEnum.element, Expression_ord).withFeature(MathFeatureDescriptorEnum.collection, CollectionExpression_ord);
        putCompositeEntity(
		Subset_ord, "Subset", Subset.class, false, CollectionExpression_ord, true, false);
        putCompositeEntity(
		ProperSubset_ord, "ProperSubset", ProperSubset.class, false, CollectionExpression_ord, true, false);
        putSimpleEntity(NotSubset_ord, "NotSubset", NotSubset.class, false).withFeature(MathFeatureDescriptorEnum.collection1, CollectionExpression_ord).withFeature(MathFeatureDescriptorEnum.collection2, CollectionExpression_ord);
        putSimpleEntity(NotProperSubset_ord, "NotProperSubset", NotProperSubset.class, false).withFeature(MathFeatureDescriptorEnum.collection1, CollectionExpression_ord).withFeature(MathFeatureDescriptorEnum.collection2, CollectionExpression_ord);
        putSimpleEntity(Cardinality_ord, "Cardinality", Cardinality.class, false).withFeature(MathFeatureDescriptorEnum.collection, CollectionExpression_ord);
        putSimpleEntity(Selector_ord, "Selector", Selector.class, false).withFeature(MathFeatureDescriptorEnum.index, Expression_ord).withFeature(MathFeatureDescriptorEnum.collection, CollectionExpression_ord);
        putSimpleEntity(Variable_ord, "Variable", Variable.class, true, Identifier_ord);
        putDataEntity(Identifier_ord, "Identifier", Identifier.class, false, String.class);
        putSimpleEntity(Number_ord, "Number", Number.class, true, Rational_ord, ByteInteger_ord, Constant_ord, LongInteger_ord, ShortInteger_ord, Double_ord, BigDecimal_ord, NotANumber_ord, Integer_ord, Float_ord, DecimalNumber_ord, IntegerNumber_ord, BigInteger_ord, Boolean_ord);
        putDataEntity(Boolean_ord, "Boolean", Boolean.class, false, boolean.class);
        putSimpleEntity(IntegerNumber_ord, "IntegerNumber", IntegerNumber.class, true, Integer_ord, LongInteger_ord, BigInteger_ord, ShortInteger_ord, ByteInteger_ord);
        putDataEntity(ByteInteger_ord, "ByteInteger", ByteInteger.class, false, byte.class);
        putDataEntity(ShortInteger_ord, "ShortInteger", ShortInteger.class, false, short.class);
        putDataEntity(Integer_ord, "Integer", Integer.class, false, int.class);
        putDataEntity(LongInteger_ord, "LongInteger", LongInteger.class, false, long.class);
        putDataEntity(BigInteger_ord, "BigInteger", BigInteger.class, false, java.math.BigInteger.class);
        putSimpleEntity(DecimalNumber_ord, "DecimalNumber", DecimalNumber.class, true, Float_ord, Double_ord, BigDecimal_ord);
        putDataEntity(Float_ord, "Float", Float.class, false, float.class);
        putDataEntity(Double_ord, "Double", Double.class, false, double.class);
        putDataEntity(BigDecimal_ord, "BigDecimal", BigDecimal.class, false, java.math.BigDecimal.class);
        putSimpleEntity(Rational_ord, "Rational", Rational.class, false).withFeature(MathFeatureDescriptorEnum.numerator, IntegerNumber_ord).withFeature(MathFeatureDescriptorEnum.denominator, IntegerNumber_ord);
        putDataEntity(Constant_ord, "Constant", Constant.class, false, ConstantEnum.Value.class);
        putSimpleEntity(NotANumber_ord, "NotANumber", NotANumber.class, false);
    }
}
