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
public class LambdaExpressionAdapter extends AbstractEntityAdapter implements
		LambdaExpression {
	private static final long serialVersionUID = 1;

	public LambdaExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public LambdaExpressionAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LambdaExpression> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.LambdaExpression;
	}

	public LambdaParameters getParameters() {
		return wGet(JavaFeatureDescriptorEnum.parameters).wGetAdapter(
				JavaEntityDescriptorEnum.LambdaParameters);
	}

	public void setParameters(LambdaParameters parameters) {
		wSet(JavaFeatureDescriptorEnum.parameters, parameters);
	}

	public ExpressionOrStatement getBody() {
		return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(
				JavaEntityDescriptorEnum.ExpressionOrStatement);
	}

	public void setBody(ExpressionOrStatement body) {
		wSet(JavaFeatureDescriptorEnum.body, body);
	}
}
