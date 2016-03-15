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
package org.whole.gen.util;

import static org.junit.Assert.*;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.junit.Test;

/**
 * 
 * @author Enrico Persiani, Riccardo Solmi
 */
public class JDTUtilsTest {
	private static final String JAVA_EXPRESSION =
		"\"hello\".length() + 20";
	private static final String JAVA_STATEMENTS = 
		"System.out.println(\"Hello!\");\n" +
		"int x = 20;";
	private static final String JAVA_INITIALIZER = 
		"{\n" +
		"  System.out.println(\"Hello!\");\n" +
		"  int x = 20;\n" +
		"}";
	private static final String JAVA_CLASS_BODY_DECLARATIONS =
		"public abstract void test();\n" +
		"public final int intTest(String... params) throws Exception {\n" +
		"  System.out.println(\"some text\");\n" +
		"}";
	private static final String JAVA_COMPILATION_UNIT =
		"package org.whole.lang;\n" +
		"import java.io.Serializable;\n" +
		"class MyClass implements Serializable {\n" +
		"  private static final String CONST = \"some value\";\n" +
		"  private void someMethod(int value) {\n" +
		"    // do nothing\n" +
		"  }\n" +
		"}";

	private static final String JAVA_UNPARSABLE = 
		"package ;\n" +
		"imports java.io.Serializable;\n" +
		"lass MyClass implement Serializable {\n";

	@Test
    public void testParseExpression() {
		try {
			ASTNode astNode = JDTUtils.parse(JAVA_EXPRESSION);
			assertTrue(astNode instanceof Expression);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
    public void testParseStatements() {
		try {
			ASTNode astNode = JDTUtils.parse(JAVA_STATEMENTS);
			assertTrue(astNode instanceof Block);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
    public void testParseInitializer() {
		try {
			ASTNode astNode = JDTUtils.parse(JAVA_INITIALIZER);
			assertTrue(astNode instanceof TypeDeclaration);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
    public void testParseClassBodyDeclarations() {
		try {
			ASTNode astNode = JDTUtils.parse(JAVA_CLASS_BODY_DECLARATIONS);
			assertTrue(astNode instanceof TypeDeclaration);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
    public void testParseCompilationUnit() {
		try {
			ASTNode astNode = JDTUtils.parse(JAVA_COMPILATION_UNIT);
			assertTrue(astNode instanceof CompilationUnit);
		} catch (IllegalArgumentException e) {
			fail();
		}
	}

	@Test
    public void testParseFail() {
		try {
			@SuppressWarnings("unused")
			ASTNode astNode = JDTUtils.parse(JAVA_UNPARSABLE);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}
}
