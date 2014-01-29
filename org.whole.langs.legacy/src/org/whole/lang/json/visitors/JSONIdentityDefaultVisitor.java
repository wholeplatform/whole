package org.whole.lang.json.visitors;

import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public class JSONIdentityDefaultVisitor extends JSONIdentityVisitor {

    public void visit(IJSONEntity entity) {
    }

    public void visit(Value entity) {
    }

    public void visit(Object entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Pair entity) {
        visit((IJSONEntity) entity);
    }

    public void visit(Name entity) {
        visit((IJSONEntity) entity);
    }

    public void visit(Array entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(String entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Decimal entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Int entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Bool entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Null entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }
}
