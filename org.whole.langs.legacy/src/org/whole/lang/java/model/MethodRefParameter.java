package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface MethodRefParameter extends IJavaEntity {
	public Type getType();

	public void setType(Type type);

	public Varargs getVarargs();

	public void setVarargs(Varargs varargs);

	public SimpleName getName();

	public void setName(SimpleName name);
}
