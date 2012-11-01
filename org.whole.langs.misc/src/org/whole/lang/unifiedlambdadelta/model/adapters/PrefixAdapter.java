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
public class PrefixAdapter extends AbstractEntityAdapter implements Prefix {
	private static final long serialVersionUID = 1;

	public PrefixAdapter(IEntity implementor) {
		super(implementor);
	}

	public PrefixAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Prefix> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Prefix;
	}

	public String getValue() {
		return wStringValue();
	}

	public void setValue(String value) {
		wSetValue(value);
	}
}
