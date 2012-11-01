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
public class IndexAdapter extends AbstractEntityAdapter implements Index {
	private static final long serialVersionUID = 1;

	public IndexAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndexAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Index> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Index;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public StringData getQualifier() {
		return wGet(RDBFeatureDescriptorEnum.qualifier).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setQualifier(StringData qualifier) {
		wSet(RDBFeatureDescriptorEnum.qualifier, qualifier);
	}

	public BooleanData getUnique() {
		return wGet(RDBFeatureDescriptorEnum.unique).wGetAdapter(
				RDBEntityDescriptorEnum.BooleanData);
	}

	public void setUnique(BooleanData unique) {
		wSet(RDBFeatureDescriptorEnum.unique, unique);
	}

	public IndexType getType() {
		return wGet(RDBFeatureDescriptorEnum.type).wGetAdapter(
				RDBEntityDescriptorEnum.IndexType);
	}

	public void setType(IndexType type) {
		wSet(RDBFeatureDescriptorEnum.type, type);
	}

	public ColumnIndices getColumnIndices() {
		return wGet(RDBFeatureDescriptorEnum.columnIndices).wGetAdapter(
				RDBEntityDescriptorEnum.ColumnIndices);
	}

	public void setColumnIndices(ColumnIndices columnIndices) {
		wSet(RDBFeatureDescriptorEnum.columnIndices, columnIndices);
	}
}
