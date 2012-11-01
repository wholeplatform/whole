package org.whole.lang.environment.visitors;

import org.whole.lang.environment.visitors.EnvironmentIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.environment.model.*;

/** 
 * @generator Whole
 */
public class EnvironmentTraverseAllSwitchVisitor extends
		EnvironmentIdentityUnaryVisitor<IVisitor> {
	public EnvironmentTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Tuple entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(ContainmentTuple entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}
}
