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
public class VariableValueAdapter extends AbstractEntityAdapter implements
		VariableValue {
	private static final long serialVersionUID = 1;

	public VariableValueAdapter(IEntity implementor) {
		super(implementor);
	}

	public VariableValueAdapter() {
	}

	public void accept(ISemanticsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<VariableValue> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.VariableValue;
	}

	public Identifier getIdentifier() {
		return wGet(SemanticsFeatureDescriptorEnum.identifier).wGetAdapter(
				SemanticsEntityDescriptorEnum.Identifier);
	}

	public void setIdentifier(Identifier identifier) {
		wSet(SemanticsFeatureDescriptorEnum.identifier, identifier);
	}
}
