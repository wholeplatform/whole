package org.whole.lang.versions.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.versions.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.versions.visitors.IVersionsVisitor;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class HistoryImpl extends AbstractSimpleEntity implements History {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<History> wGetEntityDescriptor() {
		return VersionsEntityDescriptorEnum.History;
	}

	public int wGetEntityOrd() {
		return VersionsEntityDescriptorEnum.History_ord;
	}

	public void accept(IVersionsVisitor visitor) {
		visitor.visit(this);
	}

	private Versions versions;

	public Versions getVersions() {
		return notifyRequested(VersionsFeatureDescriptorEnum.versions, versions);
	}

	public void setVersions(Versions versions) {
		notifyChanged(VersionsFeatureDescriptorEnum.versions, this.versions,
				this.versions = versions);
	}

	private Version rootVersion;

	public Version getRootVersion() {
		return notifyRequested(VersionsFeatureDescriptorEnum.rootVersion,
				rootVersion);
	}

	public void setRootVersion(Version rootVersion) {
		notifyChanged(VersionsFeatureDescriptorEnum.rootVersion,
				this.rootVersion, this.rootVersion = rootVersion, false);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getVersions().wGetAdaptee(false);
		case 1:
			return getRootVersion().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setVersions(value
					.wGetAdapter(VersionsEntityDescriptorEnum.Versions));
			break;
		case 1:
			setRootVersion(value
					.wGetAdapter(VersionsEntityDescriptorEnum.Version));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 1;
	}

	public int wAdjacentSize() {
		return 1;
	}
}
