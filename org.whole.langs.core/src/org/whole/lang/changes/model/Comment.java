package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Comment extends IChangesEntity, Change, ChangeSide {


    public Text getComment();

    public void setComment(Text comment);

    public Content getContent();

    public void setContent(Content content);
}
