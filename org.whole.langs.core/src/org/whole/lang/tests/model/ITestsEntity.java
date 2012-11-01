package org.whole.lang.tests.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;

/** 
 * @generator Whole
 */
public interface ITestsEntity extends IEntity {
	public void accept(ITestsVisitor visitor);
}
