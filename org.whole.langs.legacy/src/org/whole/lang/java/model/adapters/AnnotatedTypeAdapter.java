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
public class AnnotatedTypeAdapter extends AbstractEntityAdapter implements
		AnnotatedType {
	private static final long serialVersionUID = 1;

	public AnnotatedTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public AnnotatedTypeAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<AnnotatedType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.AnnotatedType;
	}

	public Annotations getAnnotations() {
		return wGet(JavaFeatureDescriptorEnum.annotations).wGetAdapter(
				JavaEntityDescriptorEnum.Annotations);
	}

	public void setAnnotations(Annotations annotations) {
		wSet(JavaFeatureDescriptorEnum.annotations, annotations);
	}

	public Type getType() {
		return wGet(JavaFeatureDescriptorEnum.type).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(JavaFeatureDescriptorEnum.type, type);
	}
}
