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
public class SplitImpl extends AbstractSimpleEntity implements Split {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Split> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Split;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Split_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Splitter splitter;

	public Splitter getSplitter() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.splitter, splitter);
	}

	public void setSplitter(Splitter splitter) {
		notifyChanged(GrammarsFeatureDescriptorEnum.splitter, this.splitter,
				this.splitter = splitter);
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
			return getSplitter().wGetAdaptee(false);
		case 1:
			return getRule().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setSplitter(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Splitter));
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
