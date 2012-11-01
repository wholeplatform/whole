package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface WhereTemplate extends ISemanticsEntity, Case, Template {
	public InputBindings getWhere();

	public void setWhere(InputBindings where);
}
