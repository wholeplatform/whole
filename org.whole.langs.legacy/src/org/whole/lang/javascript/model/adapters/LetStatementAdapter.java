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
public class LetStatementAdapter extends AbstractEntityAdapter implements
		LetStatement {
	private static final long serialVersionUID = 1;

	public LetStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public LetStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LetStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.LetStatement;
	}

	public VariableInitializers getVariables() {
		return wGet(JavaScriptFeatureDescriptorEnum.variables).wGetAdapter(
				JavaScriptEntityDescriptorEnum.VariableInitializers);
	}

	public void setVariables(VariableInitializers variables) {
		wSet(JavaScriptFeatureDescriptorEnum.variables, variables);
	}

	public Statement getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statement);
	}

	public void setBody(Statement body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
