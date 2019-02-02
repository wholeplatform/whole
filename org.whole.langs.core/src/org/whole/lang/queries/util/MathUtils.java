/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.evaluators.AbstractDelegatingNestedTrySupplierEvaluator;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class MathUtils {
	public static IExecutable createAdditionStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return addition(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "addition(";
			}
		};
	}
	public static IExecutable createSubtractionStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return subtraction(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "subtraction(";
			}
		};
	}
	public static IExecutable createMultiplicationStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return multiplication(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "multiplication(";
			}
		};
	}
	public static IExecutable createDivisionStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return division(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "division(";
			}
		};
	}
	public static IExecutable createRemainderStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return remainder(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "remainder(";
			}
		};
	}

	public static IExecutable createEqualsStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return MathUtils.equals(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "equals(";
			}
		};
	}
	public static IExecutable createNotEqualsStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return notEquals(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "notEquals(";
			}
		};
	}
	public static IExecutable createLessThanStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return lessThan(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "lessThan(";
			}
		};
	}
	public static IExecutable createLessOrEqualsStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return lessOrEquals(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "lessOrEquals(";
			}
		};
	}
	public static IExecutable createGreaterThanStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return greaterThan(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "greaterThan(";
			}
		};
	}
	public static IExecutable createGreaterOrEqualsStep(IExecutable expression) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(expression) {
			public IEntity get() {
				return greaterOrEquals(selfEntity, getProducer(0).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "greaterOrEquals(";
			}
		};
	}


	public static IExecutable createAddition(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return addition(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "addition(";
			}
		};
	}
	public static IExecutable createSubtraction(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return subtraction(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "subtraction(";
			}
		};
	}
	public static IExecutable createMultiplication(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return multiplication(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "multiplication(";
			}
		};
	}
	public static IExecutable createDivision(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return division(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "division(";
			}
		};
	}
	public static IExecutable createRemainder(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return remainder(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "remainder(";
			}
		};
	}

	public static IExecutable createEquals(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return MathUtils.equals(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "equals(";
			}
		};
	}
	public static IExecutable createNotEquals(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return notEquals(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "notEquals(";
			}
		};
	}
	public static IExecutable createLessThan(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return lessThan(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "lessThan(";
			}
		};
	}
	public static IExecutable createLessOrEquals(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return lessOrEquals(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "lessOrEquals(";
			}
		};
	}
	public static IExecutable createGreaterThan(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return greaterThan(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "greaterThan(";
			}
		};
	}
	public static IExecutable createGreaterOrEquals(IExecutable exp1, IExecutable exp2) {
		return new AbstractDelegatingNestedTrySupplierEvaluator(exp1, exp2) {
			public IEntity get() {
				return greaterOrEquals(getProducer(0).evaluateRemaining(), getProducer(1).evaluateRemaining());
			}
			public String toStringPrefix() {
				return "greaterOrEquals(";
			}
		};
	}


	public static IEntity addition(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);

		IEntity result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isString() || dataKind2.isString())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toString(result1) + DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toDouble(result1) + DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toFloat(result1) + DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toLong(result1) + DataTypeUtils.toLong(result2));
		else
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toInt(result1) + DataTypeUtils.toInt(result2));
		return result;
	}

	public static IEntity subtraction(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		IEntity result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toDouble(result1) - DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toFloat(result1) - DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toLong(result1) - DataTypeUtils.toLong(result2));
		else
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toInt(result1) - DataTypeUtils.toInt(result2));
		return result;
	}

	public static IEntity multiplication(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		IEntity result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toDouble(result1) * DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toFloat(result1) * DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toLong(result1) * DataTypeUtils.toLong(result2));
		else
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toInt(result1) * DataTypeUtils.toInt(result2));
		return result;
	}

	public static IEntity division(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		IEntity result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toDouble(result1) / DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toFloat(result1) / DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toLong(result1) / DataTypeUtils.toLong(result2));
		else
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toInt(result1) / DataTypeUtils.toInt(result2));
		return result;
	}

	public static IEntity remainder(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		IEntity result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toDouble(result1) % DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toFloat(result1) % DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toLong(result1) % DataTypeUtils.toLong(result2));
		else
			result = BindingManagerFactory.instance.createValue(DataTypeUtils.toInt(result1) % DataTypeUtils.toInt(result2));
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IEntity equals(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		boolean result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData()) {
			result = false;
			if (!EntityUtils.isResolver(result1) && !EntityUtils.isResolver(result2))
				throw new WholeIllegalArgumentException(WholeMessages.no_data);
		} else if (dataKind1.isBoolean() && dataKind2.isBoolean())
			result = DataTypeUtils.toBoolean(result1) == DataTypeUtils.toBoolean(result2);
		else if (dataKind1.isObject() && dataKind2.isObject()) {
			Object result1value = result1.wGetValue();
			Object result2value = result2.wGetValue();
			if (result1value instanceof Comparable && result2value instanceof Comparable)
				try {
					result = 0 == ((Comparable) result1value).compareTo((Comparable) result2value);
				} catch (ClassCastException e) {
					result = result1value == result2value;					
				}
			else
				result = result1value == result2value;
		} else if (dataKind1.isEnumValue() && dataKind2.isEnumValue())
			result = result1.wEnumValue().equals(result2.wEnumValue());
		else if (dataKind1.isDate() && dataKind2.isDate())
			result = result1.wDateValue().equals(result2.wDateValue());
		else if (dataKind1.isString() || dataKind2.isString())
			result = DataTypeUtils.toString(result1).equals(DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = 0 == Double.compare(DataTypeUtils.toDouble(result1), DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = 0 == Float.compare(DataTypeUtils.toFloat(result1), DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = DataTypeUtils.toLong(result1) == DataTypeUtils.toLong(result2);
		else
			result = DataTypeUtils.toInt(result1) == DataTypeUtils.toInt(result2);
	
		return BindingManagerFactory.instance.createValue(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IEntity notEquals(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		boolean result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isBoolean() && dataKind2.isBoolean())
			result = DataTypeUtils.toBoolean(result1) != DataTypeUtils.toBoolean(result2);
		else if (dataKind1.isObject() && dataKind2.isObject()) {
			Object result1value = result1.wGetValue();
			Object result2value = result2.wGetValue();
			if (result1value instanceof Comparable<?> && result2value instanceof Comparable<?>)
				try {
					result = 0 != ((Comparable) result1value).compareTo((Comparable) result2value);
				} catch (ClassCastException e) {
					result = result1value != result2value;					
				}
			else
				result = result1value != result2value;
		} else if (dataKind1.isEnumValue() && dataKind2.isEnumValue())
			result = !result1.wEnumValue().equals(result2.wEnumValue());
		else if (dataKind1.isDate() && dataKind2.isDate())
			result = !result1.wDateValue().equals(result2.wDateValue());
		else if (dataKind1.isString() || dataKind2.isString())
			result = !DataTypeUtils.toString(result1).equals(DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = 0 != Double.compare(DataTypeUtils.toDouble(result1), DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = 0 != Float.compare(DataTypeUtils.toFloat(result1), DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = DataTypeUtils.toLong(result1) != DataTypeUtils.toLong(result2);
		else
			result = DataTypeUtils.toInt(result1) != DataTypeUtils.toInt(result2);
	
		return BindingManagerFactory.instance.createValue(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IEntity lessThan(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		boolean result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isObject() && dataKind2.isObject()) {
			Object result1value = result1.wGetValue();
			Object result2value = result2.wGetValue();
			if (result1value instanceof Comparable && result2value instanceof Comparable)
				try {
					result = 0 > ((Comparable) result1value).compareTo((Comparable) result2value);
				} catch (ClassCastException e) {
					throw new IllegalArgumentException("Objects are not Comparable");
				}
			else
				throw new IllegalArgumentException("Objects are not Comparable");
		} else if (dataKind1.isEnumValue() && dataKind2.isEnumValue())
			result = 0 > result1.wEnumValue().compareTo(result2.wEnumValue());
		else if (dataKind1.isDate() && dataKind2.isDate())
			result = 0 > result1.wDateValue().compareTo(result2.wDateValue());
		else if (dataKind1.isString() || dataKind2.isString())
			result = 0 > DataTypeUtils.toString(result1).compareTo(DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = 0 > Double.compare(DataTypeUtils.toDouble(result1), DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = 0 > Float.compare(DataTypeUtils.toFloat(result1), DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = DataTypeUtils.toLong(result1) < DataTypeUtils.toLong(result2);
		else
			result = DataTypeUtils.toInt(result1) < DataTypeUtils.toInt(result2);
	
		return BindingManagerFactory.instance.createValue(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IEntity lessOrEquals(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		boolean result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isObject() && dataKind2.isObject()) {
			Object result1value = result1.wGetValue();
			Object result2value = result2.wGetValue();
			if (result1value instanceof Comparable && result2value instanceof Comparable)
				try {
					result = 0 >= ((Comparable) result1value).compareTo((Comparable) result2value);
				} catch (ClassCastException e) {
					throw new IllegalArgumentException("Objects are not Comparable");
				}
			else
				throw new IllegalArgumentException("Objects are not Comparable");
		} else if (dataKind1.isEnumValue() && dataKind2.isEnumValue())
			result = 0 >= result1.wEnumValue().compareTo(result2.wEnumValue());
		else if (dataKind1.isDate() && dataKind2.isDate())
			result = 0 >= result1.wDateValue().compareTo(result2.wDateValue());
		else if (dataKind1.isString() || dataKind2.isString())
			result = 0 >= DataTypeUtils.toString(result1).compareTo(DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = 0 >= Double.compare(DataTypeUtils.toDouble(result1), DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = 0 >= Float.compare(DataTypeUtils.toFloat(result1), DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = DataTypeUtils.toLong(result1) <= DataTypeUtils.toLong(result2);
		else
			result = DataTypeUtils.toInt(result1) <= DataTypeUtils.toInt(result2);
	
		return BindingManagerFactory.instance.createValue(result);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static IEntity greaterThan(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		boolean result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isObject() && dataKind2.isObject()) {
			Object result1value = result1.wGetValue();
			Object result2value = result2.wGetValue();
			if (result1value instanceof Comparable && result2value instanceof Comparable)
				try {
					result = 0 < ((Comparable) result1value).compareTo((Comparable) result2value);
				} catch (ClassCastException e) {
					throw new IllegalArgumentException("Objects are not Comparable");
				}
			else
				throw new IllegalArgumentException("Objects are not Comparable");
		} else if (dataKind1.isEnumValue() && dataKind2.isEnumValue())
			result = 0 < result1.wEnumValue().compareTo(result2.wEnumValue());
		else if (dataKind1.isDate() && dataKind2.isDate())
			result = 0 < result1.wDateValue().compareTo(result2.wDateValue());
		else if (dataKind1.isString() || dataKind2.isString())
			result = 0 < DataTypeUtils.toString(result1).compareTo(DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = 0 < Double.compare(DataTypeUtils.toDouble(result1), DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = 0 < Float.compare(DataTypeUtils.toFloat(result1), DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = DataTypeUtils.toLong(result1) > DataTypeUtils.toLong(result2);
		else
			result = DataTypeUtils.toInt(result1) > DataTypeUtils.toInt(result2);
	
			return BindingManagerFactory.instance.createValue(result);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IEntity greaterOrEquals(IEntity result1, IEntity result2) {
		DataKinds dataKind1 = DataTypeUtils.getUnboxedDataKind(result1);
		DataKinds dataKind2 = DataTypeUtils.getUnboxedDataKind(result2);
	
		boolean result;
		if (dataKind1.isNotAData() || dataKind2.isNotAData())
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		else if (dataKind1.isObject() && dataKind2.isObject()) {
			Object result1value = result1.wGetValue();
			Object result2value = result2.wGetValue();
			if (result1value instanceof Comparable && result2value instanceof Comparable)
				try {
					result = 0 <= ((Comparable) result1value).compareTo((Comparable) result2value);
				} catch (ClassCastException e) {
					throw new IllegalArgumentException("Objects are not Comparable");
				}
			else
				throw new IllegalArgumentException("Objects are not Comparable");
		} else if (dataKind1.isEnumValue() && dataKind2.isEnumValue())
			result = 0 <= result1.wEnumValue().compareTo(result2.wEnumValue());
		else if (dataKind1.isDate() && dataKind2.isDate())
			result = 0 <= result1.wDateValue().compareTo(result2.wDateValue());
		else if (dataKind1.isString() || dataKind2.isString())
			result = 0 <= DataTypeUtils.toString(result1).compareTo(DataTypeUtils.toString(result2));
		else if (dataKind1.isDouble() || dataKind2.isDouble())
			result = 0 <= Double.compare(DataTypeUtils.toDouble(result1), DataTypeUtils.toDouble(result2));
		else if (dataKind1.isFloat() || dataKind2.isFloat())
			result = 0 <= Float.compare(DataTypeUtils.toFloat(result1), DataTypeUtils.toFloat(result2));
		else if (dataKind1.isLong() || dataKind2.isLong())
			result = DataTypeUtils.toLong(result1) >= DataTypeUtils.toLong(result2);
		else
			result = DataTypeUtils.toInt(result1) >= DataTypeUtils.toInt(result2);
	
			return BindingManagerFactory.instance.createValue(result);
	}
}
