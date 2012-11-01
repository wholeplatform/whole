package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface Keyref extends IXsdEntity, IdentityConstraintDef {
	public QName getRefer();

	public void setRefer(QName refer);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public Selector getSelector();

	public void setSelector(Selector selector);

	public Fields getFields();

	public void setFields(Fields fields);
}
