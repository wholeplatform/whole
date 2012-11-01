package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.AbstractBinaryVisitor;
import org.whole.lang.misc.visitors.IMiscVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MiscSequenceVisitor extends AbstractBinaryVisitor<IMiscVisitor>
		implements IMiscVisitor {
	public MiscSequenceVisitor(IVisitor visitor1, IVisitor visitor2) {
		super(visitor1, visitor2);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}

	public void visit(Misc entity) {
		wGetVisitor1().visit(entity);
		wGetVisitor2().visit(entity);
	}
}
