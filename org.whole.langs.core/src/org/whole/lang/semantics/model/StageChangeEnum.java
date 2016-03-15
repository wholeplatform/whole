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
public class StageChangeEnum extends EnumType<StageChangeEnum.Value> {
    public static final int SAME_STAGE_ord = 0;
    public static final int STAGE_UP_ord = 1;
    public static final int STAGE_DOWN_ord = 2;
    public static final int STAGE_ZERO_ord = 3;
    public static final StageChangeEnum instance = new StageChangeEnum();
    public static final Value SAME_STAGE = instance.valueOf(SAME_STAGE_ord);
    public static final Value STAGE_UP = instance.valueOf(STAGE_UP_ord);
    public static final Value STAGE_DOWN = instance.valueOf(STAGE_DOWN_ord);
    public static final Value STAGE_ZERO = instance.valueOf(STAGE_ZERO_ord);

    private StageChangeEnum() {
        enumValue(SAME_STAGE_ord, "SAME_STAGE");
        enumValue(STAGE_UP_ord, "STAGE_UP");
        enumValue(STAGE_DOWN_ord, "STAGE_DOWN");
        enumValue(STAGE_ZERO_ord, "STAGE_ZERO");
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
