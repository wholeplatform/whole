package org.whole.lang.actions.visitors;

import org.whole.lang.actions.visitors.ActionsIdentityUnaryVisitor;
import org.whole.lang.actions.visitors.IActionsVisitor;
import org.whole.lang.actions.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ActionsTraverseAllAdjacentsVisitor extends
		ActionsIdentityUnaryVisitor<IActionsVisitor> {
	public ActionsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public ActionsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
