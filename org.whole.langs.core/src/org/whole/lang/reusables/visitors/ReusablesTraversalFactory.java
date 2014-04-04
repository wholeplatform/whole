package org.whole.lang.reusables.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/**
 *  @generator  Whole
 */
public class ReusablesTraversalFactory extends GenericTraversalFactory {
    public static final ReusablesTraversalFactory instance = new ReusablesTraversalFactory();

    private ReusablesTraversalFactory() {
    }

    protected IVisitor ensureSpecific(IVisitor visitor) {
        if (visitor instanceof IReusablesVisitor)
            return visitor;
        else
            return new ReusablesForwardGenericVisitor(visitor);
    }

    public IVisitor failure() {
        return new ReusablesFailureVisitor();
    }

    public IVisitor identity() {
        return new ReusablesIdentityVisitor();
    }

    public IVisitor forwardStaged() {
        return new ReusablesForwardStagedVisitor();
    }

    public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
        return new ReusablesSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
    }

    public IUnaryVisitor traverseAll(IVisitor visitor1) {
        return new ReusablesTraverseAllVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
        return new ReusablesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
        return new ReusablesTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
    }
}
