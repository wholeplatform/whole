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
public class ReusePointAdapter extends AbstractEntityAdapter implements
		ReusePoint {
	private static final long serialVersionUID = 1;

	public ReusePointAdapter(IEntity implementor) {
		super(implementor);
	}

	public ReusePointAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ReusePoint> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.ReusePoint;
	}

	public ResourceIdentifier getFrame() {
		return wGet(FramesFeatureDescriptorEnum.frame).wGetAdapter(
				FramesEntityDescriptorEnum.ResourceIdentifier);
	}

	public void setFrame(ResourceIdentifier frame) {
		wSet(FramesFeatureDescriptorEnum.frame, frame);
	}

	public Features getConfiguration() {
		return wGet(FramesFeatureDescriptorEnum.configuration).wGetAdapter(
				FramesEntityDescriptorEnum.Features);
	}

	public void setConfiguration(Features configuration) {
		wSet(FramesFeatureDescriptorEnum.configuration, configuration);
	}

	public Relations getRelations() {
		return wGet(FramesFeatureDescriptorEnum.relations).wGetAdapter(
				FramesEntityDescriptorEnum.Relations);
	}

	public void setRelations(Relations relations) {
		wSet(FramesFeatureDescriptorEnum.relations, relations);
	}

	public Advices getAdvices() {
		return wGet(FramesFeatureDescriptorEnum.advices).wGetAdapter(
				FramesEntityDescriptorEnum.Advices);
	}

	public void setAdvices(Advices advices) {
		wSet(FramesFeatureDescriptorEnum.advices, advices);
	}
}
