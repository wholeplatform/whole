package org.whole.lang.actions.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.actions.visitors.IActionsVisitor;

/** 
 * @generator Whole
 */
public interface IActionsEntity extends IEntity {
	public void accept(IActionsVisitor visitor);
}
