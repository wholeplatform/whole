package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface BindingsScope extends ISemanticsEntity, Environment {
	public LocalIdentifier getIdentifier();

	public void setIdentifier(LocalIdentifier identifier);

	public LocalBindings getBindings();

	public void setBindings(LocalBindings bindings);

	public BindingsScope getNestedScope();

	public void setNestedScope(BindingsScope nestedScope);
}
