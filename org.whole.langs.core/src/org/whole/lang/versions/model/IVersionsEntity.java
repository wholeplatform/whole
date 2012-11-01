package org.whole.lang.versions.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.versions.visitors.IVersionsVisitor;

/** 
 * @generator Whole
 */
public interface IVersionsEntity extends IEntity {
	public void accept(IVersionsVisitor visitor);
}
