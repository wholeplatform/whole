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
public class DataTerminalImpl extends AbstractSimpleEntity implements
		DataTerminal {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DataTerminal> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.DataTerminal;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.DataTerminal_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		visitor.visit(this);
	}

	private Pattern pattern;

	public Pattern getPattern() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.pattern, pattern);
	}

	public void setPattern(Pattern pattern) {
		notifyChanged(GrammarsFeatureDescriptorEnum.pattern, this.pattern,
				this.pattern = pattern);
	}

	private Category category;

	public Category getCategory() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.category, category);
	}

	public void setCategory(Category category) {
		notifyChanged(GrammarsFeatureDescriptorEnum.category, this.category,
				this.category = category);
	}

	private Format format;

	public Format getFormat() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.format, format);
	}

	public void setFormat(Format format) {
		notifyChanged(GrammarsFeatureDescriptorEnum.format, this.format,
				this.format = format);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPattern().wGetAdaptee(false);
		case 1:
			return getCategory().wGetAdaptee(false);
		case 2:
			return getFormat().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setPattern(value.wGetAdapter(GrammarsEntityDescriptorEnum.Pattern));
			break;
		case 1:
			setCategory(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Category));
			break;
		case 2:
			setFormat(value.wGetAdapter(GrammarsEntityDescriptorEnum.Format));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
