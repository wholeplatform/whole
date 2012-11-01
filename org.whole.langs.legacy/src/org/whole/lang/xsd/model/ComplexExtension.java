package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ComplexExtension extends IXsdEntity, ComplexDerivation {
	public QName getBase();

	public void setBase(QName base);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public DeclaredContent getContent();

	public void setContent(DeclaredContent content);
}
