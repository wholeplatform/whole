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
public class TableAdapter extends AbstractEntityAdapter implements Table {
	private static final long serialVersionUID = 1;

	public TableAdapter(IEntity implementor) {
		super(implementor);
	}

	public TableAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Table> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Table;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public Name getEntityName() {
		return wGet(RDBFeatureDescriptorEnum.entityName).wGetAdapter(
				RDBEntityDescriptorEnum.Name);
	}

	public void setEntityName(Name entityName) {
		wSet(RDBFeatureDescriptorEnum.entityName, entityName);
	}

	public Columns getColumns() {
		return wGet(RDBFeatureDescriptorEnum.columns).wGetAdapter(
				RDBEntityDescriptorEnum.Columns);
	}

	public void setColumns(Columns columns) {
		wSet(RDBFeatureDescriptorEnum.columns, columns);
	}

	public PrimaryKey getPrimaryKey() {
		return wGet(RDBFeatureDescriptorEnum.primaryKey).wGetAdapter(
				RDBEntityDescriptorEnum.PrimaryKey);
	}

	public void setPrimaryKey(PrimaryKey primaryKey) {
		wSet(RDBFeatureDescriptorEnum.primaryKey, primaryKey);
	}

	public ForeignKeys getForeignKeys() {
		return wGet(RDBFeatureDescriptorEnum.foreignKeys).wGetAdapter(
				RDBEntityDescriptorEnum.ForeignKeys);
	}

	public void setForeignKeys(ForeignKeys foreignKeys) {
		wSet(RDBFeatureDescriptorEnum.foreignKeys, foreignKeys);
	}

	public Indices getIndices() {
		return wGet(RDBFeatureDescriptorEnum.indices).wGetAdapter(
				RDBEntityDescriptorEnum.Indices);
	}

	public void setIndices(Indices indices) {
		wSet(RDBFeatureDescriptorEnum.indices, indices);
	}

	public StringData getRemarks() {
		return wGet(RDBFeatureDescriptorEnum.remarks).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setRemarks(StringData remarks) {
		wSet(RDBFeatureDescriptorEnum.remarks, remarks);
	}
}
