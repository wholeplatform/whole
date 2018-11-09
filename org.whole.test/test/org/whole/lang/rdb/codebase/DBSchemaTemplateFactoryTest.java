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
package org.whole.lang.rdb.codebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Comparator;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.ClasspathPersistenceProvider;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.rdb.model.Database;
import org.whole.lang.rdb.model.Schema;
import org.whole.lang.rdb.model.Table;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.xml.codebase.XmlBuilderPersistenceKit;

/**
 * @author Enrico Persiani
 */
public class DBSchemaTemplateFactoryTest {
	private Connection connection;

    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
    }

	@Before
    public void setUp() throws Exception {
		Class.forName("org.h2.Driver");
		connection = DriverManager.getConnection("jdbc:h2:mem:DBNAME;DATABASE_TO_UPPER=false");
	}

	@After
    public void tearDown() throws Exception {
		connection.close();
	}

	@Test
	public void testRDBSchemaTemplateFactory() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);
		bm.wDefValue("batchMode", false);

		IPersistenceProvider pp = new ClasspathPersistenceProvider("org/whole/lang/rdb/codebase/CycleModel.xwl");
		Database template = (Database) XmlBuilderPersistenceKit.instance().readModel(pp);
		Database database = EntityUtils.clone(template);
		Matcher.removeVars(database, true);
		InterpreterOperation.interpret(database, bm);

		DBSchemaTemplateFactory dbSchemaTemplateFactory = new DBSchemaTemplateFactory(connection, null, "PUBLIC");
		Database generatedDatabase = dbSchemaTemplateFactory.create();

		HashMap<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
		comparatorsMap.put(RDBEntityDescriptorEnum.Tables, new OrderedMatcher.SimpleFeatureComparator(RDBFeatureDescriptorEnum.name));
		
		Assert.assertTrue(OrderedMatcher.match(template, generatedDatabase, comparatorsMap));
	}

	@Test
	public void testRDBUtils() throws Exception {
		IBindingManager bm = BindingManagerFactory.instance.createArguments();
		bm.wDefValue("connection", connection);
		bm.wDefValue("generateDropStatements", false);
		bm.wDefValue("batchMode", false);

		IPersistenceProvider pp = new ClasspathPersistenceProvider("org/whole/lang/rdb/codebase/SampleDatabase.xwl");
		Database database = (Database) XmlBuilderPersistenceKit.instance().readModel(pp);
		InterpreterOperation.interpret(database, bm);

		DBSchemaTemplateFactory dbSchemaTemplateFactory = new DBSchemaTemplateFactory(connection, "DBNAME", null);
		Database generatedDatabase = dbSchemaTemplateFactory.create();

		HashMap<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
		comparatorsMap.put(RDBEntityDescriptorEnum.Tables, new OrderedMatcher.SimpleFeatureComparator(RDBFeatureDescriptorEnum.name));

		Schema originalSchema = (Schema) database.getSchemas().wGet(0);
		Schema generatedSchema = (Schema) generatedDatabase.getSchemas().wGet(1);
		
		//FIXME add support for schema name reveng
		generatedSchema.setName(EntityUtils.cloneIfParented(originalSchema.getName()));

		// remove automatically generated indexes
		for (Table table : generatedSchema.getTables())
			table.wRemove(RDBFeatureDescriptorEnum.indices);

		Assert.assertTrue(OrderedMatcher.match(originalSchema, generatedSchema, comparatorsMap));
	}
}
