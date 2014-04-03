package org.whole.lang.changes.reflect;

import org.whole.lang.changes.factories.ChangesDefaultEntityRegistryConfiguration;
import org.whole.lang.changes.model.adapters.ChangesAdaptersEntityRegistry;
import org.whole.lang.changes.model.impl.ChangesImplEntityRegistry;
import org.whole.lang.changes.model.impl.ChangesStrictImplEntityRegistry;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator  Whole
 */
public class ChangesLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.changes:ChangesModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.changes";
    }

    public String getName() {
        return "Changes";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return ChangesEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return ChangesFeatureDescriptorEnum.instance;
    }

    @Override
    protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
		new ChangesDefaultEntityRegistryConfiguration().apply(er);
		return er;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new ChangesImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new ChangesStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new ChangesAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return ChangesTemplateManager.instance();
    }
}
