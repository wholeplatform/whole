package org.whole.lang.json.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public class JSONForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements IJSONVisitor {

    public JSONForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Object entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Pair entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Name entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Array entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(String entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Decimal entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Int entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Bool entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Null entity) {
        wGetVisitor1().visit(entity);
    }
}
