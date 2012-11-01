package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface AnnotationType extends IXsdEntity, NSContainer {
	public AnyURI getSource();

	public void setSource(AnyURI source);

	public AnnotationContents getContent();

	public void setContent(AnnotationContents content);
}
