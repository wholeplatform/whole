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
import java.util.Iterator;

class SchemeClosureValueImpl extends SchemeValueImpl {
    public SchemeClosureValueImpl(List a, SchemeExpression b, SchemeEnvironment e) {
	fArgs = a;
	body = b;
	env = e.copy();
    }

    public String toString() {
	return "<closure:" + Integer.toString(fArgs.size()) + ">";
    }

    public SchemeValue apply(List args) throws SchemeException {
	if (args.size() != fArgs.size())
	    throw new SchemeException("wrong number of arguments: "
				      + Integer.toString(args.size()) + " instead of "
				      + Integer.toString(fArgs.size()));
	final SchemeEnvironment newEnv = env.copy();
	final Iterator i = args.iterator();
	final Iterator fi = fArgs.iterator();
	while (fi.hasNext()) {
	    final String name = (String) fi.next();
	    final SchemeValue value = (SchemeValue) i.next();
	    newEnv.add(name, value);
	}
	return body.evaluate(newEnv);
    }

    private final List fArgs;
    private final SchemeExpression body;
    private final SchemeEnvironment env;
}
