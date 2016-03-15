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
package org.whole.lang.math.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class ConstantEnum extends EnumType<ConstantEnum.Value> {
    public static final int pi_ord = 0;
    public static final int e_ord = 1;
    public static final int i_ord = 2;
    public static final int gamma_ord = 3;
    public static final int infinity_ord = 4;
    public static final ConstantEnum instance = new ConstantEnum();
    public static final Value pi = instance.valueOf(pi_ord);
    public static final Value e = instance.valueOf(e_ord);
    public static final Value i = instance.valueOf(i_ord);
    public static final Value gamma = instance.valueOf(gamma_ord);
    public static final Value infinity = instance.valueOf(infinity_ord);

    private ConstantEnum() {
        enumValue(pi_ord, "pi");
        enumValue(e_ord, "e");
        enumValue(i_ord, "i");
        enumValue(gamma_ord, "gamma");
        enumValue(infinity_ord, "infinity");
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
