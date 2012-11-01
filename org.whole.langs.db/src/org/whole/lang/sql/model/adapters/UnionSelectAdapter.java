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
public class UnionSelectAdapter extends AbstractEntityAdapter implements
		UnionSelect {
	private static final long serialVersionUID = 1;

	public UnionSelectAdapter(IEntity implementor) {
		super(implementor);
	}

	public UnionSelectAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<UnionSelect> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.UnionSelect;
	}

	public Select getSimpleSelect() {
		return wGet(SQLFeatureDescriptorEnum.simpleSelect).wGetAdapter(
				SQLEntityDescriptorEnum.Select);
	}

	public void setSimpleSelect(Select simpleSelect) {
		wSet(SQLFeatureDescriptorEnum.simpleSelect, simpleSelect);
	}

	public SelectSQLStatement getUnionSelectStatement() {
		return wGet(SQLFeatureDescriptorEnum.unionSelectStatement).wGetAdapter(
				SQLEntityDescriptorEnum.SelectSQLStatement);
	}

	public void setUnionSelectStatement(SelectSQLStatement unionSelectStatement) {
		wSet(SQLFeatureDescriptorEnum.unionSelectStatement,
				unionSelectStatement);
	}
}
