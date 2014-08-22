package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface VariantSelectionPoint extends IPatternsEntity, VariationPoint {


    public Name getVariability();

    public void setVariability(Name variability);

    public Variants getVariants();

    public void setVariants(Variants variants);
}
