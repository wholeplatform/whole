package org.whole.examples.lang.imp.model;

import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;

/** 
 * @generator Whole
 */
public interface IImpEntity extends IEntity {
	public void accept(IImpVisitor visitor);
}
