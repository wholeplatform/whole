package org.whole.lang.reusables.visitors;

import org.whole.lang.reusables.model.*;

/**
 *  @generator  Whole
 */
public class ReusablesForwardStagedVisitor extends ReusablesIdentityVisitor {

    public void visit(Adapt entity) {
        stagedVisit(entity);
    }

    public void visit(Reuse entity) {
        stagedVisit(entity);
    }

    public void visit(Synch entity) {
        stagedVisit(entity);
    }

    public void visit(Include entity) {
        stagedVisit(entity);
    }

    public void visit(Reusables entity) {
        stagedVisit(entity);
    }

    public void visit(ReferenceStep entity) {
        stagedVisit(entity);
    }

    public void visit(Resource entity) {
        stagedVisit(entity);
    }

    public void visit(Registry entity) {
        stagedVisit(entity);
    }

    public void visit(WorkspacePath entity) {
        stagedVisit(entity);
    }

    public void visit(FileSystemPath entity) {
        stagedVisit(entity);
    }

    public void visit(ClassPathURI entity) {
        stagedVisit(entity);
    }

    public void visit(URI entity) {
        stagedVisit(entity);
    }

    public void visit(Persistence entity) {
        stagedVisit(entity);
    }
}
