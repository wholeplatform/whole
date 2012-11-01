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
public class ClosureValueImpl extends AbstractSimpleEntity implements
		ClosureValue {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ClosureValue> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.ClosureValue;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.ClosureValue_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		visitor.visit(this);
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

	private SchemeEnvironment env;

	public SchemeEnvironment getEnv() {
		return notifyRequested(SchemeFeatureDescriptorEnum.env, env);
	}

	public void setEnv(SchemeEnvironment env) {
		notifyChanged(SchemeFeatureDescriptorEnum.env, this.env, this.env = env);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getArgs().wGetAdaptee(false);
		case 1:
			return getBody().wGetAdaptee(false);
		case 2:
			return getEnv().wGetAdaptee(false);
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
		case 2:
			setEnv(value
					.wGetAdapter(SchemeEntityDescriptorEnum.SchemeEnvironment));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
