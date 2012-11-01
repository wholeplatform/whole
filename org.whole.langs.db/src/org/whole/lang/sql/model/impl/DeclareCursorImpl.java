package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DeclareCursorImpl extends AbstractSimpleEntity implements
		DeclareCursor {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DeclareCursor> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DeclareCursor;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.DeclareCursor_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SQLFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SQLFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private SQLStatement sqlStatement;

	public SQLStatement getSqlStatement() {
		return notifyRequested(SQLFeatureDescriptorEnum.sqlStatement,
				sqlStatement);
	}

	public void setSqlStatement(SQLStatement sqlStatement) {
		notifyChanged(SQLFeatureDescriptorEnum.sqlStatement, this.sqlStatement,
				this.sqlStatement = sqlStatement);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getSqlStatement().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SQLEntityDescriptorEnum.Name));
			break;
		case 1:
			setSqlStatement(value
					.wGetAdapter(SQLEntityDescriptorEnum.SQLStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
