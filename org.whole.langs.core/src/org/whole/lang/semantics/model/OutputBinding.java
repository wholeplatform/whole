package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface OutputBinding extends ISemanticsEntity {
	public BindingSubject getIdentifier();

	public void setIdentifier(BindingSubject identifier);

	public Expression getExpression();

	public void setExpression(Expression expression);
}
