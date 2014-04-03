package org.whole.lang.modules.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.modules.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ModulesForwardStrategyVisitor extends GenericForwardStrategyVisitor<IModulesVisitor> implements IModulesVisitor {

    public ModulesForwardStrategyVisitor() {
        this(new ModulesIdentityVisitor());
    }

    public ModulesForwardStrategyVisitor(IModulesVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IModulesEntity) entity).accept(this);
    }

    public void visit(Module entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Include entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Reuse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Resource entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WorkspacePath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FileSystemPath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassPathURI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(URI entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Persistence entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Registry entity) {
        wGetStrategy().visit(entity);
    }
}
