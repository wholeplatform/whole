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
public class SingleMemberAnnotationAdapter extends AbstractEntityAdapter
		implements SingleMemberAnnotation {
	private static final long serialVersionUID = 1;

	public SingleMemberAnnotationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SingleMemberAnnotationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SingleMemberAnnotation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SingleMemberAnnotation;
	}

	public Name getTypeName() {
		return wGet(JavaFeatureDescriptorEnum.typeName).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setTypeName(Name typeName) {
		wSet(JavaFeatureDescriptorEnum.typeName, typeName);
	}

	public Expression getValue() {
		return wGet(JavaFeatureDescriptorEnum.value).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setValue(Expression value) {
		wSet(JavaFeatureDescriptorEnum.value, value);
	}
}
