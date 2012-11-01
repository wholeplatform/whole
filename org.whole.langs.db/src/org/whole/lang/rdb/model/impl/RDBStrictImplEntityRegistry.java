package org.whole.lang.rdb.model.impl;

/** 
 * @generator Whole
 */
public class RDBStrictImplEntityRegistry extends RDBImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new SchemasStrictImpl());
		put(new TablesStrictImpl());
		put(new ColumnsStrictImpl());
		put(new ColumnNamesStrictImpl());
		put(new ColumnIndicesStrictImpl());
	}
}
