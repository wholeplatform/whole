package org.whole.lang.testevents.visitors;

import org.whole.lang.testevents.visitors.TestEventsIdentityUnaryVisitor;
import org.whole.lang.testevents.visitors.ITestEventsVisitor;
import org.whole.lang.testevents.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TestEventsTraverseAllAdjacentsVisitor extends
		TestEventsIdentityUnaryVisitor<ITestEventsVisitor> {
	public TestEventsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public TestEventsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
