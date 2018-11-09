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
public class ColumnDeclarationAdapter extends AbstractEntityAdapter implements ColumnDeclaration {
	private static final long serialVersionUID = 1;

	public ColumnDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ColumnDeclarationAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ColumnDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ColumnDeclaration;
	}

	public ColumnName getColumnName() {
		return wGet(SQLFeatureDescriptorEnum.columnName).wGetAdapter(SQLEntityDescriptorEnum.ColumnName);
	}

	public void setColumnName(ColumnName columnName) {
		wSet(SQLFeatureDescriptorEnum.columnName, columnName);
	}

	public ColumnType getColumnType() {
		return wGet(SQLFeatureDescriptorEnum.columnType).wGetAdapter(SQLEntityDescriptorEnum.ColumnType);
	}

	public void setColumnType(ColumnType columnType) {
		wSet(SQLFeatureDescriptorEnum.columnType, columnType);
	}

	public ColumnConstraints getColumnConstraints() {
		return wGet(SQLFeatureDescriptorEnum.columnConstraints).wGetAdapter(SQLEntityDescriptorEnum.ColumnConstraints);
	}

	public void setColumnConstraints(ColumnConstraints columnConstraints) {
		wSet(SQLFeatureDescriptorEnum.columnConstraints, columnConstraints);
	}
}
