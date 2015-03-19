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
public class ImportDeclarationImpl extends AbstractSimpleEntity implements
		ImportDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<ImportDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.ImportDeclaration;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.ImportDeclaration_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private TheoryName language;

	public TheoryName getLanguage() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.language,
				language);
	}

	public void setLanguage(TheoryName language) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.language,
				this.language, this.language = language);
	}

	private Name alias;

	public Name getAlias() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.alias,
				alias);
	}

	public void setAlias(Name alias) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.alias, this.alias,
				this.alias = alias);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLanguage().wGetAdaptee(false);
		case 1:
			return getAlias().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLanguage(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.TheoryName));
			break;
		case 1:
			setAlias(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
