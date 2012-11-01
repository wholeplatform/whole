package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ForeignKeyAdapter extends AbstractEntityAdapter implements
		ForeignKey {
	private static final long serialVersionUID = 1;

	public ForeignKeyAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForeignKeyAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForeignKey> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.ForeignKey;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public StringData getTargetTable() {
		return wGet(RDBFeatureDescriptorEnum.targetTable).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setTargetTable(StringData targetTable) {
		wSet(RDBFeatureDescriptorEnum.targetTable, targetTable);
	}

	public Action getUpdateAction() {
		return wGet(RDBFeatureDescriptorEnum.updateAction).wGetAdapter(
				RDBEntityDescriptorEnum.Action);
	}

	public void setUpdateAction(Action updateAction) {
		wSet(RDBFeatureDescriptorEnum.updateAction, updateAction);
	}

	public Action getDeleteAction() {
		return wGet(RDBFeatureDescriptorEnum.deleteAction).wGetAdapter(
				RDBEntityDescriptorEnum.Action);
	}

	public void setDeleteAction(Action deleteAction) {
		wSet(RDBFeatureDescriptorEnum.deleteAction, deleteAction);
	}

	public Deferrability getDeferrability() {
		return wGet(RDBFeatureDescriptorEnum.deferrability).wGetAdapter(
				RDBEntityDescriptorEnum.Deferrability);
	}

	public void setDeferrability(Deferrability deferrability) {
		wSet(RDBFeatureDescriptorEnum.deferrability, deferrability);
	}

	public ColumnReferences getColumnReferences() {
		return wGet(RDBFeatureDescriptorEnum.columnReferences).wGetAdapter(
				RDBEntityDescriptorEnum.ColumnReferences);
	}

	public void setColumnReferences(ColumnReferences columnReferences) {
		wSet(RDBFeatureDescriptorEnum.columnReferences, columnReferences);
	}
}
