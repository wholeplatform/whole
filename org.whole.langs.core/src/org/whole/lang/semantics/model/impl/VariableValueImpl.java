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
public class VariableValueImpl extends AbstractSimpleEntity implements
		VariableValue {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableValue> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.VariableValue;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.VariableValue_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Identifier identifier;

	public Identifier getIdentifier() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.identifier,
				identifier);
	}

	public void setIdentifier(Identifier identifier) {
		notifyChanged(SemanticsFeatureDescriptorEnum.identifier,
				this.identifier, this.identifier = identifier);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getIdentifier().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setIdentifier(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Identifier));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
