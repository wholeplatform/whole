package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SubqueryImpl extends AbstractSimpleEntity implements Subquery {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Subquery> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Subquery;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.Subquery_ord;
	}

	public void accept(ISQLVisitor visitor) {
		visitor.visit(this);
	}

	private SelectSQLStatement query;

	public SelectSQLStatement getQuery() {
		return notifyRequested(SQLFeatureDescriptorEnum.query, query);
	}

	public void setQuery(SelectSQLStatement query) {
		notifyChanged(SQLFeatureDescriptorEnum.query, this.query,
				this.query = query);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getQuery().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setQuery(value
					.wGetAdapter(SQLEntityDescriptorEnum.SelectSQLStatement));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
