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
public class SequenceTypeImpl extends AbstractSimpleEntity implements
		SequenceType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<SequenceType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.SequenceType;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.SequenceType_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private Signature signature;

	public Signature getSignature() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.signature,
				signature);
	}

	public void setSignature(Signature signature) {
		notifyChanged(SemanticsFeatureDescriptorEnum.signature, this.signature,
				this.signature = signature);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSignature().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSignature(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.Signature));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
