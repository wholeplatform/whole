package org.whole.lang.xsd.model;

/** 
 * @generator Whole
 */
public interface ElementDecl extends IXsdEntity, NamedComponent, Particle,
		SchemaComponent {
	public Name getName();

	public void setName(Name name);

	public Bounded getMinOccurs();

	public void setMinOccurs(Bounded minOccurs);

	public Occurrence getMaxOccurs();

	public void setMaxOccurs(Occurrence maxOccurs);

	public QName getType();

	public void setType(QName type);

	public BooleanData getAbstract();

	public void setAbstract(BooleanData _abstract);

	public BooleanData getNillable();

	public void setNillable(BooleanData nillable);

	public StringData getDefaultValue();

	public void setDefaultValue(StringData defaultValue);

	public StringData getFixedValue();

	public void setFixedValue(StringData fixedValue);

	public Qualify getForm();

	public void setForm(Qualify form);

	public DerivationSet getBlock();

	public void setBlock(DerivationSet block);

	public DerivationSet getFinal();

	public void setFinal(DerivationSet _final);

	public QName getSubstitutionGroup();

	public void setSubstitutionGroup(QName substitutionGroup);

	public Annotation getAnnotation();

	public void setAnnotation(Annotation annotation);

	public TypeDef getTypeDef();

	public void setTypeDef(TypeDef typeDef);

	public IdentityConstraintDefs getIdentityConstraintDefs();

	public void setIdentityConstraintDefs(
			IdentityConstraintDefs identityConstraintDefs);
}
