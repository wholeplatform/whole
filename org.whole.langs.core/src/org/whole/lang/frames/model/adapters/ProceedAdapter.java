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
public class ProceedAdapter extends AbstractEntityAdapter implements Proceed {
	private static final long serialVersionUID = 1;

	public ProceedAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProceedAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Proceed> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Proceed;
	}

	public Feature getJoinpoints() {
		return wGet(FramesFeatureDescriptorEnum.joinpoints).wGetAdapter(
				FramesEntityDescriptorEnum.Feature);
	}

	public void setJoinpoints(Feature joinpoints) {
		wSet(FramesFeatureDescriptorEnum.joinpoints, joinpoints);
	}
}
