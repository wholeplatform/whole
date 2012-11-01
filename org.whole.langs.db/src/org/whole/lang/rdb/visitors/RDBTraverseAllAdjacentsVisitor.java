package org.whole.lang.rdb.visitors;

import org.whole.lang.rdb.visitors.RDBIdentityUnaryVisitor;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class RDBTraverseAllAdjacentsVisitor extends
		RDBIdentityUnaryVisitor<IRDBVisitor> {
	public RDBTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public RDBTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
