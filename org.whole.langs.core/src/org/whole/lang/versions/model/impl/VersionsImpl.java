package org.whole.lang.versions.model.impl;

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.versions.model.*;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VersionsImpl extends AbstractCollectionCompositeEntity<Version>
		implements Versions {
	private static final long serialVersionUID = 1;

	public void accept(IVersionsVisitor visitor) {
		visitor.visit(this);
	}

	public int wGetEntityOrd() {
		return VersionsEntityDescriptorEnum.Versions_ord;
	}

	public EntityDescriptor<Versions> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.Versions;
	}
}
