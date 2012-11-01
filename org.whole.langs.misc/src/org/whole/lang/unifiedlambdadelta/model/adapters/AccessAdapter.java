package org.whole.lang.unifiedlambdadelta.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AccessAdapter extends AbstractEntityAdapter implements Access {
	private static final long serialVersionUID = 1;

	public AccessAdapter(IEntity implementor) {
		super(implementor);
	}

	public AccessAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Access> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Access;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
