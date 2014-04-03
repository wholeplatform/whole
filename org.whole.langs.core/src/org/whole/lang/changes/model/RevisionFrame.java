package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface RevisionFrame extends IChangesEntity {


    public Revisions getBaseRevisions();

    public void setBaseRevisions(Revisions baseRevisions);

    public Revisions getLeftRevisions();

    public void setLeftRevisions(Revisions leftRevisions);

    public Revisions getRightRevisions();

    public void setRightRevisions(Revisions rightRevisions);

    public Content getBaseContent();

    public void setBaseContent(Content baseContent);

    public Content getLeftContent();

    public void setLeftContent(Content leftContent);

    public Content getRightContent();

    public void setRightContent(Content rightContent);
}
