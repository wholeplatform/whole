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
package org.whole.lang.semantics.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class BindingOpEnum extends EnumType<BindingOpEnum.Value> {
    public static final int BIND_ord = 0;
    public static final int UNBIND_ord = 1;
    public static final int FRESH_BIND_ord = 2;
    public static final int MATCH_BIND_ord = 3;
    public static final BindingOpEnum instance = new BindingOpEnum();
    public static final Value BIND = instance.valueOf(BIND_ord);
    public static final Value UNBIND = instance.valueOf(UNBIND_ord);
    public static final Value FRESH_BIND = instance.valueOf(FRESH_BIND_ord);
    public static final Value MATCH_BIND = instance.valueOf(MATCH_BIND_ord);

    private BindingOpEnum() {
        enumValue(BIND_ord, "BIND");
        enumValue(UNBIND_ord, "UNBIND");
        enumValue(FRESH_BIND_ord, "FRESH_BIND");
        enumValue(MATCH_BIND_ord, "MATCH_BIND");
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
