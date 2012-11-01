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
public class SuperConstructorInvocationAdapter extends AbstractEntityAdapter
		implements SuperConstructorInvocation {
	private static final long serialVersionUID = 1;

	public SuperConstructorInvocationAdapter(IEntity implementor) {
		super(implementor);
	}

	public SuperConstructorInvocationAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SuperConstructorInvocation> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SuperConstructorInvocation;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public Types getTypeArguments() {
		return wGet(JavaFeatureDescriptorEnum.typeArguments).wGetAdapter(
				JavaEntityDescriptorEnum.Types);
	}

	public void setTypeArguments(Types typeArguments) {
		wSet(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
	}

	public Arguments getArguments() {
		return wGet(JavaFeatureDescriptorEnum.arguments).wGetAdapter(
				JavaEntityDescriptorEnum.Arguments);
	}

	public void setArguments(Arguments arguments) {
		wSet(JavaFeatureDescriptorEnum.arguments, arguments);
	}
}
