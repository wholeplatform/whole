package org.whole.lang.json.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator  Whole
 */
public interface IJSONVisitor extends IVisitor {


    public void visit(Object entity);

    public void visit(Pair entity);

    public void visit(Name entity);

    public void visit(Array entity);

    public void visit(String entity);

    public void visit(Decimal entity);

    public void visit(Int entity);

    public void visit(Bool entity);

    public void visit(Null entity);
}
