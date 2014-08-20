package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface IterationPoint extends IPatternsEntity, VariationPoint {


    public PathExpression getIterator();

    public void setIterator(PathExpression iterator);

    public Template getTemplate();

    public void setTemplate(Template template);
}
