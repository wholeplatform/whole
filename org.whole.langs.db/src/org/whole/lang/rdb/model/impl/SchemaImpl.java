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
public class SchemaImpl extends AbstractSimpleEntity implements Schema {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Schema> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Schema;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Schema_ord;
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

	private StringData modelName;

	public StringData getModelName() {
		return notifyRequested(RDBFeatureDescriptorEnum.modelName, modelName);
	}

	public void setModelName(StringData modelName) {
		notifyChanged(RDBFeatureDescriptorEnum.modelName, this.modelName,
				this.modelName = modelName);
	}

	private Tables tables;

	public Tables getTables() {
		return notifyRequested(RDBFeatureDescriptorEnum.tables, tables);
	}

	public void setTables(Tables tables) {
		notifyChanged(RDBFeatureDescriptorEnum.tables, this.tables,
				this.tables = tables);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getModelName().wGetAdaptee(false);
		case 2:
			return getTables().wGetAdaptee(false);
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
			setModelName(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 2:
			setTables(value.wGetAdapter(RDBEntityDescriptorEnum.Tables));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
