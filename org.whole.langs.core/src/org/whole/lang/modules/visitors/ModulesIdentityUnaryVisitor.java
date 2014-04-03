package org.whole.lang.modules.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ModulesIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IModulesVisitor {

    public ModulesIdentityUnaryVisitor() {
        super(null);
    }

    public ModulesIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IModulesEntity) entity).accept(this);
    }

    public void visit(Module entity) {
    }

    public void visit(Include entity) {
    }

    public void visit(Reuse entity) {
    }

    public void visit(Resource entity) {
    }

    public void visit(WorkspacePath entity) {
    }

    public void visit(FileSystemPath entity) {
    }

    public void visit(ClassPathURI entity) {
    }

    public void visit(URI entity) {
    }

    public void visit(Persistence entity) {
    }

    public void visit(Registry entity) {
    }
}
