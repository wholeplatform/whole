package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface RevisionTrack extends IChangesEntity {


    public Revisions getRevisions();

    public void setRevisions(Revisions revisions);

    public ContentCompare getCompare();

    public void setCompare(ContentCompare compare);
}
