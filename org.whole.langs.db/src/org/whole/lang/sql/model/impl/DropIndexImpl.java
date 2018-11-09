package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.DropIndex;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.IndexName;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DropIndexImpl extends AbstractSimpleEntity implements DropIndex {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DropIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.DropIndex;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.DropIndex_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private IndexName indexName;

	public IndexName getIndexName() {
		return notifyRequested(SQLFeatureDescriptorEnum.indexName, indexName);
	}

	public void setIndexName(IndexName indexName) {
		notifyChanged(SQLFeatureDescriptorEnum.indexName, this.indexName, this.indexName = indexName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIndexName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIndexName(value.wGetAdapter(SQLEntityDescriptorEnum.IndexName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
