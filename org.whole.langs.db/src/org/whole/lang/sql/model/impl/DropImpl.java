package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.Drop;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.TableName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DropImpl extends AbstractSimpleEntity implements Drop {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Drop> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Drop;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Drop_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private TableName tableName;

	public TableName getTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public void setTableName(TableName tableName) {
		notifyChanged(SQLFeatureDescriptorEnum.tableName, this.tableName, this.tableName = tableName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getTableName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setTableName(value.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
