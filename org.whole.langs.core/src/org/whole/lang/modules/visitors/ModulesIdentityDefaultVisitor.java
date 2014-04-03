package org.whole.lang.modules.visitors;

import org.whole.lang.modules.model.*;

/**
 *  @generator  Whole
 */
public class ModulesIdentityDefaultVisitor extends ModulesIdentityVisitor {

    public void visit(IModulesEntity entity) {
    }

    public void visit(Module entity) {
        visit((IModulesEntity) entity);
    }

    public void visit(Include entity) {
        visit((IModulesEntity) entity);
    }

    public void visit(Reuse entity) {
        visit((IModulesEntity) entity);
    }

    public void visit(Resource entity) {
        visit((IModulesEntity) entity);
    }

    public void visit(Locator entity) {
    }

    public void visit(WorkspacePath entity) {
        visit((IModulesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(FileSystemPath entity) {
        visit((IModulesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(ClassPathURI entity) {
        visit((IModulesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(URI entity) {
        visit((IModulesEntity) entity);
        visit((Locator) entity);
    }

    public void visit(Persistence entity) {
        visit((IModulesEntity) entity);
    }

    public void visit(Registry entity) {
        visit((IModulesEntity) entity);
    }
}
