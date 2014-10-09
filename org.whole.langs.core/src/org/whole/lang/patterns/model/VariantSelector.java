package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface VariantSelector extends IPatternsEntity, Declaration {


    public Name getVariability();

    public void setVariability(Name variability);

    public PathExpression getVariant();

    public void setVariant(PathExpression variant);
}
