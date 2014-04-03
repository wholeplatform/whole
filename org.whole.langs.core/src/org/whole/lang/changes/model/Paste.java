package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Paste extends IChangesEntity, Change, ChangeSide {


    public Content getContent();

    public void setContent(Content content);

    public Clipboard getClipboard();

    public void setClipboard(Clipboard clipboard);
}
