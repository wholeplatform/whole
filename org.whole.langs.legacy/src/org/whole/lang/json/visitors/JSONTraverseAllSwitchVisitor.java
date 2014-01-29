package org.whole.lang.json.visitors;

import org.whole.lang.json.visitors.JSONIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;

/**
 *  @generator  Whole
 */
public class JSONTraverseAllSwitchVisitor extends JSONIdentityUnaryVisitor<IVisitor> {

    public JSONTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Object entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Pair entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(Array entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
