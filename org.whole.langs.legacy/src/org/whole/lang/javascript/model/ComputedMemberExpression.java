package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ComputedMemberExpression extends IJavaScriptEntity,
		MemberExpression {
	public Expression getExpression();

	public void setExpression(Expression expression);
}
