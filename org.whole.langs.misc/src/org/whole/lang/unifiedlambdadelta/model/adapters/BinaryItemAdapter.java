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
public class BinaryItemAdapter extends AbstractEntityAdapter implements
		BinaryItem {
	private static final long serialVersionUID = 1;

	public BinaryItemAdapter(IEntity implementor) {
		super(implementor);
	}

	public BinaryItemAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BinaryItem> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.BinaryItem;
	}

	public Polarity getPolarity() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity)
				.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity);
	}

	public void setPolarity(Polarity polarity) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity, polarity);
	}

	public Term getFront() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.front).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Term);
	}

	public void setFront(Term front) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.front, front);
	}
}
