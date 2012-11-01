package org.whole.lang.xsd.mapping.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.mapping.visitors.IMappingVisitor;

/** 
 * @generator Whole
 */
public interface IMappingEntity extends IEntity {
	public void accept(IMappingVisitor visitor);
}
