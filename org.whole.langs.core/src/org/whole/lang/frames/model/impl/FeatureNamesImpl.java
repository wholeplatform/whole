package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class FeatureNamesImpl extends
		AbstractCollectionCompositeEntity<FeatureName> implements FeatureNames {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.FeatureNames_ord;
	}

	public EntityDescriptor<FeatureNames> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.FeatureNames;
	}
}
