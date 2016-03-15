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

class SchemeCondExpressionImpl implements SchemeExpression {
    public SchemeCondExpressionImpl(List b, SchemeExpression e)
    {
	branches = b;
	els = e;
    }

    public SchemeValue evaluate(SchemeEnvironment env) throws SchemeException
    {
	final Iterator i = branches.iterator();
	while (i.hasNext())
	    {
		final SchemeBranch branch = (SchemeBranch) i.next();
		if (branch.getTest().evaluate(env).asBool())
		    return branch.getBody().evaluate(env);
	    }

	if (els != null)
	    return els.evaluate(env);
	else
	    throw new SchemeException("cond failed");
    }

    private final List branches;
    private final SchemeExpression els;
}
