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
public class NormalAnnotationAdapter extends AbstractEntityAdapter implements
		NormalAnnotation {
	private static final long serialVersionUID = 1;

	public NormalAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public NormalAnnotationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<NormalAnnotation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.NormalAnnotation;
	}

	public Name getTypeName() {
		return wGet(JavaFeatureDescriptorEnum.typeName).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setTypeName(Name typeName) {
		wSet(JavaFeatureDescriptorEnum.typeName, typeName);
	}

	public MemberValuePairs getValues() {
		return wGet(JavaFeatureDescriptorEnum.values).wGetAdapter(
				JavaEntityDescriptorEnum.MemberValuePairs);
	}

	public void setValues(MemberValuePairs values) {
		wSet(JavaFeatureDescriptorEnum.values, values);
	}
}
