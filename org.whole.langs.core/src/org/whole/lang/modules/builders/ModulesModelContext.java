package org.whole.lang.modules.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.modules.reflect.ModulesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ModulesModelContext extends EntityContext {

    public ModulesModelContext(IEntity root) {
        super(root);
    }

    public ModulesModelContext getContent() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.content);
    }

    public void setContent(ModulesModelContext content) {
        wSet(ModulesFeatureDescriptorEnum.content, content);
    }

    public ModulesModelContext getResource() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.resource);
    }

    public void setResource(ModulesModelContext resource) {
        wSet(ModulesFeatureDescriptorEnum.resource, resource);
    }

    public ModulesModelContext getAdapter() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.adapter);
    }

    public void setAdapter(ModulesModelContext adapter) {
        wSet(ModulesFeatureDescriptorEnum.adapter, adapter);
    }

    public ModulesModelContext getOriginal() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.original);
    }

    public void setOriginal(ModulesModelContext original) {
        wSet(ModulesFeatureDescriptorEnum.original, original);
    }

    public ModulesModelContext getAdapted() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.adapted);
    }

    public void setAdapted(ModulesModelContext adapted) {
        wSet(ModulesFeatureDescriptorEnum.adapted, adapted);
    }

    public ModulesModelContext getVariant() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.variant);
    }

    public void setVariant(ModulesModelContext variant) {
        wSet(ModulesFeatureDescriptorEnum.variant, variant);
    }

    public ModulesModelContext getLocator() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.locator);
    }

    public void setLocator(ModulesModelContext locator) {
        wSet(ModulesFeatureDescriptorEnum.locator, locator);
    }

    public ModulesModelContext getPersistence() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.persistence);
    }

    public void setPersistence(ModulesModelContext persistence) {
        wSet(ModulesFeatureDescriptorEnum.persistence, persistence);
    }

    public ModulesModelContext getRegistry() {
        return (ModulesModelContext) wGet(ModulesFeatureDescriptorEnum.registry);
    }

    public void setRegistry(ModulesModelContext registry) {
        wSet(ModulesFeatureDescriptorEnum.registry, registry);
    }
}
