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
public class ByDelimiterImpl extends AbstractSimpleEntity implements
		ByDelimiter {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ByDelimiter> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.ByDelimiter;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.ByDelimiter_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		visitor.visit(this);
	}

	private Pattern delimiter;

	public Pattern getDelimiter() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.delimiter,
				delimiter);
	}

	public void setDelimiter(Pattern delimiter) {
		notifyChanged(GrammarsFeatureDescriptorEnum.delimiter, this.delimiter,
				this.delimiter = delimiter);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDelimiter().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDelimiter(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Pattern));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
