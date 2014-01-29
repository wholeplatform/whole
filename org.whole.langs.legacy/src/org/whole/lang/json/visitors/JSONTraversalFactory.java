package org.whole.lang.json.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/**
 *  @generator  Whole
 */
public class JSONTraversalFactory extends GenericTraversalFactory {
    public static final JSONTraversalFactory instance = new JSONTraversalFactory();

    private JSONTraversalFactory() {
    }

    protected IVisitor ensureSpecific(IVisitor visitor) {
        if (visitor instanceof IJSONVisitor)
            return visitor;
        else
            return new JSONForwardGenericVisitor(visitor);
    }

    public IVisitor failure() {
        return new JSONFailureVisitor();
    }

    public IVisitor identity() {
        return new JSONIdentityVisitor();
    }

    public IVisitor forwardStaged() {
        return new JSONForwardStagedVisitor();
    }

    public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
        return new JSONSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
    }

    public IUnaryVisitor traverseAll(IVisitor visitor1) {
        return new JSONTraverseAllVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
        return new JSONTraverseAllChildrenVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
        return new JSONTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
    }
}
