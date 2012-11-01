package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Any extends IXsdEntity, Particle, Wildcard {
	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
