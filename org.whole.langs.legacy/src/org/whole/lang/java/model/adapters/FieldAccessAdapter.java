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
public class FieldAccessAdapter extends AbstractEntityAdapter implements
		FieldAccess {
	private static final long serialVersionUID = 1;

	public FieldAccessAdapter(IEntity implementor) {
		super(implementor);
	}

	public FieldAccessAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<FieldAccess> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.FieldAccess;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}

	public SimpleName getName() {
		return wGet(JavaFeatureDescriptorEnum.name).wGetAdapter(
				JavaEntityDescriptorEnum.SimpleName);
	}

	public void setName(SimpleName name) {
		wSet(JavaFeatureDescriptorEnum.name, name);
	}
}
