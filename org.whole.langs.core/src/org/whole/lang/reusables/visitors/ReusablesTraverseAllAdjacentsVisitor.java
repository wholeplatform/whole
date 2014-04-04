package org.whole.lang.reusables.visitors;

import org.whole.lang.reusables.visitors.ReusablesIdentityUnaryVisitor;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class ReusablesTraverseAllAdjacentsVisitor extends ReusablesIdentityUnaryVisitor<IReusablesVisitor> {

    public ReusablesTraverseAllAdjacentsVisitor() {
        wSetVisitor1(this);
    }

    public ReusablesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
        super(visitor1);
    }
}
