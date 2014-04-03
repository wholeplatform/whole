package org.whole.lang.modules.visitors;

import org.whole.lang.modules.visitors.ModulesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.modules.model.*;

/**
 *  @generator  Whole
 */
public class ModulesTraverseAllSwitchVisitor extends ModulesIdentityUnaryVisitor<IVisitor> {

    public ModulesTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Module entity) {
        wGetVisitor1().visit(entity.getContent());
    }

    public void visit(Include entity) {
        wGetVisitor1().visit(entity.getResource());
    }

    public void visit(Reuse entity) {
        wGetVisitor1().visit(entity.getResource());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getVariant());
    }

    public void visit(Resource entity) {
        wGetVisitor1().visit(entity.getLocator());
        wGetVisitor1().visit(entity.getPersistence());
        wGetVisitor1().visit(entity.getRegistry());
    }
}
