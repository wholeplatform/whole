package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface AbstractVariable extends ISemanticsEntity, ConfigurationItem,
		Predicate {
	public Variable getVariable();

	public void setVariable(Variable variable);

	public Num getIndex();

	public void setIndex(Num index);

	public Num getTime();

	public void setTime(Num time);
}
