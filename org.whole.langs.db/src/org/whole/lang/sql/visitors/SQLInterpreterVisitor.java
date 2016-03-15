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
package org.whole.lang.sql.visitors;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.sql.iterators.ResultSetIterator;
import org.whole.lang.sql.model.ISQLEntity;
import org.whole.lang.sql.model.SQLStatement;
import org.whole.lang.sql.model.SQLStatements;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class SQLInterpreterVisitor extends SQLIdentityDefaultVisitor {
	private static final String SQL_INTERPRETER_ERROR_MESSAGE = "SQL interpreter failure.";

	protected Connection connection;
	protected Statement statement;
	protected boolean batchMode = false;

	@Override
	public InterpreterOperation getOperation() {
		return (InterpreterOperation) super.getOperation();
	}

	@Override
	public void visit(ISQLEntity entity) {
		if (statement != null)
			return;

		try {
			if (!Matcher.isAssignableAsIsFrom(SQLEntityDescriptorEnum.SQLStatement, entity) &&
					!Matcher.match(SQLEntityDescriptorEnum.SQLStatements, entity))
				throw new IllegalArgumentException("cannot interpret.");

			IBindingManager env = getBindings();
			if (!env.wIsSet("connection"))
				throw new IllegalArgumentException("database connection undefined.");

			connection = (Connection) env.wGetValue("connection");
			statement = connection.createStatement();

		} catch (Exception e) {
			throw new VisitException(SQL_INTERPRETER_ERROR_MESSAGE, e);
		}
	}

	protected PreparedStatement getPreparedStatement(String sql) {
		try {
			return connection.prepareStatement(sql);
		} catch (Exception e) {
			throw new VisitException(SQL_INTERPRETER_ERROR_MESSAGE, e);
		}
	}

	@Override
	public void visit(SQLStatement entity) {
		try {
			IVisitor ov = getOperation().setVisitor(entity, 0,
					getOperation().getVisitor(entity, 1));
			getOperation().stagedVisit(entity);
			getOperation().setVisitor(entity, 0, ov);

			entity = (SQLStatement) getResult();
			String sql = toPrettyPrintString(entity);

			if (batchMode)
				statement.addBatch(sql);
			else {
				String[] names;
				if (entity.wGetEntityDescriptor().equals(SQLEntityDescriptorEnum.Select)) {
					IEntity columnExprs = entity.wGet(SQLFeatureDescriptorEnum.columnExprs);
					int size = columnExprs.wSize();
					names = new String[size];
					for (int i=0; i<size; i++) {
						IEntity columnExpr = columnExprs.wGet(i);
						if (Matcher.matchImpl(SQLEntityDescriptorEnum.ColumnExpression, columnExpr)) {
							IEntity alias = columnExpr.wGet(SQLFeatureDescriptorEnum.alias);
							if (DataTypeUtils.getDataKind(alias).isString())
								names[i] = alias.wStringValue();
							else {
								IEntity expr = columnExpr.wGet(SQLFeatureDescriptorEnum.expression);
								if (Matcher.matchImpl(SQLEntityDescriptorEnum.ColumnName, expr))
									names[i] = expr.wStringValue();
							}
						}
					}
				} else
					names = new String[0];

//				PreparedStatement preparedStatement = null;
//				for (IEntity e : IteratorFactory.topDownIterator(entity)) {
//					if (preparedStatement == null)
//						preparedStatement = getPreparedStatement(sql);
//					
//					
//				}

				if (statement.execute(sql)) {
					ResultSetIterator ri = new ResultSetIterator(statement.getResultSet(), names);
					ri.setBindings(getBindings());
					setResultIterator(ri);
				} else {
					setResult(null);
					statement.close();
				}
			}

		} catch (Exception e) {
			try {
				statement.close();
			} catch (Exception e1) {
			}
			throw new VisitException(SQL_INTERPRETER_ERROR_MESSAGE, e);
		} finally {
			if (!batchMode)
				statement = null;
		}
	}

	@Override
	public void visit(SQLStatements entity) {
		try {
			batchMode = true;

			int size = entity.wSize();
			for (int i=0; i<size; i++)
				((ISQLEntity) entity.wGet(i)).accept(this);
			statement.executeBatch();

		} catch (Exception e) {
			throw new VisitException(SQL_INTERPRETER_ERROR_MESSAGE, e);
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
			}
			statement = null;
		}
	}
}
