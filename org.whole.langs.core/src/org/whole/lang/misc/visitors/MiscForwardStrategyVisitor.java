package org.whole.lang.misc.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.misc.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class MiscForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IMiscVisitor> implements IMiscVisitor {
	public MiscForwardStrategyVisitor() {
		this(new MiscIdentityVisitor());
	}

	public MiscForwardStrategyVisitor(IMiscVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IMiscEntity) entity).accept(this);
	}

	public void visit(Misc entity) {
		wGetStrategy().visit(entity);
	}
}
