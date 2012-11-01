package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface ForTemplate extends ISemanticsEntity, Case, Template {
	public Expression getCondition();

	public void setCondition(Expression condition);
}
