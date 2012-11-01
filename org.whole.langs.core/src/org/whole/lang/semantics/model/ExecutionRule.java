package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface ExecutionRule extends ISemanticsEntity, Rule {
	public Name getName();

	public void setName(Name name);

	public Predicate getCondition();

	public void setCondition(Predicate condition);

	public Expression getMeaning();

	public void setMeaning(Expression meaning);
}
