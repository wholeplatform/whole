package org.whole.lang.xsd.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.DataTypeParsers;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.codebase.MappingStrategyRegistry;
import org.whole.lang.xsd.factories.XsdDefaultEntityRegistryConfiguration;
import org.whole.lang.xsd.model.adapters.XsdAdaptersEntityRegistry;
import org.whole.lang.xsd.model.impl.XsdImplEntityRegistry;
import org.whole.lang.xsd.model.impl.XsdStrictImplEntityRegistry;
import org.whole.lang.xsd.parsers.XsiDataTypeParser;

/** 
 * @generator Whole
 */
public class XsdLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://www.w3.org/2001/XMLSchema";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.xsd";
	}

	public String getName() {
		return "Xsd";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return XsdEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return XsdFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new XsdDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new XsdImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new XsdStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new XsdAdaptersEntityRegistry();
	}

	protected IDataTypeParser dataTypeParser = null;
	@Override
	public IDataTypeParser getDataTypeParser(DataTypeParsers kind) {
		if (dataTypeParser == null) {
			IMappingStrategy mappingStrategy = MappingStrategyRegistry.instance().getMappingStrategy(getURI());
			if (mappingStrategy == null)
				return super.getDataTypeParser(kind);
			dataTypeParser = new XsiDataTypeParser(mappingStrategy.getDataTypeParsers());
		}
		return dataTypeParser;
	}

	public ITemplateManager getTemplateManager() {
		return XsdTemplateManager.instance();
	}
}