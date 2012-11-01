package org.whole.lang.models.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.models.visitors.IModelsVisitor;

/** 
 * @generator Whole
 */
public interface IModelsEntity extends IEntity {
	public void accept(IModelsVisitor visitor);
}
