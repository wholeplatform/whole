package org.whole.lang.versions.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.versions.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class VersionsEntityFactory extends GenericEntityFactory {
	public static final VersionsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static VersionsEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new VersionsEntityFactory(provider);
	}

	protected VersionsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public History createHistory() {
		return create(VersionsEntityDescriptorEnum.History);
	}

	public History createHistory(Versions versions, Version rootVersion) {
		return create(VersionsEntityDescriptorEnum.History, versions,
				rootVersion);
	}

	public IEntityBuilder<History> buildHistory() {
		return new EntityBuilder<History>(
				create(VersionsEntityDescriptorEnum.History));
	}

	public Version createVersion() {
		return create(VersionsEntityDescriptorEnum.Version);
	}

	public Version createVersion(VersionLabel versionLabel, History history,
			VersionsRefs predecessors, VersionsRefs successors,
			Versionable versionable) {
		return create(VersionsEntityDescriptorEnum.Version, versionLabel,
				history, predecessors, successors, versionable);
	}

	public IEntityBuilder<Version> buildVersion() {
		return new EntityBuilder<Version>(
				create(VersionsEntityDescriptorEnum.Version));
	}

	public Versions createVersions() {
		return create(VersionsEntityDescriptorEnum.Versions);
	}

	public Versions createVersions(Version... entities) {
		return create(VersionsEntityDescriptorEnum.Versions,
				(IEntity[]) entities);
	}

	public Versions createVersions(int initialSize) {
		return clone(VersionsEntityDescriptorEnum.Versions, initialSize);
	}

	public VersionsRefs createVersionsRefs() {
		return create(VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public VersionsRefs createVersionsRefs(Version... entities) {
		return create(VersionsEntityDescriptorEnum.VersionsRefs,
				(IEntity[]) entities);
	}

	public VersionsRefs createVersionsRefs(int initialSize) {
		return clone(VersionsEntityDescriptorEnum.VersionsRefs, initialSize);
	}

	public VersionLabel createVersionLabel() {
		return create(VersionsEntityDescriptorEnum.VersionLabel);
	}

	public VersionLabel createVersionLabel(String value) {
		return create(VersionsEntityDescriptorEnum.VersionLabel, value);
	}
}
