package org.whole.lang.reusables.visitors;

import org.whole.lang.reusables.visitors.ReusablesIdentityUnaryVisitor;
import org.whole.lang.reusables.visitors.IReusablesVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class ReusablesTraverseAllVisitor extends ReusablesIdentityUnaryVisitor<IReusablesVisitor> {

    public ReusablesTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public ReusablesTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Adapt entity) {
        entity.getOriginal().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getAdapted().accept(wGetVisitor1());
    }

    public void visit(Reuse entity) {
        entity.getSource().accept(wGetVisitor1());
        entity.getOriginal().accept(wGetVisitor1());
        entity.getAdapter().accept(wGetVisitor1());
        entity.getAdapted().accept(wGetVisitor1());
        entity.getVariant().accept(wGetVisitor1());
    }

    public void visit(Include entity) {
        entity.getSource().accept(wGetVisitor1());
    }

    public void visit(Reusables entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Resource entity) {
        entity.getLocator().accept(wGetVisitor1());
        entity.getPersistence().accept(wGetVisitor1());
    }

    public void visit(Registry entity) {
        entity.getLocator().accept(wGetVisitor1());
        entity.getUri().accept(wGetVisitor1());
    }
}
