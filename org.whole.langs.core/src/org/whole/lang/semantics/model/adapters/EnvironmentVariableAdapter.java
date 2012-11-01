package org.whole.lang.semantics.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.visitors.ISemanticsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class EnvironmentVariableAdapter extends AbstractEntityAdapter implements
		EnvironmentVariable {
	private static final long serialVersionUID = 1;

	public EnvironmentVariableAdapter(IEntity implementor) {
		super(implementor);
	}

	public EnvironmentVariableAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<EnvironmentVariable> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.EnvironmentVariable;
	}

	public LocalIdentifier getEnvironment() {
		return wGet(SemanticsFeatureDescriptorEnum.environment).wGetAdapter(
				SemanticsEntityDescriptorEnum.LocalIdentifier);
	}

	public void setEnvironment(LocalIdentifier environment) {
		wSet(SemanticsFeatureDescriptorEnum.environment, environment);
	}

	public LocalIdentifier getVariable() {
		return wGet(SemanticsFeatureDescriptorEnum.variable).wGetAdapter(
				SemanticsEntityDescriptorEnum.LocalIdentifier);
	}

	public void setVariable(LocalIdentifier variable) {
		wSet(SemanticsFeatureDescriptorEnum.variable, variable);
	}
}
