package org.whole.lang.changes.visitors;

import org.whole.lang.changes.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator  Whole
 */
public class ChangesFailureVisitor extends ChangesIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(RevisionFrame entity) {
        throw new VisitException();
    }

    public void visit(RevisionTrack entity) {
        throw new VisitException();
    }

    public void visit(Revisions entity) {
        throw new VisitException();
    }

    public void visit(Revision entity) {
        throw new VisitException();
    }

    public void visit(RevisionChanges entity) {
        throw new VisitException();
    }

    public void visit(RevisionChange entity) {
        throw new VisitException();
    }

    public void visit(ChangeSides entity) {
        throw new VisitException();
    }

    public void visit(ChangeRevisions entity) {
        throw new VisitException();
    }

    public void visit(UnifiedCompare entity) {
        throw new VisitException();
    }

    public void visit(SideBySideCompare entity) {
        throw new VisitException();
    }

    public void visit(Nothing entity) {
        throw new VisitException();
    }

    public void visit(Changes entity) {
        throw new VisitException();
    }

    public void visit(Relate entity) {
        throw new VisitException();
    }

    public void visit(Cut entity) {
        throw new VisitException();
    }

    public void visit(Copy entity) {
        throw new VisitException();
    }

    public void visit(Paste entity) {
        throw new VisitException();
    }

    public void visit(Delete entity) {
        throw new VisitException();
    }

    public void visit(Insert entity) {
        throw new VisitException();
    }

    public void visit(Replace entity) {
        throw new VisitException();
    }

    public void visit(Wrap entity) {
        throw new VisitException();
    }

    public void visit(Comment entity) {
        throw new VisitException();
    }

    public void visit(Text entity) {
        throw new VisitException();
    }

    public void visit(Clipboard entity) {
        throw new VisitException();
    }
}
