package org.whole.lang.actions.model;

/** 
 * @generator Whole
 */
public interface GuardedAction extends IActionsEntity, SimpleAction {
	public Predicate getEnablerPredicate();

	public void setEnablerPredicate(Predicate enablerPredicate);
}
