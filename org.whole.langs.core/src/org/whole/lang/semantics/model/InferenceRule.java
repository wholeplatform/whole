package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface InferenceRule extends ISemanticsEntity, Premise {
	public RuleName getName();

	public void setName(RuleName name);

	public Premises getPremises();

	public void setPremises(Premises premises);

	public Transition getConclusion();

	public void setConclusion(Transition conclusion);

	public Predicate getCondition();

	public void setCondition(Predicate condition);
}
