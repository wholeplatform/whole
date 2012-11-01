package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface When extends IGrammarsEntity, Rule {
	public Predicate getPredicate();

	public void setPredicate(Predicate predicate);

	public Rule getRule();

	public void setRule(Rule rule);
}
