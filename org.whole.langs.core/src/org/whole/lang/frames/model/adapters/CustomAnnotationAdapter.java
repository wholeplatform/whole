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
public class CustomAnnotationAdapter extends AbstractEntityAdapter implements
		CustomAnnotation {
	private static final long serialVersionUID = 1;

	public CustomAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public CustomAnnotationAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CustomAnnotation> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.CustomAnnotation;
	}

	public Name getName() {
		return wGet(FramesFeatureDescriptorEnum.name).wGetAdapter(
				FramesEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(FramesFeatureDescriptorEnum.name, name);
	}

	public Expression getValue() {
		return wGet(FramesFeatureDescriptorEnum.value).wGetAdapter(
				FramesEntityDescriptorEnum.Expression);
	}

	public void setValue(Expression value) {
		wSet(FramesFeatureDescriptorEnum.value, value);
	}
}
