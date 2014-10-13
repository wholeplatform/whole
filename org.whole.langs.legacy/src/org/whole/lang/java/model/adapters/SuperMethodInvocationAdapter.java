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
public class SuperMethodInvocationAdapter extends AbstractEntityAdapter
		implements SuperMethodInvocation {
	private static final long serialVersionUID = 1;

	public SuperMethodInvocationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SuperMethodInvocationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SuperMethodInvocation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SuperMethodInvocation;
	}

	public Name getQualifier() {
		return wGet(JavaFeatureDescriptorEnum.qualifier).wGetAdapter(
				JavaEntityDescriptorEnum.Name);
	}

	public void setQualifier(Name qualifier) {
		wSet(JavaFeatureDescriptorEnum.qualifier, qualifier);
	}

	public Types getTypeArguments() {
		return wGet(JavaFeatureDescriptorEnum.typeArguments).wGetAdapter(
				JavaEntityDescriptorEnum.Types);
	}

	public void setTypeArguments(Types typeArguments) {
		wSet(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}

	public Arguments getArguments() {
		return wGet(JavaFeatureDescriptorEnum.arguments).wGetAdapter(
				JavaEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(JavaFeatureDescriptorEnum.arguments, arguments);
	}
}
