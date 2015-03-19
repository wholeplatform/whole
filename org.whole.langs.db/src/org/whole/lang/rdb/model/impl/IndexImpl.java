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
public class IndexImpl extends AbstractSimpleEntity implements Index {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Index> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Index;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Index_ord;
	}

	public void accept(IRDBVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode() + 29 * getQualifier().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName()
					.wEquals(entity.wGet(RDBFeatureDescriptorEnum.name))
					&& getQualifier().wEquals(
							entity.wGet(RDBFeatureDescriptorEnum.qualifier));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
		buffer.append("qualifier=");
		buffer.append(qualifier);
	}

	private StringData name;

	public StringData getName() {
		return notifyRequested(RDBFeatureDescriptorEnum.name, name);
	}

	public void setName(StringData name) {
		notifyChanged(RDBFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private StringData qualifier;

	public StringData getQualifier() {
		return notifyRequested(RDBFeatureDescriptorEnum.qualifier, qualifier);
	}

	public void setQualifier(StringData qualifier) {
		notifyChanged(RDBFeatureDescriptorEnum.qualifier, this.qualifier,
				this.qualifier = qualifier);
	}

	private BooleanData unique;

	public BooleanData getUnique() {
		return notifyRequested(RDBFeatureDescriptorEnum.unique, unique);
	}

	public void setUnique(BooleanData unique) {
		notifyChanged(RDBFeatureDescriptorEnum.unique, this.unique,
				this.unique = unique);
	}

	private IndexType type;

	public IndexType getType() {
		return notifyRequested(RDBFeatureDescriptorEnum.type, type);
	}

	public void setType(IndexType type) {
		notifyChanged(RDBFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private ColumnIndices columnIndices;

	public ColumnIndices getColumnIndices() {
		return notifyRequested(RDBFeatureDescriptorEnum.columnIndices,
				columnIndices);
	}

	public void setColumnIndices(ColumnIndices columnIndices) {
		notifyChanged(RDBFeatureDescriptorEnum.columnIndices,
				this.columnIndices, this.columnIndices = columnIndices);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getQualifier().wGetAdaptee(false);
		case 2:
			return getUnique().wGetAdaptee(false);
		case 3:
			return getType().wGetAdaptee(false);
		case 4:
			return getColumnIndices().wGetAdaptee(false);
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
			setQualifier(value.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 2:
			setUnique(value.wGetAdapter(RDBEntityDescriptorEnum.BooleanData));
			break;
		case 3:
			setType(value.wGetAdapter(RDBEntityDescriptorEnum.IndexType));
			break;
		case 4:
			setColumnIndices(value
					.wGetAdapter(RDBEntityDescriptorEnum.ColumnIndices));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 5;
	}
}
