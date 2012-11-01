package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface TryStatement extends IJavaEntity, Statement {
	public Block getBody();

	public void setBody(Block body);

	public CatchClauses getCatchClauses();

	public void setCatchClauses(CatchClauses catchClauses);

	public Block getFinally();

	public void setFinally(Block _finally);
}
