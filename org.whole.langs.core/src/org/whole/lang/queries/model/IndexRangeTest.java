package org.whole.lang.queries.model;


/**
 *  @generator  Whole
 */
public interface IndexRangeTest extends IQueriesEntity, Predicate {


    public IntLiteral getStartIndex();

    public void setStartIndex(IntLiteral startIndex);

    public IntLiteral getEndIndex();

    public void setEndIndex(IntLiteral endIndex);
}
