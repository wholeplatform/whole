package org.whole.lang.firstorderlogic.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;

/** 
 * @generator Whole
 */
public interface IFirstOrderLogicEntity extends IEntity {
	public void accept(IFirstOrderLogicVisitor visitor);
}
