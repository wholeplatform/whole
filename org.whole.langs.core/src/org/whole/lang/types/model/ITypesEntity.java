package org.whole.lang.types.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;

/** 
 * @generator Whole
 */
public interface ITypesEntity extends IEntity {
	public void accept(ITypesVisitor visitor);
}
