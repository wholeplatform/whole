package org.whole.lang.grammars.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;

/** 
 * @generator Whole
 */
public interface IGrammarsEntity extends IEntity {
	public void accept(IGrammarsVisitor visitor);
}
