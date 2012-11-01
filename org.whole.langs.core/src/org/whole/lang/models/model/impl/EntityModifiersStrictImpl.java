package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class EntityModifiersStrictImpl extends
		AbstractSetCompositeEntity<EntityModifier> implements EntityModifiers {
	private static final long serialVersionUID = 1;

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.EntityModifiers_ord;
	}

	public EntityDescriptor<EntityModifiers> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.EntityModifiers;
	}
}
