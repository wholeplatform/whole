package org.whole.lang.math.visitors;

import org.whole.lang.math.visitors.MathIdentityUnaryVisitor;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.math.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class MathTraverseAllAdjacentsVisitor extends
		MathIdentityUnaryVisitor<IMathVisitor> {
	public MathTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public MathTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
