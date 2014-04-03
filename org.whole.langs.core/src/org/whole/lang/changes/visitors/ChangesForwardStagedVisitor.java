package org.whole.lang.changes.visitors;

import org.whole.lang.changes.model.*;

/**
 *  @generator  Whole
 */
public class ChangesForwardStagedVisitor extends ChangesIdentityVisitor {

    public void visit(RevisionFrame entity) {
        stagedVisit(entity);
    }

    public void visit(RevisionTrack entity) {
        stagedVisit(entity);
    }

    public void visit(Revisions entity) {
        stagedVisit(entity);
    }

    public void visit(Revision entity) {
        stagedVisit(entity);
    }

    public void visit(RevisionChanges entity) {
        stagedVisit(entity);
    }

    public void visit(RevisionChange entity) {
        stagedVisit(entity);
    }

    public void visit(ChangeSides entity) {
        stagedVisit(entity);
    }

    public void visit(ChangeRevisions entity) {
        stagedVisit(entity);
    }

    public void visit(UnifiedCompare entity) {
        stagedVisit(entity);
    }

    public void visit(SideBySideCompare entity) {
        stagedVisit(entity);
    }

    public void visit(Nothing entity) {
        stagedVisit(entity);
    }

    public void visit(Changes entity) {
        stagedVisit(entity);
    }

    public void visit(Relate entity) {
        stagedVisit(entity);
    }

    public void visit(Cut entity) {
        stagedVisit(entity);
    }

    public void visit(Copy entity) {
        stagedVisit(entity);
    }

    public void visit(Paste entity) {
        stagedVisit(entity);
    }

    public void visit(Delete entity) {
        stagedVisit(entity);
    }

    public void visit(Insert entity) {
        stagedVisit(entity);
    }

    public void visit(Replace entity) {
        stagedVisit(entity);
    }

    public void visit(Wrap entity) {
        stagedVisit(entity);
    }

    public void visit(Comment entity) {
        stagedVisit(entity);
    }

    public void visit(Text entity) {
        stagedVisit(entity);
    }

    public void visit(Clipboard entity) {
        stagedVisit(entity);
    }
}
