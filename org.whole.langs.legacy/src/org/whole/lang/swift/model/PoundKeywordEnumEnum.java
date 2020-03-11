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
public class PoundKeywordEnumEnum extends EnumType<PoundKeywordEnumEnum.Value> {
    public static final int PoundIf_ord = 0;
    public static final int PoundElseif_ord = 1;
    public static final int PoundElse_ord = 2;
    public static final PoundKeywordEnumEnum instance = new PoundKeywordEnumEnum();
    public static final Value PoundIf = instance.valueOf(PoundIf_ord);
    public static final Value PoundElseif = instance.valueOf(PoundElseif_ord);
    public static final Value PoundElse = instance.valueOf(PoundElse_ord);

    private PoundKeywordEnumEnum() {
        enumValue(PoundIf_ord, "PoundIf");
        enumValue(PoundElseif_ord, "PoundElseif");
        enumValue(PoundElse_ord, "PoundElse");
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
