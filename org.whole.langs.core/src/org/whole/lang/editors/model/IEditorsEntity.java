package org.whole.lang.editors.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.editors.visitors.IEditorsVisitor;

/** 
 * @generator Whole
 */
public interface IEditorsEntity extends IEntity {
	public void accept(IEditorsVisitor visitor);
}
