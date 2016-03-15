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
package org.whole.lang.sql.iterators;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.NoSuchElementException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.IBindingScope;
import org.whole.lang.commons.factories.CommonsEntityFactory;
import org.whole.lang.iterators.AbstractCloneableIterator;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.factories.SQLEntityFactory;

/**
 * @author Riccardo Solmi
 */
public class ResultSetIterator extends AbstractCloneableIterator<IEntity> {
	private IBindingManager bindings;
	private ResultSet resultSet;
	private IEntity nextEntity = null;
	private String[] labels;

	public ResultSetIterator(ResultSet resultSet, String... labels) {
		this.resultSet = resultSet;
		this.labels = labels;
	}

	public boolean hasNext() {
		return lookahead() != null;
	}

	public IEntity next() {
		IEntity result = lookahead();
		if (result == null)
			throw new NoSuchElementException();
		
		getBindings().wAddAll(lookaheadScope());
		nextEntity = null;
		return result;
	}

	public IEntity lookahead() {
		if (nextEntity != null)
			return nextEntity;
		
		clearLookaheadScope();

		try {
			if (!resultSet.next()) {
				resultSet.getStatement().close();
				return null;
			}
		} catch (SQLException e) {
			return null;
		}

		BindingManagerFactory factory = BindingManagerFactory.instance;
		SQLEntityFactory ef = SQLEntityFactory.instance;

		try {
			getBindings().wEnterScope(lookaheadScope(), true);

			ResultSetMetaData metaData = resultSet.getMetaData();
			nextEntity = factory.createTuple();
			for (int i=1; i<=metaData.getColumnCount(); i++) {
				IEntity value;
				switch (metaData.getColumnType(i)) {
				case Types.ARRAY:
					value = ef.createArrayValue(resultSet.getArray(i).getArray());
					break;
				case Types.BIT:
				case Types.BOOLEAN:
					value = ef.createBooleanValue(resultSet.getBoolean(i));
					break;
				case Types.TINYINT:
					value = ef.createTinyIntValue(resultSet.getByte(i));
					break;
				case Types.SMALLINT:
					value = ef.createSmallIntValue(resultSet.getShort(i));
					break;
				case Types.INTEGER:
					value = ef.createIntValue(resultSet.getInt(i));
					break;
				case Types.BIGINT:
					value = ef.createBigIntValue(resultSet.getLong(i));
					break;
				case Types.FLOAT:
				case Types.DOUBLE:
					value = ef.createDoubleValue(resultSet.getDouble(i));
					break;
				case Types.REAL:
					value = ef.createRealValue(resultSet.getFloat(i));
					break;
				case Types.NUMERIC:
				case Types.DECIMAL:
					value = ef.createDecimalValue(resultSet.getBigDecimal(i));
					break;			
				case Types.CHAR:
				case Types.VARCHAR:
				case Types.LONGVARCHAR:
					value = ef.createStringValue(resultSet.getString(i));
					break;
				case Types.BINARY:
				case Types.VARBINARY:
				case Types.LONGVARBINARY:
					value = ef.createBinaryValue(resultSet.getBytes(i));
					break;
				case Types.DATE:
					value = ef.createDateValue(resultSet.getDate(i));
					break;
				case Types.TIME:
					value = ef.createTimeValue(resultSet.getTime(i));
					break;
				case Types.TIMESTAMP:
					value = ef.createTimestampValue(resultSet.getTimestamp(i));
					break;
				case Types.BLOB:
					value = ef.createBlobValue(resultSet.getBlob(i));
					break;
				case Types.CLOB:
					value = ef.createClobValue(resultSet.getClob(i));
					break;
				case Types.NULL:
					value = ef.createNullValue();
					break;
				default:
					value = ef.createRawValue(resultSet.getObject(i));
					break;	
				}

				if (resultSet.wasNull())
					value = CommonsEntityFactory.instance.createResolver();
				
				String label = i <= labels.length && labels[i-1] != null ? labels[i-1] : metaData.getColumnLabel(i);
				getBindings().wDef(label, value);
				nextEntity.wAdd(value);
			}
			
			getBindings().wExitScope();

		} catch (SQLException e) {
			throw new IllegalStateException();
		}
		return nextEntity;
	}

	public void reset(IEntity entity) {
		clearLookaheadScope();
		try {
			resultSet.beforeFirst();
		} catch (SQLException e) {
		}
	}

    public void setBindings(IBindingManager bindings) {
    	this.bindings = bindings;
	}
	public IBindingManager getBindings() {
		if (bindings == null)
			setBindings(BindingManagerFactory.instance.createBindingManager());
		return bindings;
	}

	private IBindingScope lookaheadScope;
	public IBindingScope lookaheadScope() {
		if (lookaheadScope == null)
			lookaheadScope = BindingManagerFactory.instance.createSimpleScope();
		return lookaheadScope;
	}
	protected void clearLookaheadScope() {
		if (lookaheadScope != null) {
			for (String name : lookaheadScope.wNames())
				getBindings().wUnset(name);
			lookaheadScope.wClear();
		}
	}

	public void prune() {
	}

	public void remove() {
		try {
			resultSet.deleteRow();
		} catch (SQLException e) {
			throw new UnsupportedOperationException();
		}
	}

	public void add(IEntity entity) {
		throw new UnsupportedOperationException();
	}

	public void set(IEntity entity) {
		for (int i=0; i<entity.wSize(); i++)
			try {
				resultSet.updateObject(i+1, entity.wGet(i).wGetValue());
			} catch (SQLException e) {
				throw new UnsupportedOperationException();
			}
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append("ResultSet iterator");
    }
}
