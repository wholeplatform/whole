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
public class MethodRefParameterImpl extends AbstractSimpleEntity implements
		MethodRefParameter {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<MethodRefParameter> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MethodRefParameter;
	}

	public int wGetEntityOrd() {
		return JavaEntityDescriptorEnum.MethodRefParameter_ord;
	}

	public void accept(IJavaVisitor visitor) {
		visitor.visit(this);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(JavaFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(JavaFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private Varargs varargs;

	public Varargs getVarargs() {
		return notifyRequested(JavaFeatureDescriptorEnum.varargs, varargs);
	}

	public void setVarargs(Varargs varargs) {
		notifyChanged(JavaFeatureDescriptorEnum.varargs, this.varargs,
				this.varargs = varargs);
	}

	private SimpleName name;

	public SimpleName getName() {
		return notifyRequested(JavaFeatureDescriptorEnum.name, name);
	}

	public void setName(SimpleName name) {
		notifyChanged(JavaFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getVarargs().wGetAdaptee(false);
		case 2:
			return getName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(JavaEntityDescriptorEnum.Type));
			break;
		case 1:
			setVarargs(value.wGetAdapter(JavaEntityDescriptorEnum.Varargs));
			break;
		case 2:
			setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
