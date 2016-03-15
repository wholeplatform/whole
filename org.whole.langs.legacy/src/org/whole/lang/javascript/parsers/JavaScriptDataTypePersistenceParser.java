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
package org.whole.lang.javascript.parsers;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.javascript.model.AssignmentOperatorEnum;
import org.whole.lang.javascript.model.InfixOperatorEnum;
import org.whole.lang.javascript.model.PostfixOperatorEnum;
import org.whole.lang.javascript.model.PrefixOperatorEnum;
import org.whole.lang.javascript.model.XmlMemberOperatorEnum;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Enrico Persiani
 */
public class JavaScriptDataTypePersistenceParser extends DefaultDataTypePersistenceParser {
	private static class SingletonHolder {
		private static final JavaScriptDataTypePersistenceParser instance = new JavaScriptDataTypePersistenceParser();
	}
	public static JavaScriptDataTypePersistenceParser instance() {
		return SingletonHolder.instance;
	}
	protected JavaScriptDataTypePersistenceParser() {
	}

	@Override
	public double parseDouble(EntityDescriptor<?> ed, String value) {
		//TODO ?
		return super.parseDouble(ed, value);
	}
	@Override
	public String unparseDouble(EntityDescriptor<?> ed, double value) {
		if (Math.rint(value) == value)
			return Long.toString(Math.round(value));
		else
			return super.unparseDouble(ed, value);
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumValue enumValue = null;
		switch (ed.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.AssignmentOperator_ord:
			enumValue = parseAssignmentOperator(value);
			break;
		case JavaScriptEntityDescriptorEnum.InfixOperator_ord:
			enumValue = parseInfixOperator(value);
			break;
		case JavaScriptEntityDescriptorEnum.PrefixOperator_ord:
			enumValue = parsePrefixOperator(value);
			break;
		case JavaScriptEntityDescriptorEnum.PostfixOperator_ord:
			enumValue = parsePostfixOperator(value);
			break;
		case JavaScriptEntityDescriptorEnum.XmlMemberOperator_ord:
			enumValue = parseXmlMemberOperator(value);
			break;
		}
		if (enumValue != null)
			return enumValue;
		else
			return super.parseEnumValue(ed, value);			
	}
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		switch (ed.getOrdinal()) {
		case JavaScriptEntityDescriptorEnum.AssignmentOperator_ord:
			return unparseAssignmentOperator(value);
		case JavaScriptEntityDescriptorEnum.InfixOperator_ord:
			return unparseInfixOperator(value);
		case JavaScriptEntityDescriptorEnum.PrefixOperator_ord:
			return unparsePrefixOperator(value);
		case JavaScriptEntityDescriptorEnum.PostfixOperator_ord:
			return unparsePostfixOperator(value);
		case JavaScriptEntityDescriptorEnum.XmlMemberOperator_ord:
			return unparseXmlMemberOperator(value);
		default:
			return super.unparseEnumValue(ed, value);
		}
	}

	public static final String unparseAssignmentOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case AssignmentOperatorEnum.assign_ord:
    		return "=";
    	case AssignmentOperatorEnum.plus_assign_ord:
    		return "+=";
    	case AssignmentOperatorEnum.minus_assign_ord:
    		return "-=";
    	case AssignmentOperatorEnum.times_assign_ord:
    		return "*=";
    	case AssignmentOperatorEnum.divide_assign_ord:
    		return "/=";
    	case AssignmentOperatorEnum.bit_and_assign_ord:
    		return "&=";
    	case AssignmentOperatorEnum.bit_or_assign_ord:
    		return "|=";
    	case AssignmentOperatorEnum.bit_xor_assign_ord:
    		return "^=";
    	case AssignmentOperatorEnum.remainder_assign_ord:
    		return "%=";
    	case AssignmentOperatorEnum.left_shift_assign_ord:
    		return "<<=";
    	case AssignmentOperatorEnum.right_shift_signed_assign_ord:
    		return ">>=";
    	case AssignmentOperatorEnum.right_shift_unsigned_assign_ord:
    		return ">>>=";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	public static final String unparseInfixOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case InfixOperatorEnum.times_ord:
    		return "*";
    	case InfixOperatorEnum.divide_ord:
    		return "/";
    	case InfixOperatorEnum.remainder_ord:
    		return "%";
    	case InfixOperatorEnum.plus_ord:
    		return "+";
    	case InfixOperatorEnum.minus_ord:
    		return "-";
    	case InfixOperatorEnum.left_shift_ord:
    		return "<<";
    	case InfixOperatorEnum.right_shift_signed_ord:
    		return ">>";
    	case InfixOperatorEnum.right_shift_unsigned_ord:
    		return ">>>";
    	case InfixOperatorEnum.less_ord:
    		return "<";
    	case InfixOperatorEnum.greater_ord:
    		return ">";
    	case InfixOperatorEnum.less_equals_ord:
    		return "<=";
    	case InfixOperatorEnum.greater_equals_ord:
    		return ">=";
    	case InfixOperatorEnum.equals_ord:
    		return "==";
    	case InfixOperatorEnum.not_equals_ord:
    		return "!=";
    	case InfixOperatorEnum.shallow_equals_ord:
    		return "===";
    	case InfixOperatorEnum.shallow_not_equals_ord:
    		return "!==";
    	case InfixOperatorEnum.xor_ord:
    		return "^";
    	case InfixOperatorEnum.or_ord:
    		return "|";
    	case InfixOperatorEnum.and_ord:
    		return "&";
    	case InfixOperatorEnum._instanceof_ord:
    		return "instanceof";
    	case InfixOperatorEnum.in_ord:
    		return "int";
    	case InfixOperatorEnum.conditional_or_ord:
    		return "||";
    	case InfixOperatorEnum.conditional_and_ord:
    		return "&&";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	public static final String unparsePrefixOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case PrefixOperatorEnum.increment_ord:
    		return "++";
    	case PrefixOperatorEnum.decrement_ord:
    		return "--";
    	case PrefixOperatorEnum.plus_ord:
    		return "+";
    	case PrefixOperatorEnum.minus_ord:
    		return "-";
    	case PrefixOperatorEnum.complement_ord:
    		return "~";
    	case PrefixOperatorEnum.not_ord:
    		return "!";
    	case PrefixOperatorEnum.typeof_ord:
    		return "typeof";
    	case PrefixOperatorEnum._void_ord:
    		return "void";
    	case PrefixOperatorEnum.delete_ord:
    		return "delete";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	public static final String unparsePostfixOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case PostfixOperatorEnum.increment_ord:
    		return "++";
    	case PostfixOperatorEnum.decrement_ord:
    		return "--";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	public static final String unparseXmlMemberOperator(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case XmlMemberOperatorEnum.dot_ord:
    		return ".";
    	case XmlMemberOperatorEnum.dotdot_ord:
    		return "..";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	private static volatile Map<String, AssignmentOperatorEnum.Value> assignmentOperatorMap;
	public static final AssignmentOperatorEnum.Value parseAssignmentOperator(String value) {
		if (assignmentOperatorMap == null) {
			synchronized (JavaScriptDataTypePersistenceParser.class) {
				if (assignmentOperatorMap == null) {
					assignmentOperatorMap = new HashMap<String, AssignmentOperatorEnum.Value>();
		
					assignmentOperatorMap.put("=", AssignmentOperatorEnum.assign);
					assignmentOperatorMap.put("+=", AssignmentOperatorEnum.plus_assign);
					assignmentOperatorMap.put("-=", AssignmentOperatorEnum.minus_assign);
					assignmentOperatorMap.put("*=", AssignmentOperatorEnum.times_assign);
					assignmentOperatorMap.put("/=", AssignmentOperatorEnum.divide_assign);
					assignmentOperatorMap.put("&=", AssignmentOperatorEnum.bit_and_assign);
					assignmentOperatorMap.put("|=", AssignmentOperatorEnum.bit_or_assign);
					assignmentOperatorMap.put("^=", AssignmentOperatorEnum.bit_xor_assign);
					assignmentOperatorMap.put("%=", AssignmentOperatorEnum.remainder_assign);
					assignmentOperatorMap.put("<<=", AssignmentOperatorEnum.left_shift_assign);
					assignmentOperatorMap.put(">>=", AssignmentOperatorEnum.right_shift_signed_assign);
					assignmentOperatorMap.put(">>>=", AssignmentOperatorEnum.right_shift_unsigned_assign);
		
					assert AssignmentOperatorEnum.instance.size() == assignmentOperatorMap.size();
				}
			}
		}
		return assignmentOperatorMap.get(value);
	}
	private static volatile Map<String, InfixOperatorEnum.Value> infixOperatorMap;
	public static final InfixOperatorEnum.Value parseInfixOperator(String value) {
		if (infixOperatorMap == null) {
			synchronized (JavaScriptDataTypePersistenceParser.class) {
				if (infixOperatorMap == null) {
					infixOperatorMap = new HashMap<String, InfixOperatorEnum.Value>();
		
					infixOperatorMap.put("*", InfixOperatorEnum.times);
					infixOperatorMap.put("/", InfixOperatorEnum.divide);
					infixOperatorMap.put("%", InfixOperatorEnum.remainder);
					infixOperatorMap.put("+", InfixOperatorEnum.plus);
					infixOperatorMap.put("-", InfixOperatorEnum.minus);
					infixOperatorMap.put("<<", InfixOperatorEnum.left_shift);
					infixOperatorMap.put(">>", InfixOperatorEnum.right_shift_signed);
					infixOperatorMap.put(">>>", InfixOperatorEnum.right_shift_unsigned);
					infixOperatorMap.put("<", InfixOperatorEnum.less);
					infixOperatorMap.put(">", InfixOperatorEnum.greater);
					infixOperatorMap.put("<=", InfixOperatorEnum.less_equals);
					infixOperatorMap.put(">=", InfixOperatorEnum.greater_equals);
					infixOperatorMap.put("==", InfixOperatorEnum.equals);
					infixOperatorMap.put("!=", InfixOperatorEnum.not_equals);
					infixOperatorMap.put("===", InfixOperatorEnum.shallow_equals);
					infixOperatorMap.put("!==", InfixOperatorEnum.shallow_not_equals);
					infixOperatorMap.put("^", InfixOperatorEnum.xor);
					infixOperatorMap.put("|", InfixOperatorEnum.or);
					infixOperatorMap.put("&", InfixOperatorEnum.and);
					infixOperatorMap.put("in", InfixOperatorEnum.in);
					infixOperatorMap.put("instanceof", InfixOperatorEnum._instanceof);
					infixOperatorMap.put("||", InfixOperatorEnum.conditional_or);
					infixOperatorMap.put("&&", InfixOperatorEnum.conditional_and);
		
					assert InfixOperatorEnum.instance.size() == infixOperatorMap.size();
				}
			}
		}
		return infixOperatorMap.get(value);
	}
	private static volatile Map<String, PrefixOperatorEnum.Value> prefixOperatorMap;
	public static final PrefixOperatorEnum.Value parsePrefixOperator(String value) {
		if (prefixOperatorMap == null) {
			synchronized (JavaScriptDataTypePersistenceParser.class) {
				if (prefixOperatorMap == null) {
					prefixOperatorMap = new HashMap<String, PrefixOperatorEnum.Value>();
		
					prefixOperatorMap.put("++", PrefixOperatorEnum.increment);
					prefixOperatorMap.put("--", PrefixOperatorEnum.decrement);
					prefixOperatorMap.put("+", PrefixOperatorEnum.plus);
					prefixOperatorMap.put("-", PrefixOperatorEnum.minus);
					prefixOperatorMap.put("~", PrefixOperatorEnum.complement);
					prefixOperatorMap.put("!", PrefixOperatorEnum.not);
					prefixOperatorMap.put("typeof", PrefixOperatorEnum.typeof);
					prefixOperatorMap.put("void", PrefixOperatorEnum._void);
					prefixOperatorMap.put("delete", PrefixOperatorEnum.delete);
		
					assert PrefixOperatorEnum.instance.size() == prefixOperatorMap.size();
				}
			}
		}
		return prefixOperatorMap.get(value);
	}
	private static volatile Map<String, PostfixOperatorEnum.Value> postfixOperatorMap;
	public static final PostfixOperatorEnum.Value parsePostfixOperator(String value) {
		if (postfixOperatorMap == null) {
			synchronized (JavaScriptDataTypePersistenceParser.class) {
				if (postfixOperatorMap == null) {
					postfixOperatorMap = new HashMap<String, PostfixOperatorEnum.Value>();
		
					postfixOperatorMap.put("++", PostfixOperatorEnum.increment);
					postfixOperatorMap.put("--", PostfixOperatorEnum.decrement);
		
					assert PostfixOperatorEnum.instance.size() == postfixOperatorMap.size();
				}
			}
		}
		return postfixOperatorMap.get(value);
	}
	private static volatile Map<String, XmlMemberOperatorEnum.Value> xmlMemberOperatorMap;
	public static final XmlMemberOperatorEnum.Value parseXmlMemberOperator(String value) {
		if (xmlMemberOperatorMap == null) {
			synchronized (JavaScriptDataTypePersistenceParser.class) {
				if (xmlMemberOperatorMap == null) {
					xmlMemberOperatorMap = new HashMap<String, XmlMemberOperatorEnum.Value>();
		
					xmlMemberOperatorMap.put(".", XmlMemberOperatorEnum.dot);
					xmlMemberOperatorMap.put("..", XmlMemberOperatorEnum.dotdot);
		
					assert XmlMemberOperatorEnum.instance.size() == xmlMemberOperatorMap.size();
				}
			}
		}
		return xmlMemberOperatorMap.get(value);
	}
}
