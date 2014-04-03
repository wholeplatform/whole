package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Replace extends IChangesEntity, Change, ChangeSide {


    public Content getDeleteContent();

    public void setDeleteContent(Content deleteContent);

    public Content getInsertContent();

    public void setInsertContent(Content insertContent);
}
