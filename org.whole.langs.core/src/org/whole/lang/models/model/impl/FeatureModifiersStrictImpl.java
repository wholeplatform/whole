package org.whole.lang.models.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.models.model.*;
import org.whole.lang.models.visitors.IModelsVisitor;
import org.whole.lang.models.reflect.ModelsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FeatureModifiersStrictImpl extends
		AbstractSetCompositeEntity<FeatureModifier> implements FeatureModifiers {
	private static final long serialVersionUID = 1;

	public void accept(IModelsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ModelsEntityDescriptorEnum.FeatureModifiers_ord;
	}

	public EntityDescriptor<FeatureModifiers> wGetEntityDescriptor() {
		return ModelsEntityDescriptorEnum.FeatureModifiers;
	}
}
