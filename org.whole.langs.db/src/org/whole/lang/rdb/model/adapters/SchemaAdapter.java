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
public class SchemaAdapter extends AbstractEntityAdapter implements Schema {
	private static final long serialVersionUID = 1;

	public SchemaAdapter(IEntity implementor) {
		super(implementor);
	}

	public SchemaAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Schema> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Schema;
	}

	public StringData getName() {
		return wGet(RDBFeatureDescriptorEnum.name).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setName(StringData name) {
		wSet(RDBFeatureDescriptorEnum.name, name);
	}

	public StringData getModelName() {
		return wGet(RDBFeatureDescriptorEnum.modelName).wGetAdapter(
				RDBEntityDescriptorEnum.StringData);
	}

	public void setModelName(StringData modelName) {
		wSet(RDBFeatureDescriptorEnum.modelName, modelName);
	}

	public Tables getTables() {
		return wGet(RDBFeatureDescriptorEnum.tables).wGetAdapter(
				RDBEntityDescriptorEnum.Tables);
	}

	public void setTables(Tables tables) {
		wSet(RDBFeatureDescriptorEnum.tables, tables);
	}
}
