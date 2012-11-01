package org.whole.lang.scheme.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;

/** 
 * @generator Whole
 */
public interface ISchemeEntity extends IEntity {
	public void accept(ISchemeVisitor visitor);
}
