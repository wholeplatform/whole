package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface ConditionPoint extends IPatternsEntity, VariationPoint {


    public Predicate getCondition();

    public void setCondition(Predicate condition);

    public Template getTemplate();

    public void setTemplate(Template template);
}
