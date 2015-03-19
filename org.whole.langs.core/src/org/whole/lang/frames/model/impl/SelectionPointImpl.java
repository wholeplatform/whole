package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SelectionPointImpl extends AbstractSimpleEntity implements
		SelectionPoint {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SelectionPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SelectionPoint;
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.SelectionPoint_ord;
	}

	public void accept(IFramesVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private FeatureName selector;

	public FeatureName getSelector() {
		return notifyRequested(FramesFeatureDescriptorEnum.selector, selector);
	}

	public void setSelector(FeatureName selector) {
		notifyChanged(FramesFeatureDescriptorEnum.selector, this.selector,
				this.selector = selector);
	}

	private Variants variants;

	public Variants getVariants() {
		return notifyRequested(FramesFeatureDescriptorEnum.variants, variants);
	}

	public void setVariants(Variants variants) {
		notifyChanged(FramesFeatureDescriptorEnum.variants, this.variants,
				this.variants = variants);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSelector().wGetAdaptee(false);
		case 1:
			return getVariants().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSelector(value
					.wGetAdapter(FramesEntityDescriptorEnum.FeatureName));
			break;
		case 1:
			setVariants(value.wGetAdapter(FramesEntityDescriptorEnum.Variants));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
