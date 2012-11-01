package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ComprehensionExpression extends IJavaScriptEntity, Expression {
	public Expression getExpression();

	public void setExpression(Expression expression);

	public ComprehensionBlocks getBlocks();

	public void setBlocks(ComprehensionBlocks blocks);

	public Expression getFilter();

	public void setFilter(Expression filter);
}
