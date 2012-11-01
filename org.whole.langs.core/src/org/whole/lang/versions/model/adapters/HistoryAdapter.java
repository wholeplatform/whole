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
public class HistoryAdapter extends AbstractEntityAdapter implements History {
	private static final long serialVersionUID = 1;

	public HistoryAdapter(IEntity implementor) {
		super(implementor);
	}

	public HistoryAdapter() {
	}

	public void accept(IVersionsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<History> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.History;
	}

	public Versions getVersions() {
		return wGet(VersionsFeatureDescriptorEnum.versions).wGetAdapter(
				VersionsEntityDescriptorEnum.Versions);
	}

	public void setVersions(Versions versions) {
		wSet(VersionsFeatureDescriptorEnum.versions, versions);
	}

	public Version getRootVersion() {
		return wGet(VersionsFeatureDescriptorEnum.rootVersion).wGetAdapter(
				VersionsEntityDescriptorEnum.Version);
	}

	public void setRootVersion(Version rootVersion) {
		wSet(VersionsFeatureDescriptorEnum.rootVersion, rootVersion);
	}
}
