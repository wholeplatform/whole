package org.whole.lang.modules.visitors;

import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IBinaryVisitor;
import org.whole.lang.visitors.IUnaryVisitor;

/**
 *  @generator  Whole
 */
public class ModulesTraversalFactory extends GenericTraversalFactory {
    public static final ModulesTraversalFactory instance = new ModulesTraversalFactory();

    private ModulesTraversalFactory() {
    }

    protected IVisitor ensureSpecific(IVisitor visitor) {
        if (visitor instanceof IModulesVisitor)
            return visitor;
        else
            return new ModulesForwardGenericVisitor(visitor);
    }

    public IVisitor failure() {
        return new ModulesFailureVisitor();
    }

    public IVisitor identity() {
        return new ModulesIdentityVisitor();
    }

    public IVisitor forwardStaged() {
        return new ModulesForwardStagedVisitor();
    }

    public IBinaryVisitor sequence(IVisitor visitor1, IVisitor visitor2) {
        return new ModulesSequenceVisitor(ensureSpecific(visitor1), ensureSpecific(visitor2));
    }

    public IUnaryVisitor traverseAll(IVisitor visitor1) {
        return new ModulesTraverseAllVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllChildren(IVisitor visitor1) {
        return new ModulesTraverseAllChildrenVisitor(ensureSpecific(visitor1));
    }

    public IUnaryVisitor traverseAllAdjacents(IVisitor visitor1) {
        return new ModulesTraverseAllAdjacentsVisitor(ensureSpecific(visitor1));
    }
}
