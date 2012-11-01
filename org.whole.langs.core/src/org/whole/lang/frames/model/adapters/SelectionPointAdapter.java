package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.reflect.FramesFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class SelectionPointAdapter extends AbstractEntityAdapter implements
		SelectionPoint {
	private static final long serialVersionUID = 1;

	public SelectionPointAdapter(IEntity implementor) {
		super(implementor);
	}

	public SelectionPointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SelectionPoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SelectionPoint;
	}

	public FeatureName getSelector() {
		return wGet(FramesFeatureDescriptorEnum.selector).wGetAdapter(
				FramesEntityDescriptorEnum.FeatureName);
	}

	public void setSelector(FeatureName selector) {
		wSet(FramesFeatureDescriptorEnum.selector, selector);
	}

	public Variants getVariants() {
		return wGet(FramesFeatureDescriptorEnum.variants).wGetAdapter(
				FramesEntityDescriptorEnum.Variants);
	}

	public void setVariants(Variants variants) {
		wSet(FramesFeatureDescriptorEnum.variants, variants);
	}
}
