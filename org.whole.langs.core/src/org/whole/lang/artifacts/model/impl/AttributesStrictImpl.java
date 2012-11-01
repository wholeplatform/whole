package org.whole.lang.artifacts.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class AttributesStrictImpl extends AbstractSetCompositeEntity<Attribute>
		implements Attributes {
	private static final long serialVersionUID = 1;

	public void accept(IArtifactsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return ArtifactsEntityDescriptorEnum.Attributes_ord;
	}

	public EntityDescriptor<Attributes> wGetEntityDescriptor() {
		return ArtifactsEntityDescriptorEnum.Attributes;
	}
}
