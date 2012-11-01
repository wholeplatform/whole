package org.whole.lang.properties.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.properties.visitors.IPropertiesVisitor;

/** 
 * @generator Whole
 */
public interface IPropertiesEntity extends IEntity {
	public void accept(IPropertiesVisitor visitor);
}
