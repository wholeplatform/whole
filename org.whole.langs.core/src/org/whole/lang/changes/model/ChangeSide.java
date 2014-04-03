package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface ChangeSide extends IChangesEntity {


    public ChangeRevisions getRevisions();

    public void setRevisions(ChangeRevisions revisions);
}
