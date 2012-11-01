package org.whole.lang.semantics.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.semantics.factories.SemanticsDefaultEntityRegistryConfiguration;
import org.whole.lang.semantics.model.adapters.SemanticsAdaptersEntityRegistry;
import org.whole.lang.semantics.model.impl.SemanticsImplEntityRegistry;
import org.whole.lang.semantics.model.impl.SemanticsStrictImplEntityRegistry;
import org.whole.lang.semantics.parsers.SemanticsDataTypePersistenceParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class SemanticsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Semantics";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.semantics";
	}

	public String getName() {
		return "Semantics";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return SemanticsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return SemanticsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new SemanticsDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new SemanticsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new SemanticsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new SemanticsAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return SemanticsDataTypePersistenceParser.instance();
	}
	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return SemanticsDataTypePersistenceParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return SemanticsTemplateManager.instance();
	}
}
