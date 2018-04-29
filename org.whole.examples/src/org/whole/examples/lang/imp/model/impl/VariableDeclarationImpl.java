package org.whole.examples.lang.imp.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.examples.lang.imp.model.VariableDeclaration;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.examples.lang.imp.model.Type;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.model.Name;
import org.whole.examples.lang.imp.model.Expression;

/** 
 * @generator Whole
 */
public class VariableDeclarationImpl extends AbstractSimpleEntity implements VariableDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<VariableDeclaration> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.VariableDeclaration;
	}

	public int wGetEntityOrd() {
		return ImpEntityDescriptorEnum.VariableDeclaration_ord;
	}

	public void accept(IImpVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Type type;

	public Type getType() {
		return notifyRequested(ImpFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(ImpFeatureDescriptorEnum.type, this.type, this.type = type);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(ImpFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(ImpFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private Expression initializer;

	public Expression getInitializer() {
		return notifyRequested(ImpFeatureDescriptorEnum.initializer, initializer);
	}

	public void setInitializer(Expression initializer) {
		notifyChanged(ImpFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getType().wGetAdaptee(false);
		case 1:
			return getName().wGetAdaptee(false);
		case 2:
			return getInitializer().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setType(value.wGetAdapter(ImpEntityDescriptorEnum.Type));
			break;
		case 1:
			setName(value.wGetAdapter(ImpEntityDescriptorEnum.Name));
			break;
		case 2:
			setInitializer(value.wGetAdapter(ImpEntityDescriptorEnum.Expression));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
