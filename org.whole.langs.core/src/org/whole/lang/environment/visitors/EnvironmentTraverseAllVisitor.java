package org.whole.lang.environment.visitors;

import org.whole.lang.environment.visitors.EnvironmentIdentityUnaryVisitor;
import org.whole.lang.environment.visitors.IEnvironmentVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class EnvironmentTraverseAllVisitor extends
		EnvironmentIdentityUnaryVisitor<IEnvironmentVisitor> {
	public EnvironmentTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public EnvironmentTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Tuple entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ContainmentTuple entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}
}
