package org.whole.lang.versions.model.impl;

import org.whole.lang.model.AbstractSetCompositeEntity;
import org.whole.lang.versions.model.*;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/** 
 * @generator Whole
 */
public class VersionsRefsStrictImpl extends AbstractSetCompositeEntity<Version>
		implements VersionsRefs {
	private static final long serialVersionUID = 1;

	public void accept(IVersionsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wGetEntityOrd() {
		return VersionsEntityDescriptorEnum.VersionsRefs_ord;
	}

	public EntityDescriptor<VersionsRefs> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.VersionsRefs;
	}

	public boolean isContainment() {
		return false;
	}
}
