package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MiscIdentityVisitor extends AbstractVisitor implements
		IMiscVisitor {
	public void visit(IEntity entity) {
		((IMiscEntity) entity).accept(this);
	}

	public void visit(Misc entity) {
	}
}
