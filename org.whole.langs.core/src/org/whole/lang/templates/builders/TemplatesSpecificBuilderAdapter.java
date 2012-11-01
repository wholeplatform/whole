package org.whole.lang.templates.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.templates.reflect.TemplatesFeatureDescriptorEnum;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TemplatesSpecificBuilderAdapter extends GenericBuilderContext
		implements ITemplatesBuilder {
	public TemplatesSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public TemplatesSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void qualifier() {
		wFeature(TemplatesFeatureDescriptorEnum.qualifier);
	}

	public void template() {
		wFeature(TemplatesFeatureDescriptorEnum.template);
	}

	public void forNames() {
		wFeature(TemplatesFeatureDescriptorEnum.forNames);
	}

	public void templates() {
		wFeature(TemplatesFeatureDescriptorEnum.templates);
	}

	public void name() {
		wFeature(TemplatesFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void TemplateManager() {
		wEntity(TemplatesEntityDescriptorEnum.TemplateManager);
	}

	public void TemplateManager_() {
		wEntity_(TemplatesEntityDescriptorEnum.TemplateManager);
	}

	public void _TemplateManager() {
		_wEntity(TemplatesEntityDescriptorEnum.TemplateManager);
	}

	public void Templates() {
		wEntity(TemplatesEntityDescriptorEnum.Templates);
	}

	public void Templates_() {
		wEntity_(TemplatesEntityDescriptorEnum.Templates);
	}

	public void Templates_(int initialCapacity) {
		wEntity_(TemplatesEntityDescriptorEnum.Templates, initialCapacity);
	}

	public void _Templates() {
		_wEntity(TemplatesEntityDescriptorEnum.Templates);
	}

	public void TemplateFactory() {
		wEntity(TemplatesEntityDescriptorEnum.TemplateFactory);
	}

	public void TemplateFactory_() {
		wEntity_(TemplatesEntityDescriptorEnum.TemplateFactory);
	}

	public void _TemplateFactory() {
		_wEntity(TemplatesEntityDescriptorEnum.TemplateFactory);
	}

	public void Names() {
		wEntity(TemplatesEntityDescriptorEnum.Names);
	}

	public void Names_() {
		wEntity_(TemplatesEntityDescriptorEnum.Names);
	}

	public void Names_(int initialCapacity) {
		wEntity_(TemplatesEntityDescriptorEnum.Names, initialCapacity);
	}

	public void _Names() {
		_wEntity(TemplatesEntityDescriptorEnum.Names);
	}

	public void QualifiedName() {
		wEntity(TemplatesEntityDescriptorEnum.QualifiedName);
	}

	public void QualifiedName_() {
		wEntity_(TemplatesEntityDescriptorEnum.QualifiedName);
	}

	public void _QualifiedName() {
		_wEntity(TemplatesEntityDescriptorEnum.QualifiedName);
	}

	public void SimpleName() {
		wEntity(TemplatesEntityDescriptorEnum.SimpleName);
	}

	public void SimpleName(String value) {
		wEntity(TemplatesEntityDescriptorEnum.SimpleName, value);
	}
}
