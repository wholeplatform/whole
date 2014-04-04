package org.whole.lang.reusables.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.reusables.model.impl.ReusablesImplEntityRegistry;
import org.whole.lang.reusables.model.impl.ReusablesStrictImplEntityRegistry;
import org.whole.lang.reusables.model.adapters.ReusablesAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator  Whole
 */
public class ReusablesLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.reusables:ReusablesModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.reusables";
    }

    public String getName() {
        return "Reusables";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return ReusablesEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return ReusablesFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new ReusablesImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new ReusablesStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new ReusablesAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return ReusablesTemplateManager.instance();
    }
}
