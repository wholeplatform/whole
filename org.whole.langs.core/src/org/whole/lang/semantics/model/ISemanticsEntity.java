package org.whole.lang.semantics.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;

/** 
 * @generator Whole
 */
public interface ISemanticsEntity extends IEntity {
	public void accept(ISemanticsVisitor visitor);
}
