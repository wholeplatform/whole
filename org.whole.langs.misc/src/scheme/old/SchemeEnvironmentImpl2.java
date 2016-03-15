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

import java.util.HashMap;

class SchemeEnvironmentImpl2 implements SchemeEnvironment {
    private class Box {
	public Box(SchemeValue v) {
	    value = v;
	}

	public SchemeValue getValue() {
	    return value;
	}

	public void setValue(SchemeValue v) {
	    value = v;
	}

	private SchemeValue value;
    }

    public SchemeEnvironmentImpl2() {
	map = new HashMap();
    }

    public SchemeEnvironmentImpl2(HashMap m) {
	map = (HashMap) m.clone();
    }

    public SchemeEnvironment copy() {
	return new SchemeEnvironmentImpl2(map);
    }

    public void add(String name, SchemeValue value) {
	map.put(name, new Box(value));
    }

    public SchemeValue get(String name) throws SchemeException {
	if (map.containsKey(name))
	    return ((Box) map.get(name)).getValue();
	else
	    throw new SchemeException("unbound name: " + name);
    }

    public void set(String name, SchemeValue value) {
	((Box) map.get(name)).setValue(value);
    }

    private HashMap map;
}
