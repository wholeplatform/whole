package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ColumnTypeAdapter extends AbstractEntityAdapter implements ColumnType {
	private static final long serialVersionUID = 1;

	public ColumnTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnTypeAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnType> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnType;
	}

	public Type getType() {
		return wGet(SQLFeatureDescriptorEnum.type).wGetAdapter(SQLEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(SQLFeatureDescriptorEnum.type, type);
	}

	public IntValue getSize() {
		return wGet(SQLFeatureDescriptorEnum.size).wGetAdapter(SQLEntityDescriptorEnum.IntValue);
	}

	public void setSize(IntValue size) {
		wSet(SQLFeatureDescriptorEnum.size, size);
	}

	public IntValue getPrecision() {
		return wGet(SQLFeatureDescriptorEnum.precision).wGetAdapter(SQLEntityDescriptorEnum.IntValue);
	}

	public void setPrecision(IntValue precision) {
		wSet(SQLFeatureDescriptorEnum.precision, precision);
	}
}
