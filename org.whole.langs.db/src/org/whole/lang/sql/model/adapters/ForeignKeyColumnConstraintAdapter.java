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
public class ForeignKeyColumnConstraintAdapter extends AbstractEntityAdapter implements ForeignKeyColumnConstraint {
	private static final long serialVersionUID = 1;

	public ForeignKeyColumnConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForeignKeyColumnConstraintAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForeignKeyColumnConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ForeignKeyColumnConstraint;
	}

	public TableName getForeignTableName() {
		return wGet(SQLFeatureDescriptorEnum.foreignTableName).wGetAdapter(SQLEntityDescriptorEnum.TableName);
	}

	public void setForeignTableName(TableName foreignTableName) {
		wSet(SQLFeatureDescriptorEnum.foreignTableName, foreignTableName);
	}

	public ColumnName getForeignColumnName() {
		return wGet(SQLFeatureDescriptorEnum.foreignColumnName).wGetAdapter(SQLEntityDescriptorEnum.ColumnName);
	}

	public void setForeignColumnName(ColumnName foreignColumnName) {
		wSet(SQLFeatureDescriptorEnum.foreignColumnName, foreignColumnName);
	}
}
