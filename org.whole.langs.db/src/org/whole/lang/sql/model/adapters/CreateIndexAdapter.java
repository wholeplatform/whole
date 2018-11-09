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
public class CreateIndexAdapter extends AbstractEntityAdapter implements CreateIndex {
	private static final long serialVersionUID = 1;

	public CreateIndexAdapter(IEntity implementor) {
		super(implementor);
	}

	public CreateIndexAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CreateIndex> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.CreateIndex;
	}

	public UniqueIndex getUnique() {
		return wGet(SQLFeatureDescriptorEnum.unique).wGetAdapter(SQLEntityDescriptorEnum.UniqueIndex);
	}

	public void setUnique(UniqueIndex unique) {
		wSet(SQLFeatureDescriptorEnum.unique, unique);
	}

	public IndexName getIndexName() {
		return wGet(SQLFeatureDescriptorEnum.indexName).wGetAdapter(SQLEntityDescriptorEnum.IndexName);
	}

	public void setIndexName(IndexName indexName) {
		wSet(SQLFeatureDescriptorEnum.indexName, indexName);
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public IndexDeclarations getIndexDeclarations() {
		return wGet(SQLFeatureDescriptorEnum.indexDeclarations).wGetAdapter(SQLEntityDescriptorEnum.IndexDeclarations);
	}

	public void setIndexDeclarations(IndexDeclarations indexDeclarations) {
		wSet(SQLFeatureDescriptorEnum.indexDeclarations, indexDeclarations);
	}
}
