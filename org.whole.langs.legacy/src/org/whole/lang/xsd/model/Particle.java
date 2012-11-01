package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Particle extends IXsdEntity, NSContainer, Annotated {
	public Bounded getMinOccurs();

	public void setMinOccurs(Bounded minOccurs);

	public Occurrence getMaxOccurs();

	public void setMaxOccurs(Occurrence maxOccurs);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
