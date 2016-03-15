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
package org.whole.lang.bindings;

import java.util.Date;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

import org.whole.lang.model.EnumValue;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractScope extends AbstractCloneableScope {
	public Kind getKind() {
		return Kind.SCOPE;
	}

	public Set<String> wNames() {
		Set<String> nameSet = wEnclosingScope().wNames();
		nameSet.addAll(wLocalNames());
		return nameSet;
	}

	public void wAddAll(IBindingScope scope) {
		if (scope == NullScope.instance)
			return;
		Set<String> names = scope.wEnclosingScope() == this || scope.wEnclosingScope() == NullScope.instance ?
				scope.wLocalNames() :
				scope.wNames();
		for (String name : names)
			wDef(name, scope.wGet(name));
	}

	public boolean wBooleanValue(String name) {
		try {
			return wGet(name).wBooleanValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public byte wByteValue(String name) {
		try {
			return wGet(name).wByteValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public char wCharValue(String name) {
		try {
			return wGet(name).wCharValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public double wDoubleValue(String name) {
		try {
			return wGet(name).wDoubleValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public float wFloatValue(String name) {
		try {
			return wGet(name).wFloatValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public int wIntValue(String name) {
		try {
			return wGet(name).wIntValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public long wLongValue(String name) {
		try {
			return wGet(name).wLongValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public short wShortValue(String name) {
		try {
			return wGet(name).wShortValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public String wStringValue(String name) {
		try {
			return wGet(name).wStringValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public Date wDateValue(String name) {
		try {
			return wGet(name).wDateValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public EnumValue wEnumValue(String name) {
		try {
			IEntity e = wGet(name);
			if (DataTypeUtils.getDataKind(e).isEnumValue())
				return e.wEnumValue();
			else
				return (EnumValue) e.wGetValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}
	public Object wGetValue(String name) {
		try {
			return wGet(name).wGetValue();
		} catch (NullPointerException e) {
			throw BindingManagerFactory.instance.createNoBindingException(name);
		}
	}

	public void wSetValue(String name, boolean value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, byte value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, char value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, double value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, float value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, int value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, long value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, short value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, String value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, Date value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, EnumValue value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wSetValue(String name, Object value) {
		wSet(name, BindingManagerFactory.instance.createValue(value));
	}
	
	public void wDefValue(String name, boolean value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, byte value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, char value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, double value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, float value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, int value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, long value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, short value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, String value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, Date value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, EnumValue value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}
	public void wDefValue(String name, Object value) {
		wDef(name, BindingManagerFactory.instance.createValue(value));
	}

	public static void toString(StringBuilder sb, SortedMap<String, IEntity> treeMap) {
		for (Entry<String, IEntity> entry : treeMap.entrySet()) {
			toString(sb, entry.getKey(), entry.getValue());
		}
	}
	public static void toString(StringBuilder sb, IBindingScope scope, Set<String> names) {
		for (String name : names)
			toString(sb, name, scope.wGet(name));
	}
	public static void toString(StringBuilder sb, String name, IEntity value) {
		sb.append(value.wGetEntityDescriptor().getName());
		sb.append(' ');
		sb.append(name);
		String valueString = value.toString();
		final int MAX_LENGTH = 512;
		final int MAX_LINES = 8;
		boolean isTruncated = valueString.length() > MAX_LENGTH;
		if (isTruncated)
			valueString = valueString.substring(0, MAX_LENGTH);

		int endIndex=0, i=0;
		for (; i<MAX_LINES && endIndex>=0; i++)
			endIndex = valueString.indexOf('\n', endIndex+1);

		sb.append(i == 1 ? " = " : " =\n");
		sb.append(endIndex == -1 ? valueString : valueString.substring(0, endIndex));

		sb.append(isTruncated ? " (...)\n" : "\n");
	}
}
