package org.whole.lang.misc.visitors;

import org.whole.lang.misc.visitors.MiscIdentityUnaryVisitor;
import org.whole.lang.misc.visitors.IMiscVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class MiscTraverseAllAdjacentsVisitor extends
		MiscIdentityUnaryVisitor<IMiscVisitor> {
	public MiscTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public MiscTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
