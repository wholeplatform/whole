package org.whole.lang.commons.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.commons.visitors.ICommonsVisitor;

/** 
 * @generator Whole
 */
public interface ICommonsEntity extends IEntity {
	public void accept(ICommonsVisitor visitor);
}
