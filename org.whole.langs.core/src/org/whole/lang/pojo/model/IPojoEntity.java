package org.whole.lang.pojo.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;

/** 
 * @generator Whole
 */
public interface IPojoEntity extends IEntity {
	public void accept(IPojoVisitor visitor);
}
