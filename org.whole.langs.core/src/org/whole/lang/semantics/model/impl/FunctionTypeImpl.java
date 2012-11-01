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
public class FunctionTypeImpl extends AbstractSimpleEntity implements
		FunctionType {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<FunctionType> wGetEntityDescriptor() {
		return SemanticsEntityDescriptorEnum.FunctionType;
	}

	public int wGetEntityOrd() {
		return SemanticsEntityDescriptorEnum.FunctionType_ord;
	}

	public void accept(ISemanticsVisitor visitor) {
		visitor.visit(this);
	}

	private SignatureOrSequence source;

	public SignatureOrSequence getSource() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.source, source);
	}

	public void setSource(SignatureOrSequence source) {
		notifyChanged(SemanticsFeatureDescriptorEnum.source, this.source,
				this.source = source);
	}

	private SignatureOrSequence target;

	public SignatureOrSequence getTarget() {
		return notifyRequested(SemanticsFeatureDescriptorEnum.target, target);
	}

	public void setTarget(SignatureOrSequence target) {
		notifyChanged(SemanticsFeatureDescriptorEnum.target, this.target,
				this.target = target);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getSource().wGetAdaptee(false);
		case 1:
			return getTarget().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSource(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.SignatureOrSequence));
			break;
		case 1:
			setTarget(value
					.wGetAdapter(SemanticsEntityDescriptorEnum.SignatureOrSequence));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
