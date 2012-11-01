package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Production extends IGrammarsEntity, Rule {
	public NonTerminal getName();

	public void setName(NonTerminal name);

	public Rule getRule();

	public void setRule(Rule rule);

	public Template getTemplate();

	public void setTemplate(Template template);
}
