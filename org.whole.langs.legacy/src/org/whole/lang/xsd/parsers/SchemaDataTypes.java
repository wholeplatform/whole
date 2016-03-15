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
package org.whole.lang.xsd.parsers;

import static org.whole.lang.xsd.parsers.SchemaDataTypeParsers.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class SchemaDataTypes {
	private static final Map<String, String> builtInToDataTypeMap = new HashMap<String, String>();
	private static final Map<String, IDataTypeParser> builtInToDataTypeParserMap = new HashMap<String, IDataTypeParser>();

	private static void putMapping(String builtInType, String dataType) {
		putMapping(builtInType, dataType, null);
	}
	private static void putMapping(String builtInType, String dataType, IDataTypeParser dataTypeParser) {
		builtInToDataTypeMap.put(builtInType, dataType);
		if (dataTypeParser != null)
			builtInToDataTypeParserMap.put(builtInType, dataTypeParser);
	}

	static {
		// define data type mappings

		putMapping("anySimpleType",		"String");

		putMapping("boolean",			"boolean");
		putMapping("byte",				"byte");
		putMapping("short",				"short");
		putMapping("int",				"int");
		putMapping("long",				"long");
		putMapping("double",			"double");
		putMapping("float",				"float");

		putMapping("unsignedByte",		"short", unsignedByte());
		putMapping("unsignedShort",		"int", unsignedShort());
		putMapping("unsignedInt",		"long", unsignedInt());
		putMapping("unsignedLong",		"java.math.BigInteger", BigIntegerDataTypeParser.unsignedLongDataTypeParser());

		putMapping("integer",			"java.math.BigInteger", BigIntegerDataTypeParser.integerDataTypeParser());
		putMapping("positiveInteger",	"java.math.BigInteger", BigIntegerDataTypeParser.positiveIntegerDataTypeParser());
		putMapping("negativeInteger",	"java.math.BigInteger", BigIntegerDataTypeParser.negativeIntegerDataTypeParser());
		putMapping("nonNegativeInteger","java.math.BigInteger", BigIntegerDataTypeParser.nonNegativeIntegerDataTypeParser());
		putMapping("nonPositiveInteger","java.math.BigInteger", BigIntegerDataTypeParser.nonPositiveIntegerDataTypeParser());

		putMapping("decimal",			"java.math.BigDecimal", decimal());

		putMapping("dateTime",			"java.lang.Object", dateTime());
		putMapping("date",				"java.lang.Object", date());
		putMapping("time",				"java.lang.Object", time());
		putMapping("duration",			"java.lang.Object", duration());

		putMapping("gYearMonth",		"java.lang.Object", yearMonth());
		putMapping("gMonthDay",			"java.lang.Object", monthDay());
		putMapping("gYear",				"java.lang.Object", year());
		putMapping("gMonth",			"java.lang.Object", month());
		putMapping("gDay",				"java.lang.Object", day());

		putMapping("anyURI",			"String", anyURI());

		putMapping("base64Binary",		"java.lang.Object", base64Binary());
		putMapping("hexBinary",			"java.lang.Object", hexBinary());
		
		putMapping("QName",				"org.whole.lang.xml.util.QName", qname());
		putMapping("NOTATION",			"org.whole.lang.xml.util.QName", qname());

		putMapping("string",			"String", string());
		putMapping("normalizedString",	"String", normalizedString());
		putMapping("token",				"String", token());
		putMapping("language",			"String", language());
		putMapping("Name",				"String", name());
		putMapping("NMTOKEN",			"String", nmtoken());
		putMapping("NCName",			"String", ncname());
		putMapping("ID",				"String", ncname());
		putMapping("IDREF",				"String", ncname());
		putMapping("ENTITY",			"String", ncname());
	}

	private static final Map<String, String> dataTypeToBuiltInMap = new HashMap<String, String>();
	private static final Map<String, IDataTypeParser> dataTypeToBuiltInParserMap = new HashMap<String, IDataTypeParser>();

	private static void putInverseMapping(String dataType, String builtInType) {
		putInverseMapping(dataType, builtInType, null);
	}
	private static void putInverseMapping(String dataType, String builtInType, IDataTypeParser dataTypeParser) {
		dataTypeToBuiltInMap.put(dataType,  builtInType);
		if (dataTypeParser != null)
			dataTypeToBuiltInParserMap.put(dataType, dataTypeParser);
	}
	
	public static boolean hasDataType(String builtInType) {
		return builtInToDataTypeMap.keySet().contains(builtInType);
	}
	public static String getDataType(String builtInType) {
		return builtInToDataTypeMap.get(builtInType);
	}

	public static boolean hasDataTypeParser(String builtInType) {
		return builtInToDataTypeParserMap.keySet().contains(builtInType);
	}
	public static IDataTypeParser getDataTypeParser(String builtInType) {
		return builtInToDataTypeParserMap.get(builtInType);
	}

	static {
		// define inverse data type mappings

		putInverseMapping("boolean",	"boolean");
		putInverseMapping("byte",		"byte");
		putInverseMapping("short",		"short");
		putInverseMapping("int",		"int");
		putInverseMapping("long",		"long");
		putInverseMapping("double",		"double");
		putInverseMapping("float",		"float");

		putInverseMapping("String",		"string", string());

		putInverseMapping("java.math.BigInteger",	"integer", BigIntegerDataTypeParser.integerDataTypeParser());
		putInverseMapping("java.math.BigDecimal",	"decimal", decimal());

		putInverseMapping("org.whole.lang.xml.util.QName",	"QName" , qname());
	}

	public static boolean hasBuiltInType(String builtInType) {
		return dataTypeToBuiltInMap.keySet().contains(builtInType);
	}
	public static String getBuiltInType(String builtInType) {
		return dataTypeToBuiltInMap.get(builtInType);
	}

	public static boolean hasBuiltInTypeParser(String builtInType) {
		return dataTypeToBuiltInParserMap.keySet().contains(builtInType);
	}
	public static IDataTypeParser getBuiltInTypeParser(String builtInType) {
		return dataTypeToBuiltInParserMap.get(builtInType);
	}

	private static final String[] INTEGER_DERIVED_TYPES = new String[] {
		"integer", 
		"byte", "short", "int", "long",
		"unsignedLong", "unsignedInt", "unsignedShort", "unsignedByte",
		"positiveInteger", "negativeInteger", "nonNegativeInteger", "nonPositiveInteger"
	};
	private static final Set<String> integerDerivedTypes = new HashSet<String>(Arrays.asList(INTEGER_DERIVED_TYPES));
	private static final String[] STRING_DERIVED_TYPES = new String[] {
		"string", "normalizedString", "token",
		"language", "Name", "NMTOKEN",
		"NCName", "ID", "IDREF", "ENTITY"
	};
	private static final Set<String> stringDerivedTypes = new HashSet<String>(Arrays.asList(STRING_DERIVED_TYPES));
	private static final String[] LIST_DERIVED_TYPES = new String[] {
		"NMTOKENS", "IDREFS", "ENTITIES"
	};
	private static final Set<String> listDerivedTypes = new HashSet<String>(Arrays.asList(LIST_DERIVED_TYPES));

	public static boolean isIntegerDerived(String builtInType) {
		return integerDerivedTypes.contains(builtInType);
	}
	public static boolean isStringDerived(String builtInType) {
		return stringDerivedTypes.contains(builtInType);
	}
	public static boolean isListDerived(String builtInType) {
		return listDerivedTypes.contains(builtInType);
	}
	public static String getBuiltInComponentType(String builtInType) {
		return builtInType.substring(0, builtInType.length()-1);
	}

	public static boolean isId(String builtInType) {
		return "ID".equals(builtInType) || "IDREF".equals(builtInType) || "IDREFS".equals(builtInType);
	}
	private static final String[] PRIMITIVE_TYPES = new String[] {
		"boolean", "byte", "short", "int", "long", "double", "float", "anySimpleType"
	};
	private static final Set<String> primitiveTypes = new HashSet<String>(Arrays.asList(PRIMITIVE_TYPES));
	public static boolean isPrimitive(String builtInType) {
		return primitiveTypes.contains(builtInType);
	}
	public static boolean hasCustomDataType(String builtInType) {
		return !isListDerived(builtInType) && !isPrimitive(builtInType);
	}

	private static final Set<String> builtInTypes;
	static {
		Set<String> types = new HashSet<String>(builtInToDataTypeMap.keySet());
		types.addAll(listDerivedTypes);
		builtInTypes = Collections.unmodifiableSet(types);
	}
	public static Collection<String> getBuiltInTypes() {
		return builtInTypes;
	}
	public static boolean isBuiltIn(String type) {
		return getBuiltInTypes().contains(type);
	}

	private static final Map<String, String> builtInToEntityNameMap;
	private static final Map<String, String> entityNameMapToBuiltIn;
	static {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> inverseMap = new HashMap<String, String>();
		for (String builtIn : SchemaDataTypes.getBuiltInTypes()) {
			String entityName = "XS"+StringUtils.toUpperCap(builtIn);
			map.put(builtIn, entityName);
			inverseMap.put(entityName, builtIn);
		}
		builtInToEntityNameMap = Collections.unmodifiableMap(map);
		entityNameMapToBuiltIn = Collections.unmodifiableMap(inverseMap);
	}
	public static Map<String, String>  getEntityNameToBuiltInMap() {
		return entityNameMapToBuiltIn;
	}
	public static boolean isBuiltInEntityName(String entityName) {
		return entityNameMapToBuiltIn.containsKey(entityName);
	}
	public static String getBuiltInFromEntityName(String entityName) {
		return entityNameMapToBuiltIn.get(entityName);
	}
	public static Map<String, String> getBuiltInToEntityNameMap() {
		return builtInToEntityNameMap;
	}
	public static String getEntityNameFromBuiltIn(String builtInType) {
		return builtInToEntityNameMap.get(builtInType);
	}
}
