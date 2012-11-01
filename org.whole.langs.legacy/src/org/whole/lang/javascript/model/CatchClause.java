package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface CatchClause extends IJavaScriptEntity {
	public Expression getParam();

	public void setParam(Expression param);

	public Expression getGuard();

	public void setGuard(Expression guard);

	public Statements getBody();

	public void setBody(Statements body);
}
