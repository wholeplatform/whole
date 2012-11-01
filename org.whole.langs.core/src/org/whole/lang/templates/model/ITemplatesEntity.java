package org.whole.lang.templates.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.templates.visitors.ITemplatesVisitor;

/** 
 * @generator Whole
 */
public interface ITemplatesEntity extends IEntity {
	public void accept(ITemplatesVisitor visitor);
}
