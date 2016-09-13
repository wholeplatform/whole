package org.whole.lang.versions.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class VersionsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int History_ord = 0;
	public static final int Version_ord = 1;
	public static final int Versionable_ord = 2;
	public static final int Versions_ord = 3;
	public static final int VersionsRefs_ord = 4;
	public static final int VersionLabel_ord = 5;
	public static final VersionsEntityDescriptorEnum instance = new VersionsEntityDescriptorEnum();
	public static final EntityDescriptor<History> History = (EntityDescriptor<History>) instance
			.valueOf(History_ord);
	public static final EntityDescriptor<Version> Version = (EntityDescriptor<Version>) instance
			.valueOf(Version_ord);
	public static final EntityDescriptor<Versionable> Versionable = (EntityDescriptor<Versionable>) instance
			.valueOf(Versionable_ord);
	public static final EntityDescriptor<Versions> Versions = (EntityDescriptor<Versions>) instance
			.valueOf(Versions_ord);
	public static final EntityDescriptor<VersionsRefs> VersionsRefs = (EntityDescriptor<VersionsRefs>) instance
			.valueOf(VersionsRefs_ord);
	public static final EntityDescriptor<VersionLabel> VersionLabel = (EntityDescriptor<VersionLabel>) instance
			.valueOf(VersionLabel_ord);

	private VersionsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(History_ord, "History", History.class, false)
				.withFeature(VersionsFeatureDescriptorEnum.versions,
						Versions_ord, VersionsFeatureDescriptorEnum.history,
						false, false, false, false, false).withFeature(
						VersionsFeatureDescriptorEnum.rootVersion, Version_ord,
						false, false, true, false, false);
		putSimpleEntity(Version_ord, "Version", Version.class, false)
				.withFeature(VersionsFeatureDescriptorEnum.versionLabel,
						VersionLabel_ord, false, true, false, false, false)
				.withFeature(VersionsFeatureDescriptorEnum.history,
						History_ord, VersionsFeatureDescriptorEnum.versions,
						true, false, true, false, false)
				.withFeature(VersionsFeatureDescriptorEnum.predecessors,
						VersionsRefs_ord,
						VersionsFeatureDescriptorEnum.successors, true, false,
						true, false, false)
				.withFeature(VersionsFeatureDescriptorEnum.successors,
						VersionsRefs_ord,
						VersionsFeatureDescriptorEnum.predecessors, true,
						false, true, false, false)
				.withFeature(VersionsFeatureDescriptorEnum.versionable,
						Versionable_ord,
						VersionsFeatureDescriptorEnum.baseVersion, false,
						false, true, false, false);
		putSimpleEntity(Versionable_ord, "Versionable", Versionable.class, true)
				.withFeature(VersionsFeatureDescriptorEnum.baseVersion,
						Version_ord, VersionsFeatureDescriptorEnum.versionable,
						false, false, true, false, false).withFeature(
						VersionsFeatureDescriptorEnum.predecessors,
						VersionsRefs_ord, true, false, true, false, false);
		putCompositeEntity(
		Versions_ord, "Versions", Versions.class, true, Version_ord, false, true);
		putCompositeEntity(VersionsRefs_ord, "VersionsRefs",
				VersionsRefs.class, true, Version_ord, false, true, true, false,
				false);
		putDataEntity(VersionLabel_ord, "VersionLabel", VersionLabel.class,
				true, String.class);
	}

	protected void initForeignTypeRelations() {
		setAssignableFromAll(true, Versionable_ord);
	}
}
