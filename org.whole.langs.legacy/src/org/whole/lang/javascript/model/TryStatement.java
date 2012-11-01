package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface TryStatement extends IJavaScriptEntity, Statement {
	public Statements getTry();

	public void setTry(Statements _try);

	public CatchClauses getHandlers();

	public void setHandlers(CatchClauses handlers);

	public Statements getFinally();

	public void setFinally(Statements _finally);
}
