package org.whole.lang.sql.model;

/** 
 * @generator Whole
 */
public interface Subquery extends ISQLEntity, InPredicate {
	public SelectSQLStatement getQuery();

	public void setQuery(SelectSQLStatement query);
}
