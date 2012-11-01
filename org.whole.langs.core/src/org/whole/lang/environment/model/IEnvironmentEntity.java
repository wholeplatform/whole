package org.whole.lang.environment.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;

/** 
 * @generator Whole
 */
public interface IEnvironmentEntity extends IEntity {
	public void accept(IEnvironmentVisitor visitor);
}
