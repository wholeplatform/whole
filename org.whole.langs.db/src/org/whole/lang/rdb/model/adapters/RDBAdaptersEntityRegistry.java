package org.whole.lang.rdb.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class RDBAdaptersEntityRegistry extends AbstractEntityRegistry {
	public RDBAdaptersEntityRegistry() {
		super(RDBEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DatabaseAdapter());
		put(new SchemasAdapter());
		put(new SchemaAdapter());
		put(new TablesAdapter());
		put(new TableAdapter());
		put(new ColumnsAdapter());
		put(new ColumnAdapter());
		put(new PrimaryKeyAdapter());
		put(new ColumnNamesAdapter());
		put(new ForeignKeysAdapter());
		put(new ForeignKeyAdapter());
		put(new ColumnReferencesAdapter());
		put(new ColumnReferenceAdapter());
		put(new IndicesAdapter());
		put(new IndexAdapter());
		put(new ColumnIndicesAdapter());
		put(new ColumnIndexAdapter());
		put(new TypeAdapter());
		put(new IndexTypeAdapter());
		put(new OrderAdapter());
		put(new IdMethodAdapter());
		put(new ActionAdapter());
		put(new DeferrabilityAdapter());
		put(new URIAdapter());
		put(new NamespaceAdapter());
		put(new NameAdapter());
		put(new StringDataAdapter());
		put(new IntDataAdapter());
		put(new BooleanDataAdapter());
	}
}
