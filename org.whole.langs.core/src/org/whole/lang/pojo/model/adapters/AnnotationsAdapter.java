package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;

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

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Annotations> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.Annotations;
	}
}
