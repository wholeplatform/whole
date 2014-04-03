package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Wrap extends IChangesEntity, Change, ChangeSide {


    public Content getCutContent();

    public void setCutContent(Content cutContent);

    public Content getInsertContent();

    public void setInsertContent(Content insertContent);

    public Clipboard getClipboard();

    public void setClipboard(Clipboard clipboard);
}
