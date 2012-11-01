package org.whole.lang.firstorderlogic.visitors;

import org.whole.lang.firstorderlogic.visitors.FirstOrderLogicIdentityUnaryVisitor;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class FirstOrderLogicTraverseAllAdjacentsVisitor extends
		FirstOrderLogicIdentityUnaryVisitor<IFirstOrderLogicVisitor> {
	public FirstOrderLogicTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public FirstOrderLogicTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
