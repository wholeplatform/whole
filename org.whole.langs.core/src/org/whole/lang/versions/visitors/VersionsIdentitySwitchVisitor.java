package org.whole.lang.versions.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class VersionsIdentitySwitchVisitor extends AbstractVisitor
		implements IVersionsVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case VersionsEntityDescriptorEnum.History_ord:
			visit((History) entity);
			break;
		case VersionsEntityDescriptorEnum.Version_ord:
			visit((Version) entity);
			break;
		case VersionsEntityDescriptorEnum.Versions_ord:
			visit((Versions) entity);
			break;
		case VersionsEntityDescriptorEnum.VersionsRefs_ord:
			visit((VersionsRefs) entity);
			break;
		case VersionsEntityDescriptorEnum.VersionLabel_ord:
			visit((VersionLabel) entity);
			break;
		}
	}
}
