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
public class CreateIndexImpl extends AbstractSimpleEntity implements
		CreateIndex {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CreateIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.CreateIndex;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.CreateIndex_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private UniqueIndex unique;

	public UniqueIndex getUnique() {
		return notifyRequested(SQLFeatureDescriptorEnum.unique, unique);
	}

	public void setUnique(UniqueIndex unique) {
		notifyChanged(SQLFeatureDescriptorEnum.unique, this.unique,
				this.unique = unique);
	}

	private IndexName indexName;

	public IndexName getIndexName() {
		return notifyRequested(SQLFeatureDescriptorEnum.indexName, indexName);
	}

	public void setIndexName(IndexName indexName) {
		notifyChanged(SQLFeatureDescriptorEnum.indexName, this.indexName,
				this.indexName = indexName);
	}

	private TableName tableName;

	public TableName getTableName() {
		return notifyRequested(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public void setTableName(TableName tableName) {
		notifyChanged(SQLFeatureDescriptorEnum.tableName, this.tableName,
				this.tableName = tableName);
	}

	private IndexDeclarations indexDeclarations;

	public IndexDeclarations getIndexDeclarations() {
		return notifyRequested(SQLFeatureDescriptorEnum.indexDeclarations,
				indexDeclarations);
	}

	public void setIndexDeclarations(IndexDeclarations indexDeclarations) {
		notifyChanged(SQLFeatureDescriptorEnum.indexDeclarations,
				this.indexDeclarations,
				this.indexDeclarations = indexDeclarations);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getUnique().wGetAdaptee(false);
		case 1:
			return getIndexName().wGetAdaptee(false);
		case 2:
			return getTableName().wGetAdaptee(false);
		case 3:
			return getIndexDeclarations().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setUnique(value.wGetAdapter(SQLEntityDescriptorEnum.UniqueIndex));
			break;
		case 1:
			setIndexName(value.wGetAdapter(SQLEntityDescriptorEnum.IndexName));
			break;
		case 2:
			setTableName(value.wGetAdapter(SQLEntityDescriptorEnum.TableName));
			break;
		case 3:
			setIndexDeclarations(value
					.wGetAdapter(SQLEntityDescriptorEnum.IndexDeclarations));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
