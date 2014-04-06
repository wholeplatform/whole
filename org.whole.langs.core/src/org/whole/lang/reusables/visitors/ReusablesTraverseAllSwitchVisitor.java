package org.whole.lang.reusables.visitors;

import org.whole.lang.reusables.visitors.ReusablesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.reusables.model.*;

/**
 *  @generator  Whole
 */
public class ReusablesTraverseAllSwitchVisitor extends ReusablesIdentityUnaryVisitor<IVisitor> {

    public ReusablesTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Adapt entity) {
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getAdaptedRevision());
    }

    public void visit(Reuse entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getAdaptedRevision());
    }

    public void visit(Synch entity) {
        wGetVisitor1().visit(entity.getSource());
        wGetVisitor1().visit(entity.getOriginal());
        wGetVisitor1().visit(entity.getAdapter());
        wGetVisitor1().visit(entity.getAdapted());
        wGetVisitor1().visit(entity.getAdaptedRevision());
        wGetVisitor1().visit(entity.getVariant());
        wGetVisitor1().visit(entity.getVariantRevision());
    }

    public void visit(Include entity) {
        wGetVisitor1().visit(entity.getSource());
    }

    public void visit(Reusables entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ReferenceStep entity) {
        wGetVisitor1().visit(entity.getSource());
    }

    public void visit(Resource entity) {
        wGetVisitor1().visit(entity.getLocator());
        wGetVisitor1().visit(entity.getPersistence());
    }

    public void visit(Registry entity) {
        wGetVisitor1().visit(entity.getLocator());
        wGetVisitor1().visit(entity.getUri());
    }
}
