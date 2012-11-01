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
public class CatchClauseAdapter extends AbstractEntityAdapter implements
		CatchClause {
	private static final long serialVersionUID = 1;

	public CatchClauseAdapter(IEntity implementor) {
		super(implementor);
	}

	public CatchClauseAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<CatchClause> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.CatchClause;
	}

	public Expression getParam() {
		return wGet(JavaScriptFeatureDescriptorEnum.param).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setParam(Expression param) {
		wSet(JavaScriptFeatureDescriptorEnum.param, param);
	}

	public Expression getGuard() {
		return wGet(JavaScriptFeatureDescriptorEnum.guard).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setGuard(Expression guard) {
		wSet(JavaScriptFeatureDescriptorEnum.guard, guard);
	}

	public Statements getBody() {
		return wGet(JavaScriptFeatureDescriptorEnum.body).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statements);
	}

	public void setBody(Statements body) {
		wSet(JavaScriptFeatureDescriptorEnum.body, body);
	}
}
