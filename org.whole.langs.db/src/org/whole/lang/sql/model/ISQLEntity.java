package org.whole.lang.sql.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;

/** 
 * @generator Whole
 */
public interface ISQLEntity extends IEntity {
	public void accept(ISQLVisitor visitor);
}
