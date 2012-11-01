package org.whole.lang.scripts.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.scripts.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/** 
 * @generator Whole
 */
public class ScriptsEntityFactory extends GenericEntityFactory {
	public static final ScriptsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static ScriptsEntityFactory instance(IEntityRegistryProvider provider) {
		return new ScriptsEntityFactory(provider);
	}

	protected ScriptsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Script createScript() {
		return create(ScriptsEntityDescriptorEnum.Script);
	}

	public Script createScript(LanguageName languageName, Source source) {
		return create(ScriptsEntityDescriptorEnum.Script, languageName, source);
	}

	public IEntityBuilder<Script> buildScript() {
		return new EntityBuilder<Script>(
				create(ScriptsEntityDescriptorEnum.Script));
	}

	public LanguageName createLanguageName() {
		return create(ScriptsEntityDescriptorEnum.LanguageName);
	}

	public LanguageName createLanguageName(String value) {
		return create(ScriptsEntityDescriptorEnum.LanguageName, value);
	}
}
