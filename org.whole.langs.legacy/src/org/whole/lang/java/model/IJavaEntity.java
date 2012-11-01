package org.whole.lang.java.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;

/** 
 * @generator Whole
 */
public interface IJavaEntity extends IEntity {
	public void accept(IJavaVisitor visitor);
}
