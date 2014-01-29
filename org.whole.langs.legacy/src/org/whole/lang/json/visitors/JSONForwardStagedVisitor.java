package org.whole.lang.json.visitors;

import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public class JSONForwardStagedVisitor extends JSONIdentityVisitor {

    public void visit(Object entity) {
        stagedVisit(entity);
    }

    public void visit(Pair entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(Array entity) {
        stagedVisit(entity);
    }

    public void visit(String entity) {
        stagedVisit(entity);
    }

    public void visit(Decimal entity) {
        stagedVisit(entity);
    }

    public void visit(Int entity) {
        stagedVisit(entity);
    }

    public void visit(Bool entity) {
        stagedVisit(entity);
    }

    public void visit(Null entity) {
        stagedVisit(entity);
    }
}
