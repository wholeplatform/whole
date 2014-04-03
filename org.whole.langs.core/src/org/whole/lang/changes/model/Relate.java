package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Relate extends IChangesEntity, Change, ChangeSide {


    public Content getContent();

    public void setContent(Content content);
}
