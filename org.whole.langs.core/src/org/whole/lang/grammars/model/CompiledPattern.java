package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface CompiledPattern extends IGrammarsEntity, Pattern {
	public java.util.regex.Pattern getValue();

	public void setValue(java.util.regex.Pattern value);
}
