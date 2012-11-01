package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Repeat extends IGrammarsEntity, Rule {
	public Size getLowerBound();

	public void setLowerBound(Size lowerBound);

	public Bound getUpperBound();

	public void setUpperBound(Bound upperBound);

	public Rule getSeparator();

	public void setSeparator(Rule separator);

	public Rule getRule();

	public void setRule(Rule rule);
}
