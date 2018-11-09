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
public class UniqueTableConstraintAdapter extends AbstractEntityAdapter implements UniqueTableConstraint {
	private static final long serialVersionUID = 1;

	public UniqueTableConstraintAdapter(IEntity implementor) {
		super(implementor);
	}

	public UniqueTableConstraintAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UniqueTableConstraint> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UniqueTableConstraint;
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
