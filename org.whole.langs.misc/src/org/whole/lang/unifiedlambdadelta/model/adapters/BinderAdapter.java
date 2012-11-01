package org.whole.lang.unifiedlambdadelta.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class BinderAdapter extends AbstractEntityAdapter implements Binder {
	private static final long serialVersionUID = 1;

	public BinderAdapter(IEntity implementor) {
		super(implementor);
	}

	public BinderAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Binder> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Binder;
	}

	public Name getName() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.name).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.name, name);
	}
}
