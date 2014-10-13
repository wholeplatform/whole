package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface VariableDeclarationFragment extends IJavaEntity,
		VariableDeclaration, LambdaParameters {
	public SimpleName getName();

	public void setName(SimpleName name);

	public ExtraDimensions getExtraDimensions();

	public void setExtraDimensions(ExtraDimensions extraDimensions);

	public Expression getInitializer();

	public void setInitializer(Expression initializer);
}
