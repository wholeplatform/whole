package org.whole.lang.changes.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.changes.visitors.IChangesVisitor;

/**
 *  @generator  Whole
 */
public interface IChangesEntity extends IEntity {


    public void accept(IChangesVisitor visitor);
}
