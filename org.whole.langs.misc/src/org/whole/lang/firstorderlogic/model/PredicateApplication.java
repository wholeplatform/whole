package org.whole.lang.firstorderlogic.model;

/** 
 * @generator Whole
 */
public interface PredicateApplication extends IFirstOrderLogicEntity, Formula {
	public Predicate getPredicate();

	public void setPredicate(Predicate predicate);

	public Arguments getArguments();

	public void setArguments(Arguments arguments);
}
