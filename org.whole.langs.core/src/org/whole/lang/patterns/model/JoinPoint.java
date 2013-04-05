package org.whole.lang.patterns.model;

/** 
 * @generator Whole
 */
public interface JoinPoint extends IPatternsEntity, VariationPoint {
	public Name getName();

	public void setName(Name name);

	public Template getTemplate();

	public void setTemplate(Template template);
}
