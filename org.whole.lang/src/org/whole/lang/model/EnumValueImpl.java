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
package org.whole.lang.model;

import java.util.Comparator;

/**
 * @author Riccardo Solmi
 */
public class EnumValueImpl implements EnumValue {
	private static final long serialVersionUID = 1L;
	private final int ordinal;
    private final String name;
	private final String implName;
    
    // reserved to standard serialization
    public EnumValueImpl() {
    	this(0, null, null);
    }
    public EnumValueImpl(int ordinal, String name) {
        this(ordinal, name, name);
    }
    public EnumValueImpl(int ordinal, String name, String implName) {
        this.ordinal = ordinal;
        this.name = name;
    	this.implName = implName;
    }

//FIXME enumValue should be a singleton
//    public Object readResolve() throws ObjectStreamException {
//    	return getEnumType().wValueOf(ordinal);
//    }
//FIXME hashCode

    public final boolean equals(Object o) {
    	if (this == o)
    		return true;
    	if (o instanceof EnumValue) {
    		EnumValue other = (EnumValue) o;
    		return getEnumType().equals(other.getEnumType()) && getOrdinal() == other.getOrdinal();
    	}
    	return false;
    }
    public final int compareTo(EnumValue o) {
        return getOrdinal() - o.getOrdinal();
    }

    private EnumType<?> enumType;
    public EnumType<?> getEnumType() {
    	return enumType;
    }
    @SuppressWarnings("unchecked")
	protected <E extends EnumType<?>> E getEnumType(Class<E> enumClass) {
    	return (E) enumType;
    }
    public void setEnumType(EnumType<?> enumType) {
    	this.enumType = enumType;
    }

    public int getOrdinal() {
		return ordinal;
	}

	public String getName() {
		return name;
	}

	public String getImplName() {
		return implName;
	}

	public String toString() {
        return getName();
    }

    public static Comparator<EnumValue> getByNameComparator() {
    	return EnumValueNameComparator.instance();
    }
	private static final class EnumValueNameComparator implements Comparator<EnumValue> {
		private static class SingletonHolder {
			private static final EnumValueNameComparator instance = new EnumValueNameComparator();
		}
		public static EnumValueNameComparator instance() {
			return SingletonHolder.instance;
		}
		public int compare(EnumValue ed1, EnumValue ed2) {
			return ed1.getName().compareTo(ed2.getName());
		}
	}
}
