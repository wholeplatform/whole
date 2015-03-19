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
public class NameDeclarationImpl extends AbstractSimpleEntity implements
		NameDeclaration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<NameDeclaration> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.NameDeclaration;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.NameDeclaration_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private Name name;

	public Name getName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Type type;

	public Type getType() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.type, type);
	}

	public void setType(Type type) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.type, this.type,
				this.type = type);
	}

	private Path modelBinding;

	public Path getModelBinding() {
		return notifyRequested(
				FirstOrderLogicFeatureDescriptorEnum.modelBinding, modelBinding);
	}

	public void setModelBinding(Path modelBinding) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.modelBinding,
				this.modelBinding, this.modelBinding = modelBinding);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getType().wGetAdaptee(false);
		case 2:
			return getModelBinding().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Name));
			break;
		case 1:
			setType(value.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Type));
			break;
		case 2:
			setModelBinding(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.Path));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
