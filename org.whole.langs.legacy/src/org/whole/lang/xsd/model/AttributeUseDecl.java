package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface AttributeUseDecl extends IXsdEntity, AttributeDecl,
		AttributeUse {
	public Name getName();

	public void setName(Name name);

	public QName getSimpleType();

	public void setSimpleType(QName simpleType);

	public Use getUse();

	public void setUse(Use use);

	public Qualify getForm();

	public void setForm(Qualify form);

	public StringData getDefaultValue();

	public void setDefaultValue(StringData defaultValue);

	public StringData getFixedValue();

	public void setFixedValue(StringData fixedValue);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public SimpleTypeDef getSimpleTypeDef();

	public void setSimpleTypeDef(SimpleTypeDef simpleTypeDef);
}
