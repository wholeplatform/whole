/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.swift.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class AccessorKindValueEnum extends EnumType<AccessorKindValueEnum.Value> {
    public static final int get_ord = 0;
    public static final int set_ord = 1;
    public static final int didSet_ord = 2;
    public static final int willSet_ord = 3;
    public static final int unsafeAddress_ord = 4;
    public static final int addressWithOwner_ord = 5;
    public static final int addressWithNativeOwner_ord = 6;
    public static final int unsafeMutableAddress_ord = 7;
    public static final int mutableAddressWithOwner_ord = 8;
    public static final int mutableAddressWithNativeOwner_ord = 9;
    public static final int _read_ord = 10;
    public static final int _modify_ord = 11;
    public static final AccessorKindValueEnum instance = new AccessorKindValueEnum();
    public static final Value get = instance.valueOf(get_ord);
    public static final Value set = instance.valueOf(set_ord);
    public static final Value didSet = instance.valueOf(didSet_ord);
    public static final Value willSet = instance.valueOf(willSet_ord);
    public static final Value unsafeAddress = instance.valueOf(unsafeAddress_ord);
    public static final Value addressWithOwner = instance.valueOf(addressWithOwner_ord);
    public static final Value addressWithNativeOwner = instance.valueOf(addressWithNativeOwner_ord);
    public static final Value unsafeMutableAddress = instance.valueOf(unsafeMutableAddress_ord);
    public static final Value mutableAddressWithOwner = instance.valueOf(mutableAddressWithOwner_ord);
    public static final Value mutableAddressWithNativeOwner = instance.valueOf(mutableAddressWithNativeOwner_ord);
    public static final Value _read = instance.valueOf(_read_ord);
    public static final Value _modify = instance.valueOf(_modify_ord);

    private AccessorKindValueEnum() {
        enumValue(get_ord, "get");
        enumValue(set_ord, "set");
        enumValue(didSet_ord, "didSet");
        enumValue(willSet_ord, "willSet");
        enumValue(unsafeAddress_ord, "unsafeAddress");
        enumValue(addressWithOwner_ord, "addressWithOwner");
        enumValue(addressWithNativeOwner_ord, "addressWithNativeOwner");
        enumValue(unsafeMutableAddress_ord, "unsafeMutableAddress");
        enumValue(mutableAddressWithOwner_ord, "mutableAddressWithOwner");
        enumValue(mutableAddressWithNativeOwner_ord, "mutableAddressWithNativeOwner");
        enumValue(_read_ord, "_read");
        enumValue(_modify_ord, "_modify");
    }
    private static final long serialVersionUID = 1;

    protected void enumValue(int ordinal, String name) {
        if (valueOf(name) == null)
            putEnumValue(new Value(ordinal, name));
    }

    protected void enumValue(int ordinal, String name, String implName) {
        if (valueOf(name) == null)
            putEnumValue(new Value(ordinal, name, implName));
    }

    public static class Value extends EnumValueImpl {
        private static final long serialVersionUID = 1;

        public Value() {
            super();
        }

        public Value(int ordinal, String name) {
            super(ordinal, name);
        }

        public Value(int ordinal, String name, String implName) {
            super(ordinal, name, implName);
        }
    }
}
