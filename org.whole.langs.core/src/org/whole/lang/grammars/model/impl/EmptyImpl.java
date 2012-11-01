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
public class EmptyImpl extends AbstractSimpleEntity implements Empty {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Empty> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Empty;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Empty_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		visitor.visit(this);
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
			return getLiteral().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLiteral(value.wGetAdapter(GrammarsEntityDescriptorEnum.Literal));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}
}
