package org.whole.lang.editors.model.impl;

import org.whole.lang.model.AbstractBagCompositeEntity;
import org.whole.lang.editors.model.*;
import org.whole.lang.editors.visitors.IEditorsVisitor;
import org.whole.lang.editors.reflect.EditorsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class EntityFeaturesStrictImpl extends
		AbstractBagCompositeEntity<FeatureName> implements EntityFeatures {
	private static final long serialVersionUID = 1;

	public void accept(IEditorsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return EditorsEntityDescriptorEnum.EntityFeatures_ord;
	}

	public EntityDescriptor<EntityFeatures> wGetEntityDescriptor() {
		return EditorsEntityDescriptorEnum.EntityFeatures;
	}
}
