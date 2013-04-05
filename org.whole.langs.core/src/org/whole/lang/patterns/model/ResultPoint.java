package org.whole.lang.patterns.model;

/** 
 * @generator Whole
 */
public interface ResultPoint extends IPatternsEntity, VariationPoint {
	public Type getResultType();

	public void setResultType(Type resultType);

	public Template getTemplate();

	public void setTemplate(Template template);

	public PathExpression getWeaver();

	public void setWeaver(PathExpression weaver);
}
