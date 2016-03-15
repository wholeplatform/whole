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
package org.whole.lang.math.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class MathImplEntityRegistry extends AbstractEntityRegistry {

    public MathImplEntityRegistry() {
        super(MathEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new AdditionImpl());
        put(new SubtractionImpl());
        put(new MultiplicationImpl());
        put(new DivisionImpl());
        put(new QuotientImpl());
        put(new RemainderImpl());
        put(new ExponentiationImpl());
        put(new RootImpl());
        put(new MinusImpl());
        put(new AbsoluteValueImpl());
        put(new FloorImpl());
        put(new CeilingImpl());
        put(new FactorialImpl());
        put(new GreatestCommonDivisorImpl());
        put(new LowestCommonMultipleImpl());
        put(new MaximumImpl());
        put(new MinimumImpl());
        put(new AndImpl());
        put(new OrImpl());
        put(new ExclusiveOrImpl());
        put(new NotImpl());
        put(new ImpliesImpl());
        put(new BitwiseAndImpl());
        put(new BitwiseOrImpl());
        put(new BitwiseExclusiveOrImpl());
        put(new BitwiseNotImpl());
        put(new ShiftLeftImpl());
        put(new ShiftRightImpl());
        put(new ArithmeticShiftRightImpl());
        put(new EqualsImpl());
        put(new NotEqualsImpl());
        put(new ApproximatelyEqualImpl());
        put(new GreaterThanImpl());
        put(new LessThanImpl());
        put(new GreaterOrEqualImpl());
        put(new LessOrEqualImpl());
        put(new FactorOfImpl());
        put(new ExponentialImpl());
        put(new NaturalLogarithmImpl());
        put(new LogarithmImpl());
        put(new SineImpl());
        put(new CosineImpl());
        put(new TangentImpl());
        put(new CosecantImpl());
        put(new SecantImpl());
        put(new CotangentImpl());
        put(new ArcsineImpl());
        put(new ArccosineImpl());
        put(new ArctangentImpl());
        put(new ArccosecantImpl());
        put(new ArcsecantImpl());
        put(new ArccotangentImpl());
        put(new HyperbolicSineImpl());
        put(new HyperbolicCosineImpl());
        put(new HyperbolicTangentImpl());
        put(new HyperbolicCosecantImpl());
        put(new HyperbolicSecantImpl());
        put(new HyperbolicCotangentImpl());
        put(new HyperbolicArcsineImpl());
        put(new HyperbolicArccosineImpl());
        put(new HyperbolicArctangentImpl());
        put(new HyperbolicArccosecantImpl());
        put(new HyperbolicArcsecantImpl());
        put(new HyperbolicArccotangentImpl());
        put(new EmptyImpl());
        put(new SetImpl());
        put(new OrderedPairImpl());
        put(new TupleImpl());
        put(new ListImpl());
        put(new StreamImpl());
        put(new EnumerationImpl());
        put(new BuilderImpl());
        put(new UnionImpl());
        put(new IntersectionImpl());
        put(new DifferenceImpl());
        put(new InImpl());
        put(new NotInImpl());
        put(new SubsetImpl());
        put(new ProperSubsetImpl());
        put(new NotSubsetImpl());
        put(new NotProperSubsetImpl());
        put(new CardinalityImpl());
        put(new SelectorImpl());
        put(new IdentifierImpl());
        put(new BooleanImpl());
        put(new ByteIntegerImpl());
        put(new ShortIntegerImpl());
        put(new IntegerImpl());
        put(new LongIntegerImpl());
        put(new BigIntegerImpl());
        put(new FloatImpl());
        put(new DoubleImpl());
        put(new BigDecimalImpl());
        put(new RationalImpl());
        put(new ConstantImpl());
        put(new NotANumberImpl());
    }
}
