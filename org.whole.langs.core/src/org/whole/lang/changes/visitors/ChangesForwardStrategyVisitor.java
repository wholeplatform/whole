package org.whole.lang.changes.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.changes.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ChangesForwardStrategyVisitor extends GenericForwardStrategyVisitor<IChangesVisitor> implements IChangesVisitor {

    public ChangesForwardStrategyVisitor() {
        this(new ChangesIdentityVisitor());
    }

    public ChangesForwardStrategyVisitor(IChangesVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IChangesEntity) entity).accept(this);
    }

    public void visit(RevisionFrame entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RevisionTrack entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Revisions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Revision entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RevisionChanges entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RevisionChange entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ChangeSides entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ChangeRevisions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnifiedCompare entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SideBySideCompare entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Nothing entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Changes entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Relate entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cut entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Copy entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Paste entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Delete entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Insert entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Replace entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Wrap entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Comment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Text entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Clipboard entity) {
        wGetStrategy().visit(entity);
    }
}
