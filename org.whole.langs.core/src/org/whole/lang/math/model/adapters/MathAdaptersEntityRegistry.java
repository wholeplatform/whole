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
package org.whole.lang.math.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class MathAdaptersEntityRegistry extends AbstractEntityRegistry {

    public MathAdaptersEntityRegistry() {
        super(MathEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new ExpressionAdapter());
        put(new ArithmeticExpressionAdapter());
        put(new AdditionAdapter());
        put(new SubtractionAdapter());
        put(new MultiplicationAdapter());
        put(new DivisionAdapter());
        put(new QuotientAdapter());
        put(new RemainderAdapter());
        put(new ExponentiationAdapter());
        put(new RootAdapter());
        put(new MinusAdapter());
        put(new AbsoluteValueAdapter());
        put(new FloorAdapter());
        put(new CeilingAdapter());
        put(new FactorialAdapter());
        put(new GreatestCommonDivisorAdapter());
        put(new LowestCommonMultipleAdapter());
        put(new MaximumAdapter());
        put(new MinimumAdapter());
        put(new LogicExpressionAdapter());
        put(new AndAdapter());
        put(new OrAdapter());
        put(new ExclusiveOrAdapter());
        put(new NotAdapter());
        put(new ImpliesAdapter());
        put(new BitwiseExpressionAdapter());
        put(new BitwiseAndAdapter());
        put(new BitwiseOrAdapter());
        put(new BitwiseExclusiveOrAdapter());
        put(new BitwiseNotAdapter());
        put(new ShiftExpressionAdapter());
        put(new ShiftLeftAdapter());
        put(new ShiftRightAdapter());
        put(new ArithmeticShiftRightAdapter());
        put(new RelationalExpressionAdapter());
        put(new EqualsAdapter());
        put(new NotEqualsAdapter());
        put(new ApproximatelyEqualAdapter());
        put(new GreaterThanAdapter());
        put(new LessThanAdapter());
        put(new GreaterOrEqualAdapter());
        put(new LessOrEqualAdapter());
        put(new FactorOfAdapter());
        put(new ExponentialAdapter());
        put(new NaturalLogarithmAdapter());
        put(new LogarithmAdapter());
        put(new TrigonometricExpressionAdapter());
        put(new SineAdapter());
        put(new CosineAdapter());
        put(new TangentAdapter());
        put(new CosecantAdapter());
        put(new SecantAdapter());
        put(new CotangentAdapter());
        put(new ArcsineAdapter());
        put(new ArccosineAdapter());
        put(new ArctangentAdapter());
        put(new ArccosecantAdapter());
        put(new ArcsecantAdapter());
        put(new ArccotangentAdapter());
        put(new HyperbolicSineAdapter());
        put(new HyperbolicCosineAdapter());
        put(new HyperbolicTangentAdapter());
        put(new HyperbolicCosecantAdapter());
        put(new HyperbolicSecantAdapter());
        put(new HyperbolicCotangentAdapter());
        put(new HyperbolicArcsineAdapter());
        put(new HyperbolicArccosineAdapter());
        put(new HyperbolicArctangentAdapter());
        put(new HyperbolicArccosecantAdapter());
        put(new HyperbolicArcsecantAdapter());
        put(new HyperbolicArccotangentAdapter());
        put(new CollectionExpressionAdapter());
        put(new CollectionAdapter());
        put(new EmptyAdapter());
        put(new SetAdapter());
        put(new SequenceAdapter());
        put(new OrderedPairAdapter());
        put(new TupleAdapter());
        put(new ListAdapter());
        put(new StreamAdapter());
        put(new ConstructorAdapter());
        put(new EnumerationAdapter());
        put(new BuilderAdapter());
        put(new UnionAdapter());
        put(new IntersectionAdapter());
        put(new DifferenceAdapter());
        put(new InAdapter());
        put(new NotInAdapter());
        put(new SubsetAdapter());
        put(new ProperSubsetAdapter());
        put(new NotSubsetAdapter());
        put(new NotProperSubsetAdapter());
        put(new CardinalityAdapter());
        put(new SelectorAdapter());
        put(new VariableAdapter());
        put(new IdentifierAdapter());
        put(new NumberAdapter());
        put(new BooleanAdapter());
        put(new IntegerNumberAdapter());
        put(new ByteIntegerAdapter());
        put(new ShortIntegerAdapter());
        put(new IntegerAdapter());
        put(new LongIntegerAdapter());
        put(new BigIntegerAdapter());
        put(new DecimalNumberAdapter());
        put(new FloatAdapter());
        put(new DoubleAdapter());
        put(new BigDecimalAdapter());
        put(new RationalAdapter());
        put(new ConstantAdapter());
        put(new NotANumberAdapter());
    }
}
