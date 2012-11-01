package org.whole.lang.java.visitors;

import org.whole.lang.java.visitors.JavaIdentityUnaryVisitor;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class JavaTraverseAllAdjacentsVisitor extends
		JavaIdentityUnaryVisitor<IJavaVisitor> {
	public JavaTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public JavaTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
