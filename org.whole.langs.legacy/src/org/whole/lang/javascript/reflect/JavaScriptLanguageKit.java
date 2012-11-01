package org.whole.lang.javascript.reflect;

import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.javascript.model.impl.JavaScriptImplEntityRegistry;
import org.whole.lang.javascript.model.impl.JavaScriptStrictImplEntityRegistry;
import org.whole.lang.javascript.model.adapters.JavaScriptAdaptersEntityRegistry;
import org.whole.lang.javascript.parsers.JavaScriptDataTypePersistenceParser;
import org.whole.lang.javascript.parsers.JavaScriptDataTypePresentationParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class JavaScriptLanguageKit extends AbstractLanguageKit {
	public static final String URI = "whole:org.whole.lang.javascript:JavaScript";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.javascript";
	}

	public String getName() {
		return "JavaScript";
	}

	public String getVersion() {
		return "180";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return JavaScriptEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return JavaScriptFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new JavaScriptImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new JavaScriptStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new JavaScriptAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return JavaScriptDataTypePersistenceParser.instance();
	}
	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return JavaScriptDataTypePresentationParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return JavaScriptTemplateManager.instance();
	}
}
