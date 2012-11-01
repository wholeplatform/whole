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
public class SuperFieldAccessAdapter extends AbstractEntityAdapter implements
		SuperFieldAccess {
	private static final long serialVersionUID = 1;

	public SuperFieldAccessAdapter(IEntity implementor) {
		super(implementor);
	}

	public SuperFieldAccessAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SuperFieldAccess> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SuperFieldAccess;
	}

	public Name getQualifier() {
		return wGet(JavaFeatureDescriptorEnum.qualifier).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setQualifier(Name qualifier) {
		wSet(JavaFeatureDescriptorEnum.qualifier, qualifier);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}
}
