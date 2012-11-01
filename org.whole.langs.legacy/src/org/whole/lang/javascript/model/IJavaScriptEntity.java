package org.whole.lang.javascript.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;

/** 
 * @generator Whole
 */
public interface IJavaScriptEntity extends IEntity {
	public void accept(IJavaScriptVisitor visitor);
}
