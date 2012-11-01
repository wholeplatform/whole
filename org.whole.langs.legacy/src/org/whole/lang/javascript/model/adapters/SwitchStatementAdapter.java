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
public class SwitchStatementAdapter extends AbstractEntityAdapter implements
		SwitchStatement {
	private static final long serialVersionUID = 1;

	public SwitchStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public SwitchStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SwitchStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.SwitchStatement;
	}

	public Expression getExpression() {
		return wGet(JavaScriptFeatureDescriptorEnum.expression).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setExpression(Expression expression) {
		wSet(JavaScriptFeatureDescriptorEnum.expression, expression);
	}

	public SwitchCases getCases() {
		return wGet(JavaScriptFeatureDescriptorEnum.cases).wGetAdapter(
				JavaScriptEntityDescriptorEnum.SwitchCases);
	}

	public void setCases(SwitchCases cases) {
		wSet(JavaScriptFeatureDescriptorEnum.cases, cases);
	}
}
