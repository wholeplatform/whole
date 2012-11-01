package org.whole.lang.pojo.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.pojo.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.visitors.IPojoVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.pojo.reflect.PojoFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class MarkerAnnotationAdapter extends AbstractEntityAdapter implements
		MarkerAnnotation {
	private static final long serialVersionUID = 1;

	public MarkerAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public MarkerAnnotationAdapter() {
	}

	public void accept(IPojoVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MarkerAnnotation> wGetEntityDescriptor() {
		return PojoEntityDescriptorEnum.MarkerAnnotation;
	}

	public Name getName() {
		return wGet(PojoFeatureDescriptorEnum.name).wGetAdapter(
				PojoEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(PojoFeatureDescriptorEnum.name, name);
	}
}
