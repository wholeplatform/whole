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
public class WhileStatementAdapter extends AbstractEntityAdapter implements
		WhileStatement {
	private static final long serialVersionUID = 1;

	public WhileStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public WhileStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<WhileStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.WhileStatement;
	}

	public Expression getTest() {
		return wGet(JavaScriptFeatureDescriptorEnum.test).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setTest(Expression test) {
		wSet(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public Statement getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
