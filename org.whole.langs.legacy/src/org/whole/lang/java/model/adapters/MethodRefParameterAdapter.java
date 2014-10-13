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
public class MethodRefParameterAdapter extends AbstractEntityAdapter implements
		MethodRefParameter {
	private static final long serialVersionUID = 1;

	public MethodRefParameterAdapter(IEntity implementor) {
		super(implementor);
	}

	public MethodRefParameterAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<MethodRefParameter> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.MethodRefParameter;
	}

	public Type getType() {
		return wGet(JavaFeatureDescriptorEnum.type).wGetAdapter(
				JavaEntityDescriptorEnum.Type);
	}

	public void setType(Type type) {
		wSet(JavaFeatureDescriptorEnum.type, type);
	}

	public Varargs getVarargs() {
		return wGet(JavaFeatureDescriptorEnum.varargs).wGetAdapter(
				JavaEntityDescriptorEnum.Varargs);
	}

	public void setVarargs(Varargs varargs) {
		wSet(JavaFeatureDescriptorEnum.varargs, varargs);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}
}
