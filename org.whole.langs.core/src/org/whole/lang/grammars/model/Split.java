package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Split extends IGrammarsEntity, Rule {
	public Splitter getSplitter();

	public void setSplitter(Splitter splitter);

	public Rule getRule();

	public void setRule(Rule rule);
}
