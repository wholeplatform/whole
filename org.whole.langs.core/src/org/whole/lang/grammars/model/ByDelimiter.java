package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface ByDelimiter extends IGrammarsEntity, Splitter {
	public Pattern getDelimiter();

	public void setDelimiter(Pattern delimiter);
}
