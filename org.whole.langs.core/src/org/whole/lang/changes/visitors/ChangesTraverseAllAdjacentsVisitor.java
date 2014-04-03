package org.whole.lang.changes.visitors;

import org.whole.lang.changes.visitors.ChangesIdentityUnaryVisitor;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class ChangesTraverseAllAdjacentsVisitor extends ChangesIdentityUnaryVisitor<IChangesVisitor> {

    public ChangesTraverseAllAdjacentsVisitor() {
        wSetVisitor1(this);
    }

    public ChangesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(RevisionChange entity) {
        entity.getSides().accept(wGetVisitor1());
    }

    public void visit(ChangeSides entity) {
        for (ChangeSide child : entity)
            child.accept(wGetVisitor1());
    }

    public void visit(ChangeRevisions entity) {
        for (RevisionChange child : entity)
            child.accept(wGetVisitor1());
    }

    public void visit(ChangeSide entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Relate entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Cut entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Copy entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Paste entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Delete entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Insert entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Replace entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Wrap entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Comment entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }
}
