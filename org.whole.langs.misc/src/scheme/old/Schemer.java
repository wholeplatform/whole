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

public class Schemer {
    public static SchemePairValue mkArgList(String[] args) {
	SchemePairValue res = null;
	for (int i = args.length - 1; i >= 0; i--)
	    res = SchemePairValueImpl.valueOf(SchemeStringValueImpl.valueOf(args[i]), res);
	return res;
    }

    public static void main(String[] args) throws java.io.IOException, SchemeException {
	final SchemeEnvironment env = new SchemeEnvironmentImpl2();
	SchemeBuiltins.registerBuiltins(env);
	final SchemeScanner scanner = new SchemeScanner(System.in);
	final SchemeParser parser = new SchemeParser(scanner, new SchemeFactoryImpl());
	try {
	    while (scanner.getToken() != SchemeScanner.EOF) {
		final SchemeDefinition def = parser.parseDefine();
		def.declare(env);
		def.define(env);
	    }
	} catch (SchemeException e) {
	    throw e;
	}

	final List newArgs = new ArrayList();
	newArgs.add(mkArgList(args));
	System.out.println(SchemeValueImpl.toString(env.get("main").apply(newArgs)));
    }
}
