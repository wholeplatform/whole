package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface LocalBinding extends ISemanticsEntity {
	public BindingOp getOp();

	public void setOp(BindingOp op);

	public LocalIdentifier getIdentifier();

	public void setIdentifier(LocalIdentifier identifier);

	public Expression getExpression();

	public void setExpression(Expression expression);
}
