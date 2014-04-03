package org.whole.lang.changes.model;


/**
 *  @generator  Whole
 */
public interface Revision extends IChangesEntity {


    public Revisor getRevisor();

    public void setRevisor(Revisor revisor);

    public RevisionChanges getChanges();

    public void setChanges(RevisionChanges changes);
}
