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
public class EntityNameImpl extends AbstractSimpleEntity implements EntityName {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<EntityName> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.EntityName;
	}

	public int wGetEntityOrd() {
		return FirstOrderLogicEntityDescriptorEnum.EntityName_ord;
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	private LanguageName language;

	public LanguageName getLanguage() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.language,
				language);
	}

	public void setLanguage(LanguageName language) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.language,
				this.language, this.language = language);
	}

	private Name entityName;

	public Name getEntityName() {
		return notifyRequested(FirstOrderLogicFeatureDescriptorEnum.entityName,
				entityName);
	}

	public void setEntityName(Name entityName) {
		notifyChanged(FirstOrderLogicFeatureDescriptorEnum.entityName,
				this.entityName, this.entityName = entityName);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLanguage().wGetAdaptee(false);
		case 1:
			return getEntityName().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLanguage(value
					.wGetAdapter(FirstOrderLogicEntityDescriptorEnum.LanguageName));
			break;
		case 1:
			setEntityName(value
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
