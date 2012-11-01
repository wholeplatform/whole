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
public class WithStatementAdapter extends AbstractEntityAdapter implements
		WithStatement {
	private static final long serialVersionUID = 1;

	public WithStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public WithStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WithStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.WithStatement;
	}

	public Expression getObject() {
		return wGet(JavaScriptFeatureDescriptorEnum.object).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setObject(Expression object) {
		wSet(JavaScriptFeatureDescriptorEnum.object, object);
	}

	public Statement getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
