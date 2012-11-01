package org.whole.lang.misc.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.misc.visitors.IMiscVisitor;

/** 
 * @generator Whole
 */
public interface IMiscEntity extends IEntity {
	public void accept(IMiscVisitor visitor);
}
