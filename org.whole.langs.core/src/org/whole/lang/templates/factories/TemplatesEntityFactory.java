package org.whole.lang.templates.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.templates.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.templates.reflect.TemplatesEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class TemplatesEntityFactory extends GenericEntityFactory {
	public static final TemplatesEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static TemplatesEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new TemplatesEntityFactory(provider);
	}

	protected TemplatesEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public TemplateManager createTemplateManager() {
		return create(TemplatesEntityDescriptorEnum.TemplateManager);
	}

	public TemplateManager createTemplateManager(SimpleName name,
			Templates templates) {
		return create(TemplatesEntityDescriptorEnum.TemplateManager, name,
				templates);
	}

	public IEntityBuilder<TemplateManager> buildTemplateManager() {
		return new EntityBuilder<TemplateManager>(
				create(TemplatesEntityDescriptorEnum.TemplateManager));
	}

	public Templates createTemplates() {
		return create(TemplatesEntityDescriptorEnum.Templates);
	}

	public Templates createTemplates(TemplateFactory... entities) {
		return create(TemplatesEntityDescriptorEnum.Templates,
				(IEntity[]) entities);
	}

	public Templates createTemplates(int initialSize) {
		return clone(TemplatesEntityDescriptorEnum.Templates, initialSize);
	}

	public TemplateFactory createTemplateFactory() {
		return create(TemplatesEntityDescriptorEnum.TemplateFactory);
	}

	public TemplateFactory createTemplateFactory(SimpleName name,
			Names forNames, Template template) {
		return create(TemplatesEntityDescriptorEnum.TemplateFactory, name,
				forNames, template);
	}

	public IEntityBuilder<TemplateFactory> buildTemplateFactory() {
		return new EntityBuilder<TemplateFactory>(
				create(TemplatesEntityDescriptorEnum.TemplateFactory));
	}

	public Names createNames() {
		return create(TemplatesEntityDescriptorEnum.Names);
	}

	public Names createNames(Name... entities) {
		return create(TemplatesEntityDescriptorEnum.Names, (IEntity[]) entities);
	}

	public Names createNames(int initialSize) {
		return clone(TemplatesEntityDescriptorEnum.Names, initialSize);
	}

	public QualifiedName createQualifiedName() {
		return create(TemplatesEntityDescriptorEnum.QualifiedName);
	}

	public QualifiedName createQualifiedName(SimpleName qualifier, Name name) {
		return create(TemplatesEntityDescriptorEnum.QualifiedName, qualifier,
				name);
	}

	public IEntityBuilder<QualifiedName> buildQualifiedName() {
		return new EntityBuilder<QualifiedName>(
				create(TemplatesEntityDescriptorEnum.QualifiedName));
	}

	public SimpleName createSimpleName() {
		return create(TemplatesEntityDescriptorEnum.SimpleName);
	}

	public SimpleName createSimpleName(String value) {
		return create(TemplatesEntityDescriptorEnum.SimpleName, value);
	}
}
