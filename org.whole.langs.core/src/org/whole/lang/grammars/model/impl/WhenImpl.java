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
public class WhenImpl extends AbstractSimpleEntity implements When {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<When> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.When;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.When_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Predicate predicate;

	public Predicate getPredicate() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.predicate,
				predicate);
	}

	public void setPredicate(Predicate predicate) {
		notifyChanged(GrammarsFeatureDescriptorEnum.predicate, this.predicate,
				this.predicate = predicate);
	}

	private Rule rule;

	public Rule getRule() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.rule, rule);
	}

	public void setRule(Rule rule) {
		notifyChanged(GrammarsFeatureDescriptorEnum.rule, this.rule,
				this.rule = rule);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPredicate().wGetAdaptee(false);
		case 1:
			return getRule().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPredicate(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Predicate));
			break;
		case 1:
			setRule(value.wGetAdapter(GrammarsEntityDescriptorEnum.Rule));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
