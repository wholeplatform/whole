/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.math.visitors;

import java.math.RoundingMode;
import java.util.List;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.math.model.AbsoluteValue;
import org.whole.lang.math.model.Addition;
import org.whole.lang.math.model.And;
import org.whole.lang.math.model.ApproximatelyEqual;
import org.whole.lang.math.model.Arccosine;
import org.whole.lang.math.model.Arcsine;
import org.whole.lang.math.model.Arctangent;
import org.whole.lang.math.model.BigDecimal;
import org.whole.lang.math.model.BigInteger;
import org.whole.lang.math.model.Boolean;
import org.whole.lang.math.model.Builder;
import org.whole.lang.math.model.ByteInteger;
import org.whole.lang.math.model.Cardinality;
import org.whole.lang.math.model.Ceiling;
import org.whole.lang.math.model.Constant;
import org.whole.lang.math.model.ConstantEnum;
import org.whole.lang.math.model.Cosine;
import org.whole.lang.math.model.Difference;
import org.whole.lang.math.model.Division;
import org.whole.lang.math.model.Double;
import org.whole.lang.math.model.Empty;
import org.whole.lang.math.model.Enumeration;
import org.whole.lang.math.model.Equals;
import org.whole.lang.math.model.ExclusiveOr;
import org.whole.lang.math.model.Exponential;
import org.whole.lang.math.model.Exponentiation;
import org.whole.lang.math.model.Expression;
import org.whole.lang.math.model.FactorOf;
import org.whole.lang.math.model.Factorial;
import org.whole.lang.math.model.Float;
import org.whole.lang.math.model.Floor;
import org.whole.lang.math.model.GreaterOrEqual;
import org.whole.lang.math.model.GreaterThan;
import org.whole.lang.math.model.GreatestCommonDivisor;
import org.whole.lang.math.model.HyperbolicCosine;
import org.whole.lang.math.model.HyperbolicSine;
import org.whole.lang.math.model.HyperbolicTangent;
import org.whole.lang.math.model.Identifier;
import org.whole.lang.math.model.Implies;
import org.whole.lang.math.model.In;
import org.whole.lang.math.model.Integer;
import org.whole.lang.math.model.Intersection;
import org.whole.lang.math.model.LessOrEqual;
import org.whole.lang.math.model.LessThan;
import org.whole.lang.math.model.Logarithm;
import org.whole.lang.math.model.LongInteger;
import org.whole.lang.math.model.LowestCommonMultiple;
import org.whole.lang.math.model.Maximum;
import org.whole.lang.math.model.Minimum;
import org.whole.lang.math.model.Minus;
import org.whole.lang.math.model.Multiplication;
import org.whole.lang.math.model.NaturalLogarithm;
import org.whole.lang.math.model.Not;
import org.whole.lang.math.model.NotANumber;
import org.whole.lang.math.model.NotEquals;
import org.whole.lang.math.model.NotIn;
import org.whole.lang.math.model.NotProperSubset;
import org.whole.lang.math.model.NotSubset;
import org.whole.lang.math.model.Or;
import org.whole.lang.math.model.OrderedPair;
import org.whole.lang.math.model.ProperSubset;
import org.whole.lang.math.model.Quotient;
import org.whole.lang.math.model.Remainder;
import org.whole.lang.math.model.Root;
import org.whole.lang.math.model.Selector;
import org.whole.lang.math.model.Set;
import org.whole.lang.math.model.ShortInteger;
import org.whole.lang.math.model.Sine;
import org.whole.lang.math.model.Stream;
import org.whole.lang.math.model.Subset;
import org.whole.lang.math.model.Subtraction;
import org.whole.lang.math.model.Tangent;
import org.whole.lang.math.model.Tuple;
import org.whole.lang.math.model.Union;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class MathInterpreterVisitor extends MathIdentityDefaultVisitor {
	protected void setLiteral(IEntity entity) {
    	setResult(BindingManagerFactory.instance.createSpecificValue(entity));
    }
	protected final IEntity createBooleanLiteral(boolean value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createFloatLiteral(float value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createDoubleLiteral(double value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createBigDecimalLiteral(java.math.BigDecimal value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createIntLiteral(int value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createLongLiteral(long value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createBigIntegerLiteral(java.math.BigInteger value) {
		return BindingManagerFactory.instance.createValue(value);
	}
	protected final IEntity createStringLiteral(String value) {
		return BindingManagerFactory.instance.createValue(value);
	}

	protected IEntity evaluateOptional(Expression entity) {
    	entity.accept(this);
    	return getResult();
    }
	protected IEntity evaluate(Expression entity) {
    	IEntity result = evaluateOptional(entity);
    	if (result == null)
    		throw new WholeIllegalArgumentException(WholeMessages.null_value_argument).withSourceEntity(entity).withBindings(getBindings());
    	return result;
    }

	public static enum ToKind {
		INT, LONG, BIG_INTEGER, FLOAT, DOUBLE, BIG_DECIMAL
	}
	public static ToKind maxKind(ToKind kind1, ToKind kind2) {
		if ((kind1.equals(ToKind.BIG_INTEGER) && kind1.compareTo(kind2) < 0) ||
				(kind2.equals(ToKind.BIG_INTEGER) && kind2.compareTo(kind1) < 0))
			return ToKind.BIG_DECIMAL;
		return kind1.compareTo(kind2) < 0 ? kind2 : kind1;
	}
	public ToKind maxKind(ToKind kind1, IEntity entity) {
		DataKinds dataKinds = DataTypeUtils.getUnboxedDataKind(entity);
		if (dataKinds.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data).withSourceEntity(entity).withBindings(getBindings());
		else if (dataKinds.isObject() && entity.wGetValue() instanceof java.math.BigDecimal)
			return ToKind.BIG_DECIMAL;
		else if (dataKinds.isDouble())
			return maxKind(kind1, ToKind.DOUBLE);
		else if (dataKinds.isFloat())
			return maxKind(kind1, ToKind.FLOAT);
		else if (dataKinds.isObject() && entity.wGetValue() instanceof java.math.BigInteger)
			return maxKind(kind1, ToKind.BIG_INTEGER);
		else if (dataKinds.isLong())
			return maxKind(kind1, ToKind.LONG);
		else
			return maxKind(kind1, ToKind.INT);
	}

	protected ToKind evaluateMaxKind(IEntity[] results, List<Expression> entity) {
		ToKind resultKind = ToKind.INT;
    	for (int i=0, size=entity.size(); i<size; i++)
    		resultKind = maxKind(resultKind, results[i] = evaluate(entity.get(i)));
		return resultKind;
	}
	protected ToKind evaluateMaxKind(IEntity[] results, Expression... entity) {
		ToKind resultKind = ToKind.INT;
    	for (int i=0, size=entity.length; i<size; i++)
    		resultKind = maxKind(resultKind, results[i] = evaluate(entity[i]));
		return resultKind;
	}

	@Override
	public void visit(Addition entity) {
    	IEntity[] results = new IEntity[entity.size()];
    	ToKind resultKind = evaluateMaxKind(results, entity);

    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = java.math.BigDecimal.ZERO;
    		for (IEntity r : results)
    			bdvalue = bdvalue.add(DataTypeUtils.toBigDecimal(r));
    		result = createBigDecimalLiteral(bdvalue);
    		break;
    	case DOUBLE:
    		double dvalue = 0d;
    		for (IEntity r : results)
    			dvalue += DataTypeUtils.toDouble(r);
    		result = createDoubleLiteral(dvalue);
    		break;
    	case FLOAT:
    		float fvalue = 0f;
    		for (IEntity r : results)
    			fvalue += DataTypeUtils.toFloat(r);
    		result = createFloatLiteral(fvalue);
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = java.math.BigInteger.ZERO;
    		for (IEntity r : results)
    			bivalue = bivalue.add(DataTypeUtils.toBigInteger(r));
    		result = createBigIntegerLiteral(bivalue);
    		break;
    	case LONG:
    		long lvalue = 0l;
    		for (IEntity r : results)
    			lvalue += DataTypeUtils.toLong(r);
    		result = createLongLiteral(lvalue);
    		break;
    	default:
    	case INT:
    		int ivalue = 0;
    		for (IEntity r : results)
    			ivalue += DataTypeUtils.toInt(r);
    		result = createIntLiteral(ivalue);
    		break;
    	}
		setResult(result);
	}

	@Override
	public void visit(Multiplication entity) {
    	IEntity[] results = new IEntity[entity.size()];
    	ToKind resultKind = evaluateMaxKind(results, entity);

    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = java.math.BigDecimal.ONE;
    		for (IEntity r : results)
    			bdvalue = bdvalue.multiply(DataTypeUtils.toBigDecimal(r));
    		result = createBigDecimalLiteral(bdvalue);
    		break;
    	case DOUBLE:
    		double dvalue = 1d;
    		for (IEntity r : results)
    			dvalue *= DataTypeUtils.toDouble(r);
    		result = createDoubleLiteral(dvalue);
    		break;
    	case FLOAT:
    		float fvalue = 1f;
    		for (IEntity r : results)
    			fvalue *= DataTypeUtils.toFloat(r);
    		result = createFloatLiteral(fvalue);
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = java.math.BigInteger.ONE;
    		for (IEntity r : results)
    			bivalue = bivalue.multiply(DataTypeUtils.toBigInteger(r));
    		result = createBigIntegerLiteral(bivalue);
    		break;
    	case LONG:
    		long lvalue = 1l;
    		for (IEntity r : results)
    			lvalue *= DataTypeUtils.toLong(r);
    		result = createLongLiteral(lvalue);
    		break;
    	default:
    	case INT:
    		int ivalue = 1;
    		for (IEntity r : results)
    			ivalue *= DataTypeUtils.toInt(r);
    		result = createIntLiteral(ivalue);
    		break;
    	}
		setResult(result);
	}

	@Override
	public void visit(Subtraction entity) {
    	IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getMinuend(), entity.getSubtrahend());
    	
    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(results[0]).subtract(DataTypeUtils.toBigDecimal(results[1])));
			break;
    	case DOUBLE:
			result = createDoubleLiteral(
					DataTypeUtils.toDouble(results[0]) - DataTypeUtils.toDouble(results[1]));
			break;
    	case FLOAT:
			result = createFloatLiteral(
					DataTypeUtils.toFloat(results[0]) - DataTypeUtils.toFloat(results[1]));
			break;
    	case BIG_INTEGER:
			result = createBigIntegerLiteral(
					DataTypeUtils.toBigInteger(results[0]).subtract(DataTypeUtils.toBigInteger(results[1])));
			break;
    	case LONG:
			result = createLongLiteral(
					DataTypeUtils.toLong(results[0]) - DataTypeUtils.toLong(results[1]));
			break;
    	default:
    	case INT:
			result = createIntLiteral(
					DataTypeUtils.toInt(results[0]) - DataTypeUtils.toInt(results[1]));
			break;
    	}   	
		setResult(result);
	}

	@Override
	public void visit(Division entity) {
    	IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getDividend(), entity.getDivisor());
    	
    	IEntity result;
    	switch (resultKind) {
    	case BIG_INTEGER:
    	case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(results[0]).divide(DataTypeUtils.toBigDecimal(results[1])));
			break;
    	default:
    	case LONG:
    	case INT:
    	case DOUBLE:
			result = createDoubleLiteral(
					DataTypeUtils.toDouble(results[0]) / DataTypeUtils.toDouble(results[1]));
			break;
    	case FLOAT:
			result = createFloatLiteral(
					DataTypeUtils.toFloat(results[0]) / DataTypeUtils.toFloat(results[1]));
			break;
    	}
		setResult(result);
	};
	@Override
	public void visit(Quotient entity) {
    	IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getDividend(), entity.getDivisor());
    	
    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(results[0]).divideToIntegralValue(DataTypeUtils.toBigDecimal(results[1])));
			break;
    	default:
    	case DOUBLE:
			result = createDoubleLiteral(Math.floor(
					DataTypeUtils.toDouble(results[0]) / DataTypeUtils.toDouble(results[1])));
			break;
    	case FLOAT:
			result = createFloatLiteral((float) Math.floor(
					DataTypeUtils.toFloat(results[0]) / DataTypeUtils.toFloat(results[1])));
			break;
    	case BIG_INTEGER:
			result = createBigIntegerLiteral(
					DataTypeUtils.toBigInteger(results[0]).divide(DataTypeUtils.toBigInteger(results[1])));
			break;
    	case LONG:
			result = createLongLiteral(
					DataTypeUtils.toLong(results[0]) / DataTypeUtils.toLong(results[1]));
			break;
    	case INT:
			result = createIntLiteral(
					DataTypeUtils.toInt(results[0]) / DataTypeUtils.toInt(results[1]));
			break;
    	}
		setResult(result);
	}
	@Override
	public void visit(Remainder entity) {
    	IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getDividend(), entity.getDivisor());
    	
    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(results[0]).remainder(DataTypeUtils.toBigDecimal(results[1])));
			break;
    	default:
    	case DOUBLE:
			result = createDoubleLiteral(
					DataTypeUtils.toDouble(results[0]) % DataTypeUtils.toDouble(results[1]));
			break;
    	case FLOAT:
			result = createFloatLiteral(
					DataTypeUtils.toFloat(results[0]) % DataTypeUtils.toFloat(results[1]));
			break;
    	case BIG_INTEGER:
			result = createBigIntegerLiteral(
					DataTypeUtils.toBigInteger(results[0]).remainder(DataTypeUtils.toBigInteger(results[1])));
			break;
    	case LONG:
			result = createLongLiteral(
					DataTypeUtils.toLong(results[0]) % DataTypeUtils.toLong(results[1]));
			break;
    	case INT:
			result = createIntLiteral(
					DataTypeUtils.toInt(results[0]) % DataTypeUtils.toInt(results[1]));
			break;
    	}
		setResult(result);
	}

	@Override
	public void visit(Exponentiation entity) {
    	IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getBase(), entity.getExponent());
    	
    	IEntity result;
    	switch (resultKind) {
    	case BIG_INTEGER:
    	case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(results[0]).pow(DataTypeUtils.toInt(results[1])));
			break;
    	default:
    	case LONG:
    	case INT:
    	case FLOAT:
    	case DOUBLE:
			result = createDoubleLiteral(Math.pow(
					DataTypeUtils.toDouble(results[0]), DataTypeUtils.toDouble(results[1])));
			break;
    	}
		setResult(result);
	}

	@Override
	public void visit(Root entity) {
		IEntity result1 = evaluate(entity.getExpression());
		IEntity result2 = evaluate(entity.getDegree());
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);

//		ToKind resultKind = maxKind(ToKind.INT, result1);
    	IEntity result;
    	if (dataKind2.isInt() && result2.wIntValue() == 2)
			result = createDoubleLiteral(
					Math.sqrt(DataTypeUtils.toDouble(result1)));
		else if (dataKind2.isInt() && result2.wIntValue() == 3)
			result = createDoubleLiteral(
					Math.cbrt(DataTypeUtils.toDouble(result1)));
		else
			result = createDoubleLiteral(
					Math.pow(DataTypeUtils.toDouble(result1), 1.0 / DataTypeUtils.toDouble(result2)));

		setResult(result);
	}

	@Override
	public void visit(Minus entity) {
		IEntity result1 = evaluate(entity.getExpression());
		ToKind dataKind1 = maxKind(ToKind.INT, result1);

    	IEntity result;
		switch (dataKind1) {
		case BIG_DECIMAL:
			result = createBigDecimalLiteral(DataTypeUtils.toBigDecimal(result1).negate());
			break;
		case DOUBLE:
			result = createDoubleLiteral(-DataTypeUtils.toDouble(result1));
			break;
		case FLOAT:
			result = createFloatLiteral(-DataTypeUtils.toFloat(result1));
			break;
		case BIG_INTEGER:
			result = createBigIntegerLiteral(DataTypeUtils.toBigInteger(result1).negate());
			break;
		case LONG:
			result = createLongLiteral(-DataTypeUtils.toLong(result1));
			break;
		default:
		case INT:
			result = createIntLiteral(-DataTypeUtils.toInt(result1));
			break;
		}
		setResult(result);
	}

	@Override
	public void visit(AbsoluteValue entity) {
		IEntity result1 = evaluate(entity.getExpression());
		ToKind dataKind1 = maxKind(ToKind.INT, result1);

    	IEntity result;
		switch (dataKind1) {
		case BIG_DECIMAL:
			result = createBigDecimalLiteral(DataTypeUtils.toBigDecimal(result1).abs());
			break;
		case DOUBLE:
			result = createDoubleLiteral(Math.abs(DataTypeUtils.toDouble(result1)));
			break;
		case FLOAT:
			result = createFloatLiteral(Math.abs(DataTypeUtils.toFloat(result1)));
			break;
		case BIG_INTEGER:
			result = createBigIntegerLiteral(DataTypeUtils.toBigInteger(result1).abs());
			break;
		case LONG:
			result = createLongLiteral(Math.abs(DataTypeUtils.toLong(result1)));
			break;
		default:
		case INT:
			result = createIntLiteral(Math.abs(DataTypeUtils.toInt(result1)));
			break;
		}
		setResult(result);
	}

	@Override
	public void visit(Floor entity) {
		IEntity result1 = evaluate(entity.getExpression());
		ToKind dataKind1 = maxKind(ToKind.INT, result1);

    	IEntity result;
		switch (dataKind1) {
		case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(result1).setScale(0, RoundingMode.FLOOR));
			break;
		case DOUBLE:
			result = createDoubleLiteral(Math.floor(DataTypeUtils.toDouble(result1)));
			break;
		case FLOAT:
			result = createFloatLiteral((float) Math.floor(DataTypeUtils.toFloat(result1)));
			break;		
		case BIG_INTEGER:
		case LONG:
			result = result1;
			break;
		default:
		case INT:
			result = createIntLiteral(DataTypeUtils.toInt(result1));
			break;
		}
		setResult(result);
	}

	@Override
	public void visit(Ceiling entity) {
		IEntity result1 = evaluate(entity.getExpression());
		ToKind dataKind1 = maxKind(ToKind.INT, result1);

    	IEntity result;
		switch (dataKind1) {
		case BIG_DECIMAL:
			result = createBigDecimalLiteral(
					DataTypeUtils.toBigDecimal(result1).setScale(0, RoundingMode.CEILING));
			break;
		case DOUBLE:
			result = createDoubleLiteral(Math.ceil(DataTypeUtils.toDouble(result1)));
			break;
		case FLOAT:
			result = createFloatLiteral((float) Math.ceil(DataTypeUtils.toFloat(result1)));
			break;		
		case BIG_INTEGER:
		case LONG:
			result = result1;
			break;
		default:
		case INT:
			result = createIntLiteral(DataTypeUtils.toInt(result1));
			break;
		}
		setResult(result);
	}

	@Override
	public void visit(Factorial entity) {
    	IEntity result;
		IEntity result1 = evaluate(entity.getExpression());
		long lvalue = DataTypeUtils.toLong(result1);
		if (lvalue < 0l)
			throw new WholeIllegalArgumentException("Underflow error in factorial").withSourceEntity(entity).withBindings(getBindings());
		else if (lvalue < 21l)
			result = createLongLiteral(factorial((int) lvalue));
		else
			result = createBigIntegerLiteral(factorial(
					java.math.BigInteger.valueOf(lvalue)));

		setResult(result);
	}
	public static long factorial(int n) {
		return n <= 1 ? 1 : n * factorial(n-1);
	}
	public static java.math.BigInteger factorial(java.math.BigInteger n) {
		return n.compareTo(java.math.BigInteger.ONE) <= 0 ?
				java.math.BigInteger.ONE : n.multiply(factorial(n.subtract(java.math.BigInteger.ONE)));
	}

	@Override
	public void visit(GreatestCommonDivisor entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	public static long gcd(long a, long b) {
		return b==0 ? a : gcd(b, a % b);
	}

	@Override
	public void visit(LowestCommonMultiple entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Maximum entity) {
    	IEntity[] results = new IEntity[entity.size()];
    	ToKind resultKind = evaluateMaxKind(results, entity);

    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (IEntity r : results)
    			bdvalue = bdvalue.max(DataTypeUtils.toBigDecimal(r));
    		result = createBigDecimalLiteral(bdvalue);
    		break;
    	case DOUBLE:
    		double dvalue = java.lang.Double.MIN_VALUE;
    		for (IEntity r : results)
    			dvalue = Math.max(dvalue, DataTypeUtils.toDouble(r));
    		result = createDoubleLiteral(dvalue);
    		break;
    	case FLOAT:
    		float fvalue = java.lang.Float.MIN_VALUE;
    		for (IEntity r : results)
    			fvalue = Math.max(fvalue, DataTypeUtils.toFloat(r));
    		result = createFloatLiteral(fvalue);
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (IEntity r : results)
    			bivalue = bivalue.max(DataTypeUtils.toBigInteger(r));
    		result = createBigIntegerLiteral(bivalue);
    		break;
    	case LONG:
    		long lvalue = java.lang.Long.MIN_VALUE;
    		for (IEntity r : results)
    			lvalue = Math.max(lvalue, DataTypeUtils.toLong(r));
    		result = createLongLiteral(lvalue);
    		break;
    	default:
    	case INT:
    		int ivalue = java.lang.Integer.MIN_VALUE;
    		for (IEntity r : results)
    			ivalue = Math.max(ivalue, DataTypeUtils.toInt(r));
    		result = createIntLiteral(ivalue);
    		break;
    	}
		setResult(result);
	}

	@Override
	public void visit(Minimum entity) {
    	IEntity[] results = new IEntity[entity.size()];
    	ToKind resultKind = evaluateMaxKind(results, entity);

    	IEntity result;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (IEntity r : results)
    			bdvalue = bdvalue.min(DataTypeUtils.toBigDecimal(r));
    		result = createBigDecimalLiteral(bdvalue);
    		break;
    	case DOUBLE:
    		double dvalue = java.lang.Double.MAX_VALUE;
    		for (IEntity r : results)
    			dvalue = Math.min(dvalue, DataTypeUtils.toDouble(r));
    		result = createDoubleLiteral(dvalue);
    		break;
    	case FLOAT:
    		float fvalue = java.lang.Float.MAX_VALUE;
    		for (IEntity r : results)
    			fvalue = Math.min(fvalue, DataTypeUtils.toFloat(r));
    		result = createFloatLiteral(fvalue);
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (IEntity r : results)
    			bivalue = bivalue.min(DataTypeUtils.toBigInteger(r));
    		result = createBigIntegerLiteral(bivalue);
    		break;
       	case LONG:
    		long lvalue = java.lang.Long.MAX_VALUE;
    		for (IEntity r : results)
    			lvalue = Math.min(lvalue, DataTypeUtils.toLong(r));
    		result = createLongLiteral(lvalue);
    		break;
    	default:
    	case INT:
    		int ivalue = java.lang.Integer.MAX_VALUE;
    		for (IEntity r : results)
    			ivalue = Math.min(ivalue, DataTypeUtils.toInt(r));
    		result = createIntLiteral(ivalue);
    		break;
    	}
		setResult(result);
	}

	@Override
	public void visit(And entity) {
		boolean value = true;
    	for (int i=0, size=entity.size(); i<size; i++) {
    		IEntity result = evaluate(entity.get(i));
    		DataKinds dataKinds = DataTypeUtils.getUnboxedDataKind(result);
    		if (dataKinds.isNotAData())
    			throw new WholeIllegalArgumentException(WholeMessages.no_data).withSourceEntity(entity).withBindings(getBindings());
    		else if (!dataKinds.isBoolean())
    			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion).withSourceEntity(entity).withBindings(getBindings());
    		else if (!(value &= result.wBooleanValue()))
    			break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(Or entity) {
		boolean value = false;
    	for (int i=0, size=entity.size(); i<size; i++) {
    		IEntity result = evaluate(entity.get(i));
    		DataKinds dataKinds = DataTypeUtils.getUnboxedDataKind(result);
    		if (dataKinds.isNotAData())
    			throw new WholeIllegalArgumentException(WholeMessages.no_data).withSourceEntity(entity).withBindings(getBindings());
    		else if (!dataKinds.isBoolean())
    			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion).withSourceEntity(entity).withBindings(getBindings());
    		else if (value |= result.wBooleanValue())
    			break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(ExclusiveOr entity) {
		boolean value = false;
    	for (int i=0, size=entity.size(); i<size; i++) {
    		IEntity result = evaluate(entity.get(i));
    		DataKinds dataKinds = DataTypeUtils.getUnboxedDataKind(result);
    		if (dataKinds.isNotAData())
    			throw new WholeIllegalArgumentException(WholeMessages.no_data).withSourceEntity(entity).withBindings(getBindings());
    		else if (!dataKinds.isBoolean())
    			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion).withSourceEntity(entity).withBindings(getBindings());
    		else
    			value ^= result.wBooleanValue();
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(Not entity) {
		IEntity result = evaluate(entity.getExpression());
		DataKinds dataKinds = DataTypeUtils.getUnboxedDataKind(result);
		if (dataKinds.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data).withSourceEntity(entity).withBindings(getBindings());
		else if (!dataKinds.isBoolean())
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion).withSourceEntity(entity).withBindings(getBindings());
		else
			setResult(createBooleanLiteral(!result.wBooleanValue()));
	}
	@Override
	public void visit(Implies entity) {
		IEntity result1 = evaluate(entity.getExp1());
		IEntity result2 = evaluate(entity.getExp2());
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data).withSourceEntity(entity).withBindings(getBindings());
		else if (!dataKind1.isBoolean() || !dataKind2.isBoolean())
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion).withSourceEntity(entity).withBindings(getBindings());
		else
			setResult(createBooleanLiteral(!(result1.wBooleanValue() && !result2.wBooleanValue())));
	}

	@Override
	public void visit(Equals entity) {
    	int size = entity.size();
		IEntity[] results = new IEntity[size];
    	ToKind resultKind = evaluateMaxKind(results, entity);

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bdvalue.compareTo(DataTypeUtils.toBigDecimal(results[i])) == 0)))
    				break;
    		break;
    	case DOUBLE:
    		double dvalue = DataTypeUtils.toDouble(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Double.compare(dvalue, DataTypeUtils.toDouble(results[i])) == 0)))
    				break;
    		break;
    	case FLOAT:
    		float fvalue = DataTypeUtils.toFloat(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Float.compare(fvalue, DataTypeUtils.toFloat(results[i])) == 0)))
    				break;
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bivalue.compareTo(DataTypeUtils.toBigInteger(results[i])) == 0)))
    				break;
    		break;
    	case LONG:
    		long lvalue = DataTypeUtils.toLong(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (lvalue == DataTypeUtils.toLong(results[i]))))
    				break;
    		break;
    	default:
    	case INT:
    		int ivalue = DataTypeUtils.toInt(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (ivalue == DataTypeUtils.toInt(results[i]))))
    				break;
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(NotEquals entity) {
		IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getExp1(), entity.getExp2());

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		value = DataTypeUtils.toBigDecimal(results[0]).compareTo(DataTypeUtils.toBigDecimal(results[1])) != 0;
    		break;
    	case DOUBLE:
    		value = java.lang.Double.compare(DataTypeUtils.toDouble(results[0]), DataTypeUtils.toDouble(results[1])) != 0;
    		break;
    	case FLOAT:
    		value = java.lang.Float.compare(DataTypeUtils.toFloat(results[0]), DataTypeUtils.toFloat(results[1])) != 0;
    		break;
    	case BIG_INTEGER:
    		value = DataTypeUtils.toBigInteger(results[0]).compareTo(DataTypeUtils.toBigInteger(results[1])) != 0;
    		break;
    	case LONG:
    		value = DataTypeUtils.toLong(results[0]) != DataTypeUtils.toLong(results[1]);
    		break;
    	default:
    	case INT:
    		value = DataTypeUtils.toInt(results[0]) != DataTypeUtils.toInt(results[1]);
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(ApproximatelyEqual entity) {
		IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getExp1(), entity.getExp2());

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    	case DOUBLE:
    	case FLOAT:
    		java.math.BigDecimal bdvalue1 = DataTypeUtils.toBigDecimal(results[0]);
    		java.math.BigDecimal bdvalue2 = DataTypeUtils.toBigDecimal(results[1]);
    		int scale = Math.min(bdvalue1.scale(), bdvalue2.scale());
    		value = bdvalue1.setScale(scale, RoundingMode.HALF_EVEN).compareTo(bdvalue2.setScale(scale, RoundingMode.HALF_EVEN)) == 0;
    		break;
//    	case BIG_DECIMAL:
//    		value = DataTypeUtils.toBigDecimal(results[0]).compareTo(DataTypeUtils.toBigDecimal(results[1])) == 0;
//    		break;
//    	case DOUBLE:
//    		value = java.lang.Double.compare(DataTypeUtils.toDouble(results[0]), DataTypeUtils.toDouble(results[1])) == 0;
//    		break;
//    	case FLOAT:
//    		value = java.lang.Float.compare(DataTypeUtils.toFloat(results[0]), DataTypeUtils.toFloat(results[1])) == 0;
//    		break;
    	case BIG_INTEGER:
    		value = DataTypeUtils.toBigInteger(results[0]).compareTo(DataTypeUtils.toBigInteger(results[1])) == 0;
    		break;
    	case LONG:
    		value = DataTypeUtils.toLong(results[0]) == DataTypeUtils.toLong(results[1]);
    		break;
    	default:
    	case INT:
    		value = DataTypeUtils.toInt(results[0]) == DataTypeUtils.toInt(results[1]);
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(GreaterThan entity) {
    	int size = entity.size();
		IEntity[] results = new IEntity[size];
    	ToKind resultKind = evaluateMaxKind(results, entity);

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bdvalue.compareTo(DataTypeUtils.toBigDecimal(results[i])) > 0)))
    				break;
    		break;
    	case DOUBLE:
    		double dvalue = DataTypeUtils.toDouble(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Double.compare(dvalue, DataTypeUtils.toDouble(results[i])) > 0)))
    				break;
    		break;
    	case FLOAT:
    		float fvalue = DataTypeUtils.toFloat(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Float.compare(fvalue, DataTypeUtils.toFloat(results[i])) > 0)))
    				break;
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bivalue.compareTo(DataTypeUtils.toBigInteger(results[i])) > 0)))
    				break;
    		break;
    	case LONG:
    		long lvalue = DataTypeUtils.toLong(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (lvalue > DataTypeUtils.toLong(results[i]))))
    				break;
    		break;
    	default:
    	case INT:
    		int ivalue = DataTypeUtils.toInt(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (ivalue > DataTypeUtils.toInt(results[i]))))
    				break;
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(LessThan entity) {
    	int size = entity.size();
		IEntity[] results = new IEntity[size];
    	ToKind resultKind = evaluateMaxKind(results, entity);

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bdvalue.compareTo(DataTypeUtils.toBigDecimal(results[i])) < 0)))
    				break;
    		break;
    	case DOUBLE:
    		double dvalue = DataTypeUtils.toDouble(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Double.compare(dvalue, DataTypeUtils.toDouble(results[i])) < 0)))
    				break;
    		break;
    	case FLOAT:
    		float fvalue = DataTypeUtils.toFloat(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Float.compare(fvalue, DataTypeUtils.toFloat(results[i])) < 0)))
    				break;
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bivalue.compareTo(DataTypeUtils.toBigInteger(results[i])) < 0)))
    				break;
    		break;
    	case LONG:
    		long lvalue = DataTypeUtils.toLong(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (lvalue < DataTypeUtils.toLong(results[i]))))
    				break;
    		break;
    	default:
    	case INT:
    		int ivalue = DataTypeUtils.toInt(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (ivalue < DataTypeUtils.toInt(results[i]))))
    				break;
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(GreaterOrEqual entity) {
    	int size = entity.size();
		IEntity[] results = new IEntity[size];
    	ToKind resultKind = evaluateMaxKind(results, entity);

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bdvalue.compareTo(DataTypeUtils.toBigDecimal(results[i])) >= 0)))
    				break;
    		break;
    	case DOUBLE:
    		double dvalue = DataTypeUtils.toDouble(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Double.compare(dvalue, DataTypeUtils.toDouble(results[i])) >= 0)))
    				break;
    		break;
    	case FLOAT:
    		float fvalue = DataTypeUtils.toFloat(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Float.compare(fvalue, DataTypeUtils.toFloat(results[i])) >= 0)))
    				break;
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bivalue.compareTo(DataTypeUtils.toBigInteger(results[i])) >= 0)))
    				break;
    		break;
    	case LONG:
    		long lvalue = DataTypeUtils.toLong(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (lvalue >= DataTypeUtils.toLong(results[i]))))
    				break;
    		break;
    	default:
    	case INT:
    		int ivalue = DataTypeUtils.toInt(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (ivalue >= DataTypeUtils.toInt(results[i]))))
    				break;
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}
	@Override
	public void visit(LessOrEqual entity) {
    	int size = entity.size();
		IEntity[] results = new IEntity[size];
    	ToKind resultKind = evaluateMaxKind(results, entity);

		boolean value = true;
    	switch (resultKind) {
    	case BIG_DECIMAL:
    		java.math.BigDecimal bdvalue = DataTypeUtils.toBigDecimal(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bdvalue.compareTo(DataTypeUtils.toBigDecimal(results[i])) <= 0)))
    				break;
    		break;
    	case DOUBLE:
    		double dvalue = DataTypeUtils.toDouble(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Double.compare(dvalue, DataTypeUtils.toDouble(results[i])) <= 0)))
    				break;
    		break;
    	case FLOAT:
    		float fvalue = DataTypeUtils.toFloat(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (java.lang.Float.compare(fvalue, DataTypeUtils.toFloat(results[i])) <= 0)))
    				break;
    		break;
    	case BIG_INTEGER:
    		java.math.BigInteger bivalue = DataTypeUtils.toBigInteger(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (bivalue.compareTo(DataTypeUtils.toBigInteger(results[i])) <= 0)))
    				break;
    		break;
    	case LONG:
    		long lvalue = DataTypeUtils.toLong(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (lvalue <= DataTypeUtils.toLong(results[i]))))
    				break;
    		break;
    	default:
    	case INT:
    		int ivalue = DataTypeUtils.toInt(results[0]);
    		for (int i=1; i<size; i++)
    			if (!(value = (ivalue <= DataTypeUtils.toInt(results[i]))))
    				break;
    		break;
    	}
		setResult(createBooleanLiteral(value));
	}

	@Override
	public void visit(FactorOf entity) {
    	IEntity[] results = new IEntity[2];
    	ToKind resultKind = evaluateMaxKind(results, entity.getExp2(), entity.getExp1());
    	
    	boolean value = false;
    	switch (resultKind) {
    	default:
    	case BIG_DECIMAL:
    		value = DataTypeUtils.toBigDecimal(results[0]).remainder(DataTypeUtils.toBigDecimal(results[1])).compareTo(java.math.BigDecimal.ZERO) == 0;
			break;
    	case DOUBLE:
    		value = Math.abs(DataTypeUtils.toDouble(results[0]) % DataTypeUtils.toDouble(results[1])) < 0.00001;
			break;
    	case FLOAT:
    		value = Math.abs(DataTypeUtils.toFloat(results[0]) % DataTypeUtils.toFloat(results[1])) < 0.00001;
			break;
    	case BIG_INTEGER:
    		value = DataTypeUtils.toBigInteger(results[0]).remainder(DataTypeUtils.toBigInteger(results[1])).compareTo(java.math.BigInteger.ZERO) == 0;
			break;
    	case LONG:
    		value = DataTypeUtils.toLong(results[0]) % DataTypeUtils.toLong(results[1]) == 0;
			break;
    	case INT:
			value = DataTypeUtils.toInt(results[0]) % DataTypeUtils.toInt(results[1]) == 0;
			break;
    	}
		setResult(createBooleanLiteral(value));
	}

	@Override
	public void visit(Exponential entity) {
		setResult(createDoubleLiteral(
				Math.exp(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}

	@Override
	public void visit(NaturalLogarithm entity) {
		setResult(createDoubleLiteral(
				Math.log(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(Logarithm entity) {
		setResult(createDoubleLiteral(
				Math.log(DataTypeUtils.toDouble(evaluate(entity.getExpression()))) / Math.log(DataTypeUtils.toDouble(evaluate(entity.getBase())))));
	}


	@Override
	public void visit(Sine entity) {
		setResult(createDoubleLiteral(
				Math.sin(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(Cosine entity) {
		setResult(createDoubleLiteral(
				Math.cos(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(Tangent entity) {
		setResult(createDoubleLiteral(
				Math.tan(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}

	@Override
	public void visit(Arcsine entity) {
		setResult(createDoubleLiteral(
				Math.asin(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(Arccosine entity) {
		setResult(createDoubleLiteral(
				Math.acos(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(Arctangent entity) {
		setResult(createDoubleLiteral(
				Math.atan(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}

	@Override
	public void visit(HyperbolicSine entity) {
		setResult(createDoubleLiteral(
				Math.sinh(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(HyperbolicCosine entity) {
		setResult(createDoubleLiteral(
				Math.cosh(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}
	@Override
	public void visit(HyperbolicTangent entity) {
		setResult(createDoubleLiteral(
				Math.tanh(DataTypeUtils.toDouble(
						evaluate(entity.getExpression())))));
	}


	@Override
	public void visit(Empty entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Set entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(OrderedPair entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Tuple entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(org.whole.lang.math.model.List entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Stream entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Enumeration entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Builder entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Union entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Intersection entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Difference entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(In entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(NotIn entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(Subset entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(ProperSubset entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(NotSubset entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}
	@Override
	public void visit(NotProperSubset entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Cardinality entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Selector entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	
	@Override
	public void visit(Identifier entity) {
		// TODO Auto-generated method stub
		super.visit(entity);
	}

	@Override
	public void visit(Boolean entity) {
		setLiteral(entity);
	}

	@Override
	public void visit(ByteInteger entity) {
		setLiteral(entity);
	}
	@Override
	public void visit(ShortInteger entity) {
		setLiteral(entity);
	}
	@Override
	public void visit(Integer entity) {
		setLiteral(entity);
	}
	@Override
	public void visit(LongInteger entity) {
		setLiteral(entity);
	}
	@Override
	public void visit(BigInteger entity) {
		setResult(EntityUtils.clone(entity));
	}

	@Override
	public void visit(Float entity) {
		setLiteral(entity);
	}
	@Override
	public void visit(Double entity) {
		setLiteral(entity);
	}
	@Override
	public void visit(BigDecimal entity) {
		setResult(EntityUtils.clone(entity));
	}

	@Override
	public void visit(Constant entity) {
		switch (entity.getValue().getOrdinal()) {
		case ConstantEnum.pi_ord:
			setResult(createDoubleLiteral(Math.PI));
			break;
		case ConstantEnum.e_ord:
			setResult(createDoubleLiteral(Math.E));
			break;
		case ConstantEnum.i_ord:
			setResult(EntityUtils.clone(entity));
			break;
		case ConstantEnum.gamma_ord:
			setResult(createDoubleLiteral(0.5772156649d));
			break;
		case ConstantEnum.infinity_ord:
			setResult(createDoubleLiteral(java.lang.Double.POSITIVE_INFINITY));
			break;
		}
	}

	@Override
	public void visit(NotANumber entity) {
		setResult(createDoubleLiteral(java.lang.Double.NaN));
	}
}
