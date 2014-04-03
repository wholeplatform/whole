package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Insert extends IChangesEntity, Change, ChangeSide {


    public Content getContent();

    public void setContent(Content content);
}
