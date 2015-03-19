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
public class LiteralTerminalImpl extends AbstractSimpleEntity implements
		LiteralTerminal {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<LiteralTerminal> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.LiteralTerminal;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.LiteralTerminal_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
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

	private Literal literal;

	public Literal getLiteral() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.literal, literal);
	}

	public void setLiteral(Literal literal) {
		notifyChanged(GrammarsFeatureDescriptorEnum.literal, this.literal,
				this.literal = literal);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getPattern().wGetAdaptee(false);
		case 1:
			return getCategory().wGetAdaptee(false);
		case 2:
			return getLiteral().wGetAdaptee(false);
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
			setLiteral(value.wGetAdapter(GrammarsEntityDescriptorEnum.Literal));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
