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
public class DropIndexAdapter extends AbstractEntityAdapter implements DropIndex {
	private static final long serialVersionUID = 1;

	public DropIndexAdapter(IEntity implementor) {
		super(implementor);
	}

	public DropIndexAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DropIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DropIndex;
	}

	public IndexName getIndexName() {
		return wGet(SQLFeatureDescriptorEnum.indexName).wGetAdapter(SQLEntityDescriptorEnum.IndexName);
	}

	public void setIndexName(IndexName indexName) {
		wSet(SQLFeatureDescriptorEnum.indexName, indexName);
	}
}
