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

import java.util.HashMap;
import java.util.Map;

import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.FailureDataTypeParser;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Enrico Persiani
 */
public final class SchemaEnumDataTypeParser extends FailureDataTypeParser {
	private Map<String, EnumValue> toEnumValueMap;
	private Map<EnumValue, String> fromEnumValueMap;
	private EntityDescriptor<?> ed;

	public SchemaEnumDataTypeParser(EntityDescriptor<?> ed, Map<String, EnumValue> toEnumValueMap) {
		this.toEnumValueMap = new HashMap<String, EnumValue>(toEnumValueMap);
		this.fromEnumValueMap = new HashMap<EnumValue, String>();
		this.ed = ed;
		for (String value : toEnumValueMap.keySet())
			fromEnumValueMap.put(toEnumValueMap.get(value), value);
	}

	public EnumValue parseEnumValue(EntityDescriptor<?> ed, String value) {
		if (this.ed.equals(ed) && toEnumValueMap.containsKey(value))
			return toEnumValueMap.get(value);
		else
			return super.parseEnumValue(ed, value);
	}
	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		if (this.ed.equals(ed) && fromEnumValueMap.containsKey(value))
			return fromEnumValueMap.get(value);
		else
			return super.unparseEnumValue(ed, value);
	}
}
