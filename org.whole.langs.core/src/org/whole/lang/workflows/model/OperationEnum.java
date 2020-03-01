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
package org.whole.lang.workflows.model;

import org.whole.lang.model.EnumType;
import org.whole.lang.model.EnumValueImpl;

/**
 *  @generator Whole
 */
public class OperationEnum extends EnumType<OperationEnum.Value> {
    public static final int VALIDATOR_ord = 0;
    public static final int NORMALIZER_ord = 1;
    public static final int INTERPRETER_ord = 2;
    public static final int PRETTY_PRINTER_ord = 3;
    public static final int ARTIFACTS_GENERATOR_ord = 4;
    public static final int JAVA_COMPILER_ord = 5;
    public static final OperationEnum instance = new OperationEnum();
    public static final Value VALIDATOR = instance.valueOf(VALIDATOR_ord);
    public static final Value NORMALIZER = instance.valueOf(NORMALIZER_ord);
    public static final Value INTERPRETER = instance.valueOf(INTERPRETER_ord);
    public static final Value PRETTY_PRINTER = instance.valueOf(PRETTY_PRINTER_ord);
    public static final Value ARTIFACTS_GENERATOR = instance.valueOf(ARTIFACTS_GENERATOR_ord);
    public static final Value JAVA_COMPILER = instance.valueOf(JAVA_COMPILER_ord);

    private OperationEnum() {
        enumValue(VALIDATOR_ord, "VALIDATOR");
        enumValue(NORMALIZER_ord, "NORMALIZER");
        enumValue(INTERPRETER_ord, "INTERPRETER");
        enumValue(PRETTY_PRINTER_ord, "PRETTY_PRINTER");
        enumValue(ARTIFACTS_GENERATOR_ord, "ARTIFACTS_GENERATOR");
        enumValue(JAVA_COMPILER_ord, "JAVA_COMPILER");
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
