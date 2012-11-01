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
public class PrimaryKeyAdapter extends AbstractEntityAdapter implements
		PrimaryKey {
	private static final long serialVersionUID = 1;

	public PrimaryKeyAdapter(IEntity implementor) {
		super(implementor);
	}

	public PrimaryKeyAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<PrimaryKey> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.PrimaryKey;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public IdMethod getIdMethod() {
		return wGet(RDBFeatureDescriptorEnum.idMethod).wGetAdapter(
				RDBEntityDescriptorEnum.IdMethod);
	}

	public void setIdMethod(IdMethod idMethod) {
		wSet(RDBFeatureDescriptorEnum.idMethod, idMethod);
	}

	public ColumnNames getColumnNames() {
		return wGet(RDBFeatureDescriptorEnum.columnNames).wGetAdapter(
				RDBEntityDescriptorEnum.ColumnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		wSet(RDBFeatureDescriptorEnum.columnNames, columnNames);
	}
}
