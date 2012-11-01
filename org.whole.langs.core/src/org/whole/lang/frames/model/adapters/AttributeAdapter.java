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
public class AttributeAdapter extends AbstractEntityAdapter implements
		Attribute {
	private static final long serialVersionUID = 1;

	public AttributeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AttributeAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Attribute> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Attribute;
	}

	public SolitaryFeatureName getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.SolitaryFeatureName);
	}

	public void setName(SolitaryFeatureName name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public Type getType() {
		return wGet(FramesFeatureDescriptorEnum.type).wGetAdapter(
				FramesEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(FramesFeatureDescriptorEnum.type, type);
	}

	public Expression getValue() {
		return wGet(FramesFeatureDescriptorEnum.value).wGetAdapter(
				FramesEntityDescriptorEnum.Expression);
	}

	public void setValue(Expression value) {
		wSet(FramesFeatureDescriptorEnum.value, value);
	}
}
