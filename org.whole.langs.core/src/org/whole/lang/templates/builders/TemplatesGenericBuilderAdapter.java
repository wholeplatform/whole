package org.whole.lang.templates.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplatesGenericBuilderAdapter extends GenericIdentityBuilder {
	private ITemplatesBuilder specificBuilder;

	public TemplatesGenericBuilderAdapter(ITemplatesBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public TemplatesGenericBuilderAdapter(ITemplatesBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case TemplatesFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case TemplatesFeatureDescriptorEnum.templates_ord:
			specificBuilder.templates();
			break;
		case TemplatesFeatureDescriptorEnum.forNames_ord:
			specificBuilder.forNames();
			break;
		case TemplatesFeatureDescriptorEnum.template_ord:
			specificBuilder.template();
			break;
		case TemplatesFeatureDescriptorEnum.qualifier_ord:
			specificBuilder.qualifier();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TemplatesEntityDescriptorEnum.TemplateManager_ord:
			specificBuilder.TemplateManager();
			break;
		case TemplatesEntityDescriptorEnum.Templates_ord:
			specificBuilder.Templates();
			break;
		case TemplatesEntityDescriptorEnum.TemplateFactory_ord:
			specificBuilder.TemplateFactory();
			break;
		case TemplatesEntityDescriptorEnum.Names_ord:
			specificBuilder.Names();
			break;
		case TemplatesEntityDescriptorEnum.QualifiedName_ord:
			specificBuilder.QualifiedName();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TemplatesEntityDescriptorEnum.TemplateManager_ord:
			specificBuilder.TemplateManager_();
			break;
		case TemplatesEntityDescriptorEnum.Templates_ord:
			specificBuilder.Templates_();
			break;
		case TemplatesEntityDescriptorEnum.TemplateFactory_ord:
			specificBuilder.TemplateFactory_();
			break;
		case TemplatesEntityDescriptorEnum.Names_ord:
			specificBuilder.Names_();
			break;
		case TemplatesEntityDescriptorEnum.QualifiedName_ord:
			specificBuilder.QualifiedName_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case TemplatesEntityDescriptorEnum.TemplateManager_ord:
			specificBuilder._TemplateManager();
			break;
		case TemplatesEntityDescriptorEnum.Templates_ord:
			specificBuilder._Templates();
			break;
		case TemplatesEntityDescriptorEnum.TemplateFactory_ord:
			specificBuilder._TemplateFactory();
			break;
		case TemplatesEntityDescriptorEnum.Names_ord:
			specificBuilder._Names();
			break;
		case TemplatesEntityDescriptorEnum.QualifiedName_ord:
			specificBuilder._QualifiedName();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case TemplatesEntityDescriptorEnum.Templates_ord:
			specificBuilder.Templates_(initialCapacity);
			break;
		case TemplatesEntityDescriptorEnum.Names_ord:
			specificBuilder.Names_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case TemplatesEntityDescriptorEnum.SimpleName_ord:
			specificBuilder.SimpleName(value);
			break;
		}
	}
}
