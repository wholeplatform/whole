package org.whole.lang.javascript.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.javascript.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class CatchClauseImpl extends AbstractSimpleEntity implements
		CatchClause {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<CatchClause> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.CatchClause;
	}

	public int wGetEntityOrd() {
		return JavaScriptEntityDescriptorEnum.CatchClause_ord;
	}

	public void accept(IJavaScriptVisitor visitor) {
		visitor.visit(this);
	}

	private Expression param;

	public Expression getParam() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.param, param);
	}

	public void setParam(Expression param) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.param, this.param,
				this.param = param);
	}

	private Expression guard;

	public Expression getGuard() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.guard, guard);
	}

	public void setGuard(Expression guard) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.guard, this.guard,
				this.guard = guard);
	}

	private Statements body;

	public Statements getBody() {
		return notifyRequested(JavaScriptFeatureDescriptorEnum.body, body);
	}

	public void setBody(Statements body) {
		notifyChanged(JavaScriptFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getParam().wGetAdaptee(false);
		case 1:
			return getGuard().wGetAdaptee(false);
		case 2:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setParam(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 1:
			setGuard(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Expression));
			break;
		case 2:
			setBody(value
					.wGetAdapter(JavaScriptEntityDescriptorEnum.Statements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
