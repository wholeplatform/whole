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

class SchemeLocalExpressionImpl implements SchemeExpression {
    public SchemeLocalExpressionImpl(List bs, SchemeExpression b) {
	bindings = bs;
	body = b;
    }

    public SchemeValue evaluate(SchemeEnvironment env) throws SchemeException {
	final SchemeEnvironment newEnv = env.copy();

	final Iterator i = bindings.iterator();
	while (i.hasNext()) {
	    final SchemeDefinition def = (SchemeDefinition) i.next();
	    def.declare(newEnv);
	}

	final Iterator j = bindings.iterator();
	while (j.hasNext()) {
	    final SchemeDefinition def = (SchemeDefinition) j.next();
	    def.define(newEnv);
	}

	return body.evaluate(newEnv);
    }

    private final List bindings;
    private final SchemeExpression body;
}
