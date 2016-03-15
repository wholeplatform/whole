/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.java.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class ModifierEnum extends EnumType<ModifierEnum.Value> {
    public static final int _public_ord = 0;
    public static final int _protected_ord = 1;
    public static final int _private_ord = 2;
    public static final int _static_ord = 3;
    public static final int _abstract_ord = 4;
    public static final int _final_ord = 5;
    public static final int _native_ord = 6;
    public static final int _synchronized_ord = 7;
    public static final int _transient_ord = 8;
    public static final int _volatile_ord = 9;
    public static final int strictftp_ord = 10;
    public static final int _default_ord = 11;
    public static final ModifierEnum instance = new ModifierEnum();
    public static final Value _public = instance.valueOf(_public_ord);
    public static final Value _protected = instance.valueOf(_protected_ord);
    public static final Value _private = instance.valueOf(_private_ord);
    public static final Value _static = instance.valueOf(_static_ord);
    public static final Value _abstract = instance.valueOf(_abstract_ord);
    public static final Value _final = instance.valueOf(_final_ord);
    public static final Value _native = instance.valueOf(_native_ord);
    public static final Value _synchronized = instance.valueOf(_synchronized_ord);
    public static final Value _transient = instance.valueOf(_transient_ord);
    public static final Value _volatile = instance.valueOf(_volatile_ord);
    public static final Value strictftp = instance.valueOf(strictftp_ord);
    public static final Value _default = instance.valueOf(_default_ord);

    private ModifierEnum() {
        enumValue(_public_ord, "public", "_public");
        enumValue(_protected_ord, "protected", "_protected");
        enumValue(_private_ord, "private", "_private");
        enumValue(_static_ord, "static", "_static");
        enumValue(_abstract_ord, "abstract", "_abstract");
        enumValue(_final_ord, "final", "_final");
        enumValue(_native_ord, "native", "_native");
        enumValue(_synchronized_ord, "synchronized", "_synchronized");
        enumValue(_transient_ord, "transient", "_transient");
        enumValue(_volatile_ord, "volatile", "_volatile");
        enumValue(strictftp_ord, "strictftp");
        enumValue(_default_ord, "default", "_default");
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
