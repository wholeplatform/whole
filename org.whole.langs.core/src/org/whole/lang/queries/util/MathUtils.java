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
package org.whole.lang.queries.util;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.iterators.AbstractSingleValuedRunnableIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.WholeMessages;

/**
 * @author Riccardo Solmi
 */
public class MathUtils {
	public static IExecutable<?> additionStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(addition(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("addition");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> subtractionStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(subtraction(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("subtraction");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> multiplicationStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(multiplication(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("multiplication");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> divisionStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(division(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("division");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> remainderStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(remainder(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("remainder");
				super.toString(sb);
			}
		};
	}

	public static IExecutable<?> equalsStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(MathUtils.equals(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("equals");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> notEqualsStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(notEquals(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("notEquals");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> lessThanStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(lessThan(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("lessThan");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> lessOrEqualsStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(lessOrEquals(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("lessOrEquals");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> greaterThanStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(greaterThan(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("greaterThan");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> greaterOrEqualsStepIterator(IExecutable<?> expression) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(expression.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(greaterOrEquals(selfEntity, argsEntities[0]));
			}
			public void toString(StringBuilder sb) {
				sb.append("greaterOrEquals");
				super.toString(sb);
			}
		};
	}



	public static IExecutable<?> additionIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(addition(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("addition");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> subtractionIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(subtraction(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("subtraction");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> multiplicationIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(multiplication(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("multiplication");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> divisionIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(division(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("division");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> remainderIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(remainder(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("remainder");
				super.toString(sb);
			}
		};
	}

	public static IExecutable<?> equalsIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(MathUtils.equals(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("equals");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> notEqualsIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(notEquals(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("notEquals");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> lessThanIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(lessThan(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("lessThan");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> lessOrEqualsIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(lessOrEquals(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("lessOrEquals");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> greaterThanIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(greaterThan(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("greaterThan");
				super.toString(sb);
			}
		};
	}
	public static IExecutable<?> greaterOrEqualsIterator(IExecutable<?> exp1, IExecutable<?> exp2) {
		return new AbstractSingleValuedRunnableIterator<IEntity>(exp1.iterator(), exp2.iterator()) {
			public void run(IEntity selfEntity, IBindingManager bm, IEntity... argsEntities) {
				bm.setResult(greaterOrEquals(argsEntities[0], argsEntities[1]));
			}
			public void toString(StringBuilder sb) {
				sb.append("greaterOrEquals");
				super.toString(sb);
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
