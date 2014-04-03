package org.whole.lang.changes.visitors;

import org.whole.lang.changes.visitors.ChangesIdentityUnaryVisitor;
import org.whole.lang.changes.visitors.IChangesVisitor;
import org.whole.lang.changes.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class ChangesTraverseAllVisitor extends ChangesIdentityUnaryVisitor<IChangesVisitor> {

    public ChangesTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public ChangesTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(RevisionFrame entity) {
        entity.getBaseRevisions().accept(wGetVisitor1());
        entity.getLeftRevisions().accept(wGetVisitor1());
        entity.getRightRevisions().accept(wGetVisitor1());
        entity.getBaseContent().accept(wGetVisitor1());
        entity.getLeftContent().accept(wGetVisitor1());
        entity.getRightContent().accept(wGetVisitor1());
    }

    public void visit(RevisionTrack entity) {
        entity.getRevisions().accept(wGetVisitor1());
        entity.getCompare().accept(wGetVisitor1());
    }

    public void visit(Revisions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Revision entity) {
        entity.getRevisor().accept(wGetVisitor1());
        entity.getChanges().accept(wGetVisitor1());
    }

    public void visit(RevisionChanges entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
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

    public void visit(UnifiedCompare entity) {
        entity.getUnifiedContent().accept(wGetVisitor1());
    }

    public void visit(SideBySideCompare entity) {
        entity.getBaseContent().accept(wGetVisitor1());
        entity.getFirstRevisedContent().accept(wGetVisitor1());
        entity.getSecondRevisedContent().accept(wGetVisitor1());
    }

    public void visit(ChangeSide entity) {
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Changes entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Relate entity) {
        entity.getContent().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Cut entity) {
        entity.getContent().accept(wGetVisitor1());
        entity.getClipboard().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Copy entity) {
        entity.getContent().accept(wGetVisitor1());
        entity.getClipboard().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Paste entity) {
        entity.getContent().accept(wGetVisitor1());
        entity.getClipboard().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Delete entity) {
        entity.getContent().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Insert entity) {
        entity.getContent().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Replace entity) {
        entity.getDeleteContent().accept(wGetVisitor1());
        entity.getInsertContent().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Wrap entity) {
        entity.getCutContent().accept(wGetVisitor1());
        entity.getInsertContent().accept(wGetVisitor1());
        entity.getClipboard().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }

    public void visit(Comment entity) {
        entity.getComment().accept(wGetVisitor1());
        entity.getContent().accept(wGetVisitor1());
        entity.getRevisions().accept(wGetVisitor1());
    }
}
