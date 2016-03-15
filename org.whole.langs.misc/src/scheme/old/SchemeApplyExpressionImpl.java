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
import java.util.ArrayList;
import java.util.Iterator;

class SchemeApplyExpressionImpl implements SchemeExpression {
    public SchemeApplyExpressionImpl(List es) {
	exprs = es;
    }

    public SchemeValue evaluate(SchemeEnvironment env) throws SchemeException {
	final Iterator i = exprs.iterator();
	if (!i.hasNext())
	    throw new SchemeException("empty application");
	final SchemeValue head = ((SchemeExpression) i.next()).evaluate(env);
	final List args = new ArrayList();
	while (i.hasNext()) {
	    final SchemeExpression arg = (SchemeExpression) i.next();
	    args.add(arg.evaluate(env));
	}
	return head.apply(args);
    }

    private final List exprs;
}
