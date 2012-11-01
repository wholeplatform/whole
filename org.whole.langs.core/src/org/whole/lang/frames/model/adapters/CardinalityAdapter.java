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
public class CardinalityAdapter extends AbstractEntityAdapter implements
		Cardinality {
	private static final long serialVersionUID = 1;

	public CardinalityAdapter(IEntity implementor) {
		super(implementor);
	}

	public CardinalityAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Cardinality> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Cardinality;
	}

	public IntValue getMin() {
		return wGet(FramesFeatureDescriptorEnum.min).wGetAdapter(
				FramesEntityDescriptorEnum.IntValue);
	}

	public void setMin(IntValue min) {
		wSet(FramesFeatureDescriptorEnum.min, min);
	}

	public IntValue getMax() {
		return wGet(FramesFeatureDescriptorEnum.max).wGetAdapter(
				FramesEntityDescriptorEnum.IntValue);
	}

	public void setMax(IntValue max) {
		wSet(FramesFeatureDescriptorEnum.max, max);
	}
}
