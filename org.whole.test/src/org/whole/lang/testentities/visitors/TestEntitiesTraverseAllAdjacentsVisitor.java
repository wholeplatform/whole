package org.whole.lang.testentities.visitors;

import org.whole.lang.testentities.visitors.TestEntitiesIdentityUnaryVisitor;
import org.whole.lang.testentities.visitors.ITestEntitiesVisitor;
import org.whole.lang.testentities.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class TestEntitiesTraverseAllAdjacentsVisitor extends
		TestEntitiesIdentityUnaryVisitor<ITestEntitiesVisitor> {
	public TestEntitiesTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public TestEntitiesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
