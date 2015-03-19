package org.whole.lang.unifiedlambdadelta.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;

/** 
 * @generator Whole
 */
public class TopImpl extends AbstractSimpleEntity implements Top {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Top> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Top;
	}

	public int wGetEntityOrd() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Top_ord;
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
