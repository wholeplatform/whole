package org.whole.lang.misc.visitors;

import org.whole.lang.misc.visitors.MiscIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.misc.model.*;

/** 
 * @generator Whole
 */
public class MiscTraverseAllSwitchVisitor extends
		MiscIdentityUnaryVisitor<IVisitor> {
	public MiscTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Misc entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}
}
