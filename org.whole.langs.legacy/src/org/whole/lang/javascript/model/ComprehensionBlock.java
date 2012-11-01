package org.whole.lang.javascript.model;

/** 
 * @generator Whole
 */
public interface ComprehensionBlock extends IJavaScriptEntity, Statement {
	public Expression getIterator();

	public void setIterator(Expression iterator);

	public Expression getIterated();

	public void setIterated(Expression iterated);
}
