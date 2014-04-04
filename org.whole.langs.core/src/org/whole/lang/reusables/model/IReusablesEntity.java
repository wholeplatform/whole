package org.whole.lang.reusables.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.visitors.IReusablesVisitor;

/**
 *  @generator  Whole
 */
public interface IReusablesEntity extends IEntity {


    public void accept(IReusablesVisitor visitor);
}
