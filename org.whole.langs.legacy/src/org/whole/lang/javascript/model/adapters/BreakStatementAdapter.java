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
public class BreakStatementAdapter extends AbstractEntityAdapter implements
		BreakStatement {
	private static final long serialVersionUID = 1;

	public BreakStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public BreakStatementAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<BreakStatement> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.BreakStatement;
	}

	public Identifier getTarget() {
		return wGet(JavaScriptFeatureDescriptorEnum.target).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Identifier);
	}

	public void setTarget(Identifier target) {
		wSet(JavaScriptFeatureDescriptorEnum.target, target);
	}
}
