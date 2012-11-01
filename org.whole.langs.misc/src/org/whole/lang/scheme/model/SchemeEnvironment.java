package org.whole.lang.scheme.model;

/** 
 * @generator Whole
 */
public interface SchemeEnvironment extends ISchemeEntity {
	public org.whole.lang.bindings.IBindingManager getValue();

	public void setValue(org.whole.lang.bindings.IBindingManager value);
}
