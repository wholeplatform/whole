package org.whole.lang.scheme.visitors;

import org.whole.lang.scheme.visitors.SchemeIdentityUnaryVisitor;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class SchemeTraverseAllAdjacentsVisitor extends
		SchemeIdentityUnaryVisitor<ISchemeVisitor> {
	public SchemeTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public SchemeTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
