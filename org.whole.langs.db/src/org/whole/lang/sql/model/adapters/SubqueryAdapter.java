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
public class SubqueryAdapter extends AbstractEntityAdapter implements Subquery {
	private static final long serialVersionUID = 1;

	public SubqueryAdapter(IEntity implementor) {
		super(implementor);
	}

	public SubqueryAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Subquery> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Subquery;
	}

	public SelectSQLStatement getQuery() {
		return wGet(SQLFeatureDescriptorEnum.query).wGetAdapter(SQLEntityDescriptorEnum.SelectSQLStatement);
	}

	public void setQuery(SelectSQLStatement query) {
		wSet(SQLFeatureDescriptorEnum.query, query);
	}
}
