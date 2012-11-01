package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Documentation extends IXsdEntity, AnnotationType {
	public XMLLanguageType getLanguage();

	public void setLanguage(XMLLanguageType language);

	public AnnotationContents getContent();

	public void setContent(AnnotationContents content);
}
