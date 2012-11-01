package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

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

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Annotation> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Annotation;
	}
}
