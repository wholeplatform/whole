package org.whole.lang.json.visitors;

import org.whole.lang.json.visitors.JSONIdentityUnaryVisitor;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator  Whole
 */
public class JSONTraverseAllAdjacentsVisitor extends JSONIdentityUnaryVisitor<IJSONVisitor> {

    public JSONTraverseAllAdjacentsVisitor() {
        wSetVisitor1(this);
    }

    public JSONTraverseAllAdjacentsVisitor(IVisitor visitor1) {
        super(visitor1);
    }
}
