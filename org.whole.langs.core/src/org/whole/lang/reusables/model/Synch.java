package org.whole.lang.reusables.model;


/**
 *  @generator  Whole
 */
public interface Synch extends IReusablesEntity, Reuse {


    public Reusable getVariant();

    public void setVariant(Reusable variant);

    public Revision getVariantRevision();

    public void setVariantRevision(Revision variantRevision);
}
