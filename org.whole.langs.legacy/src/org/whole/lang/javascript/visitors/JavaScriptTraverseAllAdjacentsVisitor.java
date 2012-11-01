package org.whole.lang.javascript.visitors;

import org.whole.lang.javascript.visitors.JavaScriptIdentityUnaryVisitor;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class JavaScriptTraverseAllAdjacentsVisitor extends
		JavaScriptIdentityUnaryVisitor<IJavaScriptVisitor> {
	public JavaScriptTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public JavaScriptTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
