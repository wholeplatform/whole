package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface SideBySideCompare extends IChangesEntity, ContentCompare {


    public Content getBaseContent();

    public void setBaseContent(Content baseContent);

    public Content getFirstRevisedContent();

    public void setFirstRevisedContent(Content firstRevisedContent);

    public Content getSecondRevisedContent();

    public void setSecondRevisedContent(Content secondRevisedContent);
}
