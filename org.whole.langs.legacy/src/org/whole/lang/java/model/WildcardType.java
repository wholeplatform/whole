package org.whole.lang.java.model;

/** 
 * @generator Whole
 */
public interface WildcardType extends IJavaEntity, Type {
	public Type getBound();

	public void setBound(Type bound);

	public UpperBound getUpperBound();

	public void setUpperBound(UpperBound upperBound);
}
