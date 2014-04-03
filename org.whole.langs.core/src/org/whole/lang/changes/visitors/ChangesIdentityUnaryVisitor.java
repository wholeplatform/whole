package org.whole.lang.changes.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ChangesIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IChangesVisitor {

    public ChangesIdentityUnaryVisitor() {
        super(null);
    }

    public ChangesIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IChangesEntity) entity).accept(this);
    }

    public void visit(RevisionFrame entity) {
    }

    public void visit(RevisionTrack entity) {
    }

    public void visit(Revisions entity) {
    }

    public void visit(Revision entity) {
    }

    public void visit(RevisionChanges entity) {
    }

    public void visit(RevisionChange entity) {
    }

    public void visit(ChangeSides entity) {
    }

    public void visit(ChangeRevisions entity) {
    }

    public void visit(UnifiedCompare entity) {
    }

    public void visit(SideBySideCompare entity) {
    }

    public void visit(Nothing entity) {
    }

    public void visit(Changes entity) {
    }

    public void visit(Relate entity) {
    }

    public void visit(Cut entity) {
    }

    public void visit(Copy entity) {
    }

    public void visit(Paste entity) {
    }

    public void visit(Delete entity) {
    }

    public void visit(Insert entity) {
    }

    public void visit(Replace entity) {
    }

    public void visit(Wrap entity) {
    }

    public void visit(Comment entity) {
    }

    public void visit(Text entity) {
    }

    public void visit(Clipboard entity) {
    }
}
