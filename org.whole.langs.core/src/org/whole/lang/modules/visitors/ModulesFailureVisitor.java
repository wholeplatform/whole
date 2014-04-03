package org.whole.lang.modules.visitors;

import org.whole.lang.modules.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator  Whole
 */
public class ModulesFailureVisitor extends ModulesIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Module entity) {
        throw new VisitException();
    }

    public void visit(Include entity) {
        throw new VisitException();
    }

    public void visit(Reuse entity) {
        throw new VisitException();
    }

    public void visit(Resource entity) {
        throw new VisitException();
    }

    public void visit(WorkspacePath entity) {
        throw new VisitException();
    }

    public void visit(FileSystemPath entity) {
        throw new VisitException();
    }

    public void visit(ClassPathURI entity) {
        throw new VisitException();
    }

    public void visit(URI entity) {
        throw new VisitException();
    }

    public void visit(Persistence entity) {
        throw new VisitException();
    }

    public void visit(Registry entity) {
        throw new VisitException();
    }
}
