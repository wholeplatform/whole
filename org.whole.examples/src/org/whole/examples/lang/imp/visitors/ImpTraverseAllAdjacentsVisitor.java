package org.whole.examples.lang.imp.visitors;

import org.whole.examples.lang.imp.visitors.ImpIdentityUnaryVisitor;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ImpTraverseAllAdjacentsVisitor extends ImpIdentityUnaryVisitor<IImpVisitor> {
	public ImpTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public ImpTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
