package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface Select extends IQueriesEntity, PathExpression {


    public PathExpression getSelectClause();

    public void setSelectClause(PathExpression selectClause);

    public PathExpressionOrPredicate getFromClause();

    public void setFromClause(PathExpressionOrPredicate fromClause);

    public PathExpression getWhereClause();

    public void setWhereClause(PathExpression whereClause);

    public NamesExpression getClearClause();

    public void setClearClause(NamesExpression clearClause);
}
