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

class SchemeParser {
    private final SchemeScanner scanner;
    private final SchemeFactory factory;

    public SchemeParser(SchemeScanner s, SchemeFactory f) {
	scanner = s;
	factory = f;
    }

    private void parseOpen() throws java.io.IOException {
	if (scanner.getToken() == SchemeScanner.OPEN)
	    scanner.nextToken();
	else
	    throw new SchemeSyntaxError(scanner.getLine(), "( expected");
    }

    private void parseClose() throws java.io.IOException {
	if (scanner.getToken() == SchemeScanner.CLOSE)
	    scanner.nextToken();
	else
	    throw new SchemeSyntaxError(scanner.getLine(), ") expected");
    }

    private String parseId() throws java.io.IOException {
	if (scanner.getToken() == SchemeScanner.ID) {
	    String v = scanner.getValue();
	    scanner.nextToken();
	    return v;
	} else
	    throw new SchemeSyntaxError(scanner.getLine(), "identifier expected");
    }

    private void parseId(String id) throws java.io.IOException {
	String s = parseId();
	if (!s.equals(id))
	    throw new SchemeSyntaxError(scanner.getLine(), "'" + id + "' expected");
    }

    public SchemeDefinition parseDefine() throws java.io.IOException {
	parseOpen();
	parseId("define");
	if (scanner.getToken() == SchemeScanner.OPEN) {
	    parseOpen();
	    final String name = parseId();
	    final List params = parseNameList();
	    parseClose();
	    final SchemeExpression e = parseExpression();
	    parseClose();
	    return factory.createDefinition(name, factory.createLambdaExpression(params, e));
	} else {
	    final String name = parseId();
	    final SchemeExpression e = parseExpression();
	    parseClose();
	    return factory.createDefinition(name, e);
	}
    }

    public List parseNameList() throws java.io.IOException {
	final List list = new ArrayList();
	while (scanner.getToken() != SchemeScanner.CLOSE)
	    list.add(parseId());
	return list;
    }

    public List parseExpressionList() throws java.io.IOException {
	final List list = new ArrayList();
	while (scanner.getToken() != SchemeScanner.CLOSE)
	    list.add(parseExpression());
	return list;
    }

    private SchemeExpression parseLambda() throws java.io.IOException {
	parseOpen();
	final List params = parseNameList();
	parseClose();
	return factory.createLambdaExpression(params, parseExpression());
    }

    private SchemeExpression parseAnd() throws java.io.IOException {
	return factory.createAndExpression(parseExpressionList());
    }

    private SchemeExpression parseOr() throws java.io.IOException {
	return factory.createOrExpression(parseExpressionList());
    }

    private SchemeExpression parseCond() throws java.io.IOException {
	final List list = new ArrayList();
	do {
	    parseOpen();
	    if (scanner.getToken() == SchemeScanner.ID
		&& scanner.getValue().equals("else")) {
		parseId("else");
		final SchemeExpression e = parseExpression();
		parseClose();
		return factory.createCondExpression(list, e);
	    }
	    
	    final SchemeExpression e1 = parseExpression();
	    final SchemeExpression e2 = parseExpression();
	    parseClose();
	    list.add(factory.createBranch(e1, e2));
	} while (scanner.getToken() != SchemeScanner.CLOSE);

	return factory.createCondExpression(list, null);
    }

    /*
    private SchemeExpression parseCond()
    {
	final List list = new ArrayList();
	parseOpen();
	while (scanner.getToken() != SchemeScanner.CLOSE &&
	       scanner.getToken() != SchemeScanner.ID ||
	       !scanner.getValue().equals("else"))
	    {
		final SchemeExpression e1 = parseExpression();
		final SchemeExpression e2 = parseExpression();
		parseClose();
		list.add(factory.createBranch(e1, e2));
		if (scanner.getToken() == SchemeScanner.OPEN)
		    parseOpen();
	    }

	SchemeExpression e = null;
	if (scanner.getToken() == SchemeScanner.ID && scanner.getValue().equals("else"))
	    {
		parseId("else");
		e = parseExpression();
		parseClose();
	    }

	return factory.createCondExpression(list, e);
    }
    */

    private List parseDefineList() throws java.io.IOException {
	final List list = new ArrayList();
	while (scanner.getToken() != SchemeScanner.CLOSE)
	    list.add(parseDefine());
	return list;
    }

    private SchemeExpression parseLocal() throws java.io.IOException {
	parseOpen();
	final List list = parseDefineList();
	parseClose();
	return factory.createLocalExpression(list, parseExpression());
    }

    private SchemeExpression parseBegin() throws java.io.IOException {
	return factory.createBeginExpression(parseExpressionList());
    }

    private SchemeExpression parseExpression() throws java.io.IOException {
	switch (scanner.getToken()) {
	case SchemeScanner.ID: {
	    final String value = scanner.getValue();
	    scanner.nextToken();
	    return factory.createIdExpression(value);
	}
	case SchemeScanner.BOOL: {
	    final String value = scanner.getValue();
	    scanner.nextToken();
	    return factory.createBoolExpression(value.equals("t"));
	}
	case SchemeScanner.INT: {
	    final String value = scanner.getValue();
	    scanner.nextToken();
	    return factory.createIntExpression(Integer.parseInt(value));
	}
	case SchemeScanner.STRING: {
	    final String value = scanner.getValue();
	    scanner.nextToken();
	    return factory.createStringExpression(value);
	}
	case SchemeScanner.OPEN: {
	    SchemeExpression res = null;
	    parseOpen();
	    if (scanner.getToken() == SchemeScanner.ID) {
		final String kw = scanner.getValue();
		scanner.nextToken();
		if (kw.equals("lambda"))
		    res = parseLambda();
		else if (kw.equals("and"))
		    res = parseAnd();
		else if (kw.equals("or"))
		    res = parseOr();
		else if (kw.equals("cond"))
		    res = parseCond();
		else if (kw.equals("local"))
		    res = parseLocal();
		else {
		    final List list = parseExpressionList();
		    list.add(0, factory.createIdExpression(kw));
		    res = factory.createApplyExpression(list);
		}
	    } else
		res = factory.createApplyExpression(parseExpressionList());
	    parseClose();
	    return res;
	}
	default:
	    // error
	    return null;
	}
    }
}
