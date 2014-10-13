package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface SingleVariableDeclaration extends IJavaEntity,
		VariableDeclaration {
	public ExtendedModifiers getModifiers();

	public void setModifiers(ExtendedModifiers modifiers);

	public Type getType();

	public void setType(Type type);

	public Varargs getVarargs();

	public void setVarargs(Varargs varargs);

	public SimpleName getName();

	public void setName(SimpleName name);

	public ExtraDimensions getExtraDimensions();

	public void setExtraDimensions(ExtraDimensions extraDimensions);

	public Expression getInitializer();

	public void setInitializer(Expression initializer);

	public Annotations getVarargsAnnotations();

	public void setVarargsAnnotations(Annotations varargsAnnotations);
}
