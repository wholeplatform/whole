package org.whole.lang.pojo.visitors;

import org.whole.lang.pojo.visitors.PojoIdentityUnaryVisitor;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.pojo.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class PojoTraverseAllAdjacentsVisitor extends
		PojoIdentityUnaryVisitor<IPojoVisitor> {
	public PojoTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public PojoTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
