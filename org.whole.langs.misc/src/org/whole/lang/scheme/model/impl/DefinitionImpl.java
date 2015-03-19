package org.whole.lang.scheme.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.scheme.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.scheme.visitors.ISchemeVisitor;
import org.whole.lang.scheme.reflect.SchemeFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DefinitionImpl extends AbstractSimpleEntity implements Definition {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Definition> wGetEntityDescriptor() {
		return SchemeEntityDescriptorEnum.Definition;
	}

	public int wGetEntityOrd() {
		return SchemeEntityDescriptorEnum.Definition_ord;
	}

	public void accept(ISchemeVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SchemeFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SchemeFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private SchemeExpression expression;

	public SchemeExpression getExpression() {
		return notifyRequested(SchemeFeatureDescriptorEnum.expression,
				expression);
	}

	public void setExpression(SchemeExpression expression) {
		notifyChanged(SchemeFeatureDescriptorEnum.expression, this.expression,
				this.expression = expression);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getExpression().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SchemeEntityDescriptorEnum.Name));
			break;
		case 1:
			setExpression(value
					.wGetAdapter(SchemeEntityDescriptorEnum.SchemeExpression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
