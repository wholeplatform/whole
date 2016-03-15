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

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class MathModelContext extends EntityContext {

    public MathModelContext(IEntity root) {
        super(root);
    }

    public MathModelContext getMinuend() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.minuend);
    }

    public void setMinuend(MathModelContext minuend) {
        wSet(MathFeatureDescriptorEnum.minuend, minuend);
    }

    public MathModelContext getSubtrahend() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.subtrahend);
    }

    public void setSubtrahend(MathModelContext subtrahend) {
        wSet(MathFeatureDescriptorEnum.subtrahend, subtrahend);
    }

    public MathModelContext getDividend() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.dividend);
    }

    public void setDividend(MathModelContext dividend) {
        wSet(MathFeatureDescriptorEnum.dividend, dividend);
    }

    public MathModelContext getDivisor() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.divisor);
    }

    public void setDivisor(MathModelContext divisor) {
        wSet(MathFeatureDescriptorEnum.divisor, divisor);
    }

    public MathModelContext getBase() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.base);
    }

    public void setBase(MathModelContext base) {
        wSet(MathFeatureDescriptorEnum.base, base);
    }

    public MathModelContext getExponent() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.exponent);
    }

    public void setExponent(MathModelContext exponent) {
        wSet(MathFeatureDescriptorEnum.exponent, exponent);
    }

    public MathModelContext getExpression() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.expression);
    }

    public void setExpression(MathModelContext expression) {
        wSet(MathFeatureDescriptorEnum.expression, expression);
    }

    public MathModelContext getDegree() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.degree);
    }

    public void setDegree(MathModelContext degree) {
        wSet(MathFeatureDescriptorEnum.degree, degree);
    }

    public MathModelContext getExp1() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.exp1);
    }

    public void setExp1(MathModelContext exp1) {
        wSet(MathFeatureDescriptorEnum.exp1, exp1);
    }

    public MathModelContext getExp2() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.exp2);
    }

    public void setExp2(MathModelContext exp2) {
        wSet(MathFeatureDescriptorEnum.exp2, exp2);
    }

    public MathModelContext getBits() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.bits);
    }

    public void setBits(MathModelContext bits) {
        wSet(MathFeatureDescriptorEnum.bits, bits);
    }

    public MathModelContext getElements() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.elements);
    }

    public void setElements(MathModelContext elements) {
        wSet(MathFeatureDescriptorEnum.elements, elements);
    }

    public MathModelContext getFirst() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.first);
    }

    public void setFirst(MathModelContext first) {
        wSet(MathFeatureDescriptorEnum.first, first);
    }

    public MathModelContext getSecond() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.second);
    }

    public void setSecond(MathModelContext second) {
        wSet(MathFeatureDescriptorEnum.second, second);
    }

    public MathModelContext getElement() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.element);
    }

    public void setElement(MathModelContext element) {
        wSet(MathFeatureDescriptorEnum.element, element);
    }

    public MathModelContext getRule() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.rule);
    }

    public void setRule(MathModelContext rule) {
        wSet(MathFeatureDescriptorEnum.rule, rule);
    }

    public MathModelContext getCollection1() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.collection1);
    }

    public void setCollection1(MathModelContext collection1) {
        wSet(MathFeatureDescriptorEnum.collection1, collection1);
    }

    public MathModelContext getCollection2() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.collection2);
    }

    public void setCollection2(MathModelContext collection2) {
        wSet(MathFeatureDescriptorEnum.collection2, collection2);
    }

    public MathModelContext getCollection() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.collection);
    }

    public void setCollection(MathModelContext collection) {
        wSet(MathFeatureDescriptorEnum.collection, collection);
    }

    public MathModelContext getIndex() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.index);
    }

    public void setIndex(MathModelContext index) {
        wSet(MathFeatureDescriptorEnum.index, index);
    }

    public MathModelContext getNumerator() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.numerator);
    }

    public void setNumerator(MathModelContext numerator) {
        wSet(MathFeatureDescriptorEnum.numerator, numerator);
    }

    public MathModelContext getDenominator() {
        return (MathModelContext) wGet(MathFeatureDescriptorEnum.denominator);
    }

    public void setDenominator(MathModelContext denominator) {
        wSet(MathFeatureDescriptorEnum.denominator, denominator);
    }
}
