package org.whole.lang.modules.visitors;

import org.whole.lang.modules.model.*;

/**
 *  @generator  Whole
 */
public class ModulesForwardStagedVisitor extends ModulesIdentityVisitor {

    public void visit(Module entity) {
        stagedVisit(entity);
    }

    public void visit(Include entity) {
        stagedVisit(entity);
    }

    public void visit(Reuse entity) {
        stagedVisit(entity);
    }

    public void visit(Resource entity) {
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

    public void visit(Registry entity) {
        stagedVisit(entity);
    }
}
