package org.whole.lang.queries.model;

/** 
 * @generator Whole
 */
public interface Prune extends IQueriesEntity, PruneOrPredicate {
	public Predicate getPredicate();

	public void setPredicate(Predicate predicate);
}
