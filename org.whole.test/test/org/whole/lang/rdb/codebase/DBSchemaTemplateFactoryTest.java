/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.rdb.codebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Comparator;
import java.util.HashMap;

import junit.framework.TestCase;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class DBSchemaTemplateFactoryTest extends TestCase {
	private Connection connection;

	@Override
	protected void setUp() throws Exception {
		ReflectionFactory.deployWholePlatform();

		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:mem:DBNAME");
	}

	@Override
	protected void tearDown() throws Exception {
		connection.close();
	}

	public void testRDBSchemaTemplateFactory() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database template = new CycleModel().create();
		Database database = EntityUtils.clone(template);
		Matcher.removeVars(database, true);
		InterpreterOperation.interpret(database, bm);

		DBSchemaTemplateFactory dbSchemaTemplateFactory = new DBSchemaTemplateFactory(connection, null, "PUBLIC");
		Database generatedDatabase = dbSchemaTemplateFactory.create();

		HashMap<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
		comparatorsMap.put(RDBEntityDescriptorEnum.Tables, new OrderedMatcher.SimpleFeatureComparator(RDBFeatureDescriptorEnum.name));
		
		assertTrue(OrderedMatcher.match(template, generatedDatabase, comparatorsMap));
	}

	//FIXME
	public void testRDBUtils() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);

		Database database = new SampleDatabase().create();
		InterpreterOperation.interpret(database, bm);

		DBSchemaTemplateFactory dbSchemaTemplateFactory = new DBSchemaTemplateFactory(connection, "DBNAME", null);
		Database generatedDatabase = dbSchemaTemplateFactory.create();

		HashMap<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
		comparatorsMap.put(RDBEntityDescriptorEnum.Tables, new OrderedMatcher.SimpleFeatureComparator(RDBFeatureDescriptorEnum.name));

		assertTrue(OrderedMatcher.match(database, generatedDatabase, comparatorsMap));
		
		fail();
	}
}
