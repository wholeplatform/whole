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
public class ForStatementAdapter extends AbstractEntityAdapter implements
		ForStatement {
	private static final long serialVersionUID = 1;

	public ForStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ForStatement;
	}

	public VariableDeclarationOrExpression getInit() {
		return wGet(JavaScriptFeatureDescriptorEnum.init).wGetAdapter(
				JavaScriptEntityDescriptorEnum.VariableDeclarationOrExpression);
	}

	public void setInit(VariableDeclarationOrExpression init) {
		wSet(JavaScriptFeatureDescriptorEnum.init, init);
	}

	public Expression getTest() {
		return wGet(JavaScriptFeatureDescriptorEnum.test).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setTest(Expression test) {
		wSet(JavaScriptFeatureDescriptorEnum.test, test);
	}

	public Expression getUpdate() {
		return wGet(JavaScriptFeatureDescriptorEnum.update).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setUpdate(Expression update) {
		wSet(JavaScriptFeatureDescriptorEnum.update, update);
	}

	public Statement getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
