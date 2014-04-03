package org.whole.lang.modules.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.modules.visitors.IModulesVisitor;

/**
 *  @generator  Whole
 */
public interface IModulesEntity extends IEntity {


    public void accept(IModulesVisitor visitor);
}
