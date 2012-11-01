package org.whole.lang.rdb.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;

/** 
 * @generator Whole
 */
public interface IRDBEntity extends IEntity {
	public void accept(IRDBVisitor visitor);
}
