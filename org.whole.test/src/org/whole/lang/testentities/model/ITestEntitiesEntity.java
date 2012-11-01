package org.whole.lang.testentities.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;

/** 
 * @generator Whole
 */
public interface ITestEntitiesEntity extends IEntity {
	public void accept(ITestEntitiesVisitor visitor);
}
