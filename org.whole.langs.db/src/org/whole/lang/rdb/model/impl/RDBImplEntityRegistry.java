package org.whole.lang.rdb.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RDBImplEntityRegistry extends AbstractEntityRegistry {
	public RDBImplEntityRegistry() {
		super(RDBEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DatabaseImpl());
		put(new SchemasImpl());
		put(new SchemaImpl());
		put(new TablesImpl());
		put(new TableImpl());
		put(new ColumnsImpl());
		put(new ColumnImpl());
		put(new PrimaryKeyImpl());
		put(new ColumnNamesImpl());
		put(new ForeignKeysImpl());
		put(new ForeignKeyImpl());
		put(new ColumnReferencesImpl());
		put(new ColumnReferenceImpl());
		put(new IndicesImpl());
		put(new IndexImpl());
		put(new ColumnIndicesImpl());
		put(new ColumnIndexImpl());
		put(new TypeImpl());
		put(new IndexTypeImpl());
		put(new OrderImpl());
		put(new IdMethodImpl());
		put(new ActionImpl());
		put(new DeferrabilityImpl());
		put(new URIImpl());
		put(new NamespaceImpl());
		put(new NameImpl());
		put(new StringDataImpl());
		put(new IntDataImpl());
		put(new BooleanDataImpl());
	}
}
