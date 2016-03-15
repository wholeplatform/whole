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
package org.whole.examples.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.rdb.codebase.DBSchemaTemplateFactory;
import org.whole.lang.rdb.model.Database;

/**
 * An example of using the DBSchemaTemplateFactory to reverse
 * engineer a database into an RDB Database model
 * 
 * @author Enrico Persiani
 */
public class ImportSchemaExample {
	private static final String DBNAME = "BooksDB";

	protected void importSchema() throws Exception {
		// create a connection to a local database
		Class.forName("org.h2.Driver");

		Connection connection = DriverManager.getConnection("jdbc:h2:mem:"+DBNAME);

		// reverse engineer
		DBSchemaTemplateFactory dbSchemaTemplateFactory = new DBSchemaTemplateFactory(connection, DBNAME, null);
		Database database = dbSchemaTemplateFactory.create();

		// pretty print the obtained model
		PrettyPrinterOperation.prettyPrint(database);
		
		connection.close();
	}
}
