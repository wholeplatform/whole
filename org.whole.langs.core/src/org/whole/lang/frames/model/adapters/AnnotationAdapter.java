package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AnnotationAdapter extends AbstractEntityAdapter implements
		Annotation {
	private static final long serialVersionUID = 1;

	public AnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnnotationAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Annotation> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Annotation;
	}
}
