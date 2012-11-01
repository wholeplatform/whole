package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PrimaryKeyImpl extends AbstractSimpleEntity implements PrimaryKey {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<PrimaryKey> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.PrimaryKey;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.PrimaryKey_ord;
	}

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName()
					.wEquals(entity.wGet(RDBFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private StringData name;

	public StringData getName() {
		return notifyRequested(RDBFeatureDescriptorEnum.name, name);
	}

	public void setName(StringData name) {
		notifyChanged(RDBFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private IdMethod idMethod;

	public IdMethod getIdMethod() {
		return notifyRequested(RDBFeatureDescriptorEnum.idMethod, idMethod);
	}

	public void setIdMethod(IdMethod idMethod) {
		notifyChanged(RDBFeatureDescriptorEnum.idMethod, this.idMethod,
				this.idMethod = idMethod);
	}

	private ColumnNames columnNames;

	public ColumnNames getColumnNames() {
		return notifyRequested(RDBFeatureDescriptorEnum.columnNames,
				columnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		notifyChanged(RDBFeatureDescriptorEnum.columnNames, this.columnNames,
				this.columnNames = columnNames);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getIdMethod().wGetAdaptee(false);
		case 2:
			return getColumnNames().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 1:
			setIdMethod(value.wGetAdapter(RDBEntityDescriptorEnum.IdMethod));
			break;
		case 2:
			setColumnNames(value
					.wGetAdapter(RDBEntityDescriptorEnum.ColumnNames));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
