package org.whole.lang.commons.visitors;

import org.whole.lang.commons.visitors.CommonsIdentityUnaryVisitor;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.commons.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class CommonsTraverseAllAdjacentsVisitor extends CommonsIdentityUnaryVisitor<ICommonsVisitor> {
	public CommonsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public CommonsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
