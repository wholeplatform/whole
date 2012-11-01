package org.whole.examples.lang.imp.model;

/** 
 * @generator Whole
 */
public interface SaveStatement extends IImpEntity, Statement {
	public Expression getExp();

	public void setExp(Expression exp);

	public Expression getFileName();

	public void setFileName(Expression fileName);
}
