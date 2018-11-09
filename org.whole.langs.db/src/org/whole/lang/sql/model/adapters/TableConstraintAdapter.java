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
public class TableConstraintAdapter extends AbstractEntityAdapter implements TableConstraint {
	private static final long serialVersionUID = 1;

	public TableConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public TableConstraintAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<TableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.TableConstraint;
	}

	public ConstraintName getConstraintName() {
		return wGet(SQLFeatureDescriptorEnum.constraintName).wGetAdapter(SQLEntityDescriptorEnum.ConstraintName);
	}

	public void setConstraintName(ConstraintName constraintName) {
		wSet(SQLFeatureDescriptorEnum.constraintName, constraintName);
	}

	public ColumnNames getColumnNames() {
		return wGet(SQLFeatureDescriptorEnum.columnNames).wGetAdapter(SQLEntityDescriptorEnum.ColumnNames);
	}

	public void setColumnNames(ColumnNames columnNames) {
		wSet(SQLFeatureDescriptorEnum.columnNames, columnNames);
	}
}
