package org.whole.lang.versions.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.versions.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionableAdapter extends AbstractEntityAdapter implements
		Versionable {
	private static final long serialVersionUID = 1;

	public VersionableAdapter(IEntity implementor) {
		super(implementor);
	}

	public VersionableAdapter() {
	}

	public void accept(IVersionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Versionable> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.Versionable;
	}

	public Version getBaseVersion() {
		return wGet(VersionsFeatureDescriptorEnum.baseVersion).wGetAdapter(
				VersionsEntityDescriptorEnum.Version);
	}

	public void setBaseVersion(Version baseVersion) {
		wSet(VersionsFeatureDescriptorEnum.baseVersion, baseVersion);
	}

	public VersionsRefs getPredecessors() {
		return wGet(VersionsFeatureDescriptorEnum.predecessors).wGetAdapter(
				VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public void setPredecessors(VersionsRefs predecessors) {
		wSet(VersionsFeatureDescriptorEnum.predecessors, predecessors);
	}
}
