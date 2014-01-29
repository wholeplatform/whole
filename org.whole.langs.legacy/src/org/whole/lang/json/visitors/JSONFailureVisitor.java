package org.whole.lang.json.visitors;

import org.whole.lang.json.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public class JSONFailureVisitor extends JSONIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Object entity) {
        throw new VisitException();
    }

    public void visit(Pair entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(Array entity) {
        throw new VisitException();
    }

    public void visit(String entity) {
        throw new VisitException();
    }

    public void visit(Decimal entity) {
        throw new VisitException();
    }

    public void visit(Int entity) {
        throw new VisitException();
    }

    public void visit(Bool entity) {
        throw new VisitException();
    }

    public void visit(Null entity) {
        throw new VisitException();
    }
}
