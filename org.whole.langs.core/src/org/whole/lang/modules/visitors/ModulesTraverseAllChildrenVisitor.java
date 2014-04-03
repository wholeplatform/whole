package org.whole.lang.modules.visitors;

import org.whole.lang.modules.visitors.ModulesIdentityUnaryVisitor;
import org.whole.lang.modules.visitors.IModulesVisitor;
import org.whole.lang.modules.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class ModulesTraverseAllChildrenVisitor extends ModulesIdentityUnaryVisitor<IModulesVisitor> {

    public ModulesTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public ModulesTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Module entity) {
        entity.getContent().accept(wGetVisitor1());
    }

    public void visit(Include entity) {
        entity.getResource().accept(wGetVisitor1());
    }

    public void visit(Reuse entity) {
        entity.getResource().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getOriginal().accept(wGetVisitor1());
        entity.getAdapted().accept(wGetVisitor1());
        entity.getVariant().accept(wGetVisitor1());
    }

    public void visit(Resource entity) {
        entity.getLocator().accept(wGetVisitor1());
        entity.getPersistence().accept(wGetVisitor1());
        entity.getRegistry().accept(wGetVisitor1());
    }
}
