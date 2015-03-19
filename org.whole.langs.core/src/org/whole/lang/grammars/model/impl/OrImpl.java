package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class OrImpl extends AbstractSimpleEntity implements Or {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Or> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Or;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Or_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Predicate predicate1;

	public Predicate getPredicate1() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.predicate1,
				predicate1);
	}

	public void setPredicate1(Predicate predicate1) {
		notifyChanged(GrammarsFeatureDescriptorEnum.predicate1,
				this.predicate1, this.predicate1 = predicate1);
	}

	private Predicate predicate2;

	public Predicate getPredicate2() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.predicate2,
				predicate2);
	}

	public void setPredicate2(Predicate predicate2) {
		notifyChanged(GrammarsFeatureDescriptorEnum.predicate2,
				this.predicate2, this.predicate2 = predicate2);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPredicate1().wGetAdaptee(false);
		case 1:
			return getPredicate2().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPredicate1(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Predicate));
			break;
		case 1:
			setPredicate2(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Predicate));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
