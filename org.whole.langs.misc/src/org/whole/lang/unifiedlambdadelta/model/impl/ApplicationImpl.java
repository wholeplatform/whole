package org.whole.lang.unifiedlambdadelta.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.unifiedlambdadelta.visitors.IUnifiedLambdaDeltaVisitor;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ApplicationImpl extends AbstractSimpleEntity implements
		Application {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Application> wGetEntityDescriptor() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Application;
	}

	public int wGetEntityOrd() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.Application_ord;
	}

	public void accept(IUnifiedLambdaDeltaVisitor visitor) {
		visitor.visit(this);
	}

	private Polarity polarity;

	public Polarity getPolarity() {
		return notifyRequested(
				UnifiedLambdaDeltaFeatureDescriptorEnum.polarity, polarity);
	}

	public void setPolarity(Polarity polarity) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
				this.polarity, this.polarity = polarity);
	}

	private Term front;

	public Term getFront() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
				front);
	}

	public void setFront(Term front) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
				this.front, this.front = front);
	}

	private Term back;

	public Term getBack() {
		return notifyRequested(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
				back);
	}

	public void setBack(Term back) {
		notifyChanged(UnifiedLambdaDeltaFeatureDescriptorEnum.back, this.back,
				this.back = back);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPolarity().wGetAdaptee(false);
		case 1:
			return getFront().wGetAdaptee(false);
		case 2:
			return getBack().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPolarity(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity));
			break;
		case 1:
			setFront(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Term));
			break;
		case 2:
			setBack(value
					.wGetAdapter(UnifiedLambdaDeltaEntityDescriptorEnum.Term));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
