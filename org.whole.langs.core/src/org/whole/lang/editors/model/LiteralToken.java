package org.whole.lang.editors.model;

/** 
 * @generator Whole
 */
public interface LiteralToken extends IEditorsEntity, RowElement {
	public String getValue();

	public void setValue(String value);
}
