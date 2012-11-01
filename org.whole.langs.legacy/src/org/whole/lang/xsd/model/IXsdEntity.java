package org.whole.lang.xsd.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.xsd.visitors.IXsdVisitor;

/** 
 * @generator Whole
 */
public interface IXsdEntity extends IEntity {
	public void accept(IXsdVisitor visitor);
}
