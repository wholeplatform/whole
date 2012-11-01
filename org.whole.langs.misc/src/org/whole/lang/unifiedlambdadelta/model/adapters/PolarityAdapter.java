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
public class PolarityAdapter extends AbstractEntityAdapter implements Polarity {
	private static final long serialVersionUID = 1;

	public PolarityAdapter(IEntity implementor) {
		super(implementor);
	}

	public PolarityAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Polarity> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Polarity;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
