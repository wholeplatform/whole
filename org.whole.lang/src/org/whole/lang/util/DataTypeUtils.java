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
package org.whole.lang.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.exceptions.WholeIllegalArgumentException;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.DataKinds;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public class DataTypeUtils {
	public static IDataTypeParser getDataTypeParser(IEntity entity, DataTypeParsers parserKind) {
		return getDataTypeParser(entity.wGetEntityDescriptor(), parserKind);
	}
	public static IDataTypeParser getDataTypeParser(EntityDescriptor<?> ed, DataTypeParsers parserKind) {
		return ed.getLanguageKit().getDataTypeParser(parserKind);
	}
	
	public static EntityDescriptor<?> getMostSpecificDescriptor(EntityDescriptor<?> ed, String value, DataTypeParsers parserKind) {
		if (!ed.getDataKind().isNotAData())
			return ed;
		
		EntityDescriptor<?> msed = ed;
		int specificity = DataKinds.NOT_A_DATA.ordinal();
		for (EntityDescriptor<?> sed : ed.getLanguageConcreteSubtypes()) {
			final DataKinds dataKind = sed.getDataKind();
			
			if (dataKind.ordinal() < specificity) {
				try {
					getDataTypeParser(sed, parserKind).parse(sed, value);
					msed = sed;
					specificity = dataKind.ordinal();
				} catch (IllegalArgumentException e) {
				}
			}
		}
		return msed;
	}
	
	public static <E extends IEntity> E convert(IEntity fromEntity, E toEntity) {
		if (toEntity.wGetEntityDescriptor().equals(fromEntity.wGetEntityDescriptor()))
			toEntity.wSetValue(fromEntity.wGetValue());
		else
			setFromPresentationString(toEntity, getAsPresentationString(fromEntity));
		return toEntity;
	}
	public static IEntity convertCloneIfParented(IEntity fromEntity, EntityDescriptor<?> toEd) {
		return convertCloneIfReparenting(fromEntity, toEd, false);
	}
	public static final IEntity convertCloneIfReparenting(IEntity fromEntity, FeatureDescriptor toEFd) {
		return convertCloneIfReparenting(fromEntity, toEFd.getEntityDescriptor(), toEFd.isReference());
	}
	public static final IEntity convertCloneIfReparenting(IEntity fromEntity, EntityDescriptor<?> toEd, boolean isToReference) {
		EntityDescriptor<?> fromEd = fromEntity.wGetEntityDescriptor();
		if (toEd.equals(fromEd))
			return EntityUtils.cloneIfReparenting(fromEntity, isToReference);
		else
			try {
				//TODO getMostSpecificDescriptor before converting to string
				return createFromPresentationString(toEd, getAsPresentationString(fromEntity));
			} catch (RuntimeException e) {
				Class<?> toDT = toEd.getDataType();
				Class<?> fromDT = fromEd.getDataType();
				if (toDT == null || fromDT == null || toEd.getDataKind().isEnumValue() || fromEd.getDataKind().isEnumValue())
					throw e;

				if (toDT.isInstance(fromEntity.wGetValue()))
					return GenericEntityFactory.instance.create(toEd, fromEntity.wGetValue());
				else
					throw e;
			}
	}

	public static int compare(IEntity e1, IEntity e2) {
		return getAsPresentationString(e1).compareTo(getAsPresentationString(e2));
	}
	public static int compareIgnoreCase(IEntity e1, IEntity e2) {
		return getAsPresentationString(e1).compareToIgnoreCase(getAsPresentationString(e2));
	}

	public static IEntity createFromPresentationString(EntityDescriptor<?> ed, String data) {
		IDataTypeParser parser = getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		ed = getMostSpecificDescriptor(ed, data, DataTypeParsers.PRESENTATION);
		return GenericEntityFactory.instance.create(ed, parser.parse(ed, data));
	}
	public static IEntity createFromPersistenceString(EntityDescriptor<?> ed, String data) {
		IDataTypeParser parser = getDataTypeParser(ed, DataTypeParsers.PERSISTENCE);
		ed = getMostSpecificDescriptor(ed, data, DataTypeParsers.PERSISTENCE);
		return GenericEntityFactory.instance.create(ed, parser.parse(ed, data));
	}


	public static void setFromPresentationString(IEntity entity, String value) {
		IDataTypeParser parser = getDataTypeParser(entity, DataTypeParsers.PRESENTATION);
		setFromString(entity, value, parser);
	}
	public static void setFromPersistenceString(IEntity entity, String value) {
		IDataTypeParser parser = getDataTypeParser(entity, DataTypeParsers.PERSISTENCE);
		setFromString(entity, value, parser);
	}
	public static String getAsPresentationString(IEntity entity) {
		IDataTypeParser unparser = getDataTypeParser(entity, DataTypeParsers.PRESENTATION);
		return getAsString(entity, unparser);
	}
	public static String getAsPersistenceString(IEntity entity) {
		IDataTypeParser unparser = getDataTypeParser(entity, DataTypeParsers.PERSISTENCE);
		return getAsString(entity, unparser);
	}

	public static void setFromString(IEntity entity, String value, IDataTypeParser parser) {
		final EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		switch (ed.getDataKind()) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BOOLEAN:
			entity.wSetValue(parser.parseBoolean(ed, value));
			break;
		case BYTE:
			entity.wSetValue(parser.parseByte(ed, value));
			break;
		case CHAR:
			entity.wSetValue(parser.parseChar(ed, value));
			break;
		case DOUBLE:
			entity.wSetValue(parser.parseDouble(ed, value));
			break;
		case FLOAT:
			entity.wSetValue(parser.parseFloat(ed, value));
			break;
		case INT:
			entity.wSetValue(parser.parseInt(ed, value));
			break;
		case LONG:
			entity.wSetValue(parser.parseLong(ed, value));
			break;
		case SHORT:
			entity.wSetValue(parser.parseShort(ed, value));
			break;
		case STRING:
			entity.wSetValue(parser.parseString(ed, value));
			break;
		case DATE:
			entity.wSetValue(parser.parseDate(ed, value));
			break;
		case ENUM_VALUE:
			entity.wSetValue(parser.parseEnumValue(ed, value));
			break;
		case OBJECT:
		default:
			entity.wSetValue(parser.parseObject(ed, value));
		}
	}
	public static String getAsString(IEntity entity, IDataTypeParser unparser) {
		final EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		switch (ed.getDataKind()) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BOOLEAN:
			return unparser.unparseBoolean(ed, entity.wBooleanValue());
		case BYTE:
			return unparser.unparseByte(ed, entity.wByteValue());
		case CHAR:
			return unparser.unparseChar(ed, entity.wCharValue());
		case DOUBLE:
			return unparser.unparseDouble(ed, entity.wDoubleValue());
		case FLOAT:
			return unparser.unparseFloat(ed, entity.wFloatValue());
		case INT:
			return unparser.unparseInt(ed, entity.wIntValue());
		case LONG:
			return unparser.unparseLong(ed, entity.wLongValue());
		case SHORT:
			return unparser.unparseShort(ed, entity.wShortValue());
		case STRING:
			return unparser.unparseString(ed, entity.wStringValue());
		case DATE:
			return unparser.unparseDate(ed, entity.wDateValue());
		case ENUM_VALUE:
			return unparser.unparseEnumValue(ed, entity.wEnumValue());
		case OBJECT:
		default:
			return unparser.unparseObject(ed, entity.wGetValue());
		}
	}
	public static void buildFromPersistenceString(IBuilder builder, EntityDescriptor<?> ed, String value) {
		IDataTypeParser parser = getDataTypeParser(ed, DataTypeParsers.PERSISTENCE);
		buildFromString(builder, ed, value, parser);
	}
	public static void buildFromPresentationString(IBuilder builder, EntityDescriptor<?> ed, String value) {
		IDataTypeParser parser = getDataTypeParser(ed, DataTypeParsers.PRESENTATION);
		buildFromString(builder, ed, value, parser);
	}
	public static void buildFromString(IBuilder builder, EntityDescriptor<?> ed, String value, IDataTypeParser parser) {
		switch (ed.getDataKind()) {
		case BOOLEAN:
			builder.wEntity(ed, parser.parseBoolean(ed, value));
			break;
		case BYTE:
			builder.wEntity(ed, parser.parseByte(ed, value));
			break;
		case CHAR:
			builder.wEntity(ed, parser.parseChar(ed, value));
			break;
		case DOUBLE:
			builder.wEntity(ed, parser.parseDouble(ed, value));
			break;
		case FLOAT:
			builder.wEntity(ed, parser.parseFloat(ed, value));
			break;
		case INT:
			builder.wEntity(ed, parser.parseInt(ed, value));
			break;
		case LONG:
			builder.wEntity(ed, parser.parseLong(ed, value));
			break;
		case SHORT:
			builder.wEntity(ed, parser.parseShort(ed, value));
			break;
		case STRING:
			builder.wEntity(ed, parser.parseString(ed, value));
			break;
		case DATE:
			builder.wEntity(ed, parser.parseDate(ed, value));
			break;
		case ENUM_VALUE:
			builder.wEntity(ed, parser.parseEnumValue(ed, value));
			break;
		case OBJECT:
		default:
			builder.wEntity(ed, parser.parseObject(ed, value));
		}
	}


	private static Map<Class<?>, Class<?>> wrapperClassesMap;
	private static Map<Class<?>, Class<?>> wrapperClassesMap() {
		if (wrapperClassesMap == null) {
			wrapperClassesMap = new HashMap<Class<?>, Class<?>>();
			wrapperClassesMap.put(Boolean.class, boolean.class);
			wrapperClassesMap.put(Byte.class, byte.class);
			wrapperClassesMap.put(Character.class, char.class);
			wrapperClassesMap.put(Double.class, double.class);
			wrapperClassesMap.put(Float.class, float.class);
			wrapperClassesMap.put(Integer.class, int.class);
			wrapperClassesMap.put(Long.class, long.class);
			wrapperClassesMap.put(Short.class, short.class);
		}
		return wrapperClassesMap;
	}
	public static boolean isWrapper(Class<?> dataType) {
		return wrapperClassesMap().containsKey(dataType);
	}
	public static Class<?> unboxFilter(Class<?> dataType) {
		Class<?> result = wrapperClassesMap().get(dataType);
		return result != null ? result : dataType;
	}

	private static Map<Class<?>, DataKinds> dataTypesMap;
	public static Map<Class<?>, DataKinds> dataTypesMap() {
		if (dataTypesMap == null) {
			dataTypesMap = new HashMap<Class<?>, DataKinds>();
			dataTypesMap.put(boolean.class, DataKinds.BOOLEAN);
	    	dataTypesMap.put(byte.class, DataKinds.BYTE);
	    	dataTypesMap.put(char.class, DataKinds.CHAR);
	    	dataTypesMap.put(double.class, DataKinds.DOUBLE);
	    	dataTypesMap.put(float.class, DataKinds.FLOAT);
	    	dataTypesMap.put(int.class, DataKinds.INT);
	    	dataTypesMap.put(long.class, DataKinds.LONG);
	    	dataTypesMap.put(short.class, DataKinds.SHORT);
	    	dataTypesMap.put(String.class, DataKinds.STRING);
	    	dataTypesMap.put(java.util.Date.class, DataKinds.DATE);
	    	dataTypesMap.put(EnumValue.class, DataKinds.ENUM_VALUE);
		}
		return dataTypesMap;
	}
	private static Map<Class<?>, DataKinds> unboxedDataTypesMap;
	public static Map<Class<?>, DataKinds> unboxedDataTypesMap() {
		if (unboxedDataTypesMap == null) {
			unboxedDataTypesMap = new HashMap<Class<?>, DataKinds>();
			unboxedDataTypesMap.put(boolean.class, DataKinds.BOOLEAN);
	    	unboxedDataTypesMap.put(byte.class, DataKinds.BYTE);
	    	unboxedDataTypesMap.put(char.class, DataKinds.CHAR);
	    	unboxedDataTypesMap.put(double.class, DataKinds.DOUBLE);
	    	unboxedDataTypesMap.put(float.class, DataKinds.FLOAT);
	    	unboxedDataTypesMap.put(int.class, DataKinds.INT);
	    	unboxedDataTypesMap.put(long.class, DataKinds.LONG);
	    	unboxedDataTypesMap.put(short.class, DataKinds.SHORT);
	    	unboxedDataTypesMap.put(Boolean.class, DataKinds.BOOLEAN);
	    	unboxedDataTypesMap.put(Byte.class, DataKinds.BYTE);
	    	unboxedDataTypesMap.put(Character.class, DataKinds.CHAR);
	    	unboxedDataTypesMap.put(Double.class, DataKinds.DOUBLE);
	    	unboxedDataTypesMap.put(Float.class, DataKinds.FLOAT);
	    	unboxedDataTypesMap.put(Integer.class, DataKinds.INT);
	    	unboxedDataTypesMap.put(Long.class, DataKinds.LONG);
	    	unboxedDataTypesMap.put(Short.class, DataKinds.SHORT);
	    	unboxedDataTypesMap.put(String.class, DataKinds.STRING);
	    	unboxedDataTypesMap.put(java.util.Date.class, DataKinds.DATE);
	    	unboxedDataTypesMap.put(EnumValue.class, DataKinds.ENUM_VALUE);
		}
		return unboxedDataTypesMap;
	}

	public static final DataKinds getDataKind(IEntity entity) {
		return entity.wGetAdaptee(false).wGetEntityDescriptor().getDataKind();
	}
	public static final DataKinds toDataKind(Object value) {
		return value != null ? toDataKind(value.getClass()) : DataKinds.OBJECT;
	}
	public static final DataKinds toDataKind(Class<?> dataType) {
		DataKinds result = dataTypesMap().get(dataType);
		if (result == null)
			if (EnumValue.class.isAssignableFrom(dataType))
				return DataKinds.ENUM_VALUE;
			else
				return DataKinds.OBJECT;
		return result; 
	}

	public static final DataKinds getUnboxedDataKind(IEntity entity) {
		EntityDescriptor<?> ed = entity.wGetEntityDescriptor();
		DataKinds dataKind = ed.getDataKind();
		if (dataKind.isObject())
			return toUnboxedDataKind(ed.getDataType());
		else
			return dataKind;
	}
	public static final DataKinds toUnboxedDataKind(IEntity entity) {
		return toUnboxedDataKind(entity.wGetEntityDescriptor());
	}
	public static final DataKinds toUnboxedDataKind(EntityDescriptor<?> ed) {
		Class<?> dataType = ed.getDataType();
		return dataType != null ? toUnboxedDataKind(dataType) : DataKinds.NOT_A_DATA;
	}
	public static final DataKinds toUnboxedDataKind(Object value) {
		return value != null ? toUnboxedDataKind(value.getClass()) : DataKinds.OBJECT;
	}
	public static final DataKinds toUnboxedDataKind(Class<?> dataType) {
		DataKinds result = unboxedDataTypesMap().get(dataType);
		if (result == null)
			if (EnumValue.class.isAssignableFrom(dataType))
				return DataKinds.ENUM_VALUE;
			else
				return DataKinds.OBJECT;
		return result;
	}

	public static Map<Class<?>, Set<Class<?>>> wideningMap = new HashMap<Class<?>, Set<Class<?>>>();
	static {
		Set<Class<?>> wideningSet = new HashSet<Class<?>>();
		wideningSet.add(double.class);
		wideningMap.put(double.class, wideningSet);

		wideningSet = new HashSet<Class<?>>(wideningSet);
		wideningSet.add(float.class);
		wideningMap.put(float.class, wideningSet);

		wideningSet = new HashSet<Class<?>>(wideningSet);
		wideningSet.add(long.class);
		wideningMap.put(long.class, wideningSet);

		wideningSet = new HashSet<Class<?>>(wideningSet);
		wideningSet.add(int.class);
		wideningMap.put(int.class, wideningSet);

		wideningSet = new HashSet<Class<?>>(wideningSet);
		wideningSet.add(short.class);
		wideningMap.put(short.class, wideningSet);
		
		wideningSet = new HashSet<Class<?>>(wideningSet);
		wideningSet.add(byte.class);
		wideningMap.put(byte.class, wideningSet);
		
		wideningSet = new HashSet<Class<?>>();
		wideningSet.add(char.class);
		wideningMap.put(char.class, wideningSet);
	}
	public static boolean canWidenToType(Class<?> toWiden, Class<?> type) {
		Set<Class<?>> wideningSet = wideningMap.get(unboxFilter(toWiden));
		return wideningSet != null && wideningSet.contains(unboxFilter(type));
	}

	public static Object unbox(IEntity entity, Class<?> parameterType) {
		return unbox(entity, parameterType, true);
	}
	public static Object unbox(IEntity entity, Class<?> parameterType, boolean unboxResolver) {
//		if (EntityUtils.isResolver(entity) && !parameterType.isPrimitive()
//				&& !entity.wIsAdapter() && unboxResolver) //workaround isResolver of an adapter
//			return null;
//		else
		if (EntityUtils.isData(entity)) {
			Object value = entity.wGetValue();
			if (!toDataKind(parameterType).isReferenceKind())
				return canWidenToType(value.getClass(), parameterType) ?
						value : toPrimitiveType(value, parameterType);
			else if (value == null || parameterType.isInstance(value)) //unbox ALL null values of reference data entity kind ?!?
				return value;
		}
		if (parameterType.isInstance(entity))
			return entity;
		else
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);
	}
	public static IEntity box(Object value, EntityDescriptor<?> ed) {
		if (value == null) {
			if (EntityUtils.isResolver(ed) || CommonsEntityDescriptorEnum.Any.equals(ed))
				return CommonsEntityFactory.instance.createResolver();
			else if (ed.getDataKind().isReferenceKind())//isObject()) box ALL null values of reference data entity kind ?!?
				return GenericEntityFactory.instance.create(ed, (Object) null);
			else
				return CommonsEntityAdapterFactory.createResolver(ed);
		} else {
			if (EntityUtils.isData(ed)) {
				Class<?> returnType = ed.getDataType();
				if (!toDataKind(returnType).isReferenceKind())
					return GenericEntityFactory.instance.create(ed, toPrimitiveType(value, returnType));
				else if (returnType.isInstance(value))
					return GenericEntityFactory.instance.create(ed, value);
			}
			if (value instanceof IEntity && ed.isPlatformSupertypeOf(((IEntity) value).wGetEntityDescriptor()))
				return (IEntity) value;
			else if (CommonsEntityDescriptorEnum.Any.equals(ed))
				return BindingManagerFactory.instance.createSpecificValue(value);
			else
				throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);
		}
	}
	public static Object toPrimitiveType(IEntity entity, Class<?> primitiveType) {
		return toPrimitiveType(entity.wGetValue(), primitiveType);
	}
	public static Object toPrimitiveType(Object value, Class<?> primitiveType) {
		DataKinds dataKind = toUnboxedDataKind(primitiveType);
		if (toDataKind(value).equals(dataKind))
			return value;
		else
			switch (dataKind) {
			case BOOLEAN:
				return toBoolean(value);
			case BYTE:
				return toByte(value);
			case CHAR:
				return toChar(value);
			case DOUBLE:
				return toDouble(value);
			case FLOAT:
				return toFloat(value);
			case INT:
				return toInt(value);
			case LONG:
				return toLong(value);
			case SHORT:
				return toShort(value);
			default:
				if (primitiveType.isInstance(value))
					return value;
				else
					throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);
			}
	}

	public static String toString(IEntity entity) {
		return toString(entity, getDataKind(entity));
	}
	public static String toString(IEntity entity, DataKinds dataKind) {
		if (dataKind.isString())
			return entity.wStringValue();
		else
			return getAsPresentationString(entity);		
	}

	public static boolean toBoolean(IEntity entity) {
		return toBoolean(entity, getDataKind(entity));
	}
	public static boolean toBoolean(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BOOLEAN:
			return entity.wBooleanValue();
		case OBJECT:
			return toBoolean(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);
		}
	}
	public static boolean toBoolean(Object value) {
		return toBoolean(value, toUnboxedDataKind(value.getClass()));
	}
	public static boolean toBoolean(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BOOLEAN:
			return ((Boolean) value).booleanValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static byte toByte(IEntity entity) {
		return toByte(entity, getDataKind(entity));
	}
	public static byte toByte(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return entity.wByteValue();
		case CHAR:
			return (byte) entity.wCharValue();
		case DOUBLE:
			return (byte) entity.wDoubleValue();
		case FLOAT:
			return (byte) entity.wFloatValue();
		case INT:
			return (byte) entity.wIntValue();
		case LONG:
			return (byte) entity.wLongValue();
		case SHORT:
			return (byte) entity.wShortValue();
		case OBJECT:
			return toByte(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static byte toByte(Object value) {
		return toByte(value, toUnboxedDataKind(value.getClass()));
	}
	public static byte toByte(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return ((Byte) value).byteValue();
		case CHAR:
			return (byte) ((Character) value).charValue();
		case DOUBLE:
			return ((Double) value).byteValue();
		case FLOAT:
			return ((Float) value).byteValue();
		case INT:
			return ((Integer) value).byteValue();
		case LONG:
			return ((Long) value).byteValue();
		case SHORT:
			return ((Short) value).byteValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static char toChar(IEntity entity) {
		return toChar(entity, getDataKind(entity));
	}
	public static char toChar(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return (char) entity.wByteValue();
		case CHAR:
			return entity.wCharValue();
		case DOUBLE:
			return (char) entity.wDoubleValue();
		case FLOAT:
			return (char) entity.wFloatValue();
		case INT:
			return (char) entity.wIntValue();
		case LONG:
			return (char) entity.wLongValue();
		case SHORT:
			return (char) entity.wShortValue();
		case OBJECT:
			return toChar(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static char toChar(Object value) {
		return toChar(value, toUnboxedDataKind(value.getClass()));
	}
	public static char toChar(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return (char) ((Byte) value).byteValue();
		case CHAR:
			return ((Character) value).charValue();
		case DOUBLE:
			return (char) ((Double) value).doubleValue();
		case FLOAT:
			return (char) ((Float) value).floatValue();
		case INT:
			return (char) ((Integer) value).intValue();
		case LONG:
			return (char) ((Long) value).longValue();
		case SHORT:
			return (char) ((Short) value).shortValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static java.math.BigInteger toBigInteger(IEntity entity) {
		return toBigInteger(entity, getDataKind(entity));
	}
	public static java.math.BigInteger toBigInteger(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return java.math.BigInteger.valueOf(entity.wByteValue());
		case CHAR:
			return java.math.BigInteger.valueOf(entity.wCharValue());
		case DOUBLE:
			return java.math.BigInteger.valueOf((long) entity.wDoubleValue());
		case FLOAT:
			return java.math.BigInteger.valueOf((long) entity.wFloatValue());
		case INT:
			return java.math.BigInteger.valueOf(entity.wIntValue());
		case LONG:
			return java.math.BigInteger.valueOf(entity.wLongValue());
		case SHORT:
			return java.math.BigInteger.valueOf(entity.wShortValue());
		case OBJECT:
			return toBigInteger(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static java.math.BigInteger toBigInteger(Object value) {
		return toBigInteger(value, toUnboxedDataKind(value.getClass()));
	}
	public static java.math.BigInteger toBigInteger(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return java.math.BigInteger.valueOf(((Byte) value).byteValue());
		case CHAR:
			return java.math.BigInteger.valueOf(((Character) value).charValue());
		case DOUBLE:
			return java.math.BigInteger.valueOf((long) ((Double) value).doubleValue());
		case FLOAT:
			return java.math.BigInteger.valueOf((long) ((Float) value).floatValue());
		case INT:
			return java.math.BigInteger.valueOf(((Integer) value).intValue());
		case LONG:
			return java.math.BigInteger.valueOf(((Long) value).longValue());
		case SHORT:
			return java.math.BigInteger.valueOf(((Short) value).shortValue());
		case OBJECT:
			if (value instanceof java.math.BigInteger)
				return (java.math.BigInteger) value;
			else if (value instanceof java.math.BigDecimal)
				return ((java.math.BigDecimal) value).toBigInteger();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static java.math.BigDecimal toBigDecimal(IEntity entity) {
		return toBigDecimal(entity, getDataKind(entity));
	}
	public static java.math.BigDecimal toBigDecimal(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return java.math.BigDecimal.valueOf(entity.wByteValue());
		case CHAR:
			return java.math.BigDecimal.valueOf(entity.wCharValue());
		case DOUBLE:
			return java.math.BigDecimal.valueOf(entity.wDoubleValue());
		case FLOAT:
			return java.math.BigDecimal.valueOf(entity.wFloatValue());
		case INT:
			return java.math.BigDecimal.valueOf(entity.wIntValue());
		case LONG:
			return java.math.BigDecimal.valueOf(entity.wLongValue());
		case SHORT:
			return java.math.BigDecimal.valueOf(entity.wShortValue());
		case OBJECT:
			return toBigDecimal(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static java.math.BigDecimal toBigDecimal(Object value) {
		return toBigDecimal(value, toUnboxedDataKind(value.getClass()));
	}
	public static java.math.BigDecimal toBigDecimal(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return java.math.BigDecimal.valueOf(((Byte) value).byteValue());
		case CHAR:
			return java.math.BigDecimal.valueOf(((Character) value).charValue());
		case DOUBLE:
			return java.math.BigDecimal.valueOf(((Double) value).doubleValue());
		case FLOAT:
			return java.math.BigDecimal.valueOf(((Float) value).floatValue());
		case INT:
			return java.math.BigDecimal.valueOf(((Integer) value).intValue());
		case LONG:
			return java.math.BigDecimal.valueOf(((Long) value).longValue());
		case SHORT:
			return java.math.BigDecimal.valueOf(((Short) value).shortValue());
		case OBJECT:
			if (value instanceof java.math.BigDecimal)
				return (java.math.BigDecimal) value;
			else if (value instanceof java.math.BigInteger)
				return new java.math.BigDecimal((java.math.BigInteger) value);
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static double toDouble(IEntity entity) {
		return toDouble(entity, getDataKind(entity));
	}
	public static double toDouble(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return entity.wByteValue();
		case CHAR:
			return entity.wCharValue();
		case DOUBLE:
			return entity.wDoubleValue();
		case FLOAT:
			return entity.wFloatValue();
		case INT:
			return entity.wIntValue();
		case LONG:
			return entity.wLongValue();
		case SHORT:
			return entity.wShortValue();
		case OBJECT:
			return toDouble(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static double toDouble(Object value) {
		return toDouble(value, toUnboxedDataKind(value.getClass()));
	}
	public static double toDouble(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return ((Byte) value).byteValue();
		case CHAR:
			return ((Character) value).charValue();
		case DOUBLE:
			return ((Double) value).doubleValue();
		case FLOAT:
			return ((Float) value).floatValue();
		case INT:
			return ((Integer) value).intValue();
		case LONG:
			return ((Long) value).longValue();
		case SHORT:
			return ((Short) value).shortValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static float toFloat(IEntity entity) {
		return toFloat(entity, getDataKind(entity));
	}
	public static float toFloat(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return entity.wByteValue();
		case CHAR:
			return entity.wCharValue();
		case DOUBLE:
			return (float) entity.wDoubleValue();
		case FLOAT:
			return entity.wFloatValue();
		case INT:
			return entity.wIntValue();
		case LONG:
			return entity.wLongValue();
		case SHORT:
			return entity.wShortValue();
		case OBJECT:
			return toFloat(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static float toFloat(Object value) {
		return toFloat(value, toUnboxedDataKind(value.getClass()));
	}
	public static float toFloat(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return ((Byte) value).byteValue();
		case CHAR:
			return ((Character) value).charValue();
		case DOUBLE:
			return ((Double) value).floatValue();
		case FLOAT:
			return ((Float) value).floatValue();
		case INT:
			return ((Integer) value).intValue();
		case LONG:
			return ((Long) value).longValue();
		case SHORT:
			return ((Short) value).shortValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static int toInt(IEntity entity) {
		return toInt(entity, getDataKind(entity));
	}
	public static int toInt(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return entity.wByteValue();
		case CHAR:
			return entity.wCharValue();
		case DOUBLE:
			return (int) entity.wDoubleValue();
		case FLOAT:
			return (int) entity.wFloatValue();
		case INT:
			return entity.wIntValue();
		case LONG:
			return (int) entity.wLongValue();
		case SHORT:
			return entity.wShortValue();
		case OBJECT:
			return toInt(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static int toInt(Object value) {
		return toInt(value, toUnboxedDataKind(value.getClass()));
	}
	public static int toInt(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return ((Byte) value).byteValue();
		case CHAR:
			return ((Character) value).charValue();
		case DOUBLE:
			return ((Double) value).intValue();
		case FLOAT:
			return ((Float) value).intValue();
		case INT:
			return ((Integer) value).intValue();
		case LONG:
			return ((Long) value).intValue();
		case SHORT:
			return ((Short) value).shortValue();			
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static long toLong(IEntity entity) {
		return toLong(entity, getDataKind(entity));
	}
	public static long toLong(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return entity.wByteValue();
		case CHAR:
			return entity.wCharValue();
		case DOUBLE:
			return (long) entity.wDoubleValue();
		case FLOAT:
			return (long) entity.wFloatValue();
		case INT:
			return entity.wIntValue();
		case LONG:
			return entity.wLongValue();
		case SHORT:
			return entity.wShortValue();
		case OBJECT:
			return toLong(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static long toLong(Object value) {
		return toLong(value, toUnboxedDataKind(value.getClass()));
	}
	public static long toLong(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return ((Byte) value).byteValue();
		case CHAR:
			return ((Character) value).charValue();
		case DOUBLE:
			return ((Double) value).longValue();
		case FLOAT:
			return ((Float) value).longValue();
		case INT:
			return ((Integer) value).intValue();
		case LONG:
			return ((Long) value).longValue();
		case SHORT:
			return ((Short) value).shortValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}

	public static short toShort(IEntity entity) {
		return toShort(entity, getDataKind(entity));
	}
	public static short toShort(IEntity entity, DataKinds dataKind) {
		switch (dataKind) {
		case NOT_A_DATA:
			throw new WholeIllegalArgumentException(WholeMessages.no_data);
		case BYTE:
			return (short) entity.wByteValue();
		case CHAR:
			return (short) entity.wCharValue();
		case DOUBLE:
			return (short) entity.wDoubleValue();
		case FLOAT:
			return (short) entity.wFloatValue();
		case INT:
			return (short) entity.wIntValue();
		case LONG:
			return (short) entity.wLongValue();
		case SHORT:
			return entity.wShortValue();
		case OBJECT:
			return toShort(entity.wGetValue());
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
	public static short toShort(Object value) {
		return toShort(value, toUnboxedDataKind(value.getClass()));
	}
	public static short toShort(Object value, DataKinds unboxedDataKind) {
		switch (unboxedDataKind) {
		case BYTE:
			return ((Byte) value).shortValue();
		case CHAR:
			return (short) ((Character) value).charValue();
		case DOUBLE:
			return ((Double) value).shortValue();
		case FLOAT:
			return ((Float) value).shortValue();
		case INT:
			return ((Integer) value).shortValue();
		case LONG:
			return ((Long) value).shortValue();
		case SHORT:
			return ((Short) value).shortValue();
		default:
			throw new WholeIllegalArgumentException(WholeMessages.illegal_data_conversion);		
		}
	}
}
