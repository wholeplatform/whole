package org.whole.lang.modules.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.modules.model.impl.ModulesImplEntityRegistry;
import org.whole.lang.modules.model.impl.ModulesStrictImplEntityRegistry;
import org.whole.lang.modules.model.adapters.ModulesAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator  Whole
 */
public class ModulesLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.modules:ModulesModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.modules";
    }

    public String getName() {
        return "Modules";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return ModulesEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return ModulesFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new ModulesImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new ModulesStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new ModulesAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return ModulesTemplateManager.instance();
    }
}
