package org.whole.lang.semantics.visitors;

import org.whole.lang.semantics.visitors.SemanticsIdentityUnaryVisitor;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class SemanticsTraverseAllAdjacentsVisitor extends
		SemanticsIdentityUnaryVisitor<ISemanticsVisitor> {
	public SemanticsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public SemanticsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
