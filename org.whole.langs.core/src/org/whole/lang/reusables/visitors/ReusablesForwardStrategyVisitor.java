package org.whole.lang.reusables.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.reusables.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class ReusablesForwardStrategyVisitor extends GenericForwardStrategyVisitor<IReusablesVisitor> implements IReusablesVisitor {

    public ReusablesForwardStrategyVisitor() {
        this(new ReusablesIdentityVisitor());
    }

    public ReusablesForwardStrategyVisitor(IReusablesVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IReusablesEntity) entity).accept(this);
    }

    public void visit(Adapt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Reuse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Synch entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Include entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Reusables entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReferenceStep entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Resource entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Registry entity) {
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
}
