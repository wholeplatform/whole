package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface CatchClause extends IJavaEntity {
	public SingleVariableDeclaration getException();

	public void setException(SingleVariableDeclaration exception);

	public Block getBody();

	public void setBody(Block body);
}
