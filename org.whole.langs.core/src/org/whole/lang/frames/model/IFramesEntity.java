package org.whole.lang.frames.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;

/** 
 * @generator Whole
 */
public interface IFramesEntity extends IEntity {
	public void accept(IFramesVisitor visitor);
}
