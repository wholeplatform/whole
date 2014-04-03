package org.whole.lang.changes.visitors;

import org.whole.lang.changes.model.*;

/**
 *  @generator  Whole
 */
public class ChangesIdentityDefaultVisitor extends ChangesIdentityVisitor {

    public void visit(IChangesEntity entity) {
    }

    public void visit(RevisionFrame entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(RevisionTrack entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(Revisions entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(Revision entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(RevisionChanges entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(RevisionChange entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(ChangeSides entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(ChangeRevisions entity) {
        visit((IChangesEntity) entity);
    }

    public void visit(ContentCompare entity) {
    }

    public void visit(UnifiedCompare entity) {
        visit((IChangesEntity) entity);
        visit((ContentCompare) entity);
    }

    public void visit(SideBySideCompare entity) {
        visit((IChangesEntity) entity);
        visit((ContentCompare) entity);
    }

    public void visit(Content entity) {
    }

    public void visit(Nothing entity) {
        visit((IChangesEntity) entity);
        visit((Content) entity);
    }

    public void visit(Change entity) {
        visit((Content) entity);
    }

    public void visit(Changes entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
    }

    public void visit(Relate entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(ChangeSide entity) {
    }

    public void visit(Cut entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Copy entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Paste entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Delete entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Insert entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Replace entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Wrap entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Comment entity) {
        visit((IChangesEntity) entity);
        visit((Change) entity);
        visit((ChangeSide) entity);
    }

    public void visit(Revisor entity) {
    }

    public void visit(Text entity) {
        visit((IChangesEntity) entity);
        visit((Revisor) entity);
    }

    public void visit(Clipboard entity) {
        visit((IChangesEntity) entity);
    }
}
