package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ConditionalExpressionAdapter extends AbstractEntityAdapter
		implements ConditionalExpression {
	private static final long serialVersionUID = 1;

	public ConditionalExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ConditionalExpressionAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ConditionalExpression> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ConditionalExpression;
	}

	public Expression getTest() {
		return wGet(JavaScriptFeatureDescriptorEnum.test).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setTest(Expression test) {
		wSet(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public Expression getConsequent() {
		return wGet(JavaScriptFeatureDescriptorEnum.consequent).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setConsequent(Expression consequent) {
		wSet(JavaScriptFeatureDescriptorEnum.consequent, consequent);
	}

	public Expression getAlternate() {
		return wGet(JavaScriptFeatureDescriptorEnum.alternate).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setAlternate(Expression alternate) {
		wSet(JavaScriptFeatureDescriptorEnum.alternate, alternate);
	}
}
