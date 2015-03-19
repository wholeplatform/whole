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
public class RepeatImpl extends AbstractSimpleEntity implements Repeat {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Repeat> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Repeat;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Repeat_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Size lowerBound;

	public Size getLowerBound() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.lowerBound,
				lowerBound);
	}

	public void setLowerBound(Size lowerBound) {
		notifyChanged(GrammarsFeatureDescriptorEnum.lowerBound,
				this.lowerBound, this.lowerBound = lowerBound);
	}

	private Bound upperBound;

	public Bound getUpperBound() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.upperBound,
				upperBound);
	}

	public void setUpperBound(Bound upperBound) {
		notifyChanged(GrammarsFeatureDescriptorEnum.upperBound,
				this.upperBound, this.upperBound = upperBound);
	}

	private Rule separator;

	public Rule getSeparator() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.separator,
				separator);
	}

	public void setSeparator(Rule separator) {
		notifyChanged(GrammarsFeatureDescriptorEnum.separator, this.separator,
				this.separator = separator);
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
			return getLowerBound().wGetAdaptee(false);
		case 1:
			return getUpperBound().wGetAdaptee(false);
		case 2:
			return getSeparator().wGetAdaptee(false);
		case 3:
			return getRule().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLowerBound(value.wGetAdapter(GrammarsEntityDescriptorEnum.Size));
			break;
		case 1:
			setUpperBound(value.wGetAdapter(GrammarsEntityDescriptorEnum.Bound));
			break;
		case 2:
			setSeparator(value.wGetAdapter(GrammarsEntityDescriptorEnum.Rule));
			break;
		case 3:
			setRule(value.wGetAdapter(GrammarsEntityDescriptorEnum.Rule));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
