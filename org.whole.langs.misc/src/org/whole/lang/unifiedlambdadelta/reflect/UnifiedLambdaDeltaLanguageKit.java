package org.whole.lang.unifiedlambdadelta.reflect;

import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.unifiedlambdadelta.model.impl.UnifiedLambdaDeltaImplEntityRegistry;
import org.whole.lang.unifiedlambdadelta.model.impl.UnifiedLambdaDeltaStrictImplEntityRegistry;
import org.whole.lang.unifiedlambdadelta.model.adapters.UnifiedLambdaDeltaAdaptersEntityRegistry;
import org.whole.lang.unifiedlambdadelta.parsers.UnifiedLambdaDeltaDataTypeParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/UnifiedLambdaDelta";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.unifiedlambdadelta";
	}

	public String getName() {
		return "UnifiedLambdaDelta";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return UnifiedLambdaDeltaEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return UnifiedLambdaDeltaFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new UnifiedLambdaDeltaImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new UnifiedLambdaDeltaStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new UnifiedLambdaDeltaAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return UnifiedLambdaDeltaDataTypeParser.instance();
	}

	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return UnifiedLambdaDeltaDataTypeParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return UnifiedLambdaDeltaTemplateManager.instance();
	}
}
