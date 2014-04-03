package org.whole.lang.modules.visitors;

import org.whole.lang.modules.visitors.ModulesIdentityUnaryVisitor;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.modules.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class ModulesTraverseAllAdjacentsVisitor extends ModulesIdentityUnaryVisitor<IModulesVisitor> {

    public ModulesTraverseAllAdjacentsVisitor() {
        wSetVisitor1(this);
    }

    public ModulesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
        super(visitor1);
    }
}
