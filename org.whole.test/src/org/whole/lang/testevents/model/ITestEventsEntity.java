package org.whole.lang.testevents.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;

/** 
 * @generator Whole
 */
public interface ITestEventsEntity extends IEntity {
	public void accept(ITestEventsVisitor visitor);
}
