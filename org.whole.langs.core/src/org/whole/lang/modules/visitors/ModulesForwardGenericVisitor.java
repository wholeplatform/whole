package org.whole.lang.modules.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ModulesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IModulesVisitor {

    public ModulesForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Module entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Include entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Reuse entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Resource entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(WorkspacePath entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FileSystemPath entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClassPathURI entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(URI entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Persistence entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Registry entity) {
        wGetVisitor1().visit(entity);
    }
}
