package org.whole.lang.grammars.model;

/** 
 * @generator Whole
 */
public interface Terminal extends IGrammarsEntity, Rule {
	public Pattern getPattern();

	public void setPattern(Pattern pattern);

	public Category getCategory();

	public void setCategory(Category category);
}
