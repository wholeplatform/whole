package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Empty extends IGrammarsEntity, EpsilonRule {
	public Literal getLiteral();

	public void setLiteral(Literal literal);
}
