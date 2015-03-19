package org.whole.lang.firstorderlogic.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TheoremImpl extends AbstractSimpleEntity implements Theorem {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Theorem> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.Theorem;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.Theorem_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Formula statement;

	public Formula getStatement() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.statement,
				statement);
	}

	public void setStatement(Formula statement) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.statement,
				this.statement, this.statement = statement);
	}

	private Formulae proof;

	public Formulae getProof() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.proof,
				proof);
	}

	public void setProof(Formulae proof) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.proof, this.proof,
				this.proof = proof);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getStatement().wGetAdaptee(false);
		case 2:
			return getProof().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 1:
			setStatement(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formula));
			break;
		case 2:
			setProof(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Formulae));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
