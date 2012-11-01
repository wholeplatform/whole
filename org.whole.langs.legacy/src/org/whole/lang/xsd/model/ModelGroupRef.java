package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ModelGroupRef extends IXsdEntity, Reference, ModelGroup {
	public QName getRef();

	public void setRef(QName ref);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
