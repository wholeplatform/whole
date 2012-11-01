package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class NaturesImpl extends AbstractListCompositeEntity<Nature> implements
		Natures {
	private static final long serialVersionUID = 1;

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.Natures_ord;
	}

	public EntityDescriptor<Natures> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Natures;
	}
}
