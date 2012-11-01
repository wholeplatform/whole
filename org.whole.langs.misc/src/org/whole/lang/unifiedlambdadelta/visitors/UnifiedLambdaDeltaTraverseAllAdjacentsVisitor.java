package org.whole.lang.unifiedlambdadelta.visitors;

import org.whole.lang.unifiedlambdadelta.visitors.UnifiedLambdaDeltaIdentityUnaryVisitor;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaTraverseAllAdjacentsVisitor extends
		UnifiedLambdaDeltaIdentityUnaryVisitor<IUnifiedLambdaDeltaVisitor> {
	public UnifiedLambdaDeltaTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public UnifiedLambdaDeltaTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
