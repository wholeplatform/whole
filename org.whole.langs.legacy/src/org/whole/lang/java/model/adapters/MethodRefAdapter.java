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
public class MethodRefAdapter extends AbstractEntityAdapter implements
		MethodRef {
	private static final long serialVersionUID = 1;

	public MethodRefAdapter(IEntity implementor) {
		super(implementor);
	}

	public MethodRefAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MethodRef> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MethodRef;
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

	public MethodRefParameters getParameters() {
		return wGet(JavaFeatureDescriptorEnum.parameters).wGetAdapter(
				JavaEntityDescriptorEnum.MethodRefParameters);
	}

	public void setParameters(MethodRefParameters parameters) {
		wSet(JavaFeatureDescriptorEnum.parameters, parameters);
	}
}
