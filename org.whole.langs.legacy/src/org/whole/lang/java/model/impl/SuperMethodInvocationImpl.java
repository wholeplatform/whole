package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SuperMethodInvocationImpl extends AbstractSimpleEntity implements
		SuperMethodInvocation {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SuperMethodInvocation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SuperMethodInvocation;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.SuperMethodInvocation_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Name qualifier;

	public Name getQualifier() {
		return notifyRequested(JavaFeatureDescriptorEnum.qualifier, qualifier);
	}

	public void setQualifier(Name qualifier) {
		notifyChanged(JavaFeatureDescriptorEnum.qualifier, this.qualifier,
				this.qualifier = qualifier);
	}

	private Types typeArguments;

	public Types getTypeArguments() {
		return notifyRequested(JavaFeatureDescriptorEnum.typeArguments,
				typeArguments);
	}

	public void setTypeArguments(Types typeArguments) {
		notifyChanged(JavaFeatureDescriptorEnum.typeArguments,
				this.typeArguments, this.typeArguments = typeArguments);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Arguments arguments;

	public Arguments getArguments() {
		return notifyRequested(JavaFeatureDescriptorEnum.arguments, arguments);
	}

	public void setArguments(Arguments arguments) {
		notifyChanged(JavaFeatureDescriptorEnum.arguments, this.arguments,
				this.arguments = arguments);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getQualifier().wGetAdaptee(false);
		case 1:
			return getTypeArguments().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		case 3:
			return getArguments().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setQualifier(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
			break;
		case 1:
			setTypeArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
			break;
		case 2:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		case 3:
			setArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Arguments));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
