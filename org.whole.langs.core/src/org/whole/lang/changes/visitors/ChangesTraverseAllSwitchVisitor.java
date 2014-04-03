package org.whole.lang.changes.visitors;

import org.whole.lang.changes.visitors.ChangesIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.changes.model.*;

/**
 *  @generator  Whole
 */
public class ChangesTraverseAllSwitchVisitor extends ChangesIdentityUnaryVisitor<IVisitor> {

    public ChangesTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(RevisionFrame entity) {
        wGetVisitor1().visit(entity.getBaseRevisions());
        wGetVisitor1().visit(entity.getLeftRevisions());
        wGetVisitor1().visit(entity.getRightRevisions());
        wGetVisitor1().visit(entity.getBaseContent());
        wGetVisitor1().visit(entity.getLeftContent());
        wGetVisitor1().visit(entity.getRightContent());
    }

    public void visit(RevisionTrack entity) {
        wGetVisitor1().visit(entity.getRevisions());
        wGetVisitor1().visit(entity.getCompare());
    }

    public void visit(Revisions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Revision entity) {
        wGetVisitor1().visit(entity.getRevisor());
        wGetVisitor1().visit(entity.getChanges());
    }

    public void visit(RevisionChanges entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(RevisionChange entity) {
        wGetVisitor1().visit(entity.getSides());
    }

    public void visit(ChangeSides entity) {
        for (ChangeSide child : entity)
            wGetVisitor1().visit(child);
    }

    public void visit(ChangeRevisions entity) {
        for (RevisionChange child : entity)
            wGetVisitor1().visit(child);
    }

    public void visit(UnifiedCompare entity) {
        wGetVisitor1().visit(entity.getUnifiedContent());
    }

    public void visit(SideBySideCompare entity) {
        wGetVisitor1().visit(entity.getBaseContent());
        wGetVisitor1().visit(entity.getFirstRevisedContent());
        wGetVisitor1().visit(entity.getSecondRevisedContent());
    }

    public void visit(ChangeSide entity) {
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Changes entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Relate entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Cut entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getClipboard());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Copy entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getClipboard());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Paste entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getClipboard());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Delete entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Insert entity) {
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Replace entity) {
        wGetVisitor1().visit(entity.getDeleteContent());
        wGetVisitor1().visit(entity.getInsertContent());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Wrap entity) {
        wGetVisitor1().visit(entity.getCutContent());
        wGetVisitor1().visit(entity.getInsertContent());
        wGetVisitor1().visit(entity.getClipboard());
        wGetVisitor1().visit(entity.getRevisions());
    }

    public void visit(Comment entity) {
        wGetVisitor1().visit(entity.getComment());
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getRevisions());
    }
}
