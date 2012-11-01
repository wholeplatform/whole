package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface EnvironmentVariable extends ISemanticsEntity, Identifier {
	public LocalIdentifier getEnvironment();

	public void setEnvironment(LocalIdentifier environment);

	public LocalIdentifier getVariable();

	public void setVariable(LocalIdentifier variable);
}
