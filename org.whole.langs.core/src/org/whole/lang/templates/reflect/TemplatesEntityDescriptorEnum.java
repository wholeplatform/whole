package org.whole.lang.templates.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class TemplatesEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int TemplateManager_ord = 0;
	public static final int Templates_ord = 1;
	public static final int TemplateFactory_ord = 2;
	public static final int Names_ord = 3;
	public static final int QualifiedName_ord = 4;
	public static final int SimpleName_ord = 5;
	public static final int Template_ord = 6;
	public static final int Name_ord = 7;
	public static final TemplatesEntityDescriptorEnum instance = new TemplatesEntityDescriptorEnum();
	public static final EntityDescriptor<TemplateManager> TemplateManager = (EntityDescriptor<TemplateManager>) instance
			.valueOf(TemplateManager_ord);
	public static final EntityDescriptor<Templates> Templates = (EntityDescriptor<Templates>) instance
			.valueOf(Templates_ord);
	public static final EntityDescriptor<TemplateFactory> TemplateFactory = (EntityDescriptor<TemplateFactory>) instance
			.valueOf(TemplateFactory_ord);
	public static final EntityDescriptor<Names> Names = (EntityDescriptor<Names>) instance
			.valueOf(Names_ord);
	public static final EntityDescriptor<QualifiedName> QualifiedName = (EntityDescriptor<QualifiedName>) instance
			.valueOf(QualifiedName_ord);
	public static final EntityDescriptor<SimpleName> SimpleName = (EntityDescriptor<SimpleName>) instance
			.valueOf(SimpleName_ord);
	public static final EntityDescriptor<Template> Template = (EntityDescriptor<Template>) instance
			.valueOf(Template_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);

	private TemplatesEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(TemplateManager_ord, "TemplateManager",
				TemplateManager.class, false).withFeature(
				TemplatesFeatureDescriptorEnum.name, SimpleName_ord)
				.withFeature(TemplatesFeatureDescriptorEnum.templates,
						Templates_ord);
		putCompositeEntity(
		Templates_ord, "Templates", Templates.class, false, TemplateFactory_ord, true, false);
		putSimpleEntity(TemplateFactory_ord, "TemplateFactory",
				TemplateFactory.class, false)
				.withFeature(TemplatesFeatureDescriptorEnum.name,
						SimpleName_ord, false, true, false, false, false)
				.withFeature(TemplatesFeatureDescriptorEnum.forNames,
						Names_ord, true, false, false, false, false)
				.withFeature(TemplatesFeatureDescriptorEnum.template,
						Template_ord);
		putCompositeEntity(
		Names_ord, "Names", Names.class, false, Name_ord, false, true);
		putSimpleEntity(QualifiedName_ord, "QualifiedName",
				QualifiedName.class, false).withFeature(
				TemplatesFeatureDescriptorEnum.qualifier, SimpleName_ord,
				false, true, false, false, false).withFeature(
				TemplatesFeatureDescriptorEnum.name, Name_ord, false, true,
				false, false, false);
		putDataEntity(SimpleName_ord, "SimpleName", SimpleName.class, false,
				String.class);
		putSimpleEntity(Template_ord, "Template", Template.class, true);
		putSimpleEntity(Name_ord, "Name", Name.class, true, QualifiedName_ord,
				SimpleName_ord);
	}
}
