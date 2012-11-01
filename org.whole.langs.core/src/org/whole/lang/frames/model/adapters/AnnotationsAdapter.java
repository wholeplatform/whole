package org.whole.lang.frames.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.frames.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class AnnotationsAdapter extends AbstractListEntityAdapter<Annotation>
		implements Annotations {
	private static final long serialVersionUID = 1;

	public AnnotationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnnotationsAdapter() {
	}

	public void accept(IFramesVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Annotations> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.Annotations;
	}
}
