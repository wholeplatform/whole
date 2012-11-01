package org.whole.lang.scripts.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scripts.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class ScriptsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Script_ord = 0;
	public static final int LanguageName_ord = 1;
	public static final int Source_ord = 2;
	public static final ScriptsEntityDescriptorEnum instance = new ScriptsEntityDescriptorEnum();
	public static final EntityDescriptor<Script> Script = (EntityDescriptor<Script>) instance
			.valueOf(Script_ord);
	public static final EntityDescriptor<LanguageName> LanguageName = (EntityDescriptor<LanguageName>) instance
			.valueOf(LanguageName_ord);
	public static final EntityDescriptor<Source> Source = (EntityDescriptor<Source>) instance
			.valueOf(Source_ord);

	private ScriptsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Script_ord, "Script", Script.class, false).withFeature(
				ScriptsFeatureDescriptorEnum.languageName, LanguageName_ord)
				.withFeature(ScriptsFeatureDescriptorEnum.source, Source_ord);
		putDataEntity(LanguageName_ord, "LanguageName", LanguageName.class,
				false, String.class);
		putSimpleEntity(Source_ord, "Source", Source.class, true);
	}
}
