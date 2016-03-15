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
package org.whole.lang.math.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.math.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Double;

/**
 *  @generator Whole
 */
public class MathEntityFactory extends GenericEntityFactory {
    public static final MathEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static MathEntityFactory instance(IEntityRegistryProvider provider) {
        return new MathEntityFactory(provider);
    }

    protected MathEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public Addition createAddition() {
        return create(MathEntityDescriptorEnum.Addition);
    }

    public Addition createAddition(Expression... entities) {
        return create(MathEntityDescriptorEnum.Addition, (IEntity[]) entities);
    }

    public Addition createAddition(int initialSize) {
        return clone(MathEntityDescriptorEnum.Addition, initialSize);
    }

    public Subtraction createSubtraction() {
        return create(MathEntityDescriptorEnum.Subtraction);
    }

    public Subtraction createSubtraction(Expression minuend, Expression subtrahend) {
        return create(MathEntityDescriptorEnum.Subtraction, minuend, subtrahend);
    }

    public IEntityBuilder<Subtraction> buildSubtraction() {
        return new EntityBuilder<Subtraction>(create(MathEntityDescriptorEnum.Subtraction));
    }

    public Multiplication createMultiplication() {
        return create(MathEntityDescriptorEnum.Multiplication);
    }

    public Multiplication createMultiplication(Expression... entities) {
        return create(MathEntityDescriptorEnum.Multiplication, (IEntity[]) entities);
    }

    public Multiplication createMultiplication(int initialSize) {
        return clone(MathEntityDescriptorEnum.Multiplication, initialSize);
    }

    public Division createDivision() {
        return create(MathEntityDescriptorEnum.Division);
    }

    public Division createDivision(Expression dividend, Expression divisor) {
        return create(MathEntityDescriptorEnum.Division, dividend, divisor);
    }

    public IEntityBuilder<Division> buildDivision() {
        return new EntityBuilder<Division>(create(MathEntityDescriptorEnum.Division));
    }

    public Quotient createQuotient() {
        return create(MathEntityDescriptorEnum.Quotient);
    }

    public Quotient createQuotient(Expression dividend, Expression divisor) {
        return create(MathEntityDescriptorEnum.Quotient, dividend, divisor);
    }

    public IEntityBuilder<Quotient> buildQuotient() {
        return new EntityBuilder<Quotient>(create(MathEntityDescriptorEnum.Quotient));
    }

    public Remainder createRemainder() {
        return create(MathEntityDescriptorEnum.Remainder);
    }

    public Remainder createRemainder(Expression dividend, Expression divisor) {
        return create(MathEntityDescriptorEnum.Remainder, dividend, divisor);
    }

    public IEntityBuilder<Remainder> buildRemainder() {
        return new EntityBuilder<Remainder>(create(MathEntityDescriptorEnum.Remainder));
    }

    public Exponentiation createExponentiation() {
        return create(MathEntityDescriptorEnum.Exponentiation);
    }

    public Exponentiation createExponentiation(Expression base, Expression exponent) {
        return create(MathEntityDescriptorEnum.Exponentiation, base, exponent);
    }

    public IEntityBuilder<Exponentiation> buildExponentiation() {
        return new EntityBuilder<Exponentiation>(create(MathEntityDescriptorEnum.Exponentiation));
    }

    public Root createRoot() {
        return create(MathEntityDescriptorEnum.Root);
    }

    public Root createRoot(Expression expression, Expression degree) {
        return create(MathEntityDescriptorEnum.Root, expression, degree);
    }

    public IEntityBuilder<Root> buildRoot() {
        return new EntityBuilder<Root>(create(MathEntityDescriptorEnum.Root));
    }

    public Minus createMinus() {
        return create(MathEntityDescriptorEnum.Minus);
    }

    public Minus createMinus(Expression expression) {
        return create(MathEntityDescriptorEnum.Minus, expression);
    }

    public AbsoluteValue createAbsoluteValue() {
        return create(MathEntityDescriptorEnum.AbsoluteValue);
    }

    public AbsoluteValue createAbsoluteValue(Expression expression) {
        return create(MathEntityDescriptorEnum.AbsoluteValue, expression);
    }

    public Floor createFloor() {
        return create(MathEntityDescriptorEnum.Floor);
    }

    public Floor createFloor(Expression expression) {
        return create(MathEntityDescriptorEnum.Floor, expression);
    }

    public Ceiling createCeiling() {
        return create(MathEntityDescriptorEnum.Ceiling);
    }

    public Ceiling createCeiling(Expression expression) {
        return create(MathEntityDescriptorEnum.Ceiling, expression);
    }

    public Factorial createFactorial() {
        return create(MathEntityDescriptorEnum.Factorial);
    }

    public Factorial createFactorial(Expression expression) {
        return create(MathEntityDescriptorEnum.Factorial, expression);
    }

    public GreatestCommonDivisor createGreatestCommonDivisor() {
        return create(MathEntityDescriptorEnum.GreatestCommonDivisor);
    }

    public GreatestCommonDivisor createGreatestCommonDivisor(Expression... entities) {
        return create(MathEntityDescriptorEnum.GreatestCommonDivisor, (IEntity[]) entities);
    }

    public GreatestCommonDivisor createGreatestCommonDivisor(int initialSize) {
        return clone(MathEntityDescriptorEnum.GreatestCommonDivisor, initialSize);
    }

    public LowestCommonMultiple createLowestCommonMultiple() {
        return create(MathEntityDescriptorEnum.LowestCommonMultiple);
    }

    public LowestCommonMultiple createLowestCommonMultiple(Expression... entities) {
        return create(MathEntityDescriptorEnum.LowestCommonMultiple, (IEntity[]) entities);
    }

    public LowestCommonMultiple createLowestCommonMultiple(int initialSize) {
        return clone(MathEntityDescriptorEnum.LowestCommonMultiple, initialSize);
    }

    public Maximum createMaximum() {
        return create(MathEntityDescriptorEnum.Maximum);
    }

    public Maximum createMaximum(Expression... entities) {
        return create(MathEntityDescriptorEnum.Maximum, (IEntity[]) entities);
    }

    public Maximum createMaximum(int initialSize) {
        return clone(MathEntityDescriptorEnum.Maximum, initialSize);
    }

    public Minimum createMinimum() {
        return create(MathEntityDescriptorEnum.Minimum);
    }

    public Minimum createMinimum(Expression... entities) {
        return create(MathEntityDescriptorEnum.Minimum, (IEntity[]) entities);
    }

    public Minimum createMinimum(int initialSize) {
        return clone(MathEntityDescriptorEnum.Minimum, initialSize);
    }

    public And createAnd() {
        return create(MathEntityDescriptorEnum.And);
    }

    public And createAnd(Expression... entities) {
        return create(MathEntityDescriptorEnum.And, (IEntity[]) entities);
    }

    public And createAnd(int initialSize) {
        return clone(MathEntityDescriptorEnum.And, initialSize);
    }

    public Or createOr() {
        return create(MathEntityDescriptorEnum.Or);
    }

    public Or createOr(Expression... entities) {
        return create(MathEntityDescriptorEnum.Or, (IEntity[]) entities);
    }

    public Or createOr(int initialSize) {
        return clone(MathEntityDescriptorEnum.Or, initialSize);
    }

    public ExclusiveOr createExclusiveOr() {
        return create(MathEntityDescriptorEnum.ExclusiveOr);
    }

    public ExclusiveOr createExclusiveOr(Expression... entities) {
        return create(MathEntityDescriptorEnum.ExclusiveOr, (IEntity[]) entities);
    }

    public ExclusiveOr createExclusiveOr(int initialSize) {
        return clone(MathEntityDescriptorEnum.ExclusiveOr, initialSize);
    }

    public Not createNot() {
        return create(MathEntityDescriptorEnum.Not);
    }

    public Not createNot(Expression expression) {
        return create(MathEntityDescriptorEnum.Not, expression);
    }

    public Implies createImplies() {
        return create(MathEntityDescriptorEnum.Implies);
    }

    public Implies createImplies(Expression exp1, Expression exp2) {
        return create(MathEntityDescriptorEnum.Implies, exp1, exp2);
    }

    public IEntityBuilder<Implies> buildImplies() {
        return new EntityBuilder<Implies>(create(MathEntityDescriptorEnum.Implies));
    }

    public BitwiseAnd createBitwiseAnd() {
        return create(MathEntityDescriptorEnum.BitwiseAnd);
    }

    public BitwiseAnd createBitwiseAnd(Expression... entities) {
        return create(MathEntityDescriptorEnum.BitwiseAnd, (IEntity[]) entities);
    }

    public BitwiseAnd createBitwiseAnd(int initialSize) {
        return clone(MathEntityDescriptorEnum.BitwiseAnd, initialSize);
    }

    public BitwiseOr createBitwiseOr() {
        return create(MathEntityDescriptorEnum.BitwiseOr);
    }

    public BitwiseOr createBitwiseOr(Expression... entities) {
        return create(MathEntityDescriptorEnum.BitwiseOr, (IEntity[]) entities);
    }

    public BitwiseOr createBitwiseOr(int initialSize) {
        return clone(MathEntityDescriptorEnum.BitwiseOr, initialSize);
    }

    public BitwiseExclusiveOr createBitwiseExclusiveOr() {
        return create(MathEntityDescriptorEnum.BitwiseExclusiveOr);
    }

    public BitwiseExclusiveOr createBitwiseExclusiveOr(Expression... entities) {
        return create(MathEntityDescriptorEnum.BitwiseExclusiveOr, (IEntity[]) entities);
    }

    public BitwiseExclusiveOr createBitwiseExclusiveOr(int initialSize) {
        return clone(MathEntityDescriptorEnum.BitwiseExclusiveOr, initialSize);
    }

    public BitwiseNot createBitwiseNot() {
        return create(MathEntityDescriptorEnum.BitwiseNot);
    }

    public BitwiseNot createBitwiseNot(Expression expression) {
        return create(MathEntityDescriptorEnum.BitwiseNot, expression);
    }

    public ShiftLeft createShiftLeft() {
        return create(MathEntityDescriptorEnum.ShiftLeft);
    }

    public ShiftLeft createShiftLeft(Expression expression, Expression bits) {
        return create(MathEntityDescriptorEnum.ShiftLeft, expression, bits);
    }

    public IEntityBuilder<ShiftLeft> buildShiftLeft() {
        return new EntityBuilder<ShiftLeft>(create(MathEntityDescriptorEnum.ShiftLeft));
    }

    public ShiftRight createShiftRight() {
        return create(MathEntityDescriptorEnum.ShiftRight);
    }

    public ShiftRight createShiftRight(Expression expression, Expression bits) {
        return create(MathEntityDescriptorEnum.ShiftRight, expression, bits);
    }

    public IEntityBuilder<ShiftRight> buildShiftRight() {
        return new EntityBuilder<ShiftRight>(create(MathEntityDescriptorEnum.ShiftRight));
    }

    public ArithmeticShiftRight createArithmeticShiftRight() {
        return create(MathEntityDescriptorEnum.ArithmeticShiftRight);
    }

    public ArithmeticShiftRight createArithmeticShiftRight(Expression expression, Expression bits) {
        return create(MathEntityDescriptorEnum.ArithmeticShiftRight, expression, bits);
    }

    public IEntityBuilder<ArithmeticShiftRight> buildArithmeticShiftRight() {
        return new EntityBuilder<ArithmeticShiftRight>(create(MathEntityDescriptorEnum.ArithmeticShiftRight));
    }

    public Equals createEquals() {
        return create(MathEntityDescriptorEnum.Equals);
    }

    public Equals createEquals(Expression... entities) {
        return create(MathEntityDescriptorEnum.Equals, (IEntity[]) entities);
    }

    public Equals createEquals(int initialSize) {
        return clone(MathEntityDescriptorEnum.Equals, initialSize);
    }

    public NotEquals createNotEquals() {
        return create(MathEntityDescriptorEnum.NotEquals);
    }

    public NotEquals createNotEquals(Expression exp1, Expression exp2) {
        return create(MathEntityDescriptorEnum.NotEquals, exp1, exp2);
    }

    public IEntityBuilder<NotEquals> buildNotEquals() {
        return new EntityBuilder<NotEquals>(create(MathEntityDescriptorEnum.NotEquals));
    }

    public ApproximatelyEqual createApproximatelyEqual() {
        return create(MathEntityDescriptorEnum.ApproximatelyEqual);
    }

    public ApproximatelyEqual createApproximatelyEqual(Expression exp1, Expression exp2) {
        return create(MathEntityDescriptorEnum.ApproximatelyEqual, exp1, exp2);
    }

    public IEntityBuilder<ApproximatelyEqual> buildApproximatelyEqual() {
        return new EntityBuilder<ApproximatelyEqual>(create(MathEntityDescriptorEnum.ApproximatelyEqual));
    }

    public GreaterThan createGreaterThan() {
        return create(MathEntityDescriptorEnum.GreaterThan);
    }

    public GreaterThan createGreaterThan(Expression... entities) {
        return create(MathEntityDescriptorEnum.GreaterThan, (IEntity[]) entities);
    }

    public GreaterThan createGreaterThan(int initialSize) {
        return clone(MathEntityDescriptorEnum.GreaterThan, initialSize);
    }

    public LessThan createLessThan() {
        return create(MathEntityDescriptorEnum.LessThan);
    }

    public LessThan createLessThan(Expression... entities) {
        return create(MathEntityDescriptorEnum.LessThan, (IEntity[]) entities);
    }

    public LessThan createLessThan(int initialSize) {
        return clone(MathEntityDescriptorEnum.LessThan, initialSize);
    }

    public GreaterOrEqual createGreaterOrEqual() {
        return create(MathEntityDescriptorEnum.GreaterOrEqual);
    }

    public GreaterOrEqual createGreaterOrEqual(Expression... entities) {
        return create(MathEntityDescriptorEnum.GreaterOrEqual, (IEntity[]) entities);
    }

    public GreaterOrEqual createGreaterOrEqual(int initialSize) {
        return clone(MathEntityDescriptorEnum.GreaterOrEqual, initialSize);
    }

    public LessOrEqual createLessOrEqual() {
        return create(MathEntityDescriptorEnum.LessOrEqual);
    }

    public LessOrEqual createLessOrEqual(Expression... entities) {
        return create(MathEntityDescriptorEnum.LessOrEqual, (IEntity[]) entities);
    }

    public LessOrEqual createLessOrEqual(int initialSize) {
        return clone(MathEntityDescriptorEnum.LessOrEqual, initialSize);
    }

    public FactorOf createFactorOf() {
        return create(MathEntityDescriptorEnum.FactorOf);
    }

    public FactorOf createFactorOf(Expression exp1, Expression exp2) {
        return create(MathEntityDescriptorEnum.FactorOf, exp1, exp2);
    }

    public IEntityBuilder<FactorOf> buildFactorOf() {
        return new EntityBuilder<FactorOf>(create(MathEntityDescriptorEnum.FactorOf));
    }

    public Exponential createExponential() {
        return create(MathEntityDescriptorEnum.Exponential);
    }

    public Exponential createExponential(Expression expression) {
        return create(MathEntityDescriptorEnum.Exponential, expression);
    }

    public NaturalLogarithm createNaturalLogarithm() {
        return create(MathEntityDescriptorEnum.NaturalLogarithm);
    }

    public NaturalLogarithm createNaturalLogarithm(Expression expression) {
        return create(MathEntityDescriptorEnum.NaturalLogarithm, expression);
    }

    public Logarithm createLogarithm() {
        return create(MathEntityDescriptorEnum.Logarithm);
    }

    public Logarithm createLogarithm(Expression expression, Expression base) {
        return create(MathEntityDescriptorEnum.Logarithm, expression, base);
    }

    public IEntityBuilder<Logarithm> buildLogarithm() {
        return new EntityBuilder<Logarithm>(create(MathEntityDescriptorEnum.Logarithm));
    }

    public Sine createSine() {
        return create(MathEntityDescriptorEnum.Sine);
    }

    public Sine createSine(Expression expression) {
        return create(MathEntityDescriptorEnum.Sine, expression);
    }

    public Cosine createCosine() {
        return create(MathEntityDescriptorEnum.Cosine);
    }

    public Cosine createCosine(Expression expression) {
        return create(MathEntityDescriptorEnum.Cosine, expression);
    }

    public Tangent createTangent() {
        return create(MathEntityDescriptorEnum.Tangent);
    }

    public Tangent createTangent(Expression expression) {
        return create(MathEntityDescriptorEnum.Tangent, expression);
    }

    public Cosecant createCosecant() {
        return create(MathEntityDescriptorEnum.Cosecant);
    }

    public Cosecant createCosecant(Expression expression) {
        return create(MathEntityDescriptorEnum.Cosecant, expression);
    }

    public Secant createSecant() {
        return create(MathEntityDescriptorEnum.Secant);
    }

    public Secant createSecant(Expression expression) {
        return create(MathEntityDescriptorEnum.Secant, expression);
    }

    public Cotangent createCotangent() {
        return create(MathEntityDescriptorEnum.Cotangent);
    }

    public Cotangent createCotangent(Expression expression) {
        return create(MathEntityDescriptorEnum.Cotangent, expression);
    }

    public Arcsine createArcsine() {
        return create(MathEntityDescriptorEnum.Arcsine);
    }

    public Arcsine createArcsine(Expression expression) {
        return create(MathEntityDescriptorEnum.Arcsine, expression);
    }

    public Arccosine createArccosine() {
        return create(MathEntityDescriptorEnum.Arccosine);
    }

    public Arccosine createArccosine(Expression expression) {
        return create(MathEntityDescriptorEnum.Arccosine, expression);
    }

    public Arctangent createArctangent() {
        return create(MathEntityDescriptorEnum.Arctangent);
    }

    public Arctangent createArctangent(Expression expression) {
        return create(MathEntityDescriptorEnum.Arctangent, expression);
    }

    public Arccosecant createArccosecant() {
        return create(MathEntityDescriptorEnum.Arccosecant);
    }

    public Arccosecant createArccosecant(Expression expression) {
        return create(MathEntityDescriptorEnum.Arccosecant, expression);
    }

    public Arcsecant createArcsecant() {
        return create(MathEntityDescriptorEnum.Arcsecant);
    }

    public Arcsecant createArcsecant(Expression expression) {
        return create(MathEntityDescriptorEnum.Arcsecant, expression);
    }

    public Arccotangent createArccotangent() {
        return create(MathEntityDescriptorEnum.Arccotangent);
    }

    public Arccotangent createArccotangent(Expression expression) {
        return create(MathEntityDescriptorEnum.Arccotangent, expression);
    }

    public HyperbolicSine createHyperbolicSine() {
        return create(MathEntityDescriptorEnum.HyperbolicSine);
    }

    public HyperbolicSine createHyperbolicSine(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicSine, expression);
    }

    public HyperbolicCosine createHyperbolicCosine() {
        return create(MathEntityDescriptorEnum.HyperbolicCosine);
    }

    public HyperbolicCosine createHyperbolicCosine(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicCosine, expression);
    }

    public HyperbolicTangent createHyperbolicTangent() {
        return create(MathEntityDescriptorEnum.HyperbolicTangent);
    }

    public HyperbolicTangent createHyperbolicTangent(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicTangent, expression);
    }

    public HyperbolicCosecant createHyperbolicCosecant() {
        return create(MathEntityDescriptorEnum.HyperbolicCosecant);
    }

    public HyperbolicCosecant createHyperbolicCosecant(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicCosecant, expression);
    }

    public HyperbolicSecant createHyperbolicSecant() {
        return create(MathEntityDescriptorEnum.HyperbolicSecant);
    }

    public HyperbolicSecant createHyperbolicSecant(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicSecant, expression);
    }

    public HyperbolicCotangent createHyperbolicCotangent() {
        return create(MathEntityDescriptorEnum.HyperbolicCotangent);
    }

    public HyperbolicCotangent createHyperbolicCotangent(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicCotangent, expression);
    }

    public HyperbolicArcsine createHyperbolicArcsine() {
        return create(MathEntityDescriptorEnum.HyperbolicArcsine);
    }

    public HyperbolicArcsine createHyperbolicArcsine(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicArcsine, expression);
    }

    public HyperbolicArccosine createHyperbolicArccosine() {
        return create(MathEntityDescriptorEnum.HyperbolicArccosine);
    }

    public HyperbolicArccosine createHyperbolicArccosine(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicArccosine, expression);
    }

    public HyperbolicArctangent createHyperbolicArctangent() {
        return create(MathEntityDescriptorEnum.HyperbolicArctangent);
    }

    public HyperbolicArctangent createHyperbolicArctangent(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicArctangent, expression);
    }

    public HyperbolicArccosecant createHyperbolicArccosecant() {
        return create(MathEntityDescriptorEnum.HyperbolicArccosecant);
    }

    public HyperbolicArccosecant createHyperbolicArccosecant(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicArccosecant, expression);
    }

    public HyperbolicArcsecant createHyperbolicArcsecant() {
        return create(MathEntityDescriptorEnum.HyperbolicArcsecant);
    }

    public HyperbolicArcsecant createHyperbolicArcsecant(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicArcsecant, expression);
    }

    public HyperbolicArccotangent createHyperbolicArccotangent() {
        return create(MathEntityDescriptorEnum.HyperbolicArccotangent);
    }

    public HyperbolicArccotangent createHyperbolicArccotangent(Expression expression) {
        return create(MathEntityDescriptorEnum.HyperbolicArccotangent, expression);
    }

    public Empty createEmpty() {
        return create(MathEntityDescriptorEnum.Empty);
    }

    public Set createSet() {
        return create(MathEntityDescriptorEnum.Set);
    }

    public Set createSet(Constructor elements) {
        return create(MathEntityDescriptorEnum.Set, elements);
    }

    public OrderedPair createOrderedPair() {
        return create(MathEntityDescriptorEnum.OrderedPair);
    }

    public OrderedPair createOrderedPair(Expression first, Expression second) {
        return create(MathEntityDescriptorEnum.OrderedPair, first, second);
    }

    public IEntityBuilder<OrderedPair> buildOrderedPair() {
        return new EntityBuilder<OrderedPair>(create(MathEntityDescriptorEnum.OrderedPair));
    }

    public Tuple createTuple() {
        return create(MathEntityDescriptorEnum.Tuple);
    }

    public Tuple createTuple(Expression... entities) {
        return create(MathEntityDescriptorEnum.Tuple, (IEntity[]) entities);
    }

    public Tuple createTuple(int initialSize) {
        return clone(MathEntityDescriptorEnum.Tuple, initialSize);
    }

    public List createList() {
        return create(MathEntityDescriptorEnum.List);
    }

    public List createList(Constructor elements) {
        return create(MathEntityDescriptorEnum.List, elements);
    }

    public Stream createStream() {
        return create(MathEntityDescriptorEnum.Stream);
    }

    public Stream createStream(Constructor elements) {
        return create(MathEntityDescriptorEnum.Stream, elements);
    }

    public Enumeration createEnumeration() {
        return create(MathEntityDescriptorEnum.Enumeration);
    }

    public Enumeration createEnumeration(Expression... entities) {
        return create(MathEntityDescriptorEnum.Enumeration, (IEntity[]) entities);
    }

    public Enumeration createEnumeration(int initialSize) {
        return clone(MathEntityDescriptorEnum.Enumeration, initialSize);
    }

    public Builder createBuilder() {
        return create(MathEntityDescriptorEnum.Builder);
    }

    public Builder createBuilder(Expression element, Expression rule) {
        return create(MathEntityDescriptorEnum.Builder, element, rule);
    }

    public IEntityBuilder<Builder> buildBuilder() {
        return new EntityBuilder<Builder>(create(MathEntityDescriptorEnum.Builder));
    }

    public Union createUnion() {
        return create(MathEntityDescriptorEnum.Union);
    }

    public Union createUnion(CollectionExpression... entities) {
        return create(MathEntityDescriptorEnum.Union, (IEntity[]) entities);
    }

    public Union createUnion(int initialSize) {
        return clone(MathEntityDescriptorEnum.Union, initialSize);
    }

    public Intersection createIntersection() {
        return create(MathEntityDescriptorEnum.Intersection);
    }

    public Intersection createIntersection(CollectionExpression... entities) {
        return create(MathEntityDescriptorEnum.Intersection, (IEntity[]) entities);
    }

    public Intersection createIntersection(int initialSize) {
        return clone(MathEntityDescriptorEnum.Intersection, initialSize);
    }

    public Difference createDifference() {
        return create(MathEntityDescriptorEnum.Difference);
    }

    public Difference createDifference(CollectionExpression collection1, CollectionExpression collection2) {
        return create(MathEntityDescriptorEnum.Difference, collection1, collection2);
    }

    public IEntityBuilder<Difference> buildDifference() {
        return new EntityBuilder<Difference>(create(MathEntityDescriptorEnum.Difference));
    }

    public In createIn() {
        return create(MathEntityDescriptorEnum.In);
    }

    public In createIn(Expression element, CollectionExpression collection) {
        return create(MathEntityDescriptorEnum.In, element, collection);
    }

    public IEntityBuilder<In> buildIn() {
        return new EntityBuilder<In>(create(MathEntityDescriptorEnum.In));
    }

    public NotIn createNotIn() {
        return create(MathEntityDescriptorEnum.NotIn);
    }

    public NotIn createNotIn(Expression element, CollectionExpression collection) {
        return create(MathEntityDescriptorEnum.NotIn, element, collection);
    }

    public IEntityBuilder<NotIn> buildNotIn() {
        return new EntityBuilder<NotIn>(create(MathEntityDescriptorEnum.NotIn));
    }

    public Subset createSubset() {
        return create(MathEntityDescriptorEnum.Subset);
    }

    public Subset createSubset(CollectionExpression... entities) {
        return create(MathEntityDescriptorEnum.Subset, (IEntity[]) entities);
    }

    public Subset createSubset(int initialSize) {
        return clone(MathEntityDescriptorEnum.Subset, initialSize);
    }

    public ProperSubset createProperSubset() {
        return create(MathEntityDescriptorEnum.ProperSubset);
    }

    public ProperSubset createProperSubset(CollectionExpression... entities) {
        return create(MathEntityDescriptorEnum.ProperSubset, (IEntity[]) entities);
    }

    public ProperSubset createProperSubset(int initialSize) {
        return clone(MathEntityDescriptorEnum.ProperSubset, initialSize);
    }

    public NotSubset createNotSubset() {
        return create(MathEntityDescriptorEnum.NotSubset);
    }

    public NotSubset createNotSubset(CollectionExpression collection1, CollectionExpression collection2) {
        return create(MathEntityDescriptorEnum.NotSubset, collection1, collection2);
    }

    public IEntityBuilder<NotSubset> buildNotSubset() {
        return new EntityBuilder<NotSubset>(create(MathEntityDescriptorEnum.NotSubset));
    }

    public NotProperSubset createNotProperSubset() {
        return create(MathEntityDescriptorEnum.NotProperSubset);
    }

    public NotProperSubset createNotProperSubset(CollectionExpression collection1, CollectionExpression collection2) {
        return create(MathEntityDescriptorEnum.NotProperSubset, collection1, collection2);
    }

    public IEntityBuilder<NotProperSubset> buildNotProperSubset() {
        return new EntityBuilder<NotProperSubset>(create(MathEntityDescriptorEnum.NotProperSubset));
    }

    public Cardinality createCardinality() {
        return create(MathEntityDescriptorEnum.Cardinality);
    }

    public Cardinality createCardinality(CollectionExpression collection) {
        return create(MathEntityDescriptorEnum.Cardinality, collection);
    }

    public Selector createSelector() {
        return create(MathEntityDescriptorEnum.Selector);
    }

    public Selector createSelector(Expression index, CollectionExpression collection) {
        return create(MathEntityDescriptorEnum.Selector, index, collection);
    }

    public IEntityBuilder<Selector> buildSelector() {
        return new EntityBuilder<Selector>(create(MathEntityDescriptorEnum.Selector));
    }

    public Identifier createIdentifier() {
        return create(MathEntityDescriptorEnum.Identifier);
    }

    public Identifier createIdentifier(String value) {
        return create(MathEntityDescriptorEnum.Identifier, value);
    }

    public Boolean createBoolean() {
        return create(MathEntityDescriptorEnum.Boolean);
    }

    public Boolean createBoolean(boolean value) {
        return create(MathEntityDescriptorEnum.Boolean, value);
    }

    public ByteInteger createByteInteger() {
        return create(MathEntityDescriptorEnum.ByteInteger);
    }

    public ByteInteger createByteInteger(byte value) {
        return create(MathEntityDescriptorEnum.ByteInteger, value);
    }

    public ShortInteger createShortInteger() {
        return create(MathEntityDescriptorEnum.ShortInteger);
    }

    public ShortInteger createShortInteger(short value) {
        return create(MathEntityDescriptorEnum.ShortInteger, value);
    }

    public Integer createInteger() {
        return create(MathEntityDescriptorEnum.Integer);
    }

    public Integer createInteger(int value) {
        return create(MathEntityDescriptorEnum.Integer, value);
    }

    public LongInteger createLongInteger() {
        return create(MathEntityDescriptorEnum.LongInteger);
    }

    public LongInteger createLongInteger(long value) {
        return create(MathEntityDescriptorEnum.LongInteger, value);
    }

    public BigInteger createBigInteger() {
        return create(MathEntityDescriptorEnum.BigInteger);
    }

    public BigInteger createBigInteger(java.math.BigInteger value) {
        return create(MathEntityDescriptorEnum.BigInteger, value);
    }

    public Float createFloat() {
        return create(MathEntityDescriptorEnum.Float);
    }

    public Float createFloat(float value) {
        return create(MathEntityDescriptorEnum.Float, value);
    }

    public Double createDouble() {
        return create(MathEntityDescriptorEnum.Double);
    }

    public Double createDouble(double value) {
        return create(MathEntityDescriptorEnum.Double, value);
    }

    public BigDecimal createBigDecimal() {
        return create(MathEntityDescriptorEnum.BigDecimal);
    }

    public BigDecimal createBigDecimal(java.math.BigDecimal value) {
        return create(MathEntityDescriptorEnum.BigDecimal, value);
    }

    public Rational createRational() {
        return create(MathEntityDescriptorEnum.Rational);
    }

    public Rational createRational(IntegerNumber numerator, IntegerNumber denominator) {
        return create(MathEntityDescriptorEnum.Rational, numerator, denominator);
    }

    public IEntityBuilder<Rational> buildRational() {
        return new EntityBuilder<Rational>(create(MathEntityDescriptorEnum.Rational));
    }

    public Constant createConstant() {
        return create(MathEntityDescriptorEnum.Constant);
    }

    public Constant createConstant(ConstantEnum.Value value) {
        return create(MathEntityDescriptorEnum.Constant, value);
    }

    public NotANumber createNotANumber() {
        return create(MathEntityDescriptorEnum.NotANumber);
    }
}
