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
package org.whole.lang.sql;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.rdb.codebase.DBMappingTemplateManager;
import org.whole.lang.rdb.codebase.SampleDatabase;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class SQLInterpreterTest {
	private Connection connection;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

    @Before
    public void setUp() throws Exception {
		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:mem:");
	}

	@After
	public void tearDown() throws Exception {
		connection.close();
	}

	@Test
    public void testMapAuthorsQuery() {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database database = new SampleDatabase().create();
		InterpreterOperation.interpret(database, bm);

		IEntity e = DBMappingTemplateManager.instance().create("populateDB");
		InterpreterOperation.interpret(e, bm);

		IEntity map = DBMappingTemplateManager.instance().create("mapAuthorsQuery");
		IEntity results = DBMappingTemplateManager.instance().create("mapAuthorsResults");
		int index = 0;
		for (IEntity result : DynamicCompilerOperation.compile(map, bm).getResultIterator()) {
			IEntity expectedResult = results.wGet(index++).wGet(0);
			assertTrue(Matcher.match(expectedResult, result));
		}
		assertEquals(results.wSize(), index);
	}

	@Test
    public void testMapAuthorsQuery2() {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database database = new SampleDatabase().create();
		InterpreterOperation.interpret(database, bm);

		IEntity e = DBMappingTemplateManager.instance().create("populateDB");
		InterpreterOperation.interpret(e, bm);

		IEntity map = DBMappingTemplateManager.instance().create("mapAuthorsQuery2");
		IEntity results = DBMappingTemplateManager.instance().create("mapAuthorsResults");
		int index = 0;
		for (IEntity result : DynamicCompilerOperation.compile(map, bm).getResultIterator()) {
			IEntity expectedResult = results.wGet(index++).wGet(0);
			assertTrue(Matcher.match(expectedResult, result));
		}
		assertEquals(results.wSize(), index);
	}

	@Test
    public void testMapAuthorsQuery3() {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database database = new SampleDatabase().create();
		InterpreterOperation.interpret(database, bm);

		IEntity e = DBMappingTemplateManager.instance().create("populateDB");
		InterpreterOperation.interpret(e, bm);

		IEntity map = DBMappingTemplateManager.instance().create("mapAuthorsQuery3");
		IEntity results = DBMappingTemplateManager.instance().create("mapAuthorsResults");
		int index = 0;
		for (IEntity result : DynamicCompilerOperation.compile(map, bm).getResultIterator()) {
			IEntity expectedResult = results.wGet(index++).wGet(0);
			assertTrue(Matcher.match(expectedResult, result));
		}
		assertEquals(results.wSize(), index);
	}

	@Test
    public void testMapAuthorsQueryWithNestedVar() {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database database = new SampleDatabase().create();
		InterpreterOperation.interpret(database, bm);

		IEntity e = DBMappingTemplateManager.instance().create("populateDB");
		InterpreterOperation.interpret(e, bm);

		IEntity map = DBMappingTemplateManager.instance().create("mapAuthorsQueryWithNestedVar");
		IEntity results = DBMappingTemplateManager.instance().create("mapAuthorsResults");
		int index = 0;
		for (IEntity result : DynamicCompilerOperation.compile(map, bm).getResultIterator()) {
			IEntity expectedResult = results.wGet(index++).wGet(0);
			assertTrue(Matcher.match(expectedResult, result));
		}
		assertEquals(1, index);
	}

	@Test
    public void testDataTypes() {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database database = new AllTypesDatabase().create();
		InterpreterOperation.interpret(database, bm);

		IEntity e = DBMappingTemplateManager.instance().create("populateDatatypesDB");
		InterpreterOperation.interpret(e, bm);

		IEntity map = DBMappingTemplateManager.instance().create("selectDatatypesDB");
		IEntity results = DBMappingTemplateManager.instance().create("selectDatatypesDBResults");
		IEntityIterator<IEntity> resultsIterator = DynamicCompilerOperation.compile(results, bm).getResultIterator();
		for (IEntity result : DynamicCompilerOperation.compile(map, bm).getResultIterator()) {
			assertTrue(resultsIterator.hasNext());
			IEntity expectedResult = resultsIterator.next();
			assertEquals(expectedResult.wSize(), result.wSize());
			for (int i=0; i<expectedResult.wSize(); i++) {
				IEntity expectedValue = expectedResult.wGet(i);
				IEntity actualValue = result.wGet(i);
				switch (expectedValue.wGetEntityOrd()) {
				case SQLEntityDescriptorEnum.ArrayValue_ord:
				case SQLEntityDescriptorEnum.BinaryValue_ord:
					Object a1 = expectedValue.wGetValue();
					Object a2 = actualValue.wGetValue();
					assertTrue(a1.getClass().isArray());
					assertTrue(a2.getClass().isArray());
					int length = Array.getLength(a1);
					assertEquals(length, Array.getLength(a2));
					for (int j=0; j<length; j++)
						assertEquals(Array.get(a1, j), Array.get(a2, j));
					break;
				default:
					assertTrue(Matcher.match(expectedValue, actualValue));
				}
			}
		}
		assertFalse(resultsIterator.hasNext());
	}
}
