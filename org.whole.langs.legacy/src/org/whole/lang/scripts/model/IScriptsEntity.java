package org.whole.lang.scripts.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.scripts.visitors.IScriptsVisitor;

/** 
 * @generator Whole
 */
public interface IScriptsEntity extends IEntity {
	public void accept(IScriptsVisitor visitor);
}
