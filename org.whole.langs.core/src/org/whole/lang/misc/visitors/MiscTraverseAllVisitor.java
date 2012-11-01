package org.whole.lang.misc.visitors;

import org.whole.lang.misc.visitors.MiscIdentityUnaryVisitor;
import org.whole.lang.misc.visitors.IMiscVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class MiscTraverseAllVisitor extends
		MiscIdentityUnaryVisitor<IMiscVisitor> {
	public MiscTraverseAllVisitor() {
		wSetVisitor1(this);
	}

	public MiscTraverseAllVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Misc entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}
}
