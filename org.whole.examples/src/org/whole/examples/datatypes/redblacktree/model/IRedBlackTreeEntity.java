package org.whole.examples.datatypes.redblacktree.model;

import org.whole.lang.model.IEntity;
import org.whole.examples.datatypes.redblacktree.visitors.IRedBlackTreeVisitor;

/** 
 * @generator Whole
 */
public interface IRedBlackTreeEntity extends IEntity {
	public void accept(IRedBlackTreeVisitor visitor);
}
