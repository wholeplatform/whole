package org.whole.lang.sql.visitors;

import org.whole.lang.sql.visitors.SQLIdentityUnaryVisitor;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.sql.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class SQLTraverseAllAdjacentsVisitor extends SQLIdentityUnaryVisitor<ISQLVisitor> {
	public SQLTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public SQLTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
