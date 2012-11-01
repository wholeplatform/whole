package org.whole.lang.scheme.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scheme.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ClosureValueAdapter extends AbstractEntityAdapter implements
		ClosureValue {
	private static final long serialVersionUID = 1;

	public ClosureValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public ClosureValueAdapter() {
	}

	public void accept(ISchemeVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ClosureValue> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.ClosureValue;
	}

	public Names getArgs() {
		return wGet(SchemeFeatureDescriptorEnum.args).wGetAdapter(
				SchemeEntityDescriptorEnum.Names);
	}

	public void setArgs(Names args) {
		wSet(SchemeFeatureDescriptorEnum.args, args);
	}

	public SchemeExpression getBody() {
		return wGet(SchemeFeatureDescriptorEnum.body).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeExpression);
	}

	public void setBody(SchemeExpression body) {
		wSet(SchemeFeatureDescriptorEnum.body, body);
	}

	public SchemeEnvironment getEnv() {
		return wGet(SchemeFeatureDescriptorEnum.env).wGetAdapter(
				SchemeEntityDescriptorEnum.SchemeEnvironment);
	}

	public void setEnv(SchemeEnvironment env) {
		wSet(SchemeFeatureDescriptorEnum.env, env);
	}
}
