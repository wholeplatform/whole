package org.whole.lang.testentities.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.testentities.model.impl.TestEntitiesImplEntityRegistry;
import org.whole.lang.testentities.model.impl.TestEntitiesStrictImplEntityRegistry;
import org.whole.lang.testentities.model.adapters.TestEntitiesAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class TestEntitiesLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/TestEntities";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.testentities";
	}

	public String getName() {
		return "TestEntities";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return TestEntitiesEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return TestEntitiesFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createImplEntityRegistry() {
		return new TestEntitiesImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new TestEntitiesStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new TestEntitiesAdaptersEntityRegistry();
	}

	public ITemplateManager getTemplateManager() {
		return TestEntitiesTemplateManager.instance();
	}
}
