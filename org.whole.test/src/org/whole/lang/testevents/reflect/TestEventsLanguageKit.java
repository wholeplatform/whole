package org.whole.lang.testevents.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.testevents.model.impl.TestEventsImplEntityRegistry;
import org.whole.lang.testevents.model.impl.TestEventsStrictImplEntityRegistry;
import org.whole.lang.testevents.model.adapters.TestEventsAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class TestEventsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/TestEvents";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.testevents";
	}

	public String getName() {
		return "TestEvents";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return TestEventsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return TestEventsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new TestEventsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new TestEventsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new TestEventsAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return TestEventsTemplateManager.instance();
	}
}
