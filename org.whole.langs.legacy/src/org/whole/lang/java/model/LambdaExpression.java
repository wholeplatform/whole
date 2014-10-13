package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface LambdaExpression extends IJavaEntity, Expression {
	public LambdaParameters getParameters();

	public void setParameters(LambdaParameters parameters);

	public ExpressionOrStatement getBody();

	public void setBody(ExpressionOrStatement body);
}
