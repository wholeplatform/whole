package org.whole.lang.json.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.json.model.impl.JSONImplEntityRegistry;
import org.whole.lang.json.model.impl.JSONStrictImplEntityRegistry;
import org.whole.lang.json.model.adapters.JSONAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator  Whole
 */
public class JSONLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.json:JSONModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.json";
    }

    public String getName() {
        return "JSON";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return JSONEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return JSONFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new JSONImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new JSONStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new JSONAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return JSONTemplateManager.instance();
    }
}
