package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface ScopePoint extends IPatternsEntity, VariationPoint {


    public Declarations getContext();

    public void setContext(Declarations context);

    public Template getTemplate();

    public void setTemplate(Template template);
}
