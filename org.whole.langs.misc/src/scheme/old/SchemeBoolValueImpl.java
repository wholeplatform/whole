/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package scheme.old;

class SchemeBoolValueImpl extends SchemeValueImpl {
    private SchemeBoolValueImpl(boolean v) {
	value = v;
    }

    public static SchemeBoolValueImpl valueOf(boolean b) {
	if (b)
	    return TRUE;
	else
	    return FALSE;
    }

    public boolean isBool() {
	return true;
    }

    public boolean asBool() {
	return value;
    }
    
    public String toString() {
	if (value) return "#t";
	else return "#f";
    }

    private final boolean value;
    public static final SchemeBoolValueImpl TRUE = new SchemeBoolValueImpl(true);
    public static final SchemeBoolValueImpl FALSE = new SchemeBoolValueImpl(false);
}
