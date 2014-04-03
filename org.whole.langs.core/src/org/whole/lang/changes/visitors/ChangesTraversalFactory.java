package org.whole.lang.changes.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/**
 *  @generator  Whole
 */
public class ChangesTraversalFactory extends GenericTraversalFactory {
    public static final ChangesTraversalFactory instance = new ChangesTraversalFactory();

    private ChangesTraversalFactory() {
    }

    protected IVisitor ensureSpecific(IVisitor visitor) {
        if (visitor instanceof IChangesVisitor)
            return visitor;
        else
            return new ChangesForwardGenericVisitor(visitor);
    }

    public IVisitor failure() {
        return new ChangesFailureVisitor();
    }

    public IVisitor identity() {
        return new ChangesIdentityVisitor();
    }

    public IVisitor forwardStaged() {
        return new ChangesForwardStagedVisitor();
    }

    public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
        return new ChangesSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
    }

    public IUnaryVisitor traverseAll(IVisitor visitor1) {
        return new ChangesTraverseAllVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
        return new ChangesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
        return new ChangesTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
    }
}
