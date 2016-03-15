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
package org.whole.lang.semantics.parsers;

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DefaultDataTypePersistenceParser;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.model.BindingOpEnum;
import org.whole.lang.semantics.model.StageChangeEnum;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class SemanticsDataTypePersistenceParser extends DefaultDataTypePersistenceParser {
	private static class SingletonHolder {
		private static final SemanticsDataTypePersistenceParser instance = new SemanticsDataTypePersistenceParser();
	}
	public static SemanticsDataTypePersistenceParser instance() {
		return SingletonHolder.instance;
	}
	protected SemanticsDataTypePersistenceParser() {
	}


	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		EnumValue enumValue = null;
		switch (ed.getOrdinal()) {
		case SemanticsEntityDescriptorEnum.BindingOp_ord:
			enumValue = parseBindingOp(value);
			break;
		case SemanticsEntityDescriptorEnum.StageChange_ord:
			enumValue = parseStateChange(value);
			break;
		}
		if (enumValue != null)
			return enumValue;
		else
			return super.parseEnumValue(ed, value);			
	}
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		switch (ed.getOrdinal()) {
		case SemanticsEntityDescriptorEnum.BindingOp_ord:
			return unparseBindingOp(value);
		case SemanticsEntityDescriptorEnum.StageChange_ord:
			return unparseStateChange(value);
		default:
			return super.unparseEnumValue(ed, value);
		}
	}

	private static volatile Map<String, BindingOpEnum.Value> bindingOpMap;
	public static final BindingOpEnum.Value parseBindingOp(String value) {
		if (bindingOpMap == null) {
			synchronized (SemanticsDataTypePersistenceParser.class) {
				if (bindingOpMap == null) {
					bindingOpMap = new HashMap<String, BindingOpEnum.Value>();
		
					bindingOpMap.put(" ", BindingOpEnum.BIND);
					bindingOpMap.put("+", BindingOpEnum.FRESH_BIND);
					bindingOpMap.put("-", BindingOpEnum.UNBIND);
					bindingOpMap.put("=", BindingOpEnum.MATCH_BIND);
		
					assert BindingOpEnum.instance.size() == bindingOpMap.size();
				}
			}
		}
		return bindingOpMap.get(value);
	}
	public static final String unparseBindingOp(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case BindingOpEnum.BIND_ord:
    		return " ";
    	case BindingOpEnum.UNBIND_ord:
    		return "-";
    	case BindingOpEnum.FRESH_BIND_ord:
    		return "+";
    	case BindingOpEnum.MATCH_BIND_ord:
    		return "=";
    	default:
    		throw new IllegalArgumentException();
    	}
	}

	private static volatile Map<String, StageChangeEnum.Value> stateChangeMap;
	public static final StageChangeEnum.Value parseStateChange(String value) {
		if (stateChangeMap == null) {
			synchronized (SemanticsDataTypePersistenceParser.class) {
				if (stateChangeMap == null) {
					stateChangeMap = new HashMap<String, StageChangeEnum.Value>();
		
					stateChangeMap.put("0", StageChangeEnum.SAME_STAGE);
					stateChangeMap.put("+1", StageChangeEnum.STAGE_UP);
					stateChangeMap.put("-1", StageChangeEnum.STAGE_DOWN);
					stateChangeMap.put("=0", StageChangeEnum.STAGE_ZERO);
		
					assert BindingOpEnum.instance.size() == stateChangeMap.size();
				}
			}
		}
		return stateChangeMap.get(value);
	}
	public static final String unparseStateChange(EnumValue value) {
    	switch (value.getOrdinal()) {
    	case StageChangeEnum.SAME_STAGE_ord:
    		return "0";
    	case StageChangeEnum.STAGE_UP_ord:
    		return "+1";
    	case StageChangeEnum.STAGE_DOWN_ord:
    		return "-1";
    	case StageChangeEnum.STAGE_ZERO_ord:
    		return "=0";
    	default:
    		throw new IllegalArgumentException();
    	}
	}
}
