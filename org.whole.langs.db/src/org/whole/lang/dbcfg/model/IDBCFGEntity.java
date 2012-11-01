package org.whole.lang.dbcfg.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;

/** 
 * @generator Whole
 */
public interface IDBCFGEntity extends IEntity {
	public void accept(IDBCFGVisitor visitor);
}
