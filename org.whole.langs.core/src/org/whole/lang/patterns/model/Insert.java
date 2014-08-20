package org.whole.lang.patterns.model;


/**
 *  @generator  Whole
 */
public interface Insert extends IPatternsEntity, StepExpression {


    public Placement getPlacement();

    public void setPlacement(Placement placement);

    public PathExpression getPath();

    public void setPath(PathExpression path);
}
