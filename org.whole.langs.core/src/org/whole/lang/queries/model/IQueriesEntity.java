package org.whole.lang.queries.model;

import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;

/**
 *  @generator  Whole
 */
public interface IQueriesEntity extends IEntity {


    public void accept(IQueriesVisitor visitor);
}
