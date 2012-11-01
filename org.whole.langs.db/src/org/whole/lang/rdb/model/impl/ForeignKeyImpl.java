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
public class ForeignKeyImpl extends AbstractSimpleEntity implements ForeignKey {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ForeignKey> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ForeignKey;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.ForeignKey_ord;
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

	private StringData targetTable;

	public StringData getTargetTable() {
		return notifyRequested(RDBFeatureDescriptorEnum.targetTable,
				targetTable);
	}

	public void setTargetTable(StringData targetTable) {
		notifyChanged(RDBFeatureDescriptorEnum.targetTable, this.targetTable,
				this.targetTable = targetTable);
	}

	private Action updateAction;

	public Action getUpdateAction() {
		return notifyRequested(RDBFeatureDescriptorEnum.updateAction,
				updateAction);
	}

	public void setUpdateAction(Action updateAction) {
		notifyChanged(RDBFeatureDescriptorEnum.updateAction, this.updateAction,
				this.updateAction = updateAction);
	}

	private Action deleteAction;

	public Action getDeleteAction() {
		return notifyRequested(RDBFeatureDescriptorEnum.deleteAction,
				deleteAction);
	}

	public void setDeleteAction(Action deleteAction) {
		notifyChanged(RDBFeatureDescriptorEnum.deleteAction, this.deleteAction,
				this.deleteAction = deleteAction);
	}

	private Deferrability deferrability;

	public Deferrability getDeferrability() {
		return notifyRequested(RDBFeatureDescriptorEnum.deferrability,
				deferrability);
	}

	public void setDeferrability(Deferrability deferrability) {
		notifyChanged(RDBFeatureDescriptorEnum.deferrability,
				this.deferrability, this.deferrability = deferrability);
	}

	private ColumnReferences columnReferences;

	public ColumnReferences getColumnReferences() {
		return notifyRequested(RDBFeatureDescriptorEnum.columnReferences,
				columnReferences);
	}

	public void setColumnReferences(ColumnReferences columnReferences) {
		notifyChanged(RDBFeatureDescriptorEnum.columnReferences,
				this.columnReferences, this.columnReferences = columnReferences);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getTargetTable().wGetAdaptee(false);
		case 2:
			return getUpdateAction().wGetAdaptee(false);
		case 3:
			return getDeleteAction().wGetAdaptee(false);
		case 4:
			return getDeferrability().wGetAdaptee(false);
		case 5:
			return getColumnReferences().wGetAdaptee(false);
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
			setTargetTable(value
					.wGetAdapter(RDBEntityDescriptorEnum.StringData));
			break;
		case 2:
			setUpdateAction(value.wGetAdapter(RDBEntityDescriptorEnum.Action));
			break;
		case 3:
			setDeleteAction(value.wGetAdapter(RDBEntityDescriptorEnum.Action));
			break;
		case 4:
			setDeferrability(value
					.wGetAdapter(RDBEntityDescriptorEnum.Deferrability));
			break;
		case 5:
			setColumnReferences(value
					.wGetAdapter(RDBEntityDescriptorEnum.ColumnReferences));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 6;
	}
}
