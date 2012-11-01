package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface MethodDeclaration extends IJavaEntity,
		AnnotatedBodyDeclaration {
	public TypeParameters getTypeParameters();

	public void setTypeParameters(TypeParameters typeParameters);

	public Type getReturnType();

	public void setReturnType(Type returnType);

	public SimpleName getName();

	public void setName(SimpleName name);

	public Parameters getParameters();

	public void setParameters(Parameters parameters);

	public ExtraDimensions getExtraDimensions();

	public void setExtraDimensions(ExtraDimensions extraDimensions);

	public Names getThrownExceptions();

	public void setThrownExceptions(Names thrownExceptions);

	public Block getBody();

	public void setBody(Block body);
}
