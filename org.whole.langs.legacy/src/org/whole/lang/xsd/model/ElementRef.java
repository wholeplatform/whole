package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ElementRef extends IXsdEntity, Reference, Particle {
	public QName getRef();

	public void setRef(QName ref);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
