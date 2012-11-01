package org.whole.lang.frames.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.frames.model.*;
import org.whole.lang.frames.visitors.IFramesVisitor;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class SolitaryFeaturesImpl extends
		AbstractListCompositeEntity<SolitaryFeature> implements
		SolitaryFeatures {
	private static final long serialVersionUID = 1;

	public void accept(IFramesVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return FramesEntityDescriptorEnum.SolitaryFeatures_ord;
	}

	public EntityDescriptor<SolitaryFeatures> wGetEntityDescriptor() {
		return FramesEntityDescriptorEnum.SolitaryFeatures;
	}
}
