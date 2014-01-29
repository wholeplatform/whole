package org.whole.lang.json.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;

/**
 *  @generator  Whole
 */
public interface IJSONEntity extends IEntity {


    public void accept(IJSONVisitor visitor);
}
