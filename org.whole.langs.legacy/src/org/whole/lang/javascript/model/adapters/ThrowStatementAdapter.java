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
public class ThrowStatementAdapter extends AbstractEntityAdapter implements
		ThrowStatement {
	private static final long serialVersionUID = 1;

	public ThrowStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public ThrowStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ThrowStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ThrowStatement;
	}

	public Expression getArgument() {
		return wGet(JavaScriptFeatureDescriptorEnum.argument).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setArgument(Expression argument) {
		wSet(JavaScriptFeatureDescriptorEnum.argument, argument);
	}
}
