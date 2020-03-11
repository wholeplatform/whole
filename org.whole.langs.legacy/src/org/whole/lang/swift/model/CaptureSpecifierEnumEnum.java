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
public class CaptureSpecifierEnumEnum extends EnumType<CaptureSpecifierEnumEnum.Value> {
    public static final int weak_ord = 0;
    public static final int unowned_ord = 1;
    public static final int unowned_safe__ord = 2;
    public static final int unowned_unsafe__ord = 3;
    public static final CaptureSpecifierEnumEnum instance = new CaptureSpecifierEnumEnum();
    public static final Value weak = instance.valueOf(weak_ord);
    public static final Value unowned = instance.valueOf(unowned_ord);
    public static final Value unowned_safe_ = instance.valueOf(unowned_safe__ord);
    public static final Value unowned_unsafe_ = instance.valueOf(unowned_unsafe__ord);

    private CaptureSpecifierEnumEnum() {
        enumValue(weak_ord, "weak");
        enumValue(unowned_ord, "unowned");
        enumValue(unowned_safe__ord, "unowned(safe)", "unowned_safe_");
        enumValue(unowned_unsafe__ord, "unowned(unsafe)", "unowned_unsafe_");
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
