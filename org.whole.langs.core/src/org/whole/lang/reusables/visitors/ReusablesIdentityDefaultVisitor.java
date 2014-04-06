package org.whole.lang.reusables.visitors;

import org.whole.lang.reusables.model.*;

/**
 *  @generator  Whole
 */
public class ReusablesIdentityDefaultVisitor extends ReusablesIdentityVisitor {

    public void visit(IReusablesEntity entity) {
    }

    public void visit(Adapt entity) {
        visit((IReusablesEntity) entity);
    }

    public void visit(Reuse entity) {
        visit((IReusablesEntity) entity);
    }

    public void visit(Synch entity) {
        visit((IReusablesEntity) entity);
        visit((Reuse) entity);
    }

    public void visit(Include entity) {
        visit((IReusablesEntity) entity);
    }

    public void visit(Reusable entity) {
    }

    public void visit(Reusables entity) {
        visit((IReusablesEntity) entity);
        visit((Reusable) entity);
    }

    public void visit(Source entity) {
    }

    public void visit(PathExpression entity) {
        visit((Source) entity);
        visit((Locator) entity);
    }

    public void visit(Locator entity) {
    }

    public void visit(StepExpression entity) {
        visit((PathExpression) entity);
    }

    public void visit(ReferenceStep entity) {
        visit((IReusablesEntity) entity);
        visit((StepExpression) entity);
    }

    public void visit(Resource entity) {
        visit((IReusablesEntity) entity);
        visit((Source) entity);
    }

    public void visit(Registry entity) {
        visit((IReusablesEntity) entity);
        visit((Source) entity);
    }

    public void visit(WorkspacePath entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(FileSystemPath entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(ClassPathURI entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(URI entity) {
        visit((IReusablesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(Persistence entity) {
        visit((IReusablesEntity) entity);
    }
}
