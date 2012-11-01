package org.whole.lang.semantics.model;

/** 
 * @generator Whole
 */
public interface Variable extends ISemanticsEntity, LocalIdentifier {
	public String getValue();

	public void setValue(String value);
}
