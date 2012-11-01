package org.whole.lang.math.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;

/** 
 * @generator Whole
 */
public interface IMathEntity extends IEntity {
	public void accept(IMathVisitor visitor);
}
