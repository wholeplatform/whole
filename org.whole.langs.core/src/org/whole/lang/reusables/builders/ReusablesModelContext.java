package org.whole.lang.reusables.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.reflect.ReusablesFeatureDescriptorEnum;

/**
 *  @generator  Whole
 */
public class ReusablesModelContext extends EntityContext {

    public ReusablesModelContext(IEntity root) {
        super(root);
    }

    public ReusablesModelContext getOriginal() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.original);
    }

    public void setOriginal(ReusablesModelContext original) {
        wSet(ReusablesFeatureDescriptorEnum.original, original);
    }

    public ReusablesModelContext getAdapter() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.adapter);
    }

    public void setAdapter(ReusablesModelContext adapter) {
        wSet(ReusablesFeatureDescriptorEnum.adapter, adapter);
    }

    public ReusablesModelContext getAdapted() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.adapted);
    }

    public void setAdapted(ReusablesModelContext adapted) {
        wSet(ReusablesFeatureDescriptorEnum.adapted, adapted);
    }

    public ReusablesModelContext getAdaptedRevision() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.adaptedRevision);
    }

    public void setAdaptedRevision(ReusablesModelContext adaptedRevision) {
        wSet(ReusablesFeatureDescriptorEnum.adaptedRevision, adaptedRevision);
    }

    public ReusablesModelContext getSource() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.source);
    }

    public void setSource(ReusablesModelContext source) {
        wSet(ReusablesFeatureDescriptorEnum.source, source);
    }

    public ReusablesModelContext getVariant() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.variant);
    }

    public void setVariant(ReusablesModelContext variant) {
        wSet(ReusablesFeatureDescriptorEnum.variant, variant);
    }

    public ReusablesModelContext getVariantRevision() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.variantRevision);
    }

    public void setVariantRevision(ReusablesModelContext variantRevision) {
        wSet(ReusablesFeatureDescriptorEnum.variantRevision, variantRevision);
    }

    public ReusablesModelContext getLocator() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.locator);
    }

    public void setLocator(ReusablesModelContext locator) {
        wSet(ReusablesFeatureDescriptorEnum.locator, locator);
    }

    public ReusablesModelContext getPersistence() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.persistence);
    }

    public void setPersistence(ReusablesModelContext persistence) {
        wSet(ReusablesFeatureDescriptorEnum.persistence, persistence);
    }

    public ReusablesModelContext getUri() {
        return (ReusablesModelContext) wGet(ReusablesFeatureDescriptorEnum.uri);
    }

    public void setUri(ReusablesModelContext uri) {
        wSet(ReusablesFeatureDescriptorEnum.uri, uri);
    }
}
