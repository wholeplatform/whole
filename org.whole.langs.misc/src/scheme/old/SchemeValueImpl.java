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

import java.util.List;

abstract class SchemeValueImpl implements SchemeValue {
    public boolean isBool() {
	return false;
    }

    public boolean isInt() {
	return false;
    }

    public boolean isString() {
	return false;
    }

    public boolean isPair() {
	return false;
    }

    public boolean asBool() throws SchemeException {
	throw new SchemeException("bool expected");
    }

    public int asInt() throws SchemeException {
	throw new SchemeException("int expected");
    }

    public String asString() throws SchemeException {
	throw new SchemeException("string expected");
    }

    public SchemePairValue asPair() throws SchemeException {
	throw new SchemeException("pair expected");
    }

    public abstract String toString();

    public static String toString(SchemeValue v) {
	if (v == null)
	    return "()";
	else
	    return v.toString();
    }

    public SchemeValue apply(List args) throws SchemeException {
	throw new SchemeException("closure expected");
    }
}
