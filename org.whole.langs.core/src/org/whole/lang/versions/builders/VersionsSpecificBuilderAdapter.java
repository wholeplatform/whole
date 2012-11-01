package org.whole.lang.versions.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionsSpecificBuilderAdapter extends GenericBuilderContext
		implements IVersionsBuilder {
	public VersionsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public VersionsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void baseVersion() {
		wFeature(VersionsFeatureDescriptorEnum.baseVersion);
	}

	public void versionable() {
		wFeature(VersionsFeatureDescriptorEnum.versionable);
	}

	public void successors() {
		wFeature(VersionsFeatureDescriptorEnum.successors);
	}

	public void predecessors() {
		wFeature(VersionsFeatureDescriptorEnum.predecessors);
	}

	public void history() {
		wFeature(VersionsFeatureDescriptorEnum.history);
	}

	public void versionLabel() {
		wFeature(VersionsFeatureDescriptorEnum.versionLabel);
	}

	public void rootVersion() {
		wFeature(VersionsFeatureDescriptorEnum.rootVersion);
	}

	public void versions() {
		wFeature(VersionsFeatureDescriptorEnum.versions);
	}

	public void visit() {
	}

	public void History() {
		wEntity(VersionsEntityDescriptorEnum.History);
	}

	public void History_() {
		wEntity_(VersionsEntityDescriptorEnum.History);
	}

	public void _History() {
		_wEntity(VersionsEntityDescriptorEnum.History);
	}

	public void Version() {
		wEntity(VersionsEntityDescriptorEnum.Version);
	}

	public void Version_() {
		wEntity_(VersionsEntityDescriptorEnum.Version);
	}

	public void _Version() {
		_wEntity(VersionsEntityDescriptorEnum.Version);
	}

	public void Versions() {
		wEntity(VersionsEntityDescriptorEnum.Versions);
	}

	public void Versions_() {
		wEntity_(VersionsEntityDescriptorEnum.Versions);
	}

	public void Versions_(int initialCapacity) {
		wEntity_(VersionsEntityDescriptorEnum.Versions, initialCapacity);
	}

	public void _Versions() {
		_wEntity(VersionsEntityDescriptorEnum.Versions);
	}

	public void VersionsRefs() {
		wEntity(VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public void VersionsRefs_() {
		wEntity_(VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public void VersionsRefs_(int initialCapacity) {
		wEntity_(VersionsEntityDescriptorEnum.VersionsRefs, initialCapacity);
	}

	public void _VersionsRefs() {
		_wEntity(VersionsEntityDescriptorEnum.VersionsRefs);
	}

	public void VersionLabel() {
		wEntity(VersionsEntityDescriptorEnum.VersionLabel);
	}

	public void VersionLabel(String value) {
		wEntity(VersionsEntityDescriptorEnum.VersionLabel, value);
	}
}
