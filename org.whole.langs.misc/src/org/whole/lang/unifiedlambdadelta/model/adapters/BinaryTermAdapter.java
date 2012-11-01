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
public class BinaryTermAdapter extends AbstractEntityAdapter implements
		BinaryTerm {
	private static final long serialVersionUID = 1;

	public BinaryTermAdapter(IEntity implementor) {
		super(implementor);
	}

	public BinaryTermAdapter() {
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BinaryTerm> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.BinaryTerm;
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

	public Term getBack() {
		return wGet(UnifiedLambdaDeltaFeatureDescriptorEnum.back).wGetAdapter(
				UnifiedLambdaDeltaEntityDescriptorEnum.Term);
	}

	public void setBack(Term back) {
		wSet(UnifiedLambdaDeltaFeatureDescriptorEnum.back, back);
	}
}
