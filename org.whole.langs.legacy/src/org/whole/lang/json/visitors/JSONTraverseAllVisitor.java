package org.whole.lang.json.visitors;

import org.whole.lang.json.visitors.JSONIdentityUnaryVisitor;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.json.model.Object;

/**
 *  @generator  Whole
 */
public class JSONTraverseAllVisitor extends JSONIdentityUnaryVisitor<IJSONVisitor> {

    public JSONTraverseAllVisitor() {
        wSetVisitor1(this);
    }

    public JSONTraverseAllVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Object entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Pair entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(Array entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }
}
