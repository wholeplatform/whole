package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class LambdaExpressionImpl extends AbstractSimpleEntity implements
		LambdaExpression {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LambdaExpression> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.LambdaExpression;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.LambdaExpression_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Names args;

	public Names getArgs() {
		return notifyRequested(SchemeFeatureDescriptorEnum.args, args);
	}

	public void setArgs(Names args) {
		notifyChanged(SchemeFeatureDescriptorEnum.args, this.args,
				this.args = args);
	}

	private SchemeExpression body;

	public SchemeExpression getBody() {
		return notifyRequested(SchemeFeatureDescriptorEnum.body, body);
	}

	public void setBody(SchemeExpression body) {
		notifyChanged(SchemeFeatureDescriptorEnum.body, this.body,
				this.body = body);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getArgs().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setArgs(value.wGetAdapter(SchemeEntityDescriptorEnum.Names));
			break;
		case 1:
			setBody(value
					.wGetAdapter(SchemeEntityDescriptorEnum.SchemeExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
