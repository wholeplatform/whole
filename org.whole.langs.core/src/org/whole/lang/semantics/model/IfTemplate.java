package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface IfTemplate extends ISemanticsEntity, Case, Template {
	public Predicate getCondition();

	public void setCondition(Predicate condition);
}
