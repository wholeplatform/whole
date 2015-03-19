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
public class TableImpl extends AbstractSimpleEntity implements Table {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Table> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Table;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Table_ord;
	}

	public void accept(IRDBVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private Name entityName;

	public Name getEntityName() {
		return notifyRequested(RDBFeatureDescriptorEnum.entityName, entityName);
	}

	public void setEntityName(Name entityName) {
		notifyChanged(RDBFeatureDescriptorEnum.entityName, this.entityName,
				this.entityName = entityName);
	}

	private Columns columns;

	public Columns getColumns() {
		return notifyRequested(RDBFeatureDescriptorEnum.columns, columns);
	}

	public void setColumns(Columns columns) {
		notifyChanged(RDBFeatureDescriptorEnum.columns, this.columns,
				this.columns = columns);
	}

	private PrimaryKey primaryKey;

	public PrimaryKey getPrimaryKey() {
		return notifyRequested(RDBFeatureDescriptorEnum.primaryKey, primaryKey);
	}

	public void setPrimaryKey(PrimaryKey primaryKey) {
		notifyChanged(RDBFeatureDescriptorEnum.primaryKey, this.primaryKey,
				this.primaryKey = primaryKey);
	}

	private ForeignKeys foreignKeys;

	public ForeignKeys getForeignKeys() {
		return notifyRequested(RDBFeatureDescriptorEnum.foreignKeys,
				foreignKeys);
	}

	public void setForeignKeys(ForeignKeys foreignKeys) {
		notifyChanged(RDBFeatureDescriptorEnum.foreignKeys, this.foreignKeys,
				this.foreignKeys = foreignKeys);
	}

	private Indices indices;

	public Indices getIndices() {
		return notifyRequested(RDBFeatureDescriptorEnum.indices, indices);
	}

	public void setIndices(Indices indices) {
		notifyChanged(RDBFeatureDescriptorEnum.indices, this.indices,
				this.indices = indices);
	}

	private StringData remarks;

	public StringData getRemarks() {
		return notifyRequested(RDBFeatureDescriptorEnum.remarks, remarks);
	}

	public void setRemarks(StringData remarks) {
		notifyChanged(RDBFeatureDescriptorEnum.remarks, this.remarks,
				this.remarks = remarks);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getEntityName().wGetAdaptee(false);
		case 2:
			return getColumns().wGetAdaptee(false);
		case 3:
			return getPrimaryKey().wGetAdaptee(false);
		case 4:
			return getForeignKeys().wGetAdaptee(false);
		case 5:
			return getIndices().wGetAdaptee(false);
		case 6:
			return getRemarks().wGetAdaptee(false);
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
			setEntityName(value.wGetAdapter(RDBEntityDescriptorEnum.Name));
			break;
		case 2:
			setColumns(value.wGetAdapter(RDBEntityDescriptorEnum.Columns));
			break;
		case 3:
			setPrimaryKey(value.wGetAdapter(RDBEntityDescriptorEnum.PrimaryKey));
			break;
		case 4:
			setForeignKeys(value
					.wGetAdapter(RDBEntityDescriptorEnum.ForeignKeys));
			break;
		case 5:
			setIndices(value.wGetAdapter(RDBEntityDescriptorEnum.Indices));
			break;
		case 6:
			setRemarks(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 7;
	}
}
