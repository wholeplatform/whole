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
public class WildcardTypeAdapter extends AbstractEntityAdapter implements
		WildcardType {
	private static final long serialVersionUID = 1;

	public WildcardTypeAdapter(IEntity implementor) {
		super(implementor);
	}

	public WildcardTypeAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WildcardType> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.WildcardType;
	}

	public Type getBound() {
		return wGet(JavaFeatureDescriptorEnum.bound).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setBound(Type bound) {
		wSet(JavaFeatureDescriptorEnum.bound, bound);
	}

	public UpperBound getUpperBound() {
		return wGet(JavaFeatureDescriptorEnum.upperBound).wGetAdapter(
				JavaEntityDescriptorEnum.UpperBound);
	}

	public void setUpperBound(UpperBound upperBound) {
		wSet(JavaFeatureDescriptorEnum.upperBound, upperBound);
	}
}
