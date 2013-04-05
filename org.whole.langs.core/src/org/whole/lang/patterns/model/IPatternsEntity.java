package org.whole.lang.patterns.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.visitors.IPatternsVisitor;

/** 
 * @generator Whole
 */
public interface IPatternsEntity extends IEntity {
	public void accept(IPatternsVisitor visitor);
}
