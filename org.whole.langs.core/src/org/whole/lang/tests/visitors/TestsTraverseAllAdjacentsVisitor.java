package org.whole.lang.tests.visitors;

import org.whole.lang.tests.visitors.TestsIdentityUnaryVisitor;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.tests.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TestsTraverseAllAdjacentsVisitor extends
		TestsIdentityUnaryVisitor<ITestsVisitor> {
	public TestsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public TestsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
