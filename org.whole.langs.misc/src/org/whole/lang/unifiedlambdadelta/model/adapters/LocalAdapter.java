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
public class LocalAdapter extends AbstractEntityAdapter implements Local {
	private static final long serialVersionUID = 1;

	public LocalAdapter(IEntity implementor) {
		super(implementor);
	}

	public LocalAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Local> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Local;
	}

	public Index getIndex() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.index).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Index);
	}

	public void setIndex(Index index) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.index, index);
	}
}
