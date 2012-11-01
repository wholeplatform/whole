package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface AttributeDecl extends IXsdEntity, NamedComponent, Annotated,
		SchemaComponent {
	public Name getName();

	public void setName(Name name);

	public QName getSimpleType();

	public void setSimpleType(QName simpleType);

	public StringData getDefaultValue();

	public void setDefaultValue(StringData defaultValue);

	public StringData getFixedValue();

	public void setFixedValue(StringData fixedValue);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public SimpleTypeDef getSimpleTypeDef();

	public void setSimpleTypeDef(SimpleTypeDef simpleTypeDef);
}
