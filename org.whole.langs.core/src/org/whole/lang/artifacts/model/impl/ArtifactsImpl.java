package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class ArtifactsImpl extends AbstractListCompositeEntity<Artifact>
		implements Artifacts {
	private static final long serialVersionUID = 1;

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.Artifacts_ord;
	}

	public EntityDescriptor<Artifacts> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Artifacts;
	}
}
