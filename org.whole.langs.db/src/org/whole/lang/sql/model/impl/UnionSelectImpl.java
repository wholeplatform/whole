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
public class UnionSelectImpl extends AbstractSimpleEntity implements
		UnionSelect {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<UnionSelect> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UnionSelect;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.UnionSelect_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private Select simpleSelect;

	public Select getSimpleSelect() {
		return notifyRequested(SQLFeatureDescriptorEnum.simpleSelect,
				simpleSelect);
	}

	public void setSimpleSelect(Select simpleSelect) {
		notifyChanged(SQLFeatureDescriptorEnum.simpleSelect, this.simpleSelect,
				this.simpleSelect = simpleSelect);
	}

	private SelectSQLStatement unionSelectStatement;

	public SelectSQLStatement getUnionSelectStatement() {
		return notifyRequested(SQLFeatureDescriptorEnum.unionSelectStatement,
				unionSelectStatement);
	}

	public void setUnionSelectStatement(SelectSQLStatement unionSelectStatement) {
		notifyChanged(SQLFeatureDescriptorEnum.unionSelectStatement,
				this.unionSelectStatement,
				this.unionSelectStatement = unionSelectStatement);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSimpleSelect().wGetAdaptee(false);
		case 1:
			return getUnionSelectStatement().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSimpleSelect(value.wGetAdapter(SQLEntityDescriptorEnum.Select));
			break;
		case 1:
			setUnionSelectStatement(value
					.wGetAdapter(SQLEntityDescriptorEnum.SelectSQLStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
