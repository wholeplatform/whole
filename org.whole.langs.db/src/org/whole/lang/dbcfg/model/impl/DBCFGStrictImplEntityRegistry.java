package org.whole.lang.dbcfg.model.impl;

/** 
 * @generator Whole
 */
public class DBCFGStrictImplEntityRegistry extends DBCFGImplEntityRegistry {
	protected void createPrototypes() {
		super.createPrototypes();
		put(new JDBCDriversStrictImpl());
		put(new FilesStrictImpl());
	}
}
