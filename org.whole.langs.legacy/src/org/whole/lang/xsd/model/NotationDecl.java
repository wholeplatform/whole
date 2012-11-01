package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface NotationDecl extends IXsdEntity, NamedComponent, Annotated,
		SchemaComponent {
	public StringData getPublic();

	public void setPublic(StringData _public);

	public AnyURI getSystem();

	public void setSystem(AnyURI system);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);
}
