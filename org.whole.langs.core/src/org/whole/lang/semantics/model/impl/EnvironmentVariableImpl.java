package org.whole.lang.semantics.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.semantics.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class EnvironmentVariableImpl extends AbstractSimpleEntity implements
		EnvironmentVariable {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EnvironmentVariable> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.EnvironmentVariable;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.EnvironmentVariable_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private LocalIdentifier environment;

	public LocalIdentifier getEnvironment() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.environment,
				environment);
	}

	public void setEnvironment(LocalIdentifier environment) {
		notifyChanged(SemanticsFeatureDescriptorEnum.environment,
				this.environment, this.environment = environment);
	}

	private LocalIdentifier variable;

	public LocalIdentifier getVariable() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.variable,
				variable);
	}

	public void setVariable(LocalIdentifier variable) {
		notifyChanged(SemanticsFeatureDescriptorEnum.variable, this.variable,
				this.variable = variable);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getEnvironment().wGetAdaptee(false);
		case 1:
			return getVariable().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setEnvironment(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
			break;
		case 1:
			setVariable(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.LocalIdentifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
