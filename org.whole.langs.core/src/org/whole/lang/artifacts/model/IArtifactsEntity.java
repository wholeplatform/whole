package org.whole.lang.artifacts.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;

/** 
 * @generator Whole
 */
public interface IArtifactsEntity extends IEntity {
	public void accept(IArtifactsVisitor visitor);
}
