package org.whole.lang.environment.visitors;

import org.whole.lang.environment.visitors.EnvironmentIdentityUnaryVisitor;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class EnvironmentTraverseAllAdjacentsVisitor extends
		EnvironmentIdentityUnaryVisitor<IEnvironmentVisitor> {
	public EnvironmentTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public EnvironmentTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Tuple entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}
}
