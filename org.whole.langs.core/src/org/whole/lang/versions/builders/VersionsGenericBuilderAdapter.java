package org.whole.lang.versions.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.versions.reflect.VersionsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.versions.reflect.VersionsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class VersionsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IVersionsBuilder specificBuilder;

	public VersionsGenericBuilderAdapter(IVersionsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public VersionsGenericBuilderAdapter(IVersionsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case VersionsFeatureDescriptorEnum.versions_ord:
			specificBuilder.versions();
			break;
		case VersionsFeatureDescriptorEnum.rootVersion_ord:
			specificBuilder.rootVersion();
			break;
		case VersionsFeatureDescriptorEnum.versionLabel_ord:
			specificBuilder.versionLabel();
			break;
		case VersionsFeatureDescriptorEnum.history_ord:
			specificBuilder.history();
			break;
		case VersionsFeatureDescriptorEnum.predecessors_ord:
			specificBuilder.predecessors();
			break;
		case VersionsFeatureDescriptorEnum.successors_ord:
			specificBuilder.successors();
			break;
		case VersionsFeatureDescriptorEnum.versionable_ord:
			specificBuilder.versionable();
			break;
		case VersionsFeatureDescriptorEnum.baseVersion_ord:
			specificBuilder.baseVersion();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case VersionsEntityDescriptorEnum.History_ord:
			specificBuilder.History();
			break;
		case VersionsEntityDescriptorEnum.Version_ord:
			specificBuilder.Version();
			break;
		case VersionsEntityDescriptorEnum.Versions_ord:
			specificBuilder.Versions();
			break;
		case VersionsEntityDescriptorEnum.VersionsRefs_ord:
			specificBuilder.VersionsRefs();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case VersionsEntityDescriptorEnum.History_ord:
			specificBuilder.History_();
			break;
		case VersionsEntityDescriptorEnum.Version_ord:
			specificBuilder.Version_();
			break;
		case VersionsEntityDescriptorEnum.Versions_ord:
			specificBuilder.Versions_();
			break;
		case VersionsEntityDescriptorEnum.VersionsRefs_ord:
			specificBuilder.VersionsRefs_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case VersionsEntityDescriptorEnum.History_ord:
			specificBuilder._History();
			break;
		case VersionsEntityDescriptorEnum.Version_ord:
			specificBuilder._Version();
			break;
		case VersionsEntityDescriptorEnum.Versions_ord:
			specificBuilder._Versions();
			break;
		case VersionsEntityDescriptorEnum.VersionsRefs_ord:
			specificBuilder._VersionsRefs();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case VersionsEntityDescriptorEnum.Versions_ord:
			specificBuilder.Versions_(initialCapacity);
			break;
		case VersionsEntityDescriptorEnum.VersionsRefs_ord:
			specificBuilder.VersionsRefs_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case VersionsEntityDescriptorEnum.VersionLabel_ord:
			specificBuilder.VersionLabel(value);
			break;
		}
	}
}
