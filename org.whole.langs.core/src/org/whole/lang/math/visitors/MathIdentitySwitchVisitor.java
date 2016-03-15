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

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public abstract class MathIdentitySwitchVisitor extends AbstractVisitor implements IMathVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case MathEntityDescriptorEnum.Addition_ord :
            visit((Addition) entity);
            break;
            case MathEntityDescriptorEnum.Subtraction_ord :
            visit((Subtraction) entity);
            break;
            case MathEntityDescriptorEnum.Multiplication_ord :
            visit((Multiplication) entity);
            break;
            case MathEntityDescriptorEnum.Division_ord :
            visit((Division) entity);
            break;
            case MathEntityDescriptorEnum.Quotient_ord :
            visit((Quotient) entity);
            break;
            case MathEntityDescriptorEnum.Remainder_ord :
            visit((Remainder) entity);
            break;
            case MathEntityDescriptorEnum.Exponentiation_ord :
            visit((Exponentiation) entity);
            break;
            case MathEntityDescriptorEnum.Root_ord :
            visit((Root) entity);
            break;
            case MathEntityDescriptorEnum.Minus_ord :
            visit((Minus) entity);
            break;
            case MathEntityDescriptorEnum.AbsoluteValue_ord :
            visit((AbsoluteValue) entity);
            break;
            case MathEntityDescriptorEnum.Floor_ord :
            visit((Floor) entity);
            break;
            case MathEntityDescriptorEnum.Ceiling_ord :
            visit((Ceiling) entity);
            break;
            case MathEntityDescriptorEnum.Factorial_ord :
            visit((Factorial) entity);
            break;
            case MathEntityDescriptorEnum.GreatestCommonDivisor_ord :
            visit((GreatestCommonDivisor) entity);
            break;
            case MathEntityDescriptorEnum.LowestCommonMultiple_ord :
            visit((LowestCommonMultiple) entity);
            break;
            case MathEntityDescriptorEnum.Maximum_ord :
            visit((Maximum) entity);
            break;
            case MathEntityDescriptorEnum.Minimum_ord :
            visit((Minimum) entity);
            break;
            case MathEntityDescriptorEnum.And_ord :
            visit((And) entity);
            break;
            case MathEntityDescriptorEnum.Or_ord :
            visit((Or) entity);
            break;
            case MathEntityDescriptorEnum.ExclusiveOr_ord :
            visit((ExclusiveOr) entity);
            break;
            case MathEntityDescriptorEnum.Not_ord :
            visit((Not) entity);
            break;
            case MathEntityDescriptorEnum.Implies_ord :
            visit((Implies) entity);
            break;
            case MathEntityDescriptorEnum.BitwiseAnd_ord :
            visit((BitwiseAnd) entity);
            break;
            case MathEntityDescriptorEnum.BitwiseOr_ord :
            visit((BitwiseOr) entity);
            break;
            case MathEntityDescriptorEnum.BitwiseExclusiveOr_ord :
            visit((BitwiseExclusiveOr) entity);
            break;
            case MathEntityDescriptorEnum.BitwiseNot_ord :
            visit((BitwiseNot) entity);
            break;
            case MathEntityDescriptorEnum.ShiftLeft_ord :
            visit((ShiftLeft) entity);
            break;
            case MathEntityDescriptorEnum.ShiftRight_ord :
            visit((ShiftRight) entity);
            break;
            case MathEntityDescriptorEnum.ArithmeticShiftRight_ord :
            visit((ArithmeticShiftRight) entity);
            break;
            case MathEntityDescriptorEnum.Equals_ord :
            visit((Equals) entity);
            break;
            case MathEntityDescriptorEnum.NotEquals_ord :
            visit((NotEquals) entity);
            break;
            case MathEntityDescriptorEnum.ApproximatelyEqual_ord :
            visit((ApproximatelyEqual) entity);
            break;
            case MathEntityDescriptorEnum.GreaterThan_ord :
            visit((GreaterThan) entity);
            break;
            case MathEntityDescriptorEnum.LessThan_ord :
            visit((LessThan) entity);
            break;
            case MathEntityDescriptorEnum.GreaterOrEqual_ord :
            visit((GreaterOrEqual) entity);
            break;
            case MathEntityDescriptorEnum.LessOrEqual_ord :
            visit((LessOrEqual) entity);
            break;
            case MathEntityDescriptorEnum.FactorOf_ord :
            visit((FactorOf) entity);
            break;
            case MathEntityDescriptorEnum.Exponential_ord :
            visit((Exponential) entity);
            break;
            case MathEntityDescriptorEnum.NaturalLogarithm_ord :
            visit((NaturalLogarithm) entity);
            break;
            case MathEntityDescriptorEnum.Logarithm_ord :
            visit((Logarithm) entity);
            break;
            case MathEntityDescriptorEnum.Sine_ord :
            visit((Sine) entity);
            break;
            case MathEntityDescriptorEnum.Cosine_ord :
            visit((Cosine) entity);
            break;
            case MathEntityDescriptorEnum.Tangent_ord :
            visit((Tangent) entity);
            break;
            case MathEntityDescriptorEnum.Cosecant_ord :
            visit((Cosecant) entity);
            break;
            case MathEntityDescriptorEnum.Secant_ord :
            visit((Secant) entity);
            break;
            case MathEntityDescriptorEnum.Cotangent_ord :
            visit((Cotangent) entity);
            break;
            case MathEntityDescriptorEnum.Arcsine_ord :
            visit((Arcsine) entity);
            break;
            case MathEntityDescriptorEnum.Arccosine_ord :
            visit((Arccosine) entity);
            break;
            case MathEntityDescriptorEnum.Arctangent_ord :
            visit((Arctangent) entity);
            break;
            case MathEntityDescriptorEnum.Arccosecant_ord :
            visit((Arccosecant) entity);
            break;
            case MathEntityDescriptorEnum.Arcsecant_ord :
            visit((Arcsecant) entity);
            break;
            case MathEntityDescriptorEnum.Arccotangent_ord :
            visit((Arccotangent) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicSine_ord :
            visit((HyperbolicSine) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicCosine_ord :
            visit((HyperbolicCosine) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicTangent_ord :
            visit((HyperbolicTangent) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicCosecant_ord :
            visit((HyperbolicCosecant) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicSecant_ord :
            visit((HyperbolicSecant) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicCotangent_ord :
            visit((HyperbolicCotangent) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsine_ord :
            visit((HyperbolicArcsine) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosine_ord :
            visit((HyperbolicArccosine) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicArctangent_ord :
            visit((HyperbolicArctangent) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicArccosecant_ord :
            visit((HyperbolicArccosecant) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicArcsecant_ord :
            visit((HyperbolicArcsecant) entity);
            break;
            case MathEntityDescriptorEnum.HyperbolicArccotangent_ord :
            visit((HyperbolicArccotangent) entity);
            break;
            case MathEntityDescriptorEnum.Empty_ord :
            visit((Empty) entity);
            break;
            case MathEntityDescriptorEnum.Set_ord :
            visit((Set) entity);
            break;
            case MathEntityDescriptorEnum.OrderedPair_ord :
            visit((OrderedPair) entity);
            break;
            case MathEntityDescriptorEnum.Tuple_ord :
            visit((Tuple) entity);
            break;
            case MathEntityDescriptorEnum.List_ord :
            visit((List) entity);
            break;
            case MathEntityDescriptorEnum.Stream_ord :
            visit((Stream) entity);
            break;
            case MathEntityDescriptorEnum.Enumeration_ord :
            visit((Enumeration) entity);
            break;
            case MathEntityDescriptorEnum.Builder_ord :
            visit((Builder) entity);
            break;
            case MathEntityDescriptorEnum.Union_ord :
            visit((Union) entity);
            break;
            case MathEntityDescriptorEnum.Intersection_ord :
            visit((Intersection) entity);
            break;
            case MathEntityDescriptorEnum.Difference_ord :
            visit((Difference) entity);
            break;
            case MathEntityDescriptorEnum.In_ord :
            visit((In) entity);
            break;
            case MathEntityDescriptorEnum.NotIn_ord :
            visit((NotIn) entity);
            break;
            case MathEntityDescriptorEnum.Subset_ord :
            visit((Subset) entity);
            break;
            case MathEntityDescriptorEnum.ProperSubset_ord :
            visit((ProperSubset) entity);
            break;
            case MathEntityDescriptorEnum.NotSubset_ord :
            visit((NotSubset) entity);
            break;
            case MathEntityDescriptorEnum.NotProperSubset_ord :
            visit((NotProperSubset) entity);
            break;
            case MathEntityDescriptorEnum.Cardinality_ord :
            visit((Cardinality) entity);
            break;
            case MathEntityDescriptorEnum.Selector_ord :
            visit((Selector) entity);
            break;
            case MathEntityDescriptorEnum.Identifier_ord :
            visit((Identifier) entity);
            break;
            case MathEntityDescriptorEnum.Boolean_ord :
            visit((Boolean) entity);
            break;
            case MathEntityDescriptorEnum.ByteInteger_ord :
            visit((ByteInteger) entity);
            break;
            case MathEntityDescriptorEnum.ShortInteger_ord :
            visit((ShortInteger) entity);
            break;
            case MathEntityDescriptorEnum.Integer_ord :
            visit((Integer) entity);
            break;
            case MathEntityDescriptorEnum.LongInteger_ord :
            visit((LongInteger) entity);
            break;
            case MathEntityDescriptorEnum.BigInteger_ord :
            visit((BigInteger) entity);
            break;
            case MathEntityDescriptorEnum.Float_ord :
            visit((Float) entity);
            break;
            case MathEntityDescriptorEnum.Double_ord :
            visit((Double) entity);
            break;
            case MathEntityDescriptorEnum.BigDecimal_ord :
            visit((BigDecimal) entity);
            break;
            case MathEntityDescriptorEnum.Rational_ord :
            visit((Rational) entity);
            break;
            case MathEntityDescriptorEnum.Constant_ord :
            visit((Constant) entity);
            break;
            case MathEntityDescriptorEnum.NotANumber_ord :
            visit((NotANumber) entity);
            break;
        }
    }
}
