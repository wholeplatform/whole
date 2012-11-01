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
public class ReturnStatementAdapter extends AbstractEntityAdapter implements
		ReturnStatement {
	private static final long serialVersionUID = 1;

	public ReturnStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ReturnStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ReturnStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ReturnStatement;
	}

	public Expression getArgument() {
		return wGet(JavaScriptFeatureDescriptorEnum.argument).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setArgument(Expression argument) {
		wSet(JavaScriptFeatureDescriptorEnum.argument, argument);
	}
}
