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
public class SwitchCaseAdapter extends AbstractEntityAdapter implements
		SwitchCase {
	private static final long serialVersionUID = 1;

	public SwitchCaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public SwitchCaseAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SwitchCase> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.SwitchCase;
	}

	public Expression getExpression() {
		return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(
				JavaEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaFeatureDescriptorEnum.expression, expression);
	}
}
