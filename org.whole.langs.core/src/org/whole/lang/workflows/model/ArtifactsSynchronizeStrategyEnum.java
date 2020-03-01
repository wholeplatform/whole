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
public class ArtifactsSynchronizeStrategyEnum extends EnumType<ArtifactsSynchronizeStrategyEnum.Value> {
    public static final int REMOVE_ADD_UPDATE_ord = 0;
    public static final int ADD_UPDATE_ord = 1;
    public static final int UPDATE_ord = 2;
    public static final ArtifactsSynchronizeStrategyEnum instance = new ArtifactsSynchronizeStrategyEnum();
    public static final Value REMOVE_ADD_UPDATE = instance.valueOf(REMOVE_ADD_UPDATE_ord);
    public static final Value ADD_UPDATE = instance.valueOf(ADD_UPDATE_ord);
    public static final Value UPDATE = instance.valueOf(UPDATE_ord);

    private ArtifactsSynchronizeStrategyEnum() {
        enumValue(REMOVE_ADD_UPDATE_ord, "REMOVE_ADD_UPDATE");
        enumValue(ADD_UPDATE_ord, "ADD_UPDATE");
        enumValue(UPDATE_ord, "UPDATE");
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
