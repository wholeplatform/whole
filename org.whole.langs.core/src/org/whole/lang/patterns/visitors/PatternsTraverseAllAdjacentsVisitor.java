package org.whole.lang.patterns.visitors;

import org.whole.lang.patterns.visitors.PatternsIdentityUnaryVisitor;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.patterns.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class PatternsTraverseAllAdjacentsVisitor extends
		PatternsIdentityUnaryVisitor<IPatternsVisitor> {
	public PatternsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public PatternsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
