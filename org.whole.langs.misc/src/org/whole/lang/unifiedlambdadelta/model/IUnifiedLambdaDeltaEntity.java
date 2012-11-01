package org.whole.lang.unifiedlambdadelta.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;

/** 
 * @generator Whole
 */
public interface IUnifiedLambdaDeltaEntity extends IEntity {
	public void accept(IUnifiedLambdaDeltaVisitor visitor);
}
