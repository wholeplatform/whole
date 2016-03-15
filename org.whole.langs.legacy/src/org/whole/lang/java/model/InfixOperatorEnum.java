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
public class InfixOperatorEnum extends EnumType<InfixOperatorEnum.Value> {
    public static final int times_ord = 0;
    public static final int divide_ord = 1;
    public static final int remainder_ord = 2;
    public static final int plus_ord = 3;
    public static final int minus_ord = 4;
    public static final int left_shift_ord = 5;
    public static final int right_shift_signed_ord = 6;
    public static final int right_shift_unsigned_ord = 7;
    public static final int less_ord = 8;
    public static final int greater_ord = 9;
    public static final int less_equals_ord = 10;
    public static final int greater_equals_ord = 11;
    public static final int equals_ord = 12;
    public static final int not_equals_ord = 13;
    public static final int xor_ord = 14;
    public static final int or_ord = 15;
    public static final int and_ord = 16;
    public static final int conditional_or_ord = 17;
    public static final int conditional_and_ord = 18;
    public static final InfixOperatorEnum instance = new InfixOperatorEnum();
    public static final Value times = instance.valueOf(times_ord);
    public static final Value divide = instance.valueOf(divide_ord);
    public static final Value remainder = instance.valueOf(remainder_ord);
    public static final Value plus = instance.valueOf(plus_ord);
    public static final Value minus = instance.valueOf(minus_ord);
    public static final Value left_shift = instance.valueOf(left_shift_ord);
    public static final Value right_shift_signed = instance.valueOf(right_shift_signed_ord);
    public static final Value right_shift_unsigned = instance.valueOf(right_shift_unsigned_ord);
    public static final Value less = instance.valueOf(less_ord);
    public static final Value greater = instance.valueOf(greater_ord);
    public static final Value less_equals = instance.valueOf(less_equals_ord);
    public static final Value greater_equals = instance.valueOf(greater_equals_ord);
    public static final Value equals = instance.valueOf(equals_ord);
    public static final Value not_equals = instance.valueOf(not_equals_ord);
    public static final Value xor = instance.valueOf(xor_ord);
    public static final Value or = instance.valueOf(or_ord);
    public static final Value and = instance.valueOf(and_ord);
    public static final Value conditional_or = instance.valueOf(conditional_or_ord);
    public static final Value conditional_and = instance.valueOf(conditional_and_ord);

    private InfixOperatorEnum() {
        enumValue(times_ord, "times");
        enumValue(divide_ord, "divide");
        enumValue(remainder_ord, "remainder");
        enumValue(plus_ord, "plus");
        enumValue(minus_ord, "minus");
        enumValue(left_shift_ord, "left_shift");
        enumValue(right_shift_signed_ord, "right_shift_signed");
        enumValue(right_shift_unsigned_ord, "right_shift_unsigned");
        enumValue(less_ord, "less");
        enumValue(greater_ord, "greater");
        enumValue(less_equals_ord, "less_equals");
        enumValue(greater_equals_ord, "greater_equals");
        enumValue(equals_ord, "equals");
        enumValue(not_equals_ord, "not_equals");
        enumValue(xor_ord, "xor");
        enumValue(or_ord, "or");
        enumValue(and_ord, "and");
        enumValue(conditional_or_ord, "conditional_or");
        enumValue(conditional_and_ord, "conditional_and");
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
