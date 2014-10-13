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
public class MarkerAnnotationAdapter extends AbstractEntityAdapter implements
		MarkerAnnotation {
	private static final long serialVersionUID = 1;

	public MarkerAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public MarkerAnnotationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MarkerAnnotation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MarkerAnnotation;
	}

	public Name getTypeName() {
		return wGet(JavaFeatureDescriptorEnum.typeName).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setTypeName(Name typeName) {
		wSet(JavaFeatureDescriptorEnum.typeName, typeName);
	}
}
