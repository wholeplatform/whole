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
public class MemberValuePairAdapter extends AbstractEntityAdapter implements
		MemberValuePair {
	private static final long serialVersionUID = 1;

	public MemberValuePairAdapter(IEntity implementor) {
		super(implementor);
	}

	public MemberValuePairAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MemberValuePair> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MemberValuePair;
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public Expression getValue() {
		return wGet(JavaFeatureDescriptorEnum.value).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setValue(Expression value) {
		wSet(JavaFeatureDescriptorEnum.value, value);
	}
}
