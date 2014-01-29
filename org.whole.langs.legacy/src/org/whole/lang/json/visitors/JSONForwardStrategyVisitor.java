package org.whole.lang.json.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public class JSONForwardStrategyVisitor extends GenericForwardStrategyVisitor<IJSONVisitor> implements IJSONVisitor {

    public JSONForwardStrategyVisitor() {
        this(new JSONIdentityVisitor());
    }

    public JSONForwardStrategyVisitor(IJSONVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IJSONEntity) entity).accept(this);
    }

    public void visit(Object entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Pair entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Array entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(String entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Decimal entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Int entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Bool entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Null entity) {
        wGetStrategy().visit(entity);
    }
}
