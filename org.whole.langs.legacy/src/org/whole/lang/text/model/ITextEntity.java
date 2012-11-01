package org.whole.lang.text.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.text.visitors.ITextVisitor;

/** 
 * @generator Whole
 */
public interface ITextEntity extends IEntity {
	public void accept(ITextVisitor visitor);
}
