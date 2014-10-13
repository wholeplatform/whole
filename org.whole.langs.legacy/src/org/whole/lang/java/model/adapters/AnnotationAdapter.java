package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

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

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Annotation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.Annotation;
	}

	public Name getTypeName() {
		return wGet(JavaFeatureDescriptorEnum.typeName).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setTypeName(Name typeName) {
		wSet(JavaFeatureDescriptorEnum.typeName, typeName);
	}
}
