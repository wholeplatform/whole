package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface PointwiseEquals extends IQueriesEntity, Expression {


    public PathExpression getPexp1();

    public void setPexp1(PathExpression pexp1);

    public PathExpression getPexp2();

    public void setPexp2(PathExpression pexp2);
}
