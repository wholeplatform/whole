package org.whole.lang.grammars.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.grammars.factories.GrammarsDefaultEntityRegistryConfiguration;
import org.whole.lang.grammars.model.adapters.GrammarsAdaptersEntityRegistry;
import org.whole.lang.grammars.model.impl.GrammarsImplEntityRegistry;
import org.whole.lang.grammars.model.impl.GrammarsStrictImplEntityRegistry;
import org.whole.lang.grammars.parsers.GrammarsDataTypeParser;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class GrammarsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Grammars";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.grammars";
	}

	public String getName() {
		return "Grammars";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return GrammarsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return GrammarsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new GrammarsDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new GrammarsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new GrammarsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new GrammarsAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return GrammarsDataTypeParser.instance();
	}

	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return GrammarsDataTypeParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return GrammarsTemplateManager.instance();
	}
}
